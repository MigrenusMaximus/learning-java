/**
 *  @author MigrenusMaximus
 * 	
 * This is the main executable class
 * 
 * 
 */


import java.io.IOException;

public class DaProgram {
	//@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		/*
		EmployeeFromFile employeeFile = new EmployeeFromFile();
		String fileName;
		
		java.lang.System.out.println("Which file would you like to access?");
		fileName = new java.util.Scanner(java.lang.System.in).next();
		
		employeeFile.setFileName(fileName);
		employeeFile.fileInit();
		employeeFile.getLines();
		
		employeeFile.empDataInit();
		employeeFile.printEmployeeInfo();
		*/
		
		KeyGenerator key = new KeyGenerator();
		
		key.makeKey();
		key.printKey();
		
	}
}
