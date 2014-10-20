package org.ñ.compiler.parser.ast.visitor

import org.ñ.compiler.parser.ast.*

public interface ASTVisitor<T> {
    T visit(Program program)
    T visit(ConstDef constDef)
    T visit(FuncDef funcDef)
    T visit(IdDecl idDecl)
    T visit(CondExpr condExpr)
    T visit(BinaryExpr binaryExpr)
    T visit(UnaryExpr unaryExpr)
    T visit(FuncCall funcCall)
    T visit(CardinalityCall cardinalityCall)
    T visit(VectorAccess vectorAccess)
    T visit(MatrixAccess matrixAccess)
    T visit(VectorLiteral vectorLiteral)
    T visit(MatrixLiteral matrixLiteral)
    T visit(IdLiteral idLiteral)
    T visit(IntegerLiteral integerLiteral)
    T visit(RealLiteral realLiteral)
    T visit(SymbolLiteral symbolLiteral)
}