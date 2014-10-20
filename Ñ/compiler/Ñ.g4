grammar Ñ;

program
    :   const_def* func_def* calc_block
    ;

calc_block
    :   'cálculo' '{' (expr '.')+ '}'
    ;

const_def
    :   'definición' ID type expr '.'
    ;

func_def
    :   ID '(' param_list ')' type '=' block
    ;

block
    :   '{' expr '}'
    |   '{' cond_expr+ '}'
    ;

param_list
    :   param (',' param)*
    ;

param
    :   ID type
    ;

type
    :   ':' (type_symbol | type_int | type_real | type_vector | type_matrix | type_set)
    ;

type_symbol
    :   'S'
    ;

type_int
    :   'Z'
    ;

type_real
    :   'R'
    ;

type_vector
    :   'V' '(' LIT_INT ')'
    ;

type_matrix
    :   'M' '(' LIT_INT ',' LIT_INT ')'
    ;

type_set
    :   'C'
    ;

cond_expr
    :   expr ';' 'si' expr '.'
    ;

expr
    :   primary
    |   OP_NEG expr
    |   <assoc=right> expr OP_POW expr
    |   expr (OP_DOT | OP_MULT | OP_DIV | OP_QUOT | OP_MOD) expr
    |   expr (OP_ADD | OP_SUB ) expr
    |   expr (OP_GT | OP_LT | OP_GE | OP_LE) expr
    |   expr (OP_EQ | OP_NEQ ) expr
    |   OP_NOT expr
    |   expr OP_AND expr
    |   expr OP_OR expr
    ;

primary
    :   '(' expr ')'
    |   literal
    |   vector_literal
    |   matrix_literal
    |   func_call
    |   card_call
    |   vector_access
    |   matrix_access
    ;

matrix_access
    :   ID '[' expr ']' '[' expr ']'
    ;

vector_access
    :   ID '[' expr ']'
    ;

card_call
    :   '|' expr '|'
    ;

func_call
    :   ID '(' (expr (',' expr)*)? ')'
    ;

vector_literal
    :   '[' (expr (',' expr)*)? ']'
    ;

matrix_literal
    :   '[' (vector_literal (',' vector_literal)*)? ']'
    ;

literal
    :   LIT_INT
    |   LIT_REAL
    |   LIT_SYMBOL
    |   ID
    ;

LIT_INT
    :   [0-9]+
    ;

LIT_REAL
    :   [0-9]+ ('.' [0-9]+)?
    ;

LIT_SYMBOL
    :   '$' JavaLetter JavaLetterOrDigit*
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

OP_NEG
    :   '-'
    ;

OP_POW
    :   '~a-la~'
    ;

OP_DOT
    :   '·'
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

ID
    :   JavaLetter JavaLetterOrDigit*
    ;

fragment
JavaLetter
    :   [a-zA-Z$_] // these are the "java letters" below 0xFF
    |   // covers all characters above 0xFF which are not a surrogate
        ~[\u0000-\u00FF\uD800-\uDBFF]
        {Character.isJavaIdentifierStart(_input.LA(-1))}?
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
        {Character.isJavaIdentifierStart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
    ;

fragment
JavaLetterOrDigit
    :   [a-zA-Z0-9$_] // these are the "java letters or digits" below 0xFF
    |   // covers all characters above 0xFF which are not a surrogate
        ~[\u0000-\u00FF\uD800-\uDBFF]
        {Character.isJavaIdentifierPart(_input.LA(-1))}?
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
        {Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
    ;

WS  :  [ \t\r\n\u000C]+ -> skip
    ;

COMMENT
    :   '"' .*? '"' -> skip
    ;
