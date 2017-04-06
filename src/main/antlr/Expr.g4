grammar Expr;

start: stat+ ;
stat: expr NEWLINE? ;
expr: expr '+' expr     # Add
    | INT               # int
    ;
INT: [0-9]+ ;
NEWLINE: '\r'? '\n' ;
WS: [ \t]+ -> skip ;