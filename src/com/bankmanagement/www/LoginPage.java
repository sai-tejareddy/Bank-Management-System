package com.bankmanagement.www;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JFrame implements ActionListener{
	
	JButton clear,signin,signup;
	JTextField nameField;
	JPasswordField passwordField;

    public LoginPage() {
        setTitle("TEJA BANK");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        setLayout(null); 
        getContentPane().setBackground(new Color(255, 182, 193));
        JLabel label = null;

        try {
            ImageIcon image = new ImageIcon(getClass().getResource("/icons/teja.png"));
        
            Image im=image.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        
            ImageIcon icon = new ImageIcon(im);
        
            label = new JLabel(icon);
        
            label.setBounds(60,20,70,70);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        
        add(label);
        
        JLabel title=new JLabel();
        title.setText("Welcome to ATM ");
        title.setFont(new Font("SansSerif", Font.BOLD, 30));
        title.setBounds(180, 20, 500, 60);
        add(title);
        
        JLabel name=new JLabel();
        name.setText("Card no.  ");
        name.setFont(new Font("Times New Roman", Font.BOLD, 25));
        name.setBounds(70, 105, 250, 40);
        add(name);
        
        nameField=new JTextField();
        nameField.setFont(new Font("Display", Font.PLAIN, 16));
        nameField.setBounds(180, 110, 300, 30);
        add(nameField);
        
        JLabel pin=new JLabel();
        pin.setText("Pin ");
        pin.setFont(new Font("Times New Roman", Font.BOLD, 25));
        pin.setBounds(70, 170, 100, 40);
        add(pin);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(180, 175, 300, 30);
        add(passwordField);
        
        signin =new JButton("SignIn");
        signin.setBounds(180,230,100,30);
        signin.setBackground(Color.black);
        signin.setForeground(Color.white);
        signin.addActionListener(this);
        add(signin);
        
        clear =new JButton("Clear");
        clear.setBounds(350,230,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        signup =new JButton("SignUp");
        signup.setBounds(260,280,100,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
         

        setVisible(true); 
        getContentPane().setBackground(new Color(240, 240, 240)); 
    }
    
    public void actionPerformed(ActionEvent ae) {
    	
    	if(ae.getSource()==clear) {
    		
    		nameField.setText("");
    		passwordField.setText("");
    	}
    		
    	
    	
        else if (ae.getSource() == signin){
        	
        	Connect conn =new Connect();
        	String cardnumber= nameField.getText();
        	String pinnumber =passwordField.getText();
        	String query= "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";

        	try {

        	     ResultSet rs =conn.s.executeQuery(query);

        	     if (rs.next()) {

        	          setVisible(false);
        	          new Transactions(pinnumber) .setVisible(true);

        	      } 
        	      else {
        		       JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
        	      }

        	} 
        	catch (Exception e) {

        	   e.printStackTrace();
    	
             }
        }
    	else if (ae.getSource() == signup) {
    		setVisible(false);
    		new SignUp().setVisible(true);
    		
    	}
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}