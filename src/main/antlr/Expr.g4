grammar Expr;

start: stat+ ;
stat: expr NEWLINE? ;
expr: expr '+' expr     # Add
    | expr '-' expr     # Sub
    | expr '*' expr     # Mul
    | expr '/' expr     # Div
    | NUMBER            # Number
    ;
NUMBER: [0-9]+('.'[0-9]+)? ;
NEWLINE: '\r'? '\n' ;
WS: [ \t]+ -> skip ;