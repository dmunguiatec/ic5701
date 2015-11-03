package org.ñ.compiler.parser.ast

public enum DataType {
    SYMBOL('S'), INTEGER('Z'), REAL('R'), VECTOR('V'), MATRIX('M'), SET('C'), BOOLEAN('verdadero/falso'), ERROR('error')

    String text

    DataType(String text) {
        this.text = text
    }

    @Override
    String toString() {
        return text
    }
}