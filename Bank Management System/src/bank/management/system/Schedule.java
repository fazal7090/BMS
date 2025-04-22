package bank.management.system;

import java.awt.*;
import static java.awt.Font.BOLD;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import com.toedter.calendar.JDateChooser;
import java.time.ZoneId;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;

public class Schedule extends JFrame implements ActionListener  {
    JPanel panel;
    JComboBox frqshow;  String[] cre={"Daily", "Monthly", "Yearly"};
    JButton back, confirm;
    
    JLabel heading, quoteline, Amount, freq,endate,minincome,startdate,accno;
    JTextField Amountentered, incomeentered,fineshow,accnoentered;
    JDateChooser enddateentered,startdateentered;
    String income_input,emp_inp,JOBtit_inp,cre_lim;
    Schedule()
            
    {
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
       // back.addActionListener(this);
        add(back);
        
        //intro label
        heading=new JLabel("Schedule Transfer");
        Font font2=new Font("Segoe UI", BOLD, 30);
        heading.setFont(font2);
        heading.setBounds(230,60,300,50);
        heading.setForeground(Color.decode(yellow));
        add(heading);
        
        //intro1 label
        quoteline=new JLabel("Automate your financial transactions with scheduled transfers");
        Font font3=new Font("Segoe UI", BOLD, 20);
        quoteline.setFont(font3);
        quoteline.setBounds(35,95,700,50);
        quoteline.setForeground(Color.decode(yellow));
        add(quoteline);
        
        //employment type label
       Amount=new JLabel("Total Amount");
       Font font4=new Font("Segoe UI", BOLD, 16);
       Amount.setFont(font4);
       Amount.setBounds(10,155,200,50);
       add(Amount);
       
       Amountentered=new JTextField();
        Amountentered.setBounds(280,170,150,20);
        add(Amountentered);
        
          freq=new JLabel("Frequency");
                  Font font5=new Font("Segoe UI", BOLD, 16);
       freq.setFont(font5);
        freq.setBounds(10,197,300,50);
        add(freq);
        
         //repay dropdown
         frqshow=new JComboBox(cre);
         frqshow.setBounds(280,210, 150,30);
         add(frqshow);
      
        startdate=new JLabel("Start Date");
       startdate.setFont(font5);
        startdate.setBounds(10,239,300,50);
        add(startdate);
        
         startdateentered=new JDateChooser();
        startdateentered.setBounds(280,255,150,20);
        add(startdateentered);
        
        endate=new JLabel("End Date");
       endate.setFont(font5);
        endate.setBounds(10,282,300,50);
        add(endate);
        
         enddateentered=new JDateChooser();
        enddateentered.setBounds(280,295,150,20);
        add(enddateentered);
        
        accno=new JLabel("Account Number of Receipent");
       accno.setFont(font5);
        accno.setBounds(10,324,300,50);
        add(accno);
        
         accnoentered=new JTextField();
        accnoentered.setBounds(280,335,150,20);
        add(accnoentered);
        
        confirm =new JButton("CONFIRM");
        confirm.setFont(font1);
        confirm.setBounds(550,400,100,30);
        confirm.setBackground(Color.decode(yellow));
        confirm.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        confirm.setForeground(Color.WHITE);
        confirm.addActionListener(this);
        add(confirm);
        
        
        
       
        
        setVisible(true); }
                 String frequ=null;
    public void actionPerformed(ActionEvent ae){
        
        if (ae.getSource()==back){
            setVisible(false);
            new Facilities();
        }
        if (ae.getSource()==confirm)
        {
             String startdate = ((JTextField) startdateentered.getDateEditor().getUiComponent()).getText();
             String enddate = ((JTextField) enddateentered.getDateEditor().getUiComponent()).getText();
             String accno = accnoentered.getText();
             String totalamount= Amountentered.getText();
             LocalDate startDate = startdateentered.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate endDate = enddateentered.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            // Calculate the date difference
            long daysDifference = ChronoUnit.DAYS.between(startDate, endDate);
             frqshow.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                  if (frqshow.getSelectedItem().equals("Daily"))
                  {
                      frequ="Daily";
                  }
                else if (frqshow.getSelectedItem().equals("Monthly"))
                  {
                      frequ="Monthly";
                  }
                 if (frqshow.getSelectedItem().equals("Yearly"))
                  {
                      frequ="Yearly";
                  }}}});

       String query = "select * from  login2 where cardno='"+CardNo.cardno+"'";
   
                  try {
           
              DataConnection c=new DataConnection();
           
               if (c.s.execute(query)==true)
              {
String query1 = "INSERT INTO scheduled VALUES ('" + startDate + "', '" + endDate + "', '" + totalamount + "', '" + daysDifference + "', '" + CardNo.cardno + "')";


    
   c.s.execute(query1);
   
     JOptionPane.showMessageDialog(null, "Application submitted succesfully");

              }
                  else
              {
              {
   JOptionPane.showMessageDialog(null, "No such account number exsist.Please enter correct Account number");
              }
                      }
              
                
             }

               
             catch (Exception e) {
               System.out.println(e);
            }}
        }
    
             
        
    
    public static void main(String[] args) {
        new Schedule();
    }}
