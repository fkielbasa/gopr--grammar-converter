grammar Expr;

program : (expression WS?)* EOF;

expression : label '(' subexpression (WS? 'V' WS? subexpression)* ')';

subexpression : WS? label WS?;

label : BEGIN_LABEL INT | LETTER INT | '(' label (WS? 'V' WS? label)* ')';

BEGIN_LABEL : ('E' | 'd') WS;
INT : [0-9]+ ;
LETTER : [a-zA-Z] ;
WS : [ \t\n\r] -> skip ;
