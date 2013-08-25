package com.migrenus.dummies;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EncryptorFrame {
	
	private JFrame theFrame = new JFrame();
	private JTextField inputText = new JTextField();
	private JTextField outputText = new JTextField();
	private JTextField privateKeyText = new JTextField();
	private JButton encryptButton = new JButton("Encrypt");
	private JButton decryptButton = new JButton("Decrypt");
	private Encryptor encryptionMethods = new Encryptor();
	private JLabel forEncryptionLabel = new JLabel("Encrypted text");
	private JLabel forDecryptionLabel = new JLabel("Unencrypted text");
	private JLabel privateKeyLabel = new JLabel("Private key");
	
	
	public void frameInit() {
		
		this.encryptButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					encryptButtonClicked();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		this.decryptButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					decryptButtonClicked();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		theFrame.setPreferredSize(new Dimension(600, 480));
		
		theFrame.getContentPane().setLayout(new BoxLayout(theFrame.getContentPane(), BoxLayout.PAGE_AXIS));
		theFrame.setTitle("Encryptor");
		theFrame.add(this.forDecryptionLabel);
		theFrame.add(this.inputText);		
		theFrame.add(this.forEncryptionLabel);
		theFrame.add(this.outputText);
		theFrame.add(this.privateKeyLabel);
		theFrame.add(this.privateKeyText);
		theFrame.add(this.decryptButton);
		theFrame.add(this.encryptButton);
		
		this.inputText.setPreferredSize(new Dimension(400, 150));
		this.outputText.setPreferredSize(new Dimension(400, 150));
		this.privateKeyText.setPreferredSize(new Dimension(400, 50));
		
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		theFrame.pack();
		theFrame.setVisible(true);		
	}

	private void encryptButtonClicked() throws IOException {
		
		this.encryptionMethods.textInputForEncryption(this.inputText.getText());
		this.encryptionMethods.encryptText(this.privateKeyText.getText());
		this.outputText.setText(this.encryptionMethods.getEncryptedText().toString());
		
	}
	
	private void decryptButtonClicked() throws IOException {
		
		System.out.println(this.privateKeyText.getText());
		this.encryptionMethods.textInputForDecryption(this.outputText.getText());
		this.encryptionMethods.decryptText(this.privateKeyText.getText());
		this.inputText.setText(this.encryptionMethods.getDecryptedText());
		System.out.println(this.encryptionMethods.getDecryptedText());
		
	}
	
}
