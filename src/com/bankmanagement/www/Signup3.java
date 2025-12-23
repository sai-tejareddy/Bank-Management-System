package com.bankmanagement.www;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class Signup3 extends JFrame implements ActionListener{
	
	JRadioButton r1,r2,r3,r4;
	JCheckBox  c1,c2,c3,c4,c5,c6,c7;
	JButton submit,cancel;
	String formno;
	
	
	Signup3(String formno){
		this.formno=formno;
		
		setLayout(null);
		
		JLabel l1=new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		l1.setBounds(280,40,400,40);
		add(l1);
		
		JLabel type=new JLabel("Account Type");
		type.setFont(new Font("Raleway",Font.BOLD,20));
		type.setBounds(100,140,200,30);
		add(type);
		
		r1=new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway", Font. BOLD, 16));
		r1.setBackground (Color.WHITE);
		r1.setBounds (100, 180, 150, 20);
		add(r1);

		r2=new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Raleway", Font. BOLD, 16));
		r2.setBackground(Color.WHITE); 
		r2.setBounds (350, 180, 200, 20); 
		add(r2);

		r3=new JRadioButton("Current Account");
		r3.setFont(new Font("Raleway", Font. BOLD, 16));
		r3.setBackground (Color.WHITE); 
		r3.setBounds (100, 220, 170,20);
    	add(r3);
    	
    	r4=new JRadioButton("Recurring Deposit Account");
		r4.setFont(new Font("Raleway", Font. BOLD, 16));
		r4.setBackground (Color.WHITE); 
		r4.setBounds (350, 220, 250,20);
    	add(r4);
    	
    	ButtonGroup groupaccount = new ButtonGroup();
    	groupaccount.add(r1);
    	groupaccount.add(r2);
    	groupaccount.add(r3);
    	groupaccount.add(r4);
    	
    	JLabel card =new JLabel("Card Number");
    	card.setFont(new Font("Raleway", Font. BOLD, 22));
    	card.setBounds (100, 300, 200, 30);
    	add(card);

    	JLabel number =new JLabel("XXXX-XXXX-XXXX-4184");
     	number.setFont(new Font("Raleway", Font. BOLD, 22));
    	number.setBounds (330, 300, 300, 30);
    	add(number);
    	
    	JLabel carddetail = new JLabel("Your 16 Digit Card Number");
    	carddetail.setFont(new Font("Raleway", Font. BOLD, 12));
    	carddetail.setBounds (100, 330, 300, 20);
    	add(carddetail);
    	
    	JLabel pin = new JLabel("PIN:");
    	pin.setFont (new Font("Raleway", Font.BOLD, 22));
    	pin.setBounds (100, 370, 200, 30);
    	add(pin);

    	JLabel pnumber = new JLabel("XXXX");
    	pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
    	pnumber.setBounds (330, 370, 300, 30);
    	add (pnumber);

    	JLabel pindetail = new JLabel("Your 4 Digit Password");
    	pindetail.setFont(new Font("Raleway", Font.BOLD, 12));
    	pindetail.setBounds(100, 400, 300, 20);
    	add(pindetail);
    	
    	JLabel services=  new JLabel("Services Required:");
    	services.setFont(new Font("Raleway", Font.BOLD, 22));
    	services.setBounds (100, 450, 200, 30);
    	add(services);
    	
    	c1 = new JCheckBox ("ATM CARD");
    	c1.setBackground (Color.WHITE);
    	c1.setFont(new Font("Raleway", Font. BOLD, 16));
    	c1.setBounds (100, 500, 200, 30); 
    	add(c1);
    	
    	c2 =new JCheckBox("Internet Banking");
    	c2.setBackground (Color.WHITE);
    	c2.setFont(new Font("Raleway", Font. BOLD, 16));
    	c2.setBounds(350, 500, 200,30);
    	add(c2);

    	c3 = new JCheckBox ("Mobile Banking");
    	c3.setBackground (Color.WHITE);
    	c3.setFont(new Font("Raleway", Font. BOLD, 16));
    	c3.setBounds (100, 550, 200,30);
    	add(c3);
    	
    	c4 = new JCheckBox("EMAIL & SMS Alerts");
    	c4.setBackground (Color.WHITE);
    	c4.setFont(new Font("Raleway", Font. BOLD, 16));
    	c4.setBounds (350, 550, 200,30);
    	add(c4);
    	
    	c5 = new JCheckBox("Cheque Book");
    	c5.setBackground (Color.WHITE);
    	c5.setFont(new Font("Raleway", Font. BOLD, 16));
    	c5.setBounds (100, 600, 200,30);
    	add(c5);

    	c6 = new JCheckBox ("E-Statement");
    	c6.setBackground (Color.WHITE);
    	c6.setFont(new Font("Raleway", Font. BOLD, 16));
    	c6.setBounds (350, 600, 200,30);
    	add(c6);
    	
    	c7 = new JCheckBox ("I hereby declares that the above entered details are correct to the best of my knowledge");
    	c7.setBackground (Color.WHITE);
    	c7.setFont(new Font("Raleway", Font. BOLD, 12));
        c7.setBounds (100, 680, 600,30);
   		add(c7);
   		
   		submit = new JButton("Submit");
   		submit.setBackground (Color.BLACK);
   		submit.setForeground(Color.WHITE);
   		submit.setFont(new Font("Raleway", Font. BOLD, 14));
   		submit.setBounds (250, 720, 100, 30);
   		submit.addActionListener(this);
   		add (submit);

   		cancel = new JButton("Cancel");
   		cancel.setBackground (Color.BLACK);
   		cancel.setForeground(Color.WHITE);
   		cancel.setFont(new Font("Raleway", Font. BOLD, 14));
   		cancel.setBounds (420, 720, 100, 30);
   		cancel.addActionListener(this);
   		add(cancel);
   		 		
   		JPanel panel = new JPanel();
   		panel.setLayout(null);
   		panel.setPreferredSize(new Dimension(850, 900)); 

   		panel.add(l1);
   		panel.add(type);
   		panel.add(r1);
   		panel.add(r2);
   		panel.add(r3);
   		panel.add(r4);
   		panel.add(card);
   		panel.add(number);
   		panel.add(carddetail);
   		panel.add(pin);
   		panel.add(pnumber);
   		panel.add(pindetail);
   		panel.add(services);
   		panel.add(c1);
   		panel.add(c2);
   		panel.add(c3);
   		panel.add(c4);
   		panel.add(c5);
   		panel.add(c6);	
   		panel.add(c7);
   		panel.add(submit);
   		panel.add(cancel);
   		

   		JScrollPane scrollPane = new JScrollPane(panel);
   		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
   		setContentPane(scrollPane);

		
		
		setSize(850,800);
		setLocation(350,0);
		
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== submit) {
			String accountType = null;

			if (r1.isSelected()) {

			  accountType = "Saving Account";

			} else if (r2.isSelected()) {

			  accountType = "Fixed Deposit Account";

			} else if (r3.isSelected()) {

			  accountType = "Current Account";

			} else if (r4.isSelected()) {

			  accountType = "Reccuring Deposit Account";

			}
			Random random= new Random();

			String cardnumber = ""+Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

			String pinnumber =""+ Math.abs((random.nextLong() % 9000L) + 1000L);

			String facility = "";
			
			if (c1.isSelected()) {
			   facility =facility + "ATM Card,";

			}if (c2.isSelected()) {
			   facility =facility + " Internet Banking,";
			
			}if (c3.isSelected()) {
			   facility =facility + " Mobile Banking,";

			}if (c4.isSelected()) {
				facility =facility + " EMAIL & SMS Alerts,";

			}if (c5.isSelected()) {
				facility= facility + " Cheque Book,";

			}if (c6.isSelected()) {
				facility =facility + " E-Statement";

			}
			try {
				if (accountType == null || accountType.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Account Type is Required");
				}
				else if(facility.equals("")) {
					JOptionPane.showMessageDialog(null, "Atleast select one Facility");
				}
				if (!c7.isSelected()) {
				    JOptionPane.showMessageDialog(null, "Please confirm the declaration.");
				    return;
				}

				else {
					Connect c=new Connect();
					
					 String query = "INSERT INTO signup3 VALUES ('"+formno+"','" + accountType + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";
					 String query1 = "INSERT INTO login VALUES ('"+formno+"','" + cardnumber + "','" + pinnumber + "')";
					 
					 c.s.executeUpdate(query);
					 c.s.executeUpdate(query1);
					 
					 
					 JOptionPane.showMessageDialog(null, "Card Number "+ cardnumber + "\n Pin: " +pinnumber );
					 
					 setVisible(false);
					 new Deposit(pinnumber).setVisible(true);
					 
					 
					 
				}
			}
			catch(Exception ae) {
				ae.printStackTrace();
			}
		}
		else if(e.getSource()== cancel) {
			
			setVisible(false);
			
			new LoginPage().setVisible(true);
			
		}
		
	}

	
	public static void main(String[] args) {
		new Signup3("");
	}

	
	

}
