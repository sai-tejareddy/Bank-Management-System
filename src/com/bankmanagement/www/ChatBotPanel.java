package com.bankmanagement.www;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatBotPanel extends JPanel {

    private JTextArea chatArea;
    private JTextField inputField;
    private final String pinnumber;
    private JPanel suggestionPanel;

    public ChatBotPanel(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();
        inputField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        inputField.addActionListener(e -> {
            String userInput = inputField.getText().trim();
            if (!userInput.isEmpty()) {
                displayUserMessage(userInput);
                respond(userInput);
                inputField.setText("");
            }
        });

        suggestionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        suggestionPanel.setBackground(Color.WHITE);

        add(scrollPane, BorderLayout.CENTER);
        add(suggestionPanel, BorderLayout.SOUTH);
        add(inputField, BorderLayout.NORTH);

        displayBotMessage("Hi! You can ask me about your balance, latest withdrawal, or how to update your PIN.");
        showSuggestions(new String[]{"Check Balance", "Latest Withdrawal", "Update PIN"});
    }

    private void displayUserMessage(String message) {
        chatArea.append("You: " + message + "\n");
        chatArea.setCaretPosition(chatArea.getDocument().getLength());
    }

    private void displayBotMessage(String message) {
        chatArea.append("Bot: " + message + "\n\n");
        chatArea.setCaretPosition(chatArea.getDocument().getLength());
    }

    private void showSuggestions(String[] options) {
        suggestionPanel.removeAll();
        for (String option : options) {
            JLabel label = new JLabel("<html><u><font color='blue'>" + option + "</font></u></html>");
            label.setCursor(new Cursor(Cursor.HAND_CURSOR));
            label.setFont(new Font("SansSerif", Font.PLAIN, 13));
            label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    displayUserMessage(option);
                    respond(option.toLowerCase());
                }
            });
            suggestionPanel.add(label);
        }
        revalidate();
        repaint();
    }

    private void respond(String input) {
        String reply = "I'm still learning. Try asking about balance, withdrawals, or PIN updates.";
        String[] followUp = new String[]{"Check Balance", "Latest Withdrawal", "Update PIN"};

        try {
            Connect conn = new Connect();
            Statement s = conn.s;

            if (input.contains("balance")) {
                ResultSet rs = s.executeQuery(
                    "SELECT SUM(CASE " +
                    "WHEN type LIKE 'Deposit' THEN amount " +
                    "WHEN type LIKE 'Withdraw%' THEN -amount " +
                    "ELSE 0 END) AS balance FROM bank WHERE pin = '" + pinnumber + "'"
                );
                if (rs.next()) {
                    int balance = rs.getInt("balance");
                    reply = "Your current balance is ₹" + balance + ".";
                }
                followUp = new String[]{"Latest Withdrawal", "Update PIN"};

            } else if (input.contains("withdraw")) {
                ResultSet rs = s.executeQuery(
                    "SELECT amount, date FROM bank WHERE pin = '" + pinnumber + "' AND type LIKE 'Withdraw%' ORDER BY date DESC LIMIT 1"
                );
                if (rs.next()) {
                    reply = "Latest withdrawal: ₹" + rs.getInt("amount") + " on " + rs.getString("date") + ".";
                } else {
                    reply = "No withdrawal record found.";
                }
                followUp = new String[]{"Check Balance", "Update PIN"};

            } else if (input.contains("update pin")) {
                reply = "To update your PIN, go to LoginPage > signin > Transaction > Pin Change.";
                followUp = new String[]{"Check Balance", "Latest Withdrawal"};
            }

        } catch (Exception e) {
            reply = "⚠️ Database error: " + e.getMessage();
            e.printStackTrace();
        }

        displayBotMessage(reply);
        showSuggestions(followUp);
    }

    public static void launchChatBot(String pinnumber) {
        JFrame frame = new JFrame("Bank ChatBot");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(360, 400); // Reduced width

        frame.add(new ChatBotPanel(pinnumber));

        // Position the frame at the top-right corner
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width - frame.getWidth();
        int y = 0;
        frame.setLocation(x, y);

        frame.setVisible(true);
    }
}