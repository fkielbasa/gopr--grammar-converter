// Generated from C:/Users/kubad/Documents/GitHub/gopr-grammar-converter/GrammarExpression/src/Expr.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, BEGIN_LABEL=4, INT=5, LETTER=6, WS=7;
	public static final int
		RULE_program = 0, RULE_expression = 1, RULE_subexpression = 2, RULE_label = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expression", "subexpression", "label"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "'V'", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "BEGIN_LABEL", "INT", "LETTER", "WS"
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
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ExprParser.EOF, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(ExprParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(ExprParser.WS, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(14);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 82L) != 0)) {
				{
				{
				setState(8);
				expression();
				setState(10);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(9);
					match(WS);
					}
				}

				}
				}
				setState(16);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(17);
			match(EOF);
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
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public List<SubexpressionContext> subexpression() {
			return getRuleContexts(SubexpressionContext.class);
		}
		public SubexpressionContext subexpression(int i) {
			return getRuleContext(SubexpressionContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(ExprParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(ExprParser.WS, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			label();
			setState(20);
			match(T__0);
			setState(21);
			subexpression();
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==WS) {
				{
				{
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(22);
					match(WS);
					}
				}

				setState(25);
				match(T__1);
				setState(27);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(26);
					match(WS);
					}
					break;
				}
				setState(29);
				subexpression();
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(35);
			match(T__2);
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
	public static class SubexpressionContext extends ParserRuleContext {
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(ExprParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(ExprParser.WS, i);
		}
		public SubexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterSubexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitSubexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitSubexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubexpressionContext subexpression() throws RecognitionException {
		SubexpressionContext _localctx = new SubexpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_subexpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(37);
				match(WS);
				}
			}

			setState(40);
			label();
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(41);
				match(WS);
				}
				break;
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
	public static class LabelContext extends ParserRuleContext {
		public TerminalNode BEGIN_LABEL() { return getToken(ExprParser.BEGIN_LABEL, 0); }
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public TerminalNode LETTER() { return getToken(ExprParser.LETTER, 0); }
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(ExprParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(ExprParser.WS, i);
		}
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_label);
		int _la;
		try {
			setState(65);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN_LABEL:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				match(BEGIN_LABEL);
				setState(45);
				match(INT);
				}
				break;
			case LETTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				match(LETTER);
				setState(47);
				match(INT);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				match(T__0);
				setState(49);
				label();
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1 || _la==WS) {
					{
					{
					setState(51);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==WS) {
						{
						setState(50);
						match(WS);
						}
					}

					setState(53);
					match(T__1);
					setState(55);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==WS) {
						{
						setState(54);
						match(WS);
						}
					}

					setState(57);
					label();
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(63);
				match(T__2);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0007D\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0003"+
		"\u0000\u000b\b\u0000\u0005\u0000\r\b\u0000\n\u0000\f\u0000\u0010\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001\u0018\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u001c\b"+
		"\u0001\u0001\u0001\u0005\u0001\u001f\b\u0001\n\u0001\f\u0001\"\t\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0003\u0002\'\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002+\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u00034\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u00038\b\u0003\u0001\u0003\u0005\u0003"+
		";\b\u0003\n\u0003\f\u0003>\t\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"B\b\u0003\u0001\u0003\u0000\u0000\u0004\u0000\u0002\u0004\u0006\u0000"+
		"\u0000K\u0000\u000e\u0001\u0000\u0000\u0000\u0002\u0013\u0001\u0000\u0000"+
		"\u0000\u0004&\u0001\u0000\u0000\u0000\u0006A\u0001\u0000\u0000\u0000\b"+
		"\n\u0003\u0002\u0001\u0000\t\u000b\u0005\u0007\u0000\u0000\n\t\u0001\u0000"+
		"\u0000\u0000\n\u000b\u0001\u0000\u0000\u0000\u000b\r\u0001\u0000\u0000"+
		"\u0000\f\b\u0001\u0000\u0000\u0000\r\u0010\u0001\u0000\u0000\u0000\u000e"+
		"\f\u0001\u0000\u0000\u0000\u000e\u000f\u0001\u0000\u0000\u0000\u000f\u0011"+
		"\u0001\u0000\u0000\u0000\u0010\u000e\u0001\u0000\u0000\u0000\u0011\u0012"+
		"\u0005\u0000\u0000\u0001\u0012\u0001\u0001\u0000\u0000\u0000\u0013\u0014"+
		"\u0003\u0006\u0003\u0000\u0014\u0015\u0005\u0001\u0000\u0000\u0015 \u0003"+
		"\u0004\u0002\u0000\u0016\u0018\u0005\u0007\u0000\u0000\u0017\u0016\u0001"+
		"\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000\u0000\u0018\u0019\u0001"+
		"\u0000\u0000\u0000\u0019\u001b\u0005\u0002\u0000\u0000\u001a\u001c\u0005"+
		"\u0007\u0000\u0000\u001b\u001a\u0001\u0000\u0000\u0000\u001b\u001c\u0001"+
		"\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u001f\u0003"+
		"\u0004\u0002\u0000\u001e\u0017\u0001\u0000\u0000\u0000\u001f\"\u0001\u0000"+
		"\u0000\u0000 \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000"+
		"!#\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000#$\u0005\u0003\u0000"+
		"\u0000$\u0003\u0001\u0000\u0000\u0000%\'\u0005\u0007\u0000\u0000&%\u0001"+
		"\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000"+
		"(*\u0003\u0006\u0003\u0000)+\u0005\u0007\u0000\u0000*)\u0001\u0000\u0000"+
		"\u0000*+\u0001\u0000\u0000\u0000+\u0005\u0001\u0000\u0000\u0000,-\u0005"+
		"\u0004\u0000\u0000-B\u0005\u0005\u0000\u0000./\u0005\u0006\u0000\u0000"+
		"/B\u0005\u0005\u0000\u000001\u0005\u0001\u0000\u00001<\u0003\u0006\u0003"+
		"\u000024\u0005\u0007\u0000\u000032\u0001\u0000\u0000\u000034\u0001\u0000"+
		"\u0000\u000045\u0001\u0000\u0000\u000057\u0005\u0002\u0000\u000068\u0005"+
		"\u0007\u0000\u000076\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u0000"+
		"89\u0001\u0000\u0000\u00009;\u0003\u0006\u0003\u0000:3\u0001\u0000\u0000"+
		"\u0000;>\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000<=\u0001\u0000"+
		"\u0000\u0000=?\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000?@\u0005"+
		"\u0003\u0000\u0000@B\u0001\u0000\u0000\u0000A,\u0001\u0000\u0000\u0000"+
		"A.\u0001\u0000\u0000\u0000A0\u0001\u0000\u0000\u0000B\u0007\u0001\u0000"+
		"\u0000\u0000\u000b\n\u000e\u0017\u001b &*37<A";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}