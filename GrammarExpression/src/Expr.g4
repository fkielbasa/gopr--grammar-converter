grammar Expr;

program : expression EOF;

expression : label '^' '(' subexpression ')' ;

subexpression : label ('V' label)*;

label : BEGIN_LABEL INT | LETTER INT;

BEGIN_LABEL : ('E' | 'd');
INT : [0-9]+ ;
LETTER : [a-zA-Z] ;
WS : [ \t\n\r]+ -> skip ;
