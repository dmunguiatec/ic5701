package org.ñ.compiler.parser.ast

import org.antlr.v4.runtime.Token
import org.ñ.compiler.parser.ast.visitor.ASTVisitor

class IdLiteral extends Expr {
    Token token
    DataType dataType

    @Override
    void accept(ASTVisitor visitor) {
        visitor.visit(this)
    }

    @Override
    String toString() {
        return "(id-literal ${token.text})"
    }
}
