import static java.lang.System.out;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class FileHandler {
	private String[] fileContents = new String[128];
	private int lineAmmount = 0;
	private Scanner fileHandle;
	private String fileName;
	
	public String[] getFileContents() {
		return fileContents;
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
}
