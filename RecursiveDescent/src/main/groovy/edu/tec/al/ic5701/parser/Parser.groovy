package edu.tec.al.ic5701.parser

import edu.tec.al.ic5701.lexer.Lexer
import edu.tec.al.ic5701.lexer.Token
import edu.tec.al.ic5701.lexer.TokenType

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
abstract class Parser {
    Lexer input
    Token lookahead

    protected void consume() { lookahead = input.nextToken() }

    protected void match(TokenType type) {
        if (lookahead.tokenType == type) {
            consume()
        } else {
            throw new SyntaxException("Expecting: ${type}, found: ${lookahead.tokenType} at ${lookahead.line}:${lookahead.column}")
        }
    }
}
