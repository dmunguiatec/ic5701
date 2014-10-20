package org.ñ.compiler.parser.ast

import org.antlr.v4.runtime.misc.NotNull
import org.antlr.v4.runtime.tree.TerminalNode
import org.ñ.compiler.parser.antlr4.ÑBaseVisitor
import org.ñ.compiler.parser.antlr4.ÑParser

class ASTBuilder extends ÑBaseVisitor<ASTNode> {

    @Override
    ASTNode visitProgram(@NotNull ÑParser.ProgramContext ctx) {
        Program program = new Program()

        for (ÑParser.Const_defContext constDefContext : ctx.const_def()) {
            program.constDefs << visit(constDefContext)
        }

        for (ÑParser.Func_defContext funcDefContext : ctx.func_def()) {
            program.funcDefs << visit(funcDefContext)
        }

        for (ÑParser.ExprContext exprContext : ctx.calc_block().expr()) {
            program.calcBlock << visit(exprContext)
        }

        return program
    }

    @Override
    ASTNode visitConst_def(@NotNull ÑParser.Const_defContext ctx) {
        ConstDef constDef = new ConstDef()

        constDef.identifier = visit(ctx.type()) as IdDecl
        constDef.identifier.token = ctx.ID().symbol
        constDef.value = visit(ctx.expr()) as Expr

        return constDef
    }

    @Override
    ASTNode visitFunc_def(@NotNull ÑParser.Func_defContext ctx) {
        FuncDef funcDef = new FuncDef()
        funcDef.identifier = visit(ctx.type()) as IdDecl
        funcDef.identifier.token = ctx.ID().symbol

        for (ÑParser.ParamContext paramContext : ctx.param_list().param()) {
            IdDecl idDecl = visit(paramContext.type()) as IdDecl
            idDecl.token = paramContext.ID().symbol
            funcDef.params << idDecl
        }

        for (ÑParser.Cond_exprContext condExprContext : ctx.block().cond_expr()) {
            funcDef.body << visit(condExprContext)
        }

        if (funcDef.body.empty) {
            funcDef.body << visit(ctx.block().expr())
        }

        return funcDef
    }

    @Override
    ASTNode visitCond_expr(@NotNull ÑParser.Cond_exprContext ctx) {
        CondExpr condExpr = new CondExpr()
        condExpr.cond = visit(ctx.expr(1)) as Expr
        condExpr.expr = visit(ctx.expr(0)) as Expr

        return condExpr
    }

    @Override
    ASTNode visitType_vector(@NotNull ÑParser.Type_vectorContext ctx) {
        return new IdDecl(dataType: DataType.VECTOR, dimX: ctx.LIT_INT().symbol.text as int)
    }

    @Override
    ASTNode visitType_symbol(@NotNull ÑParser.Type_symbolContext ctx) {
        return new IdDecl(dataType: DataType.SYMBOL)
    }

    @Override
    ASTNode visitType_matrix(@NotNull ÑParser.Type_matrixContext ctx) {
        return new IdDecl(dataType: DataType.MATRIX,
                dimX: ctx.LIT_INT(0).symbol.text as int,
                dimY: ctx.LIT_INT(1).symbol.text as int)
    }

    @Override
    ASTNode visitType_int(@NotNull ÑParser.Type_intContext ctx) {
        return new IdDecl(dataType: DataType.INTEGER)
    }

    @Override
    ASTNode visitType_real(@NotNull ÑParser.Type_realContext ctx) {
        return new IdDecl(dataType: DataType.REAL)
    }

    @Override
    ASTNode visitType_set(@NotNull ÑParser.Type_setContext ctx) {
        return new IdDecl(dataType: DataType.SET)
    }

    @Override
    ASTNode visitLiteral(@NotNull ÑParser.LiteralContext ctx) {
        if (ctx.ID()) {
            return new IdLiteral(token: ctx.ID().symbol)
        } else if (ctx.LIT_INT()) {
            return new IntegerLiteral(token: ctx.LIT_INT().symbol)
        } else if (ctx.LIT_REAL()) {
            return new RealLiteral(token: ctx.LIT_REAL().symbol)
        } else if (ctx.LIT_SYMBOL()) {
            return new SymbolLiteral(token: ctx.LIT_SYMBOL().symbol)
        }
    }

    @Override
    ASTNode visitVector_literal(@NotNull ÑParser.Vector_literalContext ctx) {
        VectorLiteral vectorLiteral = new VectorLiteral()
        vectorLiteral.length = ctx.expr().size()

        for (ÑParser.ExprContext exprContext : ctx.expr()) {
            vectorLiteral.elements << visit(exprContext)
        }

        return vectorLiteral
    }

    @Override
    ASTNode visitMatrix_literal(@NotNull ÑParser.Matrix_literalContext ctx) {
        MatrixLiteral matrixLiteral = new MatrixLiteral()
        matrixLiteral.rows = ctx.vector_literal().size()

        for (ÑParser.Vector_literalContext vectorLiteralContext : ctx.vector_literal()) {
            matrixLiteral.elements << visit(vectorLiteralContext)
        }

        matrixLiteral.cols = matrixLiteral.rows > 0 ? matrixLiteral.elements[0].length : 0

        return matrixLiteral
    }

    @Override
    ASTNode visitFunc_call(@NotNull ÑParser.Func_callContext ctx) {
        FuncCall funcCall = new FuncCall()
        funcCall.identifier = new IdLiteral(token: ctx.ID().symbol)

        for (ÑParser.ExprContext exprContext : ctx.expr()) {
            funcCall.params << visit(exprContext)
        }

        return funcCall
    }

    @Override
    ASTNode visitCard_call(@NotNull ÑParser.Card_callContext ctx) {
        CardinalityCall cardinalityCall = new CardinalityCall()
        cardinalityCall.expr = visit(ctx.expr()) as Expr
        return cardinalityCall
    }

    @Override
    ASTNode visitVector_access(@NotNull ÑParser.Vector_accessContext ctx) {
        VectorAccess vectorAccess = new VectorAccess()
        vectorAccess.identifier = new IdLiteral(token: ctx.ID().symbol)
        vectorAccess.index = visit(ctx.expr()) as Expr

        return vectorAccess
    }

    @Override
    ASTNode visitMatrix_access(@NotNull ÑParser.Matrix_accessContext ctx) {
        MatrixAccess matrixAccess = new MatrixAccess()
        matrixAccess.identifier = new IdLiteral(token: ctx.ID().symbol)
        matrixAccess.indexRow = visit(ctx.expr(0)) as Expr
        matrixAccess.indexCol = visit(ctx.expr(1)) as Expr

        return matrixAccess
    }

    @Override
    ASTNode visitExpr(@NotNull ÑParser.ExprContext ctx) {
        TerminalNode operator = chooseUnaryOperator(ctx)
        if (operator) {
            UnaryExpr expr = new UnaryExpr(operatorType: OperatorType.fromPayload(operator.symbol.text))
            expr.operand = visit(ctx.expr(0)) as Expr
            return expr
        }

        operator = chooseBinaryOperator(ctx)
        if (operator) {
            BinaryExpr expr = new BinaryExpr(operatorType: OperatorType.fromPayload(operator.symbol.text))
            expr.leftOperand = visit(ctx.expr(0)) as Expr
            expr.rightOperand = visit(ctx.expr(1)) as Expr
            return expr
        } else {
            return super.visitExpr(ctx) as ASTNode
        }
    }

    @Override
    ASTNode visitPrimary(@NotNull @NotNull ÑParser.PrimaryContext ctx) {
        if (ctx.expr()) {
            return visit(ctx.expr())
        } else {
            return super.visitPrimary(ctx)
        }
    }

    private static TerminalNode chooseUnaryOperator(ÑParser.ExprContext ctx) {
        if (ctx.OP_NOT()) { return ctx.OP_NOT() }
        else if (ctx.OP_NEG()) { return ctx.OP_NEG() }
        else { return null }
    }

    private static TerminalNode chooseBinaryOperator(ÑParser.ExprContext ctx) {
        if (ctx.OP_ADD()) { return ctx.OP_ADD() }
        else if (ctx.OP_AND()) { return ctx.OP_AND() }
        else if (ctx.OP_DIV()) { return ctx.OP_DIV() }
        else if (ctx.OP_DOT()) { return ctx.OP_DOT() }
        else if (ctx.OP_EQ()) { return ctx.OP_EQ() }
        else if (ctx.OP_GE()) { return ctx.OP_GE() }
        else if (ctx.OP_GT()) { return ctx.OP_GT() }
        else if (ctx.OP_LE()) { return ctx.OP_LE() }
        else if (ctx.OP_LT()) { return ctx.OP_LT() }
        else if (ctx.OP_MOD()) { return ctx.OP_MOD() }
        else if (ctx.OP_MULT()) { return ctx.OP_MULT() }
        else if (ctx.OP_NEQ()) { return ctx.OP_NEQ() }
        else if (ctx.OP_OR()) { return ctx.OP_OR() }
        else if (ctx.OP_POW()) { return ctx.OP_POW() }
        else if (ctx.OP_QUOT()) { return ctx.OP_QUOT() }
        else if (ctx.OP_SUB()) { return ctx.OP_SUB() }
        else { return null }
    }
}
