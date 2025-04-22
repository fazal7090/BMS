
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class WithdrawDeposit extends JFrame {
    private JLabel balanceLabel;
    private JTextField amountField;
    private JButton withdrawButton;
    private JButton depositButton;
    private int balance;

    // Database connection variables
    private Connection connection;
    private Statement statement;
//    CardNo.cardno="503429";
    int balance1 = Integer.parseInt(CardNo.cardno);
    DataConnection db=new DataConnection();

    public WithdrawDeposit() {
        try {
            // Establish database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost/bankmanagementsystem", "root", "11111");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        setTitle("Withdraw And Deposit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        balanceLabel = new JLabel();
        add(balanceLabel);

        amountField = new JTextField(10);
        add(amountField);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(amountField.getText());
                if (amount > 0 && amount <= balance) {
                    balance -= amount;
                    updateBalance(balance);
                    balanceLabel.setText("Balance: Rs." + balance);
                    amountField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid withdrawal amount!");
                }
            }
        });
        add(withdrawButton);

        depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(amountField.getText());
                if (amount > 0) {
                    balance += amount;
                    updateBalance(balance);
                    balanceLabel.setText("Balance: $" + balance);
                    amountField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid deposit amount!");
                }
            }
        });
        add(depositButton);

        // Establish database connection and retrieve the initial balance
//        connectToDatabase();
        balance = Integer.parseInt(getBalance());
        balanceLabel.setText("Balance: Rs." + balance);

        pack();
        setLocationRelativeTo(null);
    }

   

    private String getBalance() {
        String res=null;
//        try {
//            String sql = "SELECT balance FROM Balance WHERE acc_no = '" + CardNo.cardno + "'";
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                balance = resultSet.getDouble("balance");
//            }
//            resultSet.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        try {
                            String query = "SELECT balance FROM Balance WHERE acc_no='"+CardNo.cardno+"'";
                            ResultSet rs=db.s.executeQuery(query);

                            while (rs.next()) {
                                res  = rs.getString("balance");
                      }
         
                } catch (Exception e) {
                    System.out.println("SQL Exception: " + e.getMessage());
                }
        return res;
    }

    private void updateBalance(int newBalance) {
        try {
            String sql = "UPDATE Balance SET balance = " + newBalance + " WHERE acc_no = '" + balance1 + "'";
            db.s.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WithdrawDeposit().setVisible(true);
            }
        });
    }
}
