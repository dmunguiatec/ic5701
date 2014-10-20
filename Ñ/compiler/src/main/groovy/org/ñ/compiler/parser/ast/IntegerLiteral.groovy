package org.ñ.compiler.parser.ast

import org.antlr.v4.runtime.Token
import org.ñ.compiler.parser.ast.visitor.ASTVisitor

class IntegerLiteral extends Expr {
    Token token
    DataType dataType = DataType.INTEGER

    @Override
    void accept(ASTVisitor visitor) {
        visitor.visit(this)
    }

    @Override
    String toString() {
        return "(int-literal ${token.text})"
    }
}
