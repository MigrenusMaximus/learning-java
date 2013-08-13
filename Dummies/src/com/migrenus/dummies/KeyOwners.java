package com.migrenus.dummies;

import java.io.IOException;

public class KeyOwners {
	
	private KeyGenerator keys = new KeyGenerator(5, 5, 350);
	private EmployeeFromFile employees = new EmployeeFromFile();
	private FileHandler output = new FileHandler();
	private String[] employeeKey;
	
	public void assignKeysToEmployees() throws IOException{
				
		employees.fileInit("employees.txt");
		employees.empDataInit();
		this.employeeKey = new String[employees.noOfEmployees];
		
		for (int i = 0; i < employees.noOfEmployees; i++){
			keys.makeKey();
			this.employeeKey[i] = keys.getKey(); 
		}	
	}
	
	public void sendDataToFile() throws IOException{
		for (int i = 0; i < employees.noOfEmployees; i++){
			output.fileInit("employee_keys.txt");
			output.setLineLn(employees.name[i] + " " + employees.surname[i] + "\t-\t" + this.employeeKey[i]);
		}
	}
	
}
