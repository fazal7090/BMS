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




public class ConsumerLoan  implements ActionListener, Methods {
    double installment=0;  private int max_sal=50000;
    private JFrame frame1=new JFrame();
    JComboBox repay, products;  
    String[] repay_string={"12 Months (1 Year)", "24 Months (2 Years)", "36 Months (3 Years)", "48 Months (4 Years)"}, 
            products_string={"Home","Car","Solar Panel", "Fridge"};
    JRadioButton SalPer, Businessman;  String income_input, loan_input, repay_input, product_input;
    ButtonGroup emp;
    JButton back, enter;
    JPanel panel;
    JLabel intro, intro1, EmpType, INCOME, LOAN, REPAY, PRODUCTS;
    JTextField income, loan;
    //for current date and time 
    Date currentDate = new Date();
    Timestamp timestamp = new Timestamp(currentDate.getTime());
    
    ConsumerLoan(){ 
         //frame
        frame1.setSize(1550,850);
        frame1.setLocation(00,00); frame1.setLayout(null);
        frame1.setResizable(false);
        
        //panel
        panel=new JPanel();
        panel.setBounds(0,0,1550,80);
        String yellow="#EFCC00";
        panel.setBackground(Color.decode(yellow));
        panel.setLayout(null);
        frame1.add(panel);
        
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
        frame1.add(back);
        
        
        //intro label
        intro=new JLabel("Apply for Consumer Loan");
        Font font2=new Font("Segoe UI", BOLD, 35);
        intro.setFont(font2);
        intro.setBounds(550,100,700,50);
        intro.setForeground(Color.decode(yellow));
        frame1.add(intro);
        
        //intro1 label
        intro1=new JLabel("Achieve more with our consumer loans");
        Font font3=new Font("Segoe UI", BOLD, 50);
        intro1.setFont(font3);
        intro1.setBounds(350,160,1000,60);
        intro1.setForeground(Color.decode(yellow));
       frame1. add(intro1);
        
        //employment type label
       EmpType=new JLabel("Employment Type");
       Font font4=new Font("Segoe UI", BOLD, 25);
       EmpType.setFont(font4);
       EmpType.setBounds(300,250,500,50);
      frame1. add(EmpType);
      
        //salaried person radio button
        SalPer=new JRadioButton("Salaried Person");
         SalPer.setBounds(700,250,250,50);
         SalPer.setFont(font4);
         SalPer.addActionListener(this);
         frame1.add(SalPer);
         
        //businessman radio button
        Businessman=new JRadioButton("Businessman");
         Businessman.setBounds(950,250,200,50);
         Businessman.setFont(font4);
        Businessman.addActionListener(this);
         frame1.add(Businessman);
         
         
         //for single option
         emp=new ButtonGroup();
         emp.add(SalPer);
         emp.add(Businessman);
         
          //income label
        INCOME=new JLabel("Monthly Net Income");
       INCOME.setFont(font4);
        INCOME.setBounds(300,320,300,50);
        frame1.add(INCOME);
        
        //income text field
        income=new JTextField();
        income.setBounds(700,328,250,35);
       frame1. add(income);
    
        
         //LOAN label
        LOAN=new JLabel("Loan Amount (PKR)");
       LOAN.setFont(font4);
        LOAN.setBounds(300,390,300,50);
        frame1.add(LOAN);
        
        //loan text field
        loan=new JTextField();
        loan.setBounds(700,398,250,35);
        frame1.add(loan);
        
  
         //repay label
        REPAY=new JLabel("Desired Loan Repayment Period");
       REPAY.setFont(font4);
        REPAY.setBounds(300,460,600,50);
        frame1.add(REPAY);
        
         //repay dropdown
         repay=new JComboBox(repay_string);
         repay.setBounds(700,462, 200,50);
         frame1.add(repay);
        
         //PRODUCTS label
       PRODUCTS=new JLabel("Product Type");
       PRODUCTS.setFont(font4);
       PRODUCTS.setBounds(300,540,200,50);
       frame1.add(PRODUCTS);
       
        //products dropdown
         products=new JComboBox(products_string);
         products.setBounds(700,540, 200,50);
         frame1.add(products);
         
         //enter button
         enter=new JButton("Enter");
         Font font6=new Font("Segoe UI", BOLD, 25);
        enter.setFont(font6);
        enter.setBounds(1000,660,100,35);
        enter.setBackground(Color.decode(yellow));
        enter.setForeground(Color.WHITE);
        enter.addActionListener(this);
        frame1.add(enter);
        
        //view
        frame1.setVisible(true);
        
    }
    
    //METHODS
    
    //monthly installment method
    public void monthly_installment(int n, double installment, String selected){
        JOptionPane.showMessageDialog(null, "Your monthly installment for "+n+" months of "+selected+" loan is Rs. "+installment);
    }
    
    //exceeded loan
    public void exceeded_loan(double max){
        JOptionPane.showMessageDialog(null,"Sorry, the loan amount you entered exceeds the maximum loan limit of Rs."+ max+" Please enter a lower loan amount");
    }
    
      //salary limit
    public void salary_limit(){
        JOptionPane.showMessageDialog(null, "Sorry, your salary is less than the minimum salary limit of "+max_sal+" for applying for a loan");
    }
   
    
     //Action
    double N=0, N1=0, max=0; int n=0; String selected, selected1;
    public void actionPerformed(ActionEvent ae){ 
        //My account action
        if(ae.getSource()==back) {
           frame1. setVisible(false);
            new Facilities();
         }
   
        
        //product enter action
        else if(ae.getSource()==enter) {
            //salary
            income_input=income.getText();
             N=parseDouble(income_input);
             setSalary((int) N);
            
            if(getSalary()<max_sal){
                salary_limit();
            }
            
            //loan
            loan_input=loan.getText();
            N1=parseDouble(loan_input);
            setLoan((int) N1);
            
            //product
           selected1 = (String) products.getSelectedItem(); 
          
           
           //repayment period
           selected = (String) repay.getSelectedItem(); 

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
            
            max=(getSalary()/2)*n;
            if(getLoan()>max && getSalary()>=max_sal){
                exceeded_loan(max);
            }
            
            installment=N1/n;
            
            if(getLoan()<max && getSalary()>=max_sal){
                //insert values into PersonalLoan table
                 DataConnection db=new DataConnection();
                try{
                     String query = "INSERT INTO ConsumerLoan VALUES ('" + CardNo.cardno + "','" + getLoan() + "','" + installment + "','" + selected1 + "','" + selected+ "','" + timestamp + "')";

                 db.s.executeUpdate(query);
                }
                catch(Exception e){
                    System.out.println(e);
                }
                
                //JoptionPane output
               monthly_installment(n,installment, selected1);
               
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
                bal+=getLoan();
                
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
        new ConsumerLoan();
    }
}