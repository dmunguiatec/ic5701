package org.ñ.compiler.parser.ast

import org.ñ.compiler.parser.ast.visitor.ASTVisitor

class UnaryExpr extends Expr {
    OperatorType operatorType
    Expr operand

    @Override
    void accept(ASTVisitor visitor) {
        visitor.visit(this)
    }

    @Override
    String toString() {
        return "(${operatorType.payload} ${operand})"
    }
}
