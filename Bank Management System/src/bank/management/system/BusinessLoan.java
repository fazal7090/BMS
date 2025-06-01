package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class BusinessLoan implements ActionListener {
    private final JFrame frame;
    private final JTextField incomeField, loanField;
    private final JComboBox<String> repayCombo;
    private final JButton backButton, applyButton;
    private final Timestamp timestamp = new Timestamp(new Date().getTime());
    String cardno;

    public BusinessLoan(String cardno) {
        this.cardno = cardno;
        frame = new JFrame("Business Loan Application");
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

        JLabel heading = new JLabel("Apply for Business Loan");
        heading.setFont(new Font("Segoe UI", Font.BOLD, 24));
        heading.setBounds(240, 80, 350, 30);
        frame.add(heading);

        JLabel incomeLabel = new JLabel("Annual Turnover (PKR):");
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

        applyButton = new JButton("Apply");
        applyButton.setBounds(300, 280, 100, 30);
        applyButton.addActionListener(this);
        frame.add(applyButton);

        checkIfAlreadyApplied();

        frame.setVisible(true);
        
                try {
            DataConnection db = new DataConnection();
            String query = "SELECT * FROM BusinessLoan WHERE acc_no = '" + cardno + "'";
            ResultSet rs = db.s.executeQuery(query);

            if (rs.next()) {
                StringBuilder message = new StringBuilder();
                message.append("Loan Amount: Rs.").append(rs.getDouble("loan_amount")).append("\n");
                message.append("Monthly Installment: Rs.").append(rs.getDouble("installment")).append("\n");
                message.append("Repay Months: ").append(rs.getInt("repay_months")).append("\n");
                message.append("Timestamp: ").append(rs.getTimestamp("timestamp")).append("\n");

                JOptionPane.showMessageDialog(frame, message.toString(), "Existing Business Loan", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                new Facilities(cardno);
                 return;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error checking existing loan.", "Database Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private void checkIfAlreadyApplied() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            frame.dispose();
            new Facilities(cardno);
            return;
        }

        try {
            double turnover = Double.parseDouble(incomeField.getText());
            double loan = Double.parseDouble(loanField.getText());
            int months = Integer.parseInt((String) repayCombo.getSelectedItem());

            double maxLoan = turnover * 4;
            if (loan > maxLoan) {
                JOptionPane.showMessageDialog(frame, "Loan exceeds max limit of PKR " + maxLoan);
                return;
            }

            double monthlyInstallment = loan / months;

            DataConnection db = new DataConnection();
            String query = "INSERT INTO BusinessLoan (acc_no, loan_amount, installment, repay_months, timestamp) VALUES ('" +
                    cardno + "', " + loan + ", " + monthlyInstallment + ", " + months + ", '" + timestamp + "')";
            db.s.executeUpdate(query);

            JOptionPane.showMessageDialog(frame, "Loan Approved! Monthly Installment: PKR " + (int) monthlyInstallment);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numbers for turnover and loan amount.");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error while processing loan.");
        }
    }

    public static void main(String[] args) {
        new BusinessLoan("32421");
    }
}
