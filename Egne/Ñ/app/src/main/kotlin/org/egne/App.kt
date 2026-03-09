package org.egne

import Egne
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import kotlin.jvm.javaClass


private const val SAMPLE_EGNE = "/sample.egne"

class App {
    fun run() {
        val input = CharStreams.fromStream(this.javaClass.getResourceAsStream(SAMPLE_EGNE))
        val lexer = Egne(input)
        val tokens = CommonTokenStream(lexer)

        tokens.fill()

        for (token in tokens.getTokens()) {
            System.out.printf(
                "%-10s %-10s line=%d col=%d%n",
                lexer.getVocabulary().getSymbolicName(token.getType()),
                token.getText(),
                token.getLine(),
                token.getCharPositionInLine()
            )
        }
    }
}

fun main() {
    App().run()
}
