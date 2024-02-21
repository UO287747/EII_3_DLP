grammar Pmm;	

program: expression EOF
       ;

expression: INT_CONSTANT
            | REAL_CONSTANT
            | CHAR_CONSTANT
            | ID
            | '(' expression ')'
            | '[' expression ']'
            | expression'.'ID
            | '('tipo')' expression
            | '-' expression
            | '!' expression
            | expression ('*'|'/'|'%')
            | expression ('+'|'-') expression
            | expression ('>'|'>='|'<'|'<='|'==') expression
            | expression ('&&'|'||') expression;

expressions: expression
             | expression','expressions;

statement: 'print'  expressions
            | 'input' expressions
            | expression '=' expression
            | 'if' expression ':' ('{' statements '}'|statement) ('else' ':' ('{' statements '}'|statement))?
            | 'while' expression ':' ('{' statements '}'|statement)
            | 'return' expression
            | ;

statements: statement ';'
            | statement ';' statements;


var_definition: variables ':' tipo ';';

variables : ID
            | ID ',' variables;

tipo: 'int' | 'double' | 'char';




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