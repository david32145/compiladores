package br.ufc.crateus.ccompiler.syntactic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import br.ufc.crateus.ccompiler.lexical.Token;
import br.ufc.crateus.ccompiler.syntactic.constants.Tags;
import br.ufc.crateus.ccompiler.syntactic.productions.ProductionType;

public class SyntacticAnalyzer {
	private Grammar grammar;
	private PredictiveTable predictiveTable;

	public SyntacticAnalyzer(Grammar grammar, PredictiveTable predictiveTable) {
		this.grammar = grammar;
		this.predictiveTable = predictiveTable;
	}

	public void analyzer(List<Token> listTokens) {
		Stack<Token> inputTokens = mapTokensAsStack(listTokens);
		Stack<ProductionType> stack = new Stack<>();
		stack.add(ProductionType
				.ofNoTerminal(grammar.findNoTerminalByTag(Tags.P)));
		while (!inputTokens.isEmpty()) {
			Token token = inputTokens.lastElement();
			ProductionType head = stack.lastElement();
			if (head.isNoTerminal()) {
				Rule rule = predictiveTable.getRule(token.getLexeme(),
						head.getNoTerminal());
				List<ProductionType> toInsertInStack = reverseProductionType(
						rule.getProduction().getProductionTypes());
				stack.pop();
				stack.addAll(toInsertInStack);
				System.out.println(rule);
				continue;
			}
			if(head.isTerminal()) {
				if(head.matches(token.getLexeme())) {
					inputTokens.pop();
					stack.pop();
					System.out.println("Matches: " + token.getLexeme().getName());
					continue;
				}
			}
			throw new RuntimeException("Não foi possível reconhecer");
		}
		System.out.println("\nReconhecido!!!");
	}

	private List<ProductionType> reverseProductionType(
			List<ProductionType> productionTypes) {
		List<ProductionType> reverse = new ArrayList<>(productionTypes);
		Collections.reverse(reverse);
		return reverse;
	}

	private Stack<Token> mapTokensAsStack(List<Token> tokens) {
		List<Token> reverseTokens = new ArrayList<>(tokens);
		Collections.reverse(reverseTokens);
		Stack<Token> stack = new Stack<>();
		reverseTokens.forEach(t -> stack.add(t));
		return stack;
	}
}
