// Generated from /home/diegomunguia/Dropbox/TEC/II-2014/IC-5701 Compiladores e Intérpretes/Ñ/compiler/Ñ.g4 by ANTLR 4.4.1-dev
package org.ñ.compiler.parser.antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ÑParser extends Parser {
//	static { RuntimeMetaData.checkVersion("4.4.1-dev", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__19=1, T__18=2, T__17=3, T__16=4, T__15=5, T__14=6, T__13=7, T__12=8, 
		T__11=9, T__10=10, T__9=11, T__8=12, T__7=13, T__6=14, T__5=15, T__4=16, 
		T__3=17, T__2=18, T__1=19, T__0=20, LIT_INT=21, LIT_REAL=22, LIT_SYMBOL=23, 
		OP_NOT=24, OP_AND=25, OP_OR=26, OP_EQ=27, OP_NEQ=28, OP_GT=29, OP_LT=30, 
		OP_GE=31, OP_LE=32, OP_NEG=33, OP_POW=34, OP_DOT=35, OP_MULT=36, OP_DIV=37, 
		OP_QUOT=38, OP_MOD=39, OP_ADD=40, OP_SUB=41, ID=42, WS=43, COMMENT=44;
	public static final String[] tokenNames = {
		"<INVALID>", "'cálculo'", "']'", "'C'", "')'", "'.'", "','", "'['", "':'", 
		"'('", "'si'", "';'", "'Z'", "'definición'", "'{'", "'R'", "'V'", "'}'", 
		"'S'", "'|'", "'M'", "LIT_INT", "LIT_REAL", "LIT_SYMBOL", "'~no~'", "'~y~'", 
		"'~o~'", "'='", "'!='", "'>'", "'<'", "'<='", "'>='", "OP_NEG", "'~a-la~'", 
		"'·'", "'*'", "'/'", "'div'", "'mod'", "'+'", "OP_SUB", "ID", "WS", "COMMENT"
	};
	public static final int
		RULE_program = 0, RULE_calc_block = 1, RULE_const_def = 2, RULE_func_def = 3, 
		RULE_block = 4, RULE_param_list = 5, RULE_param = 6, RULE_type = 7, RULE_type_symbol = 8, 
		RULE_type_int = 9, RULE_type_real = 10, RULE_type_vector = 11, RULE_type_matrix = 12, 
		RULE_type_set = 13, RULE_cond_expr = 14, RULE_expr = 15, RULE_primary = 16, 
		RULE_matrix_access = 17, RULE_vector_access = 18, RULE_card_call = 19, 
		RULE_func_call = 20, RULE_vector_literal = 21, RULE_matrix_literal = 22, 
		RULE_literal = 23;
	public static final String[] ruleNames = {
		"program", "calc_block", "const_def", "func_def", "block", "param_list", 
		"param", "type", "type_symbol", "type_int", "type_real", "type_vector", 
		"type_matrix", "type_set", "cond_expr", "expr", "primary", "matrix_access", 
		"vector_access", "card_call", "func_call", "vector_literal", "matrix_literal", 
		"literal"
	};

	@Override
	public String getGrammarFileName() { return "Ñ.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ÑParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<Func_defContext> func_def() {
			return getRuleContexts(Func_defContext.class);
		}
		public List<Const_defContext> const_def() {
			return getRuleContexts(Const_defContext.class);
		}
		public Const_defContext const_def(int i) {
			return getRuleContext(Const_defContext.class,i);
		}
		public Func_defContext func_def(int i) {
			return getRuleContext(Func_defContext.class,i);
		}
		public Calc_blockContext calc_block() {
			return getRuleContext(Calc_blockContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(48); const_def();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(54); func_def();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60); calc_block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Calc_blockContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Calc_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calc_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitCalc_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Calc_blockContext calc_block() throws RecognitionException {
		Calc_blockContext _localctx = new Calc_blockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_calc_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); match(T__19);
			setState(63); match(T__6);
			setState(67); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(64); expr(0);
				setState(65); match(T__15);
				}
				}
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__11) | (1L << T__1) | (1L << LIT_INT) | (1L << LIT_REAL) | (1L << LIT_SYMBOL) | (1L << OP_NOT) | (1L << OP_NEG) | (1L << ID))) != 0) );
			setState(71); match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Const_defContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(ÑParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Const_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_def; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitConst_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Const_defContext const_def() throws RecognitionException {
		Const_defContext _localctx = new Const_defContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_const_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73); match(T__7);
			setState(74); match(ID);
			setState(75); type();
			setState(76); expr(0);
			setState(77); match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_defContext extends ParserRuleContext {
		public Param_listContext param_list() {
			return getRuleContext(Param_listContext.class,0);
		}
		public TerminalNode ID() { return getToken(ÑParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Func_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_def; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitFunc_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_defContext func_def() throws RecognitionException {
		Func_defContext _localctx = new Func_defContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_func_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79); match(ID);
			setState(80); match(T__11);
			setState(81); param_list();
			setState(82); match(T__16);
			setState(83); type();
			setState(84); match(OP_EQ);
			setState(85); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public Cond_exprContext cond_expr(int i) {
			return getRuleContext(Cond_exprContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<Cond_exprContext> cond_expr() {
			return getRuleContexts(Cond_exprContext.class);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			setState(99);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(87); match(T__6);
				setState(88); expr(0);
				setState(89); match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(91); match(T__6);
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(92); cond_expr();
					}
					}
					setState(95); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__11) | (1L << T__1) | (1L << LIT_INT) | (1L << LIT_REAL) | (1L << LIT_SYMBOL) | (1L << OP_NOT) | (1L << OP_NEG) | (1L << ID))) != 0) );
				setState(97); match(T__3);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_listContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public Param_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitParam_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_listContext param_list() throws RecognitionException {
		Param_listContext _localctx = new Param_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); param();
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(102); match(T__14);
				setState(103); param();
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ÑParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109); match(ID);
			setState(110); type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type_symbolContext type_symbol() {
			return getRuleContext(Type_symbolContext.class,0);
		}
		public Type_vectorContext type_vector() {
			return getRuleContext(Type_vectorContext.class,0);
		}
		public Type_intContext type_int() {
			return getRuleContext(Type_intContext.class,0);
		}
		public Type_realContext type_real() {
			return getRuleContext(Type_realContext.class,0);
		}
		public Type_matrixContext type_matrix() {
			return getRuleContext(Type_matrixContext.class,0);
		}
		public Type_setContext type_set() {
			return getRuleContext(Type_setContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); match(T__12);
			setState(119);
			switch (_input.LA(1)) {
			case T__2:
				{
				setState(113); type_symbol();
				}
				break;
			case T__8:
				{
				setState(114); type_int();
				}
				break;
			case T__5:
				{
				setState(115); type_real();
				}
				break;
			case T__4:
				{
				setState(116); type_vector();
				}
				break;
			case T__0:
				{
				setState(117); type_matrix();
				}
				break;
			case T__17:
				{
				setState(118); type_set();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_symbolContext extends ParserRuleContext {
		public Type_symbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_symbol; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitType_symbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_symbolContext type_symbol() throws RecognitionException {
		Type_symbolContext _localctx = new Type_symbolContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type_symbol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_intContext extends ParserRuleContext {
		public Type_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_int; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitType_int(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_intContext type_int() throws RecognitionException {
		Type_intContext _localctx = new Type_intContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type_int);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123); match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_realContext extends ParserRuleContext {
		public Type_realContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_real; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitType_real(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_realContext type_real() throws RecognitionException {
		Type_realContext _localctx = new Type_realContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type_real);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125); match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_vectorContext extends ParserRuleContext {
		public TerminalNode LIT_INT() { return getToken(ÑParser.LIT_INT, 0); }
		public Type_vectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_vector; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitType_vector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_vectorContext type_vector() throws RecognitionException {
		Type_vectorContext _localctx = new Type_vectorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type_vector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127); match(T__4);
			setState(128); match(T__11);
			setState(129); match(LIT_INT);
			setState(130); match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_matrixContext extends ParserRuleContext {
		public List<TerminalNode> LIT_INT() { return getTokens(ÑParser.LIT_INT); }
		public TerminalNode LIT_INT(int i) {
			return getToken(ÑParser.LIT_INT, i);
		}
		public Type_matrixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_matrix; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitType_matrix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_matrixContext type_matrix() throws RecognitionException {
		Type_matrixContext _localctx = new Type_matrixContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type_matrix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132); match(T__0);
			setState(133); match(T__11);
			setState(134); match(LIT_INT);
			setState(135); match(T__14);
			setState(136); match(LIT_INT);
			setState(137); match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_setContext extends ParserRuleContext {
		public Type_setContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_set; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitType_set(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_setContext type_set() throws RecognitionException {
		Type_setContext _localctx = new Type_setContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_type_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139); match(T__17);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cond_exprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Cond_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitCond_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cond_exprContext cond_expr() throws RecognitionException {
		Cond_exprContext _localctx = new Cond_exprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_cond_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); expr(0);
			setState(142); match(T__9);
			setState(143); match(T__10);
			setState(144); expr(0);
			setState(145); match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode OP_DOT() { return getToken(ÑParser.OP_DOT, 0); }
		public TerminalNode OP_MOD() { return getToken(ÑParser.OP_MOD, 0); }
		public TerminalNode OP_ADD() { return getToken(ÑParser.OP_ADD, 0); }
		public TerminalNode OP_AND() { return getToken(ÑParser.OP_AND, 0); }
		public TerminalNode OP_NEG() { return getToken(ÑParser.OP_NEG, 0); }
		public TerminalNode OP_NOT() { return getToken(ÑParser.OP_NOT, 0); }
		public TerminalNode OP_SUB() { return getToken(ÑParser.OP_SUB, 0); }
		public TerminalNode OP_NEQ() { return getToken(ÑParser.OP_NEQ, 0); }
		public TerminalNode OP_LE() { return getToken(ÑParser.OP_LE, 0); }
		public TerminalNode OP_POW() { return getToken(ÑParser.OP_POW, 0); }
		public TerminalNode OP_LT() { return getToken(ÑParser.OP_LT, 0); }
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode OP_EQ() { return getToken(ÑParser.OP_EQ, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_GT() { return getToken(ÑParser.OP_GT, 0); }
		public TerminalNode OP_DIV() { return getToken(ÑParser.OP_DIV, 0); }
		public TerminalNode OP_OR() { return getToken(ÑParser.OP_OR, 0); }
		public TerminalNode OP_QUOT() { return getToken(ÑParser.OP_QUOT, 0); }
		public TerminalNode OP_MULT() { return getToken(ÑParser.OP_MULT, 0); }
		public TerminalNode OP_GE() { return getToken(ÑParser.OP_GE, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			switch (_input.LA(1)) {
			case OP_NEG:
				{
				setState(148); match(OP_NEG);
				setState(149); expr(9);
				}
				break;
			case OP_NOT:
				{
				setState(150); match(OP_NOT);
				setState(151); expr(3);
				}
				break;
			case T__13:
			case T__11:
			case T__1:
			case LIT_INT:
			case LIT_REAL:
			case LIT_SYMBOL:
			case ID:
				{
				setState(152); primary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(178);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(176);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(155);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(156); match(OP_POW);
						setState(157); expr(8);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(158);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(159);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_DOT) | (1L << OP_MULT) | (1L << OP_DIV) | (1L << OP_QUOT) | (1L << OP_MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(160); expr(8);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(161);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(162);
						_la = _input.LA(1);
						if ( !(_la==OP_ADD || _la==OP_SUB) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(163); expr(7);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(164);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(165);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_GT) | (1L << OP_LT) | (1L << OP_GE) | (1L << OP_LE))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(166); expr(6);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(167);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(168);
						_la = _input.LA(1);
						if ( !(_la==OP_EQ || _la==OP_NEQ) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(169); expr(5);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(170);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(171); match(OP_AND);
						setState(172); expr(3);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(173);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(174); match(OP_OR);
						setState(175); expr(2);
						}
						break;
					}
					} 
				}
				setState(180);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public Matrix_accessContext matrix_access() {
			return getRuleContext(Matrix_accessContext.class,0);
		}
		public Matrix_literalContext matrix_literal() {
			return getRuleContext(Matrix_literalContext.class,0);
		}
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Vector_accessContext vector_access() {
			return getRuleContext(Vector_accessContext.class,0);
		}
		public Card_callContext card_call() {
			return getRuleContext(Card_callContext.class,0);
		}
		public Vector_literalContext vector_literal() {
			return getRuleContext(Vector_literalContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_primary);
		try {
			setState(192);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(181); match(T__11);
				setState(182); expr(0);
				setState(183); match(T__16);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(185); literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(186); vector_literal();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(187); matrix_literal();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(188); func_call();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(189); card_call();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(190); vector_access();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(191); matrix_access();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Matrix_accessContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ID() { return getToken(ÑParser.ID, 0); }
		public Matrix_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrix_access; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitMatrix_access(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Matrix_accessContext matrix_access() throws RecognitionException {
		Matrix_accessContext _localctx = new Matrix_accessContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_matrix_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); match(ID);
			setState(195); match(T__13);
			setState(196); expr(0);
			setState(197); match(T__18);
			setState(198); match(T__13);
			setState(199); expr(0);
			setState(200); match(T__18);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Vector_accessContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(ÑParser.ID, 0); }
		public Vector_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector_access; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitVector_access(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vector_accessContext vector_access() throws RecognitionException {
		Vector_accessContext _localctx = new Vector_accessContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_vector_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202); match(ID);
			setState(203); match(T__13);
			setState(204); expr(0);
			setState(205); match(T__18);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Card_callContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Card_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_card_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitCard_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Card_callContext card_call() throws RecognitionException {
		Card_callContext _localctx = new Card_callContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_card_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207); match(T__1);
			setState(208); expr(0);
			setState(209); match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_callContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ID() { return getToken(ÑParser.ID, 0); }
		public Func_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitFunc_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_callContext func_call() throws RecognitionException {
		Func_callContext _localctx = new Func_callContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_func_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211); match(ID);
			setState(212); match(T__11);
			setState(221);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__11) | (1L << T__1) | (1L << LIT_INT) | (1L << LIT_REAL) | (1L << LIT_SYMBOL) | (1L << OP_NOT) | (1L << OP_NEG) | (1L << ID))) != 0)) {
				{
				setState(213); expr(0);
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(214); match(T__14);
					setState(215); expr(0);
					}
					}
					setState(220);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(223); match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Vector_literalContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Vector_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitVector_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vector_literalContext vector_literal() throws RecognitionException {
		Vector_literalContext _localctx = new Vector_literalContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_vector_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225); match(T__13);
			setState(234);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__11) | (1L << T__1) | (1L << LIT_INT) | (1L << LIT_REAL) | (1L << LIT_SYMBOL) | (1L << OP_NOT) | (1L << OP_NEG) | (1L << ID))) != 0)) {
				{
				setState(226); expr(0);
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(227); match(T__14);
					setState(228); expr(0);
					}
					}
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(236); match(T__18);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Matrix_literalContext extends ParserRuleContext {
		public Vector_literalContext vector_literal(int i) {
			return getRuleContext(Vector_literalContext.class,i);
		}
		public List<Vector_literalContext> vector_literal() {
			return getRuleContexts(Vector_literalContext.class);
		}
		public Matrix_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrix_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitMatrix_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Matrix_literalContext matrix_literal() throws RecognitionException {
		Matrix_literalContext _localctx = new Matrix_literalContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_matrix_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238); match(T__13);
			setState(247);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(239); vector_literal();
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(240); match(T__14);
					setState(241); vector_literal();
					}
					}
					setState(246);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(249); match(T__18);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ÑParser.ID, 0); }
		public TerminalNode LIT_SYMBOL() { return getToken(ÑParser.LIT_SYMBOL, 0); }
		public TerminalNode LIT_REAL() { return getToken(ÑParser.LIT_REAL, 0); }
		public TerminalNode LIT_INT() { return getToken(ÑParser.LIT_INT, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ÑVisitor ) return ((ÑVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LIT_INT) | (1L << LIT_REAL) | (1L << LIT_SYMBOL) | (1L << ID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 8);
		case 1: return precpred(_ctx, 7);
		case 2: return precpred(_ctx, 6);
		case 3: return precpred(_ctx, 5);
		case 4: return precpred(_ctx, 4);
		case 5: return precpred(_ctx, 2);
		case 6: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3.\u0100\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\7\2\64\n\2\f\2\16\2\67\13\2\3\2\7\2:\n\2\f\2\16\2=\13\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\6\3F\n\3\r\3\16\3G\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\6\6`\n\6\r\6"+
		"\16\6a\3\6\3\6\5\6f\n\6\3\7\3\7\3\7\7\7k\n\7\f\7\16\7n\13\7\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tz\n\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u009c\n\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00b3\n\21\f\21\16\21\u00b6\13\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00c3\n\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\7\26\u00db\n\26\f\26\16\26\u00de"+
		"\13\26\5\26\u00e0\n\26\3\26\3\26\3\27\3\27\3\27\3\27\7\27\u00e8\n\27\f"+
		"\27\16\27\u00eb\13\27\5\27\u00ed\n\27\3\27\3\27\3\30\3\30\3\30\3\30\7"+
		"\30\u00f5\n\30\f\30\16\30\u00f8\13\30\5\30\u00fa\n\30\3\30\3\30\3\31\3"+
		"\31\3\31\2\3 \32\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\2"+
		"\7\3\2%)\3\2*+\3\2\37\"\3\2\35\36\4\2\27\31,,\u0108\2\65\3\2\2\2\4@\3"+
		"\2\2\2\6K\3\2\2\2\bQ\3\2\2\2\ne\3\2\2\2\fg\3\2\2\2\16o\3\2\2\2\20r\3\2"+
		"\2\2\22{\3\2\2\2\24}\3\2\2\2\26\177\3\2\2\2\30\u0081\3\2\2\2\32\u0086"+
		"\3\2\2\2\34\u008d\3\2\2\2\36\u008f\3\2\2\2 \u009b\3\2\2\2\"\u00c2\3\2"+
		"\2\2$\u00c4\3\2\2\2&\u00cc\3\2\2\2(\u00d1\3\2\2\2*\u00d5\3\2\2\2,\u00e3"+
		"\3\2\2\2.\u00f0\3\2\2\2\60\u00fd\3\2\2\2\62\64\5\6\4\2\63\62\3\2\2\2\64"+
		"\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66;\3\2\2\2\67\65\3\2\2\28:\5"+
		"\b\5\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>?\5"+
		"\4\3\2?\3\3\2\2\2@A\7\3\2\2AE\7\20\2\2BC\5 \21\2CD\7\7\2\2DF\3\2\2\2E"+
		"B\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\7\23\2\2J\5\3\2\2"+
		"\2KL\7\17\2\2LM\7,\2\2MN\5\20\t\2NO\5 \21\2OP\7\7\2\2P\7\3\2\2\2QR\7,"+
		"\2\2RS\7\13\2\2ST\5\f\7\2TU\7\6\2\2UV\5\20\t\2VW\7\35\2\2WX\5\n\6\2X\t"+
		"\3\2\2\2YZ\7\20\2\2Z[\5 \21\2[\\\7\23\2\2\\f\3\2\2\2]_\7\20\2\2^`\5\36"+
		"\20\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2bc\3\2\2\2cd\7\23\2\2df\3"+
		"\2\2\2eY\3\2\2\2e]\3\2\2\2f\13\3\2\2\2gl\5\16\b\2hi\7\b\2\2ik\5\16\b\2"+
		"jh\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\r\3\2\2\2nl\3\2\2\2op\7,\2\2"+
		"pq\5\20\t\2q\17\3\2\2\2ry\7\n\2\2sz\5\22\n\2tz\5\24\13\2uz\5\26\f\2vz"+
		"\5\30\r\2wz\5\32\16\2xz\5\34\17\2ys\3\2\2\2yt\3\2\2\2yu\3\2\2\2yv\3\2"+
		"\2\2yw\3\2\2\2yx\3\2\2\2z\21\3\2\2\2{|\7\24\2\2|\23\3\2\2\2}~\7\16\2\2"+
		"~\25\3\2\2\2\177\u0080\7\21\2\2\u0080\27\3\2\2\2\u0081\u0082\7\22\2\2"+
		"\u0082\u0083\7\13\2\2\u0083\u0084\7\27\2\2\u0084\u0085\7\6\2\2\u0085\31"+
		"\3\2\2\2\u0086\u0087\7\26\2\2\u0087\u0088\7\13\2\2\u0088\u0089\7\27\2"+
		"\2\u0089\u008a\7\b\2\2\u008a\u008b\7\27\2\2\u008b\u008c\7\6\2\2\u008c"+
		"\33\3\2\2\2\u008d\u008e\7\5\2\2\u008e\35\3\2\2\2\u008f\u0090\5 \21\2\u0090"+
		"\u0091\7\r\2\2\u0091\u0092\7\f\2\2\u0092\u0093\5 \21\2\u0093\u0094\7\7"+
		"\2\2\u0094\37\3\2\2\2\u0095\u0096\b\21\1\2\u0096\u0097\7#\2\2\u0097\u009c"+
		"\5 \21\13\u0098\u0099\7\32\2\2\u0099\u009c\5 \21\5\u009a\u009c\5\"\22"+
		"\2\u009b\u0095\3\2\2\2\u009b\u0098\3\2\2\2\u009b\u009a\3\2\2\2\u009c\u00b4"+
		"\3\2\2\2\u009d\u009e\f\n\2\2\u009e\u009f\7$\2\2\u009f\u00b3\5 \21\n\u00a0"+
		"\u00a1\f\t\2\2\u00a1\u00a2\t\2\2\2\u00a2\u00b3\5 \21\n\u00a3\u00a4\f\b"+
		"\2\2\u00a4\u00a5\t\3\2\2\u00a5\u00b3\5 \21\t\u00a6\u00a7\f\7\2\2\u00a7"+
		"\u00a8\t\4\2\2\u00a8\u00b3\5 \21\b\u00a9\u00aa\f\6\2\2\u00aa\u00ab\t\5"+
		"\2\2\u00ab\u00b3\5 \21\7\u00ac\u00ad\f\4\2\2\u00ad\u00ae\7\33\2\2\u00ae"+
		"\u00b3\5 \21\5\u00af\u00b0\f\3\2\2\u00b0\u00b1\7\34\2\2\u00b1\u00b3\5"+
		" \21\4\u00b2\u009d\3\2\2\2\u00b2\u00a0\3\2\2\2\u00b2\u00a3\3\2\2\2\u00b2"+
		"\u00a6\3\2\2\2\u00b2\u00a9\3\2\2\2\u00b2\u00ac\3\2\2\2\u00b2\u00af\3\2"+
		"\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"!\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b8\7\13\2\2\u00b8\u00b9\5 \21\2"+
		"\u00b9\u00ba\7\6\2\2\u00ba\u00c3\3\2\2\2\u00bb\u00c3\5\60\31\2\u00bc\u00c3"+
		"\5,\27\2\u00bd\u00c3\5.\30\2\u00be\u00c3\5*\26\2\u00bf\u00c3\5(\25\2\u00c0"+
		"\u00c3\5&\24\2\u00c1\u00c3\5$\23\2\u00c2\u00b7\3\2\2\2\u00c2\u00bb\3\2"+
		"\2\2\u00c2\u00bc\3\2\2\2\u00c2\u00bd\3\2\2\2\u00c2\u00be\3\2\2\2\u00c2"+
		"\u00bf\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c1\3\2\2\2\u00c3#\3\2\2\2"+
		"\u00c4\u00c5\7,\2\2\u00c5\u00c6\7\t\2\2\u00c6\u00c7\5 \21\2\u00c7\u00c8"+
		"\7\4\2\2\u00c8\u00c9\7\t\2\2\u00c9\u00ca\5 \21\2\u00ca\u00cb\7\4\2\2\u00cb"+
		"%\3\2\2\2\u00cc\u00cd\7,\2\2\u00cd\u00ce\7\t\2\2\u00ce\u00cf\5 \21\2\u00cf"+
		"\u00d0\7\4\2\2\u00d0\'\3\2\2\2\u00d1\u00d2\7\25\2\2\u00d2\u00d3\5 \21"+
		"\2\u00d3\u00d4\7\25\2\2\u00d4)\3\2\2\2\u00d5\u00d6\7,\2\2\u00d6\u00df"+
		"\7\13\2\2\u00d7\u00dc\5 \21\2\u00d8\u00d9\7\b\2\2\u00d9\u00db\5 \21\2"+
		"\u00da\u00d8\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd"+
		"\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00d7\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\7\6\2\2\u00e2+\3\2\2\2"+
		"\u00e3\u00ec\7\t\2\2\u00e4\u00e9\5 \21\2\u00e5\u00e6\7\b\2\2\u00e6\u00e8"+
		"\5 \21\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9"+
		"\u00ea\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00e4\3\2"+
		"\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\7\4\2\2\u00ef"+
		"-\3\2\2\2\u00f0\u00f9\7\t\2\2\u00f1\u00f6\5,\27\2\u00f2\u00f3\7\b\2\2"+
		"\u00f3\u00f5\5,\27\2\u00f4\u00f2\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4"+
		"\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9"+
		"\u00f1\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\7\4"+
		"\2\2\u00fc/\3\2\2\2\u00fd\u00fe\t\6\2\2\u00fe\61\3\2\2\2\23\65;Gaely\u009b"+
		"\u00b2\u00b4\u00c2\u00dc\u00df\u00e9\u00ec\u00f6\u00f9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}