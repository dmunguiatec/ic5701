package org.ñ.compiler.semantics

import org.antlr.v4.runtime.Token
import org.ñ.compiler.parser.ast.DataType

class SemanticError {
    ErrorType errorType
    Token token

    // for type mismatch
    List<DataType> expecting
    List<DataType> received
}
