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

public class KeyFrame extends JFrame {
	
	private FileHandler keys = new FileHandler();
	private KeyChecker check = new KeyChecker();
	
	private JButton checkButton = new JButton("Check Key");
	private JButton viewKeysButton = new JButton("View Keys");	
	private JTextField textField = new JTextField(0);
	
	public void keyGetFrame() throws IOException {
		
		this.checkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkButtonClicked();
			}
		});
		
		this.viewKeysButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					viewKeysButtonClicked();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		this.keys.fileInit("keygen.txt");
		
		this.setPreferredSize(new Dimension(350, 100));
		
		this.setLayout(new FlowLayout());
		this.setTitle("Mah KEEEEEEEEEEEEEEEEEYS");
		this.add(textField);
		this.add(checkButton);
		this.add(viewKeysButton);
		
		this.textField.setAlignmentX(CENTER_ALIGNMENT);
		this.textField.setPreferredSize(new Dimension(250, 25));
		this.checkButton.setAlignmentX(LEFT_ALIGNMENT);
		this.viewKeysButton.setAlignmentX(RIGHT_ALIGNMENT);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.pack();
		this.setVisible(true);
		
	}
	
	public void viewKeysButtonClicked() throws IOException {
		
		KeyDisplayFrame keyDisplayer = new KeyDisplayFrame();
		keyDisplayer.keyGetFrame();
		
	}

	public void checkButtonClicked() {
		
		String testKey = this.textField.getText();
		
		try {
			
			if (check.checkKey(testKey) == true) {
				this.textField.setText("Key Correct");
			} else {
				this.textField.setText("Key Incorrect");
			}
			
		} catch (IOException e1) {
			
			e1.printStackTrace();
			
		}
		
	this.textField.grabFocus();
	this.textField.selectAll();
	
	}
}