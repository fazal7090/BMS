package bank.management.system;
import java.awt.*;
import static java.awt.Font.BOLD;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;

public class Branchless extends JFrame implements ActionListener{
    JPanel panel;
    JLabel MCS;
    JButton back, bills, mobile_package;
    
    Branchless(){
          //frame
        setSize(1366,768);
        setLocation(0,0); setLayout(null);
        setResizable(false);
        
        //panel
        panel=new JPanel();
        panel.setBounds(0,0,1366,80);
        String yellow="#EFCC00";
        panel.setBackground(Color.decode(yellow));
        panel.setLayout(null);
        add(panel);
        
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
        add(back);
        
        //bills button
         bills=new JButton("Utility Bills");
        Font font2=new Font("Segoe UI", BOLD, 40);
        bills.setFont(font2);
        bills.setBounds(320,520,220,60);
        String c="#f0ecec";
        bills.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        bills.setBackground(Color.decode(c));
        bills.setForeground(Color.BLACK);
        bills.addActionListener(this);
        add(bills);
        
        //mobile_package button
         mobile_package=new JButton("Mobile Packages");
        mobile_package.setFont(font2);
        mobile_package.setBounds(720,520,350,60);
        mobile_package.setBorder(BorderFactory.createLineBorder(Color.decode(c)));
        mobile_package.setBackground(Color.decode(c));
        mobile_package.setForeground(Color.BLACK);
        mobile_package.addActionListener(this);
        add(mobile_package);
        
         //images
        
        //bill image
        ImageIcon im=new ImageIcon(ClassLoader.getSystemResource("logo/bill.png"));
        Image i=im.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
        ImageIcon IM=new ImageIcon(i);
        JLabel label = new JLabel(IM);
        label.setBounds(280,230,250,250);
        add(label);
        
        //mob package image
        ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("logo/mobile.png"));
        Image i1=im1.getImage().getScaledInstance(320,310, Image.SCALE_DEFAULT);
        ImageIcon IM1=new ImageIcon(i1);
        JLabel label1 = new JLabel(IM1);
        label1.setBounds(735,200,320,310);
        add(label1);
        
        
        
        //view
        setVisible(true);
    }
    
        
     //Action
    public void actionPerformed(ActionEvent ae){ 
        //back action
        if(ae.getSource()==back) {
            setVisible(false);
            new Facilities();
         }
        
        //utility bills action
        if(ae.getSource()==bills) {
            setVisible(false);
            new Bills();
         }
        
        //mobile packages action
        if(ae.getSource()==mobile_package) {
            setVisible(false);
            new MobPackage();
         }
        
        
    }
    public static void main(String[] args) {
        new Branchless();
        
    }
}
