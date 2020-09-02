package br.ufc.crateus.ccompiler.lexical;

public enum Lexeme {
	MAIN("main", LexemeType.KEY_WORD),
	IF("if", LexemeType.KEY_WORD),
	ELSE("else", LexemeType.KEY_WORD),
	WHILE("while", LexemeType.KEY_WORD),
	INT("int", LexemeType.DATA_TYPE),
	FLOAT("float", LexemeType.DATA_TYPE),
	CHAR("char", LexemeType.DATA_TYPE),
	VOID("void", LexemeType.DATA_TYPE),
	SYSTEM("system", LexemeType.KEY_WORD),
	OPEN_PARENTHESIS("\\(", LexemeType.UNKNOWN),
	CLOSE_PARENTHESIS("\\)", LexemeType.UNKNOWN),
	OPEN_KEY("\\{", LexemeType.UNKNOWN),
	CLOSE_KEY("\\}", LexemeType.UNKNOWN),
	SEMICOLON(";", LexemeType.SEPARATOR),
	COMMAN(",", LexemeType.SEPARATOR),
	AMPERSAND("&", LexemeType.AMPERSAND),
	HASHTAG("#", LexemeType.HASHTAG),
	OPERATOR_SUM("\\+", LexemeType.OPERATOR),
	OPERATOR_SUB("\\-", LexemeType.OPERATOR),
	OPERATOR_MULTIPLY("\\*", LexemeType.OPERATOR),
	OPERATOR_DIVISION("/", LexemeType.OPERATOR),
	OPERATOR_REST("%", LexemeType.OPERATOR),
	OPERATOR_AND("&&", LexemeType.OPERATOR),
	OPERATOR_OR("\\|\\|", LexemeType.OPERATOR),
	OPERATOR_NOT("!", LexemeType.OPERATOR),
	OPERATOR_GREATER(">", LexemeType.OPERATOR),
	OPERATOR_LESS("<", LexemeType.OPERATOR),
	OPERATOR_ASSIGN("=", LexemeType.OPERATOR),
	OPERATOR_EQUAL("==", LexemeType.OPERATOR),
	OPERATOR_GREATER_OR_EQUAL(">=", LexemeType.OPERATOR),
	OPERATOR_LESS_OR_EQUAL("<=", LexemeType.OPERATOR),
	OPERATOR_DIFFERENT("!=", LexemeType.OPERATOR),
	RETURN("return", LexemeType.KEY_WORD),
	BREAK("break", LexemeType.KEY_WORD),
	CONTINUE("continue", LexemeType.KEY_WORD),
	INCLUDE("#include", LexemeType.KEY_WORD),
	DEFINE("#define", LexemeType.KEY_WORD),
	PRINTF("printf", LexemeType.KEY_WORD),
	SCANF("scanf",  LexemeType.KEY_WORD),
	LIB(".*\\.h", LexemeType.UNKNOWN),
	ID("[a-zA-Z]([a-zA-Z]|(\\d))*",  LexemeType.ID),
	NUMBER_LITERAL("\\d*", LexemeType.LITERAL),
	STRING_LITERAL("\".*\"", LexemeType.LITERAL);
	
	
	String pattern;
	LexemeType type;
	
	Lexeme(String pattern, LexemeType type) {
		this.pattern = pattern;
		this.type = type;
	}
	
	public boolean matches(String value) {
		return value.matches(pattern);
	}
	
	public String getLexemeTypeMessage() {
		return type.getMsg();
	}
}
