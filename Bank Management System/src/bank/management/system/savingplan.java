/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

public class savingplan extends AddMoney implements ActionListener, Methods{
    double installment=0;
    JComboBox repay;  String[] repay_string={"12 Months (1 Year)", "24 Months (2 Years)", "36 Months (3 Years)", "48 Months (4 Years)"};
    JRadioButton SalPer, Businessman;  String income_input, loan_input, repay_input;
    ButtonGroup emp;
    JButton back, income_enter, loan_enter, repay_enter;
    JPanel panel;
    JLabel intro, intro1, EmpType, INCOME, LOAN, REPAY;
    JTextField income, loan;
    JFrame frame=new JFrame();

    savingplan(){ nframe.setVisible(false);
        //frame
        frame.setSize(700,500);
        frame.setLocation(300,100); frame.setLayout(null);
        frame.setResizable(false);

        //panel
        panel=new JPanel();
        panel.setBounds(0,0,700,53);
        String yellow="#EFCC00";
        panel.setBackground(Color.decode(yellow));
        panel.setLayout(null);
        frame.add(panel);

        //MCS BANK label
        JLabel MCS=new JLabel("MCS BANK");
        MCS.setBounds(20,0,185,50);
        MCS.setForeground(Color.WHITE);
        Font font=new Font("Segoe UI", BOLD, 32);
        MCS.setFont(font);
        panel.add(MCS);

        //back button
        back=new JButton("Back");
        Font font1=new Font("Segoe UI", BOLD, 12);
        back.setFont(font1);
        back.setBounds(600,12,50,25);
        back.setBackground(Color.decode(yellow));
        back.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        //intro label
        intro=new JLabel("     Saving Plan");
        Font font2=new Font("Segoe UI", BOLD, 30);
        intro.setFont(font2);
        intro.setBounds(230,60,300,50);
        intro.setForeground(Color.decode(yellow));
        frame.add(intro);

        //intro1 label
        intro1=new JLabel("      Save your Money for Safe Future");
        Font font3=new Font("Segoe UI", BOLD, 30);
        intro1.setFont(font3);
        intro1.setBounds(55,95,700,50);
        intro1.setForeground(Color.decode(yellow));
        frame.add(intro1);

        //income label
        INCOME=new JLabel("Money you want to save");
        Font font5=new Font("Segoe UI", BOLD, 16);
        INCOME.setFont(font5);
        INCOME.setBounds(10,155,300,50);
        frame.add(INCOME);

        //income text field
        income=new JTextField();
        income.setBounds(270,173,150,20);
        frame.add(income);

//        //income_enter button
//        income_enter=new JButton("Enter");
        Font font6=new Font("Segoe UI", BOLD, 18);
//        income_enter.setFont(font6);
//        income_enter.setBounds(445,171,80,25);
//        income_enter.setBackground(Color.decode(yellow));
//        income_enter.setForeground(Color.WHITE);
//        income_enter.addActionListener(this);
//        add(income_enter);

        //LOAN label
        LOAN=new JLabel("Monthly deposit");
        LOAN.setFont(font5);
        LOAN.setBounds(10,200,300,50);
        frame.add(LOAN);

        //loan text field
        loan=new JTextField();
        loan.setBounds(270,220,150,20);
        frame.add(loan);

//        //loan_enter button
//        loan_enter=new JButton("Enter");
//        loan_enter.setFont(font6);
//        loan_enter.setBounds(445,220,80,25);
//        loan_enter.setBackground(Color.decode(yellow));
//        loan_enter.setForeground(Color.WHITE);
//        loan_enter.addActionListener(this);
//        add(loan_enter);

        //repay label
        REPAY=new JLabel("Saving Plan Period");
        REPAY.setFont(font5);
        REPAY.setBounds(10,260,300,50);
        frame.add(REPAY);

        //repay dropdown
        repay=new JComboBox(repay_string);
        repay.setBounds(270,270, 150,30);
        frame.add(repay);


        //repay_enter button
        repay_enter=new JButton("Enter");
        repay_enter.setFont(font6);
        repay_enter.setBounds(310,350,80,25);
        repay_enter.setBackground(Color.decode(yellow));
        repay_enter.setForeground(Color.WHITE);
        repay_enter.addActionListener(this);
        frame.add(repay_enter);

        //view
        frame.setVisible(true);

    }

    //METHODS

    //monthly installment method
     public void monthly_installment(int n, double installment, String selected){
        JOptionPane.showMessageDialog(null, "We can Fix "+installment+" amount every month from your deposit amount for "+selected+" months to save Rs."+n);
    }

    //exceeded loan
    public void exceeded_loan(double n){
        JOptionPane.showMessageDialog(null,"Sorry, the amount we want to fix for you on monthly bases is less than from your monthly deposit of"+n+" (Please choose another saving plan)");
    }

    //Action
    int N=0, N1=0; double max=0;
    public void actionPerformed(ActionEvent ae){
        //My account action
        if(ae.getSource()==back) {
            frame.setVisible(false);
            new Facilities();
        }



        //repay action
        else if(ae.getSource()==repay_enter) {


            income_input=income.getText();
            N=parseInt(income_input);
            setSalary(N);
            String selected = (String) repay.getSelectedItem(); int Months=0;

        loan_input=loan.getText();
            N1=parseInt(loan_input);

            if(selected==repay_string[0]){
                Months=12;
            }

            else if(selected==repay_string[1]){
                Months=24;
            }
            if(selected==repay_string[2]){
                Months=36;
            }
            if(selected==repay_string[3]){
                Months=48;
            }

            installment=N/Months;
            String st=Months+"";
            if(N1<installment){
                exceeded_loan(N1);
            }
            else{
                
//insert values into PersonalLoan table
                
                //for current date and time 
                DataConnection db=new DataConnection();
                try{
                     String query = "INSERT INTO SavingPlan VALUES ('" + CardNo.cardno + "','" + getSalary() + "','" + installment + "','" + selected+  "')";

                 db.s.executeUpdate(query);
                }
                catch(Exception e){
                    System.out.println(e);
                }
                monthly_installment(N,installment, st);
            }
        }

    }


    public static void main(String[] args) {
        new savingplan();
    }


    @Override
    public void salary_limit() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}