package org.ñ.compiler.parser.ast

import org.antlr.v4.runtime.Token

abstract class Expr extends ASTNode {
    DataType dataType
    Token token
}
