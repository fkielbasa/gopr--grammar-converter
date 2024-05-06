grammar Expr;

program : (expression WS?)* EOF;

expression : label '^' '(' subexpression ')' | label;

subexpression : WS? expression (WS? 'V' WS? expression)* WS?;

label : BEGIN_LABEL INT | LETTER INT | '(' subexpression ')';

BEGIN_LABEL : ('E' | 'd');
INT : [0-9]+ ;
LETTER : [a-zA-Z] ;
WS : [ \t\n\r]+ -> skip ;
