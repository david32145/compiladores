package br.ufc.crateus.ccompiler.lexical;

public class Token {
	private String lexemeAsString;
	private int line;
	private int column;
	
	public Token(String lexemeAsString, int line, int column) {
		this.lexemeAsString = lexemeAsString;
		this.line = line;
		this.column = column;
	}
	
	public String getLexeme() {
		return lexemeAsString;
	}
	
	public void appendToLexeme(char ch) {
		lexemeAsString = lexemeAsString.concat(ch + "");
	}
	
	@Override
	public String toString() {
		Lexeme lexeme = LexicalAnalyzer.parseLexeme(lexemeAsString);
		return String.format("%s - %d:%d %s %s", lexemeAsString, line, column, lexeme.name(), lexeme.getLexemeTypeMessage());
	}
}
