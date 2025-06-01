package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FundsTransfer1 extends JFrame implements ActionListener {
    private final JTextField amountField, recipientField;
    private final JButton nextBtn, cancelBtn;
    private final String cardno;
    private final int accno;

    public FundsTransfer1(String cardno) {
        this.cardno = cardno;
        this.accno = Integer.parseInt(cardno);

        setTitle("Funds Transfer");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(null);
        formPanel.setBackground(Color.WHITE);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(30, 30, 100, 25);
        formPanel.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(150, 30, 200, 25);
        formPanel.add(amountField);

        JLabel recipientLabel = new JLabel("Recipient Acc#: ");
        recipientLabel.setBounds(30, 70, 120, 25);
        formPanel.add(recipientLabel);

        recipientField = new JTextField();
        recipientField.setBounds(150, 70, 200, 25);
        formPanel.add(recipientField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.WHITE);

        nextBtn = new JButton("Next");
        nextBtn.addActionListener(this);
        buttonPanel.add(nextBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(this);
        buttonPanel.add(cancelBtn);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelBtn) {
            new Facilities(cardno);
            dispose();
            return;
        }

        String quantity = amountField.getText().trim();
        String recipientCardNo = recipientField.getText().trim();

        if (quantity.isEmpty() || recipientCardNo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int transferAmount = Integer.parseInt(quantity);
            DataConnection c = new DataConnection();

            ResultSet destCheck = c.s.executeQuery("SELECT * FROM MainTable WHERE cardno = '" + recipientCardNo + "'");
            if (!destCheck.next()) {
                JOptionPane.showMessageDialog(this, "Destination account does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ResultSet sourceCheck = c.s.executeQuery("SELECT bal, name FROM MainTable WHERE cardno = '" + cardno + "'");
            if (sourceCheck.next()) {
                int sourceBal = sourceCheck.getInt("bal");
                String senderName = sourceCheck.getString("name");

                if (sourceBal < transferAmount) {
                    JOptionPane.showMessageDialog(this, "Insufficient balance.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int newSourceBal = sourceBal - transferAmount;
                c.s.executeUpdate("UPDATE MainTable SET bal = " + newSourceBal + " WHERE cardno = '" + cardno + "'");

                ResultSet destBalanceCheck = c.s.executeQuery("SELECT bal, name FROM MainTable WHERE cardno = '" + recipientCardNo + "'");
                if (destBalanceCheck.next()) {
                    int destBal = destBalanceCheck.getInt("bal") + transferAmount;
                    String recipientName = destBalanceCheck.getString("name");
                    c.s.executeUpdate("UPDATE MainTable SET bal = " + destBal + " WHERE cardno = '" + recipientCardNo + "'");

                    // Log the transaction
                    String insertTransaction = "INSERT INTO transfer_details (account_number, account_name, recipient_number, recipient_name, transfer_amount, date_time) " +
                            "VALUES ('" + cardno + "', '" + senderName + "', '" + recipientCardNo + "', '" + recipientName + "', " + transferAmount + ", NOW())";
                    c.s.executeUpdate(insertTransaction);
                }

                JOptionPane.showMessageDialog(this, "Funds transferred successfully to account: " + recipientCardNo);
                new Facilities(cardno);
                dispose();
            }
            c.s.close();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for amount.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred during the transaction.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new FundsTransfer1("503721");
    }
}
