grammar Pmm;	

@header{
    import ast.*;
    import ast.definitions.*;
    import ast.expressions.*;
    import ast.statements.*;
    import ast.types.*;
}

program returns [Program ast]:
        definition* EOF;

// e = !e Poner nombre -> e1=e = ! e2=e
// OP='+' -> Nombre de los terminales en mayúsculas
// Todas las regalas modifican ast -> { $ast = new ... } { $ast.add() }
// No terminales -> $nt1.ast    // $e1.ast.getLine() .get...()
// Terminales -> $ID.getLine() .getCharPositionInLine() .text()
// Declarar variables -> Returns [...] LOCALS [ List<String> temp = new ... ]
// (nt { list.add(...) })+

expression returns [Expression ast]:
            INT_CONSTANT { $ast = new IntLiteral($INT_CONSTANT.getLine(), $INT_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToInt($INT_CONSTANT.text)); }
            | REAL_CONSTANT { $ast = new RealLiteral($REAL_CONSTANT.getLine(), $REAL_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToReal($REAL_CONSTANT.text)); }
            | CHAR_CONSTANT { $ast = new CharLiteral($CHAR_CONSTANT.getLine(), $CHAR_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToChar($CHAR_CONSTANT.text)); }
            | ID { $ast = new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text); }
            | function { $ast = $function.ast }
            | '(' expression ')'
            | expression '[' expression ']'
            | expression'.'ID
            | '('type')' e1=expression { $ast = new Cast($e1.ast.getLine(), $e1.ast.getCharPositionLine(), $e1.ast, $type.ast) }
            | '-' e1=expression { $ast = new UnaryMinus($e1.ast.getLine(), $e1.ast.getCharPositionLine(), $e1.ast) }
            | '!' e1=expression { $ast = new UnaryNot($e1.ast.getLine(), $e1.ast.getCharPositionLine(), $e1.ast) }
            | expression ('*'|'/'|'%') expression
            | expression ('+'|'-') expression
            | expression ('>'|'>='|'<'|'<='|'=='|'!=') expression
            | expression ('&&'|'||') expression;

expressions returns [List<Expression> ast = new ArrayList<Expression>()]:
            expression { $ast = $expression.ast }
             | e1=expression{ $ast.add($e1.ast) }','e2=expressions{ $ast.addAll($e2.ast) };

statement: 'print' expressions ';'
            | 'input' expressions ';'
            | expression '=' expression ';'
            | 'if' expression ':' loop_body ('else' ':' loop_body)?
            | 'while' expression ':' loop_body
            | 'return' expression ';'
            | function ';';

loop_body: '{' statement* '}'
            | statement;

function returns [Expression ast] locals [ List<Expression> list = new ArrayList<Expression>() ]:
        ID '(' (expressions{ list.add($expressions.ast) })? ')' { $ast = new FuncCall($ID.getLine(), $ID.getCharPositionInLine()+1),
         list.ast, new Variable($ID.text, $definition.ast) };

definition returns [Definition ast]:
            func_definition
            | var_definition ';';

func_definition: 'def' ID '(' parameters? ')' ':' type? '{' (var_definition';')* statement* '}';

parameters: var_definition (','var_definition)*;

var_definition: variables ':' type;

variables : ID
            | ID ',' variables;

type returns [Type ast]:
    'int' { $ast = new IntType() }
      | 'double' { $ast = new DoubleType() }
      | 'char' { $ast = new CharType() }
      | '[' INT_CONSTANT ']' type { $ast = new ArrayType($INT_CONSTANT.getLine(), $INT_CONSTANT.getCharPositionInLine()+1,
                                    LexerHelper.lexemeToInt($INT_CONSTANT.text), $type.ast ) }
      | 'struct' '{' struct_field* '}'
      | 'void' { $ast = new VoidType() };

struct_field: ID ':' type ';';




/* LEXER PATTERNS */
TRASH: ([ \n\r\t] | COMMENT) -> skip;

fragment
LETRA: [a-zA-Z];
fragment
NUMERO: [0-9];
fragment
REAL_BODY: INT_CONSTANT?'.'INT_CONSTANT
            | INT_CONSTANT'.'INT_CONSTANT?
            | INT_CONSTANT;


COMMENT: ('#'.*?('\n'|EOF))|'"""'.*?'"""';
ID: (LETRA|'_')(LETRA|NUMERO|'_')*;
INT_CONSTANT: '0'|[1-9]NUMERO*;
REAL_CONSTANT: REAL_BODY([eE][-+]?INT_CONSTANT)?;
CHAR_CONSTANT: '\''(.|'\\'(NUMERO*|'n'|'t'))'\'';