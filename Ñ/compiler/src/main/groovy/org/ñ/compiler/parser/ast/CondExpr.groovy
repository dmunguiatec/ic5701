package org.ñ.compiler.parser.ast

import org.ñ.compiler.parser.ast.visitor.ASTVisitor

class CondExpr extends Expr {
    Expr cond
    Expr expr

    @Override
    void accept(ASTVisitor visitor) {
        visitor.visit(this)
    }

    @Override
    String toString() {
        return "(cond ${cond} ${expr})"
    }
}
