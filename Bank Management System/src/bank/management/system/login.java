/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;


import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;    // For printing graphics and images
import static java.awt.Font.BOLD;
import java.sql.*;
import java.awt.event.*;    // For printing graphics and images
import java.awt.event.ActionListener;  // For Action Listener

public class login  extends JFrame implements ActionListener {
    
    // Declarations 
        JButton SIGNUP , clear , SIGNIN ;
        JPasswordField cardTextField , pinTextField ;
        JPanel panel ;
        //JTextField  ;
    
    // Coonstructor of Login Class    
    login(){

    // Setting the dimensions,locations and visibility of Page
        setSize(1550,900);
        setVisible(true);
        setLayout(null);
        setTitle("Automated Teller Machine");
      
        
    // Presenting the Background image and setting is length and width
        ImageIcon backimage = new ImageIcon (ClassLoader.getSystemResource("icons/MCSBackgroun.png"));
        Image backimage1 = backimage.getImage().getScaledInstance(1550,900, Image.SCALE_DEFAULT);
        ImageIcon backimage2 = new ImageIcon(backimage1);

    //  displaying Background image and setting size and dimensions
        JLabel label4 = new JLabel(backimage2);
        label4.setBounds(0,0,1550,900);
        add(label4);    
        
    //panel
        panel=new JPanel();
        panel.setBounds(0,0,1550,80);
        String yellow="#EFCC00";
        panel.setBackground(Color.decode(yellow));
        panel.setLayout(null);
        label4.add(panel);
         
    //MCS BANK label
        JLabel MCS=new JLabel("MCS BANK");
        MCS.setBounds(40,10,200,60);
        MCS.setForeground(Color.WHITE);
        Font font=new Font("Segoe UI", BOLD, 32);
        MCS.setFont(font);
        panel.add(MCS);
        
        
    //  Label Statement
        JLabel statement = new JLabel("An Evolving Customer Based  ");
        statement.setBounds(470 ,100 ,  1000 , 200 );
        statement.setFont(new Font(" Stencil" , Font.BOLD , 42));
        add(statement);
        statement.setForeground(Color.decode(yellow));
        label4.add(statement);
        
    //  Label Statement
        JLabel statement2 = new JLabel("  Challenging Banking Tradition");
        statement2.setBounds(490 ,150 ,  1000 , 200 );
        statement2.setFont(new Font(" Stencil" , Font.BOLD , 34));
        statement2.setForeground(Color.decode(yellow));
        label4.add(statement2);
        

    // Asking Account no
        JLabel codeNo = new JLabel("Account no");
        codeNo.setBounds(500 ,240 ,  200 , 200 );
        codeNo.setFont(new Font(" Stencil" , Font.BOLD , 24));
        add(codeNo);
        codeNo.setForeground(Color.white);
        label4.add(codeNo);
        
    // Asking for Pin
        JLabel pin = new JLabel("Pin ");
        pin.setBounds(500 , 300 ,  200 , 200 );
        pin.setFont(new Font(" Stencil" , Font.BOLD , 24));
        add(pin);
        pin.setForeground(Color.white);
        label4.add(pin);

    // Tex field for card number
        cardTextField = new JPasswordField();
        cardTextField.setFont( new Font("Aerial",Font.BOLD,18));
        cardTextField.setBounds(670,330,350,30);
        add(cardTextField);
        label4.add(cardTextField);

    

    // Tex field for Password
        pinTextField = new JPasswordField();
        pinTextField.setFont( new Font("Aerial",Font.BOLD,18));
        pinTextField.setBounds(670,380,350,30);
        add(pinTextField);
        label4.add(pinTextField);

    // Setting the Background color
        getContentPane().setBackground(Color.white);


    // Signup Button
        SIGNUP = new JButton("Sign up");
        SIGNUP.setBounds(670,480,150,40);
        SIGNUP.addActionListener(this);
        add(SIGNUP);
        label4.add(SIGNUP);

    // Clear Button
        clear = new JButton("Clear");
        clear.setBounds(870,480,150,40);
        clear.addActionListener(this);
        add(clear);
        label4.add(clear);

    // SIGNIN Button
        SIGNIN = new JButton("Sign in");
        SIGNIN.setBounds(670,430,350,40);
        SIGNIN.addActionListener(this);
        add(SIGNIN);
        label4.add(SIGNIN);
        
     

    }

    // Override the methods in Action Listener 
    public void actionPerformed(ActionEvent ae){

        if (ae.getSource() == clear ){

            cardTextField.setText("");
            pinTextField.setText("");

        } else if (ae.getSource() == SIGNUP ){

            setVisible(false);
            new SignupOne().setVisible(true);
            
        } else if (ae.getSource() == SIGNIN ) {
    String givenCardno = cardTextField.getText();
    String givenPinno = pinTextField.getText();

    try {
        // instantiate the connection class
        DataConnection c = new DataConnection();

        ResultSet rs = c.s.executeQuery("SELECT * FROM MainTable WHERE cardno = '" + givenCardno + "'");

        if (rs.next()) {
            String storedPin = rs.getString("pin");
            String storedCardno = rs.getString("cardno");
          //  CardNo.cardno = storedCardno;

            // Comparing given account number and pin with stored card no and pin
            if (givenPinno.equals(storedPin) && givenCardno.equals(storedCardno)) {
                // Do something when the PIN and card number match
                setVisible(false);
                new Facilities(storedCardno);
            } else {
                // Show a message when the PIN and card number do not match
                JOptionPane.showMessageDialog(null, "The Entered Account no or Pin is not correct!");
            }
        } else {
            // No record found for the given card number
            JOptionPane.showMessageDialog(null, "The Entered Account no or Pin is not correct!");
        }

        rs.close();
        c.s.close();
    } catch (Exception e) {
        System.out.println(e);
    }
}

                   
        
    }
    public static void main(String[] args) {

          new login();
        
    }
}

