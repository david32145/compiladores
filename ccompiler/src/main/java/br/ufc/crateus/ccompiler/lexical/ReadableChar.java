package br.ufc.crateus.ccompiler.lexical;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public abstract class ReadableChar {
	protected InputStream inputStream;
	protected char lastCharReadable;
	
	public ReadableChar(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	protected void read() throws IOException {
		Scanner scanner = new Scanner(this.inputStream);
		int lineCount = 0;
		int columnCount = 0;
		while(scanner.hasNextLine()) {
			lineCount++;
			columnCount = 0;
			String line = scanner.nextLine();
			this.onNextLine();
			for(int i = 0; i < line.length(); i++) {
				columnCount++;
				this.onChar(line.charAt(i), lineCount, columnCount);
				this.lastCharReadable = line.charAt(i);
			}
		}
		
		
		this.inputStream.close();
		scanner.close();
	}
	
	abstract void onNextLine();
	
	abstract void onChar(char ch, int lineCount, int columnCount);
}
