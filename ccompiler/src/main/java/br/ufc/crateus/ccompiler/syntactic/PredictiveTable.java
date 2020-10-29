package br.ufc.crateus.ccompiler.syntactic;

import java.util.ArrayList;
import java.util.List;

import br.ufc.crateus.ccompiler.lexical.Lexeme;
import br.ufc.crateus.ccompiler.syntactic.Rule.RuleBuilder;
import br.ufc.crateus.ccompiler.syntactic.productions.Production;

public class PredictiveTable {
	private class Relation {
		final Lexeme lexeme;
		final NoTerminal noTerminal;
		final Production production;

		public Relation(Lexeme lexeme, NoTerminal noTerminal,
				Production production) {
			this.lexeme = lexeme;
			this.noTerminal = noTerminal;
			this.production = production;
		}
	}

	private List<Relation> relations;

	public PredictiveTable() {
		this.relations = new ArrayList<>();
	}

	public Rule getRule(Lexeme lexeme, NoTerminal noTerminal) {
		Relation relation = relations.stream()
				.filter(r -> r.lexeme == lexeme && r.noTerminal == noTerminal)
				.findFirst().orElse(null);
		if (relation == null) {
			throw new RuntimeException(
					String.format("Unable to find relation between %s and %s",
							lexeme, noTerminal));
		}
		return RuleBuilder.of(noTerminal).produce(relation.production);
	}

	public void addRelation(Lexeme lexeme, NoTerminal noTerminal,
			Production production) {
		this.relations.add(new Relation(lexeme, noTerminal, production));
	}
}
