package org.ñ.compiler.parser.ast.visitor

import org.ñ.compiler.parser.ast.*

abstract class AbstractASTVisitor implements ASTVisitor<void> {

    @Override
    void visit(Program program) {
        program.constDefs.each { it.accept(this) }
        program.funcDefs.each { it.accept(this) }
        program.calcBlock.each { it.accept(this) }
    }

    @Override
    void visit(ConstDef constDef) {
        constDef.identifier.accept(this)
        constDef.value.accept(this)
    }

    @Override
    void visit(FuncDef funcDef) {
        funcDef.identifier.accept(this)
        funcDef.params.each { it.accept(this) }
        funcDef.body.each { it.accept(this) }
    }

    @Override
    void visit(IdDecl idDecl) {}

    @Override
    void visit(CondExpr condExpr) {
        condExpr.cond.accept(this)
        condExpr.expr.accept(this)
    }

    @Override
    void visit(BinaryExpr binaryExpr) {
        binaryExpr.leftOperand.accept(this)
        binaryExpr.rightOperand.accept(this)
    }

    @Override
    void visit(UnaryExpr unaryExpr) {
        unaryExpr.operand.accept(this)
    }

    @Override
    void visit(FuncCall funcCall) {
        funcCall.identifier.accept(this)
        funcCall.params.each { it.accept(this) }
    }

    @Override
    void visit(CardinalityCall cardinalityCall) {
        cardinalityCall.expr.accept(this)
    }

    @Override
    void visit(VectorAccess vectorAccess) {
        vectorAccess.identifier.accept(this)
        vectorAccess.index.accept(this)
    }

    @Override
    void visit(MatrixAccess matrixAccess) {
        matrixAccess.identifier.accept(this)
        matrixAccess.indexRow.accept(this)
        matrixAccess.indexCol.accept(this)
    }

    @Override
    void visit(VectorLiteral vectorLiteral) {
        vectorLiteral.elements.each { it.accept(this) }
    }

    @Override
    void visit(MatrixLiteral matrixLiteral) {
        matrixLiteral.elements.each { it.accept(this) }
    }

    @Override
    void visit(IdLiteral idLiteral) {}

    @Override
    void visit(IntegerLiteral integerLiteral) {}

    @Override
    void visit(RealLiteral realLiteral) {}

    @Override
    void visit(SymbolLiteral symbolLiteral) {}
}
