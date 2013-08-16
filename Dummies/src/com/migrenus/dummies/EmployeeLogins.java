package com.migrenus.dummies;

import java.io.IOException;

public class EmployeeLogins extends EmployeeFromFile {
	
	private String[] usernames;
	private String[] passwords;
	private String employeeFile;
	private String passwordFile;
	
	public EmployeeLogins() {
		this.employeeFile = "employees.txt";
		this.passwordFile = "passwords.txt";
	}
	
	public EmployeeLogins(String employeeFile, String passwordFile) {
		this.employeeFile = employeeFile;
		this.passwordFile = passwordFile;
	}
	
	public void loginDataInit() throws IOException {
		
		this.empDataInit(this.employeeFile);
		this.usernames = new String[this.noOfEmployees];
		this.passwords = new String[this.noOfEmployees];
		
		for (int i = 0; i < this.noOfEmployees; i++) {
			this.usernames[i] = this.getEmployeeName(i);
		}
		
		this.closeOpenFile();
		
		this.fileInit(this.passwordFile);
		
		for (int i = 0; i < this.noOfEmployees; i++) {
			this.passwords[i] = this.getFileContents(i);
		}
		
		this.closeOpenFile();
		
	}

	public boolean employeeLogin(String username, String password) {
		
		for (int i = 0; i < this.noOfEmployees; i++) {
			
			if (this.usernames[i].equals(username)) {
				if (this.passwords[i].equals(password)){
					return true;
				} else {
					return false;
				}
			}
			
		}
		
		return false;
	}
	
}
