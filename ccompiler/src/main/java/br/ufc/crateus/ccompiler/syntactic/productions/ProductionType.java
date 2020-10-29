package br.ufc.crateus.ccompiler.syntactic.productions;

import br.ufc.crateus.ccompiler.lexical.Lexeme;
import br.ufc.crateus.ccompiler.syntactic.NoTerminal;

abstract public class ProductionType {
	
	public static ProductionType ofTerminal(Lexeme lexeme) {
		return new ProductionTypeTerminal(lexeme);
	}
	
	public static ProductionType ofNoTerminal(NoTerminal noTerminal) {
		return new ProductionTypeNoTerminal(noTerminal);
	}	
	
	public boolean isNoTerminal() {
		return false;
	}
	
	public NoTerminal getNoTerminal() {
		return null;
	}
	
	public boolean matches(Lexeme lexeme) {
		return false;
	}

	public boolean isTerminal() {
		return false;
	}
	
	public Lexeme getTerminal() {
		return null;
	}
}
