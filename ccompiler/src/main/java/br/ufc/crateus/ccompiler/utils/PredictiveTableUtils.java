package br.ufc.crateus.ccompiler.utils;

import br.ufc.crateus.ccompiler.lexical.Lexeme;
import br.ufc.crateus.ccompiler.syntactic.Grammar;
import br.ufc.crateus.ccompiler.syntactic.PredictiveTable;
import br.ufc.crateus.ccompiler.syntactic.constants.Productions;
import br.ufc.crateus.ccompiler.syntactic.constants.Tags;
import br.ufc.crateus.ccompiler.syntactic.productions.Production;

public class PredictiveTableUtils {
	public final static PredictiveTable getPredictiveTable(final Grammar G) {
		PredictiveTable table = new PredictiveTable();

		table.addRelation(Lexeme.VOID, G.findNoTerminalByTag(Tags.P),
				G.findProductionById(Productions.P1));
		table.addRelation(Lexeme.OPEN_PARENTHESIS,
				G.findNoTerminalByTag(Tags.E),
				G.findProductionById(Productions.P6));
		table.addRelation(Lexeme.OPERATOR_NOT, G.findNoTerminalByTag(Tags.E),
				G.findProductionById(Productions.P3));
		table.addRelation(Lexeme.ID, G.findNoTerminalByTag(Tags.E),
				G.findProductionById(Productions.P2));
		table.addRelation(Lexeme.INT_LITERAL, G.findNoTerminalByTag(Tags.E),
				G.findProductionById(Productions.P8));
		table.addRelation(Lexeme.CHAR_LITERAL, G.findNoTerminalByTag(Tags.E),
				G.findProductionById(Productions.P9));
		table.addRelation(Lexeme.FLOAT_LITERAL, G.findNoTerminalByTag(Tags.E),
				G.findProductionById(Productions.P10));
		table.addRelation(Lexeme.STRING_LITERAL, G.findNoTerminalByTag(Tags.E),
				G.findProductionById(Productions.P11));
		table.addRelation(Lexeme.IF, G.findNoTerminalByTag(Tags.IF_ST),
				G.findProductionById(Productions.P26));
		table.addRelation(Lexeme.OPEN_KEY, G.findNoTerminalByTag(Tags.B),
				G.findProductionById(Productions.P27));
		table.addRelation(Lexeme.INT, G.findNoTerminalByTag(Tags.VAR),
				G.findProductionById(Productions.P28));
		table.addRelation(Lexeme.INT, G.findNoTerminalByTag(Tags.STMT),
				G.findProductionById(Productions.P32));
		table.addRelation(Lexeme.OPEN_PARENTHESIS,
				G.findNoTerminalByTag(Tags.STMT),
				G.findProductionById(Productions.P29));
		table.addRelation(Lexeme.OPEN_KEY, G.findNoTerminalByTag(Tags.STMT),
				G.findProductionById(Productions.P31));
		table.addRelation(Lexeme.IF, G.findNoTerminalByTag(Tags.STMT),
				G.findProductionById(Productions.P30));
		table.addRelation(Lexeme.OPERATOR_NOT, G.findNoTerminalByTag(Tags.STMT),
				G.findProductionById(Productions.P29));
		table.addRelation(Lexeme.ID, G.findNoTerminalByTag(Tags.STMT),
				G.findProductionById(Productions.P29));
		table.addRelation(Lexeme.INT_LITERAL, G.findNoTerminalByTag(Tags.STMT),
				G.findProductionById(Productions.P29));
		table.addRelation(Lexeme.CHAR_LITERAL, G.findNoTerminalByTag(Tags.STMT),
				G.findProductionById(Productions.P29));
		table.addRelation(Lexeme.FLOAT_LITERAL,
				G.findNoTerminalByTag(Tags.STMT),
				G.findProductionById(Productions.P29));
		table.addRelation(Lexeme.STRING_LITERAL,
				G.findNoTerminalByTag(Tags.STMT),
				G.findProductionById(Productions.P29));
		table.addRelation(Lexeme.INT, G.findNoTerminalByTag(Tags.STMT_LIST),
				G.findProductionById(Productions.P33));
		table.addRelation(Lexeme.OPEN_PARENTHESIS,
				G.findNoTerminalByTag(Tags.STMT_LIST),
				G.findProductionById(Productions.P33));
		table.addRelation(Lexeme.OPEN_KEY,
				G.findNoTerminalByTag(Tags.STMT_LIST),
				G.findProductionById(Productions.P33));
		table.addRelation(Lexeme.CLOSE_KEY,
				G.findNoTerminalByTag(Tags.STMT_LIST),
				G.findProductionById(Productions.P34));
		table.addRelation(Lexeme.IF, G.findNoTerminalByTag(Tags.STMT_LIST),
				G.findProductionById(Productions.P33));
		table.addRelation(Lexeme.OPERATOR_NOT,
				G.findNoTerminalByTag(Tags.STMT_LIST),
				G.findProductionById(Productions.P33));
		table.addRelation(Lexeme.ID, G.findNoTerminalByTag(Tags.STMT_LIST),
				G.findProductionById(Productions.P33));
		table.addRelation(Lexeme.INT_LITERAL,
				G.findNoTerminalByTag(Tags.STMT_LIST),
				G.findProductionById(Productions.P33));
		table.addRelation(Lexeme.CHAR_LITERAL,
				G.findNoTerminalByTag(Tags.STMT_LIST),
				G.findProductionById(Productions.P33));
		table.addRelation(Lexeme.FLOAT_LITERAL,
				G.findNoTerminalByTag(Tags.STMT_LIST),
				G.findProductionById(Productions.P33));
		table.addRelation(Lexeme.STRING_LITERAL,
				G.findNoTerminalByTag(Tags.STMT_LIST),
				G.findProductionById(Productions.P33));
		table.addRelation(Lexeme.OPERATOR_SUM, G.findNoTerminalByTag(Tags.E),
				G.findProductionById(Productions.P5));
		table.addRelation(Lexeme.OPERATOR_SUB, G.findNoTerminalByTag(Tags.E),
				G.findProductionById(Productions.P4));
		table.addRelation(Lexeme.OPERATOR_DIFFERENT,
				G.findNoTerminalByTag(Tags.E_1),
				G.findProductionById(Productions.P14));
		table.addRelation(Lexeme.SEMICOLON, G.findNoTerminalByTag(Tags.E_1),
				G.findProductionById(Productions.P25));
		table.addRelation(Lexeme.OPERATOR_LESS_OR_EQUAL,
				G.findNoTerminalByTag(Tags.E_1),
				G.findProductionById(Productions.P15));
		table.addRelation(Lexeme.OPERATOR_LESS, G.findNoTerminalByTag(Tags.E_1),
				G.findProductionById(Productions.P16));
		table.addRelation(Lexeme.OPERATOR_GREATER_OR_EQUAL,
				G.findNoTerminalByTag(Tags.E_1),
				G.findProductionById(Productions.P17));
		table.addRelation(Lexeme.OPERATOR_GREATER,
				G.findNoTerminalByTag(Tags.E_1),
				G.findProductionById(Productions.P18));
		table.addRelation(Lexeme.OPERATOR_SUM, G.findNoTerminalByTag(Tags.E_1),
				G.findProductionById(Productions.P20));
		table.addRelation(Lexeme.OPERATOR_SUB, G.findNoTerminalByTag(Tags.E_1),
				G.findProductionById(Productions.P21));
		table.addRelation(Lexeme.OPERATOR_MULTIPLY,
				G.findNoTerminalByTag(Tags.E_1),
				G.findProductionById(Productions.P22));
		table.addRelation(Lexeme.OPERATOR_DIVISION,
				G.findNoTerminalByTag(Tags.E_1),
				G.findProductionById(Productions.P23));
		table.addRelation(Lexeme.OPERATOR_AND, G.findNoTerminalByTag(Tags.E_1),
				G.findProductionById(Productions.P19));
		table.addRelation(Lexeme.OPERATOR_EQUAL,
				G.findNoTerminalByTag(Tags.E_1),
				G.findProductionById(Productions.P13));
		table.addRelation(Lexeme.OPERATOR_OR, G.findNoTerminalByTag(Tags.E_1),
				G.findProductionById(Productions.P12));
		table.addRelation(Lexeme.OPERATOR_REST, G.findNoTerminalByTag(Tags.E_1),
				G.findProductionById(Productions.P24));
		table.addRelation(Lexeme.OPERATOR_SUM, G.findNoTerminalByTag(Tags.STMT),
				G.findProductionById(Productions.P29));
		table.addRelation(Lexeme.OPERATOR_SUB, G.findNoTerminalByTag(Tags.STMT),
				G.findProductionById(Productions.P29));
		table.addRelation(Lexeme.OPERATOR_SUM,
				G.findNoTerminalByTag(Tags.STMT_LIST),
				G.findProductionById(Productions.P33));
		table.addRelation(Lexeme.OPERATOR_SUB,
				G.findNoTerminalByTag(Tags.STMT_LIST),
				G.findProductionById(Productions.P33));
		table.addRelation(Lexeme.CLOSE_PARENTHESIS,
				G.findNoTerminalByTag(Tags.E_1),
				G.findProductionById(Productions.P35));
		return table;
	}
}
