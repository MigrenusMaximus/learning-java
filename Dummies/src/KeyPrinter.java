/*
import java.io.IOException;

public class KeyPrinter {
		
	public void keyToFile(String fileName, KeyGenerator key) throws IOException {		
		int keyBits = key.length;
		
		for (int i = 0; i < (keyBits-1); i++) {
				key[i].keyToFile(fileName, keyBitSize, false);
		}
		
		key[keyBits-1].keyToFile(fileName);
	}
	
	public void keyToConsole(int keyBitSize, KeyGenerator[] key){
		int keyBits = key.length;
		
		for (int i = 0; i < (keyBits-1); i++) {
			key[i].printKey(keyBitSize, false);
		}
	
		key[keyBits-1].printKey(keyBitSize, true);
		
	}
	
}
*/