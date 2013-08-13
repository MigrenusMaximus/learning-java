package com.migrenus.dummies;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
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
	
	JTextField textField = new JTextField(20);
	JButton button = new JButton("Guess");
	
	public void keyGetFrame() throws IOException {
		
		keys.fileInit("keygen.txt");
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		this.setTitle("Mah KEEEEEEEEEEEEEEEEEYS");
		this.add(textField);
		this.add(button);
		
		this.textField.setAlignmentX(CENTER_ALIGNMENT);
		this.button.setAlignmentX(CENTER_ALIGNMENT);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.button.addActionListener(this);
		this.addInfo();

		this.pack();
		this.setVisible(true);
		}
		
	private void addInfo() {
		for (int i = 0; i < keys.getLineAmmount(); i++){
			add(new JLabel(keys.getFileContents(i)));
			add(new JLabel("\n"));
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
				this.pack();
				this.correct.setVisible(true);
			} else {
				this.textField.setText("");
				this.pack();
				this.notCorrect.setVisible(true);
			}
			
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
	}
}