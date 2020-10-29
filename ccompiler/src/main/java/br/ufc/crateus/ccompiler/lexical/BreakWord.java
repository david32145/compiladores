package br.ufc.crateus.ccompiler.lexical;

import java.util.Arrays;
import java.util.List;

public class BreakWord {
	private static List<String> breakWords = Arrays.asList(
			" ", "(", ")", "{", "}", ">", "<",
			"=", "!", ";", "&", ",", "/", "+", "-", "*", "/"
	);
	
	
	public static boolean isBreakWord(String posibleBreakWord) {
		return BreakWord.breakWords.contains(posibleBreakWord);
	}
}
