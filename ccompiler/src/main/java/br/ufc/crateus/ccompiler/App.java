package br.ufc.crateus.ccompiler;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import br.ufc.crateus.ccompiler.lexical.LexicalAnalyzer;
import br.ufc.crateus.ccompiler.lexical.Token;
import br.ufc.crateus.ccompiler.syntactic.Grammar;
import br.ufc.crateus.ccompiler.syntactic.PredictiveTable;
import br.ufc.crateus.ccompiler.syntactic.SyntacticAnalyzer;
import br.ufc.crateus.ccompiler.utils.GrammarUtil;
import br.ufc.crateus.ccompiler.utils.PredictiveTableUtils;

public class App {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = new FileInputStream("main.c");
		LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(inputStream);
		lexicalAnalyzer.analyzer();

		List<Token> tokens = lexicalAnalyzer.getTokens();
		tokens.forEach(System.out::println);
		
		System.out.println("\nProduções: ");

		Grammar grammar = GrammarUtil.getGrammar();
		PredictiveTable predictiveTable = PredictiveTableUtils.getPredictiveTable(grammar);
		SyntacticAnalyzer syntacticAnalyzer = new SyntacticAnalyzer(grammar, predictiveTable);
		syntacticAnalyzer.analyzer(tokens);
	}
}
