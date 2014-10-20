package org.ñ.compiler.parser.ast

import org.ñ.compiler.parser.ast.visitor.ASTVisitor

class FuncDef extends ASTNode {
    DataType dataType

    IdDecl identifier
    List<IdDecl> params = []
    List<Expr> body = []

    @Override
    void accept(ASTVisitor visitor) {
        visitor.visit(this)
    }

    @Override
    String toString() {
        return "(func-def ${identifier} (params ${(params*.toString()).join(' ')}) (body ${(body*.toString()).join(' ')}))"
    }
}
