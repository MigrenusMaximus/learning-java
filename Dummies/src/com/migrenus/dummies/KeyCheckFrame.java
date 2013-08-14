package com.migrenus.dummies;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings({ "serial", "unused" })

public class KeyCheckFrame extends JFrame implements ActionListener {
	
	public FileHandler keys = new FileHandler();
	private KeyChecker check = new KeyChecker();
	private JLabel correct = new JLabel("\nThe key is correct.");
	private JLabel notCorrect = new JLabel("\nThe key is not correct.");
	private JLabel[] keyLabel;
	
	JTextField textField = new JTextField(0);
	JButton button = new JButton("Guess");
	
	public void keyGetFrame() throws IOException {
		
		this.keys.fileInit("keygen.txt");
		
		this.setSize(350, 275);
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		this.setTitle("Mah KEEEEEEEEEEEEEEEEEYS");
		this.add(textField);
		this.add(button);
		
		this.textField.setAlignmentX(CENTER_ALIGNMENT);
		this.textField.setPreferredSize(new Dimension(200, 25));
		this.button.setAlignmentX(CENTER_ALIGNMENT);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.button.addActionListener(this);
		this.addInfo();

//		this.setSize(350, 500);
		
//		this.pack();
		this.setVisible(true);
		}
		
	private void addInfo() {
		
		this.keyLabel = new JLabel[keys.getLineAmmount()];
		
		for (int i = 0; i < keys.getLineAmmount(); i++){
			
			this.keyLabel[i] = new JLabel("null");
			
		}
		
		for (int i = 0; i < keys.getLineAmmount(); i++){
			
			this.keyLabel[i].setText(keys.getFileContents(i));
			this.add(this.keyLabel[i]);
			this.keyLabel[i].setAlignmentX(CENTER_ALIGNMENT);
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.add(notCorrect);
		this.add(correct);
		
		this.correct.setAlignmentX(CENTER_ALIGNMENT);
		this.notCorrect.setAlignmentX(CENTER_ALIGNMENT);
		
		this.correct.setVisible(false);
		this.notCorrect.setVisible(false);
		
		String testKey = this.textField.getText();
		this.textField.setText("");

		
		try {
			
			if (check.checkKey(testKey) == true) {
				this.textField.setText("");
//				this.pack();
				this.correct.setVisible(true);
			} else {
				this.textField.setText("");
//				this.pack();
				this.notCorrect.setVisible(true);
			}
			
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
	}
}