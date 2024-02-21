grammar Pmm;	

program: definition* EOF
       ;

expression: INT_CONSTANT
            | REAL_CONSTANT
            | CHAR_CONSTANT
            | ID
            | function
            | '(' expression ')'
            | expression '[' expression ']'
            | expression'.'ID
            | '('type')' expression
            | '-' expression
            | '!' expression
            | expression ('*'|'/'|'%') expression
            | expression ('+'|'-') expression
            | expression ('>'|'>='|'<'|'<='|'=='|'!=') expression
            | expression ('&&'|'||') expression;

expressions: expression
             | expression','expressions;

statement: 'print' expressions ';'
            | 'input' expressions ';'
            | expression '=' expression ';'
            | 'if' expression ':' loop_body ('else' ':' loop_body)?
            | 'while' expression ':' loop_body
            | 'return' expression ';'
            | function ';';

loop_body: '{' statement* '}'
            | statement;

function: ID '(' expressions? ')' ;

definition: func_definition
            | var_definition ';';

func_definition: 'def' ID '(' parameters? ')' ':' type? '{' (var_definition';')* statement* '}';

parameters: var_definition (','var_definition)*;

var_definition: variables ':' type;

variables : ID
            | ID ',' variables;

type: 'int'
      | 'double'
      | 'char'
      | '[' INT_CONSTANT ']' type
      | 'struct' '{' struct_field* '}';

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