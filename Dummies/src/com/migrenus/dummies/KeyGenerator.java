package com.migrenus.dummies;

import static java.lang.System.out;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class KeyGenerator {
	private String key = "";
	private char[] keyBit;
	private int keyBitValue;
	private int keyBits;
	private int keyBitChars;
	
	public KeyGenerator(){}
	
	public KeyGenerator(int keyBits, int keyBitChars, int keyBitValue){
		this.keyBits = keyBits;
		this.keyBitChars = keyBitChars;
		this.keyBitValue = keyBitValue;
		this.keyBit = new char[keyBitChars];
	}
	
	public int findKeyValue(int keyBitChars){
		int value = 0;
		for (int i = 0; i < keyBitChars; i++){
			value += this.keyBit[i];
		}
		return value;
	}
		
	private String makeKeyBit(int keyBitChars, int keyValue) {
		Arrays.fill(this.keyBit, ' ');
		int placeHolder = 0;
		while (findKeyValue(keyBitChars) != this.keyBitValue){
			for (int i = 0; i < keyBitChars; i++){
				placeHolder = 0;
				while ( !((placeHolder >= 48 && placeHolder <= 57) || 
						(placeHolder >= 65 && placeHolder <= 90)) ) {
					placeHolder = new Random().nextInt(122) + 1;
				}
				this.keyBit[i] = (char) placeHolder;
			}
		}
		return String.copyValueOf(this.keyBit);
	}
	
	public void makeKey(){
		for (int i = 0; i < this.keyBits; i++){
			if (i != this.keyBits - 1){
				this.key += this.makeKeyBit(this.keyBitChars, this.keyBitValue) + "-";
			} else {
				this.key += this.makeKeyBit(this.keyBitChars, this.keyBitValue);
			}
		}
	}
	
	public String getKey(){
		return this.key;
	}
	
	public void printKey() {		
		out.println(this.key);		
	}
	
	
	public void keyToFile(String fileName) throws IOException {
		PrintWriter to_file = new PrintWriter(new FileWriter(fileName, true)); 
		
		to_file.print(this.key);
		to_file.print("\n");
		to_file.flush();
		to_file.close();
	}	
	
}
