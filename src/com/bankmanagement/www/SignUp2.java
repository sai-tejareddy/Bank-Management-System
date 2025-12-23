package com.bankmanagement.www;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class SignUp2 extends JFrame implements ActionListener{
	
	
	   String formno;
	   JTextField pan,aadhar;
	   JRadioButton syes,sno,eyes,eno;
	   JButton button;
	   JComboBox occupation,religion,education,income,category;

       
	   

        public SignUp2 (String formno) {
        	
        	this.formno=formno;
        	
            setLayout(null);
           
            setTitle("NEW APPLICATION FORM -Page 2");

            
            getContentPane().setBackground(Color.WHITE);
            
            

            setSize (850, 800);
            setLocation (350, 10);
            
            JLabel additionalDetails = new JLabel("Page 2: Additional Details");
            additionalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
            additionalDetails.setBounds (290, 80, 400, 30);
            add(additionalDetails);

            JLabel name = new JLabel("Religion:");
            name.setFont(new Font("Raleway", Font.BOLD, 17));
            name.setBounds (100, 140, 100, 30);
            add(name);
            
            String valReligion[] = {"Hindu","Muslim","Christian","Sikh","other"};
            religion =new  JComboBox(valReligion);
            religion.setBounds(300, 140, 400, 30);
            religion.setBackground(Color.white);
            add(religion);
            
            
            
            
            JLabel fname = new JLabel("Category:");
            fname.setFont(new Font("Raleway", Font. BOLD, 15));
            fname.setBounds (100, 190, 200, 30);
            add(fname);
            
            String categoryval[]= {"General","OBC","BC","SC","ST","Other"};
            category =new  JComboBox(categoryval);
            category.setBounds(300, 190, 400, 30);
            category.setBackground(Color.white);
            add(category);
            
            

            JLabel income1 =new JLabel("Income");
            income1.setFont (new Font("Raleway", Font. BOLD, 15));
            income1.setBounds (100, 240, 200, 30);
            add(income1);
            
            String incomecategory[] = {"Null", "< 1,50,000", "< 2,50,0000", "< 5,00,000", "Upto 10,00,000"};
            income =new JComboBox (incomecategory);
            income.setBounds (300, 240, 400, 30);
            income.setBackground(Color.WHITE);
            add(income);
            
            
            JLabel gender = new JLabel("Educational ");
            gender.setFont(new Font("Raleway", Font.BOLD, 17));
            gender.setBounds (100, 290, 200, 30);
            add (gender);
            

            JLabel gender1 = new JLabel("Qualification :");
            gender1.setFont(new Font("Raleway", Font.BOLD, 17));
            gender1.setBounds (100,315, 200, 30);
            add (gender1);
            
            String educationValues[]={"Non-Graduation", "Graduate", "Post-Graduation", "Doctrate", "Other"};
            education = new JComboBox (educationValues);
            education.setBounds (300, 315, 400, 30);
            education.setBackground(Color.WHITE);
           	add(education);
                 
            JLabel marital =new JLabel("Occupation:");
            marital.setFont(new Font("Raleway", Font.BOLD, 17));
            marital.setBounds (100, 390, 200, 30);
            add(marital);
            
            String occupationValues[] ={"Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Others"};
            occupation =new JComboBox (occupationValues);
            occupation.setBounds (300, 390, 400, 30);
            occupation.setBackground(Color.WHITE);
            add(occupation);
                
            JLabel address = new JLabel("PAN Number:");
            address.setFont(new Font("Raleway", Font. BOLD, 17));
            address.setBounds (100, 440, 200, 30);
            add (address);
            
            pan = new JTextField();
            pan.setFont(new Font("SansSerif", Font.PLAIN, 14));
            pan.setBounds(300, 440, 400, 30);
            add(pan);
            

            JLabel city = new JLabel("Aadhar Number:");
            city.setFont(new Font("Raleway", Font. BOLD, 17));
            city.setBounds (100, 490, 200, 30);
            add(city);
            
            aadhar = new JTextField();
            aadhar.setFont(new Font("SansSerif", Font.PLAIN, 14));
            aadhar.setBounds(300, 490, 400, 30);
            add(aadhar);
                     
            JLabel state = new JLabel("Senior Citizen:");
            state.setFont(new Font("Raleway", Font. BOLD, 17));
            state.setBounds (100, 540, 200, 30);
            add(state);
            
            syes = new JRadioButton("Yes");
            syes.setFont(new Font("SansSerif", Font.BOLD, 14));
            syes.setBounds(370, 540, 120, 30);
            syes.setBackground(Color.WHITE);
            add(syes);
            
            sno = new JRadioButton("No");
            sno.setFont(new Font("SansSerif", Font.BOLD, 14));
            sno.setBounds(510, 540, 120, 30);
            sno.setBackground(Color.WHITE);
            add(sno);
            
            ButtonGroup seniorGroup = new ButtonGroup();
            seniorGroup.add(syes);
            seniorGroup.add(sno);

            
            JLabel pincode =new JLabel("Existing Account:");
            pincode.setFont(new Font("Raleway", Font. BOLD, 17));
            pincode.setBounds (100, 590, 200, 30);
            add(pincode);
            
            eyes = new JRadioButton("Yes");
            eyes.setFont(new Font("SansSerif", Font.BOLD, 14));
            eyes.setBounds(370, 590, 120, 30);
            eyes.setBackground(Color.WHITE);
            add(eyes);
            
            eno = new JRadioButton("No");
            eno.setFont(new Font("SansSerif", Font.BOLD, 14));
            eno.setBounds(510, 590, 120, 30);
            eno.setBackground(Color.WHITE);
            add(eno);
            
            ButtonGroup accountGroup = new ButtonGroup();
            accountGroup.add(eyes);
            accountGroup.add(eno);

            
            button=new JButton("next");
            button.setBounds(640,630,60,20);
            button.setBackground(Color.black);
            button.setForeground(Color.WHITE);
            button.addActionListener(this);
            button.addActionListener(this);
            add(button);
       
            setVisible(true); 
            
        }
        public void actionPerformed(ActionEvent ae) {
        	
        	
        	String sreligion=(String) religion.getSelectedItem();
        	String scategory=(String) category.getSelectedItem();
        	String sincome=(String) income.getSelectedItem();
        	String seducation=(String) education.getSelectedItem();
        	String soccupation=(String) occupation.getSelectedItem();
        	String span=pan.getText();
        	String saadhar=aadhar.getText();
        	String seniorcitizen =null;
        	if(syes.isSelected()) {
        		seniorcitizen="Yes";
        	}
        	else if(sno.isSelected()) {
        		seniorcitizen="No";
        	}
        	String accountexist =null;
        	if(eyes.isSelected()) {
        		accountexist="Yes";
        	}
        	else if(eno.isSelected()) {
        		accountexist="No";
        	}
        	try {
       		 if (span.equals("")) {
       	              JOptionPane.showMessageDialog(null, "Name is required");
       	     } else if (saadhar.equals("")) {
       	              JOptionPane.showMessageDialog(null, "Father's name is required");
       	     }  else if (seniorcitizen == null) {
       	             JOptionPane.showMessageDialog(null, "Please select are you seniorcitizen");
       	     }   else if (accountexist == null) {
       	         JOptionPane.showMessageDialog(null, "Please select your do you have any existingAccount");
       	     }  
       	     else {
       	    	     Connect c= new Connect();
       		         String query = "INSERT INTO signup2 VALUES ('"+formno+"','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" +saadhar + "','" + seniorcitizen+ "','" + accountexist + "')";
                     c.s.executeUpdate(query);
                     JOptionPane.showMessageDialog(null, "Form submitted successfully!");
                     
                     setVisible(false);
                     new Signup3(formno).setVisible(true);
       	     }
        	} 
             catch(Exception e) {
            	 e.printStackTrace();
             }      	
        	
       }
        
        public static void main(String[] args) {
        	new SignUp2("");
        }
}


    
