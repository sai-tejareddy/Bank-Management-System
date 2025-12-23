package com.bankmanagement.www;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener{
	
	JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;
	
	
	FastCash(String pinnumber) {
		
        this.pinnumber=pinnumber;
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 =new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds (0, 0, 900, 900);
		add (image);

		JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(215, 300, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font. BOLD, 16));	
		image.add(text);
		
		deposit= new JButton("Rs 100");
		deposit.setBounds(170, 415, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);

		withdrawl= new JButton("Rs 500");
		withdrawl.setBounds(355, 415, 150, 30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastcash =new JButton("Rs 1000");
		fastcash.setBounds (170, 450, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);

		ministatement = new JButton("Rs 2000");
		ministatement.setBounds (355, 450, 150, 30);
		ministatement.addActionListener(this);
		image.add(ministatement);

		pinchange = new JButton("Rs 5000");
		pinchange.setBounds(170, 485, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry = new JButton("Rs 10000");
		balanceenquiry.setBounds (355, 485, 150, 30);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);

		exit =new JButton("Back");
		exit.setBounds (355, 520, 150, 30);
		exit.addActionListener(this);
		image.add(exit);

		setSize (900, 900);
		setLocation (300, 0);
		setUndecorated(true);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
	    if (ae.getSource() == exit) {
	        setVisible(false);
	        new Transactions(pinnumber).setVisible(true);
	    } else {
	        String amount = ((JButton) ae.getSource()).getText().substring(3); 
	        Connect c = new Connect();
	        try {
	            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
	            int balance = 0;
	            while (rs.next()) {
	                if (rs.getString("type").equals("Deposit")) {
	                    balance += Integer.parseInt(rs.getString("amount"));
	                } else {
	                    balance -= Integer.parseInt(rs.getString("amount"));
	                }
	            }

	            if (Integer.parseInt(amount) > balance) {
	                JOptionPane.showMessageDialog(null, "Insufficient balance");
	                return;
	            }

	            Date date = new Date();

	            String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'Withdrawal', '" + amount + "')";
	            c.s.executeUpdate(query);

	            JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
	            setVisible(false);
	            new Transactions(pinnumber).setVisible(true);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    } 
	}
		
	
	public static void main(String[] args) {
		new FastCash("");
	}
	
}




