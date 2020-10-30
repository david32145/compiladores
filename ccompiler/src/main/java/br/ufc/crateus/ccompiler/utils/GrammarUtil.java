package br.ufc.crateus.ccompiler.utils;

import java.util.Arrays;
import br.ufc.crateus.ccompiler.lexical.Lexeme;
import br.ufc.crateus.ccompiler.syntactic.Grammar;
import br.ufc.crateus.ccompiler.syntactic.NoTerminal;
import br.ufc.crateus.ccompiler.syntactic.Rule;
import br.ufc.crateus.ccompiler.syntactic.Rule.RuleBuilder;
import br.ufc.crateus.ccompiler.syntactic.constants.Productions;
import br.ufc.crateus.ccompiler.syntactic.constants.Tags;
import br.ufc.crateus.ccompiler.syntactic.productions.Production;
import br.ufc.crateus.ccompiler.syntactic.productions.ProductionType;

public class GrammarUtil {
	public static final Grammar getGrammar() {
		final NoTerminal P = new NoTerminal(Tags.P);
		final NoTerminal E = new NoTerminal(Tags.E);
		final NoTerminal E_1 = new NoTerminal(Tags.E_1);
		final NoTerminal IF_ST = new NoTerminal(Tags.IF_ST);
		final NoTerminal B = new NoTerminal(Tags.B);
		final NoTerminal VAR = new NoTerminal(Tags.VAR);
		final NoTerminal STMT = new NoTerminal(Tags.STMT);
		final NoTerminal STMT_LIST = new NoTerminal(Tags.STMT_LIST);

		Production p1 = Production.of(Productions.P1,
				ProductionType.ofTerminal(Lexeme.VOID),
				ProductionType.ofTerminal(Lexeme.MAIN),
				ProductionType.ofTerminal(Lexeme.OPEN_PARENTHESIS),
				ProductionType.ofTerminal(Lexeme.CLOSE_PARENTHESIS),
				ProductionType.ofNoTerminal(B));
		Production p2 = Production.of(Productions.P2,
				ProductionType.ofTerminal(Lexeme.ID),
				ProductionType.ofTerminal(Lexeme.OPERATOR_ASSIGN),
				ProductionType.ofNoTerminal(E));
		Production p3 = Production.of(Productions.P3,
				ProductionType.ofTerminal(Lexeme.OPERATOR_NOT),
				ProductionType.ofNoTerminal(E),
				ProductionType.ofNoTerminal(E_1));
		Production p4 = Production.of(Productions.P4,
				ProductionType.ofTerminal(Lexeme.OPERATOR_SUB),
				ProductionType.ofNoTerminal(E),
				ProductionType.ofNoTerminal(E_1));
		Production p5 = Production.of(Productions.P5,
				ProductionType.ofTerminal(Lexeme.OPERATOR_SUM),
				ProductionType.ofNoTerminal(E),
				ProductionType.ofNoTerminal(E_1));
		Production p6 = Production.of(Productions.P6,
				ProductionType.ofTerminal(Lexeme.OPEN_PARENTHESIS),
				ProductionType.ofNoTerminal(E),
				ProductionType.ofTerminal(Lexeme.CLOSE_PARENTHESIS),
				ProductionType.ofNoTerminal(E_1));
		Production p8 = Production.of(Productions.P8,
				ProductionType.ofTerminal(Lexeme.INT_LITERAL),
				ProductionType.ofNoTerminal(E_1));
		Production p9 = Production.of(Productions.P9,
				ProductionType.ofTerminal(Lexeme.CHAR_LITERAL),
				ProductionType.ofNoTerminal(E_1));
		Production p10 = Production.of(Productions.P10,
				ProductionType.ofTerminal(Lexeme.FLOAT_LITERAL),
				ProductionType.ofNoTerminal(E_1));
		Production p11 = Production.of(Productions.P11,
				ProductionType.ofTerminal(Lexeme.STRING_LITERAL),
				ProductionType.ofNoTerminal(E_1));
		Production p12 = Production.of(Productions.P12,
				ProductionType.ofTerminal(Lexeme.OPERATOR_OR),
				ProductionType.ofNoTerminal(E));
		Production p13 = Production.of(Productions.P13,
				ProductionType.ofTerminal(Lexeme.OPERATOR_EQUAL),
				ProductionType.ofNoTerminal(E));
		Production p14 = Production.of(Productions.P14,
				ProductionType.ofTerminal(Lexeme.OPERATOR_DIFFERENT),
				ProductionType.ofNoTerminal(E));
		Production p15 = Production.of(Productions.P15,
				ProductionType.ofTerminal(Lexeme.OPERATOR_LESS_OR_EQUAL),
				ProductionType.ofNoTerminal(E));
		Production p16 = Production.of(Productions.P16,
				ProductionType.ofTerminal(Lexeme.OPERATOR_LESS),
				ProductionType.ofNoTerminal(E));
		Production p17 = Production.of(Productions.P17,
				ProductionType.ofTerminal(Lexeme.OPERATOR_GREATER_OR_EQUAL),
				ProductionType.ofNoTerminal(E));
		Production p18 = Production.of(Productions.P18,
				ProductionType.ofTerminal(Lexeme.OPERATOR_GREATER),
				ProductionType.ofNoTerminal(E));
		Production p19 = Production.of(Productions.P19,
				ProductionType.ofTerminal(Lexeme.OPERATOR_AND),
				ProductionType.ofNoTerminal(E));
		Production p20 = Production.of(Productions.P20,
				ProductionType.ofTerminal(Lexeme.OPERATOR_SUM),
				ProductionType.ofNoTerminal(E));
		Production p21 = Production.of(Productions.P21,
				ProductionType.ofTerminal(Lexeme.OPERATOR_SUB),
				ProductionType.ofNoTerminal(E));
		Production p22 = Production.of(Productions.P22,
				ProductionType.ofTerminal(Lexeme.OPERATOR_MULTIPLY),
				ProductionType.ofNoTerminal(E));
		Production p23 = Production.of(Productions.P23,
				ProductionType.ofTerminal(Lexeme.OPERATOR_DIVISION),
				ProductionType.ofNoTerminal(E));
		Production p24 = Production.of(Productions.P24,
				ProductionType.ofTerminal(Lexeme.OPERATOR_REST),
				ProductionType.ofNoTerminal(E));
		Production p25 = Production.of(Productions.P25,
				ProductionType.ofTerminal(Lexeme.SEMICOLON));
		Production p26 = Production.of(Productions.P26,
				ProductionType.ofTerminal(Lexeme.IF),
				ProductionType.ofTerminal(Lexeme.OPEN_PARENTHESIS),
				ProductionType.ofNoTerminal(E),
				ProductionType.ofTerminal(Lexeme.CLOSE_PARENTHESIS),
				ProductionType.ofNoTerminal(STMT),
				ProductionType.ofTerminal(Lexeme.ELSE),
				ProductionType.ofNoTerminal(STMT));
		Production p27 = Production.of(Productions.P27,
				ProductionType.ofTerminal(Lexeme.OPEN_KEY),
				ProductionType.ofNoTerminal(STMT_LIST),
				ProductionType.ofTerminal(Lexeme.CLOSE_KEY));
		Production p28 = Production.of(Productions.P28,
				ProductionType.ofTerminal(Lexeme.INT),
				ProductionType.ofTerminal(Lexeme.ID),
				ProductionType.ofTerminal(Lexeme.SEMICOLON));
		Production p29 = Production.of(Productions.P29,
				ProductionType.ofNoTerminal(E));
		Production p30 = Production.of(Productions.P30,
				ProductionType.ofNoTerminal(IF_ST));
		Production p31 = Production.of(Productions.P31,
				ProductionType.ofNoTerminal(B));
		Production p32 = Production.of(Productions.P32,
				ProductionType.ofNoTerminal(VAR));
		Production p33 = Production.of(Productions.P33,
				ProductionType.ofNoTerminal(STMT),
				ProductionType.ofNoTerminal(STMT_LIST));
		Production p34 = Production.of(Productions.P34);
		Production p35 = Production.of(Productions.P35);

		Rule r1 = RuleBuilder.of(P).produce(p1);
		Rule r2 = RuleBuilder.of(E).produce(p2);
		Rule r3 = RuleBuilder.of(E).produce(p3);
		Rule r4 = RuleBuilder.of(E).produce(p4);
		Rule r5 = RuleBuilder.of(E).produce(p5);
		Rule r6 = RuleBuilder.of(E).produce(p6);
		Rule r8 = RuleBuilder.of(E).produce(p8);
		Rule r9 = RuleBuilder.of(E).produce(p9);
		Rule r10 = RuleBuilder.of(E).produce(p10);
		Rule r11 = RuleBuilder.of(E).produce(p11);
		Rule r12 = RuleBuilder.of(E_1).produce(p12);
		Rule r13 = RuleBuilder.of(E_1).produce(p13);
		Rule r14 = RuleBuilder.of(E_1).produce(p14);
		Rule r15 = RuleBuilder.of(E_1).produce(p15);
		Rule r16 = RuleBuilder.of(E_1).produce(p16);
		Rule r17 = RuleBuilder.of(E_1).produce(p17);
		Rule r18 = RuleBuilder.of(E_1).produce(p18);
		Rule r19 = RuleBuilder.of(E_1).produce(p19);
		Rule r20 = RuleBuilder.of(E_1).produce(p20);
		Rule r21 = RuleBuilder.of(E_1).produce(p21);
		Rule r22 = RuleBuilder.of(E_1).produce(p22);
		Rule r23 = RuleBuilder.of(E_1).produce(p23);
		Rule r24 = RuleBuilder.of(E_1).produce(p24);
		Rule r25 = RuleBuilder.of(E_1).produce(p25);
		Rule r26 = RuleBuilder.of(IF_ST).produce(p26);
		Rule r27 = RuleBuilder.of(B).produce(p27);
		Rule r28 = RuleBuilder.of(VAR).produce(p28);
		Rule r29 = RuleBuilder.of(STMT).produce(p29);
		Rule r30 = RuleBuilder.of(STMT).produce(p30);
		Rule r31 = RuleBuilder.of(STMT).produce(p31);
		Rule r32 = RuleBuilder.of(STMT).produce(p32);
		Rule r33 = RuleBuilder.of(STMT_LIST).produce(p33);
		Rule r34 = RuleBuilder.of(STMT_LIST).produce(p34);
		Rule r35 = RuleBuilder.of(E_1).produce(p35);
		
		return new Grammar(
				Arrays.asList(r1, r2, r3, r4, r5, r6, r8, r9, r10, r11, r12,
						r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23,
						r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35),
				Arrays.asList(p1, p2, p3, p4, p5, p6, p8, p9, p10, p11, p12,
						p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23,
						p24, p25, p26, p27, p28, p29, p30, p31, p32, p33, p34, p35),
				Arrays.asList(P, E, E_1, IF_ST, B, VAR, STMT, STMT_LIST));
	}
}
