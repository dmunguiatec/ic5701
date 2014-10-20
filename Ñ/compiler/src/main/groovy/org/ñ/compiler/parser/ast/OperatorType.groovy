package org.ñ.compiler.parser.ast

public enum OperatorType {
    NOT('~no~'), AND('~y~'), OR('~o~'),
    EQ('='), NEQ('!='), GT('>'), LT('<'), GE('>='), LE('<='),
    NEG('-'), POW('~a-la~'), DOT('.'), MULT('*'), DIV('/'), QUOT('div'), MOD('mod'),
    ADD('+'), SUB('-')

    String payload

    OperatorType(String payload) {
        this.payload = payload
    }

    static OperatorType fromPayload(String payload) {
        return values().find { value ->
            value.payload == payload
        }
    }
}