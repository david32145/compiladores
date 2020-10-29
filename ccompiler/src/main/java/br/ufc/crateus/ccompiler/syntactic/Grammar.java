package br.ufc.crateus.ccompiler.syntactic;

import java.util.List;

import br.ufc.crateus.ccompiler.syntactic.productions.Production;

public class Grammar {
	private List<Rule> rules;
	private List<Production> productions;
	private List<NoTerminal> noTerminals;

	public Grammar(List<Rule> rules, List<Production> productions,
			List<NoTerminal> noTerminals) {
		this.rules = rules;
		this.productions = productions;
		this.noTerminals = noTerminals;
	}

	public Production findProductionById(int id) {
		return productions.stream().filter(p -> p.equalsById(id)).findFirst()
				.get();
	}

	public NoTerminal findNoTerminalByTag(String tag) {
		return noTerminals.stream().filter(n -> n.equalsByTag(tag)).findFirst()
				.get();
	}

	public List<Rule> getRules() {
		return rules;
	}

	public List<Production> getProductions() {
		return productions;
	}

	public List<NoTerminal> getNoTerminals() {
		return noTerminals;
	}
}
