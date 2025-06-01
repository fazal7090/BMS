package bank.management.system;

import java.awt.*;
import static java.awt.Font.BOLD;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;

public class savingplan extends AddMoney implements ActionListener, Methods {
    double installment = 0;
    JComboBox repay;
    String[] repay_string = {"12 Months (1 Year)", "24 Months (2 Years)", "36 Months (3 Years)", "48 Months (4 Years)"};
    JRadioButton SalPer, Businessman;
    String income_input, loan_input, repay_input;
    ButtonGroup emp;
    JButton back, repay_enter;
    JPanel panel;
    JLabel intro, intro1, EmpType, INCOME, LOAN, REPAY;
    JTextField income, loan;
    JFrame frame = new JFrame();
    String cardno;

    savingplan(String cardno) {
        super(cardno); // Call parent constructor with cardno
        this.cardno = cardno;
        nframe.setVisible(false);

        frame.setSize(700, 500);
        frame.setLocation(300, 100);
        frame.setLayout(null);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setBounds(0, 0, 700, 53);
        String yellow = "#EFCC00";
        panel.setBackground(Color.decode(yellow));
        panel.setLayout(null);
        frame.add(panel);

        JLabel MCS = new JLabel("MCS BANK");
        MCS.setBounds(20, 0, 185, 50);
        MCS.setForeground(Color.WHITE);
        Font font = new Font("Segoe UI", BOLD, 32);
        MCS.setFont(font);
        panel.add(MCS);

        back = new JButton("Back");
        Font font1 = new Font("Segoe UI", BOLD, 12);
        back.setFont(font1);
        back.setBounds(600, 12, 50, 25);
        back.setBackground(Color.decode(yellow));
        back.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        intro = new JLabel("     Saving Plan");
        Font font2 = new Font("Segoe UI", BOLD, 30);
        intro.setFont(font2);
        intro.setBounds(230, 60, 300, 50);
        intro.setForeground(Color.decode(yellow));
        frame.add(intro);

        intro1 = new JLabel("      Save your Money for Safe Future");
        Font font3 = new Font("Segoe UI", BOLD, 30);
        intro1.setFont(font3);
        intro1.setBounds(55, 95, 700, 50);
        intro1.setForeground(Color.decode(yellow));
        frame.add(intro1);

        INCOME = new JLabel("Money you want to save");
        Font font5 = new Font("Segoe UI", BOLD, 16);
        INCOME.setFont(font5);
        INCOME.setBounds(10, 155, 300, 50);
        frame.add(INCOME);

        income = new JTextField();
        income.setBounds(270, 173, 150, 20);
        frame.add(income);

        LOAN = new JLabel("Monthly deposit");
        LOAN.setFont(font5);
        LOAN.setBounds(10, 200, 300, 50);
        frame.add(LOAN);

        loan = new JTextField();
        loan.setBounds(270, 220, 150, 20);
        frame.add(loan);

        REPAY = new JLabel("Saving Plan Period");
        REPAY.setFont(font5);
        REPAY.setBounds(10, 260, 300, 50);
        frame.add(REPAY);

        repay = new JComboBox(repay_string);
        repay.setBounds(270, 270, 150, 30);
        frame.add(repay);

        Font font6 = new Font("Segoe UI", BOLD, 18);
        repay_enter = new JButton("Enter");
        repay_enter.setFont(font6);
        repay_enter.setBounds(310, 350, 80, 25);
        repay_enter.setBackground(Color.decode(yellow));
        repay_enter.setForeground(Color.WHITE);
        repay_enter.addActionListener(this);
        frame.add(repay_enter);

        frame.setVisible(true);
    }

    public void monthly_installment(int n, double installment, String selected) {
        JOptionPane.showMessageDialog(null, "We can fix " + installment + " amount every month from your deposit amount for " + selected + " months to save Rs." + n);
    }

    public void exceeded_loan(double n) {
        JOptionPane.showMessageDialog(null, "Sorry, the amount we want to fix for you on monthly basis is greater than your deposit of Rs." + n + ". Please choose another saving plan.");
    }

    int N = 0, N1 = 0;

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            frame.setVisible(false);
            new Facilities(cardno);
        } else if (ae.getSource() == repay_enter) {
            income_input = income.getText();
            N = parseInt(income_input);
            setSalary(N);
            String selected = (String) repay.getSelectedItem();
            int Months = 0;

            loan_input = loan.getText();
            N1 = parseInt(loan_input);

            if (selected.equals(repay_string[0])) Months = 12;
            else if (selected.equals(repay_string[1])) Months = 24;
            else if (selected.equals(repay_string[2])) Months = 36;
            else if (selected.equals(repay_string[3])) Months = 48;

            installment = (double) N / Months;
            String st = String.valueOf(Months);

            if (N1 < installment) {
                exceeded_loan(N1);
            } else {
                DataConnection db = new DataConnection();
                try {
                   String query = "INSERT INTO SavingPlan (acc_no, total_saving, monthly_installment, plan_duration) " +
               "VALUES ('" + cardno + "', '" + getSalary() + "', '" + installment + "', '" + selected + "')";

                    db.s.executeUpdate(query);
                } catch (Exception e) {
                    System.out.println(e);
                }
                monthly_installment(N, installment, st);
            }
        }
    }

    public static void main(String[] args) {
        new savingplan("503721");
    }

    @Override
    public void salary_limit() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}