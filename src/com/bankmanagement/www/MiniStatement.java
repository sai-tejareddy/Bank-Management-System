package com.bankmanagement.www;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class MiniStatement extends JFrame {

    MiniStatement(String pinnumber) {
        setTitle("Mini Statement");
        setLayout(null);

        JLabel bankLabel = new JLabel("Teja Bank");
        bankLabel.setBounds(100, 20, 150, 40);
        add(bankLabel);

        JLabel cardLabel = new JLabel();
        cardLabel.setBounds(20, 60, 300, 20);
        add(cardLabel);

        JLabel miniLabel = new JLabel();        
        miniLabel.setBounds(20, 100, 400, 30);
        add(miniLabel);
        
        
        

        try {
            Connect conn = new Connect();
            Statement s = conn.s;

            
            ResultSet rs1 = s.executeQuery("SELECT cardnumber FROM login WHERE pin = '" + pinnumber + "'");
            if (rs1.next()) {
                String cardNum = rs1.getString("cardnumber");
                cardLabel.setText("Card Number: " + cardNum.substring(0, 4) + "XXXXXXXX" + cardNum.substring(12));
            }

            
            ResultSet rs2 = s.executeQuery("SELECT date, type, amount FROM bank WHERE pin = '" + pinnumber + "'");
            String result = "<html>";
            while (rs2.next()) {
                result += rs2.getString("date") + " - " + rs2.getString("type") + " - " + rs2.getString("amount") + "<br>";
            }
            result += "</html>";
            miniLabel.setText(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        getContentPane().setBackground(Color.WHITE);
        setSize(350, 400);
        setLocation(0, 0);
        setVisible(true);
        
        ChatBotPanel.launchChatBot(pinnumber);
        
        
        
    }

    public static void main(String[] args) {
        new MiniStatement(""); 
    }
}