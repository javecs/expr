grammar Expr;

start: stat+ ;
stat: expr NEWLINE? ;
expr: expr '+' expr
    | INT
    ;
INT: [0-9]+ ;
NEWLINE: '\r'? '\n' ;
WS: [ \t]+ -> skip ;