package org.ñ.compiler.parser.ast

import org.antlr.v4.runtime.Token
import org.ñ.compiler.parser.ast.visitor.ASTVisitor

class RealLiteral extends Expr {

    Token token
    DataType dataType = DataType.REAL

    @Override
    void accept(ASTVisitor visitor) {
        visitor.visit(this)
    }

    @Override
    String toString() {
        return "(real-literal ${token.text})"
    }
}
