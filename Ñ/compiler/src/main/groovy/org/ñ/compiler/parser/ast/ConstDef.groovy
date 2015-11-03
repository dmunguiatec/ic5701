package org.ñ.compiler.parser.ast

import groovy.transform.Canonical
import org.ñ.compiler.parser.ast.visitor.ASTVisitor

@Canonical
class ConstDef extends ASTNode {
    IdDecl identifier
    Expr value

    @Override
    void accept(ASTVisitor visitor) {
        visitor.visit(this)
    }

    @Override
    String toString() {
        return "(const ${identifier} ${value})"
    }
}
