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

public class Details extends AddMoney implements ActionListener {
     JPanel panel; JFrame frame=new JFrame();
    JComboBox detailshow;  String[] types={  "Business Loan", "Consumer Loan","Credit Card"
    ,"Fund Transfer","Bills","Mobile Packages"};
   
    JButton back;
    int userid;
            

    
    JLabel intro, Details;String cardno
    Details()
    {
        
        nframe.setVisible(false);
        frame.setSize(1350,700);
        frame.setLocation(00,00); frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.white);
        
        panel=new JPanel();
        panel.setBounds(0,0,1350,83);
        String yellow="#EFCC00";
        panel.setBackground(Color.decode(yellow));
        panel.setLayout(null);
        frame.add(panel);
        
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
        frame.add(back);
        
        intro=new JLabel("Check your details");
        Font font2=new Font("Segoe UI", BOLD, 30);
        intro.setFont(font2);
        intro.setBounds(530,115,700,50);
        frame.add(intro);
        
               Details=new JLabel("Please choose the category for which you would like to receive details");
       Font font4=new Font("Segoe UI", BOLD, 22);
       Details.setFont(font4);
       Details.setBounds(60,245,750,50);
       frame.add(Details);
       
       detailshow=new JComboBox(types);
         detailshow.setBounds(850,245, 270,50);
                  detailshow.setFont(font4);         
         frame.add(detailshow);
        
           detailshow.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                  if (detailshow.getSelectedItem()=="Credit Card")
                  {
         try{
         DataConnection c=new DataConnection();    
         
     String query = "SELECT * FROM credit WHERE CardNo = '"+CardNo.cardno+"'";
       
                    ResultSet rs = c.s.executeQuery(query);
                     StringBuilder message = new StringBuilder();

        while (rs.next()) {
           String emptype = rs.getString("emptype");
                String jobtitle = rs.getString("jobtitle");
                String fine=rs.getString("fine");
                String credlimit=rs.getString("selectcredit");
                // ... retrieve other column values as needed

                // Append the retrieved data to the message
                message.append("Employement Type :").append(emptype).append("\n");
                message.append("Credit Limit: ").append(credlimit).append("\n");
                message.append("Fine in case of non payement of credit dues: ").append(fine).append("\n");

                // ... append other column values as needed

                message.append("\n"); // Add a newline separator between records
            }

            // Show the retrieved data using JOptionPane
            if (message.length() > 0) {
                JOptionPane.showMessageDialog(null, message.toString(), "Credit Card Details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "You are currently not availing our credit card services.", "No Data", JOptionPane.INFORMATION_MESSAGE);
            }
                  
         }
         
         catch (Exception ee) {
                   System.out.println(ee);
                }

              
                    
                }
                  else if (detailshow.getSelectedItem()=="Personal Loan")
                  {
         try{
                  DataConnection c=new DataConnection();    
    
         
     String query = "SELECT * FROM PersonalLoan WHERE acc_no = '"+CardNo.cardno+"'";
       
                    ResultSet rs = c.s.executeQuery(query);
                     StringBuilder message = new StringBuilder();

        while (rs.next()) {
           String acc_no = rs.getString("acc_no");
                String loan_Amount = rs.getString("loan_amount");
                String montinstal=rs.getString("monthly_installment");
                String datetime=rs.getString("date_time");
          

              
                message.append("Account Number : ").append(acc_no).append("\n");
                message.append("Loan Amount: ").append(loan_Amount).append("\n");
                message.append("Monthly Installment: ").append(montinstal).append("\n");
                message.append("Date an time of application: ").append(datetime).append("\n");

                message.append("\n"); // Adding line
            }

            
            if (message.length() > 0) {
                JOptionPane.showMessageDialog(null, message.toString(), "Personal Loan Details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "You are not currently availing our personal loan services", "No Data", JOptionPane.INFORMATION_MESSAGE);
            }
                  
         }
         
         catch (Exception ee) {
                   System.out.println(ee);
                }

              
                    
                }
         else if (detailshow.getSelectedItem()=="Consumer Loan")
                  {
         try{
                           DataConnection c=new DataConnection();    
  
         
     String query = "SELECT * FROM ConsumerLoan WHERE acc_no = '"+CardNo.cardno+"'";
       
                    ResultSet rs = c.s.executeQuery(query);
                    StringBuilder message = new StringBuilder();

        while (rs.next()) {
                String acc_no = rs.getString("acc_no");
                String loan_Amount = rs.getString("loan_amount");
                String montinstal=rs.getString("monthly_installment");
                String datetime=rs.getString("date_time");
                String product=rs.getString("product");

              
                message.append("Account Number : ").append(acc_no).append("\n");
                message.append("Loan Amount: ").append(loan_Amount).append("\n");
                message.append("Monthly Installment: ").append(montinstal).append("\n");
                message.append("Date an time of application: ").append(datetime).append("\n");
                message.append("Product Type: ").append(product).append("\n");


                message.append("\n"); // Adding line
            }

            
            if (message.length() > 0) {
                JOptionPane.showMessageDialog(null, message.toString(), "Consumer Loan Details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "You are not currently  availing our consumer loan services.", "No Data", JOptionPane.INFORMATION_MESSAGE);
            }
                  
         }
         
         catch (Exception ee) {
                   System.out.println(ee);
                }

              
                    
                } 
          else if (detailshow.getSelectedItem()=="Business Loan")
                  {
         try{
                          DataConnection c=new DataConnection();      
         
     String query = "SELECT * FROM BusinessLoan WHERE acc_no = '"+CardNo.cardno+"'";
       
                    ResultSet rs = c.s.executeQuery(query);
                    StringBuilder message = new StringBuilder();

        while (rs.next()) {
                String acc_no = rs.getString("acc_no");
                String loan_Amount = rs.getString("loan_amount");
                String montinstal=rs.getString("monthly_installment");
                String datetime=rs.getString("date_time");
                

              
                message.append("Account Number : ").append(acc_no).append("\n");
                message.append("Loan Amount: ").append(loan_Amount).append("\n");
                message.append("Monthly Installment: ").append(montinstal).append("\n");
                message.append("Date an time of application: ").append(datetime).append("\n");
             


                message.append("\n"); // Adding line
            }

            
            if (message.length() > 0) {
                JOptionPane.showMessageDialog(null, message.toString(), "Business Loan Details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "You are not currently  availing our business loan services.", "No Data", JOptionPane.INFORMATION_MESSAGE);
            }
                  
         }
         
         catch (Exception ee) {
                   System.out.println(ee);
                }

              
                    
                } 
             else if (detailshow.getSelectedItem()=="Fund Transfer")
                  {
         try{
                          DataConnection c=new DataConnection();      
         
     String query = "SELECT * FROM transfer_details WHERE account_number = '"+CardNo.cardno+"'";
       
                    ResultSet rs = c.s.executeQuery(query);
                    StringBuilder message = new StringBuilder();

        while (rs.next()) {
                String acc_no = rs.getString("account_number");
                String acc_name = rs.getString("account_name");
                String tranamount=rs.getString("transfer_amount");
                String datetime=rs.getString("date_time");
                

              
                message.append("Account Number : ").append(acc_no).append("\n");
                message.append("Loan Amount: ").append(acc_name).append("\n");
                message.append("Monthly Installment: ").append(tranamount).append("\n");
                message.append("Date an time of application: ").append(datetime).append("\n");
             


                message.append("\n"); // Adding line
            }

            
            if (message.length() > 0) {
                JOptionPane.showMessageDialog(null, message.toString(), "Fund transfer details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No transaction made.", "No Data", JOptionPane.INFORMATION_MESSAGE);
            }
                  
         }
         
         catch (Exception ee) {
                   System.out.println(ee);
                }

              
                    
                }
    else if (detailshow.getSelectedItem() == "Bills") {
    try {
        DataConnection c = new DataConnection();
        StringBuilder message = new StringBuilder();

        // Fetch data from GasBill table
        String gasQuery = "SELECT * FROM GasBill WHERE acc_no = '" + CardNo.cardno + "'";
        ResultSet gasResultSet = c.s.executeQuery(gasQuery);

        while (gasResultSet.next()) {
            String acc_no = gasResultSet.getString("acc_no");
            String bill_no = gasResultSet.getString("bill_no");
            double bill_amount = gasResultSet.getDouble("bill_amount");
            String date_time = gasResultSet.getString("date_time");

            message.append("Gas Bill\n");
            message.append("Account Number: ").append(acc_no).append("\n");
            message.append("Bill Number: ").append(bill_no).append("\n");
            message.append("Bill Amount: ").append(bill_amount).append("\n");
            message.append("Date and Time: ").append(date_time).append("\n");
            message.append("\n");
        }

        // Fetch data from InternetBill table
        String internetQuery = "SELECT * FROM InternetBill WHERE acc_no = '" + CardNo.cardno + "'";
        ResultSet internetResultSet = c.s.executeQuery(internetQuery);

        while (internetResultSet.next()) {
            String acc_no = internetResultSet.getString("acc_no");
            String bill_no = internetResultSet.getString("bill_no");
            double bill_amount = internetResultSet.getDouble("bill_amount");
            String date_time = internetResultSet.getString("date_time");

            message.append("Internet Bill\n");
            message.append("Account Number: ").append(acc_no).append("\n");
            message.append("Bill Number: ").append(bill_no).append("\n");
            message.append("Bill Amount: ").append(bill_amount).append("\n");
            message.append("Date and Time: ").append(date_time).append("\n");
            message.append("\n");
        }

        // Fetch data from ElectricityBill table
        String electricityQuery = "SELECT * FROM ElectricityBill WHERE acc_no = '" + CardNo.cardno + "'";
        ResultSet electricityResultSet = c.s.executeQuery(electricityQuery);

        while (electricityResultSet.next()) {
            String acc_no = electricityResultSet.getString("acc_no");
            String bill_no = electricityResultSet.getString("bill_no");
            double bill_amount = electricityResultSet.getDouble("bill_amount");
            String date_time = electricityResultSet.getString("date_time");

            message.append("Electricity Bill\n");
            message.append("Account Number: ").append(acc_no).append("\n");
            message.append("Bill Number: ").append(bill_no).append("\n");
            message.append("Bill Amount: ").append(bill_amount).append("\n");
            message.append("Date and Time: ").append(date_time).append("\n");
            message.append("\n");
        }

        // Fetch data from WaterBill table
        String waterQuery = "SELECT * FROM WaterBill WHERE acc_no = '" + CardNo.cardno + "'";
        ResultSet waterResultSet = c.s.executeQuery(waterQuery);

        while (waterResultSet.next()) {
            String acc_no = waterResultSet.getString("acc_no");
            String bill_no = waterResultSet.getString("bill_no");
            double bill_amount = waterResultSet.getDouble("bill_amount");
            String date_time = waterResultSet.getString("date_time");

            message.append("Water Bill\n");
            message.append("Account Number: ").append(acc_no).append("\n");
            message.append("Bill Number: ").append(bill_no).append("\n");
            message.append("Bill Amount: ").append(bill_amount).append("\n");
            message.append("Date and Time: ").append(date_time).append("\n");
            message.append("\n");
        }

        if (message.length() > 0) {
            JOptionPane.showMessageDialog(null, message.toString(), "Bill Details", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No bills found.", "No Data", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (Exception ee) {
        System.out.println(ee);
    }
}
  
            else if (detailshow.getSelectedItem()=="Personal Information")
                  {
         try{
                          DataConnection c=new DataConnection();      
         
     String query = "SELECT * FROM signup1 WHERE acc_no = '"+CardNo.cardno+"'";
       
                    ResultSet rs = c.s.executeQuery(query);
                    StringBuilder message = new StringBuilder();

        while (rs.next()) {
                String name = rs.getString("Name");
                String fname = rs.getString("Father_Name");
                String dob=rs.getString("dob");
                String state=rs.getString("state");
                String city=rs.getString("city");

                
                

              
                message.append("Account Number : ").append(CardNo.cardno).append("\n");
                message.append("Name :").append(name).append("\n");
                message.append("Father Name: ").append(fname).append("\n");
                message.append("Date of birth : ").append(dob).append("\n");
                             message.append("State :").append(state).append("\n");
                 message.append("City :").append(city).append("\n");
  
             


                message.append("\n"); // Adding line
            }

            
            if (message.length() > 0) {
                JOptionPane.showMessageDialog(null, message.toString(), "Personal details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No Data`.", "No Data", JOptionPane.INFORMATION_MESSAGE);
            }
                  
         }
         
         catch (Exception ee) {
                   System.out.println(ee);
                }

              
                    
                }  
            else if (detailshow.getSelectedItem()=="Personal Information")
                  {
         try{
                          DataConnection c=new DataConnection();      
         
     String query = "SELECT * FROM MobPackages WHERE acc_no = '"+CardNo.cardno+"'";
       
                    ResultSet rs = c.s.executeQuery(query);
                    StringBuilder message = new StringBuilder();

        while (rs.next()) {
                String name = rs.getString("Name");
                String fname = rs.getString("Father_Name");
                String dob=rs.getString("dob");
                String state=rs.getString("state");
                String city=rs.getString("city");

                
                

              
                message.append("Account Number : ").append(CardNo.cardno).append("\n");
                message.append("Name :").append(name).append("\n");
                message.append("Father Name: ").append(fname).append("\n");
                message.append("Date of birth : ").append(dob).append("\n");
                             message.append("State :").append(state).append("\n");
                 message.append("City :").append(city).append("\n");
  
             


                message.append("\n"); // Adding line
            }

            
            if (message.length() > 0) {
                JOptionPane.showMessageDialog(null, message.toString(), "Fund transfer details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No transaction made.", "No Data", JOptionPane.INFORMATION_MESSAGE);
            }
                  
         }
         
         catch (Exception ee) {
                   System.out.println(ee);
                }

              
                    
                }
                  else if (detailshow.getSelectedItem() == "Mobile Packages") {
    try {
        DataConnection c = new DataConnection();
        String query = "SELECT * FROM MobPackage WHERE acc_no = '" + CardNo.cardno + "'";
        ResultSet rs = c.s.executeQuery(query);
        StringBuilder message = new StringBuilder();

        while (rs.next()) {
            String package_name = rs.getString("package_name");
            int price = rs.getInt("price");
            String mobile_no = rs.getString("mobile_no");
            String date_time = rs.getString("date_time");

            message.append("Account Number: ").append(CardNo.cardno).append("\n");
            message.append("Package Name: ").append(package_name).append("\n");
            message.append("Price: ").append(price).append("\n");
            message.append("Mobile Number: ").append(mobile_no).append("\n");
            message.append("Date and Time: ").append(date_time).append("\n");

            message.append("\n"); // Adding line
        }

        if (message.length() > 0) {
            JOptionPane.showMessageDialog(null, message.toString(), "Packages details", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No personal information found.", "No Data", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (Exception ee) {
        System.out.println(ee);
    }
}
                  
                 }
            }
        });
        
        frame.setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==back)
    {
        frame.setVisible(false);
//        new Facilities();
        
    }}
        
  
    public static void main(String[] args) {
        new Details();
    }
}