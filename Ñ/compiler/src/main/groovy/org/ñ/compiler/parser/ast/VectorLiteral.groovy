package org.ñ.compiler.parser.ast

import org.ñ.compiler.parser.ast.visitor.ASTVisitor

class VectorLiteral extends Expr {
    int length
    List<Expr> elements = []
    DataType dataType = DataType.VECTOR

    @Override
    void accept(ASTVisitor visitor) {
        visitor.visit(this)
    }

    @Override
    String toString() {
        return "(vector-literal ${(elements*.toString()).join(' ')})"
    }
}
