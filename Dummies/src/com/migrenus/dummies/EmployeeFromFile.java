package com.migrenus.dummies;

import static java.lang.System.out;

public class EmployeeFromFile extends FileHandler {
	
	public String[] name = new String[128];
	public String[] surname = new String[128];
	private double[] paySize = new double[128];
	public int noOfEmployees;
	
	public double getPaySize(int placeInArray) {
		return paySize[placeInArray];
	}
	
	public void empDataInit() {

		this.getLines();
		
		for (int i = 0; i < this.getLineAmmount(); i+=3){
			
			this.name[i/3] = this.getFileContents(i);
			this.surname[i/3] = this.getFileContents(i+1);
			this.paySize[i/3] = Double.parseDouble(this.getFileContents(i+2));
			
		}
		
		this.noOfEmployees = (this.getLineAmmount()/3);
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
