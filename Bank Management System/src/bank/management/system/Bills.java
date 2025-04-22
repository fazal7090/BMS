package bank.management.system;
import java.awt.*;
import static java.awt.Font.BOLD;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;

public class Bills extends AddMoney implements ActionListener {
    String n_balance=null; double n_bal=0;
    boolean waterClicked=false, elecClicked=false, gasClicked=false, netClicked=false;
    double balance=0;    String st1=null, st2 = null; double inp;
    private JFrame frame4=new JFrame();
    JPanel panel;
    JTextField WATER_NO, ELEC_NO, GAS_NO, NET_NO, WATER_AM, ELEC_AM, GAS_AM, NET_AM;
    JLabel MCS, quote, water_no, elec_no, gas_no, net_no, water_am, elec_am, gas_am, net_am, label4, con_bill, con_am;
    JButton back, water, elec, gas, net, enter1, enter2, enter3, enter4, confirm_payment;
    //for current date and time 
    Date currentDate = new Date();
    Timestamp timestamp = new Timestamp(currentDate.getTime());
    
    Bills(){ nframe.setVisible(false);
           //frame
        frame4.setSize(1366,768);
        frame4.setLocation(0,0); frame4.setLayout(null);
        frame4.setResizable(false);
        
        //panel
        panel=new JPanel();
        panel.setBounds(0,0,1366,80);
        String yellow="#EFCC00";
        panel.setBackground(Color.decode(yellow));
        panel.setLayout(null);
        frame4.add(panel);
        
        //MCS BANK label
        JLabel MCS=new JLabel("MCS BANK");
        MCS.setBounds(20,10,220,50);
        MCS.setForeground(Color.WHITE);
        Font font=new Font("Segoe UI", BOLD, 40);
        MCS.setFont(font);
        panel.add(MCS);
        
        //back button
         back=new JButton("Back");
        Font font1=new Font("Segoe UI", BOLD, 20);
        back.setFont(font1);
        back.setBounds(1250,17,60,35);
        back.setBackground(Color.decode(yellow));
        back.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        frame4.add(back);
        
        //water bill button
         water=new JButton("Water Bill");
         Font font2=new Font("Segoe UI", BOLD, 30);
        water.setFont(font2);
        water.setBounds(40,190,350,60);
        String c="#f0ecec";
        water.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        water.setBackground(Color.decode(c));
        water.setForeground(Color.BLACK);
        water.addActionListener(this);
        frame4.add(water);
        
        //elec bill button
         elec=new JButton("Electricity Bill");
        elec.setFont(font2);
        elec.setBounds(340,190,350,60);
        elec.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        elec.setBackground(Color.decode(c));
        elec.setForeground(Color.BLACK);
        elec.addActionListener(this);
        frame4.add(elec);
        
         //gas button
         gas=new JButton("Gas Bill");
        gas.setFont(font2);
        gas.setBounds(735,190,150,60);
        gas.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        gas.setBackground(Color.decode(c));
        gas.setForeground(Color.BLACK);
        gas.addActionListener(this);
        frame4.add(gas);
        
         //net button
         net=new JButton("Net Bill");
        net.setFont(font2);
        net.setBounds(1037,190,150,60);
        net.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        net.setBackground(Color.decode(c));
        net.setForeground(Color.BLACK);
        net.addActionListener(this);
       frame4. add(net);
        
      //quote label
        quote=new JLabel("Fast, secure, and hassle-free bill payments");
        Font font3=new Font("Segoe UI", BOLD, 40);
        quote.setFont(font3);
        quote.setBounds(300,600,1000,50);
        quote.setForeground(Color.decode(yellow));
        frame4.add(quote);
        
      //water_no label
        water_no=new JLabel("Enter Water Bill Number");
        Font font4=new Font("Segoe UI", BOLD, 25);
        water_no.setFont(font4);
        water_no.setBounds(200,330,1000,50);
        water_no.setForeground(Color.BLACK);
        frame4.add(water_no);
        water_no.setVisible(false);
        
      //water_am label
        water_am=new JLabel("Enter Bill Amount");
        water_am.setFont(font4);
        water_am.setBounds(200,430,1000,50);
        water_am.setForeground(Color.BLACK);
        frame4.add(water_am);
        water_am.setVisible(false);
        
        //WATER_NO text field
        WATER_NO=new JTextField();
        WATER_NO.setBounds(550,340,140,35);
        frame4.add(WATER_NO);
        WATER_NO.setVisible(false);
        
        //WATER_AM text field
        WATER_AM=new JTextField();
        WATER_AM.setBounds(550,440,140,35);
        frame4.add(WATER_AM);
        WATER_AM.setVisible(false);
        
        //enter1 button
         enter1=new JButton("Enter");
         Font font6=new Font("Segoe UI", BOLD, 18);
        enter1.setFont(font6);
        enter1.setBounds(750,440,80,40);
        enter1.setBackground(Color.decode(yellow));
        enter1.setForeground(Color.WHITE);
        enter1.addActionListener(this);
        frame4.add(enter1);
        enter1.setVisible(false);
        
        //enter2 button
         enter2=new JButton("Enter");
        enter2.setFont(font6);
        enter2.setBounds(750,440,80,40);
        enter2.setBackground(Color.decode(yellow));
        enter2.setForeground(Color.WHITE);
        enter2.addActionListener(this);
        frame4.add(enter2);
        enter2.setVisible(false);
        
        //enter3 button
         enter3=new JButton("Enter");
        enter3.setFont(font6);
        enter3.setBounds(750,440,80,40);
        enter3.setBackground(Color.decode(yellow));
        enter3.setForeground(Color.WHITE);
        enter3.addActionListener(this);
        frame4.add(enter3);
        enter3.setVisible(false);
        
        //enter4 button
         enter4=new JButton("Enter");
        enter4.setFont(font6);
        enter4.setBounds(750,440,80,40);
        enter4.setBackground(Color.decode(yellow));
        enter4.setForeground(Color.WHITE);
        enter4.addActionListener(this);
        frame4.add(enter4);
        enter4.setVisible(false);
        
        
      //elec_no label
        elec_no=new JLabel("Enter Electricity Bill Number");
        elec_no.setFont(font4);
        elec_no.setBounds(200,330,1000,50);
        elec_no.setForeground(Color.BLACK);
        frame4.add(elec_no);
        elec_no.setVisible(false);
        
      //elec_am label
        elec_am=new JLabel("Enter Bill Amount");
        elec_am.setFont(font4);
        elec_am.setBounds(200,430,1000,50);
        elec_am.setForeground(Color.BLACK);
        frame4.add(elec_am);
        elec_am.setVisible(false);
        
        //ELEC_NO text field
        ELEC_NO=new JTextField();
        ELEC_NO.setBounds(550,340,140,35);
        frame4.add(ELEC_NO);
        ELEC_NO.setVisible(false);
        
        //ELEC_AM text field
        ELEC_AM=new JTextField();
        ELEC_AM.setBounds(550,440,140,35);
        frame4.add(ELEC_AM);
        ELEC_AM.setVisible(false);
        
      //gas_no label
        gas_no=new JLabel("Enter Gas Bill Number");
        gas_no.setFont(font4);
        gas_no.setBounds(200,330,1000,50);
        gas_no.setForeground(Color.BLACK);
        frame4.add(gas_no);
        gas_no.setVisible(false);
        
      //gas_am label
        gas_am=new JLabel("Enter Bill Amount");
        gas_am.setFont(font4);
        gas_am.setBounds(200,430,1000,50);
        gas_am.setForeground(Color.BLACK);
        frame4.add(gas_am);
        gas_am.setVisible(false);
        
        //GAS_NO text field
        GAS_NO=new JTextField();
        GAS_NO.setBounds(550,340,140,35);
        frame4.add(GAS_NO);
        GAS_NO.setVisible(false);
        
        //GAS_AM text field
        GAS_AM=new JTextField();
        GAS_AM.setBounds(550,440,140,35);
        frame4.add(GAS_AM);
        GAS_AM.setVisible(false);
        
      //net_no label
        net_no=new JLabel("Enter Internet Bill Number");
        net_no.setFont(font4);
        net_no.setBounds(200,330,1000,50);
        net_no.setForeground(Color.BLACK);
        frame4.add(net_no);
        net_no.setVisible(false);
        
      //net_am label
        net_am=new JLabel("Enter Bill Amount");
        net_am.setFont(font4);
        net_am.setBounds(200,430,1000,50);
        net_am.setForeground(Color.BLACK);
        frame4.add(net_am);
        net_am.setVisible(false);
        
        //NET_NO text field
        NET_NO=new JTextField();
        NET_NO.setBounds(550,340,140,35);
        frame4.add(NET_NO);
        NET_NO.setVisible(false);
        
        //NET_AM text field
        NET_AM=new JTextField();
        NET_AM.setBounds(550,440,140,35);
        frame4.add(NET_AM);
        NET_AM.setVisible(false);
        
        
        
        
        //images
        
        //water bill image
        ImageIcon im=new ImageIcon(ClassLoader.getSystemResource("logo/water.png"));
        Image i=im.getImage().getScaledInstance(80,80, Image.SCALE_DEFAULT);
        ImageIcon IM=new ImageIcon(i);
        JLabel label = new JLabel(IM);
        label.setBounds(170,110,80,80);
       frame4. add(label);
        
        //elec image
        ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("logo/elec.png"));
        Image i1=im1.getImage().getScaledInstance(75,75, Image.SCALE_DEFAULT);
        ImageIcon IM1=new ImageIcon(i1);
        JLabel label1 = new JLabel(IM1);
        label1.setBounds(470,110,75,75);
        frame4.add(label1);
        
        //gas image
        ImageIcon im2=new ImageIcon(ClassLoader.getSystemResource("logo/gas.png"));
        Image i2=im2.getImage().getScaledInstance(75,75, Image.SCALE_DEFAULT);
        ImageIcon IM2=new ImageIcon(i2);
        JLabel label2 = new JLabel(IM2);
        label2.setBounds(770,110,75,75);
        frame4.add(label2);
        
        //net image
        ImageIcon im3=new ImageIcon(ClassLoader.getSystemResource("logo/net.png"));
        Image i3=im3.getImage().getScaledInstance(75,75, Image.SCALE_DEFAULT);
        ImageIcon IM3=new ImageIcon(i3);
        JLabel label3 = new JLabel(IM3);
        label3.setBounds(1070,110,75,75);
        frame4.add(label3);
        
        //bill image
        ImageIcon im4=new ImageIcon(ClassLoader.getSystemResource("logo/BILL (2).png"));
        Image i4=im4.getImage().getScaledInstance(350,350, Image.SCALE_DEFAULT);
        ImageIcon IM4=new ImageIcon(i4);
        label4 = new JLabel(IM4);
        label4.setBounds(500,250,350,350);
        frame4.add(label4);
        
        //visible 
        frame4.setVisible(true);
    }
    
    
    
    
    
    
    
    
    
     //Action
    public void actionPerformed(ActionEvent ae){ 
     
       
        
        //confirm payment page
        JFrame confirm=new JFrame();
        confirm.setSize(300,170);
        confirm.setLocation(500,200); confirm.setLayout(null);
        confirm.setResizable(false);
        confirm.setVisible(false);
        
        
        //back action
        if(ae.getSource()==back) {
            frame4.setVisible(false);
            new Branchless();
         }
        
        //water bill action
        if(ae.getSource()==water) {
            waterClicked=true;
            //visible false
              gas_no.setVisible(false);
            GAS_NO.setVisible(false);
           gas_am.setVisible(false);
            GAS_AM.setVisible(false);
            enter3.setVisible(false);
            
            net_no.setVisible(false);
            NET_NO.setVisible(false);
           net_am.setVisible(false);
            NET_AM.setVisible(false);
            enter4.setVisible(false);
            
            elec_no.setVisible(false);
            ELEC_NO.setVisible(false);
            elec_am.setVisible(false);
            ELEC_AM.setVisible(false);
            enter2.setVisible(false);
            
            //visible true
            label4.setVisible(false);
            water_no.setVisible(true);
            WATER_NO.setVisible(true);
            water_am.setVisible(true);
            WATER_AM.setVisible(true);
            enter1.setVisible(true);
            
         }
        
        //elec bill action
        if(ae.getSource()==elec) {
            elecClicked=true;
            //visible false
            label4.setVisible(false);
            water_no.setVisible(false);
            WATER_NO.setVisible(false);
            water_am.setVisible(false);
            WATER_AM.setVisible(false);
            enter1.setVisible(false);
            
             gas_no.setVisible(false);
            GAS_NO.setVisible(false);
           gas_am.setVisible(false);
            GAS_AM.setVisible(false);
            enter3.setVisible(false);
            
            net_no.setVisible(false);
            NET_NO.setVisible(false);
           net_am.setVisible(false);
            NET_AM.setVisible(false);
            enter4.setVisible(false);
            
            //visible true
            label4.setVisible(false);
            elec_no.setVisible(true);
            ELEC_NO.setVisible(true);
            elec_am.setVisible(true);
            ELEC_AM.setVisible(true);
            enter2.setVisible(true);
         }
        
        //gas bill action
        if(ae.getSource()==gas) {
            gasClicked=true;
            //visible false
            label4.setVisible(false);
             net_no.setVisible(false);
            NET_NO.setVisible(false);
           net_am.setVisible(false);
            NET_AM.setVisible(false);
            enter4.setVisible(false);
            
            elec_no.setVisible(false);
            ELEC_NO.setVisible(false);
            elec_am.setVisible(false);
            ELEC_AM.setVisible(false);
            enter2.setVisible(false);
            
             water_no.setVisible(false);
            WATER_NO.setVisible(false);
            water_am.setVisible(false);
            WATER_AM.setVisible(false);
            enter1.setVisible(false);
            
            //visible true
            label4.setVisible(false);
            gas_no.setVisible(true);
            GAS_NO.setVisible(true);
           gas_am.setVisible(true);
            GAS_AM.setVisible(true);
            enter3.setVisible(true);
         }
        
        //net bill action
        if(ae.getSource()==net) {
            netClicked=true;
            //visible false
             label4.setVisible(false);
            water_no.setVisible(false);
            WATER_NO.setVisible(false);
            water_am.setVisible(false);
            WATER_AM.setVisible(false);
            enter1.setVisible(false);
            
             gas_no.setVisible(false);
            GAS_NO.setVisible(false);
           gas_am.setVisible(false);
            GAS_AM.setVisible(false);
            enter3.setVisible(false);
            
             elec_no.setVisible(false);
            ELEC_NO.setVisible(false);
            elec_am.setVisible(false);
            ELEC_AM.setVisible(false);
            enter2.setVisible(false);
            
            //visible true
            label4.setVisible(false);
            net_no.setVisible(true);
            NET_NO.setVisible(true);
           net_am.setVisible(true);
            NET_AM.setVisible(true);
            enter4.setVisible(true);
         }
        
        //enter1 action
        if(ae.getSource()==enter1){
            //inputs
            st1=WATER_NO.getText();
            st2=WATER_AM.getText();
            
            if(st1.isEmpty() || st2.isEmpty()){
                JOptionPane.showMessageDialog(null,"Empty field(s)");
            }
           inp=parseDouble(st2);
                //confirm window
            
            //con_bill
            con_bill=new JLabel("Bill No: "+st1);
            Font font=new Font("Segoe UI", BOLD, 15);
            con_bill.setFont(font);
            con_bill.setBounds(10,10,300,30);
            con_bill.setForeground(Color.BLACK);
            confirm.add(con_bill);
            
            //con_am
            con_am=new JLabel("Bill Amount: Rs."+st2);
            con_am.setFont(font);
            con_am.setBounds(10,35,300,30);
            con_am.setForeground(Color.BLACK);
            confirm.add(con_am);
            
             //confirm_payment bill button
            confirm_payment=new JButton("Confirm Payment");
           confirm_payment.setFont(font);
           confirm_payment.setBounds(100,80,170,30);
           String yellow="#EFCC00";
           confirm_payment.setBackground(Color.decode(yellow));
           confirm_payment.setForeground(Color.WHITE);
           confirm_payment.addActionListener(this);
           confirm.add(confirm_payment);
            
            //visibility
            confirm.setVisible(true);
        }
        
        if(ae.getSource()==enter2){ 
            //inputs
            st1=ELEC_NO.getText();
            st2=ELEC_AM.getText();
            
            if(st1.isEmpty() || st2.isEmpty()){
                JOptionPane.showMessageDialog(null,"Empty field(s)");
            }
                inp=parseDouble(st2);
                //confirm window
            
            //con_bill
            con_bill=new JLabel("Bill No: "+st1);
            Font font=new Font("Segoe UI", BOLD, 15);
            con_bill.setFont(font);
            con_bill.setBounds(10,10,300,30);
            con_bill.setForeground(Color.BLACK);
            confirm.add(con_bill);
            
            //con_am
            con_am=new JLabel("Bill Amount: Rs."+st2);
            con_am.setFont(font);
            con_am.setBounds(10,35,300,30);
            con_am.setForeground(Color.BLACK);
            confirm.add(con_am);
            
             //confirm_payment bill button
            confirm_payment=new JButton("Confirm Payment");
           confirm_payment.setFont(font);
           confirm_payment.setBounds(100,80,170,30);
           String yellow="#EFCC00";
           confirm_payment.setBackground(Color.decode(yellow));
           confirm_payment.setForeground(Color.WHITE);
           confirm_payment.addActionListener(this);
           confirm.add(confirm_payment);
            
            //visibility
            confirm.setVisible(true);
        }
        
        if(ae.getSource()==enter3){ 
            //inputs
            st1=GAS_NO.getText();
            st2=GAS_AM.getText();
            
            if(st1.isEmpty() || st2.isEmpty()){
                JOptionPane.showMessageDialog(null,"Empty field(s)");
            }
                inp=parseDouble(st2);
                //confirm window
            
            //con_bill
            con_bill=new JLabel("Bill No: "+st1);
            Font font=new Font("Segoe UI", BOLD, 15);
            con_bill.setFont(font);
            con_bill.setBounds(10,10,300,30);
            con_bill.setForeground(Color.BLACK);
            confirm.add(con_bill);
            
            //con_am
            con_am=new JLabel("Bill Amount: Rs."+st2);
            con_am.setFont(font);
            con_am.setBounds(10,35,300,30);
            con_am.setForeground(Color.BLACK);
            confirm.add(con_am);
            
             //confirm_payment bill button
            confirm_payment=new JButton("Confirm Payment");
           confirm_payment.setFont(font);
           confirm_payment.setBounds(100,80,170,30);
           String yellow="#EFCC00";
           confirm_payment.setBackground(Color.decode(yellow));
           confirm_payment.setForeground(Color.WHITE);
           confirm_payment.addActionListener(this);
           confirm.add(confirm_payment);
            
            //visibility
            confirm.setVisible(true);
            
        }
        
        if(ae.getSource()==enter4){ 
            //inputs
            st1=NET_NO.getText();
            st2=NET_AM.getText();
            
            if(st1.isEmpty() || st2.isEmpty()){
                JOptionPane.showMessageDialog(null,"Empty field(s)");
            }
                inp=parseDouble(st2);
                //confirm window
            
            //con_bill
            con_bill=new JLabel("Bill No: "+st1);
            Font font=new Font("Segoe UI", BOLD, 15);
            con_bill.setFont(font);
            con_bill.setBounds(10,10,300,30);
            con_bill.setForeground(Color.BLACK);
            confirm.add(con_bill);
            
            //con_am
            con_am=new JLabel("Bill Amount: Rs."+st2);
            con_am.setFont(font);
            con_am.setBounds(10,35,300,30);
            con_am.setForeground(Color.BLACK);
            confirm.add(con_am);
            
             //confirm_payment bill button
            confirm_payment=new JButton("Confirm Payment");
           confirm_payment.setFont(font);
           confirm_payment.setBounds(100,80,170,30);
           String yellow="#EFCC00";
           confirm_payment.setBackground(Color.decode(yellow));
           confirm_payment.setForeground(Color.WHITE);
           confirm_payment.addActionListener(this);
           confirm.add(confirm_payment);
            
            //visibility
            confirm.setVisible(true);
            
        }
        
        if(ae.getSource()==confirm_payment){
             //insert values into Bill tables
                 DataConnection db=new DataConnection();
                 
                 //check if current balance is sufficient for this bill, if yes then execute
            try {
                    String query = "select balance  FROM Balance WHERE acc_no = '" + CardNo.cardno + "'";
                   ResultSet rs = db.s.executeQuery(query);

                    while (rs.next()) {
                        n_balance = rs.getString("balance");
                    }
            }
            catch(Exception e){
                    System.out.println(e);
                    }
            
            //change n_balance to double
            n_bal=parseDouble(n_balance);
                 
                if(n_bal>=inp){
                     //water
                 if(waterClicked){
                         //update balance
                        String res = null; int bal;
                         try {
                                    String query = "SELECT balance FROM Balance WHERE acc_no='"+CardNo.cardno+"'";
                                    ResultSet rs=db.s.executeQuery(query);

                                    while (rs.next()) {
                                        res  = rs.getString("balance");
                              }

                        } catch (Exception e) {
                            System.out.println("SQL Exception: " + e.getMessage());
                        }
                        bal=parseInt(res);
                        bal-=inp;

                        try {
                                    String query = "UPDATE Balance SET balance = " + bal + " WHERE acc_no = '" + CardNo.cardno + "'";
                                    db.s.executeUpdate(query);
                                    JOptionPane.showMessageDialog(null, "Payment of Rs. "+st2+" done");
                        } catch (Exception e) {
                            System.out.println("SQL Exception: " + e.getMessage());
                        }
                        
                         try{
                                     String query = "INSERT INTO WaterBill VALUES ('" + CardNo.cardno + "','" + st1 + "','" + inp + "','" + timestamp+  "')";
                                    db.s.executeUpdate(query);
                        }
                        catch(Exception e){
                            System.out.println(e);
                        }
                     
                 }
                 
                 //elec
                 if(elecClicked){
                        try{
                                     String query = "INSERT INTO ElectricityBill VALUES ('" + CardNo.cardno + "','" + st1 + "','" + inp + "','" + timestamp+  "')";
                                    db.s.executeUpdate(query);
                        }
                        catch(Exception e){
                            System.out.println(e);
                        }
                        //update balance
                        String res = null; int bal;
                         try {
                                    String query = "SELECT balance FROM Balance WHERE acc_no='"+CardNo.cardno+"'";
                                    ResultSet rs=db.s.executeQuery(query);

                                    while (rs.next()) {
                                        res  = rs.getString("balance");
                              }

                        } catch (Exception e) {
                            System.out.println("SQL Exception: " + e.getMessage());
                        }
                        bal=parseInt(res);
                        bal-=inp;

                        try {
                                    String query = "UPDATE Balance SET balance = " + bal + " WHERE acc_no = '" + CardNo.cardno + "'";
                                    db.s.executeUpdate(query);
                                    JOptionPane.showMessageDialog(null, "Payment of Rs. "+st2+" done");
                        } catch (Exception e) {
                            System.out.println("SQL Exception: " + e.getMessage());
                        }

                 }
                 
                 
                 //gas
                 if(gasClicked){
                        try{
                                     String query = "INSERT INTO GasBill VALUES ('" + CardNo.cardno + "','" + st1 + "','" + inp + "','" + timestamp+  "')";
                                    db.s.executeUpdate(query);
                        }
                        catch(Exception e){
                            System.out.println(e);
                        }
                        
                        //update balance
                        String res = null; int bal;
                         try {
                                    String query = "SELECT balance FROM Balance WHERE acc_no='"+CardNo.cardno+"'";
                                    ResultSet rs=db.s.executeQuery(query);

                                    while (rs.next()) {
                                        res  = rs.getString("balance");
                              }

                        } catch (Exception e) {
                            System.out.println("SQL Exception: " + e.getMessage());
                        }
                        bal=parseInt(res);
                        bal-=inp;

                        try {
                                    String query = "UPDATE Balance SET balance = " + bal + " WHERE acc_no = '" + CardNo.cardno + "'";
                                    db.s.executeUpdate(query);
                                    JOptionPane.showMessageDialog(null, "Payment of Rs. "+st2+" done");
                        } catch (Exception e) {
                            System.out.println("SQL Exception: " + e.getMessage());
                        }

                 }
                 
                 
                 //net
                 if(netClicked){
                        try{
                                     String query = "INSERT INTO InternetBill VALUES ('" + CardNo.cardno + "','" + st1 + "','" + inp+ "','" + timestamp +  "')";
                                    db.s.executeUpdate(query);
                        }
                        catch(Exception e){
                            System.out.println(e);
                        }
                        
                        //update balance
                        String res = null; int bal;
                         try {
                                    String query = "SELECT balance FROM Balance WHERE acc_no='"+CardNo.cardno+"'";
                                    ResultSet rs=db.s.executeQuery(query);

                                    while (rs.next()) {
                                        res  = rs.getString("balance");
                              }

                        } catch (Exception e) {
                            System.out.println("SQL Exception: " + e.getMessage());
                        }
                        bal=parseInt(res);
                        bal-=inp;

                        try {
                                    String query = "UPDATE Balance SET balance = " + bal + " WHERE acc_no = '" + CardNo.cardno + "'";
                                    db.s.executeUpdate(query);
                                    JOptionPane.showMessageDialog(null, "Payment of Rs. "+st2+" done");
                        } catch (Exception e) {
                            System.out.println("SQL Exception: " + e.getMessage());
                        }

                 }
                }
                
                else{
                    JOptionPane.showMessageDialog(null,"Insufficient Funds!");
                }
                 
                 }
                     
                     
                     
            
           
        }
        
       
    

   

    
    public static void main(String[] args) {
        new Bills();
        
    }
}