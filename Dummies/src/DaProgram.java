/**
 *  @author MigrenusMaximus
 * 	
 * This is the main executable class
 * 
 * 
 */

import static java.lang.System.out;
import static java.lang.System.in;
import java.util.Scanner;
import java.io.IOException;

public class DaProgram {
	public static void main(String[] args) throws IOException {
		int keyBitValue = 0;
		KeyGenerator[] key = new KeyGenerator[5];
		for (int i = 0; i < 5; i++){
			out.println("Key part " + (i+1) + " value:");
			keyBitValue = new Scanner(in).nextInt(); //try to make it 290-400 for optimum results
			key[i] = new KeyGenerator(keyBitValue); //anything lower than 240 or higher than 450 will cause it to hang
			key[i].makeKey(); 						//cause it's impossible to make a combination with that value
		}
		
		for (int i = 0; i < 5; i++){
			if(i == 4){
				key[i].printKey();
				break;
			}
			
			key[i].printKey();
			out.print("-");
			
		}
	}
}
