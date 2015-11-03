package org.ñ.compiler

import org.antlr.v4.runtime.ANTLRFileStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree
import org.ñ.compiler.parser.antlr4.ÑLexer
import org.ñ.compiler.parser.antlr4.ÑParser
import org.ñ.compiler.parser.ast.ASTBuilder
import org.ñ.compiler.parser.ast.Program
import org.ñ.compiler.semantics.ErrorType
import org.ñ.compiler.semantics.SemanticAnalyzer
import org.ñ.compiler.semantics.SemanticError
import org.ñ.compiler.semantics.SymbolTableBuilder

ÑLexer lexer = new ÑLexer(new ANTLRFileStream(args[0], 'UTF-8'))
ÑParser parser = new ÑParser(new CommonTokenStream(lexer))
ParseTree parseTree = parser.program()

Program ast = new ASTBuilder().visit(parseTree) as Program
new SymbolTableBuilder().visit(ast)
SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer()
semanticAnalyzer.visit(ast)

if (semanticAnalyzer.errors) {
    semanticAnalyzer.errors.each { SemanticError error ->
        switch(error.errorType) {
            case ErrorType.ALREADY_DEFINED_IDENTIFIER:
                println("Error línea ${error.token.line}: el identificador ${error.token.text} ya está definido")
                break
            case ErrorType.UNDEFINED_IDENTIFIER:
                println("Error línea ${error.token.line}: el identificador ${error.token.text} no está definido")
                break
            case ErrorType.TYPE_MISMATCH:
                println("Error línea ${error.token.line}: conflicto de tipos, se esperaba ${error.expecting}, se recibió ${error.received}")
                break
        }
    }
} else {
    println('Ok!')
}
