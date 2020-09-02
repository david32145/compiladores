package br.ufc.crateus.ccompiler.lexical;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexicalAnalyzer extends ReadableChar {

	private static final char QUOTE_CHAR = '"';

	private StringBuilder currentLexeme;
	private boolean quotesOpened;
	private boolean isInComment;
	private boolean isLineComment;
	private List<Token> tokens;

	public LexicalAnalyzer(InputStream inputStream) {
		super(inputStream);
		this.currentLexeme = new StringBuilder();
		this.quotesOpened = false;
		this.tokens = new ArrayList<>();
	}

	public void analyzer() throws IOException {
		super.read();
	}
	
	@Override
	void onNextLine() {
		if(isInComment() && isLineComment()) {
			this.clearCommentBlock();
		}
	}

	@Override
	void onChar(char ch, int lineCount, int columnCount) {
		if(isInComment()) {
			if(isEndCommentBlock(ch)) {
				clearCommentBlock();
			}
			return;
		}
		if(isBeginCommentBlock(ch)) {
			initCommentBlock(ch);
			return;
		}
		if (isQuotesOpened() && isNotQuote(ch)) {
			this.currentLexeme.append(ch);
			return;
		}
		if (isQuote(ch)) {
			if (isQuotesOpened()) {
				currentLexeme.append(LexicalAnalyzer.QUOTE_CHAR);
				String lexemeAsString = currentLexeme.toString();
				Token token = new Token(lexemeAsString, lineCount, columnCount - lexemeAsString.length());
				tokens.add(token);
				this.clearCurrentLexeme();
				this.closeQuote();
			} else {
				currentLexeme.append(LexicalAnalyzer.QUOTE_CHAR);
				this.openQuote();
			}
			this.lastCharReadable = ch;
			return;
		}
		if (BreakWord.isBreakWord(ch + "")) {
			if(joinToken(ch)) {
				this.tokens.get(this.tokens.size() - 1).appendToLexeme(ch);
				return;
			}
			if (isEmpty(currentLexeme)) {
				String lexemeAsString = currentLexeme.toString();
				Token token = new Token(lexemeAsString, lineCount, columnCount - lexemeAsString.length());
				tokens.add(token);
			}
			if (ch != ' ') {
				String lexemeAsString = ch + "";
				Token token = new Token(lexemeAsString, lineCount, columnCount - lexemeAsString.length());
				tokens.add(token);
			}
			this.clearCurrentLexeme();
		} else {
			currentLexeme.append(ch);
		}
	}
	
	
	public boolean isBeginCommentBlock(char ch) {
		return
				(this.lastCharReadable == '/' && ch == '/')
				|| (this.lastCharReadable == '/' && ch=='*');
	}
	
	public boolean isEndCommentBlock(char ch) {
		return (this.lastCharReadable == '*' && ch=='/');
	}
	
	public void initCommentBlock(char ch) {
		this.tokens.remove(this.tokens.size()-1);
		this.clearCurrentLexeme();
		this.isInComment = true;
		if(this.lastCharReadable == '/' && ch == '/') {
			this.isLineComment = true;
		}
	}
	
	public void clearCommentBlock() {
		this.isInComment = false;
		this.isLineComment = false;
	}

	public boolean isInComment() {
		return isInComment;
	}
	
	public boolean isLineComment() {
		return isLineComment;
	}

	public boolean isQuotesOpened() {
		return quotesOpened;
	}

	public boolean isNotQuote(char ch) {
		return !this.isQuote(ch);
	}

	public boolean isQuote(char ch) {
		return ch == LexicalAnalyzer.QUOTE_CHAR;
	}

	public void clearCurrentLexeme() {
		currentLexeme = new StringBuilder();
	}

	public void openQuote() {
		this.quotesOpened = true;
	}

	public void closeQuote() {
		this.quotesOpened = false;
	}
	
	public boolean joinToken(char currentChar) {
		if(currentChar == '=' && lastCharReadable == '=') {
			return true;
		}
		if(lastCharReadable == '!' && currentChar == '=' ) {
			return true;
		}
		if(lastCharReadable == '>' && currentChar == '=' ) {
			return true;
		}
		if(lastCharReadable == '<' && currentChar == '=' ) {
			return true;
		}
		if(lastCharReadable == '+' && currentChar == '+' ) {
			return true;
		}
		if(lastCharReadable == '-' && currentChar == '-' ) {
			return true;
		}
		if(lastCharReadable == '+' && currentChar == '=' ) {
			return true;
		}
		if(lastCharReadable == '*' && currentChar == '=' ) {
			return true;
		}
		if(lastCharReadable == '/' && currentChar == '=' ) {
			return true;
		}
		if(lastCharReadable == '|' && currentChar == '|') {
			return true;
		}
		if(lastCharReadable == '&' && currentChar == '&') {
			return true;
		}
		return false;
	}

	public static Lexeme parseLexeme(String lexemeAsString) {
		Lexeme lexeme = Arrays.asList(Lexeme.values()).stream().filter(lex -> lex.matches(lexemeAsString)).findFirst()
				.orElse(null);
		if (lexeme == null) {
			throw new RuntimeException("Unknown lexeme: " + lexemeAsString);
		}
		return lexeme;
	}

	private boolean isEmpty(StringBuilder sb) {
		String s = sb.toString().trim();
		return s.length() > 0;
	}

	public List<Token> getTokens() {
		return tokens;
	}
}
