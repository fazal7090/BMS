package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class FundsTransfer1 extends JFrame implements ActionListener {
    JPanel panel1;
    JPanel panel2;
    JButton next, cancel, withdrawdeposit;
    JTextField textField1;
    JTextField textField2;
    JLabel Quantity;
    JLabel AccNo;
    Connection connection;
    int accno;
String cardno;
    FundsTransfer1(String cardno) {
        accno=Integer.parseInt(cardno);
        this.cardno=cardno;
        try {
            // Establish database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost/bank_management_system2", "root", "goatcr77");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Next Button
        next = new JButton("Next");
        next.addActionListener(this);
        next.setFocusable(true);
        next.setBackground(Color.white);
        next.setForeground(Color.BLACK);
        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setFocusable(true);
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.BLACK);
     
        // TextField and Label for displaying and getting info from user
        Quantity = new JLabel();
        Quantity.setText("Quantity");
        Quantity.setBounds(20, 100, 87, 20);
        Quantity.setFont(new Font("Arial", Font.BOLD, 10));
        Quantity.setIgnoreRepaint(false);

        textField1 = new JTextField();
        textField1.setPreferredSize(new Dimension(200, 30));
        textField1.setBounds(115, 100, 120, 20);

        AccNo = new JLabel();
        AccNo.setText("Account#");
        AccNo.setBounds(20, 130, 70, 20);
        AccNo.setFont(new Font("Arial", Font.BOLD, 10));
        AccNo.setIgnoreRepaint(false);

        textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(250, 40));
        textField2.setBounds(115, 130, 100, 20);
        // User can enter only 10 digits
        textField2.setColumns(10);
        // Main Panel in which all the TextFields and Labels are added
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.add(textField1);
        panel1.add(textField2);
        panel1.add(Quantity);
        panel1.add(AccNo);
     
        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel2.add(next);
        panel2.add(cancel);
        // Frame Setting
        this.setTitle("Funds Transfer");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(300, 250));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
        this.setVisible(true);
        this.add(panel1);
        this.add(panel2, BorderLayout.SOUTH);
    }

    // For restricting user to enter digit only
    private void setTextField2(java.awt.event.KeyEvent evt) {
        String Number = textField2.getText();
        int length = Number.length();
        char c = evt.getKeyChar();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (length < 10) {
                textField2.setEditable(true);
            } else {
                textField2.setEditable(false);
            }
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                textField2.setEditable(true);
            } else {
                textField2.setEditable(false);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == next) {
        String quantity = textField1.getText();
        String number = textField2.getText();

        try {
    DataConnection c = new DataConnection();

      ResultSet destAccount = c.s.executeQuery("SELECT * FROM MainTable WHERE cardno = '" + number + "'");
      if (destAccount.next())
      {
    // Check if the source account (your account) exists
    ResultSet sourceAccountResult = c.s.executeQuery("SELECT balance FROM MainTable WHERE cardno = '" + cardno + "'");
    if (sourceAccountResult.next()) {
        int balance = sourceAccountResult.getInt("balance");
        int transferAmount = Integer.parseInt(quantity);

        // Check if the source account has sufficient balance
        if (balance < transferAmount) {
            JOptionPane.showMessageDialog(null, "Insufficient balance.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Stop the process if balance is insufficient
        }

        // Deduct the transfer amount from the source account
        int newBalance = balance - transferAmount;
        c.s.executeUpdate("UPDATE MainTable SET balance = " + newBalance + " WHERE cardno = '" + cardno + "'");

        // Check if the destination account exists
        ResultSet destAccountResult = c.s.executeQuery("SELECT balance FROM MainTable WHERE cardno = '" + number + "'");
        if (destAccountResult.next()) {
            // Update the balance of the destination account
            int destBalance = destAccountResult.getInt("balance");
            int newDestBalance = destBalance + transferAmount;
            c.s.executeUpdate("UPDATE MainTable SET balance = " + newDestBalance + " WHERE cardno = '" + number + "'");
             JOptionPane.showMessageDialog(null,"Funds Transferred Succesfully to account number "+number);
            new Facilities(cardno);
        } 
        

    }
    } else {
        JOptionPane.showMessageDialog(null, "Destination account does not exsist", "Error", JOptionPane.ERROR_MESSAGE);
    }
    c.s.close();
} catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, "An error occurred while performing the transfer.", "Error", JOptionPane.ERROR_MESSAGE);
}
    
        } else if (e.getSource() == cancel) {
            new Facilities(cardno);
            dispose();
        } 
    }
    public static void main(String[] args) {
        FundsTransfer1 a=new FundsTransfer1("504839");
    }
   
}