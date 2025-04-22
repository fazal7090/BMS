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





public class BusinessLoan  implements ActionListener, Methods1 {
 
    double installment=0;
    private JFrame frame3=new JFrame();
    JComboBox repay;  String[] repay_string={"12 Months (1 Year)", "24 Months (2 Years)", "36 Months (3 Years)", "48 Months (4 Years)"};
    JRadioButton SalPer, Businessman;  String income_input, loan_input, repay_input;
    ButtonGroup emp;
    JButton back, enter;
    JPanel panel;
    JLabel intro, intro1, EmpType, INCOME, LOAN, REPAY;
    JTextField income, loan;
    
    //for current date and time 
    Date currentDate = new Date();
    Timestamp timestamp = new Timestamp(currentDate.getTime());
    
    BusinessLoan(){     
         //frame
        frame3.setSize(1550,850);
        frame3.setLocation(00,00); frame3.setLayout(null);
        frame3.setResizable(false);
        
        //panel
        panel=new JPanel();
        panel.setBounds(0,0,1550,80);
        String yellow="#EFCC00";
        panel.setBackground(Color.decode(yellow));
        panel.setLayout(null);
        frame3.add(panel);
        
        //MCS BANK label
        JLabel MCS=new JLabel("MCS BANK");
        MCS.setBounds(40,10,200,60);
        MCS.setForeground(Color.WHITE);
        Font font=new Font("Segoe UI", BOLD, 32);
        MCS.setFont(font);
        panel.add(MCS);
        
        //back button
         back=new JButton("Back");
        Font font1=new Font("Segoe UI", BOLD, 20);
        back.setFont(font1);
        back.setBounds(1400,15,70,45);
        back.setBackground(Color.decode(yellow));
        back.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        frame3.add(back);
        
        //intro label
        intro=new JLabel("Apply for Consumer Loan");
        Font font2=new Font("Segoe UI", BOLD, 35);
        intro.setFont(font2);
        intro.setBounds(550,100,700,50); 
        intro.setForeground(Color.decode(yellow));
        frame3.add(intro);
        
        //intro1 label
        intro1=new JLabel("Fuel your business growth with our loans");
        Font font3=new Font("Segoe UI", BOLD, 50);
        intro1.setFont(font3);
        intro1.setBounds(350,160,1000,60);
        intro1.setForeground(Color.decode(yellow));
        frame3.add(intro1);
        
          //income label
        INCOME=new JLabel("Annual Business Turnover");
        Font font5=new Font("Segoe UI", BOLD, 25);
       INCOME.setFont(font5);
        INCOME.setBounds(300,300,500,50);
        frame3.add(INCOME);
        
        //income text field
        income=new JTextField();
        income.setBounds(700,308,250,35);
        frame3.add(income);
        
         //LOAN label
        LOAN=new JLabel("Loan Amount (PKR)");
       LOAN.setFont(font5);
        LOAN.setBounds(300,370,300,50);
        frame3.add(LOAN);
        
        //loan text field
        loan=new JTextField();
        loan.setBounds(700,378,250,35);
       frame3. add(loan);
        

        
           //repay label
        REPAY=new JLabel("Desired Loan Repayment Period");
       REPAY.setFont(font5);
        REPAY.setBounds(300,430,600,50);
        frame3.add(REPAY);
        
         //repay dropdown
         repay=new JComboBox(repay_string);
         repay.setBounds(700,438, 200,50);
         frame3.add(repay);
         
        
        //enter button
         enter=new JButton("Enter");
         Font font6=new Font("Segoe UI", BOLD, 25);
        enter.setFont(font6);
        enter.setBounds(1000,560,100,35);
        enter.setBackground(Color.decode(yellow));
        enter.setForeground(Color.WHITE);
        enter.addActionListener(this);
        frame3.add(enter);
        
        
        //view
        frame3.setVisible(true);
        
    }
    
    //METHODS
    
    //monthly installment method
    public void monthly_installment(int n, double installment){
        JOptionPane.showMessageDialog(null, "Your monthly installment for "+n+" months of business loan is Rs. "+installment);
    }
    
    //exceeded loan
    public void exceeded_loan(double max){
        JOptionPane.showMessageDialog(null,"Sorry, the loan amount you entered exceeds the maximum loan limit of Rs."+ max+" Please enter a lower loan amount");
    }
    
     //Action
    double N=0, N1=0; double max=0;
    public void actionPerformed(ActionEvent ae){ 
        //My account action
        if(ae.getSource()==back) {
            frame3.setVisible(false);
            new Facilities();
         }
        
     
        //repay action
        if(ae.getSource()==enter) {
            //income
            income_input=income.getText();
             N=parseDouble(income_input);
             setSalary((int) N);
            
             //loan
              loan_input=loan.getText();
            N1=parseDouble(loan_input);
            setLoan((int) N1);
            max=4*getSalary();
            if(getLoan()>max){
                exceeded_loan(max);
            }
            
            //repay
            String selected = (String) repay.getSelectedItem(); int n=0;

            if(selected==repay_string[0]){
             n=12;
        }
            
        else if(selected==repay_string[1]){
             n=24;
            }
            if(selected==repay_string[2]){
             n=36;
            }
            if(selected==repay_string[3]){
             n=48;
            }
         
            installment=N1/n;
            
            if(getLoan()<=max){
                 //insert values into PersonalLoan table
                 DataConnection db=new DataConnection();
                try{
                     String query = "INSERT INTO BusinessLoan VALUES ('" + CardNo.cardno + "','" + getLoan() + "','" + installment + "','" + selected + "','" + timestamp+ "')";

                 db.s.executeUpdate(query);
                }
                catch(Exception e){
                    System.out.println(e);
                }
                
                //JoptionPane output
                monthly_installment(n,installment);
                
                //update balance
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
                  
                try {
                            String query = "UPDATE Balance SET balance = " + bal + " WHERE acc_no = '" + CardNo.cardno + "'";
                            db.s.executeUpdate(query);
                } catch (Exception e) {
                    System.out.println("SQL Exception: " + e.getMessage());
                }
            }
        }            
            
} 
      
    
    public static void main(String[] args) {
        new BusinessLoan();
    }
}