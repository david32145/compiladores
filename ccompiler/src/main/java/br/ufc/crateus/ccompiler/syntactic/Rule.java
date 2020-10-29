package br.ufc.crateus.ccompiler.syntactic;

import br.ufc.crateus.ccompiler.syntactic.productions.Production;

public class Rule {
	private NoTerminal noTerminal;
	private Production production;
	
	private Rule(RuleBuilder ruleBuilder) {
		this.noTerminal = ruleBuilder.noTerminal;
		this.production = ruleBuilder.production;
	}
	
	public NoTerminal getNoTerminal() {
		return noTerminal;
	}
	
	public Production getProduction() {
		return production;
	}
	
	@Override
	public String toString() {
		return String.format("%s => %s", noTerminal, production);
	}
	
	public static class RuleBuilder {
		private NoTerminal noTerminal;
		private Production production;
		
		private RuleBuilder(NoTerminal noTerminal) {
			this.noTerminal = noTerminal;
		}

		public static RuleBuilder of(NoTerminal noTerminal) {
			return new RuleBuilder(noTerminal);
		}
		
		public Rule produce(Production production) {
			this.production = production;
			return new Rule(this);
		}
	}
}
