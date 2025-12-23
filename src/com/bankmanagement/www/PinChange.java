package com.bankmanagement.www;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PinChange extends JFrame implements ActionListener{
	
	  JPasswordField pin,repin;
	  JButton change,back;
	  String pinnumber;

       PinChange (String pinnumber) {
    	        this.pinnumber = pinnumber;
                setLayout(null);

                ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
                Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
                ImageIcon i3 =new ImageIcon(i2);
                JLabel image= new JLabel(i3);            
                image.setBounds(0, 0, 900, 900);
                add(image);
                
                JLabel text = new JLabel("Change your pin here");
        		text.setBounds(235, 280, 700, 35);
        		text.setForeground(Color.WHITE);
        		text.setFont(new Font("System", Font. BOLD, 16));	
        		image.add(text);
        		
        		JLabel pintext = new JLabel("New PIN:");
        		pintext.setForeground(Color.WHITE);
        		pintext.setFont(new Font("System", Font. BOLD, 16));
        		pintext.setBounds (165, 320, 180, 25);
        		image.add(pintext);

        		pin =new JPasswordField();
        		pin.setFont(new Font("Raleway", Font. BOLD, 25));
        		pin.setBounds (330, 320, 180, 25);
        		image.add(pin);

        		JLabel repintext = new JLabel("Re-Enter New PIN");
        		repintext.setForeground (Color.WHITE);
        		repintext.setFont(new Font("System", Font. BOLD, 16));
        		repintext.setBounds(165, 360, 180, 25);
        		image.add(repintext);
        		
        		
        		repin =new JPasswordField();
        		repin.setFont(new Font("Raleway", Font. BOLD, 25));
        		repin.setBounds (330, 360, 180, 25);
        		image.add(repin);
                
                change = new JButton("Change");
                change.setBounds(355, 485, 150, 30);
                change.addActionListener(this);
                image.add(change);

                back = new JButton("Back");
                back.setBounds(355, 520, 150, 30);
                back.addActionListener(this);
                image.add(back);

                setSize(900, 900);
                setLocation(300, 0);
                setUndecorated(true);
                setVisible(true);

               }
       public void actionPerformed(ActionEvent ae) {
    	   
    	   if (ae.getSource() == back) {
   	          
    		    setVisible(false);
   	            new Transactions(pinnumber).setVisible(true);
    	   }
    	   else {
    		   String pintext=pin.getText();
    		   String repintext=repin.getText();
    		   try {
    			   
    			   if(pintext.equals("")||pintext.length() != 4||repintext.equals("")||repintext.length() != 4) {  			
       	            JOptionPane.showMessageDialog(null, "Please enter a valid 4-digit PIN.");
       	            return;
       	           }
    			   if(!pintext.equals(repintext)) {
    				   JOptionPane.showMessageDialog(null, "Pin is not matching");
          	            return;
    			   }
    			   Connect con=new Connect();
    			   String query1="Update bank set pin='"+pintext+"' where pin='"+pinnumber+"'";
    			   String query2="Update login set pin='"+pintext+"' where pin='"+pinnumber+"'"; 
    			   String query3="Update signup3 set pin='"+pintext+"' where pin='"+pinnumber+"'";
    			   
    			   con.s.executeUpdate(query1);
    			   con.s.executeUpdate(query2);
    			   con.s.executeUpdate(query3);
    			   
    			   JOptionPane.showMessageDialog(null, "You Updated Pin Successfully");
    			   
    			   setVisible(false);
    			   new Transactions(pintext).setVisible(true);
    			   
    			   
    			   
    		   }
    		   catch(Exception e) {
    			   e.printStackTrace();
    		   }
    		   
    		   
    	   }
    	   
    	   
       }
       

       public static void main(String args[]) {

    	   new PinChange("").setVisible(true);
       }
}