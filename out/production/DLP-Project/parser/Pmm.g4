grammar Pmm;	

program: 
       ;





/* LEXER PATTERNS */
TRASH: ([ \n\r\t] | COMMENT) -> skip;

fragment
LETRA: [a-zA-Z];
fragment
NUMERO: [0-9];


COMMENT: ('#'.*?'\n')|'"""'.*?'"""';
IDENT: (LETRA|'_')(LETRA|NUMERO|'_')*;
INT_CONSTANT: '0'|[1-9]NUMERO*;
REAL_CONSTANT: NUMERO;
