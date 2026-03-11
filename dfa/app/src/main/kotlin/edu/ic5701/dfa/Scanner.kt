package edu.ic5701.dfa

data class Token(val type: TokenType, val lexeme: String, val offsetStart: Int, val offsetEnd: Int)
data class AcceptingState(val id: Int, val type: TokenType, val rollback: Boolean)

enum class TokenType {
    IDENTIFIER, COMMA, EOF
}

private const val UNDEFINED = -1

private const val Q0 = 0
private const val Q1 = 1
private const val Q2 = 2
private const val Q3 = 3
private const val Q4 = 4

private const val INPUT_ALPHA = -1000
private const val INPUT_DIGIT = -2000
private const val INPUT_EOF = -3000

class Scanner(val input: String) {

    val acceptingStates = mapOf(
        Q2 to AcceptingState(Q2, TokenType.IDENTIFIER, true),
        Q3 to AcceptingState(Q3, TokenType.COMMA, false),
        Q4 to AcceptingState(Q4, TokenType.EOF, false)
    )

    val dfa = arrayOf(
        mapOf('_' to Q1,        INPUT_ALPHA to Q1,        INPUT_DIGIT to UNDEFINED, ',' to Q3       , INPUT_EOF to Q4),
        mapOf('_' to Q1,        INPUT_ALPHA to Q1,        INPUT_DIGIT to Q1,        ',' to Q2       , INPUT_EOF to Q2),
        mapOf('_' to UNDEFINED, INPUT_ALPHA to UNDEFINED, INPUT_DIGIT to UNDEFINED, ',' to UNDEFINED, INPUT_EOF to UNDEFINED),
        mapOf('_' to UNDEFINED, INPUT_ALPHA to UNDEFINED, INPUT_DIGIT to UNDEFINED, ',' to UNDEFINED, INPUT_EOF to UNDEFINED),
        mapOf('_' to UNDEFINED, INPUT_ALPHA to UNDEFINED, INPUT_DIGIT to UNDEFINED, ',' to UNDEFINED, INPUT_EOF to UNDEFINED)
    )

    var pointer = 0

    fun next(): Token {
        var currentState = Q0
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

                val lexeme = buffer.toString()
                return Token(acceptingState.type, lexeme, this.pointer - lexeme.length, this.pointer - 1)
            }

            val inputChar = if (this.pointer < this.input.length) this.input[this.pointer] else '\u0000'

            val inputColumn = when {
                (this.pointer == this.input.length) -> INPUT_EOF
                (inputChar in 'a'..'z') -> INPUT_ALPHA
                (inputChar in '0' .. '9') -> INPUT_DIGIT
                else -> inputChar
            }

            val nextState = this.dfa[currentState][inputColumn] ?: UNDEFINED
            if (nextState == UNDEFINED) {
                System.err.println("Undefined state for input: $inputChar at offset: ${this.pointer}")
                break
            }
            currentState = nextState

            buffer.append(inputChar)
            this.pointer++
        }

        return Token(TokenType.EOF, "", this.pointer, this.pointer)
    }

}
