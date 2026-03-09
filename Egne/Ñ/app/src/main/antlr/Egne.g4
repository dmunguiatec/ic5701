lexer grammar Egne;

LIT_INT
    :   [0-9]+
    ;

LIT_REAL
    :   [0-9]+ ('.' [0-9]+)?
    ;

LIT_SYMBOL
    :   '$' LETTER LETTER_OR_DIGIT*
    ;

OP_NOT
    :   '~no~'
    ;

OP_AND
    :   '~y~'
    ;

OP_OR
    :   '~o~'
    ;

OP_EQ
    :   '='
    ;

OP_NEQ
    :   '!='
    ;

OP_GT
    :   '>'
    ;

OP_LT
    :   '<'
    ;

OP_GE
    :   '<='
    ;

OP_LE
    :   '>='
    ;

OP_POW
    :   '~a-la~'
    ;

OP_DOT
    :   '·'
    ;

OP_TRANSP
    :   '^'
    ;

OP_MULT
    :   '*'
    ;

OP_DIV
    :   '/'
    ;

OP_QUOT
    :   'div'
    ;

OP_MOD
    :   'mod'
    ;

OP_ADD
    :   '+'
    ;

OP_SUB
    :   '-'
    ;

SEMICOLON
    :   ';'
    ;

COLON
    :   ':'
    ;

PERIOD
    :   '.'
    ;

LPAREN
    :   '('
    ;

RPAREN
    :   ')'
    ;

COMMA
    :   ','
    ;

LBRACK
    :   '['
    ;

RBRACK
    :   ']'
    ;

LBRACE
    :   '{'
    ;

RBRACE
    :   '}'
    ;

ID
    :   LETTER LETTER_OR_DIGIT*
    ;

LETTER
    :   [a-zA-ZáéíóúÁÉÍÓÚñÑ\u0370-\u03FF]
    ;

LETTER_OR_DIGIT
    :   [a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\u0370-\u03FF]
    ;

WS  :  [ \t\r\n\u000C]+ -> skip
    ;

COMMENT
    :   '"' .*? '"' -> skip
    ;