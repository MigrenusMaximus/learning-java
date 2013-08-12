package com.migrenus.dummies.pack;
import static java.lang.System.out;

public class EmployeeFromFile extends FileHandler {
	private String[] name = new String[128];
	private String[] surname = new String[128];
	private double[] paySize = new double[128];	
	
	public double getPaySize(int placeInArray) {
		return paySize[placeInArray];
	}
	
	public void empDataInit() {
		for (int i = 0; i < this.getLineAmmount(); i+=3){
			this.name[i/3] = this.getFileContents(i);
			this.surname[i/3] = this.getFileContents(i+1);
			this.paySize[i/3] = Double.parseDouble(this.getFileContents(i+2));
		}
	}
	
	public void printEmployeeInfo() {
		for (int i = 0; i < ((this.getLineAmmount())/3); i++){
			out.println("Name: " + this.name[i]);
			out.println("Surname: " + this.surname[i]);
			out.println("Pay ammount: " + this.paySize[i]);
		}
	}
	
}
