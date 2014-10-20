package org.ñ.compiler.parser.ast

import org.ñ.compiler.parser.ast.visitor.ASTVisitor

class FuncCall extends Expr {
    IdLiteral identifier
    List<Expr> params = []

    @Override
    void accept(ASTVisitor visitor) {
        visitor.visit(this)
    }

    @Override
    String toString() {
        return "(func-call ${identifier} (params ${(params*.toString()).join(' ')}))"
    }
}
