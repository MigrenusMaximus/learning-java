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
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

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

	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	
	public void fileInit() throws IOException{
		this.fileHandle = new Scanner(new File(this.fileName));
	}
	
	public void getLines() {
		for (int i = 0; i < 128; i++){
			this.fileContents[i] = this.fileHandle.nextLine();
			
			if (!this.fileHandle.hasNextLine()){
				this.lineAmmount = i + 1;
				out.println("End of file.");
				out.println("The file " + this.fileName + " has " + this.lineAmmount + " lines.");
				out.println("\"" + this.fileContents[i] + "\"" + " is the last line of the file.");
				break;
			}
		}
	}
	
	public void setLine(String line){
		FileWriter output = null;
	    try {	    	
	      output = new FileWriter(this.fileName);
	      @SuppressWarnings("resource")
	      BufferedWriter writer = new BufferedWriter(output);
	      writer.write(line);	
	      
	    } catch (Exception e) {	    	
	      throw new RuntimeException(e);
	      
	    } finally {
	      if (output != null) {	    	  
	        try {
	          output.close();
	        } catch (IOException e) {
	          // Ignore issues during closing
	        }
	      }
	    }

	}
}
