package bank.management.system;

import java.awt.*;
import static java.awt.Font.BOLD;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Facilities extends JFrame implements ActionListener {
     JButton MyAccount; JPanel panel;
     JLabel intro1;
     JButton accountdetails, logout, update, personalloan, fundtransfer, inttransaction, consumerloan, busloans, branchless, creditcard, advsalary, schtransfer, ticket, savingplan, balinquiry;
     JComboBox acc;
     int accno;
     String cardno;
    Facilities(String cardno){
        //frame
        this.cardno=cardno;
        accno=Integer.parseInt(cardno);
        setSize(1550,850);
        setLayout(null);
        setTitle("MCS BANK Facilities");
         
        
        //panel
        panel=new JPanel();
        panel.setBounds(0,0,1550,80);
        String yellow="#EFCC00";
        panel.setBackground(Color.decode(yellow));
        panel.setLayout(null);
        add(panel);
        
        //MCS BANK text field
        JLabel MCS=new JLabel("MCS BANK");
        MCS.setBounds(40,10,200,60);
        MCS.setForeground(Color.WHITE);
        Font font=new Font("Segoe UI", BOLD, 32);
        MCS.setFont(font);
        panel.add(MCS);
        
        // label2
        intro1=new JLabel("Pakistan's Fastest Digital Banking System");
        Font font3=new Font("Segoe UI", BOLD, 26);
        intro1.setFont(font3);
        intro1.setBounds(485,130,700,50);
        intro1.setForeground(Color.decode(yellow));
        add(intro1);
        
        //logout button
        logout=new JButton("LogOut");
        Font font1=new Font("Segoe UI", BOLD, 24);
        logout.setFont(font1);
        logout.setBounds(1400,20,110,35);
        logout.setBackground(Color.decode(yellow));
        logout.setBorder(BorderFactory.createLineBorder(Color.decode(yellow)));
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);
        
        //accountdetails button
        accountdetails=new JButton("Account Details");
        accountdetails.setFont(font1);
        accountdetails.setBounds(1180,20,190,35);
        accountdetails.setBackground(Color.decode(yellow));
        accountdetails.setBorder(BorderFactory.createLineBorder(Color.decode(yellow)));
        accountdetails.setForeground(Color.WHITE);
        accountdetails.addActionListener(this);
        add(accountdetails);
        
//        //update button
//        update=new JButton("Update Info");
//        update.setFont(font1);
//        update.setBounds(1240,20,140,35);
//        update.setBackground(Color.decode(yellow));
//        update.setBorder(BorderFactory.createLineBorder(Color.decode(yellow)));
//        update.setForeground(Color.WHITE);
//        update.addActionListener(this);
//        add(update);
        
        //personal loan button
        personalloan=new JButton("Personal Loan");
        Font font2=new Font("Segoe UI", BOLD, 17);
        personalloan.setFont(font2);
        personalloan.setBounds(340,310,120,30);
        String c="#f0ecec";
        personalloan.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        personalloan.setBackground(Color.decode(c));
        personalloan.setForeground(Color.BLACK);
        personalloan.addActionListener(this);
        add(personalloan);
        
        //consumer loan button
        consumerloan=new JButton("Consumer Loan");
        consumerloan.setFont(new Font("Segoe UI", BOLD, 17));
        consumerloan.setBounds(610,310,150,30);
        consumerloan.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        consumerloan.setBackground(Color.decode(c));
        consumerloan.setForeground(Color.BLACK);
        consumerloan.addActionListener(this);
        add(consumerloan);
         
        //Business loan button
        busloans=new JButton("Business Loan");
        Font font4=new Font("Segoe UI", BOLD, 17);
        busloans.setFont(font4);
        busloans.setBounds(870,310,150,30);
        busloans.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        busloans.setBackground(Color.decode(c));
        busloans.setForeground(Color.BLACK);
        busloans.addActionListener(this);
        add(busloans);
        
        //fundtransfer button
        fundtransfer=new JButton("Fund Transaction");
        Font font5=new Font("Segoe UI", BOLD, 17);
        fundtransfer.setFont(font5);
        fundtransfer.setBounds(580,492,220,30);
         fundtransfer.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        fundtransfer.setBackground(Color.decode(c));
        fundtransfer.setForeground(Color.BLACK);
        fundtransfer.addActionListener(this);
        add(fundtransfer);
        
        //balance inquiry button
        balinquiry=new JButton("Balance Inquiry");
        Font font6=new Font("Segoe UI", BOLD, 17);
        balinquiry.setFont(font6);
        balinquiry.setBounds(340,492,130,30);
         balinquiry.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        balinquiry.setBackground(Color.decode(c));
        balinquiry.setForeground(Color.BLACK);
        balinquiry.addActionListener(this);
        add(balinquiry);
        
        //international transcation button
    /*    inttransaction=new JButton("International Transaction");
        Font font7=new Font("Segoe UI", BOLD, 17);
        inttransaction.setFont(font7);
        inttransaction.setBounds(580,492,220,30);
         inttransaction.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        inttransaction.setBackground(Color.decode(c));
        inttransaction.setForeground(Color.BLACK);
        inttransaction.addActionListener(this);
        add(inttransaction);*/
        
        //branchless banking button
        branchless=new JButton("Branchless Banking");
        Font font8=new Font("Segoe UI", BOLD, 17);
        branchless.setFont(font8);
        branchless.setBounds(865,492,180,30);
         branchless.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        branchless.setBackground(Color.decode(c));
        branchless.setForeground(Color.BLACK);
        branchless.addActionListener(this);
        add(branchless);
        
        //credit card button
        creditcard=new JButton("Credit Card");
        Font font9=new Font("Segoe UI", BOLD, 17);
        creditcard.setFont(font9);
        creditcard.setBounds(1100,310,130,30);
         creditcard.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        creditcard.setBackground(Color.decode(c));
        creditcard.setForeground(Color.BLACK);
        creditcard.addActionListener(this);
        add(creditcard);
        
        //advance salary button
        advsalary=new JButton("Advance Salary");
        Font font10=new Font("Segoe UI", BOLD, 17);
        advsalary.setFont(font10);
        advsalary.setBounds(340,675,130,30);
         advsalary.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        advsalary.setBackground(Color.decode(c));
        advsalary.setForeground(Color.BLACK);
        advsalary.addActionListener(this);
        add(advsalary);
        
        //scheduled transfer button
        schtransfer=new JButton("Schedule Transfer");
        Font font11=new Font("Segoe UI", BOLD, 17);
        schtransfer.setFont(font11);
        schtransfer.setBounds(600,675,180,30);
        schtransfer.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        schtransfer.setBackground(Color.decode(c));
        schtransfer.setForeground(Color.BLACK);
        schtransfer.addActionListener(this);
        add(schtransfer);
        
        //Book travel tickets button
        ticket=new JButton("Book Travel Tickets");
        Font font12=new Font("Segoe UI", BOLD, 17);
        ticket.setFont(font12);
        ticket.setBounds(860,675,200,30);
           ticket.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        ticket.setBackground(Color.decode(c));
        ticket.setForeground(Color.BLACK);
        ticket.addActionListener(this);
        add(ticket);
        
        //saving plan button
        savingplan=new JButton("Saving Plan");
        Font font13=new Font("Segoe UI", BOLD, 17);
        savingplan.setFont(font13);
        savingplan.setBounds(1100,492,150,30);
        savingplan.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        savingplan.setBackground(Color.decode(c));
        savingplan.setForeground(Color.BLACK);
        savingplan.addActionListener(this);
        add(savingplan);
        
        
        //images
         
        //personal loan image
        ImageIcon im=new ImageIcon(ClassLoader.getSystemResource("icons/pic1.jpg"));
        Image i=im.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT);
        ImageIcon IM=new ImageIcon(i);
        JLabel label = new JLabel(IM);
        label.setBounds(368,230,70,70);
        add(label);
        
        //consumer loan image
        ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("icons/pic2.jpg"));
        Image i1=im1.getImage().getScaledInstance(85,85, Image.SCALE_DEFAULT);
        ImageIcon IM1=new ImageIcon(i1);
        JLabel label1 = new JLabel(IM1);
        label1.setBounds(650,227,85,85);
        add(label1);
        
        //business loan image
        ImageIcon im2=new ImageIcon(ClassLoader.getSystemResource("icons/pic3.jpg"));
        Image i2=im2.getImage().getScaledInstance(85,85, Image.SCALE_DEFAULT);
        ImageIcon IM2=new ImageIcon(i2);
        JLabel label2 = new JLabel(IM2);
        label2.setBounds(900,223,85,85);
        add(label2);
        
        //credit caardimage
        ImageIcon im3=new ImageIcon(ClassLoader.getSystemResource("icons/pic4.jpg"));
        Image i3=im3.getImage().getScaledInstance(140,140, Image.SCALE_DEFAULT);
        ImageIcon IM3=new ImageIcon(i3);
        JLabel label3 = new JLabel(IM3);
        label3.setBounds(1090,195,140,140);
        add(label3);
        
        //balance inquiry image
        ImageIcon im4=new ImageIcon(ClassLoader.getSystemResource("icons/pic5.jpg"));
        Image i4=im4.getImage().getScaledInstance(90,90, Image.SCALE_DEFAULT);
        ImageIcon IM4=new ImageIcon(i4);
        JLabel label4 = new JLabel(IM4);
        label4.setBounds(360,400,90,90);
        add(label4);
        
        //international transaction image
        ImageIcon im6=new ImageIcon(ClassLoader.getSystemResource("icons/pic6.jpg"));
        Image i6=im6.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon IM6=new ImageIcon(i6);
        JLabel label6 = new JLabel(IM6);
        label6.setBounds(640,390,100,100);
        add(label6);
        
        //branchless banking image
        ImageIcon im7=new ImageIcon(ClassLoader.getSystemResource("icons/pic7.jpg"));
        Image i7=im7.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon IM7=new ImageIcon(i7);
        JLabel label7 = new JLabel(IM7);
        label7.setBounds(910,387,100,100);
        add(label7);
        
        //saving plan image
        ImageIcon im8=new ImageIcon(ClassLoader.getSystemResource("icons/pic8.jpg"));
        Image i8=im8.getImage().getScaledInstance(90,90, Image.SCALE_DEFAULT);
        ImageIcon IM8=new ImageIcon(i8);
        JLabel label8 = new JLabel(IM8);
        label8.setBounds(1130,396,90,90);
        add(label8);
        
        //advance salary image
        ImageIcon im9=new ImageIcon(ClassLoader.getSystemResource("icons/pic9.jpg"));
        Image i9=im9.getImage().getScaledInstance(80,80, Image.SCALE_DEFAULT);
        ImageIcon IM9=new ImageIcon(i9);
        JLabel label9 = new JLabel(IM9);
        label9.setBounds(370,580,80,80);
        add(label9);
        
        //schedule transfer image
        ImageIcon im10=new ImageIcon(ClassLoader.getSystemResource("icons/pic10.jpg"));
        Image i10=im10.getImage().getScaledInstance(90,90, Image.SCALE_DEFAULT);
        ImageIcon IM10=new ImageIcon(i10);
        JLabel label10 = new JLabel(IM10);
        label10.setBounds(650,580,90,90);
        add(label10);
        
        //ticket transfer image
        ImageIcon im11=new ImageIcon(ClassLoader.getSystemResource("icons/pic11.jpg"));
        Image i11=im11.getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT);
        ImageIcon IM11=new ImageIcon(i11);
        JLabel label11 = new JLabel(IM11);
        label11.setBounds(900,560,120,120);
        add(label11);
        
        //fund transfer image
        ImageIcon im12=new ImageIcon(ClassLoader.getSystemResource("icons/pic12.jpg"));
        Image i12=im12.getImage().getScaledInstance(80,80, Image.SCALE_DEFAULT);
        ImageIcon IM12=new ImageIcon(i12);
        JLabel label12 = new JLabel(IM12);
        label12.setBounds(1140,586,80,80);
        add(label12);
        
        //display
        setVisible(true);

    }
    
    //Action
    public void actionPerformed(ActionEvent ae){
        
        
        //Credit card action
        if(ae.getSource()==creditcard) {
            setVisible(false);
             try {
        // instantiate the connection class
        DataConnection c = new DataConnection();

        ResultSet rs = c.s.executeQuery("SELECT * FROM creditcard WHERE cardno = '" + accno + "'");

       if (rs.next()) {
    String cardNo = rs.getString("cardno");
    String jobTitle = rs.getString("jobtitle");
    String empType = rs.getString("emptype");
    String selectCredit = rs.getString("selectcredit");
    String fine = rs.getString("fine");
    String cardname = rs.getString("cardname");
    // Format the data for display
    String message = "Card No: " + cardNo + "\n"
            +"Card Type: " + cardname + "\n"
            + " Credit: " + selectCredit + "\n"
            + "Fine: " + fine;

    // Display the data in a JOptionPane
    JOptionPane.showMessageDialog(null, message, "Credit Card Details", JOptionPane.INFORMATION_MESSAGE);
}
       else {
           new CreditCard(cardno);
        }

        rs.close();
        c.s.close();
    } catch (Exception e) {
        System.out.println(e);
    }
            new Facilities(cardno);
         }
        
        if(ae.getSource()==fundtransfer) {
            setVisible(false);
            new FundsTransfer1(cardno);
         }
        
        //personal loan action
        if(ae.getSource()==personalloan) {
            setVisible(false);
            new PersonalLoan();
         }
        
        //consumer loan action
        if(ae.getSource()==consumerloan) {
            setVisible(false);
            new ConsumerLoan();
         }
        //busuiness loan action
        if(ae.getSource()==busloans) {
            setVisible(false);
            new BusinessLoan();
         }
        
        //branchless banking option action
        if(ae.getSource()==branchless) {
            setVisible(false);
            new Branchless();
         }
        
        //logout option action
        if(ae.getSource()==logout) {
            setVisible(false);
            new login();
         }
        
        //accountdetails option action
        if(ae.getSource()==accountdetails) {
            setVisible(false);
//            new SignupOne();
         }
        if(ae.getSource()==inttransaction){
            setVisible(false);
            new CurrencyConversion();
        }
        
        if(ae.getSource()==savingplan){
            setVisible(false);
        new savingplan();
        }
        if(ae.getSource()==advsalary){
            setVisible(false);
        new AdvanceSalary();
        }
        
        if(ae.getSource()==ticket){
            setVisible(false);
        new TicketReservation();
        }
        if(ae.getSource()==schtransfer){
            setVisible(false);
        new Schedule();
        }
        
        //balinquiry option action
        if(ae.getSource()==balinquiry) {
            
            //fetch data from database
            String res=null, res1=null;
            DataConnection db=new DataConnection();
             try {
                            String query = "SELECT acc_no, balance FROM Balance WHERE acc_no='"+CardNo.cardno+"'";
                            ResultSet rs=db.s.executeQuery(query);

                            while (rs.next()) {
                                res = rs.getString("acc_no");
                                res1 = rs.getString("balance");
                      }
         
                } catch (Exception e) {
                    System.out.println("SQL Exception: " + e.getMessage());
                }
             JOptionPane.showMessageDialog(null,"Account Number: "+res+"\nBalance: Rs."+res1);
         }
        if(ae.getSource()==accountdetails){
            setVisible(false);
        new Details();
        }
      
    }
    public static void main(String[] args) {
        Facilities a=new Facilities("504839");
    }
}
