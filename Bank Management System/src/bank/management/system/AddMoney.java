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
import java.sql.Timestamp;
import java.util.Date;
 
interface Methods{
    //monthly installment method
    public void monthly_installment(int n, double installment, String selected);
    //exceeded loan
    public void exceeded_loan(double max);
    
      //salary limit
    public void salary_limit();
}

interface Methods1{
    //monthly installment method
    public void monthly_installment(int n, double installment);
    
    //exceeded loan
    public void exceeded_loan(double max);
}

public class AddMoney implements ActionListener {
    int accno;
    String cardno;
    //for current date and time 
    Date currentDate = new Date();
    Timestamp timestamp = new Timestamp(currentDate.getTime());
    
    private int salary, loan;
    String sAmount=null;
    private int price1=749, price2=385, price3=340, price4=1099, price5=749, price6=320, price7=350, price8=1100, price9=180, price10=160, price11=180, price12=200;
    private String offer1="Monthly Super Card", offer2="Super Weekly Premium", offer3="Weekly HLO", offer4="Super Card Gold", offer5="Super Card Max", offer6="Sab Se Bari Offer", offer7="Weekly Extreme Offer ", offer8="Monthly Extreme Offer", offer9="EasyCard180", offer10="Work From Home Offer", offer11="Weekly Super Plus Package", offer12="Mahana Bachat Offer";

    public String getOffer1() {
        return offer1;
    }

    public String getOffer2() {
        return offer2;
    }

    public String getOffer3() {
        return offer3;
    }

    public String getOffer4() {
        return offer4;
    }

    public String getOffer5() {
        return offer5;
    }

    public String getOffer6() {
        return offer6;
    }

    public String getOffer7() {
        return offer7;
    }

    public String getOffer8() {
        return offer8;
    }

    public String getOffer9() {
        return offer9;
    }

    public String getOffer10() {
        return offer10;
    }

    public String getOffer11() {
        return offer11;
    }

    public String getOffer12() {
        return offer12;
    }
    
    public int getPrice1() {
        return price1;
    }

    public int getPrice2() {
        return price2;
    }

    public int getPrice3() {
        return price3;
    }

    public int getPrice4() {
        return price4;
    }

    public int getPrice5() {
        return price5;
    }

    public int getPrice6() {
        return price6;
    }

    public int getPrice7() {
        return price7;
    }

    public int getPrice8() {
        return price8;
    }

    public int getPrice9() {
        return price9;
    }

    public int getPrice10() {
        return price10;
    }

    public int getPrice11() {
        return price11;
    }

    public int getPrice12() {
        return price12;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(int loan) {
        this.loan = loan;
    }
    
    
    JButton back , next ; 
    JFrame nframe=new JFrame();
    JPanel panel;
    JLabel intro, intro1, EmpType ;
    JTextField amount;
    Font font4=new Font("Segoe UI", BOLD, 24); 
//    String cardno=null;
//    private SignupTwo signupTwo;
    
    public AddMoney(String cardno){ //cardno=Cardno; 
//    this.signupTwo = signupTwo; 
//    signupTwo.Hide();
accno=Integer.parseInt(cardno);
this.cardno=cardno;
    System.out.println(CardNo.cardno);
         //frame
        nframe.setSize(700,500);
         nframe.setLocation(300,150); 
         nframe.setLayout(null);  
         
        //panel
        panel=new JPanel();
        panel.setBounds(0,0,700,53);
        String yellow="#EFCC00";
        panel.setBackground(Color.decode(yellow));
        panel.setLayout(null);
          nframe.add(panel);
        
        //MCS BANK label
        JLabel MCS=new JLabel("MCS BANK");
        MCS.setBounds(20,0,185,50);
        MCS.setForeground(Color.WHITE);
        Font font=new Font("Segoe UI", BOLD, 32);
        MCS.setFont(font);
        panel.add(MCS);
        
        
         //next button
        next=new JButton("next");
        Font font1=new Font("Segoe UI", BOLD, 12);
        next.setFont(font1);
        next.setBounds(460,380,150,30);
        next.addActionListener(this);
         nframe.add(next);
        
        // label1
        intro=new JLabel("Pakistan's Fastest Digital Banking System");
        Font font2=new Font("Segoe UI", BOLD, 28);
        intro.setFont(font2);
        intro.setBounds(70,100,560,50);
        intro.setForeground(Color.decode(yellow));
         nframe.add(intro);
        
        // label2
        intro1=new JLabel("Deposit some amount in your account");
        Font font3=new Font("Segoe UI", BOLD, 24);
        intro1.setFont(font3);
        intro1.setBounds( 126,165,700,50);
        intro1.setForeground(Color.decode(yellow));
         nframe.add(intro1);
        
        // label3
       EmpType=new JLabel("Enter amount ");   
       EmpType.setFont(font4);
       EmpType.setBounds(160,234,250,50);
        nframe.add(EmpType);
      
         // Text field for amount
         amount = new JTextField();
         amount .setFont(new Font("Segoe UI", BOLD, 24));
         amount.setBounds(360,250,150,30);
          nframe.add(amount);
          
         nframe.setVisible(true);
        
    }
  
    //Action
    public void actionPerformed(ActionEvent ae){ 
        
        
   
        //My account action
        if(ae.getSource()==next) {
            sAmount = amount.getText();
       int samount=Integer.parseInt(sAmount);
            if (samount==0){
            
                JOptionPane.showMessageDialog(null," Plese Enter some amount in your account" );
        }
            else  {
            DataConnection db =new DataConnection();
                try{
                   String query = "UPDATE MainTable SET balance = '" + samount + "' WHERE cardno = '" + accno + "'";


                 db.s.executeUpdate(query);
                    System.out.println(CardNo.cardno);
                    JOptionPane.showMessageDialog(null," The amount is deposited in your account" );
                    
                nframe.setVisible(false);
            new Facilities(cardno);
                }
                catch(Exception e){
                    System.out.println(e);
                }
                             
         }
            
        }
    }
}
        
       
        
 
            

      
    
  