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
import javax.swing.JOptionPane;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Visa  implements ActionListener {
    
    private JFrame frame1=new JFrame();
        
    JPanel panel;
    JComboBox creditlimshow;  String[] cre={"150,000 Rupees", "200,000 Rupees", "250,000 Rupees", "400,000 Rupees"};
    JRadioButton SalPer, Businessman;  
    ButtonGroup emp;
    JButton back, crelimenter,confirm;
            

    
    JLabel intro, intro1, EmpType, Job, income, Creditlim,fine,minincome;
    JTextField jobentered, incomeentered,fineshow;
   String cardno;
   int accno;
    Visa(String cardno)
            
    {
        this.cardno=cardno;
        accno=Integer.parseInt(cardno);

         frame1.setSize(1350,700);
        frame1.setLocation(00,00); frame1.setLayout(null);
        frame1.setResizable(false);
        
       //panel
        panel=new JPanel();
        panel.setBounds(0,0,1350,83);
        String yellow="#EFCC00";
        panel.setBackground(Color.decode(yellow));
        panel.setLayout(null);
        frame1.add(panel);
        
        //MCS BANK label
        JLabel MCS=new JLabel("MCS BANK");
        MCS.setBounds(20,15,185,50);
        MCS.setForeground(Color.WHITE);
        Font font=new Font("Segoe UI", BOLD, 32);
        MCS.setFont(font);
        panel.add(MCS);
        
        //back button
         back=new JButton("Back");
        Font font1=new Font("Segoe UI", BOLD, 32);
        back.setFont(font1);
        back.setBounds(1170,12,130,50);
        back.setBackground(Color.decode(yellow));
        back.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        frame1.add(back);
        
        //intro label
        intro=new JLabel("Apply for Visa Credit Card");
        Font font2=new Font("Segoe UI", BOLD, 30);
        intro.setFont(font2);
        intro.setBounds(530,95,700,50);
        intro.setForeground(Color.decode(yellow));
        frame1.add(intro);
        
        //intro1 label
        intro1=new JLabel("Easy solution to your financial needs");
        Font font3=new Font("Segoe UI", BOLD, 30);
        intro1.setFont(font3);
        intro1.setBounds(440,145,700,50);
        intro1.setForeground(Color.decode(yellow));
        frame1.add(intro1);
        
        //employment type label
       EmpType=new JLabel("Employment Type");
       Font font4=new Font("Segoe UI", BOLD, 22);
       EmpType.setFont(font4);
       EmpType.setBounds(60,245,200,50);
       frame1.add(EmpType);
      
        //salaried person radio button
        SalPer=new JRadioButton("Salaried Person");
        SalPer.setFont(font4);
         SalPer.setBounds(325,248,200,50);
         SalPer.addActionListener(this);
         frame1.add(SalPer);
         
        //businessman radio button
        Businessman=new JRadioButton("Businessman");
        Businessman.setFont(font4);
        Businessman.setBounds(530,248,220,50);
        Businessman.addActionListener(this);
        frame1.add(Businessman);
         
         //for single option
         emp=new ButtonGroup();
         emp.add(SalPer);
         emp.add(Businessman);
         
          //income label
        Job=new JLabel("Job Title/Bussiness");
        Font font5=new Font("Segoe UI", BOLD, 22);
        Job.setFont(font5);
        Job.setBounds(60,310,300,50);
        frame1.add(Job);
        
        //income text field
        jobentered=new JTextField();
        jobentered.setBounds(325,310,300,35);
        frame1.add(jobentered);
        Font font6=new Font("Segoe UI", BOLD, 18);

       
         //LOAN label
        income=new JLabel("Monthly Net Income");
        income.setFont(font5);
        income.setBounds(60,375,300,50);
        frame1.add(income);
        
        minincome=new JLabel("(Minimun Income =Rs.300,000) ");
        minincome.setFont(font5);
        minincome.setBounds(60,420,400,50);
        frame1.add(minincome);
        
        
        //loan text field
        incomeentered=new JTextField();
        incomeentered.setBounds(325,385,300,35);
        frame1.add(incomeentered);
        
        
       
        
        Creditlim=new JLabel("Credit Limit");
        Creditlim.setFont(font5);
        Creditlim.setBounds(60,475,300,50);
        frame1.add(Creditlim);
        
         
        creditlimshow=new JComboBox(cre);
        creditlimshow.setBounds(325,475, 150,40);
        frame1.add(creditlimshow);
         
        
        
        crelimenter=new JButton("Enter");
        crelimenter.setFont(font6);
        crelimenter.setBounds(510,475,100,40);
        crelimenter.setBackground(Color.decode(yellow));
        crelimenter.setForeground(Color.WHITE);
        crelimenter.addActionListener(this);
        frame1.add(crelimenter);
       
        // Fine
        fine=new JLabel("Corresponding Fine");
        fine.setFont(font5);
        fine.setBounds(60,540,300,50);
        frame1.add(fine);
        
         //repay dropdown
         fineshow=new JTextField();
         fineshow.setBounds(325,550, 200,35);
         frame1.add(fineshow);
         
         //Confirm button
         confirm =new JButton("CONFIRM");
        confirm.setFont(font1);
        confirm.setBounds(1100,600,170,50);
        confirm.setBackground(Color.decode(yellow));
        confirm.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        confirm.setForeground(Color.WHITE);
        confirm.addActionListener(this);
        frame1.add(confirm);
     
         
       
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/i4.JPG"));// importing 
        //image from another class
        Image i5=i4.getImage().getScaledInstance(550, 300,Image.SCALE_DEFAULT);//for setting h,w,l otherwise will be very Large
        ImageIcon i6 = new ImageIcon(i5);//we are converting iage into imageicon bec jlabel cant work with image
         JLabel label1=new JLabel(i6);// imagesicon cant be directly placed on frames so passing it in jlabel
       // and then placing it  on frame
        label1.setBounds(780, 220, 550,300);//for setting the loc of image otherwise will be centered
        //1st arg horiontal distance from frame 2nd arg vertical dis from fram ,3rd 4th l anh h of image as passed in line 13
        frame1.add(label1);//adding image on to frame after convertingit in obj of jlabel
        
        frame1.setVisible(true);    }
    double incinp; 
public void actionPerformed(ActionEvent ae){
         

    if (ae.getSource()==back)
    {
        frame1.setVisible(false);
        new CreditCard(cardno);
        
    }
  
     else if (ae.getSource()==crelimenter)
      {
             String selected = (String) creditlimshow.getSelectedItem();

           if(selected.equals(cre[0])){
             fineshow.setText("Rs. 10,000 over period of one month");
        }
            
          else if(selected.equals(cre[1])){
             fineshow.setText("Rs. 15,000 over period of month");
        }
          else if(selected.equals(cre[2])){
             fineshow.setText("Rs. 20,000 over period of month");
        }
          else if(selected.equals(cre[3])){
             fineshow.setText("Rs. 25,000 over period of one month");
        }
          
         
      }
     else if (ae.getSource()==confirm)
        {
            String income=incomeentered.getText();
String jobtitle=jobentered.getText();
String emptype=null;
String selectcredit=(String) creditlimshow.getSelectedItem();
String cardname="Visa Credit Card";
if (SalPer.isSelected())
{
    emptype="Salaried Person";
}
else if (Businessman.isSelected())
{
    emptype="Bussiness man";
}
       
String fine=fineshow.getText();

    if (incomeentered.getText().isEmpty()||jobentered.getText().equals("")||emptype.equals("")||fineshow.getText().equals(""))
    {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
}
    else 
    {
int inc = Integer.parseInt(income);

if (inc<300000)
{
                     JOptionPane.showMessageDialog(null, "You are not eligible to apply for this credit card.");
new CreditCard(cardno);   
}
else if(inc>300000)
{
    
     try {
           
String query = "INSERT INTO creditcard VALUES(" + accno + ", '" + jobtitle + "', '" + emptype + "', '" + income + "', '" + selectcredit + "', '" + fine + "', '" + cardname + "')";



                DataConnection c = new DataConnection();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Credit Card Details Inserted Successfully .");
                frame1.setVisible(false);
                new Facilities(cardno);
                
             }

               
             catch (Exception e) {
               System.out.println(e);
            }}
        }
    }

       
     }

    public static void main(String[] args) {
        Visa a=new Visa("11");
    }
}
