grammar Pmm;	

program: 
       ;





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