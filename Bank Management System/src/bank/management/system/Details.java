package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Details implements ActionListener {
    JPanel panel;
    JFrame frame = new JFrame("Details");
    JComboBox<String> detailshow;
    String[] types = {"Personal Loan", "Business Loan", "Consumer Loan", "Credit Card", "Fund Transfer", "Saving Plan"};
    JButton back;
    String cardno;
    JLabel intro, Details;

    Details(String cardno) {
        this.cardno = cardno;

        frame.setSize(900, 500);
        frame.setLocationRelativeTo(null); // center the window
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.white);

        panel = new JPanel();
        panel.setBounds(0, 0, 900, 70);
        String yellow = "#EFCC00";
        panel.setBackground(Color.decode(yellow));
        panel.setLayout(null);
        frame.add(panel);

        JLabel MCS = new JLabel("MCS BANK");
        MCS.setBounds(20, 10, 200, 50);
        MCS.setForeground(Color.WHITE);
        Font font = new Font("Segoe UI", Font.BOLD, 28);
        MCS.setFont(font);
        panel.add(MCS);

        back = new JButton("Back");
        Font font1 = new Font("Segoe UI", Font.BOLD, 18);
        back.setFont(font1);
        back.setBounds(750, 20, 100, 30);
        back.setBackground(Color.decode(yellow));
        back.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        intro = new JLabel("Check your account service details");
        Font font2 = new Font("Segoe UI", Font.BOLD, 24);
        intro.setFont(font2);
        intro.setBounds(230, 90, 500, 40);
        frame.add(intro);

        Details = new JLabel("Choose a category to view its details:");
        Font font4 = new Font("Segoe UI", Font.PLAIN, 18);
        Details.setFont(font4);
        Details.setBounds(80, 160, 400, 30);
        frame.add(Details);

        detailshow = new JComboBox<>(types);
        detailshow.setBounds(500, 160, 280, 30);
        detailshow.setFont(font4);
        frame.add(detailshow);

        detailshow.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selection = (String) detailshow.getSelectedItem();
                    try {
                        DataConnection c = new DataConnection();
                        ResultSet rs;
                        StringBuilder message = new StringBuilder();

                        switch (selection) {
                            case "Saving Plan":
                                rs = c.s.executeQuery("SELECT * FROM SavingPlan WHERE acc_no = '" + cardno + "'");
                                while (rs.next()) {
                                    message.append("Account Number: ").append(rs.getString("acc_no")).append("\n");
                                    message.append("Total Saving: Rs.").append(rs.getDouble("total_saving")).append("\n");
                                    message.append("Monthly Installment: Rs.").append(rs.getDouble("monthly_installment")).append("\n");
                                    message.append("Plan Duration: ").append(rs.getString("plan_duration")).append("\n");
                                    message.append("Created At: ").append(rs.getTimestamp("created_at")).append("\n\n");
                                }
                                break;

                            case "Personal Loan":
                                rs = c.s.executeQuery("SELECT * FROM PersonalLoan WHERE acc_no = '" + cardno + "'");
                                while (rs.next()) {
                                    message.append("Loan Amount: Rs.").append(rs.getDouble("loan_amount")).append("\n");
                                    message.append("Monthly Installment: Rs.").append(rs.getDouble("installment")).append("\n");
                                    message.append("Repay Months: ").append(rs.getInt("repay_months")).append("\n");
                                    message.append("Timestamp: ").append(rs.getTimestamp("timestamp")).append("\n\n");
                                }
                                break;

                            case "Business Loan":
                                rs = c.s.executeQuery("SELECT * FROM BusinessLoan WHERE acc_no = '" + cardno + "'");
                                while (rs.next()) {
                                    message.append("Loan Amount: Rs.").append(rs.getDouble("loan_amount")).append("\n");
                                    message.append("Monthly Installment: Rs.").append(rs.getDouble("installment")).append("\n");
                                    message.append("Repay Months: ").append(rs.getInt("repay_months")).append("\n");
                                    message.append("Timestamp: ").append(rs.getTimestamp("timestamp")).append("\n\n");
                                }
                                break;

                            case "Consumer Loan":
                                rs = c.s.executeQuery("SELECT * FROM ConsumerLoan WHERE acc_no = '" + cardno + "'");
                                while (rs.next()) {
                                    message.append("Loan Amount: Rs.").append(rs.getDouble("loan_amount")).append("\n");
                                    message.append("Monthly Installment: Rs.").append(rs.getDouble("installment")).append("\n");
                                    message.append("Product: ").append(rs.getString("product")).append("\n");
                                    message.append("Repay Months: ").append(rs.getInt("repay_months")).append("\n");
                                    message.append("Timestamp: ").append(rs.getTimestamp("timestamp")).append("\n\n");
                                }
                                break;

                            case "Credit Card":
                                rs = c.s.executeQuery("SELECT * FROM creditcard WHERE accno = '" + cardno + "'");
                                while (rs.next()) {
                                    message.append("Job Title: ").append(rs.getString("jobtitle")).append("\n");
                                    message.append("Employment Type: ").append(rs.getString("emptype")).append("\n");
                                    message.append("Monthly Income: Rs.").append(rs.getDouble("income")).append("\n");
                                    message.append("Credit Limit: ").append(rs.getString("selectcredit")).append("\n");
                                    message.append("Fine: ").append(rs.getString("fine")).append("\n");
                                    message.append("Card Type: ").append(rs.getString("cardname")).append("\n\n");
                                }
                                break;

                            case "Fund Transfer":
                                rs = c.s.executeQuery("SELECT * FROM transfer_details WHERE account_number = '" + cardno + "'");
                                while (rs.next()) {
                                    message.append("Sender Name: ").append(rs.getString("account_name")).append("\n");
                                    message.append("Sender Account No: ").append(rs.getString("account_number")).append("\n");
                                    message.append("Recipient Name: ").append(rs.getString("recipient_name")).append("\n");
                                    message.append("Recipient Account No: ").append(rs.getString("recipient_number")).append("\n");
                                    message.append("Transfer Amount: Rs.").append(rs.getDouble("transfer_amount")).append("\n");
                                    message.append("Date/Time: ").append(rs.getTimestamp("date_time")).append("\n\n");
                                }
                                break;
                        }

                        if (message.length() > 0) {
                            JTextArea textArea = new JTextArea(message.toString());
                            textArea.setEditable(false);
                            textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
                            JScrollPane scrollPane = new JScrollPane(textArea);
                            scrollPane.setPreferredSize(new Dimension(600, 400));
                            JOptionPane.showMessageDialog(null, scrollPane, selection + " Details", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "No records found for this category.", "No Data", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error fetching details.", "Database Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            frame.setVisible(false);
            new Facilities(cardno);
        }
    }

    public static void main(String[] args) {
        new Details("503721");
    }
}