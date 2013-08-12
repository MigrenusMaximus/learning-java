package com.migrenus.dummies;

import java.io.IOException;

public class KeyOwners {
	private KeyGenerator[] keys;
	private EmployeeFromFile employees;
	
	public void assignKeysToEmployees() throws IOException{
		
		employees.fileInit("employees.txt");
		employees.empDataInit();
		
		keys = new KeyGenerator[employees.getLineAmmount()];
		
		for (int i = 0; i < (employees.getLineAmmount()/3); i++){
			
		}
		
	}
}
