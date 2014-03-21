package com.migrenus.dummies;

import java.util.Random;

public class EncryptorV2 {
	
	//the private key is the length of the alphabet, upper and lower case, digits and the space character
	private char[] privateKey = new char[63];
	//used for plaintext
	private char[] unencryptedText;
	//used for ciphertext
	private char[] encryptedText;
	//get number of characters in the text
	private int noOfCharsInText;
	//the english alphabet + digits + space character
	private char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
			'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' '};
	//plain and ciphertext strings for easier input 
	public String inputText;
	public String outputText;
	
	//returns the private key if it's assigned
	public String getPrivateKey() {
		return this.privateKey.toString();
	}
	
	//returns plaintext
	public String getDecryptedText() {
		this.inputText = String.valueOf(this.unencryptedText);
		return this.inputText;
	}
	
	//returns ciphertext
	public String getEncryptedText() {
		this.outputText = String.valueOf(this.encryptedText);
		return this.outputText;
	}
	
	//prepares plaintext
	public void textInputForEncryption() {		
		this.noOfCharsInText = this.inputText.length();
		this.unencryptedText = new char[this.noOfCharsInText];
		this.unencryptedText = this.inputText.toCharArray();
		this.encryptedText = new char[this.noOfCharsInText];
		
	}
	
	//prepares ciphertext
	public void textInputForDecryption() {
		
		this.noOfCharsInText = this.outputText.length();
		this.encryptedText = new char[this.noOfCharsInText];
		this.encryptedText = this.outputText.toCharArray();
		this.unencryptedText = new char[this.noOfCharsInText];
		
	}
	
	//the encryption method
	public void encryptText(String key) {
		int place = 0;
		char[] charKey = key.toCharArray();
		for(int i = 0; i < this.noOfCharsInText; i++) {
			for(int j = 0; j < 63; j++) {
				if(this.unencryptedText[i] == this.alphabet[j]) {
					place = i + j;
				while(place >= 63) {
					place = place - 63;
				}
				this.encryptedText[i] = charKey[place];
				}
			}
		}
		
		System.out.println(this.encryptedText);
		
	}
	
	//the decryption method
	public void decryptText(String key) {
		int place = 0;
		char[] charKey = key.toCharArray();
		for(int i = this.noOfCharsInText - 1; i >= 0; i--) {
			for(int j = 62; j >= 0; j--) {
				if(this.encryptedText[i] == charKey[j]) {
					place = j - i;
					while(place < 0) {
						place = place + 63;
					}
				this.unencryptedText[i] = this.alphabet[place];
				}
			}
		}
		
	System.out.println(this.unencryptedText);
		
	}
	
	//this bit is used to generate custom encryption keys	
	public void encryptionKeyGenerator() {
		
		for(int i = 0; i < 63; i++) {
			if(i!=0){
			if(this.consistencyScan(i)){
				this.privateKey[i] = this.alphabet[new Random().nextInt(63)];					
			} else {
				i= i - 2;
			}
			} else { this.privateKey[i] = this.alphabet[new Random().nextInt(63)]; 

			}	
		}

		System.out.println(this.privateKey);	
		
	}
	
	//used to check that there are no dupes in the private key
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
