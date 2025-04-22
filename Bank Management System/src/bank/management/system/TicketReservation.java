package bank.management.system;

/**
 *
 * @author ADMIN
 */
//package bank.system;

import java.awt.*;
import static java.awt.Font.BOLD;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;

public class TicketReservation extends JFrame implements ActionListener {

    JButton back, income_enter, loan_enter, repay_enter;
    JPanel panel;
    JLabel intro, intro1;

    TicketReservation(){
        //frame
        setSize(700,500);
        setLocation(300,100); setLayout(null);
        setResizable(false);

        //panel
        panel=new JPanel();
        panel.setBounds(0,0,700,53);
        String yellow="#EFCC00";
        panel.setBackground(Color.decode(yellow));
        panel.setLayout(null);
        add(panel);

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
        intro=new JLabel("Ticket Reservation");
        Font font2=new Font("Segoe UI", BOLD, 30);
        intro.setFont(font2);
        intro.setBounds(230,60,300,50);
        intro.setForeground(Color.decode(yellow));
        add(intro);

        //intro1 label
        intro1=new JLabel("      Book your ticket with us from home");
        Font font3=new Font("Segoe UI", BOLD, 30);
        intro1.setFont(font3);
        intro1.setBounds(55,95,700,50);
        intro1.setForeground(Color.decode(yellow));
        add(intro1);



        //income_enter button
        income_enter=new JButton("Flight");
        Font font6=new Font("Segoe UI", BOLD, 18);
        income_enter.setFont(font6);
        income_enter.setBounds(110,220,120,50);
        income_enter.setBackground(Color.decode(yellow));
        income_enter.setForeground(Color.WHITE);
        income_enter.addActionListener(this);
        add(income_enter);


        //loan_enter button
        loan_enter=new JButton("Bus");
        loan_enter.setFont(font6);
        loan_enter.setBounds(430,220,120,50);
        loan_enter.setBackground(Color.decode(yellow));
        loan_enter.setForeground(Color.WHITE);
        loan_enter.addActionListener(this);
        add(loan_enter);




        repay_enter=new JButton("Train");
        repay_enter.setFont(font6);
        repay_enter.setBounds(272,220,120,50);
        repay_enter.setBackground(Color.decode(yellow));
        repay_enter.setForeground(Color.WHITE);
        repay_enter.addActionListener(this);
        add(repay_enter);

        //view
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        //My account action
        if(ae.getSource()==back) {
            setVisible(false);
            new Facilities();
        }

        //income enter
        else if(ae.getSource()==income_enter) {
            setVisible(false);

        new Bus();
        }

        //loan enter action
        else if(ae.getSource()==loan_enter) {


        }

        //repay action
        else if(ae.getSource()==repay_enter) {



        }

    }


    public static void main(String[] args) {
        new TicketReservation();
    }
}