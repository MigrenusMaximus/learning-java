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
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileHandler {
	private String[] fileContents = new String[128];
	private int lineAmmount = 0;
	private Scanner fileHandle;
	private String fileName;
	
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

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void fileInit() throws IOException {
		this.fileHandle = new Scanner(new File(this.fileName));
	}
	
	public void getLines() {
		for (int i = 0; i < 128; i++) {
			this.fileContents[i] = this.fileHandle.nextLine();
			
			if (!this.fileHandle.hasNextLine()) {
				this.lineAmmount = i + 1;
				out.println("End of file.");
				out.println("The file " + this.fileName + " has " + this.lineAmmount + " lines.");
				out.println("\"" + this.fileContents[i] + "\"" + " is the last line of the file.");
				break;
			}
		}
	}
	
	public void setLineLn(String line) throws IOException {
		PrintWriter to_file = new PrintWriter(new FileWriter(this.fileName, true)); 
		to_file.println(line);
		to_file.close();
	}
	
	public void setLine(String line) throws IOException {
		PrintWriter to_file = new PrintWriter(new FileWriter(this.fileName, true)); 
		to_file.print(line);
		to_file.close();
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