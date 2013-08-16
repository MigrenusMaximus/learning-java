package com.migrenus.dummies;

/**
 * 	@author MigrenusMaximus
 * 
 * This class handles file input
 * in a way specific to what is needed
 * in the application
 * 
 */


import static java.lang.System.out;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

public class FileHandler {
	private String[] fileContents;
	private int lineAmmount = 0;
	private Scanner fileHandle;
	private String fileName;
	private boolean withOverWrite;
	
	public FileHandler(boolean withOverWrite) {
		this.withOverWrite = withOverWrite;
	}
	
	public FileHandler() {
		this.withOverWrite = false;
	}
	
	public String getFileContents(int placeInArray) {
		return fileContents[placeInArray];
	}

	public int getLineAmmount() {
		return lineAmmount;
	}

	public Scanner getFileHandle() {
		return fileHandle;
	}

	public String getFileName() {
		return fileName;
	}
	
	public void fileInit(String fileName) throws IOException {
		this.fileName = fileName;
		this.fileHandle = new Scanner(new File(this.fileName));
		this.getLines();
	}
	
	public void getLines() throws FileNotFoundException {
		@SuppressWarnings("unused")
		String placeHolder = " ";
		int noOfLines = 0;
		Scanner bread = new Scanner(new File(this.fileName));
		
		for (;;) {
			placeHolder = bread.nextLine().toString();
			noOfLines++;
			if (!bread.hasNextLine()) {
				this.lineAmmount = noOfLines + 1;
				bread.close();
				break;
			}
		}
		
		this.fileContents = new String[this.lineAmmount];
		
		for (int i = 0; i < this.lineAmmount - 1; i++) {
			this.fileContents[i] = this.fileHandle.nextLine().toString();
		}
	}
	
	public void getLinesWithComment() throws FileNotFoundException {
		
		String placeHolder = " ";
		int noOfLines = 0;
		Scanner bread = new Scanner(new File(this.fileName));
		
		for (;;) {
			placeHolder = bread.nextLine().toString();
			noOfLines++;
			if (!bread.hasNextLine()) {
				this.lineAmmount = noOfLines + 1;
				out.println("End of file.");
				out.println("The file " + this.fileName + " has " + this.lineAmmount + " lines.");
				out.println("\"" + placeHolder + "\"" + " is the last line of the file.");
				bread.close();
				break;
			}
		}
		
		this.fileContents = new String[this.lineAmmount];
		
		for (int i = 0; i < this.lineAmmount - 1; i++) {
			this.fileContents[i] = this.fileHandle.nextLine().toString();
		}
		
	}
	
	public void setLineLn(String line, boolean firstLine) throws IOException {
		
		if (this.withOverWrite == false || firstLine == false) {
			PrintWriter to_file = new PrintWriter(new FileWriter(this.fileName, true)); 
			to_file.println(line);
			to_file.close();
		} else {
			PrintStream to_file = new PrintStream(this.fileName);
			to_file.println(line);
			to_file.close();
		}
		
	}
	
	public void setLine(String line, boolean firstLine) throws IOException {
		
		if (this.withOverWrite == false || firstLine == false) {
			PrintWriter to_file = new PrintWriter(new FileWriter(this.fileName, true)); 
			to_file.print(line);
			to_file.close();
		} else {
			PrintStream to_file = new PrintStream(this.fileName);
			to_file.print(line);
			to_file.close();
		}
		
	}
	
	public void closeOpenFile(){
		this.fileHandle.close();
	}

}


/*
 * 
 * This comment is used for future reference
 * 
 * "Pulling apart delimited items on a line."
 * 
 *  String text = "Beggars in Spain*Nancy Kress*1992"; 
 	StringTokenizer tokenizer = new StringTokenizer(text,"*"); 
 	String title = tokenizer.nextToken(); 
 	String author = tokenizer.nextToken(); 
 	String year = tokenizer.nextToken();
 	String letters = "a b c d e f g h i j"; 
 	StringTokenizer tokenizer = new StringTokenizer(text," "); 
 	String[] allText = new String[10]; 
 	int pos = 0; 
 	while (tokenizer.hasMoreTokens()) 
      allText[pos++] = tokenizer.nextToken(); 
 *
 * 
 * 
 * 
 */