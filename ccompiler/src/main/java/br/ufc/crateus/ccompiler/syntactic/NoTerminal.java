package br.ufc.crateus.ccompiler.syntactic;

public class NoTerminal {
	private String tag;

	public NoTerminal(String tag) {
		this.tag = tag;
	}
	
	@Override
	public String toString() {
		return tag;
	}
	
	public boolean equalsByTag(String tag) {
		return this.tag == tag;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoTerminal other = (NoTerminal) obj;
		return tag.equals(other.tag);
	}
	
}
