package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Visa implements ActionListener {
    private final JFrame frame;
    private final JTextField jobField, incomeField, fineField;
    private final JComboBox<String> creditLimitCombo;
    private final JRadioButton salariedBtn, businessBtn;
    private final ButtonGroup empGroup;
    private final String cardno;
    private final int accno;

    public Visa(String cardno) {
        this.cardno = cardno;
        this.accno = Integer.parseInt(cardno);

        frame = new JFrame("Apply for Visa Credit Card");
        frame.setSize(800, 600);
        frame.setLayout(null);
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

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(680, 20, 80, 30);
        backBtn.addActionListener(this);
        header.add(backBtn);

        frame.add(header);

        JLabel heading = new JLabel("Apply for Visa Credit Card");
        heading.setFont(new Font("Segoe UI", Font.BOLD, 22));
        heading.setBounds(240, 80, 400, 30);
        frame.add(heading);

        JLabel empLabel = new JLabel("Employment Type:");
        empLabel.setBounds(100, 140, 200, 25);
        frame.add(empLabel);

        salariedBtn = new JRadioButton("Salaried Person");
        salariedBtn.setBounds(300, 140, 150, 25);
        frame.add(salariedBtn);

        businessBtn = new JRadioButton("Businessman");
        businessBtn.setBounds(460, 140, 150, 25);
        frame.add(businessBtn);

        empGroup = new ButtonGroup();
        empGroup.add(salariedBtn);
        empGroup.add(businessBtn);

        JLabel jobLabel = new JLabel("Job Title/Business:");
        jobLabel.setBounds(100, 180, 200, 25);
        frame.add(jobLabel);

        jobField = new JTextField();
        jobField.setBounds(300, 180, 200, 25);
        frame.add(jobField);

        JLabel incomeLabel = new JLabel("Monthly Net Income:");
        incomeLabel.setBounds(100, 220, 200, 25);
        frame.add(incomeLabel);

        incomeField = new JTextField();
        incomeField.setBounds(300, 220, 200, 25);
        frame.add(incomeField);

        JLabel creditLimitLabel = new JLabel("Credit Limit:");
        creditLimitLabel.setBounds(100, 260, 200, 25);
        frame.add(creditLimitLabel);

        String[] creditOptions = {"150,000 Rupees", "200,000 Rupees", "250,000 Rupees", "400,000 Rupees"};
        creditLimitCombo = new JComboBox<>(creditOptions);
        creditLimitCombo.setBounds(300, 260, 200, 25);
        frame.add(creditLimitCombo);

        JLabel fineLabel = new JLabel("Corresponding Fine:");
        fineLabel.setBounds(100, 300, 200, 25);
        frame.add(fineLabel);

        fineField = new JTextField();
        fineField.setBounds(300, 300, 200, 25);
        frame.add(fineField);

        creditLimitCombo.addActionListener(e -> {
            String selected = (String) creditLimitCombo.getSelectedItem();
            switch (selected) {
                case "150,000 Rupees" -> fineField.setText("Rs. 10,000 over period of one month");
                case "200,000 Rupees" -> fineField.setText("Rs. 15,000 over period of month");
                case "250,000 Rupees" -> fineField.setText("Rs. 20,000 over period of month");
                case "400,000 Rupees" -> fineField.setText("Rs. 25,000 over period of one month");
            }
        });

        JButton confirmBtn = new JButton("Confirm");
        confirmBtn.setBounds(300, 350, 100, 30);
        confirmBtn.addActionListener(this);
        frame.add(confirmBtn);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String incomeStr = incomeField.getText();
        String jobTitle = jobField.getText();
        String fine = fineField.getText();
        String empType = salariedBtn.isSelected() ? "Salaried Person" : businessBtn.isSelected() ? "Businessman" : "";
        String creditStr = (String) creditLimitCombo.getSelectedItem();
        String creditClean = creditStr.replaceAll("[^\\d]", "");
        double credit = Double.parseDouble(creditClean);
        String cardname = "Visa Credit Card";

        if (incomeStr.isEmpty() || jobTitle.isEmpty() || empType.isEmpty() || fine.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill all the required fields");
            return;
        }

        double income = Double.parseDouble(incomeStr);
        if (income < 300000) {
            JOptionPane.showMessageDialog(null, "You are not eligible to apply for this credit card.");
            return;
        }

        try {
            String query = "INSERT INTO creditcard (cardno, jobtitle, emptype, income, selectcredit, fine, cardname) VALUES ('"
                    + accno + "', '" + jobTitle + "', '" + empType + "', " + income + ", " + credit + ", '" + fine + "', '" + cardname + "')";
            DataConnection c = new DataConnection();
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Credit Card Details Inserted Successfully");
            frame.dispose();
            new Facilities(cardno);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error while inserting data");
        }
    }

    public static void main(String[] args) {
       
    }
}