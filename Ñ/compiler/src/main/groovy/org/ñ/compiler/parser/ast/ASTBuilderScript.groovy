package org.ñ.compiler.parser.ast

import org.antlr.v4.runtime.ANTLRFileStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree
import org.ñ.compiler.parser.antlr4.ÑLexer
import org.ñ.compiler.parser.antlr4.ÑParser

ÑLexer lexer = new ÑLexer(new ANTLRFileStream(args[0], 'UTF-8'))
ÑParser parser = new ÑParser(new CommonTokenStream(lexer))
ParseTree parseTree = parser.program()

Program ast = new ASTBuilder().visit(parseTree) as Program
println(ast)