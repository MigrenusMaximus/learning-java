package com.migrenus.dummies;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EmployeeLoginFrame {
	
	private JFrame theFrame = new JFrame();
	private JTextField usernameTextField = new JTextField(5);
	private JPasswordField passwordTextField = new JPasswordField(5);
	private JButton loginButton = new JButton("Login");
	private EmployeeLogins loginCheck = new EmployeeLogins("employees.txt", "passwords.txt");
	
	public void frameInit() {
		
		this.loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					checkButtonClicked();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		this.usernameTextField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					checkButtonClicked();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		this.passwordTextField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					checkButtonClicked();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		theFrame.setPreferredSize(new Dimension(350, 125));
		
		theFrame.getContentPane().setLayout(new BoxLayout(theFrame.getContentPane(), BoxLayout.PAGE_AXIS));
		theFrame.setTitle("Login");
		theFrame.add(this.usernameTextField);
		theFrame.add(this.passwordTextField);
		theFrame.add(this.loginButton);
		
		this.usernameTextField.setPreferredSize(new Dimension(250, 25));
		this.passwordTextField.setPreferredSize(new Dimension(250, 25));
		
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		theFrame.pack();
		theFrame.setVisible(true);
		
		
	}
	
	@SuppressWarnings("deprecation")
	public void checkButtonClicked() throws IOException {
		
		loginCheck.loginDataInit();
		
		if (loginCheck.employeeLogin(this.usernameTextField.getText(), this.passwordTextField.getText())){
			this.usernameTextField.setText("Login accepted");			
		} else {
			this.usernameTextField.setText("Invalid username/password");
		}
		
		this.passwordTextField.setText("");
		this.usernameTextField.grabFocus();
		this.usernameTextField.selectAll();
		
	}
	
	

}
