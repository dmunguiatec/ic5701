// Generated from /home/diegomunguia/Dropbox/TEC/II-2014/IC-5701 Compiladores e Intérpretes/Ñ/compiler/Ñ.g4 by ANTLR 4.4.1-dev
package org.ñ.compiler.parser.antlr4;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ÑParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ÑVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ÑParser#type_vector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_vector(@NotNull ÑParser.Type_vectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(@NotNull ÑParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#type_symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_symbol(@NotNull ÑParser.Type_symbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#calc_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalc_block(@NotNull ÑParser.Calc_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#type_matrix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_matrix(@NotNull ÑParser.Type_matrixContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull ÑParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#type_int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_int(@NotNull ÑParser.Type_intContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(@NotNull ÑParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull ÑParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#func_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_def(@NotNull ÑParser.Func_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#param_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_list(@NotNull ÑParser.Param_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#cond_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_expr(@NotNull ÑParser.Cond_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#vector_access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVector_access(@NotNull ÑParser.Vector_accessContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#func_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_call(@NotNull ÑParser.Func_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#type_real}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_real(@NotNull ÑParser.Type_realContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#card_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCard_call(@NotNull ÑParser.Card_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull ÑParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(@NotNull ÑParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#matrix_access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrix_access(@NotNull ÑParser.Matrix_accessContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#type_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_set(@NotNull ÑParser.Type_setContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#matrix_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrix_literal(@NotNull ÑParser.Matrix_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#vector_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVector_literal(@NotNull ÑParser.Vector_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull ÑParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ÑParser#const_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst_def(@NotNull ÑParser.Const_defContext ctx);
}