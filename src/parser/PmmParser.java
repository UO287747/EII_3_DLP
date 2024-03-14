// Generated from C:/Users/angel/Desktop/EII_3_DLP/src/parser/Pmm.g4 by ANTLR 4.13.1
package parser;

    import ast.*;
    import ast.definitions.*;
    import ast.expressions.*;
    import ast.statements.*;
    import ast.types.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		TRASH=39, COMMENT=40, ID=41, INT_CONSTANT=42, REAL_CONSTANT=43, CHAR_CONSTANT=44;
	public static final int
		RULE_program = 0, RULE_main = 1, RULE_expression = 2, RULE_expressions = 3, 
		RULE_statement = 4, RULE_loop_body = 5, RULE_functionStatement = 6, RULE_functionExpression = 7, 
		RULE_func_definition = 8, RULE_parameters = 9, RULE_var_definition = 10, 
		RULE_variables = 11, RULE_type = 12, RULE_struct_field = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "expression", "expressions", "statement", "loop_body", 
			"functionStatement", "functionExpression", "func_definition", "parameters", 
			"var_definition", "variables", "type", "struct_field"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'def'", "'main'", "'('", "')'", "':'", "'{'", "'}'", "'['", 
			"']'", "'.'", "'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'>'", "'>='", 
			"'<'", "'<='", "'=='", "'!='", "'&&'", "'||'", "','", "'print'", "'input'", 
			"'='", "'if'", "'else'", "'while'", "'return'", "'int'", "'double'", 
			"'char'", "'struct'", "'void'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "TRASH", "COMMENT", "ID", "INT_CONSTANT", "REAL_CONSTANT", 
			"CHAR_CONSTANT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Pmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public List<Definition> definitions = new ArrayList<Definition>();
		public Var_definitionContext var_definition;
		public Func_definitionContext func_definition;
		public MainContext main;
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PmmParser.EOF, 0); }
		public List<Var_definitionContext> var_definition() {
			return getRuleContexts(Var_definitionContext.class);
		}
		public Var_definitionContext var_definition(int i) {
			return getRuleContext(Var_definitionContext.class,i);
		}
		public List<Func_definitionContext> func_definition() {
			return getRuleContexts(Func_definitionContext.class);
		}
		public Func_definitionContext func_definition(int i) {
			return getRuleContext(Func_definitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(35);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ID:
						{
						setState(28);
						((ProgramContext)_localctx).var_definition = var_definition();
						setState(29);
						match(T__0);
						 _localctx.definitions.addAll(((ProgramContext)_localctx).var_definition.ast); 
						}
						break;
					case T__1:
						{
						setState(32);
						((ProgramContext)_localctx).func_definition = func_definition();
						 _localctx.definitions.add(((ProgramContext)_localctx).func_definition.ast); 
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(39);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(40);
			((ProgramContext)_localctx).main = main();
			 _localctx.definitions.add(((ProgramContext)_localctx).main.ast); 
			setState(42);
			match(EOF);

			            ((ProgramContext)_localctx).ast =  new Program(0, 0, _localctx.definitions);
			        
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

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public Definition ast;
		public List<VarDefinition> definitions = new ArrayList<VarDefinition>();
		public List<Statement> statements = new ArrayList<Statement>();
		public Token e;
		public Var_definitionContext var_definition;
		public StatementContext statement;
		public List<Var_definitionContext> var_definition() {
			return getRuleContexts(Var_definitionContext.class);
		}
		public Var_definitionContext var_definition(int i) {
			return getRuleContext(Var_definitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(T__1);
			setState(46);
			((MainContext)_localctx).e = match(T__2);
			setState(47);
			match(T__3);
			setState(48);
			match(T__4);
			setState(49);
			match(T__5);
			setState(50);
			match(T__6);
			setState(57);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(51);
					((MainContext)_localctx).var_definition = var_definition();
					setState(52);
					match(T__0);
					 _localctx.definitions.addAll(((MainContext)_localctx).var_definition.ast); 
					}
					} 
				}
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 32999710142480L) != 0)) {
				{
				{
				setState(60);
				((MainContext)_localctx).statement = statement();
				 _localctx.statements.addAll(((MainContext)_localctx).statement.ast); 
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
			match(T__7);

			            FunctionType ft = new FunctionType(((MainContext)_localctx).e.getLine(), ((MainContext)_localctx).e.getCharPositionInLine()+1, new VoidType(0,0), _localctx.definitions);
			            ((MainContext)_localctx).ast =  new FuncDefinition(((MainContext)_localctx).e.getLine(), ((MainContext)_localctx).e.getCharPositionInLine()+1, ft, "main", _localctx.definitions, _localctx.statements);
			        
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext e1;
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token ID;
		public FunctionExpressionContext functionExpression;
		public TypeContext type;
		public Token OP;
		public ExpressionContext e2;
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(PmmParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(PmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public FunctionExpressionContext functionExpression() {
			return getRuleContext(FunctionExpressionContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(72);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).INT_CONSTANT.getLine(), ((ExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToInt((((ExpressionContext)_localctx).INT_CONSTANT!=null?((ExpressionContext)_localctx).INT_CONSTANT.getText():null))); 
				}
				break;
			case 2:
				{
				setState(74);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new RealLiteral(((ExpressionContext)_localctx).REAL_CONSTANT.getLine(), ((ExpressionContext)_localctx).REAL_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToReal((((ExpressionContext)_localctx).REAL_CONSTANT!=null?((ExpressionContext)_localctx).REAL_CONSTANT.getText():null))); 
				}
				break;
			case 3:
				{
				setState(76);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).CHAR_CONSTANT.getLine(), ((ExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine()+1, LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CHAR_CONSTANT!=null?((ExpressionContext)_localctx).CHAR_CONSTANT.getText():null))); 
				}
				break;
			case 4:
				{
				setState(78);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ast =  new Variable(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
				}
				break;
			case 5:
				{
				setState(80);
				((ExpressionContext)_localctx).functionExpression = functionExpression();
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).functionExpression.ast; 
				}
				break;
			case 6:
				{
				setState(83);
				match(T__3);
				setState(84);
				((ExpressionContext)_localctx).e1 = expression(0);
				setState(85);
				match(T__4);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).e1.ast; 
				}
				break;
			case 7:
				{
				setState(88);
				match(T__3);
				setState(89);
				((ExpressionContext)_localctx).type = type();
				setState(90);
				match(T__4);
				setState(91);
				((ExpressionContext)_localctx).e1 = expression(7);
				 ((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).type.ast.getLine(), ((ExpressionContext)_localctx).type.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).type.ast); 
				}
				break;
			case 8:
				{
				setState(94);
				match(T__11);
				setState(95);
				((ExpressionContext)_localctx).e1 = expression(6);
				 ((ExpressionContext)_localctx).ast =  new UnaryMinus(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast); 
				}
				break;
			case 9:
				{
				setState(98);
				match(T__12);
				setState(99);
				((ExpressionContext)_localctx).e1 = expression(5);
				 ((ExpressionContext)_localctx).ast =  new UnaryNot(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(136);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(134);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(104);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(105);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(106);
						((ExpressionContext)_localctx).e2 = expression(5);
						 new Arithmetic(((ExpressionContext)_localctx).OP.getLine(), ((ExpressionContext)_localctx).OP.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null)); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(109);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(110);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__11 || _la==T__16) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(111);
						((ExpressionContext)_localctx).e2 = expression(4);
						 new Arithmetic(((ExpressionContext)_localctx).OP.getLine(), ((ExpressionContext)_localctx).OP.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null)); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(114);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(115);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16515072L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(116);
						((ExpressionContext)_localctx).e2 = expression(3);
						 new Comparison(((ExpressionContext)_localctx).OP.getLine(), ((ExpressionContext)_localctx).OP.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null)); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(119);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(120);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(121);
						((ExpressionContext)_localctx).e2 = expression(2);
						 new Logic(((ExpressionContext)_localctx).OP.getLine(), ((ExpressionContext)_localctx).OP.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null)); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(124);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(125);
						match(T__8);
						setState(126);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(127);
						match(T__9);
						 ((ExpressionContext)_localctx).ast =  new ArrayAccess(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(130);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(131);
						match(T__10);
						setState(132);
						((ExpressionContext)_localctx).ID = match(ID);
						 ((ExpressionContext)_localctx).ast =  new StructAccess(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
						}
						break;
					}
					} 
				}
				setState(138);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionsContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<Expression>();
		public ExpressionContext expression;
		public ExpressionContext e1;
		public ExpressionsContext e2;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitExpressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expressions);
		try {
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				((ExpressionsContext)_localctx).expression = expression(0);
				 _localctx.ast.add(((ExpressionsContext)_localctx).expression.ast); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				((ExpressionsContext)_localctx).e1 = expression(0);
				 _localctx.ast.add(((ExpressionsContext)_localctx).e1.ast); 
				setState(144);
				match(T__25);
				setState(145);
				((ExpressionsContext)_localctx).e2 = expressions();
				 _localctx.ast.addAll(((ExpressionsContext)_localctx).e2.ast); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public List<Statement> elseList = new ArrayList<Statement>();
		public Token e;
		public ExpressionsContext expressions;
		public ExpressionContext e1;
		public Token OP;
		public ExpressionContext e2;
		public ExpressionContext expression;
		public Loop_bodyContext b1;
		public Loop_bodyContext b2;
		public Loop_bodyContext loop_body;
		public FunctionStatementContext functionStatement;
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<Loop_bodyContext> loop_body() {
			return getRuleContexts(Loop_bodyContext.class);
		}
		public Loop_bodyContext loop_body(int i) {
			return getRuleContext(Loop_bodyContext.class,i);
		}
		public FunctionStatementContext functionStatement() {
			return getRuleContext(FunctionStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				((StatementContext)_localctx).e = match(T__26);
				setState(151);
				((StatementContext)_localctx).expressions = expressions();
				setState(152);
				match(T__0);

				                for (Expression expression: ((StatementContext)_localctx).expressions.ast) {
				                    _localctx.ast.add(new Print(((StatementContext)_localctx).e.getLine(), ((StatementContext)_localctx).e.getCharPositionInLine()+1, expression));
				                }
				            
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				((StatementContext)_localctx).e = match(T__27);
				setState(156);
				((StatementContext)_localctx).expressions = expressions();
				setState(157);
				match(T__0);

				                for (Expression expression: ((StatementContext)_localctx).expressions.ast) {
				                    _localctx.ast.add(new Input(((StatementContext)_localctx).e.getLine(), ((StatementContext)_localctx).e.getCharPositionInLine()+1, expression));
				                }
				            
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				((StatementContext)_localctx).e1 = expression(0);
				setState(161);
				((StatementContext)_localctx).OP = match(T__28);
				setState(162);
				((StatementContext)_localctx).e2 = expression(0);
				setState(163);
				match(T__0);
				 _localctx.ast.add( new Assignment(((StatementContext)_localctx).OP.getLine(), ((StatementContext)_localctx).OP.getCharPositionInLine()+1, ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).e2.ast)); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(166);
				((StatementContext)_localctx).e = match(T__29);
				setState(167);
				((StatementContext)_localctx).expression = expression(0);
				setState(168);
				match(T__5);
				setState(169);
				((StatementContext)_localctx).b1 = loop_body();
				setState(175);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(170);
					match(T__30);
					setState(171);
					match(T__5);
					setState(172);
					((StatementContext)_localctx).b2 = loop_body();
					 ((StatementContext)_localctx).elseList =  ((StatementContext)_localctx).b2.ast; 
					}
					break;
				}

				                _localctx.ast.add( new IfElse(((StatementContext)_localctx).e.getLine(), ((StatementContext)_localctx).e.getCharPositionInLine()+1, ((StatementContext)_localctx).expression.ast, ((StatementContext)_localctx).b1.ast, _localctx.elseList) );
				            
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(179);
				((StatementContext)_localctx).e = match(T__31);
				setState(180);
				((StatementContext)_localctx).expression = expression(0);
				setState(181);
				match(T__5);
				setState(182);
				((StatementContext)_localctx).loop_body = loop_body();

				                _localctx.ast.add( new While(((StatementContext)_localctx).e.getLine(), ((StatementContext)_localctx).e.getCharPositionInLine()+1, ((StatementContext)_localctx).expression.ast, ((StatementContext)_localctx).loop_body.ast) );
				            
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(185);
				((StatementContext)_localctx).e = match(T__32);
				setState(186);
				((StatementContext)_localctx).expression = expression(0);
				setState(187);
				match(T__0);
				 _localctx.ast.add(new Return(((StatementContext)_localctx).e.getLine(), ((StatementContext)_localctx).e.getCharPositionInLine()+1, ((StatementContext)_localctx).expression.ast)); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(190);
				((StatementContext)_localctx).functionStatement = functionStatement();
				setState(191);
				match(T__0);
				 _localctx.ast.add(((StatementContext)_localctx).functionStatement.ast); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class Loop_bodyContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public StatementContext statement;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Loop_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_body; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitLoop_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_bodyContext loop_body() throws RecognitionException {
		Loop_bodyContext _localctx = new Loop_bodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_loop_body);
		int _la;
		try {
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				match(T__6);
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 32999710142480L) != 0)) {
					{
					{
					setState(197);
					((Loop_bodyContext)_localctx).statement = statement();
					 _localctx.ast.addAll(((Loop_bodyContext)_localctx).statement.ast); 
					}
					}
					setState(204);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(205);
				match(T__7);
				}
				break;
			case T__3:
			case T__11:
			case T__12:
			case T__26:
			case T__27:
			case T__29:
			case T__31:
			case T__32:
			case ID:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				((Loop_bodyContext)_localctx).statement = statement();
				 _localctx.ast.addAll(((Loop_bodyContext)_localctx).statement.ast); 
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionStatementContext extends ParserRuleContext {
		public Statement ast;
		public List<Expression> list = new ArrayList<Expression>();
		public Token ID;
		public ExpressionsContext expressions;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public FunctionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitFunctionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionStatementContext functionStatement() throws RecognitionException {
		FunctionStatementContext _localctx = new FunctionStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			((FunctionStatementContext)_localctx).ID = match(ID);
			setState(212);
			match(T__3);
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 32985348845584L) != 0)) {
				{
				setState(213);
				((FunctionStatementContext)_localctx).expressions = expressions();
				 _localctx.list.addAll(((FunctionStatementContext)_localctx).expressions.ast); 
				}
			}

			setState(218);
			match(T__4);
			 ((FunctionStatementContext)_localctx).ast =  new FuncInvocation(((FunctionStatementContext)_localctx).ID.getLine(), ((FunctionStatementContext)_localctx).ID.getCharPositionInLine()+1,
			         _localctx.list, new Variable(((FunctionStatementContext)_localctx).ID.getLine(), ((FunctionStatementContext)_localctx).ID.getCharPositionInLine()+1, (((FunctionStatementContext)_localctx).ID!=null?((FunctionStatementContext)_localctx).ID.getText():null))); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionExpressionContext extends ParserRuleContext {
		public Expression ast;
		public List<Expression> list = new ArrayList<Expression>();
		public Token ID;
		public ExpressionsContext expressions;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public FunctionExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitFunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionExpressionContext functionExpression() throws RecognitionException {
		FunctionExpressionContext _localctx = new FunctionExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			((FunctionExpressionContext)_localctx).ID = match(ID);
			setState(222);
			match(T__3);
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 32985348845584L) != 0)) {
				{
				setState(223);
				((FunctionExpressionContext)_localctx).expressions = expressions();
				 _localctx.list.addAll(((FunctionExpressionContext)_localctx).expressions.ast); 
				}
			}

			setState(228);
			match(T__4);
			 ((FunctionExpressionContext)_localctx).ast =  new FuncInvocation(((FunctionExpressionContext)_localctx).ID.getLine(), ((FunctionExpressionContext)_localctx).ID.getCharPositionInLine()+1,
			        _localctx.list, new Variable(((FunctionExpressionContext)_localctx).ID.getLine(), ((FunctionExpressionContext)_localctx).ID.getCharPositionInLine()+1, (((FunctionExpressionContext)_localctx).ID!=null?((FunctionExpressionContext)_localctx).ID.getText():null))); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class Func_definitionContext extends ParserRuleContext {
		public Definition ast;
		public List<VarDefinition> params = new ArrayList<VarDefinition>();
		public Type return_ = new VoidType(0,0);
		public List<VarDefinition> varDefinitions = new ArrayList<VarDefinition>();
		public List<Statement> statements = new ArrayList<Statement>();
		public Token ID;
		public ParametersContext parameters;
		public TypeContext type;
		public Var_definitionContext var_definition;
		public StatementContext statement;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<Var_definitionContext> var_definition() {
			return getRuleContexts(Var_definitionContext.class);
		}
		public Var_definitionContext var_definition(int i) {
			return getRuleContext(Var_definitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Func_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitFunc_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_definitionContext func_definition() throws RecognitionException {
		Func_definitionContext _localctx = new Func_definitionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_func_definition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(T__1);
			setState(232);
			((Func_definitionContext)_localctx).ID = match(ID);
			setState(233);
			match(T__3);
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(234);
				((Func_definitionContext)_localctx).parameters = parameters();
				 _localctx.params.addAll(((Func_definitionContext)_localctx).parameters.ast); 
				}
			}

			setState(239);
			match(T__4);
			setState(240);
			match(T__5);
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 532575945216L) != 0)) {
				{
				setState(241);
				((Func_definitionContext)_localctx).type = type();
				 ((Func_definitionContext)_localctx).return_ =  ((Func_definitionContext)_localctx).type.ast; 
				}
			}

			setState(246);
			match(T__6);
			setState(253);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(247);
					((Func_definitionContext)_localctx).var_definition = var_definition();
					setState(248);
					match(T__0);
					 _localctx.varDefinitions.addAll(((Func_definitionContext)_localctx).var_definition.ast); 
					}
					} 
				}
				setState(255);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 32999710142480L) != 0)) {
				{
				{
				setState(256);
				((Func_definitionContext)_localctx).statement = statement();
				 _localctx.statements.addAll(((Func_definitionContext)_localctx).statement.ast); 
				}
				}
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(264);
			match(T__7);

			                FunctionType ft = new FunctionType(((Func_definitionContext)_localctx).ID.getLine(), ((Func_definitionContext)_localctx).ID.getCharPositionInLine()+1, _localctx.return_, _localctx.params);
			                ((Func_definitionContext)_localctx).ast =  new FuncDefinition(((Func_definitionContext)_localctx).ID.getLine(), ((Func_definitionContext)_localctx).ID.getCharPositionInLine()+1, ft, (((Func_definitionContext)_localctx).ID!=null?((Func_definitionContext)_localctx).ID.getText():null), _localctx.varDefinitions, _localctx.statements);
			            
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public Var_definitionContext vd1;
		public Var_definitionContext vd2;
		public List<Var_definitionContext> var_definition() {
			return getRuleContexts(Var_definitionContext.class);
		}
		public Var_definitionContext var_definition(int i) {
			return getRuleContext(Var_definitionContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			((ParametersContext)_localctx).vd1 = var_definition();
			 _localctx.ast.addAll(((ParametersContext)_localctx).vd1.ast); 
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__25) {
				{
				{
				setState(269);
				match(T__25);
				setState(270);
				((ParametersContext)_localctx).vd2 = var_definition();
				 _localctx.ast.addAll(((ParametersContext)_localctx).vd2.ast); 
				}
				}
				setState(277);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Var_definitionContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public VariablesContext variables;
		public TypeContext type;
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Var_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitVar_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_definitionContext var_definition() throws RecognitionException {
		Var_definitionContext _localctx = new Var_definitionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_var_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			((Var_definitionContext)_localctx).variables = variables();
			setState(279);
			match(T__5);
			setState(280);
			((Var_definitionContext)_localctx).type = type();


			                for (Variable v: ((Var_definitionContext)_localctx).variables.ast) {

			                    VarDefinition vd = new VarDefinition(v.getLine(), v.getColumn(), ((Var_definitionContext)_localctx).type.ast, v.getName());
			                    if (!_localctx.ast.contains(vd)) { _localctx.ast.add(vd); }
			                    else { new ErrorType(v.getLine(), v.getColumn(), "La variable " + v.getName() + " ya se ha declarado."); }
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariablesContext extends ParserRuleContext {
		public List<Variable> ast = new ArrayList<Variable>();
		public Token ID;
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public VariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variables; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitVariables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariablesContext variables() throws RecognitionException {
		VariablesContext _localctx = new VariablesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_variables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			((VariablesContext)_localctx).ID = match(ID);
			 _localctx.ast.add( new Variable(((VariablesContext)_localctx).ID.getLine(), ((VariablesContext)_localctx).ID.getCharPositionInLine()+1, (((VariablesContext)_localctx).ID!=null?((VariablesContext)_localctx).ID.getText():null)) ); 
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__25) {
				{
				{
				setState(285);
				match(T__25);
				setState(286);
				((VariablesContext)_localctx).ID = match(ID);
				 _localctx.ast.add(new Variable(((VariablesContext)_localctx).ID.getLine(), ((VariablesContext)_localctx).ID.getCharPositionInLine()+1, (((VariablesContext)_localctx).ID!=null?((VariablesContext)_localctx).ID.getText():null))); 
				}
				}
				setState(292);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public Token INT_CONSTANT;
		public TypeContext type;
		public Token e;
		public Struct_fieldContext struct_field;
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<Struct_fieldContext> struct_field() {
			return getRuleContexts(Struct_fieldContext.class);
		}
		public Struct_fieldContext struct_field(int i) {
			return getRuleContext(Struct_fieldContext.class,i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type);
		int _la;
		try {
			setState(318);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(293);
				match(T__33);
				 ((TypeContext)_localctx).ast =  IntType.getInstance(); 
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 2);
				{
				setState(295);
				match(T__34);
				 ((TypeContext)_localctx).ast =  DoubleType.getInstance(); 
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 3);
				{
				setState(297);
				match(T__35);
				 ((TypeContext)_localctx).ast =  CharType.getInstance(); 
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(299);
				match(T__8);
				setState(300);
				((TypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(301);
				match(T__9);
				setState(302);
				((TypeContext)_localctx).type = type();
				 ((TypeContext)_localctx).ast =  new ArrayType(((TypeContext)_localctx).INT_CONSTANT.getLine(), ((TypeContext)_localctx).INT_CONSTANT.getCharPositionInLine()+1,
				                                    LexerHelper.lexemeToInt((((TypeContext)_localctx).INT_CONSTANT!=null?((TypeContext)_localctx).INT_CONSTANT.getText():null)), ((TypeContext)_localctx).type.ast ); 
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 5);
				{
				setState(305);
				((TypeContext)_localctx).e = match(T__36);
				setState(306);
				match(T__6);
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(307);
					((TypeContext)_localctx).struct_field = struct_field();
					 ((TypeContext)_localctx).ast =  new StructType(((TypeContext)_localctx).e.getLine(), ((TypeContext)_localctx).e.getCharPositionInLine()+1, ((TypeContext)_localctx).struct_field.ast); 
					}
					}
					setState(314);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(315);
				match(T__7);
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 6);
				{
				setState(316);
				match(T__37);
				 ((TypeContext)_localctx).ast =  new VoidType(0,0); 
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_fieldContext extends ParserRuleContext {
		public List<RecordField> ast = new ArrayList<RecordField>();
		public VariablesContext variables;
		public TypeContext type;
		public List<VariablesContext> variables() {
			return getRuleContexts(VariablesContext.class);
		}
		public VariablesContext variables(int i) {
			return getRuleContext(VariablesContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public Struct_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_field; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitStruct_field(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_fieldContext struct_field() throws RecognitionException {
		Struct_fieldContext _localctx = new Struct_fieldContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_struct_field);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(326); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(320);
					((Struct_fieldContext)_localctx).variables = variables();
					setState(321);
					match(T__5);
					setState(322);
					((Struct_fieldContext)_localctx).type = type();
					setState(323);
					match(T__0);


					            for (Variable v: ((Struct_fieldContext)_localctx).variables.ast) {

					                RecordField rf = new RecordField(v.getLine(), v.getColumn(), v.getName(), ((Struct_fieldContext)_localctx).type.ast);
					                if (!_localctx.ast.contains(rf)) { _localctx.ast.add(rf); }
					                else { new ErrorType(v.getLine(), v.getColumn(), "El campo " + v.getName() + " ya se ha declarado."); }
					            }
					        
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(328); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		case 2:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001,\u014b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000$\b\u0000\n\u0000\f\u0000"+
		"\'\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u00018\b\u0001"+
		"\n\u0001\f\u0001;\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"@\b\u0001\n\u0001\f\u0001C\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002g\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u0087\b\u0002\n\u0002"+
		"\f\u0002\u008a\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"\u0095\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004\u00b0\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00c3\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00c9\b\u0005\n\u0005"+
		"\f\u0005\u00cc\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005\u00d2\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006\u00d9\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u00e3\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\b\u00ee\b\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u00f5\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005"+
		"\b\u00fc\b\b\n\b\f\b\u00ff\t\b\u0001\b\u0001\b\u0001\b\u0005\b\u0104\b"+
		"\b\n\b\f\b\u0107\t\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\t\u0112\b\t\n\t\f\t\u0115\t\t\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u0121\b\u000b\n\u000b\f\u000b\u0124\t\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0137"+
		"\b\f\n\f\f\f\u013a\t\f\u0001\f\u0001\f\u0001\f\u0003\f\u013f\b\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0004\r\u0147\b\r\u000b\r\f"+
		"\r\u0148\u0001\r\u0000\u0001\u0004\u000e\u0000\u0002\u0004\u0006\b\n\f"+
		"\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0004\u0001\u0000\u000e"+
		"\u0010\u0002\u0000\f\f\u0011\u0011\u0001\u0000\u0012\u0017\u0001\u0000"+
		"\u0018\u0019\u0167\u0000%\u0001\u0000\u0000\u0000\u0002-\u0001\u0000\u0000"+
		"\u0000\u0004f\u0001\u0000\u0000\u0000\u0006\u0094\u0001\u0000\u0000\u0000"+
		"\b\u00c2\u0001\u0000\u0000\u0000\n\u00d1\u0001\u0000\u0000\u0000\f\u00d3"+
		"\u0001\u0000\u0000\u0000\u000e\u00dd\u0001\u0000\u0000\u0000\u0010\u00e7"+
		"\u0001\u0000\u0000\u0000\u0012\u010b\u0001\u0000\u0000\u0000\u0014\u0116"+
		"\u0001\u0000\u0000\u0000\u0016\u011b\u0001\u0000\u0000\u0000\u0018\u013e"+
		"\u0001\u0000\u0000\u0000\u001a\u0146\u0001\u0000\u0000\u0000\u001c\u001d"+
		"\u0003\u0014\n\u0000\u001d\u001e\u0005\u0001\u0000\u0000\u001e\u001f\u0006"+
		"\u0000\uffff\uffff\u0000\u001f$\u0001\u0000\u0000\u0000 !\u0003\u0010"+
		"\b\u0000!\"\u0006\u0000\uffff\uffff\u0000\"$\u0001\u0000\u0000\u0000#"+
		"\u001c\u0001\u0000\u0000\u0000# \u0001\u0000\u0000\u0000$\'\u0001\u0000"+
		"\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&(\u0001"+
		"\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000()\u0003\u0002\u0001\u0000"+
		")*\u0006\u0000\uffff\uffff\u0000*+\u0005\u0000\u0000\u0001+,\u0006\u0000"+
		"\uffff\uffff\u0000,\u0001\u0001\u0000\u0000\u0000-.\u0005\u0002\u0000"+
		"\u0000./\u0005\u0003\u0000\u0000/0\u0005\u0004\u0000\u000001\u0005\u0005"+
		"\u0000\u000012\u0005\u0006\u0000\u000029\u0005\u0007\u0000\u000034\u0003"+
		"\u0014\n\u000045\u0005\u0001\u0000\u000056\u0006\u0001\uffff\uffff\u0000"+
		"68\u0001\u0000\u0000\u000073\u0001\u0000\u0000\u00008;\u0001\u0000\u0000"+
		"\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:A\u0001\u0000"+
		"\u0000\u0000;9\u0001\u0000\u0000\u0000<=\u0003\b\u0004\u0000=>\u0006\u0001"+
		"\uffff\uffff\u0000>@\u0001\u0000\u0000\u0000?<\u0001\u0000\u0000\u0000"+
		"@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000"+
		"\u0000BD\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000DE\u0005\b\u0000"+
		"\u0000EF\u0006\u0001\uffff\uffff\u0000F\u0003\u0001\u0000\u0000\u0000"+
		"GH\u0006\u0002\uffff\uffff\u0000HI\u0005*\u0000\u0000Ig\u0006\u0002\uffff"+
		"\uffff\u0000JK\u0005+\u0000\u0000Kg\u0006\u0002\uffff\uffff\u0000LM\u0005"+
		",\u0000\u0000Mg\u0006\u0002\uffff\uffff\u0000NO\u0005)\u0000\u0000Og\u0006"+
		"\u0002\uffff\uffff\u0000PQ\u0003\u000e\u0007\u0000QR\u0006\u0002\uffff"+
		"\uffff\u0000Rg\u0001\u0000\u0000\u0000ST\u0005\u0004\u0000\u0000TU\u0003"+
		"\u0004\u0002\u0000UV\u0005\u0005\u0000\u0000VW\u0006\u0002\uffff\uffff"+
		"\u0000Wg\u0001\u0000\u0000\u0000XY\u0005\u0004\u0000\u0000YZ\u0003\u0018"+
		"\f\u0000Z[\u0005\u0005\u0000\u0000[\\\u0003\u0004\u0002\u0007\\]\u0006"+
		"\u0002\uffff\uffff\u0000]g\u0001\u0000\u0000\u0000^_\u0005\f\u0000\u0000"+
		"_`\u0003\u0004\u0002\u0006`a\u0006\u0002\uffff\uffff\u0000ag\u0001\u0000"+
		"\u0000\u0000bc\u0005\r\u0000\u0000cd\u0003\u0004\u0002\u0005de\u0006\u0002"+
		"\uffff\uffff\u0000eg\u0001\u0000\u0000\u0000fG\u0001\u0000\u0000\u0000"+
		"fJ\u0001\u0000\u0000\u0000fL\u0001\u0000\u0000\u0000fN\u0001\u0000\u0000"+
		"\u0000fP\u0001\u0000\u0000\u0000fS\u0001\u0000\u0000\u0000fX\u0001\u0000"+
		"\u0000\u0000f^\u0001\u0000\u0000\u0000fb\u0001\u0000\u0000\u0000g\u0088"+
		"\u0001\u0000\u0000\u0000hi\n\u0004\u0000\u0000ij\u0007\u0000\u0000\u0000"+
		"jk\u0003\u0004\u0002\u0005kl\u0006\u0002\uffff\uffff\u0000l\u0087\u0001"+
		"\u0000\u0000\u0000mn\n\u0003\u0000\u0000no\u0007\u0001\u0000\u0000op\u0003"+
		"\u0004\u0002\u0004pq\u0006\u0002\uffff\uffff\u0000q\u0087\u0001\u0000"+
		"\u0000\u0000rs\n\u0002\u0000\u0000st\u0007\u0002\u0000\u0000tu\u0003\u0004"+
		"\u0002\u0003uv\u0006\u0002\uffff\uffff\u0000v\u0087\u0001\u0000\u0000"+
		"\u0000wx\n\u0001\u0000\u0000xy\u0007\u0003\u0000\u0000yz\u0003\u0004\u0002"+
		"\u0002z{\u0006\u0002\uffff\uffff\u0000{\u0087\u0001\u0000\u0000\u0000"+
		"|}\n\t\u0000\u0000}~\u0005\t\u0000\u0000~\u007f\u0003\u0004\u0002\u0000"+
		"\u007f\u0080\u0005\n\u0000\u0000\u0080\u0081\u0006\u0002\uffff\uffff\u0000"+
		"\u0081\u0087\u0001\u0000\u0000\u0000\u0082\u0083\n\b\u0000\u0000\u0083"+
		"\u0084\u0005\u000b\u0000\u0000\u0084\u0085\u0005)\u0000\u0000\u0085\u0087"+
		"\u0006\u0002\uffff\uffff\u0000\u0086h\u0001\u0000\u0000\u0000\u0086m\u0001"+
		"\u0000\u0000\u0000\u0086r\u0001\u0000\u0000\u0000\u0086w\u0001\u0000\u0000"+
		"\u0000\u0086|\u0001\u0000\u0000\u0000\u0086\u0082\u0001\u0000\u0000\u0000"+
		"\u0087\u008a\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u0005\u0001\u0000\u0000\u0000"+
		"\u008a\u0088\u0001\u0000\u0000\u0000\u008b\u008c\u0003\u0004\u0002\u0000"+
		"\u008c\u008d\u0006\u0003\uffff\uffff\u0000\u008d\u0095\u0001\u0000\u0000"+
		"\u0000\u008e\u008f\u0003\u0004\u0002\u0000\u008f\u0090\u0006\u0003\uffff"+
		"\uffff\u0000\u0090\u0091\u0005\u001a\u0000\u0000\u0091\u0092\u0003\u0006"+
		"\u0003\u0000\u0092\u0093\u0006\u0003\uffff\uffff\u0000\u0093\u0095\u0001"+
		"\u0000\u0000\u0000\u0094\u008b\u0001\u0000\u0000\u0000\u0094\u008e\u0001"+
		"\u0000\u0000\u0000\u0095\u0007\u0001\u0000\u0000\u0000\u0096\u0097\u0005"+
		"\u001b\u0000\u0000\u0097\u0098\u0003\u0006\u0003\u0000\u0098\u0099\u0005"+
		"\u0001\u0000\u0000\u0099\u009a\u0006\u0004\uffff\uffff\u0000\u009a\u00c3"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u0005\u001c\u0000\u0000\u009c\u009d"+
		"\u0003\u0006\u0003\u0000\u009d\u009e\u0005\u0001\u0000\u0000\u009e\u009f"+
		"\u0006\u0004\uffff\uffff\u0000\u009f\u00c3\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a1\u0003\u0004\u0002\u0000\u00a1\u00a2\u0005\u001d\u0000\u0000\u00a2"+
		"\u00a3\u0003\u0004\u0002\u0000\u00a3\u00a4\u0005\u0001\u0000\u0000\u00a4"+
		"\u00a5\u0006\u0004\uffff\uffff\u0000\u00a5\u00c3\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a7\u0005\u001e\u0000\u0000\u00a7\u00a8\u0003\u0004\u0002\u0000"+
		"\u00a8\u00a9\u0005\u0006\u0000\u0000\u00a9\u00af\u0003\n\u0005\u0000\u00aa"+
		"\u00ab\u0005\u001f\u0000\u0000\u00ab\u00ac\u0005\u0006\u0000\u0000\u00ac"+
		"\u00ad\u0003\n\u0005\u0000\u00ad\u00ae\u0006\u0004\uffff\uffff\u0000\u00ae"+
		"\u00b0\u0001\u0000\u0000\u0000\u00af\u00aa\u0001\u0000\u0000\u0000\u00af"+
		"\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u0006\u0004\uffff\uffff\u0000\u00b2\u00c3\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b4\u0005 \u0000\u0000\u00b4\u00b5\u0003\u0004\u0002\u0000\u00b5"+
		"\u00b6\u0005\u0006\u0000\u0000\u00b6\u00b7\u0003\n\u0005\u0000\u00b7\u00b8"+
		"\u0006\u0004\uffff\uffff\u0000\u00b8\u00c3\u0001\u0000\u0000\u0000\u00b9"+
		"\u00ba\u0005!\u0000\u0000\u00ba\u00bb\u0003\u0004\u0002\u0000\u00bb\u00bc"+
		"\u0005\u0001\u0000\u0000\u00bc\u00bd\u0006\u0004\uffff\uffff\u0000\u00bd"+
		"\u00c3\u0001\u0000\u0000\u0000\u00be\u00bf\u0003\f\u0006\u0000\u00bf\u00c0"+
		"\u0005\u0001\u0000\u0000\u00c0\u00c1\u0006\u0004\uffff\uffff\u0000\u00c1"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c2\u0096\u0001\u0000\u0000\u0000\u00c2"+
		"\u009b\u0001\u0000\u0000\u0000\u00c2\u00a0\u0001\u0000\u0000\u0000\u00c2"+
		"\u00a6\u0001\u0000\u0000\u0000\u00c2\u00b3\u0001\u0000\u0000\u0000\u00c2"+
		"\u00b9\u0001\u0000\u0000\u0000\u00c2\u00be\u0001\u0000\u0000\u0000\u00c3"+
		"\t\u0001\u0000\u0000\u0000\u00c4\u00ca\u0005\u0007\u0000\u0000\u00c5\u00c6"+
		"\u0003\b\u0004\u0000\u00c6\u00c7\u0006\u0005\uffff\uffff\u0000\u00c7\u00c9"+
		"\u0001\u0000\u0000\u0000\u00c8\u00c5\u0001\u0000\u0000\u0000\u00c9\u00cc"+
		"\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cb"+
		"\u0001\u0000\u0000\u0000\u00cb\u00cd\u0001\u0000\u0000\u0000\u00cc\u00ca"+
		"\u0001\u0000\u0000\u0000\u00cd\u00d2\u0005\b\u0000\u0000\u00ce\u00cf\u0003"+
		"\b\u0004\u0000\u00cf\u00d0\u0006\u0005\uffff\uffff\u0000\u00d0\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d1\u00c4\u0001\u0000\u0000\u0000\u00d1\u00ce\u0001"+
		"\u0000\u0000\u0000\u00d2\u000b\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005"+
		")\u0000\u0000\u00d4\u00d8\u0005\u0004\u0000\u0000\u00d5\u00d6\u0003\u0006"+
		"\u0003\u0000\u00d6\u00d7\u0006\u0006\uffff\uffff\u0000\u00d7\u00d9\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d5\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001"+
		"\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00db\u0005"+
		"\u0005\u0000\u0000\u00db\u00dc\u0006\u0006\uffff\uffff\u0000\u00dc\r\u0001"+
		"\u0000\u0000\u0000\u00dd\u00de\u0005)\u0000\u0000\u00de\u00e2\u0005\u0004"+
		"\u0000\u0000\u00df\u00e0\u0003\u0006\u0003\u0000\u00e0\u00e1\u0006\u0007"+
		"\uffff\uffff\u0000\u00e1\u00e3\u0001\u0000\u0000\u0000\u00e2\u00df\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e5\u0005\u0005\u0000\u0000\u00e5\u00e6\u0006"+
		"\u0007\uffff\uffff\u0000\u00e6\u000f\u0001\u0000\u0000\u0000\u00e7\u00e8"+
		"\u0005\u0002\u0000\u0000\u00e8\u00e9\u0005)\u0000\u0000\u00e9\u00ed\u0005"+
		"\u0004\u0000\u0000\u00ea\u00eb\u0003\u0012\t\u0000\u00eb\u00ec\u0006\b"+
		"\uffff\uffff\u0000\u00ec\u00ee\u0001\u0000\u0000\u0000\u00ed\u00ea\u0001"+
		"\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001"+
		"\u0000\u0000\u0000\u00ef\u00f0\u0005\u0005\u0000\u0000\u00f0\u00f4\u0005"+
		"\u0006\u0000\u0000\u00f1\u00f2\u0003\u0018\f\u0000\u00f2\u00f3\u0006\b"+
		"\uffff\uffff\u0000\u00f3\u00f5\u0001\u0000\u0000\u0000\u00f4\u00f1\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f6\u00fd\u0005\u0007\u0000\u0000\u00f7\u00f8\u0003"+
		"\u0014\n\u0000\u00f8\u00f9\u0005\u0001\u0000\u0000\u00f9\u00fa\u0006\b"+
		"\uffff\uffff\u0000\u00fa\u00fc\u0001\u0000\u0000\u0000\u00fb\u00f7\u0001"+
		"\u0000\u0000\u0000\u00fc\u00ff\u0001\u0000\u0000\u0000\u00fd\u00fb\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000\u0000\u00fe\u0105\u0001"+
		"\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u0100\u0101\u0003"+
		"\b\u0004\u0000\u0101\u0102\u0006\b\uffff\uffff\u0000\u0102\u0104\u0001"+
		"\u0000\u0000\u0000\u0103\u0100\u0001\u0000\u0000\u0000\u0104\u0107\u0001"+
		"\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000\u0105\u0106\u0001"+
		"\u0000\u0000\u0000\u0106\u0108\u0001\u0000\u0000\u0000\u0107\u0105\u0001"+
		"\u0000\u0000\u0000\u0108\u0109\u0005\b\u0000\u0000\u0109\u010a\u0006\b"+
		"\uffff\uffff\u0000\u010a\u0011\u0001\u0000\u0000\u0000\u010b\u010c\u0003"+
		"\u0014\n\u0000\u010c\u0113\u0006\t\uffff\uffff\u0000\u010d\u010e\u0005"+
		"\u001a\u0000\u0000\u010e\u010f\u0003\u0014\n\u0000\u010f\u0110\u0006\t"+
		"\uffff\uffff\u0000\u0110\u0112\u0001\u0000\u0000\u0000\u0111\u010d\u0001"+
		"\u0000\u0000\u0000\u0112\u0115\u0001\u0000\u0000\u0000\u0113\u0111\u0001"+
		"\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114\u0013\u0001"+
		"\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0116\u0117\u0003"+
		"\u0016\u000b\u0000\u0117\u0118\u0005\u0006\u0000\u0000\u0118\u0119\u0003"+
		"\u0018\f\u0000\u0119\u011a\u0006\n\uffff\uffff\u0000\u011a\u0015\u0001"+
		"\u0000\u0000\u0000\u011b\u011c\u0005)\u0000\u0000\u011c\u0122\u0006\u000b"+
		"\uffff\uffff\u0000\u011d\u011e\u0005\u001a\u0000\u0000\u011e\u011f\u0005"+
		")\u0000\u0000\u011f\u0121\u0006\u000b\uffff\uffff\u0000\u0120\u011d\u0001"+
		"\u0000\u0000\u0000\u0121\u0124\u0001\u0000\u0000\u0000\u0122\u0120\u0001"+
		"\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0017\u0001"+
		"\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0125\u0126\u0005"+
		"\"\u0000\u0000\u0126\u013f\u0006\f\uffff\uffff\u0000\u0127\u0128\u0005"+
		"#\u0000\u0000\u0128\u013f\u0006\f\uffff\uffff\u0000\u0129\u012a\u0005"+
		"$\u0000\u0000\u012a\u013f\u0006\f\uffff\uffff\u0000\u012b\u012c\u0005"+
		"\t\u0000\u0000\u012c\u012d\u0005*\u0000\u0000\u012d\u012e\u0005\n\u0000"+
		"\u0000\u012e\u012f\u0003\u0018\f\u0000\u012f\u0130\u0006\f\uffff\uffff"+
		"\u0000\u0130\u013f\u0001\u0000\u0000\u0000\u0131\u0132\u0005%\u0000\u0000"+
		"\u0132\u0138\u0005\u0007\u0000\u0000\u0133\u0134\u0003\u001a\r\u0000\u0134"+
		"\u0135\u0006\f\uffff\uffff\u0000\u0135\u0137\u0001\u0000\u0000\u0000\u0136"+
		"\u0133\u0001\u0000\u0000\u0000\u0137\u013a\u0001\u0000\u0000\u0000\u0138"+
		"\u0136\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139"+
		"\u013b\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013b"+
		"\u013f\u0005\b\u0000\u0000\u013c\u013d\u0005&\u0000\u0000\u013d\u013f"+
		"\u0006\f\uffff\uffff\u0000\u013e\u0125\u0001\u0000\u0000\u0000\u013e\u0127"+
		"\u0001\u0000\u0000\u0000\u013e\u0129\u0001\u0000\u0000\u0000\u013e\u012b"+
		"\u0001\u0000\u0000\u0000\u013e\u0131\u0001\u0000\u0000\u0000\u013e\u013c"+
		"\u0001\u0000\u0000\u0000\u013f\u0019\u0001\u0000\u0000\u0000\u0140\u0141"+
		"\u0003\u0016\u000b\u0000\u0141\u0142\u0005\u0006\u0000\u0000\u0142\u0143"+
		"\u0003\u0018\f\u0000\u0143\u0144\u0005\u0001\u0000\u0000\u0144\u0145\u0006"+
		"\r\uffff\uffff\u0000\u0145\u0147\u0001\u0000\u0000\u0000\u0146\u0140\u0001"+
		"\u0000\u0000\u0000\u0147\u0148\u0001\u0000\u0000\u0000\u0148\u0146\u0001"+
		"\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u001b\u0001"+
		"\u0000\u0000\u0000\u0017#%9Af\u0086\u0088\u0094\u00af\u00c2\u00ca\u00d1"+
		"\u00d8\u00e2\u00ed\u00f4\u00fd\u0105\u0113\u0122\u0138\u013e\u0148";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}