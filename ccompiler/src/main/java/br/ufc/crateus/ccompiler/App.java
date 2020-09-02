package br.ufc.crateus.ccompiler;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import br.ufc.crateus.ccompiler.lexical.LexicalAnalyzer;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        InputStream inputStream = new FileInputStream("main.c");
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(inputStream);
        lexicalAnalyzer.analyzer();
        
        lexicalAnalyzer.getTokens()
        	.forEach(System.out::println);
    }
}
