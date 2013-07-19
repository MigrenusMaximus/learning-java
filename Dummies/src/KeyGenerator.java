/*
 * 0-9 == 48-57
 * A-Z == 65-90
 * a-z == 97-122
 * 
 * median == 90
 * final = noOfChars * median;
 * 
 */

import static java.lang.System.out;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class KeyGenerator {
	private char[] key = new char[5];
	private int keyValue;
	
	public KeyGenerator(){}
	
	public KeyGenerator(int keyValue){
		this.keyValue = keyValue;
	}
	
	public int findKeyValue(int keyBitChars){
		int value = 0;
		for (int i = 0; i < keyBitChars; i++){
			value += this.key[i];
		}
		return value;
	}
	
	public void makeKey(int keyBitChars, int keyValue) {
		int placeHolder = 0;
		while (keyValue != this.keyValue){
			for (int i = 0; i < keyBitChars; i++){
				placeHolder = 0;
				while ( !((placeHolder >= 48 && placeHolder <= 57) || 
						(placeHolder >= 65 && placeHolder <= 90)) ) {
					placeHolder = new Random().nextInt(122) + 1;
				}
				this.key[i] = (char) placeHolder;
			}
		}
	}
	
	public void printKey(int keyBitSize, boolean isLastBit) {
		
		for(int i = 0; i < keyBitSize; i++){
			out.print(this.key[i]);
		}
		
		if(!isLastBit){
			out.print("-");
		} else {
			out.println();
		}
		
	}
	
	
	public void keyToFile(String fileName, int keyBitSize, boolean isLastBit) throws IOException {
		PrintWriter to_file = new PrintWriter(new FileWriter(fileName, true)); 
		
		for(int i = 0; i < keyBitSize; i++){
			to_file.print(this.key[i]);
		}
		
		if(!isLastBit){
			to_file.print("-");
		} else {
			to_file.println();
		}
		
		to_file.flush();
		to_file.close();
	}	
	
}
