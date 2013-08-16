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
	
		KeyOwners asd = new KeyOwners();
		asd.assignKeysToEmployees();
		asd.sendDataToFile();
		
//		KeyFrame asd = new KeyFrame();
//		asd.keyGetFrame();
		
	}
}
