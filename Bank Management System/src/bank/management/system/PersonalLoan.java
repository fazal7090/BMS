package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class PersonalLoan implements ActionListener {
    private final JFrame frame;
    private JTextField incomeField, loanField;
    private JComboBox<String> repayCombo;
    private JRadioButton salariedButton, businessButton;
    private ButtonGroup empGroup;
    private final String cardno;
    private final Timestamp timestamp;
    private final int minSalary = 30000;
    private JButton backButton;

    public PersonalLoan(String cardno) {
        this.cardno = cardno;
        this.timestamp = new Timestamp(new Date().getTime());
        frame = new JFrame("Personal Loan Application");
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

        try {
            DataConnection db = new DataConnection();
            String query = "SELECT * FROM PersonalLoan WHERE acc_no = '" + cardno + "'";
            ResultSet rs = db.s.executeQuery(query);

            if (rs.next()) {
                StringBuilder info = new StringBuilder();
                info.append("Loan Already Approved!\n\n")
                    .append("Loan Amount: PKR ").append(rs.getDouble("loan_amount")).append("\n")
                    .append("Monthly Installment: PKR ").append(rs.getDouble("installment")).append("\n")
                    .append("Repay Period: ").append(rs.getInt("repay_months")).append(" months\n")
                    .append("Timestamp: ").append(rs.getTimestamp("timestamp"));

                JOptionPane.showMessageDialog(frame, info.toString(), "Personal Loan Details", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                new Facilities(cardno);
                return;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error fetching loan details.", "Error", JOptionPane.ERROR_MESSAGE);
            frame.dispose();
            new Facilities(cardno);
            return;
        }

        JLabel intro = new JLabel("Apply for Personal Loan");
        intro.setFont(new Font("Segoe UI", Font.BOLD, 26));
        intro.setBounds(240, 80, 350, 30);
        frame.add(intro);

        JLabel empLabel = new JLabel("Employment Type:");
        empLabel.setBounds(100, 140, 200, 25);
        frame.add(empLabel);

        salariedButton = new JRadioButton("Salaried");
        salariedButton.setBounds(300, 140, 100, 25);
        frame.add(salariedButton);

        businessButton = new JRadioButton("Businessman");
        businessButton.setBounds(400, 140, 150, 25);
        frame.add(businessButton);

        empGroup = new ButtonGroup();
        empGroup.add(salariedButton);
        empGroup.add(businessButton);

        JLabel incomeLabel = new JLabel("Monthly Income (PKR):");
        incomeLabel.setBounds(100, 190, 200, 25);
        frame.add(incomeLabel);

        incomeField = new JTextField();
        incomeField.setBounds(300, 190, 200, 25);
        frame.add(incomeField);

        JLabel loanLabel = new JLabel("Loan Amount (PKR):");
        loanLabel.setBounds(100, 230, 200, 25);
        frame.add(loanLabel);

        loanField = new JTextField();
        loanField.setBounds(300, 230, 200, 25);
        frame.add(loanField);

        JLabel repayLabel = new JLabel("Repayment Period:");
        repayLabel.setBounds(100, 270, 200, 25);
        frame.add(repayLabel);

        String[] repayOptions = {"12", "24", "36", "48"};
        repayCombo = new JComboBox<>(repayOptions);
        repayCombo.setBounds(300, 270, 100, 25);
        frame.add(repayCombo);

        JButton applyBtn = new JButton("Apply");
        applyBtn.setBounds(300, 320, 100, 30);
        applyBtn.addActionListener(this);
        frame.add(applyBtn);

        frame.setVisible(true);
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
            String query = "INSERT INTO PersonalLoan (acc_no, loan_amount, installment, repay_months, timestamp) VALUES ('" +
                    cardno + "', " + loan + ", " + monthlyInstallment + ", " + months + ", '" + timestamp + "')";
            db.s.executeUpdate(query);

            JOptionPane.showMessageDialog(frame, "Loan Approved! Monthly Installment: PKR " + (int) monthlyInstallment);
            frame.dispose();
            new Facilities(cardno);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numbers for income and loan amount.");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error while processing loan.");
        }
    }

    public static void main(String[] args) {
        new PersonalLoan("123456");
    }
}