package com.migrenus.dummies;
/*
import java.io.IOException;
import java.util.StringTokenizer;

import static java.lang.System.out;

public class KeyCracker {
	private KeyGenerator[] testCase;
	
	public void crackFromFile(String fileName, int placeInFile, String separator) throws IOException {
		int keyBits = 0;
		int keyCharBits = 0;
		FileHandler theFile = new FileHandler();
		String findingCharsInBit = new String();
		
		theFile.fileInit(fileName);
		theFile.getLines();
		
		StringTokenizer tokenizer = new StringTokenizer(theFile.getFileContents(placeInFile), "-");
		
		while (tokenizer.hasMoreTokens()) {
			findingCharsInBit = tokenizer.nextToken();
			keyBits++;
		}
		
		keyCharBits = findingCharsInBit.length();
		testCase = new KeyGenerator[keyBits];
		
		for (int i = 0; i < ((keyCharBits*keyBits) + keyBits - 1); i++) {
			
		}
		
		
		for (int i = 0; i < keyBits; i++){
			char[] tester = new char[keyCharBits];
			for (int j = 0; j < keyCharBits; j++){
				do {
					tester[i] = testCase[i].makeKey(keyCharBits, 350); 
				} while (tester[i].key[] != this.testCase[i].key[]);
			}
		}
		
	}
	
}

/*
 * 
 * This comment is used for future reference
 * 
 * "Pulling apart delimited items on a line."
 * 
 *  String text = "Beggars in Spain*Nancy Kress*1992"; 
 	StringTokenizer tokenizer = new StringTokenizer(text,"*"); 
 	String title = tokenizer.nextToken(); 
 	String author = tokenizer.nextToken(); 
 	String year = tokenizer.nextToken();
 	String letters = "a b c d e f g h i j"; 
 	StringTokenizer tokenizer = new StringTokenizer(text," "); 
 	String[] allText = new String[10]; 
 	int pos = 0; 
 	while (tokenizer.hasMoreTokens()) 
      allText[pos++] = tokenizer.nextToken(); 
 *
 * 
 * 
 * 
 */
