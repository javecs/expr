grammar Expr;

start: stat+ ;
stat: expr NEWLINE? ;
expr: expr '*' expr     # Mul
    | expr '/' expr     # Div
    | expr '+' expr     # Add
    | expr '-' expr     # Sub
    | '(' expr ')'      # Parens
    | NUMBER            # Number
    | '(' expr ')'      # Parens
    ;
NUMBER: [0-9]+('.'[0-9]+)? ;
NEWLINE: '\r'? '\n' ;
WS: [ \t]+ -> skip ;