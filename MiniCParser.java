// Generated from MiniCParser.g4 by ANTLR 4.7.2

package fr.n7.stl.minic.parser;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.IOException;
import fr.n7.stl.minic.ast.*;
import fr.n7.stl.minic.ast.expression.*;
import fr.n7.stl.minic.ast.expression.accessible.*;
import fr.n7.stl.minic.ast.expression.allocation.*;
import fr.n7.stl.minic.ast.expression.assignable.*;
import fr.n7.stl.minic.ast.expression.value.*;
import fr.n7.stl.minic.ast.instruction.*;
import fr.n7.stl.minic.ast.instruction.declaration.*;
import fr.n7.stl.minic.ast.scope.*;
import fr.n7.stl.minic.ast.type.*;
import fr.n7.stl.minic.ast.type.declaration.*;
import fr.n7.stl.util.*;
import fr.n7.stl.tam.ast.*;
import fr.n7.stl.tam.ast.impl.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Egal=1, AccoladeOuvrante=2, AccoladeFermante=3, ParentheseOuvrante=4, 
		ParentheseFermante=5, CrochetOuvrant=6, CrochetFermant=7, Point=8, PointInterrogation=9, 
		DeuxPoint=10, Virgule=11, PointVirgule=12, Afficher=13, Si=14, Sinon=15, 
		Retour=16, DefinitionConstante=17, DefinitionType=18, Enregistrement=19, 
		Enumeration=20, Nouveau=21, TantQue=22, Asterisque=23, Oblique=24, PourCent=25, 
		Plus=26, Moins=27, DoubleBarre=28, DoubleEsperluette=29, PointExclamation=30, 
		Inferieur=31, Superieur=32, InferieurEgal=33, SuperieurEgal=34, DoubleEgal=35, 
		ExclamationEgal=36, Esperluette=37, TypeEntier=38, TypeFlottant=39, TypeBooleen=40, 
		TypeCaractere=41, TypeChaine=42, TypeVide=43, Vrai=44, Faux=45, Nul=46, 
		Premier=47, Second=48, Caractere=49, Chaine=50, Identificateur=51, Entier=52, 
		Flottant=53, CommentaireLigne=54, CommentaireBloc=55, WS=56;
	public static final int
		RULE_programme = 0, RULE_bloc = 1, RULE_parametres = 2, RULE_instruction = 3, 
		RULE_atomique = 4, RULE_champ = 5, RULE_etiquettes = 6, RULE_type = 7, 
		RULE_affectable = 8, RULE_expressions = 9, RULE_arguments = 10, RULE_expression = 11, 
		RULE_identifiant = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"programme", "bloc", "parametres", "instruction", "atomique", "champ", 
			"etiquettes", "type", "affectable", "expressions", "arguments", "expression", 
			"identifiant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'{'", "'}'", "'('", "')'", "'['", "']'", "'.'", "'?'", 
			"':'", "','", "';'", "'print'", "'if'", "'else'", "'return'", "'const'", 
			"'typedef'", "'struct'", "'enum'", "'new'", "'while'", "'*'", "'/'", 
			"'%'", "'+'", "'-'", "'||'", "'&&'", "'!'", "'<'", "'>'", "'<='", "'>='", 
			"'=='", "'!='", "'&'", "'int'", "'float'", "'boolean'", "'char'", "'String'", 
			"'void'", "'true'", "'false'", "'null'", "'fst'", "'snd'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Egal", "AccoladeOuvrante", "AccoladeFermante", "ParentheseOuvrante", 
			"ParentheseFermante", "CrochetOuvrant", "CrochetFermant", "Point", "PointInterrogation", 
			"DeuxPoint", "Virgule", "PointVirgule", "Afficher", "Si", "Sinon", "Retour", 
			"DefinitionConstante", "DefinitionType", "Enregistrement", "Enumeration", 
			"Nouveau", "TantQue", "Asterisque", "Oblique", "PourCent", "Plus", "Moins", 
			"DoubleBarre", "DoubleEsperluette", "PointExclamation", "Inferieur", 
			"Superieur", "InferieurEgal", "SuperieurEgal", "DoubleEgal", "ExclamationEgal", 
			"Esperluette", "TypeEntier", "TypeFlottant", "TypeBooleen", "TypeCaractere", 
			"TypeChaine", "TypeVide", "Vrai", "Faux", "Nul", "Premier", "Second", 
			"Caractere", "Chaine", "Identificateur", "Entier", "Flottant", "CommentaireLigne", 
			"CommentaireBloc", "WS"
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
	public String getGrammarFileName() { return "MiniCParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgrammeContext extends ParserRuleContext {
		public Token name;
		public BlocContext main;
		public TerminalNode Identificateur() { return getToken(MiniCParser.Identificateur, 0); }
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public ProgrammeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programme; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterProgramme(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitProgramme(this);
		}
	}

	public final ProgrammeContext programme() throws RecognitionException {
		ProgrammeContext _localctx = new ProgrammeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programme);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			((ProgrammeContext)_localctx).name = match(Identificateur);
			setState(27);
			((ProgrammeContext)_localctx).main = bloc();
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

	public static class BlocContext extends ParserRuleContext {
		public Block b;
		public InstructionContext instruction;
		public List<InstructionContext> instructions = new ArrayList<InstructionContext>();
		public TerminalNode AccoladeOuvrante() { return getToken(MiniCParser.AccoladeOuvrante, 0); }
		public TerminalNode AccoladeFermante() { return getToken(MiniCParser.AccoladeFermante, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public BlocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterBloc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitBloc(this);
		}
	}

	public final BlocContext bloc() throws RecognitionException {
		BlocContext _localctx = new BlocContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_bloc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(AccoladeOuvrante);
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ParentheseOuvrante) | (1L << Afficher) | (1L << Si) | (1L << Retour) | (1L << DefinitionConstante) | (1L << DefinitionType) | (1L << Enregistrement) | (1L << Enumeration) | (1L << TantQue) | (1L << Asterisque) | (1L << Inferieur) | (1L << TypeEntier) | (1L << TypeFlottant) | (1L << TypeBooleen) | (1L << TypeCaractere) | (1L << TypeChaine) | (1L << TypeVide) | (1L << Identificateur))) != 0)) {
				{
				{
				setState(30);
				((BlocContext)_localctx).instruction = instruction();
				((BlocContext)_localctx).instructions.add(((BlocContext)_localctx).instruction);
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
			match(AccoladeFermante);
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

	public static class ParametresContext extends ParserRuleContext {
		public List<ParameterDeclaration> l;
		public TypeContext type1;
		public IdentifiantContext ident1;
		public TypeContext type;
		public List<TypeContext> suiteType = new ArrayList<TypeContext>();
		public IdentifiantContext identifiant;
		public List<IdentifiantContext> suiteIdent = new ArrayList<IdentifiantContext>();
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<IdentifiantContext> identifiant() {
			return getRuleContexts(IdentifiantContext.class);
		}
		public IdentifiantContext identifiant(int i) {
			return getRuleContext(IdentifiantContext.class,i);
		}
		public List<TerminalNode> Virgule() { return getTokens(MiniCParser.Virgule); }
		public TerminalNode Virgule(int i) {
			return getToken(MiniCParser.Virgule, i);
		}
		public ParametresContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametres; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterParametres(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitParametres(this);
		}
	}

	public final ParametresContext parametres() throws RecognitionException {
		ParametresContext _localctx = new ParametresContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_parametres);
		int _la;
		try {
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ParentheseFermante:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case Enregistrement:
			case Enumeration:
			case Inferieur:
			case TypeEntier:
			case TypeFlottant:
			case TypeBooleen:
			case TypeCaractere:
			case TypeChaine:
			case TypeVide:
			case Identificateur:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				((ParametresContext)_localctx).type1 = type();
				setState(40);
				((ParametresContext)_localctx).ident1 = identifiant(0);
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Virgule) {
					{
					{
					setState(41);
					match(Virgule);
					setState(42);
					((ParametresContext)_localctx).type = type();
					((ParametresContext)_localctx).suiteType.add(((ParametresContext)_localctx).type);
					setState(43);
					((ParametresContext)_localctx).identifiant = identifiant(0);
					((ParametresContext)_localctx).suiteIdent.add(((ParametresContext)_localctx).identifiant);
					}
					}
					setState(49);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class InstructionContext extends ParserRuleContext {
		public Instruction i;
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	 
		public InstructionContext() { }
		public void copyFrom(InstructionContext ctx) {
			super.copyFrom(ctx);
			this.i = ctx.i;
		}
	}
	public static class InstructionReturnContext extends InstructionContext {
		public TerminalNode Retour() { return getToken(MiniCParser.Retour, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PointVirgule() { return getToken(MiniCParser.PointVirgule, 0); }
		public InstructionReturnContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterInstructionReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitInstructionReturn(this);
		}
	}
	public static class InstructionSiSinonContext extends InstructionContext {
		public BlocContext alors;
		public BlocContext sinon;
		public TerminalNode Si() { return getToken(MiniCParser.Si, 0); }
		public TerminalNode ParentheseOuvrante() { return getToken(MiniCParser.ParentheseOuvrante, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ParentheseFermante() { return getToken(MiniCParser.ParentheseFermante, 0); }
		public TerminalNode Sinon() { return getToken(MiniCParser.Sinon, 0); }
		public List<BlocContext> bloc() {
			return getRuleContexts(BlocContext.class);
		}
		public BlocContext bloc(int i) {
			return getRuleContext(BlocContext.class,i);
		}
		public InstructionSiSinonContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterInstructionSiSinon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitInstructionSiSinon(this);
		}
	}
	public static class InstructionTantQueContext extends InstructionContext {
		public BlocContext alors;
		public TerminalNode TantQue() { return getToken(MiniCParser.TantQue, 0); }
		public TerminalNode ParentheseOuvrante() { return getToken(MiniCParser.ParentheseOuvrante, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ParentheseFermante() { return getToken(MiniCParser.ParentheseFermante, 0); }
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public InstructionTantQueContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterInstructionTantQue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitInstructionTantQue(this);
		}
	}
	public static class InstructionSiAlorsContext extends InstructionContext {
		public BlocContext alors;
		public TerminalNode Si() { return getToken(MiniCParser.Si, 0); }
		public TerminalNode ParentheseOuvrante() { return getToken(MiniCParser.ParentheseOuvrante, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ParentheseFermante() { return getToken(MiniCParser.ParentheseFermante, 0); }
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public InstructionSiAlorsContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterInstructionSiAlors(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitInstructionSiAlors(this);
		}
	}
	public static class InstructionArrayDeclarationContext extends InstructionContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifiantContext identifiant() {
			return getRuleContext(IdentifiantContext.class,0);
		}
		public TerminalNode CrochetOuvrant() { return getToken(MiniCParser.CrochetOuvrant, 0); }
		public TerminalNode Entier() { return getToken(MiniCParser.Entier, 0); }
		public TerminalNode CrochetFermant() { return getToken(MiniCParser.CrochetFermant, 0); }
		public TerminalNode PointVirgule() { return getToken(MiniCParser.PointVirgule, 0); }
		public TerminalNode DefinitionConstante() { return getToken(MiniCParser.DefinitionConstante, 0); }
		public InstructionArrayDeclarationContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterInstructionArrayDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitInstructionArrayDeclaration(this);
		}
	}
	public static class InstructionAffichageContext extends InstructionContext {
		public TerminalNode Afficher() { return getToken(MiniCParser.Afficher, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PointVirgule() { return getToken(MiniCParser.PointVirgule, 0); }
		public InstructionAffichageContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterInstructionAffichage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitInstructionAffichage(this);
		}
	}
	public static class InstructionDeclarationContext extends InstructionContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifiantContext identifiant() {
			return getRuleContext(IdentifiantContext.class,0);
		}
		public TerminalNode Egal() { return getToken(MiniCParser.Egal, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PointVirgule() { return getToken(MiniCParser.PointVirgule, 0); }
		public TerminalNode DefinitionConstante() { return getToken(MiniCParser.DefinitionConstante, 0); }
		public InstructionDeclarationContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterInstructionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitInstructionDeclaration(this);
		}
	}
	public static class InstructionTypeDeclarationContext extends InstructionContext {
		public TerminalNode DefinitionType() { return getToken(MiniCParser.DefinitionType, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifiantContext identifiant() {
			return getRuleContext(IdentifiantContext.class,0);
		}
		public TerminalNode PointVirgule() { return getToken(MiniCParser.PointVirgule, 0); }
		public InstructionTypeDeclarationContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterInstructionTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitInstructionTypeDeclaration(this);
		}
	}
	public static class InstructionFunctionDeclarationContext extends InstructionContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifiantContext identifiant() {
			return getRuleContext(IdentifiantContext.class,0);
		}
		public TerminalNode ParentheseOuvrante() { return getToken(MiniCParser.ParentheseOuvrante, 0); }
		public ParametresContext parametres() {
			return getRuleContext(ParametresContext.class,0);
		}
		public TerminalNode ParentheseFermante() { return getToken(MiniCParser.ParentheseFermante, 0); }
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public InstructionFunctionDeclarationContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterInstructionFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitInstructionFunctionDeclaration(this);
		}
	}
	public static class InstructionAffectationContext extends InstructionContext {
		public ExpressionContext valeur;
		public AffectableContext affectable() {
			return getRuleContext(AffectableContext.class,0);
		}
		public TerminalNode Egal() { return getToken(MiniCParser.Egal, 0); }
		public TerminalNode PointVirgule() { return getToken(MiniCParser.PointVirgule, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InstructionAffectationContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterInstructionAffectation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitInstructionAffectation(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instruction);
		try {
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new InstructionDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DefinitionConstante:
					{
					setState(52);
					match(DefinitionConstante);
					}
					break;
				case Enregistrement:
				case Enumeration:
				case Inferieur:
				case TypeEntier:
				case TypeFlottant:
				case TypeBooleen:
				case TypeCaractere:
				case TypeChaine:
				case TypeVide:
				case Identificateur:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(56);
				type();
				setState(57);
				identifiant(0);
				setState(58);
				match(Egal);
				setState(59);
				expression(0);
				setState(60);
				match(PointVirgule);
				}
				break;
			case 2:
				_localctx = new InstructionArrayDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DefinitionConstante:
					{
					setState(62);
					match(DefinitionConstante);
					}
					break;
				case Enregistrement:
				case Enumeration:
				case Inferieur:
				case TypeEntier:
				case TypeFlottant:
				case TypeBooleen:
				case TypeCaractere:
				case TypeChaine:
				case TypeVide:
				case Identificateur:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(66);
				type();
				setState(67);
				identifiant(0);
				setState(68);
				match(CrochetOuvrant);
				setState(69);
				match(Entier);
				setState(70);
				match(CrochetFermant);
				setState(71);
				match(PointVirgule);
				}
				break;
			case 3:
				_localctx = new InstructionTypeDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				match(DefinitionType);
				setState(74);
				type();
				setState(75);
				identifiant(0);
				setState(76);
				match(PointVirgule);
				}
				break;
			case 4:
				_localctx = new InstructionFunctionDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				type();
				setState(79);
				identifiant(0);
				setState(80);
				match(ParentheseOuvrante);
				setState(81);
				parametres();
				setState(82);
				match(ParentheseFermante);
				setState(83);
				bloc();
				}
				break;
			case 5:
				_localctx = new InstructionAffectationContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(85);
				affectable(0);
				setState(86);
				match(Egal);
				setState(87);
				((InstructionAffectationContext)_localctx).valeur = expression(0);
				setState(88);
				match(PointVirgule);
				}
				break;
			case 6:
				_localctx = new InstructionAffichageContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(90);
				match(Afficher);
				setState(91);
				expression(0);
				setState(92);
				match(PointVirgule);
				}
				break;
			case 7:
				_localctx = new InstructionSiSinonContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(94);
				match(Si);
				setState(95);
				match(ParentheseOuvrante);
				setState(96);
				expression(0);
				setState(97);
				match(ParentheseFermante);
				setState(98);
				((InstructionSiSinonContext)_localctx).alors = bloc();
				setState(99);
				match(Sinon);
				setState(100);
				((InstructionSiSinonContext)_localctx).sinon = bloc();
				}
				break;
			case 8:
				_localctx = new InstructionSiAlorsContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(102);
				match(Si);
				setState(103);
				match(ParentheseOuvrante);
				setState(104);
				expression(0);
				setState(105);
				match(ParentheseFermante);
				setState(106);
				((InstructionSiAlorsContext)_localctx).alors = bloc();
				}
				break;
			case 9:
				_localctx = new InstructionTantQueContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(108);
				match(TantQue);
				setState(109);
				match(ParentheseOuvrante);
				setState(110);
				expression(0);
				setState(111);
				match(ParentheseFermante);
				setState(112);
				((InstructionTantQueContext)_localctx).alors = bloc();
				}
				break;
			case 10:
				_localctx = new InstructionReturnContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(114);
				match(Retour);
				setState(115);
				expression(0);
				setState(116);
				match(PointVirgule);
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

	public static class AtomiqueContext extends ParserRuleContext {
		public AtomicType t;
		public TerminalNode TypeEntier() { return getToken(MiniCParser.TypeEntier, 0); }
		public TerminalNode TypeFlottant() { return getToken(MiniCParser.TypeFlottant, 0); }
		public TerminalNode TypeBooleen() { return getToken(MiniCParser.TypeBooleen, 0); }
		public TerminalNode TypeCaractere() { return getToken(MiniCParser.TypeCaractere, 0); }
		public TerminalNode TypeChaine() { return getToken(MiniCParser.TypeChaine, 0); }
		public TerminalNode TypeVide() { return getToken(MiniCParser.TypeVide, 0); }
		public AtomiqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomique; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterAtomique(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitAtomique(this);
		}
	}

	public final AtomiqueContext atomique() throws RecognitionException {
		AtomiqueContext _localctx = new AtomiqueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_atomique);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TypeEntier) | (1L << TypeFlottant) | (1L << TypeBooleen) | (1L << TypeCaractere) | (1L << TypeChaine) | (1L << TypeVide))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ChampContext extends ParserRuleContext {
		public FieldDeclaration f;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifiantContext identifiant() {
			return getRuleContext(IdentifiantContext.class,0);
		}
		public TerminalNode PointVirgule() { return getToken(MiniCParser.PointVirgule, 0); }
		public ChampContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_champ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterChamp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitChamp(this);
		}
	}

	public final ChampContext champ() throws RecognitionException {
		ChampContext _localctx = new ChampContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_champ);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			type();
			setState(123);
			identifiant(0);
			setState(124);
			match(PointVirgule);
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

	public static class EtiquettesContext extends ParserRuleContext {
		public List<LabelDeclaration> l;
		public Token premiere;
		public Token Identificateur;
		public List<Token> suite = new ArrayList<Token>();
		public List<TerminalNode> Identificateur() { return getTokens(MiniCParser.Identificateur); }
		public TerminalNode Identificateur(int i) {
			return getToken(MiniCParser.Identificateur, i);
		}
		public List<TerminalNode> Virgule() { return getTokens(MiniCParser.Virgule); }
		public TerminalNode Virgule(int i) {
			return getToken(MiniCParser.Virgule, i);
		}
		public EtiquettesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_etiquettes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterEtiquettes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitEtiquettes(this);
		}
	}

	public final EtiquettesContext etiquettes() throws RecognitionException {
		EtiquettesContext _localctx = new EtiquettesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_etiquettes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			((EtiquettesContext)_localctx).premiere = match(Identificateur);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Virgule) {
				{
				{
				setState(127);
				match(Virgule);
				setState(128);
				((EtiquettesContext)_localctx).Identificateur = match(Identificateur);
				((EtiquettesContext)_localctx).suite.add(((EtiquettesContext)_localctx).Identificateur);
				}
				}
				setState(133);
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

	public static class TypeContext extends ParserRuleContext {
		public Type t;
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
			this.t = ctx.t;
		}
	}
	public static class TypeEnumContext extends TypeContext {
		public TerminalNode Enumeration() { return getToken(MiniCParser.Enumeration, 0); }
		public TerminalNode Identificateur() { return getToken(MiniCParser.Identificateur, 0); }
		public TerminalNode AccoladeOuvrante() { return getToken(MiniCParser.AccoladeOuvrante, 0); }
		public EtiquettesContext etiquettes() {
			return getRuleContext(EtiquettesContext.class,0);
		}
		public TerminalNode AccoladeFermante() { return getToken(MiniCParser.AccoladeFermante, 0); }
		public TypeEnumContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterTypeEnum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitTypeEnum(this);
		}
	}
	public static class TypeNamedContext extends TypeContext {
		public TerminalNode Identificateur() { return getToken(MiniCParser.Identificateur, 0); }
		public TypeNamedContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterTypeNamed(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitTypeNamed(this);
		}
	}
	public static class TypeCoupleContext extends TypeContext {
		public TypeContext gauche;
		public TypeContext droite;
		public TerminalNode Inferieur() { return getToken(MiniCParser.Inferieur, 0); }
		public TerminalNode Virgule() { return getToken(MiniCParser.Virgule, 0); }
		public TerminalNode Superieur() { return getToken(MiniCParser.Superieur, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TypeCoupleContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterTypeCouple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitTypeCouple(this);
		}
	}
	public static class TypeAtomicContext extends TypeContext {
		public AtomiqueContext atomique() {
			return getRuleContext(AtomiqueContext.class,0);
		}
		public TypeAtomicContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterTypeAtomic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitTypeAtomic(this);
		}
	}
	public static class TypeRecordContext extends TypeContext {
		public ChampContext champ;
		public List<ChampContext> champs = new ArrayList<ChampContext>();
		public TerminalNode Enregistrement() { return getToken(MiniCParser.Enregistrement, 0); }
		public TerminalNode Identificateur() { return getToken(MiniCParser.Identificateur, 0); }
		public TerminalNode AccoladeOuvrante() { return getToken(MiniCParser.AccoladeOuvrante, 0); }
		public TerminalNode AccoladeFermante() { return getToken(MiniCParser.AccoladeFermante, 0); }
		public List<ChampContext> champ() {
			return getRuleContexts(ChampContext.class);
		}
		public ChampContext champ(int i) {
			return getRuleContext(ChampContext.class,i);
		}
		public TypeRecordContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterTypeRecord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitTypeRecord(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		int _la;
		try {
			setState(158);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TypeEntier:
			case TypeFlottant:
			case TypeBooleen:
			case TypeCaractere:
			case TypeChaine:
			case TypeVide:
				_localctx = new TypeAtomicContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				atomique();
				}
				break;
			case Identificateur:
				_localctx = new TypeNamedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				match(Identificateur);
				}
				break;
			case Inferieur:
				_localctx = new TypeCoupleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				match(Inferieur);
				setState(137);
				((TypeCoupleContext)_localctx).gauche = type();
				setState(138);
				match(Virgule);
				setState(139);
				((TypeCoupleContext)_localctx).droite = type();
				setState(140);
				match(Superieur);
				}
				break;
			case Enregistrement:
				_localctx = new TypeRecordContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(142);
				match(Enregistrement);
				setState(143);
				match(Identificateur);
				setState(144);
				match(AccoladeOuvrante);
				setState(146); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(145);
					((TypeRecordContext)_localctx).champ = champ();
					((TypeRecordContext)_localctx).champs.add(((TypeRecordContext)_localctx).champ);
					}
					}
					setState(148); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Enregistrement) | (1L << Enumeration) | (1L << Inferieur) | (1L << TypeEntier) | (1L << TypeFlottant) | (1L << TypeBooleen) | (1L << TypeCaractere) | (1L << TypeChaine) | (1L << TypeVide) | (1L << Identificateur))) != 0) );
				setState(150);
				match(AccoladeFermante);
				}
				break;
			case Enumeration:
				_localctx = new TypeEnumContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(152);
				match(Enumeration);
				setState(153);
				match(Identificateur);
				setState(154);
				match(AccoladeOuvrante);
				setState(155);
				etiquettes();
				setState(156);
				match(AccoladeFermante);
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

	public static class AffectableContext extends ParserRuleContext {
		public AssignableExpression a;
		public AffectableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_affectable; }
	 
		public AffectableContext() { }
		public void copyFrom(AffectableContext ctx) {
			super.copyFrom(ctx);
			this.a = ctx.a;
		}
	}
	public static class AffectableArrayContext extends AffectableContext {
		public AffectableContext affectable() {
			return getRuleContext(AffectableContext.class,0);
		}
		public TerminalNode CrochetOuvrant() { return getToken(MiniCParser.CrochetOuvrant, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CrochetFermant() { return getToken(MiniCParser.CrochetFermant, 0); }
		public AffectableArrayContext(AffectableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterAffectableArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitAffectableArray(this);
		}
	}
	public static class AffectableIdentifiantContext extends AffectableContext {
		public Token ident;
		public TerminalNode Identificateur() { return getToken(MiniCParser.Identificateur, 0); }
		public AffectableIdentifiantContext(AffectableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterAffectableIdentifiant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitAffectableIdentifiant(this);
		}
	}
	public static class AffectableFieldContext extends AffectableContext {
		public AffectableContext affectable() {
			return getRuleContext(AffectableContext.class,0);
		}
		public TerminalNode Point() { return getToken(MiniCParser.Point, 0); }
		public TerminalNode Identificateur() { return getToken(MiniCParser.Identificateur, 0); }
		public AffectableFieldContext(AffectableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterAffectableField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitAffectableField(this);
		}
	}
	public static class AffectablePointerContext extends AffectableContext {
		public TerminalNode Asterisque() { return getToken(MiniCParser.Asterisque, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AffectablePointerContext(AffectableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterAffectablePointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitAffectablePointer(this);
		}
	}
	public static class AffectableConversionContext extends AffectableContext {
		public TerminalNode ParentheseOuvrante() { return getToken(MiniCParser.ParentheseOuvrante, 0); }
		public TerminalNode ParentheseFermante() { return getToken(MiniCParser.ParentheseFermante, 0); }
		public AffectableContext affectable() {
			return getRuleContext(AffectableContext.class,0);
		}
		public TerminalNode Identificateur() { return getToken(MiniCParser.Identificateur, 0); }
		public AtomiqueContext atomique() {
			return getRuleContext(AtomiqueContext.class,0);
		}
		public AffectableConversionContext(AffectableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterAffectableConversion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitAffectableConversion(this);
		}
	}

	public final AffectableContext affectable() throws RecognitionException {
		return affectable(0);
	}

	private AffectableContext affectable(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AffectableContext _localctx = new AffectableContext(_ctx, _parentState);
		AffectableContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_affectable, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identificateur:
				{
				_localctx = new AffectableIdentifiantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(161);
				((AffectableIdentifiantContext)_localctx).ident = match(Identificateur);
				}
				break;
			case Asterisque:
				{
				_localctx = new AffectablePointerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162);
				match(Asterisque);
				setState(163);
				expression(0);
				}
				break;
			case ParentheseOuvrante:
				{
				_localctx = new AffectableConversionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(164);
				match(ParentheseOuvrante);
				setState(167);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Identificateur:
					{
					setState(165);
					match(Identificateur);
					}
					break;
				case TypeEntier:
				case TypeFlottant:
				case TypeBooleen:
				case TypeCaractere:
				case TypeChaine:
				case TypeVide:
					{
					setState(166);
					atomique();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(169);
				match(ParentheseFermante);
				setState(170);
				affectable(2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(183);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(181);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new AffectableArrayContext(new AffectableContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_affectable);
						setState(173);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(174);
						match(CrochetOuvrant);
						setState(175);
						expression(0);
						setState(176);
						match(CrochetFermant);
						}
						break;
					case 2:
						{
						_localctx = new AffectableFieldContext(new AffectableContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_affectable);
						setState(178);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(179);
						match(Point);
						setState(180);
						match(Identificateur);
						}
						break;
					}
					} 
				}
				setState(185);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class ExpressionsContext extends ParserRuleContext {
		public List<AccessibleExpression> l;
		public ExpressionContext premiere;
		public ExpressionContext expression;
		public List<ExpressionContext> suite = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Virgule() { return getTokens(MiniCParser.Virgule); }
		public TerminalNode Virgule(int i) {
			return getToken(MiniCParser.Virgule, i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressions(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			((ExpressionsContext)_localctx).premiere = expression(0);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Virgule) {
				{
				{
				setState(187);
				match(Virgule);
				setState(188);
				((ExpressionsContext)_localctx).expression = expression(0);
				((ExpressionsContext)_localctx).suite.add(((ExpressionsContext)_localctx).expression);
				}
				}
				setState(193);
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

	public static class ArgumentsContext extends ParserRuleContext {
		public List<AccessibleExpression> l;
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arguments);
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ParentheseFermante:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case AccoladeOuvrante:
			case ParentheseOuvrante:
			case Nouveau:
			case Asterisque:
			case Moins:
			case PointExclamation:
			case Inferieur:
			case Esperluette:
			case Vrai:
			case Faux:
			case Nul:
			case Premier:
			case Second:
			case Caractere:
			case Chaine:
			case Identificateur:
			case Entier:
			case Flottant:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				expressions();
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

	public static class ExpressionContext extends ParserRuleContext {
		public AccessibleExpression e;
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
			this.e = ctx.e;
		}
	}
	public static class ExpressionCharacterContext extends ExpressionContext {
		public TerminalNode Caractere() { return getToken(MiniCParser.Caractere, 0); }
		public ExpressionCharacterContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionCharacter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionCharacter(this);
		}
	}
	public static class ExpressionAddressContext extends ExpressionContext {
		public TerminalNode Esperluette() { return getToken(MiniCParser.Esperluette, 0); }
		public AffectableContext affectable() {
			return getRuleContext(AffectableContext.class,0);
		}
		public ExpressionAddressContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionAddress(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionAddress(this);
		}
	}
	public static class ExpressionOppositeContext extends ExpressionContext {
		public TerminalNode Moins() { return getToken(MiniCParser.Moins, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionOppositeContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionOpposite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionOpposite(this);
		}
	}
	public static class ExpressionParentheseContext extends ExpressionContext {
		public TerminalNode ParentheseOuvrante() { return getToken(MiniCParser.ParentheseOuvrante, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ParentheseFermante() { return getToken(MiniCParser.ParentheseFermante, 0); }
		public ExpressionParentheseContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionParenthese(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionParenthese(this);
		}
	}
	public static class ExpressionSequenceContext extends ExpressionContext {
		public TerminalNode AccoladeOuvrante() { return getToken(MiniCParser.AccoladeOuvrante, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public TerminalNode AccoladeFermante() { return getToken(MiniCParser.AccoladeFermante, 0); }
		public ExpressionSequenceContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionSequence(this);
		}
	}
	public static class ExpressionNotContext extends ExpressionContext {
		public ExpressionContext expr;
		public TerminalNode PointExclamation() { return getToken(MiniCParser.PointExclamation, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionNotContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionNot(this);
		}
	}
	public static class ExpressionConditionalContext extends ExpressionContext {
		public ExpressionContext condition;
		public ExpressionContext alors;
		public ExpressionContext sinon;
		public TerminalNode PointInterrogation() { return getToken(MiniCParser.PointInterrogation, 0); }
		public TerminalNode DeuxPoint() { return getToken(MiniCParser.DeuxPoint, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionConditionalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionConditional(this);
		}
	}
	public static class ExpressionAndContext extends ExpressionContext {
		public ExpressionContext gauche;
		public ExpressionContext droite;
		public TerminalNode DoubleEsperluette() { return getToken(MiniCParser.DoubleEsperluette, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionAndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionAnd(this);
		}
	}
	public static class ExpressionArrayAcessContext extends ExpressionContext {
		public ExpressionContext tableau;
		public ExpressionContext indice;
		public TerminalNode CrochetOuvrant() { return getToken(MiniCParser.CrochetOuvrant, 0); }
		public TerminalNode CrochetFermant() { return getToken(MiniCParser.CrochetFermant, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionArrayAcessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionArrayAcess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionArrayAcess(this);
		}
	}
	public static class ExpressionCoupleContext extends ExpressionContext {
		public ExpressionContext gauche;
		public ExpressionContext droite;
		public TerminalNode Inferieur() { return getToken(MiniCParser.Inferieur, 0); }
		public TerminalNode Virgule() { return getToken(MiniCParser.Virgule, 0); }
		public TerminalNode Superieur() { return getToken(MiniCParser.Superieur, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionCoupleContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionCouple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionCouple(this);
		}
	}
	public static class ExpressionAccessContext extends ExpressionContext {
		public TerminalNode Identificateur() { return getToken(MiniCParser.Identificateur, 0); }
		public ExpressionAccessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionAccess(this);
		}
	}
	public static class ExpressionFieldContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Point() { return getToken(MiniCParser.Point, 0); }
		public TerminalNode Identificateur() { return getToken(MiniCParser.Identificateur, 0); }
		public ExpressionFieldContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionField(this);
		}
	}
	public static class ExpressionNullContext extends ExpressionContext {
		public TerminalNode Nul() { return getToken(MiniCParser.Nul, 0); }
		public ExpressionNullContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionNull(this);
		}
	}
	public static class ExpressionPointerAccessContext extends ExpressionContext {
		public TerminalNode Asterisque() { return getToken(MiniCParser.Asterisque, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionPointerAccessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionPointerAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionPointerAccess(this);
		}
	}
	public static class ExpressionConversionContext extends ExpressionContext {
		public TerminalNode ParentheseOuvrante() { return getToken(MiniCParser.ParentheseOuvrante, 0); }
		public TerminalNode ParentheseFermante() { return getToken(MiniCParser.ParentheseFermante, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Identificateur() { return getToken(MiniCParser.Identificateur, 0); }
		public AtomiqueContext atomique() {
			return getRuleContext(AtomiqueContext.class,0);
		}
		public ExpressionConversionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionConversion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionConversion(this);
		}
	}
	public static class ExpressionEqualityContext extends ExpressionContext {
		public ExpressionContext gauche;
		public Token op;
		public ExpressionContext droite;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DoubleEgal() { return getToken(MiniCParser.DoubleEgal, 0); }
		public TerminalNode ExclamationEgal() { return getToken(MiniCParser.ExclamationEgal, 0); }
		public ExpressionEqualityContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionEquality(this);
		}
	}
	public static class ExpressionInequalityContext extends ExpressionContext {
		public ExpressionContext gauche;
		public Token op;
		public ExpressionContext droite;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Inferieur() { return getToken(MiniCParser.Inferieur, 0); }
		public TerminalNode InferieurEgal() { return getToken(MiniCParser.InferieurEgal, 0); }
		public TerminalNode Superieur() { return getToken(MiniCParser.Superieur, 0); }
		public TerminalNode SuperieurEgal() { return getToken(MiniCParser.SuperieurEgal, 0); }
		public ExpressionInequalityContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionInequality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionInequality(this);
		}
	}
	public static class ExpressionFirstContext extends ExpressionContext {
		public TerminalNode Premier() { return getToken(MiniCParser.Premier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionFirstContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionFirst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionFirst(this);
		}
	}
	public static class ExpressionFunctionCallContext extends ExpressionContext {
		public TerminalNode Identificateur() { return getToken(MiniCParser.Identificateur, 0); }
		public TerminalNode ParentheseOuvrante() { return getToken(MiniCParser.ParentheseOuvrante, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode ParentheseFermante() { return getToken(MiniCParser.ParentheseFermante, 0); }
		public ExpressionFunctionCallContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionFunctionCall(this);
		}
	}
	public static class ExpressionAdditiveContext extends ExpressionContext {
		public ExpressionContext gauche;
		public Token op;
		public ExpressionContext droite;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Plus() { return getToken(MiniCParser.Plus, 0); }
		public TerminalNode Moins() { return getToken(MiniCParser.Moins, 0); }
		public ExpressionAdditiveContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionAdditive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionAdditive(this);
		}
	}
	public static class ExpressionTrueContext extends ExpressionContext {
		public TerminalNode Vrai() { return getToken(MiniCParser.Vrai, 0); }
		public ExpressionTrueContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionTrue(this);
		}
	}
	public static class ExpressionMultiplicativeContext extends ExpressionContext {
		public ExpressionContext gauche;
		public Token op;
		public ExpressionContext droite;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Asterisque() { return getToken(MiniCParser.Asterisque, 0); }
		public TerminalNode Oblique() { return getToken(MiniCParser.Oblique, 0); }
		public TerminalNode PourCent() { return getToken(MiniCParser.PourCent, 0); }
		public ExpressionMultiplicativeContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionMultiplicative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionMultiplicative(this);
		}
	}
	public static class ExpressionFalseContext extends ExpressionContext {
		public TerminalNode Faux() { return getToken(MiniCParser.Faux, 0); }
		public ExpressionFalseContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionFalse(this);
		}
	}
	public static class ExpresionFloatContext extends ExpressionContext {
		public TerminalNode Flottant() { return getToken(MiniCParser.Flottant, 0); }
		public ExpresionFloatContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpresionFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpresionFloat(this);
		}
	}
	public static class ExpressionSecondContext extends ExpressionContext {
		public TerminalNode Second() { return getToken(MiniCParser.Second, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionSecondContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionSecond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionSecond(this);
		}
	}
	public static class ExpressionArrayAllocationContext extends ExpressionContext {
		public TerminalNode Nouveau() { return getToken(MiniCParser.Nouveau, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode CrochetOuvrant() { return getToken(MiniCParser.CrochetOuvrant, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CrochetFermant() { return getToken(MiniCParser.CrochetFermant, 0); }
		public ExpressionArrayAllocationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionArrayAllocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionArrayAllocation(this);
		}
	}
	public static class ExpressionStringContext extends ExpressionContext {
		public TerminalNode Chaine() { return getToken(MiniCParser.Chaine, 0); }
		public ExpressionStringContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionString(this);
		}
	}
	public static class ExpressionOrContext extends ExpressionContext {
		public ExpressionContext gauche;
		public ExpressionContext droite;
		public TerminalNode DoubleBarre() { return getToken(MiniCParser.DoubleBarre, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionOrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionOr(this);
		}
	}
	public static class ExpressionPointerAllocationContext extends ExpressionContext {
		public TerminalNode Nouveau() { return getToken(MiniCParser.Nouveau, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ParentheseOuvrante() { return getToken(MiniCParser.ParentheseOuvrante, 0); }
		public TerminalNode ParentheseFermante() { return getToken(MiniCParser.ParentheseFermante, 0); }
		public ExpressionPointerAllocationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionPointerAllocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionPointerAllocation(this);
		}
	}
	public static class ExpressionIntContext extends ExpressionContext {
		public TerminalNode Entier() { return getToken(MiniCParser.Entier, 0); }
		public ExpressionIntContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterExpressionInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitExpressionInt(this);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new ExpressionParentheseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(199);
				match(ParentheseOuvrante);
				setState(200);
				expression(0);
				setState(201);
				match(ParentheseFermante);
				}
				break;
			case 2:
				{
				_localctx = new ExpressionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203);
				match(PointExclamation);
				setState(204);
				((ExpressionNotContext)_localctx).expr = expression(27);
				}
				break;
			case 3:
				{
				_localctx = new ExpressionFirstContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(205);
				match(Premier);
				setState(206);
				expression(26);
				}
				break;
			case 4:
				{
				_localctx = new ExpressionSecondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(207);
				match(Second);
				setState(208);
				expression(25);
				}
				break;
			case 5:
				{
				_localctx = new ExpressionOppositeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209);
				match(Moins);
				setState(210);
				expression(24);
				}
				break;
			case 6:
				{
				_localctx = new ExpressionArrayAllocationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211);
				match(Nouveau);
				setState(212);
				type();
				setState(213);
				match(CrochetOuvrant);
				setState(214);
				expression(0);
				setState(215);
				match(CrochetFermant);
				}
				break;
			case 7:
				{
				_localctx = new ExpressionPointerAllocationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				match(Nouveau);
				setState(218);
				type();
				setState(219);
				match(ParentheseOuvrante);
				setState(220);
				match(ParentheseFermante);
				}
				break;
			case 8:
				{
				_localctx = new ExpressionSequenceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222);
				match(AccoladeOuvrante);
				setState(223);
				expressions();
				setState(224);
				match(AccoladeFermante);
				}
				break;
			case 9:
				{
				_localctx = new ExpressionCoupleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226);
				match(Inferieur);
				setState(227);
				((ExpressionCoupleContext)_localctx).gauche = expression(0);
				setState(228);
				match(Virgule);
				setState(229);
				((ExpressionCoupleContext)_localctx).droite = expression(0);
				setState(230);
				match(Superieur);
				}
				break;
			case 10:
				{
				_localctx = new ExpressionFunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232);
				match(Identificateur);
				setState(233);
				match(ParentheseOuvrante);
				setState(234);
				arguments();
				setState(235);
				match(ParentheseFermante);
				}
				break;
			case 11:
				{
				_localctx = new ExpressionPointerAccessContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237);
				match(Asterisque);
				setState(238);
				expression(11);
				}
				break;
			case 12:
				{
				_localctx = new ExpressionAddressContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(239);
				match(Esperluette);
				setState(240);
				affectable(0);
				}
				break;
			case 13:
				{
				_localctx = new ExpressionConversionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(241);
				match(ParentheseOuvrante);
				setState(244);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Identificateur:
					{
					setState(242);
					match(Identificateur);
					}
					break;
				case TypeEntier:
				case TypeFlottant:
				case TypeBooleen:
				case TypeCaractere:
				case TypeChaine:
				case TypeVide:
					{
					setState(243);
					atomique();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(246);
				match(ParentheseFermante);
				setState(247);
				expression(9);
				}
				break;
			case 14:
				{
				_localctx = new ExpressionTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(248);
				match(Vrai);
				}
				break;
			case 15:
				{
				_localctx = new ExpressionFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(249);
				match(Faux);
				}
				break;
			case 16:
				{
				_localctx = new ExpressionIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(250);
				match(Entier);
				}
				break;
			case 17:
				{
				_localctx = new ExpresionFloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(251);
				match(Flottant);
				}
				break;
			case 18:
				{
				_localctx = new ExpressionCharacterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(252);
				match(Caractere);
				}
				break;
			case 19:
				{
				_localctx = new ExpressionStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(253);
				match(Chaine);
				}
				break;
			case 20:
				{
				_localctx = new ExpressionNullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(254);
				match(Nul);
				}
				break;
			case 21:
				{
				_localctx = new ExpressionAccessContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(255);
				match(Identificateur);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(292);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(290);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionMultiplicativeContext(new ExpressionContext(_parentctx, _parentState));
						((ExpressionMultiplicativeContext)_localctx).gauche = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(258);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(259);
						((ExpressionMultiplicativeContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Asterisque) | (1L << Oblique) | (1L << PourCent))) != 0)) ) {
							((ExpressionMultiplicativeContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(260);
						((ExpressionMultiplicativeContext)_localctx).droite = expression(22);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionAdditiveContext(new ExpressionContext(_parentctx, _parentState));
						((ExpressionAdditiveContext)_localctx).gauche = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(261);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(262);
						((ExpressionAdditiveContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Moins) ) {
							((ExpressionAdditiveContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(263);
						((ExpressionAdditiveContext)_localctx).droite = expression(21);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionInequalityContext(new ExpressionContext(_parentctx, _parentState));
						((ExpressionInequalityContext)_localctx).gauche = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(264);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(265);
						((ExpressionInequalityContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Inferieur) | (1L << Superieur) | (1L << InferieurEgal) | (1L << SuperieurEgal))) != 0)) ) {
							((ExpressionInequalityContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(266);
						((ExpressionInequalityContext)_localctx).droite = expression(20);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionEqualityContext(new ExpressionContext(_parentctx, _parentState));
						((ExpressionEqualityContext)_localctx).gauche = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(267);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(268);
						((ExpressionEqualityContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==DoubleEgal || _la==ExclamationEgal) ) {
							((ExpressionEqualityContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(269);
						((ExpressionEqualityContext)_localctx).droite = expression(19);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionAndContext(new ExpressionContext(_parentctx, _parentState));
						((ExpressionAndContext)_localctx).gauche = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(270);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(271);
						match(DoubleEsperluette);
						setState(272);
						((ExpressionAndContext)_localctx).droite = expression(18);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionOrContext(new ExpressionContext(_parentctx, _parentState));
						((ExpressionOrContext)_localctx).gauche = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(273);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(274);
						match(DoubleBarre);
						setState(275);
						((ExpressionOrContext)_localctx).droite = expression(17);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionConditionalContext(new ExpressionContext(_parentctx, _parentState));
						((ExpressionConditionalContext)_localctx).condition = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(276);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(277);
						match(PointInterrogation);
						setState(278);
						((ExpressionConditionalContext)_localctx).alors = expression(0);
						setState(279);
						match(DeuxPoint);
						setState(280);
						((ExpressionConditionalContext)_localctx).sinon = expression(16);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionFieldContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(282);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(283);
						match(Point);
						setState(284);
						match(Identificateur);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionArrayAcessContext(new ExpressionContext(_parentctx, _parentState));
						((ExpressionArrayAcessContext)_localctx).tableau = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(285);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(286);
						match(CrochetOuvrant);
						setState(287);
						((ExpressionArrayAcessContext)_localctx).indice = expression(0);
						setState(288);
						match(CrochetFermant);
						}
						break;
					}
					} 
				}
				setState(294);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class IdentifiantContext extends ParserRuleContext {
		public fr.n7.stl.util.Pair<String, PartialType> id;
		public TerminalNode Asterisque() { return getToken(MiniCParser.Asterisque, 0); }
		public IdentifiantContext identifiant() {
			return getRuleContext(IdentifiantContext.class,0);
		}
		public TerminalNode ParentheseOuvrante() { return getToken(MiniCParser.ParentheseOuvrante, 0); }
		public TerminalNode ParentheseFermante() { return getToken(MiniCParser.ParentheseFermante, 0); }
		public TerminalNode Identificateur() { return getToken(MiniCParser.Identificateur, 0); }
		public TerminalNode CrochetOuvrant() { return getToken(MiniCParser.CrochetOuvrant, 0); }
		public TerminalNode CrochetFermant() { return getToken(MiniCParser.CrochetFermant, 0); }
		public IdentifiantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifiant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).enterIdentifiant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCParserListener ) ((MiniCParserListener)listener).exitIdentifiant(this);
		}
	}

	public final IdentifiantContext identifiant() throws RecognitionException {
		return identifiant(0);
	}

	private IdentifiantContext identifiant(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IdentifiantContext _localctx = new IdentifiantContext(_ctx, _parentState);
		IdentifiantContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_identifiant, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Asterisque:
				{
				setState(296);
				match(Asterisque);
				setState(297);
				identifiant(3);
				}
				break;
			case ParentheseOuvrante:
				{
				setState(298);
				match(ParentheseOuvrante);
				setState(299);
				identifiant(0);
				setState(300);
				match(ParentheseFermante);
				}
				break;
			case Identificateur:
				{
				setState(302);
				match(Identificateur);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(310);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new IdentifiantContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_identifiant);
					setState(305);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(306);
					match(CrochetOuvrant);
					setState(307);
					match(CrochetFermant);
					}
					} 
				}
				setState(312);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return affectable_sempred((AffectableContext)_localctx, predIndex);
		case 11:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 12:
			return identifiant_sempred((IdentifiantContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean affectable_sempred(AffectableContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 21);
		case 3:
			return precpred(_ctx, 20);
		case 4:
			return precpred(_ctx, 19);
		case 5:
			return precpred(_ctx, 18);
		case 6:
			return precpred(_ctx, 17);
		case 7:
			return precpred(_ctx, 16);
		case 8:
			return precpred(_ctx, 15);
		case 9:
			return precpred(_ctx, 29);
		case 10:
			return precpred(_ctx, 28);
		}
		return true;
	}
	private boolean identifiant_sempred(IdentifiantContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3:\u013c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\3\3\3\7\3\"\n\3\f\3\16\3%"+
		"\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\60\n\4\f\4\16\4\63\13\4"+
		"\5\4\65\n\4\3\5\3\5\5\59\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5C\n\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5y\n\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\7\b\u0084\n\b\f\b\16\b\u0087"+
		"\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\6\t\u0095\n\t\r"+
		"\t\16\t\u0096\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00a1\n\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\5\n\u00aa\n\n\3\n\3\n\5\n\u00ae\n\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\7\n\u00b8\n\n\f\n\16\n\u00bb\13\n\3\13\3\13\3\13\7\13"+
		"\u00c0\n\13\f\13\16\13\u00c3\13\13\3\f\3\f\5\f\u00c7\n\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00f7\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u0103\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\7\r\u0125\n\r\f\r\16\r\u0128\13\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\5\16\u0132\n\16\3\16\3\16\3\16\7\16\u0137\n\16\f"+
		"\16\16\16\u013a\13\16\3\16\2\5\22\30\32\17\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\2\7\3\2(-\3\2\31\33\3\2\34\35\3\2!$\3\2%&\2\u016a\2\34\3\2\2\2"+
		"\4\37\3\2\2\2\6\64\3\2\2\2\bx\3\2\2\2\nz\3\2\2\2\f|\3\2\2\2\16\u0080\3"+
		"\2\2\2\20\u00a0\3\2\2\2\22\u00ad\3\2\2\2\24\u00bc\3\2\2\2\26\u00c6\3\2"+
		"\2\2\30\u0102\3\2\2\2\32\u0131\3\2\2\2\34\35\7\65\2\2\35\36\5\4\3\2\36"+
		"\3\3\2\2\2\37#\7\4\2\2 \"\5\b\5\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2"+
		"\2\2$&\3\2\2\2%#\3\2\2\2&\'\7\5\2\2\'\5\3\2\2\2(\65\3\2\2\2)*\5\20\t\2"+
		"*\61\5\32\16\2+,\7\r\2\2,-\5\20\t\2-.\5\32\16\2.\60\3\2\2\2/+\3\2\2\2"+
		"\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\64"+
		"(\3\2\2\2\64)\3\2\2\2\65\7\3\2\2\2\669\7\23\2\2\679\3\2\2\28\66\3\2\2"+
		"\28\67\3\2\2\29:\3\2\2\2:;\5\20\t\2;<\5\32\16\2<=\7\3\2\2=>\5\30\r\2>"+
		"?\7\16\2\2?y\3\2\2\2@C\7\23\2\2AC\3\2\2\2B@\3\2\2\2BA\3\2\2\2CD\3\2\2"+
		"\2DE\5\20\t\2EF\5\32\16\2FG\7\b\2\2GH\7\66\2\2HI\7\t\2\2IJ\7\16\2\2Jy"+
		"\3\2\2\2KL\7\24\2\2LM\5\20\t\2MN\5\32\16\2NO\7\16\2\2Oy\3\2\2\2PQ\5\20"+
		"\t\2QR\5\32\16\2RS\7\6\2\2ST\5\6\4\2TU\7\7\2\2UV\5\4\3\2Vy\3\2\2\2WX\5"+
		"\22\n\2XY\7\3\2\2YZ\5\30\r\2Z[\7\16\2\2[y\3\2\2\2\\]\7\17\2\2]^\5\30\r"+
		"\2^_\7\16\2\2_y\3\2\2\2`a\7\20\2\2ab\7\6\2\2bc\5\30\r\2cd\7\7\2\2de\5"+
		"\4\3\2ef\7\21\2\2fg\5\4\3\2gy\3\2\2\2hi\7\20\2\2ij\7\6\2\2jk\5\30\r\2"+
		"kl\7\7\2\2lm\5\4\3\2my\3\2\2\2no\7\30\2\2op\7\6\2\2pq\5\30\r\2qr\7\7\2"+
		"\2rs\5\4\3\2sy\3\2\2\2tu\7\22\2\2uv\5\30\r\2vw\7\16\2\2wy\3\2\2\2x8\3"+
		"\2\2\2xB\3\2\2\2xK\3\2\2\2xP\3\2\2\2xW\3\2\2\2x\\\3\2\2\2x`\3\2\2\2xh"+
		"\3\2\2\2xn\3\2\2\2xt\3\2\2\2y\t\3\2\2\2z{\t\2\2\2{\13\3\2\2\2|}\5\20\t"+
		"\2}~\5\32\16\2~\177\7\16\2\2\177\r\3\2\2\2\u0080\u0085\7\65\2\2\u0081"+
		"\u0082\7\r\2\2\u0082\u0084\7\65\2\2\u0083\u0081\3\2\2\2\u0084\u0087\3"+
		"\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\17\3\2\2\2\u0087"+
		"\u0085\3\2\2\2\u0088\u00a1\5\n\6\2\u0089\u00a1\7\65\2\2\u008a\u008b\7"+
		"!\2\2\u008b\u008c\5\20\t\2\u008c\u008d\7\r\2\2\u008d\u008e\5\20\t\2\u008e"+
		"\u008f\7\"\2\2\u008f\u00a1\3\2\2\2\u0090\u0091\7\25\2\2\u0091\u0092\7"+
		"\65\2\2\u0092\u0094\7\4\2\2\u0093\u0095\5\f\7\2\u0094\u0093\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u0099\7\5\2\2\u0099\u00a1\3\2\2\2\u009a\u009b\7\26\2\2\u009b"+
		"\u009c\7\65\2\2\u009c\u009d\7\4\2\2\u009d\u009e\5\16\b\2\u009e\u009f\7"+
		"\5\2\2\u009f\u00a1\3\2\2\2\u00a0\u0088\3\2\2\2\u00a0\u0089\3\2\2\2\u00a0"+
		"\u008a\3\2\2\2\u00a0\u0090\3\2\2\2\u00a0\u009a\3\2\2\2\u00a1\21\3\2\2"+
		"\2\u00a2\u00a3\b\n\1\2\u00a3\u00ae\7\65\2\2\u00a4\u00a5\7\31\2\2\u00a5"+
		"\u00ae\5\30\r\2\u00a6\u00a9\7\6\2\2\u00a7\u00aa\7\65\2\2\u00a8\u00aa\5"+
		"\n\6\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\u00ac\7\7\2\2\u00ac\u00ae\5\22\n\4\u00ad\u00a2\3\2\2\2\u00ad\u00a4\3"+
		"\2\2\2\u00ad\u00a6\3\2\2\2\u00ae\u00b9\3\2\2\2\u00af\u00b0\f\5\2\2\u00b0"+
		"\u00b1\7\b\2\2\u00b1\u00b2\5\30\r\2\u00b2\u00b3\7\t\2\2\u00b3\u00b8\3"+
		"\2\2\2\u00b4\u00b5\f\3\2\2\u00b5\u00b6\7\n\2\2\u00b6\u00b8\7\65\2\2\u00b7"+
		"\u00af\3\2\2\2\u00b7\u00b4\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2"+
		"\2\2\u00b9\u00ba\3\2\2\2\u00ba\23\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00c1"+
		"\5\30\r\2\u00bd\u00be\7\r\2\2\u00be\u00c0\5\30\r\2\u00bf\u00bd\3\2\2\2"+
		"\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\25"+
		"\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c7\5\24\13\2"+
		"\u00c6\u00c4\3\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\27\3\2\2\2\u00c8\u00c9"+
		"\b\r\1\2\u00c9\u00ca\7\6\2\2\u00ca\u00cb\5\30\r\2\u00cb\u00cc\7\7\2\2"+
		"\u00cc\u0103\3\2\2\2\u00cd\u00ce\7 \2\2\u00ce\u0103\5\30\r\35\u00cf\u00d0"+
		"\7\61\2\2\u00d0\u0103\5\30\r\34\u00d1\u00d2\7\62\2\2\u00d2\u0103\5\30"+
		"\r\33\u00d3\u00d4\7\35\2\2\u00d4\u0103\5\30\r\32\u00d5\u00d6\7\27\2\2"+
		"\u00d6\u00d7\5\20\t\2\u00d7\u00d8\7\b\2\2\u00d8\u00d9\5\30\r\2\u00d9\u00da"+
		"\7\t\2\2\u00da\u0103\3\2\2\2\u00db\u00dc\7\27\2\2\u00dc\u00dd\5\20\t\2"+
		"\u00dd\u00de\7\6\2\2\u00de\u00df\7\7\2\2\u00df\u0103\3\2\2\2\u00e0\u00e1"+
		"\7\4\2\2\u00e1\u00e2\5\24\13\2\u00e2\u00e3\7\5\2\2\u00e3\u0103\3\2\2\2"+
		"\u00e4\u00e5\7!\2\2\u00e5\u00e6\5\30\r\2\u00e6\u00e7\7\r\2\2\u00e7\u00e8"+
		"\5\30\r\2\u00e8\u00e9\7\"\2\2\u00e9\u0103\3\2\2\2\u00ea\u00eb\7\65\2\2"+
		"\u00eb\u00ec\7\6\2\2\u00ec\u00ed\5\26\f\2\u00ed\u00ee\7\7\2\2\u00ee\u0103"+
		"\3\2\2\2\u00ef\u00f0\7\31\2\2\u00f0\u0103\5\30\r\r\u00f1\u00f2\7\'\2\2"+
		"\u00f2\u0103\5\22\n\2\u00f3\u00f6\7\6\2\2\u00f4\u00f7\7\65\2\2\u00f5\u00f7"+
		"\5\n\6\2\u00f6\u00f4\3\2\2\2\u00f6\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"\u00f9\7\7\2\2\u00f9\u0103\5\30\r\13\u00fa\u0103\7.\2\2\u00fb\u0103\7"+
		"/\2\2\u00fc\u0103\7\66\2\2\u00fd\u0103\7\67\2\2\u00fe\u0103\7\63\2\2\u00ff"+
		"\u0103\7\64\2\2\u0100\u0103\7\60\2\2\u0101\u0103\7\65\2\2\u0102\u00c8"+
		"\3\2\2\2\u0102\u00cd\3\2\2\2\u0102\u00cf\3\2\2\2\u0102\u00d1\3\2\2\2\u0102"+
		"\u00d3\3\2\2\2\u0102\u00d5\3\2\2\2\u0102\u00db\3\2\2\2\u0102\u00e0\3\2"+
		"\2\2\u0102\u00e4\3\2\2\2\u0102\u00ea\3\2\2\2\u0102\u00ef\3\2\2\2\u0102"+
		"\u00f1\3\2\2\2\u0102\u00f3\3\2\2\2\u0102\u00fa\3\2\2\2\u0102\u00fb\3\2"+
		"\2\2\u0102\u00fc\3\2\2\2\u0102\u00fd\3\2\2\2\u0102\u00fe\3\2\2\2\u0102"+
		"\u00ff\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0101\3\2\2\2\u0103\u0126\3\2"+
		"\2\2\u0104\u0105\f\27\2\2\u0105\u0106\t\3\2\2\u0106\u0125\5\30\r\30\u0107"+
		"\u0108\f\26\2\2\u0108\u0109\t\4\2\2\u0109\u0125\5\30\r\27\u010a\u010b"+
		"\f\25\2\2\u010b\u010c\t\5\2\2\u010c\u0125\5\30\r\26\u010d\u010e\f\24\2"+
		"\2\u010e\u010f\t\6\2\2\u010f\u0125\5\30\r\25\u0110\u0111\f\23\2\2\u0111"+
		"\u0112\7\37\2\2\u0112\u0125\5\30\r\24\u0113\u0114\f\22\2\2\u0114\u0115"+
		"\7\36\2\2\u0115\u0125\5\30\r\23\u0116\u0117\f\21\2\2\u0117\u0118\7\13"+
		"\2\2\u0118\u0119\5\30\r\2\u0119\u011a\7\f\2\2\u011a\u011b\5\30\r\22\u011b"+
		"\u0125\3\2\2\2\u011c\u011d\f\37\2\2\u011d\u011e\7\n\2\2\u011e\u0125\7"+
		"\65\2\2\u011f\u0120\f\36\2\2\u0120\u0121\7\b\2\2\u0121\u0122\5\30\r\2"+
		"\u0122\u0123\7\t\2\2\u0123\u0125\3\2\2\2\u0124\u0104\3\2\2\2\u0124\u0107"+
		"\3\2\2\2\u0124\u010a\3\2\2\2\u0124\u010d\3\2\2\2\u0124\u0110\3\2\2\2\u0124"+
		"\u0113\3\2\2\2\u0124\u0116\3\2\2\2\u0124\u011c\3\2\2\2\u0124\u011f\3\2"+
		"\2\2\u0125\u0128\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127"+
		"\31\3\2\2\2\u0128\u0126\3\2\2\2\u0129\u012a\b\16\1\2\u012a\u012b\7\31"+
		"\2\2\u012b\u0132\5\32\16\5\u012c\u012d\7\6\2\2\u012d\u012e\5\32\16\2\u012e"+
		"\u012f\7\7\2\2\u012f\u0132\3\2\2\2\u0130\u0132\7\65\2\2\u0131\u0129\3"+
		"\2\2\2\u0131\u012c\3\2\2\2\u0131\u0130\3\2\2\2\u0132\u0138\3\2\2\2\u0133"+
		"\u0134\f\6\2\2\u0134\u0135\7\b\2\2\u0135\u0137\7\t\2\2\u0136\u0133\3\2"+
		"\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139"+
		"\33\3\2\2\2\u013a\u0138\3\2\2\2\27#\61\648Bx\u0085\u0096\u00a0\u00a9\u00ad"+
		"\u00b7\u00b9\u00c1\u00c6\u00f6\u0102\u0124\u0126\u0131\u0138";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}