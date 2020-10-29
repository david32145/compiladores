package br.ufc.crateus.ccompiler.lexical;

public enum Lexeme {
	MAIN("main", LexemeType.KEY_WORD, "main"),
	IF("if", LexemeType.KEY_WORD, "if"),
	ELSE("else", LexemeType.KEY_WORD, "else"),
	WHILE("while", LexemeType.KEY_WORD, "while"),
	INT("int", LexemeType.DATA_TYPE, "<dt_int>"),
	FLOAT("float", LexemeType.DATA_TYPE, "<dt_int>"),
	CHAR("char", LexemeType.DATA_TYPE, "<dt_int>"),
	VOID("void", LexemeType.DATA_TYPE, "void"),
	SYSTEM("system", LexemeType.KEY_WORD, "system"),
	OPEN_PARENTHESIS("\\(", LexemeType.UNKNOWN, "("),
	CLOSE_PARENTHESIS("\\)", LexemeType.UNKNOWN, ")"),
	OPEN_KEY("\\{", LexemeType.UNKNOWN, "{"),
	CLOSE_KEY("\\}", LexemeType.UNKNOWN, "}"),
	SEMICOLON(";", LexemeType.SEPARATOR, ";"),
	COMMAN(",", LexemeType.SEPARATOR, ","),
	AMPERSAND("&", LexemeType.AMPERSAND, "&"),
	HASHTAG("#", LexemeType.HASHTAG, "#"),
	OPERATOR_SUM("\\+", LexemeType.OPERATOR, "+"),
	OPERATOR_SUB("\\-", LexemeType.OPERATOR, "-"),
	OPERATOR_MULTIPLY("\\*", LexemeType.OPERATOR, "*"),
	OPERATOR_DIVISION("/", LexemeType.OPERATOR, "/"),
	OPERATOR_REST("%", LexemeType.OPERATOR, "%"),
	OPERATOR_AND("&&", LexemeType.OPERATOR, "&&"),
	OPERATOR_OR("\\|\\|", LexemeType.OPERATOR, "||"),
	OPERATOR_NOT("!", LexemeType.OPERATOR, "!"),
	OPERATOR_GREATER(">", LexemeType.OPERATOR, ">"),
	OPERATOR_LESS("<", LexemeType.OPERATOR,"<"),
	OPERATOR_ASSIGN("=", LexemeType.OPERATOR, "="),
	OPERATOR_EQUAL("==", LexemeType.OPERATOR, "=="),
	OPERATOR_GREATER_OR_EQUAL(">=", LexemeType.OPERATOR,">="),
	OPERATOR_LESS_OR_EQUAL("<=", LexemeType.OPERATOR, "<="),
	OPERATOR_DIFFERENT("!=", LexemeType.OPERATOR, "!="),
	RETURN("return", LexemeType.KEY_WORD, "return"),
	BREAK("break", LexemeType.KEY_WORD, "break"),
	CONTINUE("continue", LexemeType.KEY_WORD, "continue"),
	INCLUDE("#include", LexemeType.KEY_WORD, "#includes"),
	DEFINE("#define", LexemeType.KEY_WORD, "#define"),
	PRINTF("printf", LexemeType.KEY_WORD, "printf"),
	SCANF("scanf",  LexemeType.KEY_WORD, "scanf"),
	LIB(".*\\.h", LexemeType.UNKNOWN, "header"),
	ID("[a-zA-Z]([a-zA-Z]|(\\d))*",  LexemeType.ID, "id"),
	INT_LITERAL("\\d*", LexemeType.LITERAL, "IL"),
	CHAR_LITERAL("'.'", LexemeType.LITERAL, "CL"),
	FLOAT_LITERAL("\\d+\\.\\d+", LexemeType.LITERAL, "FL"),
	STRING_LITERAL("\".*\"", LexemeType.LITERAL, "SL");
	
	
	String pattern;
	LexemeType type;
	String name;
	
	Lexeme(String pattern, LexemeType type, String name) {
		this.pattern = pattern;
		this.type = type;
		this.name = name;
	}
	
	public boolean matches(String value) {
		return value.matches(pattern);
	}
	
	public String getLexemeTypeMessage() {
		return type.getMsg();
	}
	
	public String getName() {
		return name;
	}
}
