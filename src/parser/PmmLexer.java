// Generated from C:/Users/Ángel/Desktop/EII_3_DLP/src/parser/Pmm.g4 by ANTLR 4.13.1
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PmmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TRASH=1, COMMENT=2, ID=3, INT_CONSTANT=4, REAL_CONSTANT=5, CHAR_CONSTANT=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"TRASH", "LETRA", "NUMERO", "REAL_BODY", "COMMENT", "ID", "INT_CONSTANT", 
			"REAL_CONSTANT", "CHAR_CONSTANT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TRASH", "COMMENT", "ID", "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT"
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


	public PmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0006q\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0001\u0000\u0001\u0000\u0003\u0000\u0016"+
		"\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0003\u0003\u001f\b\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003&\b\u0003\u0001\u0003\u0003"+
		"\u0003)\b\u0003\u0001\u0004\u0001\u0004\u0005\u0004-\b\u0004\n\u0004\f"+
		"\u00040\t\u0004\u0001\u0004\u0003\u00043\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004:\b\u0004\n\u0004\f\u0004"+
		"=\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004B\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0003\u0005F\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005K\b\u0005\n\u0005\f\u0005N\t\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006S\b\u0006\n\u0006\f\u0006V\t\u0006\u0003"+
		"\u0006X\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007]\b\u0007"+
		"\u0001\u0007\u0003\u0007`\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005"+
		"\bf\b\b\n\b\f\bi\t\b\u0001\b\u0003\bl\b\b\u0003\bn\b\b\u0001\b\u0001\b"+
		"\u0002.;\u0000\t\u0001\u0001\u0003\u0000\u0005\u0000\u0007\u0000\t\u0002"+
		"\u000b\u0003\r\u0004\u000f\u0005\u0011\u0006\u0001\u0000\b\u0003\u0000"+
		"\t\n\r\r  \u0002\u0000AZaz\u0001\u000009\u0001\u0001\n\n\u0001\u00001"+
		"9\u0002\u0000EEee\u0002\u0000++--\u0002\u0000nntt\u0080\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0001\u0015\u0001\u0000\u0000"+
		"\u0000\u0003\u0019\u0001\u0000\u0000\u0000\u0005\u001b\u0001\u0000\u0000"+
		"\u0000\u0007(\u0001\u0000\u0000\u0000\tA\u0001\u0000\u0000\u0000\u000b"+
		"E\u0001\u0000\u0000\u0000\rW\u0001\u0000\u0000\u0000\u000fY\u0001\u0000"+
		"\u0000\u0000\u0011a\u0001\u0000\u0000\u0000\u0013\u0016\u0007\u0000\u0000"+
		"\u0000\u0014\u0016\u0003\t\u0004\u0000\u0015\u0013\u0001\u0000\u0000\u0000"+
		"\u0015\u0014\u0001\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000\u0000"+
		"\u0017\u0018\u0006\u0000\u0000\u0000\u0018\u0002\u0001\u0000\u0000\u0000"+
		"\u0019\u001a\u0007\u0001\u0000\u0000\u001a\u0004\u0001\u0000\u0000\u0000"+
		"\u001b\u001c\u0007\u0002\u0000\u0000\u001c\u0006\u0001\u0000\u0000\u0000"+
		"\u001d\u001f\u0003\r\u0006\u0000\u001e\u001d\u0001\u0000\u0000\u0000\u001e"+
		"\u001f\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 !\u0005"+
		".\u0000\u0000!)\u0003\r\u0006\u0000\"#\u0003\r\u0006\u0000#%\u0005.\u0000"+
		"\u0000$&\u0003\r\u0006\u0000%$\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000"+
		"\u0000&)\u0001\u0000\u0000\u0000\')\u0003\r\u0006\u0000(\u001e\u0001\u0000"+
		"\u0000\u0000(\"\u0001\u0000\u0000\u0000(\'\u0001\u0000\u0000\u0000)\b"+
		"\u0001\u0000\u0000\u0000*.\u0005#\u0000\u0000+-\t\u0000\u0000\u0000,+"+
		"\u0001\u0000\u0000\u0000-0\u0001\u0000\u0000\u0000./\u0001\u0000\u0000"+
		"\u0000.,\u0001\u0000\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001\u0000"+
		"\u0000\u000013\u0007\u0003\u0000\u000021\u0001\u0000\u0000\u00003B\u0001"+
		"\u0000\u0000\u000045\u0005\"\u0000\u000056\u0005\"\u0000\u000067\u0005"+
		"\"\u0000\u00007;\u0001\u0000\u0000\u00008:\t\u0000\u0000\u000098\u0001"+
		"\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000"+
		";9\u0001\u0000\u0000\u0000<>\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000"+
		"\u0000>?\u0005\"\u0000\u0000?@\u0005\"\u0000\u0000@B\u0005\"\u0000\u0000"+
		"A*\u0001\u0000\u0000\u0000A4\u0001\u0000\u0000\u0000B\n\u0001\u0000\u0000"+
		"\u0000CF\u0003\u0003\u0001\u0000DF\u0005_\u0000\u0000EC\u0001\u0000\u0000"+
		"\u0000ED\u0001\u0000\u0000\u0000FL\u0001\u0000\u0000\u0000GK\u0003\u0003"+
		"\u0001\u0000HK\u0003\u0005\u0002\u0000IK\u0005_\u0000\u0000JG\u0001\u0000"+
		"\u0000\u0000JH\u0001\u0000\u0000\u0000JI\u0001\u0000\u0000\u0000KN\u0001"+
		"\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000"+
		"M\f\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000OX\u00050\u0000\u0000"+
		"PT\u0007\u0004\u0000\u0000QS\u0003\u0005\u0002\u0000RQ\u0001\u0000\u0000"+
		"\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001\u0000"+
		"\u0000\u0000UX\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000WO\u0001"+
		"\u0000\u0000\u0000WP\u0001\u0000\u0000\u0000X\u000e\u0001\u0000\u0000"+
		"\u0000Y_\u0003\u0007\u0003\u0000Z\\\u0007\u0005\u0000\u0000[]\u0007\u0006"+
		"\u0000\u0000\\[\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0001"+
		"\u0000\u0000\u0000^`\u0003\r\u0006\u0000_Z\u0001\u0000\u0000\u0000_`\u0001"+
		"\u0000\u0000\u0000`\u0010\u0001\u0000\u0000\u0000am\u0005\'\u0000\u0000"+
		"bn\t\u0000\u0000\u0000ck\u0005\\\u0000\u0000df\u0003\u0005\u0002\u0000"+
		"ed\u0001\u0000\u0000\u0000fi\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000"+
		"\u0000gh\u0001\u0000\u0000\u0000hl\u0001\u0000\u0000\u0000ig\u0001\u0000"+
		"\u0000\u0000jl\u0007\u0007\u0000\u0000kg\u0001\u0000\u0000\u0000kj\u0001"+
		"\u0000\u0000\u0000ln\u0001\u0000\u0000\u0000mb\u0001\u0000\u0000\u0000"+
		"mc\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000op\u0005\'\u0000\u0000"+
		"p\u0012\u0001\u0000\u0000\u0000\u0013\u0000\u0015\u001e%(.2;AEJLTW\\_"+
		"gkm\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}