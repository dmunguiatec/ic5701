package org.ñ.compiler.parser.ast

import org.antlr.v4.runtime.Token
import org.ñ.compiler.parser.ast.visitor.ASTVisitor

class SymbolLiteral extends Expr {

    Token token
    DataType dataType = DataType.SYMBOL

    @Override
    void accept(ASTVisitor visitor) {
        visitor.visit(this)
    }

    @Override
    String toString() {
        return "(symbol-literal ${token.text})"
    }
}
