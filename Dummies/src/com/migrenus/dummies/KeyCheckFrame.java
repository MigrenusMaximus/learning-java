package com.migrenus.dummies;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;

@SuppressWarnings({ "serial", "unused" })

public class KeyCheckFrame extends JFrame {
	
	public FileHandler keys = new FileHandler();
	
	public void KeyGetFrame() throws IOException {
		
		keys.fileInit("keygen.txt");
		keys.getLinesWithComment();

		this.setTitle("Mah KEEEEEEEEEEEEEEEEEYS");
		this.setLayout(new GridLayout(keys.getLineAmmount(), 1, 20, 0));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(350, 20*keys.getLineAmmount());
		this.addInfo();
		
		//this.pack();
		this.setVisible(true);
		}
		
	private void addInfo() {
		for (int i = 0; i < keys.getLineAmmount(); i++){
			add(new JLabel(keys.getFileContents(i)));
		}
	}
}