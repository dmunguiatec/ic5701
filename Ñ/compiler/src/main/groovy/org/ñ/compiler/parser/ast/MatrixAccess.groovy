package org.ñ.compiler.parser.ast

import org.ñ.compiler.parser.ast.visitor.ASTVisitor

class MatrixAccess extends Expr {
    IdLiteral identifier
    Expr indexRow
    Expr indexCol

    @Override
    void accept(ASTVisitor visitor) {
        visitor.visit(this)
    }

    @Override
    String toString() {
        return "(matrix-access ${identifier} ${indexRow} ${indexCol})"
    }
}
