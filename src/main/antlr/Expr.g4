grammar Expr;

start: stat+ ;
stat: expr                          # StatExpr
    | ID '=' expr                   # Assign
    ;
expr: <assoc=right> expr '^' expr   # Pow
    | ('+'|'-') expr                # Sign
    | expr '*' expr                 # Mul
    | expr '/' expr                 # Div
    | expr '%' expr                 # Mod
    | expr '+' expr                 # Add
    | expr '-' expr                 # Sub
    | ID '(' expr ')'               # Function
    | CONSTANT                      # Constant
    | NUMBER                        # Number
    | ID                            # Id
    | '(' expr ')'                  # Parens
    ;
CONSTANT: [Pp][Ii]
    | [Ee]
    ;
NUMBER: [0-9]+('.'[0-9]+)? ;
ID: [a-zA-Z][a-zA-Z0-9]* ;
WS: [ \t\r\n]+ -> skip ;
