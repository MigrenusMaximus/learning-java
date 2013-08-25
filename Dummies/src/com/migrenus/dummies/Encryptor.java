package com.migrenus.dummies;

import java.util.Random;

public class Encryptor {
	
	private char[] privateKey = new char[26];
	private char[] unencryptedText;
	private char[] encryptedText;
	private int noOfCharsInText;
	private char[] uppercaseAlphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	
	public String getPrivateKey() {
		return this.privateKey.toString();
	}
	
	public String getDecryptedText() {
		String text = "";
		text = String.valueOf(this.unencryptedText);
		return text;
	}
	
	public String getEncryptedText() {
		String text = "";
		text = String.valueOf(this.encryptedText);
		return text;
	}
	
	public void textInputForEncryption(String text) {
		
		this.noOfCharsInText = text.length();
		this.unencryptedText = new char[this.noOfCharsInText];
		this.unencryptedText = text.toUpperCase().toCharArray();
		this.encryptedText = new char[this.noOfCharsInText];
		
	}
	
	public void textInputForDecryption(String text) {
		
		this.noOfCharsInText = text.length();
		this.encryptedText = new char[this.noOfCharsInText];
		this.encryptedText = text.toUpperCase().toCharArray();
		this.unencryptedText = new char[this.noOfCharsInText];
		
	}
	
	public void encryptionKeyGenerator() {
		
		for(int i = 0; i < 26; i++) {
			
			while(!(this.privateKey[i] >= 65 && this.privateKey[i] <= 90)) {
				if (!this.consistencyScan(i) && i!=0){
					i -= 1;
					this.privateKey[i] = (char) new Random().nextInt(90);
				} else {
					this.privateKey[i] = (char) new Random().nextInt(90);
				}
			}
			
		}
		
		System.out.println(this.privateKey);
		
	}
	
	public void encryptText() {
		
		for(int i = 0; i < this.noOfCharsInText; i++ ) {
			
			if(this.unencryptedText[i] >= 65 && this.unencryptedText[i] <= 90){
				
				this.encryptedText[i] = this.privateKey[findPlaceInAlphabet(this.unencryptedText[i])];
				
			} else {
				
				this.encryptedText[i] = this.unencryptedText[i];
				
			}
			
		}
		
	}
	
	public void encryptText(String privateKey) {
		
		this.privateKey = privateKey.toCharArray();
		
		for(int i = 0; i < this.noOfCharsInText; i++ ) {
			
			if(this.unencryptedText[i] >= 65 && this.unencryptedText[i] <= 90){
				
				this.encryptedText[i] = this.privateKey[findPlaceInAlphabet(this.unencryptedText[i])];
				
			} else {
				
				this.encryptedText[i] = this.unencryptedText[i];
				
			}
			
		}
		
	}
	
	public void decryptText(String privateKey) {
		
		this.privateKey = privateKey.toCharArray();
		
		for(int i = 0; i < this.noOfCharsInText; i++ ) {
			
			if(this.encryptedText[i] >= 65 && this.encryptedText[i] <= 90){
				
				this.unencryptedText[i] = this.uppercaseAlphabet[findPlaceInPrivateKey(this.encryptedText[i])];
				
			} else {
				
				this.unencryptedText[i] = this.encryptedText[i];
				
			}
			
		}
		
	}
	
	private int findPlaceInAlphabet(char a) {
		
		for (int i = 0; i < 26; i++) {
			if (a == this.uppercaseAlphabet[i]) {
				return i;
			}
		}
		
		return 0;
		
	}
	
	private int findPlaceInPrivateKey(char a) {
		
		for (int i = 0; i < 26; i++) {
			if (a == this.privateKey[i]) {
				return i;
			}
		}
		
		return 0;
		
	}
	
	private boolean consistencyScan(int currentPlaceInArray) {
		
		for(int i = 0; i < currentPlaceInArray; i++) {
			
			for(int j = 0; j < i; j++) {
				if (this.privateKey[i] == this.privateKey[j]) {
					return false;
				}
			}
			
		}
		
		return true;
		
	}

}

/*
 * while ( !((placeHolder >= 48 && placeHolder <= 57) || 
						(placeHolder >= 65 && placeHolder <= 90)) ) {
					placeHolder = new Random().nextInt(122) + 1;
				}
*/
