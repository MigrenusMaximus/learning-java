/*
 * 0-9 == 48-57
 * A-Z == 65-90
 * a-z == 97-122
 * 
 * median == 90
 * final = noOfChars * median;
 * 
 */

import java.util.Random;
import static java.lang.System.out;

public class KeyGenerator extends FileHandler {
	private char[] key = new char[5];
	private int keyValue;
	
	public KeyGenerator(int keyValue){
		this.keyValue = keyValue;
	}
	
	public void makeKey() {
		int placeHolder = 0;
		while (key[0]+key[1]+key[2]+key[3]+key[4]!=this.keyValue){
			for (int i = 0; i < 5; i++){
				placeHolder = 0;
				while ( !((placeHolder >= 48 && placeHolder <= 57) || 
						(placeHolder >= 65 && placeHolder <= 90)) ) {
					placeHolder = new Random().nextInt(122) + 1;
				}
				this.key[i] = (char) placeHolder;
			}
		}
	}
	
	public void printKey() {
		for (int i = 0; i < 5; i++){
			out.print(this.key[i]);
		}
	}
}
