package br.ufc.crateus.ccompiler.syntactic.productions;

import br.ufc.crateus.ccompiler.lexical.Lexeme;

class ProductionTypeTerminal extends ProductionType {
	private Lexeme lexeme;
	
	public ProductionTypeTerminal(Lexeme lexeme) {
		this.lexeme = lexeme;
	}
	
	@Override
	public String toString() {
		return lexeme.getName();
	}
	
	@Override
	public boolean matches(Lexeme lexeme) {
		return this.lexeme == lexeme;
	}
	
	@Override
	public boolean isTerminal() {
		return true;
	}
	
	@Override
	public Lexeme getTerminal() {
		return lexeme;
	}
}
