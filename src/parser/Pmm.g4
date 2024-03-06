grammar Pmm;	

@header{
    import ast.*;
    import ast.definitions.*;
    import ast.expressions.*;
    import ast.statements.*;
    import ast.types.*;
}

program returns [Program ast]
        locals [
            List<Definition> definitions = new ArrayList<Definition>()
        ]:
        (var_definition';'{ $definitions.addAll($var_definition.ast); }|func_definition{ $definitions.add($func_definition.ast); })*
        main { $definitions.add($main.ast); } EOF
        {
            $ast = new Program(0, 0, $definitions);
        };

main returns [Definition ast]
        locals [List<VarDefinition> definitions = new ArrayList<VarDefinition>(),
                List<Statement> statements = new ArrayList<Statement>()]:
        'def' e='main' '(' ')' ':' '{' (var_definition';'{ $definitions.addAll($var_definition.ast); })* (statement { $statements.addAll($statement.ast); })* '}'
        {
            FunctionType ft = new FunctionType($e.getLine(), $e.getCharPositionInLine()+1, new VoidType(0,0), $definitions);
            $ast = new FuncDefinition($e.getLine(), $e.getCharPositionInLine()+1, ft, "main", $definitions, $statements);
        };

expression returns [Expression ast]:
            INT_CONSTANT { $ast = new IntLiteral($INT_CONSTANT.getLine(), $INT_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToInt($INT_CONSTANT.text)); }
            | REAL_CONSTANT { $ast = new RealLiteral($REAL_CONSTANT.getLine(), $REAL_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToReal($REAL_CONSTANT.text)); }
            | CHAR_CONSTANT { $ast = new CharLiteral($CHAR_CONSTANT.getLine(), $CHAR_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToChar($CHAR_CONSTANT.text)); }
            | ID { $ast = new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text); }
            | functionExpression { $ast = $functionExpression.ast; }
            | '(' e1=expression ')' { $ast = $e1.ast; }
            | e1=expression '[' e2=expression ']' { $ast = new ArrayAccess($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast); }
            | e1=expression'.'ID { $ast = new StructAccess($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $ID.text); }
            | '('type')' e1=expression { $ast = new Cast($type.ast.getLine(), $type.ast.getColumn(), $e1.ast, $type.ast); }
            | '-' e1=expression { $ast = new UnaryMinus($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast); }
            | '!' e1=expression { $ast = new UnaryNot($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast); }
            | e1=expression OP=('*'|'/'|'%') e2=expression { new Arithmetic($OP.getLine(), $OP.getCharPositionInLine()+1, $e1.ast, $e2.ast, $OP.text); }
            | e1=expression OP=('+'|'-') e2=expression { new Arithmetic($OP.getLine(), $OP.getCharPositionInLine()+1, $e1.ast, $e2.ast, $OP.text); }
            | e1=expression OP=('>'|'>='|'<'|'<='|'=='|'!=') e2=expression { new Comparison($OP.getLine(), $OP.getCharPositionInLine()+1, $e1.ast, $e2.ast, $OP.text); }
            | e1=expression OP=('&&'|'||') e2=expression { new Logic($OP.getLine(), $OP.getCharPositionInLine()+1, $e1.ast, $e2.ast, $OP.text); };

expressions returns [List<Expression> ast = new ArrayList<Expression>()]:
            expression { $ast.add($expression.ast); }
             | e1=expression{ $ast.add($e1.ast); }','e2=expressions{ $ast.addAll($e2.ast); };

statement returns [List<Statement> ast = new ArrayList<Statement>()]
            locals [ List<Statement> elseList = new ArrayList<Statement>() ]:
            e='print' expressions ';' {
                for (Expression expression: $expressions.ast) {
                    $ast.add(new Print($e.getLine(), $e.getCharPositionInLine()+1, expression));
                }
            }
            | e='input' expressions ';' {
                for (Expression expression: $expressions.ast) {
                    $ast.add(new Input($e.getLine(), $e.getCharPositionInLine()+1, expression));
                }
            }
            | e1=expression OP='=' e2=expression ';' { $ast.add( new Assignment($OP.getLine(), $OP.getCharPositionInLine()+1, $e1.ast, $e2.ast)); }
            | e='if' expression ':' b1=loop_body ('else' ':' b2=loop_body{ $elseList = $b2.ast; })? {
                $ast.add( new IfElse($e.getLine(), $e.getCharPositionInLine()+1, $expression.ast, $b1.ast, $elseList) );
            }
            | e='while' expression ':' loop_body {
                $ast.add( new While($e.getLine(), $e.getCharPositionInLine()+1, $expression.ast, $loop_body.ast) );
            }
            | e='return' expression ';' { $ast.add(new Return($e.getLine(), $e.getCharPositionInLine()+1, $expression.ast)); }
            | functionStatement ';' { $ast.add($functionStatement.ast); };

loop_body returns [ List<Statement> ast = new ArrayList<Statement>() ]:
            '{' (statement{ $ast.addAll($statement.ast); })* '}'
            | statement { $ast.addAll($statement.ast); };

functionStatement returns [Statement ast] locals [ List<Expression> list = new ArrayList<Expression>() ]:
        ID '(' (expressions{ $list.addAll($expressions.ast); })? ')' { $ast = new FuncInvocation($ID.getLine(), $ID.getCharPositionInLine()+1,
         $list, new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text)); };

functionExpression returns [Expression ast] locals [ List<Expression> list = new ArrayList<Expression>() ]:
        ID '(' (expressions{ $list.addAll($expressions.ast); })? ')' { $ast = new FuncInvocation($ID.getLine(), $ID.getCharPositionInLine()+1,
        $list, new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text)); };

func_definition returns [ Definition ast ]
                locals [
                List<VarDefinition> params = new ArrayList<VarDefinition>(),
                Type return = new VoidType(0,0),
                List<VarDefinition> varDefinitions = new ArrayList<VarDefinition>(),
                List<Statement> statements = new ArrayList<Statement>()]:
            'def' ID '(' (parameters{ $params.addAll($parameters.ast); })? ')' ':' (type{ $return = $type.ast; })? '{'
            (var_definition';'{ $varDefinitions.addAll($var_definition.ast); })* (statement{ $statements.addAll($statement.ast); })* '}'
            {
                FunctionType ft = new FunctionType($ID.getLine(), $ID.getCharPositionInLine()+1, $return, $params);
                $ast = new FuncDefinition($ID.getLine(), $ID.getCharPositionInLine()+1, ft, $ID.text, $varDefinitions, $statements);
            };

parameters returns [ List<VarDefinition> ast = new ArrayList<VarDefinition>() ]:
            vd1=var_definition { $ast.addAll($vd1.ast); } (','vd2=var_definition { $ast.addAll($vd2.ast); } )*;

var_definition returns [ List<VarDefinition> ast = new ArrayList<VarDefinition>() ]:
            variables ':' type {

                for (Variable v: $variables.ast) {

                    VarDefinition vd = new VarDefinition(v.getLine(), v.getColumn(), $type.ast, v.getName());
                    if (!$ast.contains(vd)) { $ast.add(vd); }
                    else { new ErrorType(v.getLine(), v.getColumn(), "La variable " + v.getName() + " ya se ha declarado."); }
                }
            };

variables returns [ List<Variable> ast = new ArrayList<Variable>() ] :
            ID { $ast.add( new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text) ); }
            (',' ID { $ast.add(new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text)); })*;

type returns [Type ast]:
    'int' { $ast = new IntType(0,0); }
      | 'double' { $ast = new DoubleType(0,0); }
      | 'char' { $ast = new CharType(0,0); }
      | '[' INT_CONSTANT ']' type { $ast = new ArrayType($INT_CONSTANT.getLine(), $INT_CONSTANT.getCharPositionInLine()+1,
                                    LexerHelper.lexemeToInt($INT_CONSTANT.text), $type.ast ); }
      | e='struct' '{' (struct_field{ $ast = new StructType($e.getLine(), $e.getCharPositionInLine()+1, $struct_field.ast); })* '}'
      | 'void' { $ast = new VoidType(0,0); };

struct_field returns [ List<RecordField> ast = new ArrayList<RecordField>() ]:
        (variables ':' type ';' {

            for (Variable v: $variables.ast) {

                RecordField rf = new RecordField(v.getLine(), v.getColumn(), v.getName(), $type.ast);
                if (!$ast.contains(rf)) { $ast.add(rf); }
                else { new ErrorType(v.getLine(), v.getColumn(), "El campo " + v.getName() + " ya se ha declarado."); }
            }
        })+;




/* LEXER PATTERNS */
TRASH: ([ \n\r\t] | COMMENT) -> skip;

fragment
LETRA: [a-zA-Z];
fragment
NUMERO: [0-9];
fragment
REAL_BODY: INT_CONSTANT?'.'INT_CONSTANT*
            | INT_CONSTANT'.'INT_CONSTANT?
            | INT_CONSTANT;


COMMENT: ('#'.*?('\n'|EOF))|'"""'.*?'"""';
ID: (LETRA|'_')(LETRA|NUMERO|'_')*;
INT_CONSTANT: '0'|[1-9]NUMERO*;
REAL_CONSTANT: REAL_BODY([eE][-+]?INT_CONSTANT)?;
CHAR_CONSTANT: '\''(.|'\\'(NUMERO*|'n'|'t'))'\'';