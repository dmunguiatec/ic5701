package org.ñ.compiler.parser.ast

import org.ñ.compiler.parser.ast.visitor.ASTVisitor
import org.ñ.compiler.semantics.symboltable.SymbolTable

class FuncDef extends ASTNode {
    IdDecl identifier
    List<IdDecl> params = []
    List<Expr> body = []
    SymbolTable scope

    @Override
    void accept(ASTVisitor visitor) {
        visitor.visit(this)
    }

    @Override
    String toString() {
        return "(func-def ${identifier} (params ${(params*.toString()).join(' ')}) (body ${(body*.toString()).join(' ')}))"
    }
}
