package edu.tec.al.ic5701.lexer

import groovy.transform.Canonical

@Canonical
class Token {
    TokenType tokenType
    int line
    int column
    String text

    @Override
    String toString() { "<${text}, ${tokenType}, ${line}:${column}>" }
}
