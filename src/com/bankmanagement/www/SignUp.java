package com.bankmanagement.www;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;



public class SignUp extends JFrame implements ActionListener{

       
	    int formNumber;

	    JTextField nameTextField, fnameTextField, dobTextField, emailTextField, addressTextField, stateTextField, cityTextField, pincodeTextField;

	    JButton button;

	    JRadioButton maleButton, femaleButton, marriedButton, unmarriedButton, otherButton;

	    JDateChooser dobChooser;
        private static final String EMAIL_REGEX ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

        public static boolean isValidEmail(String email) {
                     return email != null && !email.isEmpty() && EMAIL_PATTERN.matcher(email).matches();
    }

        public SignUp () {
        	
            setLayout(null);
            Random ran= new Random();

            formNumber = Math.abs(ran.nextInt(9999)); 
            JLabel formno = new JLabel("APPLICATION FORM NO. " + formNumber);
            getContentPane().setBackground(Color.WHITE);
            
            formno.setFont(new Font("SansSerif", Font.BOLD, 25));
            formno.setBounds(250,30,400,40);

            setSize (850, 800);
            setLocation (350, 10);
            add(formno);
            
            JLabel personDetails = new JLabel("Page 1: Personal Details");
            personDetails.setFont(new Font("Raleway", Font.BOLD, 20));
            personDetails.setBounds (290, 80, 400, 30);
            add(personDetails);

            JLabel name = new JLabel("Name:");
            name.setFont(new Font("Raleway", Font.BOLD, 17));
            name.setBounds (100, 140, 100, 30);
            add(name);
            
            nameTextField = new JTextField();
            nameTextField.setFont(new Font("Display", Font.BOLD, 12));
            nameTextField.setBounds(300, 140, 400, 30);
            add(nameTextField);
            
            JLabel fname = new JLabel("Father's Name:");
            fname.setFont(new Font("Raleway", Font. BOLD, 15));
            fname.setBounds (100, 190, 200, 30);
            add(fname);
            
            fnameTextField = new JTextField();
            fnameTextField.setFont(new Font("Display", Font.BOLD, 12));
            fnameTextField.setBounds(300, 190, 400, 30);
            add(fnameTextField);

            JLabel dob =new JLabel("Date of Birth");
            dob.setFont (new Font("Raleway", Font. BOLD, 15));
            dob.setBounds (100, 240, 200, 30);
            add(dob);
            
            dobChooser = new JDateChooser();
            dobChooser.setBounds(300, 240, 400, 30);
            dobChooser.setFont(new Font("Raleway", Font.PLAIN, 14));
            add(dobChooser);
 
            JLabel gender = new JLabel("Gender:");
            gender.setFont(new Font("Raleway", Font.BOLD, 17));
            gender.setBounds (100, 290, 200, 30);
            add (gender);
            
            maleButton = new JRadioButton("Male");
            maleButton.setFont(new Font("SansSerif", Font.BOLD, 14));
            maleButton.setBounds(300, 290, 100, 30);
            maleButton.setBackground(Color.WHITE);
            add(maleButton);

            femaleButton = new JRadioButton("Female");
            femaleButton.setFont(new Font("SansSerif", Font.BOLD, 14));
            femaleButton.setBounds(410, 290, 100, 30);
            femaleButton.setBackground(Color.WHITE);
            add(femaleButton);


            ButtonGroup genderGroup = new ButtonGroup();
            genderGroup.add(maleButton);
            genderGroup.add(femaleButton);

            JLabel email = new JLabel("Email Address:");
            email.setFont(new Font("Raleway", Font.BOLD, 17));
            email.setBounds (100, 340, 200, 30);
            add (email);
            
            emailTextField = new JTextField();
            nameTextField.setFont(new Font("SansSerif", Font.BOLD, 14));
            emailTextField.setBounds(300, 340, 400, 30);
            add(emailTextField);

            JLabel marital =new JLabel("Marital Status:");
            marital.setFont(new Font("Raleway", Font.BOLD, 17));
            marital.setBounds (100, 390, 200, 30);
            add(marital);
            
            marriedButton = new JRadioButton("Married");
            marriedButton.setFont(new Font("SansSerif", Font.BOLD, 14));
            marriedButton.setBounds(300, 390, 100, 30);
            marriedButton.setBackground(Color.WHITE);
            add(marriedButton);

            unmarriedButton = new JRadioButton("Unmarried");
            unmarriedButton.setFont(new Font("SansSerif", Font.BOLD, 14));
            unmarriedButton.setBounds(410, 390, 120, 30);
            unmarriedButton.setBackground(Color.WHITE);
            add(unmarriedButton);
            
            otherButton = new JRadioButton("Other");
            otherButton.setFont(new Font("SansSerif", Font.BOLD, 14));
            otherButton.setBounds(540, 390, 120, 30);
            otherButton.setBackground(Color.WHITE);
            add(otherButton);
            

            ButtonGroup statusGroup = new ButtonGroup();
            statusGroup.add(marriedButton);
            statusGroup.add(unmarriedButton);
            statusGroup.add(otherButton);

            JLabel address = new JLabel("Address:");
            address.setFont(new Font("Raleway", Font. BOLD, 17));
            address.setBounds (100, 440, 200, 30);
            add (address);
            
            addressTextField = new JTextField();
            addressTextField.setFont(new Font("SansSerif", Font.PLAIN, 14));
            addressTextField.setBounds(300, 440, 400, 30);
            add(addressTextField);

            JLabel city = new JLabel("City:");
            city.setFont(new Font("Raleway", Font. BOLD, 17));
            city.setBounds (100, 490, 200, 30);
            add(city);
            
            cityTextField = new JTextField();
            cityTextField.setFont(new Font("SansSerif", Font.PLAIN, 14));
            cityTextField.setBounds(300, 490, 400, 30);
            add(cityTextField);

            JLabel state = new JLabel("State:");
            state.setFont(new Font("Raleway", Font. BOLD, 17));
            state.setBounds (100, 540, 200, 30);
            add(state);
            
            stateTextField = new JTextField();
            stateTextField.setFont(new Font("SansSerif", Font.PLAIN, 14));
            stateTextField.setBounds(300, 540, 400, 30);
            add(stateTextField);
            
            JLabel pincode =new JLabel("Pin Code:");
            pincode.setFont(new Font("Raleway", Font. BOLD, 17));
            pincode.setBounds (100, 590, 200, 30);
            add(pincode);
            
            pincodeTextField = new JTextField();
            pincodeTextField.setFont(new Font("SansSerif", Font.PLAIN, 14));
            pincodeTextField.setBounds(300, 590, 400, 30);
            add(pincodeTextField);
            
            button=new JButton("next");
            button.setBounds(640,630,60,20);
            button.setBackground(Color.black);
            button.setForeground(Color.WHITE);
            button.addActionListener(this);
            add(button);
       
            setVisible(true); 
            
        }
        public void actionPerformed(ActionEvent ae) {
        	
        	String formno = "" + formNumber;
        	String name = nameTextField.getText();
        	String fname=fnameTextField.getText();
        	String dob = ((JTextField) dobChooser.getDateEditor().getUiComponent()).getText();

        	String gender = null;
        	
        	if(maleButton.isSelected()) {
        	      gender = "Male";
        	} 
        	else if(femaleButton.isSelected()) {
        	       gender = "Female";
        	}


        	String email = emailTextField.getText();

        	String marital= null;

        	if (marriedButton.isSelected()) {
        	      marital = "Married";
        	} 
        	else if (unmarriedButton.isSelected()) {
        	      marital = "Unmarried";
        	} 
        	else if(otherButton.isSelected()) {
        		  marital = "Other";
        	}
        	String address = addressTextField.getText();

        	String city = cityTextField.getText();

        	String state= stateTextField.getText();

        	String pin = pincodeTextField.getText();
        	
        	try {
        		 if (name.equals("")) {
        	               JOptionPane.showMessageDialog(null, "Name is required");
        	     } else if (fname.equals("")) {
        	              JOptionPane.showMessageDialog(null, "Father's name is required");
        	     } else if (dob.equals("")) {
        	             JOptionPane.showMessageDialog(null, "Date of birth is required");
        	     } else if (gender == null) {
        	             JOptionPane.showMessageDialog(null, "Please select your gender");
        	     } else if (email.equals("")) {
        	            JOptionPane.showMessageDialog(null, "Email is required");
        	     } else if (!isValidEmail(email)) {
        	         JOptionPane.showMessageDialog(null, "Enter a valid email address");
        	     } else if (marital == null) {
        	         JOptionPane.showMessageDialog(null, "Please select your marital status");
        	     } else if (address.equals("")) {
        	         JOptionPane.showMessageDialog(null, "Address is required");
        	     } else if (city.equals("")) {
        	         JOptionPane.showMessageDialog(null, "City is required");
        	     } else if (state.equals("")) {
        	        JOptionPane.showMessageDialog(null, "State is required");
        	     } else if (pin.equals("")) {
        	         JOptionPane.showMessageDialog(null, "Pin code is required");
        	     } else {
        	    	     Connect c= new Connect();
        		    String query = "INSERT INTO signup (formno, name, father_name, dob, gender, email, martial_status, address, city, state, pincode) " +
                            "VALUES ('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + state + "','" + pin + "')";

                             c.s.executeUpdate(query);
                           JOptionPane.showMessageDialog(null, "Form submitted successfully!");
                           setVisible(false);
                           new SignUp2(formno).setVisible(true);

        		
        	    
        	}
        			
        	}
             catch (Exception e) {
                    e.printStackTrace();
        }
       }
        
        public static void main(String[] args) {
        	new SignUp();
        }
}


    