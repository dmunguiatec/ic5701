package edu.tec.al.ic5701.lexer

import static util.DoWhile.*

/**
 *   RDLexer
 *   Copyright (C) 2015  diegomunguia
 *
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; either version 2 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License along
 *   with this program; if not, write to the Free Software Foundation, Inc.,
 *   51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

class ListLexer extends Lexer {

    /**
     * LBRACK  -> '['
     * RBRACK  -> ']'
     * COMMA   -> ','
     * COMMENT -> '"' .* '"' skip
     * WS      -> [ \t\r\n]+ skip
     * ID      -> [a-zA-Z][a-zA-Z0-9]*
     * INT     -> [0-9]+
     */
    ListLexer(Reader input) {
        this.input = input
        consume()
    }

    @Override
    Token nextToken() {
        while (current != EOF) {
            if (isWS()) WS()
            else if (current == '"') COMMENT()
            else if (current == ',') return COMMA()
            else if (current == '[') return LBRACK()
            else if (current == ']') return RBRACK()
            else if (isLETTER()) return ID()
            else if (isDIGIT()) return INT()
            else error()

        }

        return new Token(TokenType.EOF, currentLine, currentCol)
    }

    private def error() {
        throw new LexicalException("Unexpected character '${current}'. at: ${currentLine}:${currentCol}")
    }

    private boolean isWS() { current == ' ' || current == '\n' || current == '\r' || current == '\t' }
    private boolean isLETTER() { (current in 'a'..'z' || current in 'A'..'Z') }
    private boolean isDIGIT() { current in '0'..'9' }

    private def WS() { while (isWS()) consume() }
    private def COMMENT() {
        repeat {
            consume()
        } until { current == '"' }
        consume() // consume that last "
    }

    private def COMMA() {
        def token = new Token(TokenType.COMMA, currentLine, currentCol, current as String)
        consume()
        return token
    }
    private def LBRACK() {
        def token = new Token(TokenType.LBRACK, currentLine, currentCol, current as String)
        consume()
        return token
    }
    private def RBRACK() {
        def token = new Token(TokenType.RBRACK, currentLine, currentCol, current as String)
        consume()
        return token
    }

    private def ID() {
        def buffer = new StringBuilder()
        repeat {
            buffer.append(current)
            consume()
        } until { !isLETTER() && !isDIGIT() }


        def text = buffer.toString()
        return new Token(TokenType.ID, currentLine, currentCol - text.length(), text)
    }

    private def INT() {
        def buffer = new StringBuilder()
        repeat {
            buffer.append(current)
            consume()
        } until { !isDIGIT() }


        def text = buffer.toString()
        return new Token(TokenType.INT, currentLine, currentCol - text.length(), text)
    }

}
