package com.migrenus.dummies;

/**
 *  @author MigrenusMaximus
 * 	
 * This is the main executable class 
 * 
 */

import static java.lang.System.out;
import static java.lang.System.in;

import java.util.Scanner;
import java.io.IOException;

@SuppressWarnings("unused")
public class DaProgram {
	public static void main(String[] args) throws IOException {
		
		KeyGenerator key = new KeyGenerator(5, 5, 350);
		key.makeKey();
		key.printKey();
		key.keyToFile("keygen.txt");
		
	}
}
