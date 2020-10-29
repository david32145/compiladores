package br.ufc.crateus.ccompiler.syntactic.productions;

import br.ufc.crateus.ccompiler.syntactic.NoTerminal;

class ProductionTypeNoTerminal extends ProductionType {
	private NoTerminal noTerminal;
	
	public ProductionTypeNoTerminal(NoTerminal noTerminal) {
		this.noTerminal = noTerminal;
	}

	@Override
	public String toString() {
		return "<" + noTerminal + ">";
	}
	
	@Override
	public NoTerminal getNoTerminal() {
		return noTerminal;
	}  
	
	@Override
	public boolean isNoTerminal() {
		return true;
	}
}
