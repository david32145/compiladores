package br.ufc.crateus.ccompiler.lexical;

public enum LexemeType {
	KEY_WORD("Palavra reservado"),
	DATA_TYPE("Tipo de dado"),
	LITERAL("Literal"),
	NUMBER("Número"),
	ID("Identificador"),
	OPERATOR("Operador"),
	SEPARATOR("Separador"),
	AMPERSAND("É comercial"),
	HASHTAG("Hashtag"),
	UNKNOWN("");
	
	String msg;
	
	LexemeType(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}
}
