package org.ñ.compiler.parser.ast

import org.ñ.compiler.parser.ast.visitor.ASTVisitor

class Program extends ASTNode {
    List<ConstDef> constDefs = []
    List<FuncDef> funcDefs = []
    List<Expr> calcBlock = []

    @Override
    void accept(ASTVisitor visitor) {
        visitor.visit(this)
    }

    @Override
    String toString() {
        return "(program (const-defs ${(constDefs*.toString()).join(' ')}) (func-defs ${(funcDefs*.toString()).join(' ')}) (calc ${(calcBlock*.toString()).join(' ')}))"
    }
}
