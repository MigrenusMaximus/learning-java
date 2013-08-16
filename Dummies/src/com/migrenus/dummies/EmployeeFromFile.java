package com.migrenus.dummies;

import static java.lang.System.out;

import java.io.IOException;

public class EmployeeFromFile extends FileHandler {
	
	public String[] name;
	public String[] surname;
	private double[] paySize;
	public int noOfEmployees;
	
	public double getPaySize(int placeInArray) {
		return paySize[placeInArray];
	}
	
	public void empDataInit() throws IOException {
		
		this.fileInit("employees.txt");
		this.name = new String[this.getLineAmmount()/3];
		this.surname = new String[this.getLineAmmount()/3];
		this.paySize = new double[this.getLineAmmount()/3];
		
		for (int i = 0; i < this.getLineAmmount() - 1; i+=3){
			
			this.name[i/3] = this.getFileContents(i);
			this.surname[i/3] = this.getFileContents(i+1);
			this.paySize[i/3] = Double.parseDouble(this.getFileContents(i+2));
			
		}
		
		this.noOfEmployees = (this.getLineAmmount()/3);
		this.closeOpenFile();
	}
	
public void empDataInit(String fileName) throws IOException {
		
		this.fileInit(fileName);
		this.name = new String[this.getLineAmmount()/3];
		this.surname = new String[this.getLineAmmount()/3];
		this.paySize = new double[this.getLineAmmount()/3];
		
		for (int i = 0; i < this.getLineAmmount() - 1; i+=3){
			
			this.name[i/3] = this.getFileContents(i);
			this.surname[i/3] = this.getFileContents(i+1);
			this.paySize[i/3] = Double.parseDouble(this.getFileContents(i+2));
			
		}
		
		this.noOfEmployees = (this.getLineAmmount()/3);
		this.closeOpenFile();
	}
	
	public void printEmployeeInfo() {
		
		for (int i = 0; i < this.noOfEmployees; i++){
			
			out.println("Name: " + this.name[i]);
			out.println("Surname: " + this.surname[i]);
			out.println("Pay ammount: " + this.paySize[i]);
			
		}
	}
	
	public String getEmployeeName(int i){
		return this.name[i];
	}
	
	public String getEmployeeSurname(int i){
		return this.surname[i];
	}
	
}
