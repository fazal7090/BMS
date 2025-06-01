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
import java.sql.*;

public class AccountDetails extends JFrame implements ActionListener {
     JPanel panel;
    JComboBox detailshow;  String[] types={"Personal-Information", "Personal Loan", "Business Loan", "Consumer Loan","Credit Card"
    ,"Fund Transfer","Bills","Mobile Packages","Travel Tickets"};
   
    JButton back;
    int userid;
            

    
    JLabel intro, Details;
    String cardno;
    AccountDetails(String cardno)
    {
        this.cardno=cardno;
    
        setSize(1350,700);
        setLocation(00,00); setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        
        panel=new JPanel();
        panel.setBounds(0,0,1350,83);
        String yellow="#EFCC00";
        panel.setBackground(Color.decode(yellow));
        panel.setLayout(null);
        add(panel);
        
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
      //  back.addActionListener(this);
        add(back);
        
        intro=new JLabel("Check your details");
        Font font2=new Font("Segoe UI", BOLD, 30);
        intro.setFont(font2);
        intro.setBounds(530,115,700,50);
        add(intro);
        
               Details=new JLabel("Please choose the category for which you would like to receive details");
       Font font4=new Font("Segoe UI", BOLD, 22);
       Details.setFont(font4);
       Details.setBounds(60,245,750,50);
       add(Details);
       
       detailshow=new JComboBox(types);
         detailshow.setBounds(850,245, 270,50);
                  detailshow.setFont(font4);         
         add(detailshow);
        
           detailshow.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                  if (detailshow.getSelectedItem()=="Credit Card")
                  {
         try{
                DataConnection c=new DataConnection();       
         
     String query = "SELECT * FROM Credit WHERE jobtitle = 'r'";
       
                    ResultSet rs = c.s.executeQuery(query);
                     StringBuilder message = new StringBuilder();

        while (rs.next()) {
           String emptype = rs.getString("emptype");
                String jobtitle = rs.getString("jobtitle");
                String fine=rs.getString("fine");
                String credlimit=rs.getString("selectcredit");
                // ... retrieve other column values as needed

                // Append the retrieved data to the message
                message.append("Employement Type ").append(emptype).append("\n");
                message.append("Fine in case of non payement of credit dues: ").append(fine).append("\n");
                // ... append other column values as needed

                message.append("\n"); // Add a newline separator between records
            }

//            // Show the retrieved data using JOptionPane
            if (message.length() > 0) {
                JOptionPane.showMessageDialog(null, message.toString(), "Credit Card Details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "You are currently not availing our credit card services.", "No Data", JOptionPane.INFORMATION_MESSAGE);
            }
                  
         }
         
         catch (Exception ee) {
                   System.out.println(ee);
                }

              
                   
                }}
            }
        });
        
        setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==back)
    {
        setVisible(false);
        new Facilities(cardno);
        
    }}
        
  
    public static void main(String[] args) {
        new AccountDetails("322543");
    }
}