package org.ñ.compiler.parser.ast

import org.ñ.compiler.parser.ast.visitor.ASTVisitor

class BinaryExpr extends Expr {

    OperatorType operatorType
    Expr leftOperand
    Expr rightOperand

    @Override
    String toString() {
        return "(${operatorType.payload} ${leftOperand} ${rightOperand})"
    }

    @Override
    void accept(ASTVisitor visitor) {
        visitor.visit(this)
    }
}
