package com.migrenus.dummies;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class KeyDisplayFrame extends KeyFrame {
	
	private FileHandler keys = new FileHandler();
	private JButton button = new JButton("OK");
	private JLabel[] keyLabel;
	
	@Override
	public void keyGetFrame() throws IOException{
		
		this.button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonClicked();
			}
		});
		
		this.keys.fileInit("keygen.txt");
		
		this.setPreferredSize(new Dimension(350, 20*keys.getLineAmmount() + 50));
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		this.setTitle("Current Keys");
		this.addInfo();
		this.add(button);
		
		this.button.setAlignmentX(CENTER_ALIGNMENT);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.pack();
		
		this.setVisible(true);
		
	}
	
	public void buttonClicked() {
		
		this.dispose();
		
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
	
}
