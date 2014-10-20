package org.ñ.compiler.parser.ast

import org.antlr.v4.runtime.Token
import org.ñ.compiler.parser.ast.visitor.ASTVisitor

class IdDecl extends ASTNode {
    Token token
    DataType dataType
    int dimX, dimY

    @Override
    void accept(ASTVisitor visitor) {
        visitor.visit(this)
    }

    @Override
    String toString() {
        return "(id-decl ${token.text} ${dataType} ${dimX ? dimX : ''} ${dimY ? dimY : ''})"
    }
}
