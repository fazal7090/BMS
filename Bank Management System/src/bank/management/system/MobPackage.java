package bank.management.system;

 import java.awt.*;
import static java.awt.Font.BOLD;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.Date;
import java.sql.Timestamp;


public class MobPackage extends AddMoney implements ActionListener {
    String res = null; int bal;
    String n_balance=null; double n_bal=0;
    DataConnection db=new DataConnection(); 
    double balance;
    Font font6=new Font("Segoe UI", BOLD, 18);
     private JFrame frame5=new JFrame();
     private JFrame frame6=new JFrame();
    JPanel panel;
    JLabel MCS, quote, zongLBL1, zongLBL2, zongLBL3, zongLBL4, zongLBL5, zongLBL6, zongLBL7, zongLBL8, zongLBL9, jazzLBL, label4,
          ufoneLBL1, ufoneLBL2 , ufoneLBL3, ufoneLBL4, ufoneLBL5, ufoneLBL6, ufoneLBL7, ufoneLBL8, ufoneLBL9   ,
          teleLBL1, teleLBL2 , teleLBL3, teleLBL4, teleLBL5, teleLBL6, teleLBL7, teleLBL8, teleLBL9   ,
          jazzLBL1, jazzLBL2 , jazzLBL3, jazzLBL4, jazzLBL5, jazzLBL6, jazzLBL7, jazzLBL8, jazzLBL9, mobno   ;
    JTextField MOBNO1, MOBNO2, MOBNO3, MOBNO4, MOBNO5, MOBNO6, MOBNO7, MOBNO8, MOBNO9, MOBNO10, MOBNO11, MOBNO12;
    JButton back, zong, ufone, telenor, jazz, buy1, buy2, buy3, buy4, buy5, buy6, buy7, buy8, buy9, buy10, buy11, buy12, con1, con2
            , con3, con4, con5, con6, con7, con8, con9, con10, con11, con12, CON7, CON9;
    
    
    //for current date and time 
    Date currentDate = new Date();
    Timestamp timestamp = new Timestamp(currentDate.getTime());
    
    MobPackage(){ nframe.setVisible(false);
           //frame
        frame5.setSize(1366,768);
        frame5.setLocation(0,0); frame5.setLayout(null);
        frame5.setResizable(false);
        
        //panel
        panel=new JPanel();
        panel.setBounds(0,0,1366,80);
        String yellow="#EFCC00";
        panel.setBackground(Color.decode(yellow));
        panel.setLayout(null);
        frame5.add(panel);
        
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
        frame5.add(back);
        
        //zong button
         zong=new JButton("Zong");
         Font font2=new Font("Segoe UI", BOLD, 30);
        zong.setFont(font2);
        zong.setBounds(40,190,350,60);
        String c="#f0ecec";
        zong.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
//        telenor.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        zong.setBackground(Color.decode(c));
        zong.setForeground(Color.BLACK);
        zong.addActionListener(this);
        frame5.add(zong);
        
        //telenor button
         telenor=new JButton("Telenor");
        telenor.setFont(font2);
        telenor.setBounds(340,200,350,40);
        telenor.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        telenor.setBackground(Color.decode(c));
        telenor.setForeground(Color.BLACK);
        telenor.addActionListener(this);
        frame5.add(telenor);
        
         //jazz button
         jazz=new JButton("Jazz");
        jazz.setFont(font2);
        jazz.setBounds(745,205,150,30);
        jazz.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        jazz.setBackground(Color.decode(c));
        jazz.setForeground(Color.BLACK);
        jazz.addActionListener(this);
        frame5.add(jazz);
        
         //ufone button
         ufone=new JButton("Ufone");
        ufone.setFont(font2);
        ufone.setBounds(1037,200,150,40);
        ufone.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        ufone.setBackground(Color.decode(c));
        ufone.setForeground(Color.BLACK);
        ufone.addActionListener(this);
       frame5. add(ufone);
        
      //quote label
        quote=new JLabel("Unlock the power of communication with our mobile packages!");
        Font font3=new Font("Segoe UI", BOLD, 37);
        quote.setFont(font3);
        quote.setBounds(100,600,1200,50);
        quote.setForeground(Color.decode(yellow));
        frame5.add(quote); 
        
//      //zongLBL1 label
        zongLBL1=new JLabel(getOffer1()+"                                       Rs. "+getPrice1());
        Font font4=new Font("Segoe UI", BOLD, 20);
        zongLBL1.setFont(font4);
        zongLBL1.setBounds(170,270,1000,50);
        zongLBL1.setForeground(Color.BLACK);
        frame5.add(zongLBL1);
        
        //zongLBL2 label
        zongLBL2=new JLabel("30 Day Package");
        Font font5=new Font("Segoe UI", BOLD, 17);
        zongLBL2.setFont(font5);
        zongLBL2.setBounds(170,300,1000,50);
        zongLBL2.setForeground(Color.GREEN);
        frame5.add(zongLBL2);
        
        //zongLBL3 label
        zongLBL3=new JLabel("10 GB, 250 OFFNET, 5000 ONNET, 5000 SMS");
        zongLBL3.setFont(font5);
        zongLBL3.setBounds(170,330,400,50);
        frame5.add(zongLBL3);
        
        
        //buy1 button
         buy1=new JButton("Buy Now");
         
        buy1.setFont(font6);
        buy1.setBounds(580,340,120,30);
        buy1.setBackground(Color.decode(yellow));
        buy1.setForeground(Color.WHITE);
        buy1.addActionListener(this);
        frame5.add(buy1);
        
      //zongLBL4 label
        zongLBL4=new JLabel(getOffer2()+"                                  Rs. "+getPrice2());
        zongLBL4.setFont(font4);
        zongLBL4.setBounds(170,430,1000,50);
        zongLBL4.setForeground(Color.BLACK);
        frame5.add(zongLBL4);
        
        //zongLBL5 label
        zongLBL5=new JLabel("7 Day Package");
        zongLBL5.setFont(font5);
        zongLBL5.setBounds(170,460,1000,50);
        zongLBL5.setForeground(Color.GREEN);
        frame5.add(zongLBL5);
        
        //zongLBL6 label
        zongLBL6=new JLabel("30 GB, 180 OFFNET, 5000 ONNET, 5000 SMS");
        zongLBL6.setFont(font5);
        zongLBL6.setBounds(170,490,400,50);
        frame5.add(zongLBL6);
        
        
        //buy2 button
         buy2=new JButton("Buy Now");
        buy2.setFont(font6);
        buy2.setBounds(580,500,120,30);
        buy2.setBackground(Color.decode(yellow));
        buy2.setForeground(Color.WHITE);
        buy2.addActionListener(this);
        frame5.add(buy2);
        
      //zongLBL7 label
        zongLBL7=new JLabel(getOffer3()+"Weekly HLO                                                   Rs. "+getPrice3());
        zongLBL7.setFont(font4);
        zongLBL7.setBounds(170,590,1000,50);
        zongLBL7.setForeground(Color.BLACK);
        frame5.add(zongLBL7);
        
        //zongLBL8 label
        zongLBL8=new JLabel("7 Day Package");
        zongLBL8.setFont(font5);
        zongLBL8.setBounds(170,620,1000,50);
        zongLBL8.setForeground(Color.GREEN);
        frame5.add(zongLBL8);
        
        //zongLBL9 label
        zongLBL9=new JLabel("12 GB, 100 OFFNET, 5000 ONNET, 5000 SMS");
        zongLBL9.setFont(font5);
        zongLBL9.setBounds(170,650,400,50);
        frame5.add(zongLBL9);
        
        
        //buy3 button
         buy3=new JButton("Buy Now");
        buy3.setFont(font6);
        buy3.setBounds(580,660,120,30);
        buy3.setBackground(Color.decode(yellow));
        buy3.setForeground(Color.WHITE);
        buy3.addActionListener(this);
        frame5.add(buy3);
        
        zongLBL1.setVisible(false);
        zongLBL2.setVisible(false);
        zongLBL3.setVisible(false);
        zongLBL4.setVisible(false);
        zongLBL5.setVisible(false);
        zongLBL6.setVisible(false);
        zongLBL7.setVisible(false);
        zongLBL8.setVisible(false);
        zongLBL9.setVisible(false);
        buy1.setVisible(false);
        buy2.setVisible(false);
        buy3.setVisible(false);
        
      
       //ufoneLBL1 label
        ufoneLBL1=new JLabel(getOffer4()+"Super Card Gold                                    Rs. "+getPrice4());
        ufoneLBL1.setFont(font4);
        ufoneLBL1.setBounds(170,270,1000,50);
        ufoneLBL1.setForeground(Color.BLACK);
        frame5.add(ufoneLBL1);
        
        //ufoneLBL2 label
        ufoneLBL2=new JLabel("30 Day Package");
        ufoneLBL2.setFont(font5);
        ufoneLBL2.setBounds(170,300,1000,50);
        ufoneLBL2.setForeground(Color.GREEN);
        frame5.add(ufoneLBL2);
        
        //ufoneLBL3 label
        ufoneLBL3=new JLabel("24 GB, 600 OFFNET, 7500 ONNET, 5000 SMS");
        ufoneLBL3.setFont(font5);
        ufoneLBL3.setBounds(170,330,400,50);
        frame5.add(ufoneLBL3);
        
        
        //buy4 button
         buy4=new JButton("Buy Now");
        buy4.setFont(font6);
        buy4.setBounds(580,340,120,30);
        buy4.setBackground(Color.decode(yellow));
        buy4.setForeground(Color.WHITE);
        buy4.addActionListener(this);
        frame5.add(buy4);
        
      //ufoneLBL4 label
        ufoneLBL4=new JLabel(getOffer5()+"Super Card Max                                Rs. "+getPrice5());
        ufoneLBL4.setFont(font4);
        ufoneLBL4.setBounds(170,430,1000,50);
        ufoneLBL4.setForeground(Color.BLACK);
        frame5.add(ufoneLBL4);
        
        //ufoneLBL5 label
        ufoneLBL5=new JLabel("30 Day Package");
        ufoneLBL5.setFont(font5);
        ufoneLBL5.setBounds(170,460,1000,50);
        ufoneLBL5.setForeground(Color.GREEN);
        frame5.add(ufoneLBL5);
        
        ufoneLBL6=new JLabel("14 GB, 350 OFFNET, 5000 ONNET, 4500 SMS");
        ufoneLBL6.setFont(font5);
        ufoneLBL6.setBounds(170,490,400,50);
        frame5.add(ufoneLBL6);
        
        
        //buy5 button
         buy5=new JButton("Buy Now");
        buy5.setFont(font6);
        buy5.setBounds(580,500,120,30);
        buy5.setBackground(Color.decode(yellow));
        buy5.setForeground(Color.WHITE);
        buy5.addActionListener(this);
        frame5.add(buy5);
        
      //ufoneLBL7 label
        ufoneLBL7=new JLabel(getOffer6()+"                                                   Rs. "+getPrice6());
        ufoneLBL7.setFont(font4);
        ufoneLBL7.setBounds(170,590,1000,50);
        ufoneLBL7.setForeground(Color.BLACK);
        frame5.add(ufoneLBL7);
        
        //ufoneLBL8 label
        ufoneLBL8=new JLabel("7 Day Package");
        ufoneLBL8.setFont(font5);
        ufoneLBL8.setBounds(170,620,1000,50);
        ufoneLBL8.setForeground(Color.GREEN);
        frame5.add(ufoneLBL8);
        
        //ufoneLBL9 label
        ufoneLBL9=new JLabel("40 GB, 5000 ONNNET");
        ufoneLBL9.setFont(font5);
        ufoneLBL9.setBounds(170,650,400,50);
        frame5.add(ufoneLBL9);
        
        
        //buy6 button
         buy6=new JButton("Buy Now");
        buy6.setFont(font6);
        buy6.setBounds(580,660,120,30);
        buy6.setBackground(Color.decode(yellow));
        buy6.setForeground(Color.WHITE);
        buy6.addActionListener(this);
        frame5.add(buy6);
        
        ufoneLBL1.setVisible(false);
        ufoneLBL2.setVisible(false);
        ufoneLBL3.setVisible(false);
        ufoneLBL4.setVisible(false);
        ufoneLBL5.setVisible(false);
        ufoneLBL6.setVisible(false);
        ufoneLBL7.setVisible(false);
        ufoneLBL8.setVisible(false);
        ufoneLBL9.setVisible(false);
        buy4.setVisible(false);
        buy5.setVisible(false);
        buy6.setVisible(false);
        
       //teleLBL1 label
        teleLBL1=new JLabel(getOffer7()+"                                   Rs. "+getPrice7());
        teleLBL1.setFont(font4);
        teleLBL1.setBounds(170,270,1000,50);
        teleLBL1.setForeground(Color.BLACK);
        frame5.add(teleLBL1);
        
        //teleLBL2 label
        teleLBL2=new JLabel("7 Day Package");
        teleLBL2.setFont(font5);
        teleLBL2.setBounds(170,300,1000,50);
        teleLBL2.setForeground(Color.GREEN);
        frame5.add(teleLBL2);
        
        //teleLBL3 label
        teleLBL3=new JLabel("40 GB, 200 OFFNET, 7500 ONNET, 7500 SMS");
        teleLBL3.setFont(font5);
        teleLBL3.setBounds(170,330,400,50);
        frame5.add(teleLBL3);
        
        
        //buy7 button
         buy7=new JButton("Buy Now");
        buy7.setFont(font6);
        buy7.setBounds(580,340,120,30);
        buy7.setBackground(Color.decode(yellow));
        buy7.setForeground(Color.WHITE);
        buy7.addActionListener(this);
        frame5.add(buy7);
        
      //teleLBL4 label
        teleLBL4=new JLabel(getOffer8()+"                                Rs. "+getPrice8());
        teleLBL4.setFont(font4);
        teleLBL4.setBounds(170,430,1000,50);
        teleLBL4.setForeground(Color.BLACK);
        frame5.add(teleLBL4);
        
        //teleLBL5 label
        teleLBL5=new JLabel("30 Day Package");
        teleLBL5.setFont(font5);
        teleLBL5.setBounds(170,460,1000,50);
        teleLBL5.setForeground(Color.GREEN);
        frame5.add(teleLBL5);
        
        //teleLBL6 label
        teleLBL6=new JLabel("60 GB, 600 OFFNET, 7500 ONNET, 10000 SMS");
        teleLBL6.setFont(font5);
        teleLBL6.setBounds(170,490,400,50);
        frame5.add(teleLBL6);
        
        
        //buy8 button
         buy8=new JButton("Buy Now");
        buy8.setFont(font6);
        buy8.setBounds(580,500,120,30);
        buy8.setBackground(Color.decode(yellow));
        buy8.setForeground(Color.WHITE);
        buy8.addActionListener(this);
        frame5.add(buy8);
        
      //teleLBL7 label
        teleLBL7=new JLabel(getOffer9()+"                                                   Rs. "+getPrice9());
        teleLBL7.setFont(font4);
        teleLBL7.setBounds(170,590,1000,50);
        teleLBL7.setForeground(Color.BLACK);
        frame5.add(teleLBL7);
        
        //teleLBL8 label
        teleLBL8=new JLabel("7 Day Package");
        teleLBL8.setFont(font5);
        teleLBL8.setBounds(170,620,1000,50);
        teleLBL8.setForeground(Color.GREEN);
        frame5.add(teleLBL8);
        
        //teleLBL9 label
        teleLBL9=new JLabel("3 GB, 3000 ONNNET, 100 OFFNET, 1500 SMS");
        teleLBL9.setFont(font5);
        teleLBL9.setBounds(170,650,400,50);
        frame5.add(teleLBL9);
        
        
        //buy9 button
         buy9=new JButton("Buy Now");
        buy9.setFont(font6);
        buy9.setBounds(580,660,120,30);
        buy9.setBackground(Color.decode(yellow));
        buy9.setForeground(Color.WHITE);
        buy9.addActionListener(this);
        frame5.add(buy9);
        
        teleLBL1.setVisible(false);
        teleLBL2.setVisible(false);
        teleLBL3.setVisible(false);
        teleLBL4.setVisible(false);
        teleLBL5.setVisible(false);
        teleLBL6.setVisible(false);
        teleLBL7.setVisible(false);
        teleLBL8.setVisible(false);
        teleLBL9.setVisible(false);
        buy7.setVisible(false);
        buy8.setVisible(false);
        buy9.setVisible(false);
        
        
        
       //jazzLBL1 label
        jazzLBL1=new JLabel(getOffer10()+"                                    Rs. "+getPrice10());
        jazzLBL1.setFont(font4);
        jazzLBL1.setBounds(170,270,1000,50);
        jazzLBL1.setForeground(Color.BLACK);
        frame5.add(jazzLBL1);
        
        //jazzLBL2 label
        jazzLBL2=new JLabel("7 Day Package");
        jazzLBL2.setFont(font5);
        jazzLBL2.setBounds(170,300,1000,50);
        jazzLBL2.setForeground(Color.GREEN);
        frame5.add(jazzLBL2);
        
        //jazzLBL3 label
        jazzLBL3=new JLabel("12 GB, 5000 ONNET");
        jazzLBL3.setFont(font5);
        jazzLBL3.setBounds(170,330,400,50);
        frame5.add(jazzLBL3);
        
        
        //buy10 button
         buy10=new JButton("Buy Now");
        buy10.setFont(font6);
        buy10.setBounds(580,340,120,30);
        buy10.setBackground(Color.decode(yellow));
        buy10.setForeground(Color.WHITE);
        buy10.addActionListener(this);
        frame5.add(buy10);
        
      //jazzLBL4 label
        jazzLBL4=new JLabel(getOffer11()+"                                Rs. "+getPrice11());
        jazzLBL4.setFont(font4);
        jazzLBL4.setBounds(170,430,1000,50);
        jazzLBL4.setForeground(Color.BLACK);
        frame5.add(jazzLBL4);
        
        //jazzLBL5 label
        jazzLBL5=new JLabel("7 Day Package");
        jazzLBL5.setFont(font5);
        jazzLBL5.setBounds(170,460,1000,50);
        jazzLBL5.setForeground(Color.GREEN);
        frame5.add(jazzLBL5);
        
        //jazzLBL6 label
        jazzLBL6=new JLabel("10 GB, 100 OFFNET, 5000 ONNET, 5000 SMS");
        jazzLBL6.setFont(font5);
        jazzLBL6.setBounds(170,490,400,50);
        frame5.add(jazzLBL6);
        
        
        //buy11 button
         buy11=new JButton("Buy Now");
        buy11.setFont(font6);
        buy11.setBounds(580,500,120,30);
        buy11.setBackground(Color.decode(yellow));
        buy11.setForeground(Color.WHITE);
        buy11.addActionListener(this);
        frame5.add(buy11);
        
      //jazzLBL7 label
        jazzLBL7=new JLabel(getOffer12()+"                                                   Rs. "+getPrice12());
        jazzLBL7.setFont(font4);
        jazzLBL7.setBounds(170,590,1000,50);
        jazzLBL7.setForeground(Color.BLACK);
        frame5.add(jazzLBL7);
        
        //jazzLBL8 label
        jazzLBL8=new JLabel("30 Day Package");
        jazzLBL8.setFont(font5);
        jazzLBL8.setBounds(170,620,1000,50);
        jazzLBL8.setForeground(Color.GREEN);
        frame5.add(jazzLBL8);
        
        //jazzLBL9 label
        jazzLBL9=new JLabel("4 GB, 300 ONNNET, 40 OFFNET, 200 SMS");
        jazzLBL9.setFont(font5);
        jazzLBL9.setBounds(170,650,400,50);
        frame5.add(jazzLBL9);
        
        
        //buy12 button
         buy12=new JButton("Buy Now");
        buy12.setFont(font6);
        buy12.setBounds(580,660,120,30);
        buy12.setBackground(Color.decode(yellow));
        buy12.setForeground(Color.WHITE);
        buy12.addActionListener(this);
        frame5.add(buy12);
        
        
       jazzLBL1.setVisible(false);
        jazzLBL2.setVisible(false);
        jazzLBL3.setVisible(false);
        jazzLBL4.setVisible(false);
        jazzLBL5.setVisible(false);
        jazzLBL6.setVisible(false);
        jazzLBL7.setVisible(false);
        jazzLBL8.setVisible(false);
        jazzLBL9.setVisible(false);
        buy10.setVisible(false);
        buy11.setVisible(false);
        buy12.setVisible(false);
        
        
        
        
        
        //images
        
        //water bill image
        ImageIcon im=new ImageIcon(ClassLoader.getSystemResource("logo/zong.png"));
        Image i=im.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon IM=new ImageIcon(i);
        JLabel label = new JLabel(IM);
        label.setBounds(127,80,200,200);
       frame5. add(label);
        
        //elec image
        ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("logo/telenor.png"));
        Image i1=im1.getImage().getScaledInstance(75,70, Image.SCALE_DEFAULT);
        ImageIcon IM1=new ImageIcon(i1);
        JLabel label1 = new JLabel(IM1);
        label1.setBounds(475,127,75,70);
        frame5.add(label1);
        
        //gas image
        ImageIcon im2=new ImageIcon(ClassLoader.getSystemResource("logo/jazz.png"));
        Image i2=im2.getImage().getScaledInstance(180,115, Image.SCALE_DEFAULT);
        ImageIcon IM2=new ImageIcon(i2);
        JLabel label2 = new JLabel(IM2);
        label2.setBounds(738,103,180,115);
        frame5.add(label2);
        
        //net image
        ImageIcon im3=new ImageIcon(ClassLoader.getSystemResource("logo/ufone.png"));
        Image i3=im3.getImage().getScaledInstance(130,125, Image.SCALE_DEFAULT);
        ImageIcon IM3=new ImageIcon(i3);
        JLabel label3 = new JLabel(IM3);
        label3.setBounds(1052,105,130,125);
        frame5.add(label3);
        
        //intro image
        ImageIcon im4=new ImageIcon(ClassLoader.getSystemResource("logo/intro.png"));
        Image i4=im4.getImage().getScaledInstance(350,340, Image.SCALE_DEFAULT);
        ImageIcon IM4=new ImageIcon(i4);
        label4 = new JLabel(IM4);
        label4.setBounds(500,260,350,340);
        frame5.add(label4);
        
        //visible 
        frame5.setVisible(true);
        
        //buy now window
        frame6.setSize(400,170);
        frame6.setLocation(500,200); frame6.setLayout(null);
        frame6.setResizable(false);
        
        //mobno label
        mobno=new JLabel("Mobile Number:");
          Font font7=new Font("Segoe UI", BOLD, 15);
        mobno.setFont(font7);
        mobno.setBounds(10,10,130,50);
        mobno.setForeground(Color.BLACK);
        frame6.add(mobno);
        
         //MOBNO1 text field
            MOBNO1=new JTextField();
            MOBNO1.setBounds(150,23,170,25);
            frame6.add(MOBNO1);

            //con1 button
             con1=new JButton("Confirm");
            con1.setFont(font6);
            con1.setBounds(250,80,120,30);
            con1.setBackground(Color.decode(yellow));
            con1.setForeground(Color.WHITE);
            con1.addActionListener(this);
            frame6.add(con1);
        
        //MOBNO2 text field
            MOBNO2=new JTextField();
            MOBNO2.setBounds(150,23,170,25);
            frame6.add(MOBNO2);

            //con2 button
             con2=new JButton("Confirm");
            con2.setFont(font6);
            con2.setBounds(250,80,120,30);
            con2.setBackground(Color.decode(yellow));
            con2.setForeground(Color.WHITE);
            con2.addActionListener(this);
            frame6.add(con2);
        
        
            //MOBNO3 text field
            MOBNO3=new JTextField();
            MOBNO3.setBounds(150,23,170,25);
            frame6.add(MOBNO3);

            //con3 button
             con3=new JButton("Confirm");
            con3.setFont(font6);
            con3.setBounds(250,80,120,30);
            con3.setBackground(Color.decode(yellow));
            con3.setForeground(Color.WHITE);
            con3.addActionListener(this);
            frame6.add(con3);
            
             //MOBNO5 text field
            MOBNO5=new JTextField();
            MOBNO5.setBounds(150,23,170,25);
            frame6.add(MOBNO5);

            //con5 button
             con5=new JButton("Confirm");
            con5.setFont(font6);
            con5.setBounds(250,80,120,30);
            con5.setBackground(Color.decode(yellow));
            con5.setForeground(Color.WHITE);
            con5.addActionListener(this);
            frame6.add(con5);
            
            //MOBNO4 text field
            MOBNO4=new JTextField();
            MOBNO4.setBounds(150,23,170,25);
            frame6.add(MOBNO4);

            //con4 button
             con4=new JButton("Confirm");
            con4.setFont(font6);
            con4.setBounds(250,80,120,30);
            con4.setBackground(Color.decode(yellow));
            con4.setForeground(Color.WHITE);
            con4.addActionListener(this);
            frame6.add(con4);
            
           //MOBNO6 text field
            MOBNO6=new JTextField();
            MOBNO6.setBounds(150,23,170,25);
            frame6.add(MOBNO6);

            //confirm6 button
             con6=new JButton("Confirm");
            con6.setFont(font6);
            con6.setBounds(250,80,120,30);
            con6.setBackground(Color.decode(yellow));
            con6.setForeground(Color.WHITE);
            con6.addActionListener(this);
            frame6.add(con6);
        
            //MOBNO7 text field
            MOBNO7=new JTextField();
            MOBNO7.setBounds(150,23,170,25);
            frame6.add(MOBNO7);
              
            //CON7 Button
             CON7=new JButton("Confirm");
            CON7.setFont(font6);
            CON7.setBounds(250,80,120,30);
            CON7.setBackground(Color.decode(yellow));
            CON7.setForeground(Color.WHITE);
            CON7.addActionListener(this);
            frame6.add(CON7);
        
            //MOBNO8 text field
            MOBNO8=new JTextField();
            MOBNO8.setBounds(150,23,170,25);
            frame6.add(MOBNO8);

            //confirm8 button
             con8=new JButton("Confirm");
            con8.setFont(font6);
            con8.setBounds(250,80,120,30);
            con8.setBackground(Color.decode(yellow));
            con8.setForeground(Color.WHITE);
            con8.addActionListener(this);
            frame6.add(con8);
            
            
       //MOBNO9 text field
            MOBNO9=new JTextField();
            MOBNO9.setBounds(150,23,170,25);
            frame6.add(MOBNO9);

           //CON9 Button
             CON9=new JButton("Confirm");
            CON9.setFont(font6);
            CON9.setBounds(250,80,120,30);
            CON9.setBackground(Color.decode(yellow));
            CON9.setForeground(Color.WHITE);
            CON9.addActionListener(this);
            frame6.add(CON9);
        
            //MOBNO10 text field
            MOBNO10=new JTextField();
            MOBNO10.setBounds(150,23,170,25);
            frame6.add(MOBNO10);

            //confirm10 button
             con10=new JButton("Confirm");
            con10.setFont(font6);
            con10.setBounds(250,80,120,30);
            con10.setBackground(Color.decode(yellow));
            con10.setForeground(Color.WHITE);
            con10.addActionListener(this);
            frame6.add(con10);
        
            //MOBNO11 text field
            MOBNO11=new JTextField();
            MOBNO11.setBounds(150,23,170,25);
            frame6.add(MOBNO11);

            //confirm11 button
             con11=new JButton("Confirm");
            con11.setFont(font6);
            con11.setBounds(250,80,120,30);
            con11.setBackground(Color.decode(yellow));
            con11.setForeground(Color.WHITE);
            con11.addActionListener(this);
            frame6.add(con11);
            
             
            //MOBNO12 text field
            MOBNO12=new JTextField();
            MOBNO12.setBounds(150,23,170,25);
            frame6.add(MOBNO12);

            //confirm12 button
             con12=new JButton("Confirm");
            con12.setFont(font6);
            con12.setBounds(250,80,120,30);
            con12.setBackground(Color.decode(yellow));
            con12.setForeground(Color.WHITE);
            con12.addActionListener(this);
            frame6.add(con12);
        
    }
    
      //Action
    public void actionPerformed(ActionEvent ae){ 
        String n;
        
        //back action
        if(ae.getSource()==back) {
            frame5.setVisible(false);
            new Branchless();
         }
        
        //zong
        if(ae.getSource()==zong) {
            //minus balance
            
            
            //visible true
            zongLBL1.setVisible(true);
            zongLBL2.setVisible(true);
            zongLBL3.setVisible(true);
            zongLBL4.setVisible(true);
            zongLBL5.setVisible(true);
            zongLBL6.setVisible(true);
            zongLBL7.setVisible(true);
            zongLBL8.setVisible(true);
            zongLBL9.setVisible(true);
            buy1.setVisible(true);
            buy2.setVisible(true);
            buy3.setVisible(true);
            
            //visible false
            quote.setVisible(false);
            label4.setVisible(false);
            
             jazzLBL1.setVisible(false);
            jazzLBL2.setVisible(false);
            jazzLBL3.setVisible(false);
            jazzLBL4.setVisible(false);
            jazzLBL5.setVisible(false);
            jazzLBL6.setVisible(false);
            jazzLBL7.setVisible(false);
            jazzLBL8.setVisible(false);
            jazzLBL9.setVisible(false);
            buy10.setVisible(false);
            buy11.setVisible(false);
            buy12.setVisible(false);
            
            teleLBL1.setVisible(false);
            teleLBL2.setVisible(false);
            teleLBL3.setVisible(false);
            teleLBL4.setVisible(false);
            teleLBL5.setVisible(false);
            teleLBL6.setVisible(false);
            teleLBL7.setVisible(false);
            teleLBL8.setVisible(false);
            teleLBL9.setVisible(false);
            buy7.setVisible(false);
            buy8.setVisible(false);
            buy9.setVisible(false);
            
            ufoneLBL1.setVisible(false);
            ufoneLBL2.setVisible(false);
            ufoneLBL3.setVisible(false);
            ufoneLBL4.setVisible(false);
            ufoneLBL5.setVisible(false);
            ufoneLBL6.setVisible(false);
            ufoneLBL7.setVisible(false);
            ufoneLBL8.setVisible(false);
            ufoneLBL9.setVisible(false);
            buy4.setVisible(false);
            buy5.setVisible(false);
            buy6.setVisible(false);
         }
        //jazz
        if(ae.getSource()==jazz) {
            //visible true
            
             jazzLBL1.setVisible(true);
            jazzLBL2.setVisible(true);
            jazzLBL3.setVisible(true);
            jazzLBL4.setVisible(true);
            jazzLBL5.setVisible(true);
            jazzLBL6.setVisible(true);
            jazzLBL7.setVisible(true);
            jazzLBL8.setVisible(true);
            jazzLBL9.setVisible(true);
            buy10.setVisible(true);
            buy11.setVisible(true);
            buy12.setVisible(true);
            
            //visible false
            quote.setVisible(false);
            label4.setVisible(false);
            
            teleLBL1.setVisible(false);
            teleLBL2.setVisible(false);
            teleLBL3.setVisible(false);
            teleLBL4.setVisible(false);
            teleLBL5.setVisible(false);
            teleLBL6.setVisible(false);
            teleLBL7.setVisible(false);
            teleLBL8.setVisible(false);
            teleLBL9.setVisible(false);
            buy7.setVisible(false);
            buy8.setVisible(false);
            buy9.setVisible(false);
            
            ufoneLBL1.setVisible(false);
            ufoneLBL2.setVisible(false);
            ufoneLBL3.setVisible(false);
            ufoneLBL4.setVisible(false);
            ufoneLBL5.setVisible(false);
            ufoneLBL6.setVisible(false);
            ufoneLBL7.setVisible(false);
            ufoneLBL8.setVisible(false);
            ufoneLBL9.setVisible(false);
            buy4.setVisible(false);
            buy5.setVisible(false);
            buy6.setVisible(false);
            
             zongLBL1.setVisible(false);
            zongLBL2.setVisible(false);
            zongLBL3.setVisible(false);
            zongLBL4.setVisible(false);
            zongLBL5.setVisible(false);
            zongLBL6.setVisible(false);
            zongLBL7.setVisible(false);
            zongLBL8.setVisible(false);
            zongLBL9.setVisible(false);
            buy1.setVisible(false);
            buy2.setVisible(false);
            buy3.setVisible(false);
            
         }
        //telenor
        if(ae.getSource()==telenor) {
            //visible true
            teleLBL1.setVisible(true);
            teleLBL2.setVisible(true);
            teleLBL3.setVisible(true);
            teleLBL4.setVisible(true);
            teleLBL5.setVisible(true);
            teleLBL6.setVisible(true);
            teleLBL7.setVisible(true);
            teleLBL8.setVisible(true);
            teleLBL9.setVisible(true);
            buy7.setVisible(true);
            buy8.setVisible(true);
            buy9.setVisible(true);
            
            //visible false
            quote.setVisible(false);
            label4.setVisible(false);
            
             jazzLBL1.setVisible(false);
            jazzLBL2.setVisible(false);
            jazzLBL3.setVisible(false);
            jazzLBL4.setVisible(false);
            jazzLBL5.setVisible(false);
            jazzLBL6.setVisible(false);
            jazzLBL7.setVisible(false);
            jazzLBL8.setVisible(false);
            jazzLBL9.setVisible(false);
            buy10.setVisible(false);
            buy11.setVisible(false);
            buy12.setVisible(false);
            
            ufoneLBL1.setVisible(false);
            ufoneLBL2.setVisible(false);
            ufoneLBL3.setVisible(false);
            ufoneLBL4.setVisible(false);
            ufoneLBL5.setVisible(false);
            ufoneLBL6.setVisible(false);
            ufoneLBL7.setVisible(false);
            ufoneLBL8.setVisible(false);
            ufoneLBL9.setVisible(false);
            buy4.setVisible(false);
            buy5.setVisible(false);
            buy6.setVisible(false);
            
             zongLBL1.setVisible(false);
            zongLBL2.setVisible(false);
            zongLBL3.setVisible(false);
            zongLBL4.setVisible(false);
            zongLBL5.setVisible(false);
            zongLBL6.setVisible(false);
            zongLBL7.setVisible(false);
            zongLBL8.setVisible(false);
            zongLBL9.setVisible(false);
            buy1.setVisible(false);
            buy2.setVisible(false);
            buy3.setVisible(false);
            
         }
        
        //ufone
        if(ae.getSource()==ufone) {
            //visible true
            ufoneLBL1.setVisible(true);
            ufoneLBL2.setVisible(true);
            ufoneLBL3.setVisible(true);
            ufoneLBL4.setVisible(true);
            ufoneLBL5.setVisible(true);
            ufoneLBL6.setVisible(true);
            ufoneLBL7.setVisible(true);
            ufoneLBL8.setVisible(true);
            ufoneLBL9.setVisible(true);
            buy4.setVisible(true);
            buy5.setVisible(true);
            buy6.setVisible(true);
            
            //visible false
            quote.setVisible(false);
            label4.setVisible(false);
            
             jazzLBL1.setVisible(false);
            jazzLBL2.setVisible(false);
            jazzLBL3.setVisible(false);
            jazzLBL4.setVisible(false);
            jazzLBL5.setVisible(false);
            jazzLBL6.setVisible(false);
            jazzLBL7.setVisible(false);
            jazzLBL8.setVisible(false);
            jazzLBL9.setVisible(false);
            buy10.setVisible(false);
            buy11.setVisible(false);
            buy12.setVisible(false);
            
            teleLBL1.setVisible(false);
            teleLBL2.setVisible(false);
            teleLBL3.setVisible(false);
            teleLBL4.setVisible(false);
            teleLBL5.setVisible(false);
            teleLBL6.setVisible(false);
            teleLBL7.setVisible(false);
            teleLBL8.setVisible(false);
            teleLBL9.setVisible(false);
            buy7.setVisible(false);
            buy8.setVisible(false);
            buy9.setVisible(false);
            
             zongLBL1.setVisible(false);
            zongLBL2.setVisible(false);
            zongLBL3.setVisible(false);
            zongLBL4.setVisible(false);
            zongLBL5.setVisible(false);
            zongLBL6.setVisible(false);
            zongLBL7.setVisible(false);
            zongLBL8.setVisible(false);
            zongLBL9.setVisible(false);
            buy1.setVisible(false);
            buy2.setVisible(false);
            buy3.setVisible(false);
            
         }
        
        //buy1
        if(ae.getSource()==buy1){
            //visibility
            MOBNO1.setVisible(true);  
            MOBNO2.setVisible(false);  
            MOBNO3.setVisible(false);  
            MOBNO4.setVisible(false);  
            MOBNO5.setVisible(false);  
            MOBNO6.setVisible(false);  
            MOBNO7.setVisible(false);  
            MOBNO8.setVisible(false);  
            MOBNO9.setVisible(false);  
            MOBNO10.setVisible(false);  
            MOBNO11.setVisible(false);  
            MOBNO12.setVisible(false);
            
            
            con1.setVisible(true);
            con2.setVisible(false);
            con3.setVisible(false);
            con4.setVisible(false);
            con5.setVisible(false);
            con6.setVisible(false);
            CON7.setVisible(false);
            con8.setVisible(false);
            CON9.setVisible(false);
            con10.setVisible(false);
            con11.setVisible(false);
            con12.setVisible(false);
            
             //vis
            frame6.setVisible(true);
            
        }
        
        //buy2
        if(ae.getSource()==buy2){
            //visibility false
            MOBNO2.setVisible(true);  
            MOBNO1.setVisible(false);  
            MOBNO3.setVisible(false);  
            MOBNO4.setVisible(false);  
            MOBNO5.setVisible(false);  
            MOBNO6.setVisible(false);  
            MOBNO7.setVisible(false);  
            MOBNO8.setVisible(false);  
            MOBNO9.setVisible(false);  
            MOBNO10.setVisible(false);  
            MOBNO11.setVisible(false);  
            MOBNO12.setVisible(false);  
            
            con1.setVisible(false);
            con3.setVisible(false);
            con4.setVisible(false);
            con5.setVisible(false);
            con6.setVisible(false);
            CON7.setVisible(false);
            con8.setVisible(false);
            CON9.setVisible(false);
            con10.setVisible(false);
            con11.setVisible(false);
            con12.setVisible(false);
            con2.setVisible(true);
            
            
             //vis
            frame6.setVisible(true);
            
        }
        
        //buy3
        if(ae.getSource()==buy3){
            //visibility 
            MOBNO1.setVisible(false);  
            MOBNO2.setVisible(false);  
            MOBNO4.setVisible(false);  
            MOBNO5.setVisible(false);  
            MOBNO6.setVisible(false);  
            MOBNO7.setVisible(false);  
            MOBNO8.setVisible(false);  
            MOBNO9.setVisible(false);  
            MOBNO10.setVisible(false);  
            MOBNO11.setVisible(false);  
            MOBNO12.setVisible(false);  
            MOBNO3.setVisible(true);  
            
            con2.setVisible(false);
            con1.setVisible(false);
            con4.setVisible(false);
            con5.setVisible(false);
            con6.setVisible(false);
            CON7.setVisible(false);
            con8.setVisible(false);
            CON9.setVisible(false);
            con10.setVisible(false);
            con11.setVisible(false);
            con12.setVisible(false);
            con3.setVisible(true);
            
        
             //vis
            frame6.setVisible(true);
        }
        
        //buy5
        if(ae.getSource()==buy5){
            //visibility 
            MOBNO5.setVisible(true);  
            MOBNO1.setVisible(false);  
            MOBNO3.setVisible(false);  
            MOBNO4.setVisible(false);  
            MOBNO2.setVisible(false);  
            MOBNO6.setVisible(false);  
            MOBNO7.setVisible(false);  
            MOBNO8.setVisible(false);  
            MOBNO9.setVisible(false);  
            MOBNO10.setVisible(false);  
            MOBNO11.setVisible(false);  
            MOBNO12.setVisible(false);  
         
            con2.setVisible(false);
            con3.setVisible(false);
            con4.setVisible(false);
            con1.setVisible(false);
            con6.setVisible(false);
            CON7.setVisible(false);
            con8.setVisible(false);
            CON9.setVisible(false);
            con10.setVisible(false);
            con11.setVisible(false);
            con12.setVisible(false);
            con5.setVisible(true);
            
             //vis
            frame6.setVisible(true);
        }
        
        //buy4
        if(ae.getSource()==buy4){
            //visibility 
            MOBNO4.setVisible(true);  
            MOBNO1.setVisible(false);  
            MOBNO3.setVisible(false);  
            MOBNO2.setVisible(false);  
            MOBNO5.setVisible(false);  
            MOBNO6.setVisible(false);  
            MOBNO7.setVisible(false);  
            MOBNO8.setVisible(false);  
            MOBNO9.setVisible(false);  
            MOBNO10.setVisible(false);  
            MOBNO11.setVisible(false);  
            MOBNO12.setVisible(false);  
          
        con2.setVisible(false);
            con3.setVisible(false);
            con4.setVisible(true);
            con5.setVisible(false);
            con1.setVisible(false);
            CON7.setVisible(false);
            con8.setVisible(false);
            CON9.setVisible(false);
            con10.setVisible(false);
            con11.setVisible(false);
            con12.setVisible(false);
            con6.setVisible(false);
            
             //vis
            frame6.setVisible(true);
        }
        
        //buy6
        if(ae.getSource()==buy6){
            //visibility 
            MOBNO6.setVisible(true);  
            MOBNO1.setVisible(false);  
            MOBNO3.setVisible(false);  
            MOBNO4.setVisible(false);  
            MOBNO5.setVisible(false);  
            MOBNO2.setVisible(false);  
            MOBNO7.setVisible(false);  
            MOBNO8.setVisible(false);  
            MOBNO9.setVisible(false);  
            MOBNO10.setVisible(false);  
            MOBNO11.setVisible(false);  
            MOBNO12.setVisible(false);  
            
        con2.setVisible(false);
            con3.setVisible(false);
            con4.setVisible(false);
            con5.setVisible(false);
            con1.setVisible(false);
            CON7.setVisible(false);
            con8.setVisible(false);
            CON9.setVisible(false);
            con10.setVisible(false);
            con11.setVisible(false);
            con12.setVisible(false);
            con6.setVisible(true);
            
             //vis
            frame6.setVisible(true);
        }
        
        //buy7
        if(ae.getSource()==buy7){
            //visibility 
            MOBNO6.setVisible(false);  
            MOBNO1.setVisible(false);  
            MOBNO3.setVisible(false);  
            MOBNO4.setVisible(false);  
            MOBNO5.setVisible(false);  
            MOBNO2.setVisible(false);  
            MOBNO7.setVisible(true);  
            MOBNO8.setVisible(false);  
            MOBNO9.setVisible(false);  
            MOBNO10.setVisible(false);  
            MOBNO11.setVisible(false);  
            MOBNO12.setVisible(false);  
            
        con2.setVisible(false);
            con3.setVisible(false);
            con4.setVisible(false);
            con5.setVisible(false);
            con1.setVisible(false);
            CON7.setVisible(true);
            con8.setVisible(false);
            CON9.setVisible(false);
            con10.setVisible(false);
            con11.setVisible(false);
            con12.setVisible(false);
            con6.setVisible(false);
            
             //vis
            frame6.setVisible(true);
        }
        
        //buy8
        if(ae.getSource()==buy8){
            
            //visibility 
            MOBNO8.setVisible(true);  
            MOBNO1.setVisible(false);  
            MOBNO3.setVisible(false);  
            MOBNO4.setVisible(false);  
            MOBNO5.setVisible(false);  
            MOBNO6.setVisible(false);  
            MOBNO7.setVisible(false);  
            MOBNO2.setVisible(false);  
            MOBNO9.setVisible(false);  
            MOBNO10.setVisible(false);  
            MOBNO11.setVisible(false);  
            MOBNO12.setVisible(false);  
           
        con2.setVisible(false);
            con3.setVisible(false);
            con4.setVisible(false);
            con5.setVisible(false);
            con6.setVisible(false);
            CON7.setVisible(false);
            con1.setVisible(false);
            CON9.setVisible(false);
            con10.setVisible(false);
            con11.setVisible(false);
            con12.setVisible(false);
            con8.setVisible(true);
            
             //vis
            frame6.setVisible(true);
        }
       
        //buy9
        if(ae.getSource()==buy9){
            
            //visibility 
            MOBNO9.setVisible(true);  
            MOBNO1.setVisible(false);  
            MOBNO3.setVisible(false);  
            MOBNO4.setVisible(false);  
            MOBNO5.setVisible(false);  
            MOBNO6.setVisible(false);  
            MOBNO7.setVisible(false);  
            MOBNO2.setVisible(false);  
            MOBNO8.setVisible(true);  
            MOBNO10.setVisible(false);  
            MOBNO11.setVisible(false);  
            MOBNO12.setVisible(false);  
           
        con2.setVisible(false);
            con3.setVisible(false);
            con4.setVisible(false);
            con5.setVisible(false);
            con6.setVisible(false);
            CON7.setVisible(false);
            con1.setVisible(false);
            CON9.setVisible(true);
            con10.setVisible(false);
            con11.setVisible(false);
            con12.setVisible(false);
            con8.setVisible(false);
            
             //vis
            frame6.setVisible(true);
        }
       
        
        
        //buy10
        if(ae.getSource()==buy10){
            //visibility 
            MOBNO10.setVisible(true);  
            MOBNO1.setVisible(false);  
            MOBNO3.setVisible(false);  
            MOBNO4.setVisible(false);  
            MOBNO5.setVisible(false);  
            MOBNO6.setVisible(false);  
            MOBNO7.setVisible(false);  
            MOBNO8.setVisible(false);  
            MOBNO9.setVisible(false);  
            MOBNO2.setVisible(false);  
            MOBNO11.setVisible(false);  
            MOBNO12.setVisible(false);  
            
            con2.setVisible(false);
            con3.setVisible(false);
            con4.setVisible(false);
            con5.setVisible(false);
            con6.setVisible(false);
            CON7.setVisible(false);
            con8.setVisible(false);
            CON9.setVisible(false);
            con1.setVisible(false);
            con11.setVisible(false);
            con12.setVisible(false);
            con10.setVisible(true);
            
             //vis
            frame6.setVisible(true);
        }
        
        //buy11
        if(ae.getSource()==buy11){
            //visibility 
            MOBNO11.setVisible(true);  
            MOBNO1.setVisible(false);  
            MOBNO3.setVisible(false);  
            MOBNO4.setVisible(false);  
            MOBNO5.setVisible(false);  
            MOBNO6.setVisible(false);  
            MOBNO7.setVisible(false);  
            MOBNO8.setVisible(false);  
            MOBNO9.setVisible(false);  
            MOBNO10.setVisible(false);  
            MOBNO2.setVisible(false);  
            MOBNO12.setVisible(false);  
            
            con2.setVisible(false);
            con3.setVisible(false);
            con4.setVisible(false);
            con5.setVisible(false);
            con6.setVisible(false);
            CON7.setVisible(false);
            con8.setVisible(false);
            CON9.setVisible(false);
            con10.setVisible(false);
            con1.setVisible(false);
            con12.setVisible(false);
            con11.setVisible(true);
        
             //vis
            frame6.setVisible(true);
        }
        
        //buy12
        if(ae.getSource()==buy12){
            //visibility 
            MOBNO12.setVisible(true);  
            MOBNO1.setVisible(false);  
            MOBNO3.setVisible(false);  
            MOBNO4.setVisible(false);  
            MOBNO5.setVisible(false);  
            MOBNO6.setVisible(false);  
            MOBNO7.setVisible(false);  
            MOBNO8.setVisible(false);  
            MOBNO9.setVisible(false);  
            MOBNO10.setVisible(false);  
            MOBNO11.setVisible(false);  
            MOBNO2.setVisible(false);  
           
            con2.setVisible(false);
            con3.setVisible(false);
            con4.setVisible(false);
            con5.setVisible(false);
            con6.setVisible(false);
            CON7.setVisible(false);
            con8.setVisible(false);
            CON9.setVisible(false);
            con10.setVisible(false);
            con11.setVisible(false);
            con1.setVisible(false);
            con12.setVisible(true);
            
             //vis
            frame6.setVisible(true);
        }
        
        //con1
        if(ae.getSource()==con1){ 
           n=MOBNO1.getText();
           
           //validation
           if(n.length()!=11){
               if(n.length()<11){
                   JOptionPane.showMessageDialog(null,"Incomplete phone number!");
               }
               if(n.length()>11){
                   JOptionPane.showMessageDialog(null,"Invalid phone number!");
               }
           }
           
           //check if current balance is sufficient for buying this package, if yes then execute
            try {
                    String query = "select balance  FROM balance WHERE acc_no = '" + CardNo.cardno + "'";
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
            
            //make the purchase
           if(n.length()==11 && n_bal>=getPrice1()){
               try{
                   String query = "INSERT INTO MobPackage VALUES ('" + CardNo.cardno + "','Zong: " + getOffer1() + "','" + getPrice1() + "','" + n + "','" + timestamp + "')";

                   db.s.executeUpdate(query);
               }
               catch(Exception e){
                   System.out.println("Error: "+e);
               }
                JOptionPane.showMessageDialog(null, "Rs. "+getPrice1()+" package transferred to "+n);
                
                 //update balance
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
                bal-=getPrice1();
                
                try {
                            String query = "UPDATE Balance SET balance = " + bal + " WHERE acc_no = '" + CardNo.cardno + "'";
                            db.s.executeUpdate(query);
                } catch (Exception e) {
                    System.out.println("SQL Exception: " + e.getMessage());
                }
                
                
           }
           else if(n_bal<getPrice1()){
               JOptionPane.showMessageDialog(null, "Insufficient Funds!");
           }
           
        }
        
        //con2
        if(ae.getSource()==con2){
           n=MOBNO2.getText();
           
           //validation
           if(n.length()!=11){
                if(n.length()>11){
               JOptionPane.showMessageDialog(null,"Invalid phone number!");
           }
                if(n.length()<11)
               JOptionPane.showMessageDialog(null,"Incomplete phone number!");
           }
          
          //check if current balance is sufficient for buying this package, if yes then execute
            try {
                    String query = "select balance  FROM balance WHERE acc_no = '" + CardNo.cardno + "'";
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
            
            //make the purchase
           if(n.length()==11 && n_bal>=getPrice2()){
               try{
                   String query = "INSERT INTO MobPackage VALUES ('" + CardNo.cardno + "','Zong: " + getOffer2() + "','" + getPrice2() + "','" + n + "','" + timestamp + "')";

                   db.s.executeUpdate(query);
               }
               catch(Exception e){
                   System.out.println("Error: "+e);
               }
                JOptionPane.showMessageDialog(null, "Rs. "+getPrice2()+" package transferred to "+n);
                
                //update balance
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
                bal-=getPrice2();
                
                try {
                            String query = "UPDATE Balance SET balance = " + bal + " WHERE acc_no = '" + CardNo.cardno + "'";
                            db.s.executeUpdate(query);
                } catch (Exception e) {
                    System.out.println("SQL Exception: " + e.getMessage());
                }
           }
           else if(n_bal<getPrice2()){
               JOptionPane.showMessageDialog(null, "Insufficient Funds!");
           }
        }
        
        //con3
        if(ae.getSource()==con3){
           n=MOBNO3.getText();
           
            //validation
           if(n.length()!=11){
                if(n.length()>11){
               JOptionPane.showMessageDialog(null,"Invalid phone number!");
           }
                if(n.length()<11)
               JOptionPane.showMessageDialog(null,"Incomplete phone number!");
           }
           
           //check if current balance is sufficient for buying this package, if yes then execute
            try {
                    String query = "select balance  FROM balance WHERE acc_no = '" + CardNo.cardno + "'";
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
            
            //make the purchase
           if(n.length()==11 && n_bal>=getPrice3()){
               try{
                   String query = "INSERT INTO MobPackage VALUES ('" + CardNo.cardno + "','Zong: " + getOffer3() + "','" + getPrice3() + "','" + n + "','" + timestamp + "')";

                   db.s.executeUpdate(query);
               }
               catch(Exception e){
                   System.out.println("Error: "+e);
               }
                JOptionPane.showMessageDialog(null, "Rs. "+getPrice3()+" package transferred to "+n);
                
                
                //update balance
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
                bal-=getPrice3();
                
                try {
                            String query = "UPDATE Balance SET balance = " + bal + " WHERE acc_no = '" + CardNo.cardno + "'";
                            db.s.executeUpdate(query);
                } catch (Exception e) {
                    System.out.println("SQL Exception: " + e.getMessage());
                }
           }
           else if(n_bal<getPrice3()){
               JOptionPane.showMessageDialog(null, "Insufficient Funds!");
           }
        }
        
        //con4
        if(ae.getSource()==con4){ 
           n=MOBNO4.getText();
           
            //validation
           if(n.length()!=11){
                if(n.length()>11){
               JOptionPane.showMessageDialog(null,"Invalid phone number!");
           }
                if(n.length()<11)
               JOptionPane.showMessageDialog(null,"Incomplete phone number!");
           }
           
          //check if current balance is sufficient for buying this package, if yes then execute
            try {
                     String query = "select balance  FROM balance WHERE acc_no = '" + CardNo.cardno + "'";
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
            
            //make the purchase
           if(n.length()==11 && n_bal>=getPrice4()){
               try{
                   String query = "INSERT INTO MobPackage VALUES ('" + CardNo.cardno + "','Zong: " + getOffer4() + "','" + getPrice4() + "','" + n + "','" + timestamp + "')";

                   db.s.executeUpdate(query);
               }
               catch(Exception e){
                   System.out.println("Error: "+e);
               }
                JOptionPane.showMessageDialog(null, "Rs. "+getPrice4()+" package transferred to "+n);
                //update balance
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
                bal-=getPrice4();
                
                try {
                            String query = "UPDATE Balance SET balance = " + bal + " WHERE acc_no = '" + CardNo.cardno + "'";
                            db.s.executeUpdate(query);
                } catch (Exception e) {
                    System.out.println("SQL Exception: " + e.getMessage());
                };
           }
           else if(n_bal<getPrice4()){
               JOptionPane.showMessageDialog(null, "Insufficient Funds!");
           }
        }
        
        //con5
        if(ae.getSource()==con5){
           n=MOBNO5.getText();
           
            //validation
           if(n.length()!=11){
                if(n.length()>11){
               JOptionPane.showMessageDialog(null,"Invalid phone number!");
           }
                if(n.length()<11)
               JOptionPane.showMessageDialog(null,"Incomplete phone number!");
           }
           //check if current balance is sufficient for buying this package, if yes then execute
            try {
                     String query = "select balance  FROM balance WHERE acc_no = '" +CardNo.cardno + "'";
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
            
            //make the purchase
           if(n.length()==11 && n_bal>=getPrice5()){
               try{
                   String query = "INSERT INTO MobPackage VALUES ('" + CardNo.cardno + "','Zong: " + getOffer5() + "','" + getPrice5() + "','" + n + "','" + timestamp + "')";

                   db.s.executeUpdate(query);
               }
               catch(Exception e){
                   System.out.println("Error: "+e);
               }
                JOptionPane.showMessageDialog(null, "Rs. "+getPrice5()+" package transferred to "+n);
               //update balance
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
                bal-=getPrice5();
                
                try {
                            String query = "UPDATE Balance SET balance = " + bal + " WHERE acc_no = '" + CardNo.cardno + "'";
                            db.s.executeUpdate(query);
                } catch (Exception e) {
                    System.out.println("SQL Exception: " + e.getMessage());
                }
           }
           else if(n_bal<getPrice5()){
               JOptionPane.showMessageDialog(null, "Insufficient Funds!");
           }
        }
        
        //con6
        if(ae.getSource()==con6){
           n=MOBNO6.getText();
           
           //validation
           if(n.length()!=11){
                if(n.length()>11){
               JOptionPane.showMessageDialog(null,"Invalid phone number!");
           }
                if(n.length()<11)
               JOptionPane.showMessageDialog(null,"Incomplete phone number!");
           }
           
          //check if current balance is sufficient for buying this package, if yes then execute
            try {
                     String query = "select balance  FROM balance WHERE acc_no = '" + CardNo.cardno + "'";
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
            
            //make the purchase
           if(n.length()==11 && n_bal>=getPrice6()){
               try{
                   String query = "INSERT INTO MobPackage VALUES ('" + CardNo.cardno+ "','Zong: " + getOffer6() + "','" + getPrice6() + "','" + n + "','" + timestamp + "')";

                   db.s.executeUpdate(query);
               }
               catch(Exception e){
                   System.out.println("Error: "+e);
               }
                JOptionPane.showMessageDialog(null, "Rs. "+getPrice6()+" package transferred to "+n);
                //update balance
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
                bal-=getPrice6();
                
                try {
                            String query = "UPDATE Balance SET balance = " + bal + " WHERE acc_no = '" + CardNo.cardno + "'";
                            db.s.executeUpdate(query);
                } catch (Exception e) {
                    System.out.println("SQL Exception: " + e.getMessage());
                }
           }
           else if(n_bal<getPrice6()){
               JOptionPane.showMessageDialog(null, "Insufficient Funds!");
           }
        }
     
        
        //con7
        if(ae.getSource()==CON7){ System.out.println("ja");
           n=MOBNO7.getText();
           
            //validation
           if(n.length()!=11){
                if(n.length()>11){
               JOptionPane.showMessageDialog(null,"Invalid phone number!");
           }
                if(n.length()<11)
               JOptionPane.showMessageDialog(null,"Incomplete phone number!");
           }
           
           //check if current balance is sufficient for buying this package, if yes then execute
            try {
                     String query = "select balance  FROM balance WHERE acc_no = '" + CardNo.cardno + "'";
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
            
            //make the purchase
           if(n.length()==11 && n_bal>=getPrice7()){
               try{
                   String query = "INSERT INTO MobPackage VALUES ('" + CardNo.cardno + "','Zong: " + getOffer7() + "','" + getPrice7() + "','" + n + "','" + timestamp + "')";

                   db.s.executeUpdate(query);
               }
               catch(Exception e){
                   System.out.println("Error: "+e);
               }
                JOptionPane.showMessageDialog(null, "Rs. "+getPrice7()+" package transferred to "+n);
               //update balance
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
                bal-=getPrice7();
                
                try {
                            String query = "UPDATE Balance SET balance = " + bal + " WHERE acc_no = '" + CardNo.cardno + "'";
                            db.s.executeUpdate(query);
                } catch (Exception e) {
                    System.out.println("SQL Exception: " + e.getMessage());
                }
           }
           else if(n_bal<getPrice7()){
               JOptionPane.showMessageDialog(null, "Insufficient Funds!");
           }
        }
        
        //con8
        if(ae.getSource()==con8){
           n=MOBNO8.getText();
           
            //validation
           if(n.length()!=11){
                if(n.length()>11){
               JOptionPane.showMessageDialog(null,"Invalid phone number!");
           }
                if(n.length()<11)
               JOptionPane.showMessageDialog(null,"Incomplete phone number!");
           }
           
          //check if current balance is sufficient for buying this package, if yes then execute
            try {
                     String query = "select balance  FROM balance WHERE acc_no = '" + CardNo.cardno + "'";
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
            
            //make the purchase
           if(n.length()==11 && n_bal>=getPrice8()){
               try{
                   String query = "INSERT INTO MobPackage VALUES ('" + CardNo.cardno + "','Zong: " + getOffer8() + "','" + getPrice8() + "','" + n + "','" + timestamp + "')";

                   db.s.executeUpdate(query);
               }
               catch(Exception e){
                   System.out.println("Error: "+e);
               }
                JOptionPane.showMessageDialog(null, "Rs. "+getPrice8()+" package transferred to "+n);
                //update balance
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
                bal-=getPrice8();
                
                try {
                            String query = "UPDATE Balance SET balance = " + bal + " WHERE acc_no = '" + CardNo.cardno + "'";
                            db.s.executeUpdate(query);
                } catch (Exception e) {
                    System.out.println("SQL Exception: " + e.getMessage());
                }
           }
           else if(n_bal<getPrice8()){
               JOptionPane.showMessageDialog(null, "Insufficient Funds!");
           }
        }
        
        //con9
        if(ae.getSource()==CON9){
           n=MOBNO9.getText();
           
            //validation
           if(n.length()!=11){
                if(n.length()>11){
               JOptionPane.showMessageDialog(null,"Invalid phone number!");
           }
                if(n.length()<11)
               JOptionPane.showMessageDialog(null,"Incomplete phone number!");
           }
           //check if current balance is sufficient for buying this package, if yes then execute
            try {
                     String query = "select balance  FROM balance WHERE acc_no = '" + CardNo.cardno + "'";
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
            
            //make the purchase
           if(n.length()==11 && n_bal>=getPrice9()){
               try{
                   String query = "INSERT INTO MobPackage VALUES ('" + CardNo.cardno + "','Zong: " + getOffer9() + "','" + getPrice9() + "','" + n + "','" + timestamp + "')";

                   db.s.executeUpdate(query);
               }
               catch(Exception e){
                   System.out.println("Error: "+e);
               }
                JOptionPane.showMessageDialog(null, "Rs. "+getPrice9()+" package transferred to "+n);
                //update balance
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
                bal-=getPrice9();
                
                try {
                            String query = "UPDATE Balance SET balance = " + bal + " WHERE acc_no = '" + CardNo.cardno+ "'";
                            db.s.executeUpdate(query);
                } catch (Exception e) {
                    System.out.println("SQL Exception: " + e.getMessage());
                }
           }
           else if(n_bal<getPrice9()){
               JOptionPane.showMessageDialog(null, "Insufficient Funds!");
           }
        }
       
        
        //con10
        if(ae.getSource()==con10){
           n=MOBNO10.getText();
           
            //validation
           if(n.length()!=11){
                if(n.length()>11){
               JOptionPane.showMessageDialog(null,"Invalid phone number!");
           }
                if(n.length()<11)
               JOptionPane.showMessageDialog(null,"Incomplete phone number!");
           }
           //check if current balance is sufficient for buying this package, if yes then execute
            try {
                     String query = "select balance  FROM balance WHERE acc_no = '" + CardNo.cardno + "'";
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
            
            //make the purchase
           if(n.length()==11 && n_bal>=getPrice10()){
               try{
                   String query = "INSERT INTO MobPackage VALUES ('" + CardNo.cardno + "','Zong: " + getOffer10() + "','" + getPrice10() + "','" + n + "','" + timestamp + "')";

                   db.s.executeUpdate(query);
               }
               catch(Exception e){
                   System.out.println("Error: "+e);
               }
                JOptionPane.showMessageDialog(null, "Rs. "+getPrice10()+" package transferred to "+n);
              //update balance
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
                bal-=getPrice10();
                
                try {
                            String query = "UPDATE Balance SET balance = " + bal + " WHERE acc_no = '" + CardNo.cardno + "'";
                            db.s.executeUpdate(query);
                } catch (Exception e) {
                    System.out.println("SQL Exception: " + e.getMessage());
                }
           }
           else if(n_bal<getPrice10()){
               JOptionPane.showMessageDialog(null, "Insufficient Funds!");
           }
        }
        
        //con11
        if(ae.getSource()==con11){
           n=MOBNO11.getText();
           
           //validation
           if(n.length()!=11){
                if(n.length()>11){
               JOptionPane.showMessageDialog(null,"Invalid phone number!");
           }
                if(n.length()<11)
               JOptionPane.showMessageDialog(null,"Incomplete phone number!");
           }
           //check if current balance is sufficient for buying this package, if yes then execute
            try {
                   String query = "select balance  FROM balance WHERE acc_no = '" + CardNo.cardno + "'";
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
            
            //make the purchase
           if(n.length()==11 && n_bal>=getPrice11()){
               try{
                   String query = "INSERT INTO MobPackage VALUES ('" + CardNo.cardno + "','Zong: " + getOffer11() + "','" + getPrice11() + "','" + n + "','" + timestamp + "')";

                   db.s.executeUpdate(query);
               }
               catch(Exception e){
                   System.out.println("Error: "+e);
               }
                JOptionPane.showMessageDialog(null, "Rs. "+getPrice11()+" package transferred to "+n);
                //update balance
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
                bal-=getPrice11();
                
                try {
                            String query = "UPDATE Balance SET balance = " + bal + " WHERE acc_no = '" +CardNo.cardno + "'";
                            db.s.executeUpdate(query);
                } catch (Exception e) {
                    System.out.println("SQL Exception: " + e.getMessage());
                }
           }
           else if(n_bal<getPrice11()){
               JOptionPane.showMessageDialog(null, "Insufficient Funds!");
           }
        }
        
        //con12
        if(ae.getSource()==con12){
           n=MOBNO12.getText();
           
          //validation
           if(n.length()!=11){
                if(n.length()>11){
               JOptionPane.showMessageDialog(null,"Invalid phone number!");
           }
                if(n.length()<11)
               JOptionPane.showMessageDialog(null,"Incomplete phone number!");
           }
           //check if current balance is sufficient for buying this package, if yes then execute
            try {
                    String query = "select balance  FROM balance WHERE acc_no = '" + CardNo.cardno + "'";
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
            
            //make the purchase
           if(n.length()==11 && n_bal>=getPrice12()){
               try{
                   String query = "INSERT INTO MobPackage VALUES ('" + CardNo.cardno + "','Zong: " + getOffer12() + "','" + getPrice12() + "','" + n + "','" + timestamp + "')";

                   db.s.executeUpdate(query);
               }
               catch(Exception e){
                   System.out.println("Error: "+e);
               }
                JOptionPane.showMessageDialog(null, "Rs. "+getPrice12()+" package transferred to "+n);
                //update balance
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
                bal-=getPrice12();
                
                try {
                            String query = "UPDATE Balance SET balance = " + bal + " WHERE acc_no = '" + CardNo.cardno + "'";
                            db.s.executeUpdate(query);
                } catch (Exception e) {
                    System.out.println("SQL Exception: " + e.getMessage());
                }
           }
           else if(n_bal<getPrice12()){
               JOptionPane.showMessageDialog(null, "Insufficient Funds!");
           }
        }
        
        
    }
    public static void main(String[] args) {
        new MobPackage();
    }
}