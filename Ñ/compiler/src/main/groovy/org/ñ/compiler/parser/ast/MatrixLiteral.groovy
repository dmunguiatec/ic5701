package org.ñ.compiler.parser.ast

import org.ñ.compiler.parser.ast.visitor.ASTVisitor

class MatrixLiteral extends Expr {
    int rows, cols
    List<VectorLiteral> elements = []
    DataType dataType = DataType.MATRIX

    @Override
    void accept(ASTVisitor visitor) {
        visitor.visit(this)
    }

    @Override
    String toString() {
        return "(matrix-literal ${(elements*.toString()).join(' ')})"
    }
}
