package edu.tec.al.ic5701.lexer

import static groovy.test.GroovyAssert.*
import org.junit.Test

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

class ListLexerTest {
    @Test
    void testScan() {
        // test one liner
        String code = '"comment"[xCoord, 5, yCoord, 1]"comment"'

        def expectedOutput = [
                new Token(TokenType.LBRACK, 1, 10, '['),
                new Token(TokenType.ID, 1, 11, 'xCoord'),
                new Token(TokenType.COMMA, 1, 17, ','),
                new Token(TokenType.INT, 1, 19, '5'),
                new Token(TokenType.COMMA, 1, 20, ','),
                new Token(TokenType.ID, 1, 22, 'yCoord'),
                new Token(TokenType.COMMA, 1, 28, ','),
                new Token(TokenType.INT, 1, 30, '1'),
                new Token(TokenType.RBRACK, 1, 31, ']')
        ]

        def output = tokenizeString(code)
        assert(expectedOutput == output)

        // test multi-liner
        code =
        '''
        " this is a
          multiline
          comment
        "
        [
            el1,
            el2,
            el3
        ]
        '''
        output = tokenizeString(code)
        expectedOutput = [
                TokenType.LBRACK,
                TokenType.ID,
                TokenType.COMMA,
                TokenType.ID,
                TokenType.COMMA,
                TokenType.ID,
                TokenType.RBRACK
        ]

        output = tokenizeString(code)
        assert(expectedOutput == output*.tokenType)

        // test error
        shouldFail LexicalException, {
            code = '[1, -1]'
            tokenizeString(code)
        }

    }

    static def tokenizeString(String code) {
        def output = []
        def token
        Lexer lexer = new ListLexer(new StringReader(code))
        while ((token = lexer.nextToken())?.tokenType != TokenType.EOF) {
            output << token
        }
        return output
    }
}
