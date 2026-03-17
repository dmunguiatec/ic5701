package edu.ic5701.dfa

data class Token(val type: TokenType, val lexeme: String, val line: Int, val offset: Int)
data class AcceptingState(val id: Int, val type: TokenType, val rollback: Boolean)

enum class TokenType {
    IDENT, PRINT, INT_LIT, OP_SUB, OP_ADD, OP_MUL, OP_ASSIGN, STMT_END, WS, EOF
}

private const val NIL = -1

private const val Q00 = 0
private const val Q01 = 1
private const val Q02 = 2
private const val Q03 = 3
private const val Q04 = 4
private const val Q05 = 5
private const val Q06 = 6
private const val Q07 = 7
private const val Q08 = 8
private const val Q09 = 9
private const val Q10 = 10
private const val Q11 = 11
private const val Q12 = 12
private const val Q13 = 13

private const val INPUT_ALPHA = -1000
private const val INPUT_DIGIT = -2000
private const val INPUT_WS    = -3000
private const val INPUT_EOF   = -4000

private const val EOF_CHAR = '\u0000'

class Scanner(val input: String) {

    val acceptingStates = mapOf(
        Q02 to AcceptingState(Q02, TokenType.IDENT, true),
        Q04 to AcceptingState(Q04, TokenType.INT_LIT, true),
        Q05 to AcceptingState(Q05, TokenType.OP_SUB, false),
        Q06 to AcceptingState(Q06, TokenType.OP_ADD, false),
        Q07 to AcceptingState(Q07, TokenType.OP_MUL, false),
        Q09 to AcceptingState(Q09, TokenType.OP_ASSIGN, false),
        Q10 to AcceptingState(Q10, TokenType.STMT_END, false),
        Q12 to AcceptingState(Q12, TokenType.WS, true),
        Q13 to AcceptingState(Q13, TokenType.EOF, false),
    )

    val dfa = arrayOf(
        mapOf(INPUT_ALPHA to Q01, INPUT_DIGIT to Q03, '-' to Q05, '+' to Q06, '*' to Q07, '<' to Q08, ';' to Q10, INPUT_WS to Q11, INPUT_EOF to Q13),
        mapOf(INPUT_ALPHA to Q01, INPUT_DIGIT to Q01, '-' to Q02, '+' to Q02, '*' to Q02, '<' to Q02, ';' to Q02, INPUT_WS to Q02, INPUT_EOF to Q02 ),
        mapOf(INPUT_ALPHA to NIL, INPUT_DIGIT to NIL, '-' to NIL, '+' to NIL, '*' to NIL, '<' to NIL, ';' to NIL, INPUT_WS to NIL, INPUT_EOF to NIL),
        mapOf(INPUT_ALPHA to Q04, INPUT_DIGIT to Q03, '-' to Q04, '+' to Q04, '*' to Q04, '<' to Q04, ';' to Q04, INPUT_WS to Q04, INPUT_EOF to Q04 ),
        mapOf(INPUT_ALPHA to NIL, INPUT_DIGIT to NIL, '-' to NIL, '+' to NIL, '*' to NIL, '<' to NIL, ';' to NIL, INPUT_WS to NIL, INPUT_EOF to NIL),
        mapOf(INPUT_ALPHA to NIL, INPUT_DIGIT to NIL, '-' to NIL, '+' to NIL, '*' to NIL, '<' to NIL, ';' to NIL, INPUT_WS to NIL, INPUT_EOF to NIL),
        mapOf(INPUT_ALPHA to NIL, INPUT_DIGIT to NIL, '-' to NIL, '+' to NIL, '*' to NIL, '<' to NIL, ';' to NIL, INPUT_WS to NIL, INPUT_EOF to NIL),
        mapOf(INPUT_ALPHA to NIL, INPUT_DIGIT to NIL, '-' to NIL, '+' to NIL, '*' to NIL, '<' to NIL, ';' to NIL, INPUT_WS to NIL, INPUT_EOF to NIL),
        mapOf(INPUT_ALPHA to NIL, INPUT_DIGIT to NIL, '-' to Q09, '+' to NIL, '*' to NIL, '<' to NIL, ';' to NIL, INPUT_WS to NIL, INPUT_EOF to NIL),
        mapOf(INPUT_ALPHA to NIL, INPUT_DIGIT to NIL, '-' to NIL, '+' to NIL, '*' to NIL, '<' to NIL, ';' to NIL, INPUT_WS to NIL, INPUT_EOF to NIL),
        mapOf(INPUT_ALPHA to NIL, INPUT_DIGIT to NIL, '-' to NIL, '+' to NIL, '*' to NIL, '<' to NIL, ';' to NIL, INPUT_WS to NIL, INPUT_EOF to NIL),
        mapOf(INPUT_ALPHA to Q12, INPUT_DIGIT to Q12, '-' to Q12, '+' to Q12, '*' to Q12, '<' to Q12, ';' to Q12, INPUT_WS to Q10, INPUT_EOF to Q12),
        mapOf(INPUT_ALPHA to NIL, INPUT_DIGIT to NIL, '-' to NIL, '+' to NIL, '*' to NIL, '<' to NIL, ';' to NIL, INPUT_WS to NIL, INPUT_EOF to NIL),
        mapOf(INPUT_ALPHA to NIL, INPUT_DIGIT to NIL, '-' to NIL, '+' to NIL, '*' to NIL, '<' to NIL, ';' to NIL, INPUT_WS to NIL, INPUT_EOF to NIL),
    )

    val keywords = mapOf(
        "print" to TokenType.PRINT,
    )

    var pointer = 0
    var line = 1
    var offset = 1

    fun next(): Token {
        var currentState = Q00
        val buffer = StringBuilder()

        while (true) {
            if (this.acceptingStates.containsKey(currentState)) {
                val acceptingState = this.acceptingStates[currentState]!!

                if (acceptingState.rollback) {
                    if (buffer.isNotEmpty()) {
                        buffer.setLength(buffer.length - 1)
                    }
                    this.pointer--
                }

                if (acceptingState.type == TokenType.WS) {
                    currentState = Q00
                    buffer.setLength(0)
                    continue
                }

                val lexeme = buffer.toString()
                val type: TokenType
                if (acceptingState.type == TokenType.IDENT) {
                    type = this.keywords[lexeme] ?: TokenType.IDENT
                } else {
                    type = acceptingState.type
                }

                return Token(type, lexeme, this.line, this.offset)
            }

            val inputChar = if (this.pointer < this.input.length) this.input[this.pointer] else EOF_CHAR

            if (inputChar == '\n') {
                this.line++
                this.offset = 1
            } else {
                this.offset++
            }

            val inputColumn = when {
                (this.pointer == this.input.length) -> INPUT_EOF
                inputChar.isLetter() -> INPUT_ALPHA
                inputChar.isDigit() -> INPUT_DIGIT
                inputChar.isWhitespace() -> INPUT_WS
                else -> inputChar
            }

            val nextState = this.dfa[currentState][inputColumn] ?: NIL
            if (nextState == NIL) {
                System.err.println("Undefined state for input: $inputChar at offset: ${this.pointer}")
                break
            }
            currentState = nextState

            buffer.append(inputChar)
            this.pointer++
        }

        return Token(TokenType.EOF, "", this.line, this.offset)
    }

}
