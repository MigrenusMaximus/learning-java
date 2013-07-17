import java.io.IOException;

public class DaProgram {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		FileHandler mahFile = new FileHandler();
		String fileName;
		fileName = new java.util.Scanner(java.lang.System.in).next();
		java.lang.System.out.println(fileName);
		
		mahFile.setFileName(fileName);
		mahFile.fileInit();
		mahFile.getLines();
		
	}
}
