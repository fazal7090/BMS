package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class ConsumerLoan implements ActionListener {
    private final JFrame frame;
    private final JTextField incomeField, loanField;
    private final JComboBox<String> repayCombo, productCombo;
    private final String cardno;
    private final Timestamp timestamp;
    private final int minSalary = 50000;
    private final JButton backButton, applyButton;

    public ConsumerLoan(String cardno) {
        this.cardno = cardno;
        this.timestamp = new Timestamp(new Date().getTime());

        frame = new JFrame("Consumer Loan Application");
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel header = new JPanel();
        header.setBounds(0, 0, 800, 70);
        header.setBackground(Color.decode("#EFCC00"));
        header.setLayout(null);

        JLabel title = new JLabel("MCS BANK");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(Color.WHITE);
        title.setBounds(20, 10, 300, 50);
        header.add(title);

        backButton = new JButton("Back");
        backButton.setBounds(700, 20, 80, 30);
        backButton.setFocusPainted(false);
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLACK);
        backButton.addActionListener(this);
        header.add(backButton);

        frame.add(header);

        JLabel heading = new JLabel("Apply for Consumer Loan");
        heading.setFont(new Font("Segoe UI", Font.BOLD, 24));
        heading.setBounds(240, 80, 350, 30);
        frame.add(heading);

        JLabel incomeLabel = new JLabel("Monthly Income (PKR):");
        incomeLabel.setBounds(100, 150, 200, 25);
        frame.add(incomeLabel);

        incomeField = new JTextField();
        incomeField.setBounds(300, 150, 200, 25);
        frame.add(incomeField);

        JLabel loanLabel = new JLabel("Loan Amount (PKR):");
        loanLabel.setBounds(100, 190, 200, 25);
        frame.add(loanLabel);

        loanField = new JTextField();
        loanField.setBounds(300, 190, 200, 25);
        frame.add(loanField);

        JLabel repayLabel = new JLabel("Repayment Period (Months):");
        repayLabel.setBounds(100, 230, 250, 25);
        frame.add(repayLabel);

        String[] repayOptions = {"12", "24", "36", "48"};
        repayCombo = new JComboBox<>(repayOptions);
        repayCombo.setBounds(300, 230, 100, 25);
        frame.add(repayCombo);

        JLabel productLabel = new JLabel("Product Type:");
        productLabel.setBounds(100, 270, 200, 25);
        frame.add(productLabel);

        String[] productOptions = {"Home", "Car", "Solar Panel", "Fridge"};
        productCombo = new JComboBox<>(productOptions);
        productCombo.setBounds(300, 270, 150, 25);
        frame.add(productCombo);

        applyButton = new JButton("Apply");
        applyButton.setBounds(300, 320, 100, 30);
        applyButton.addActionListener(this);
        frame.add(applyButton);

        checkIfAlreadyApplied();

        frame.setVisible(true);
    }

    private void checkIfAlreadyApplied() {
        try {
            DataConnection db = new DataConnection();
            String query = "SELECT * FROM ConsumerLoan WHERE acc_no = '" + cardno + "'";
            ResultSet rs = db.s.executeQuery(query);

            if (rs.next()) {
                StringBuilder message = new StringBuilder();
                message.append("Loan Already Approved!\n\n");
                message.append("Loan Amount: Rs.").append(rs.getDouble("loan_amount")).append("\n");
                message.append("Monthly Installment: Rs.").append(rs.getDouble("installment")).append("\n");
                message.append("Product: ").append(rs.getString("product")).append("\n");
                message.append("Repay Months: ").append(rs.getInt("repay_months")).append("\n");
                message.append("Timestamp: ").append(rs.getTimestamp("timestamp")).append("\n");

                JOptionPane.showMessageDialog(frame, message.toString(), "Existing Consumer Loan", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                new Facilities(cardno);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error checking existing loan.", "Database Error", JOptionPane.ERROR_MESSAGE);
            frame.dispose();
            new Facilities(cardno);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            frame.dispose();
            new Facilities(cardno);
            return;
        }

        try {
            double income = Double.parseDouble(incomeField.getText());
            double loan = Double.parseDouble(loanField.getText());
            int months = Integer.parseInt((String) repayCombo.getSelectedItem());
            String product = (String) productCombo.getSelectedItem();

            if (income < minSalary) {
                JOptionPane.showMessageDialog(frame, "Income must be at least PKR " + minSalary);
                return;
            }

            double maxLoan = (income / 2) * months;
            if (loan > maxLoan) {
                JOptionPane.showMessageDialog(frame, "Loan exceeds max limit of PKR " + maxLoan);
                return;
            }

            double monthlyInstallment = loan / months;

            DataConnection db = new DataConnection();
            String query = "INSERT INTO ConsumerLoan (acc_no, loan_amount, installment, product, repay_months, timestamp) VALUES ('" +
                    cardno + "', " + loan + ", " + monthlyInstallment + ", '" + product + "', " + months + ", '" + timestamp + "')";
            db.s.executeUpdate(query);

            JOptionPane.showMessageDialog(frame, "Loan Approved! Monthly Installment for " + months + " months: PKR " + (int) monthlyInstallment);
            frame.dispose();
            new Facilities(cardno);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numbers for income and loan amount.");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error while processing loan.");
            frame.dispose();
            new Facilities(cardno);
        }
    }

    public static void main(String[] args) {
        new ConsumerLoan("43252");
    }
}
