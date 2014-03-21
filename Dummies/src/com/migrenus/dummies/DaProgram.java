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
		
//		EmployeeLoginFrame asd = new EmployeeLoginFrame();
//		asd.frameInit();
		
//		KeyFrame asd = new KeyFrame();
//		asd.keyGetFrame();
		
//		EncryptorFrame asd = new EncryptorFrame();
//		asd.frameInit();
		
		EncryptorV2 novo = new EncryptorV2();
//		novo.inputText = "I like cookies";
//		novo.textInputForEncryption();
//		novo.encryptText("PumpWYndo57xThRNr3O690Mbck4BvV28Hyq1zXDwJiSICUjlEeKsgQAa tLFZf6");
//		novo.getEncryptedText();
		novo.outputText = "oPwXJ1Y1EejUSt";
		novo.textInputForDecryption();
		novo.decryptText("PumpWYndo57xThRNr3O690Mbck4BvV28Hyq1zXDwJiSICUjlEeKsgQAa tLFZf6");
		
//		you can use this private key for testing
//		PumpWYndo57xThRNr3O690Mbck4BvV28Hyq1zXDwJiSICUjlEeKsgQAa tLFZf6
		
//		5BuiIUDld KEjshCSrQeesZMt6fta
		
	}
}
