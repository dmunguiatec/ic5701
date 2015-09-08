package edu.tec.al.ic5701.lexer

abstract class Lexer {

    public static final char EOF = -1

    char current = EOF
    int currentLine = 1
    int currentCol = 0

    Reader input

    protected void consume() {
        current = input.read()

        // deal with coordinates
        if (current == '\n') {
            currentLine++
            currentCol = 1
        } else {
            currentCol++
        }
    }

    abstract Token nextToken()
}
