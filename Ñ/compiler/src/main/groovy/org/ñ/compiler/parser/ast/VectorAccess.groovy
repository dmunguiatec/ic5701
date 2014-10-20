package org.ñ.compiler.parser.ast

import org.ñ.compiler.parser.ast.visitor.ASTVisitor

class VectorAccess extends Expr {
    IdLiteral identifier
    Expr index

    @Override
    void accept(ASTVisitor visitor) {
        visitor.visit(this)
    }

    @Override
    String toString() {
        return "(vector-access ${identifier} ${index})"
    }
}
