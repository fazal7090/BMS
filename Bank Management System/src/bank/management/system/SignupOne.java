package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;    // For printing graphics and images
import static java.awt.Font.BOLD;
import java.sql.*;
import java.awt.event.*;    // For printing graphics and images
import java.awt.event.ActionListener; 

public class SignupOne extends JFrame implements ActionListener {

    JLabel nameLabel, fnameLabel, dBirth, email, addressLabel, cityLabel, maritalLabel, StateLabel, genderLabel;
    TextField nameTextField, birthTextField, fnameTextField, stateTextField, pinTextField, cityTextField, addressTextField, emailTextField;
    JRadioButton married, otherGender, female, male, unmarried;
    JButton next, back;
    JPanel panel;
    private String cardno;

    SignupOne() {

        // Title and Dimensions for Frame
        setTitle("New Account Application Page 1");
        setVisible(true);
        setSize(1550, 900);

        // Presenting the Background image and setting its length and width
        ImageIcon backimage = new ImageIcon("icons/Logo1.png");
        Image backimage1 = backimage.getImage().getScaledInstance(1550, 900, Image.SCALE_DEFAULT);
        ImageIcon backimage2 = new ImageIcon(backimage1);

        // displaying Background image and setting size and dimensions
        JLabel label4 = new JLabel(backimage2);
        label4.setBounds(0, 0, 1550, 900);
        this.add(label4);

        
        // panel
        panel = new JPanel();
        panel.setBounds(0, 0, 1550, 85);
        String yellow = "#EFCC00";
        panel.setLayout(null);
        panel.setBackground(Color.decode(yellow));
        label4.add(panel);

        // MCS label
        JLabel MCSe = new JLabel("MCS BANK Management System");
        MCSe.setBounds(480, 10, 685, 70);
        MCSe.setForeground(Color.WHITE);
        MCSe.setFont(new Font("Segoe UI", Font.BOLD, 42));
        panel.add(MCSe);

        // Personal Detail Label
        JLabel personDetails = new JLabel("Add Your Personal Details ");
        personDetails.setFont(new Font("Railway", Font.BOLD, 44));
        personDetails.setBounds(550, 150, 650, 54);
        personDetails.setForeground(Color.white);
        label4.add(personDetails);

        // Name Label
        nameLabel = new JLabel("Name ");
        nameLabel.setFont(new Font("Railway", Font.BOLD, 18));
        nameLabel.setBounds(590, 240, 150, 25);
        nameLabel.setForeground(Color.white);
        label4.add(nameLabel);

        // Name Text Field
        nameTextField = new TextField();
        nameTextField.setBounds(740, 240, 320, 25);
        nameTextField.setFont(new Font("Railway", Font.BOLD, 16));
        label4.add(nameTextField);

        // Father Name Label
        fnameLabel = new JLabel("Father's Name ");
        fnameLabel.setFont(new Font("Railway", Font.BOLD, 18));
        fnameLabel.setBounds(590, 270, 150, 25);
        fnameLabel.setForeground(Color.white);
        label4.add(fnameLabel);

        // Father Name Text Field
        fnameTextField = new TextField();
        fnameTextField.setBounds(740, 270, 320, 25);
        fnameTextField.setFont(new Font("Railway", Font.BOLD, 16));
        label4.add(fnameTextField);

        // Date of Birth Label
        dBirth = new JLabel("Date Of Birth ");
        dBirth.setFont(new Font("Railway", Font.BOLD, 18));
        dBirth.setBounds(590, 300, 150, 25);
        dBirth.setForeground(Color.white);
        label4.add(dBirth);

        // Date of Birth Text Field
        birthTextField = new TextField();
        birthTextField.setBounds(740, 300, 320, 25);
        birthTextField.setFont(new Font("Railway", Font.BOLD, 16));
        label4.add(birthTextField);

        // email Label
        email = new JLabel("Email Address ");
        email.setFont(new Font("Railway", Font.BOLD, 18));
        email.setBounds(590, 330, 150, 25);
        email.setForeground(Color.white);
        label4.add(email);

        // email Text Field
        emailTextField = new TextField();
        emailTextField.setBounds(740, 330, 320, 25);
        emailTextField.setFont(new Font("Railway", Font.BOLD, 16));
        label4.add(emailTextField);

        // Address Label
        addressLabel = new JLabel("Address ");
        addressLabel.setFont(new Font("Railway", Font.BOLD, 18));
        addressLabel.setForeground(Color.white);
        addressLabel.setBounds(590, 360, 150, 25);
        label4.add(addressLabel);

        // Address Text Field
        addressTextField = new TextField();
        addressTextField.setBounds(740, 360, 320, 25);
        addressTextField.setFont(new Font("Railway", Font.BOLD, 16));
        label4.add(addressTextField);

        // City Label
        cityLabel = new JLabel("City ");
        cityLabel.setFont(new Font("Railway", Font.BOLD, 18));
        cityLabel.setForeground(Color.white);
        cityLabel.setBounds(590, 390, 150, 25);
        label4.add(cityLabel);

        // City Text Field
        cityTextField = new TextField();
        cityTextField.setBounds(740, 390, 320, 25);
        cityTextField.setFont(new Font("Railway", Font.BOLD, 16));
        label4.add(cityTextField);

        // State Label
        StateLabel = new JLabel("State ");
        StateLabel.setFont(new Font("Railway", Font.BOLD, 18));
        StateLabel.setForeground(Color.white);
        StateLabel.setBounds(590, 420, 150, 25);
        label4.add(StateLabel);

        // State Text Field
        stateTextField = new TextField();
        stateTextField.setBounds(740, 420, 320, 25);
        stateTextField.setFont(new Font("Railway", Font.BOLD, 16));
        label4.add(stateTextField);

        // Marital Status Label
        maritalLabel = new JLabel("Marital Status ");
        maritalLabel.setFont(new Font("Railway", Font.BOLD, 18));
        maritalLabel.setForeground(Color.white);
        maritalLabel.setBounds(590, 450, 150, 25);
        label4.add(maritalLabel);

        // Radio Buttons for Marital Status

        // For Married
        married = new JRadioButton("Married");
        married.setBackground(Color.white);
        married.setBounds(740, 450, 100, 25);
        label4.add(married);

        // For Unmarried
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBackground(Color.white);
        unmarried.setBounds(850, 450, 100, 25);
        label4.add(unmarried);

        // For only single option selection
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);

        // Gender Label
        genderLabel = new JLabel("Gender ");
        genderLabel.setFont(new Font("Railway", Font.BOLD, 18));
        genderLabel.setBounds(590, 480, 150, 25);
        genderLabel.setForeground(Color.WHITE);
        label4.add(genderLabel);

        // Radio Buttons for Marital Status

        // For Male
        male = new JRadioButton("Male");
        male.setBackground(Color.white);
        male.setBounds(740, 480, 100, 25);
        label4.add(male);

        // For Female
        female = new JRadioButton("Female");
        female.setBackground(Color.white);
        female.setBounds(850, 480, 100, 25);
        label4.add(female);

        // For Others
        otherGender = new JRadioButton("Others");
        otherGender.setBackground(Color.white);
        otherGender.setBounds(960, 480, 100, 25);
        label4.add(otherGender);

        // For only single option selection
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(otherGender);

        // Back Button
        back = new JButton("BACK");
        back.setBounds(630, 580, 180, 40);
        back.addActionListener(this);
        label4.add(back);

        // Adding Next Button
        next = new JButton("Next");
        next.setBounds(850, 580, 180, 40);
        next.addActionListener(this);
        label4.add(next);
        
          getContentPane().setBackground(Color.BLACK);
    }

    // Implementing the Abstract method
    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public boolean checkcardno(String cardno)
    {
        try {
            // instatiate the connection class
            DataConnection c = new DataConnection();

            ResultSet rs = c.s.executeQuery("SELECT * FROM MainTable WHERE cardno = '" + cardno + "'");

            if (rs.next()) {

                return true;

            }
        }
            catch (Exception e) {
                    System.out.println(e);

                }
            return false;
        
    }
    public void actionPerformed(ActionEvent ae) {

        // Alloting some Card number and details
        Random ran = new Random();
        String cardno = "" + Math.abs((ran.nextLong() % 900L) + 504093L);
        while (checkcardno(cardno)==true)
        {
             cardno = "" + Math.abs((ran.nextLong() % 900L) + 504093L);
           
        }
       
                setCardno(cardno);
                String pin = "" + Math.abs((ran.nextLong() % 9000L) + 1000L);
                CardNo.cardno = getCardno();
                String name = nameTextField.getText();
                String fName = fnameTextField.getText();
                String dob = birthTextField.getText();
                String state = stateTextField.getText();
                String city = cityTextField.getText();
                String address = addressTextField.getText();
                String email = emailTextField.getText();
                cardno = getCardno();
                int bal=0;

                // For Radio Button Gender
                String gender = null;

                if (male.isSelected()) {
                    gender = "male";
                } else if (female.isSelected()) {
                    gender = "female ";
                } else if (otherGender.isSelected()) {
                    gender = " other";
                }

                // For Marital status Button
                String marital = null;
                if (married.isSelected()) {
                    marital = "married";
                } else if (unmarried.isSelected()) {
                    marital = "unmarried";
                }

                // Exceptional Handling

                try {

                    // User wants to go back to the previous page
                    if (ae.getSource() == back) {
                        this.setVisible(false);
                        new login().setVisible(true);
                    } else {
                        if (name.equals("") || fName.equals("") || dob.equals("") || state.equals("") || city.equals("")
                                || address.equals("") || email.equals("")) {
                            // If the user presses next without entering his details
                            JOptionPane.showMessageDialog(null, "Please enter your details!");
                        } else {
                            if (ae.getSource() == next) {
                                
                                 DataConnection con = new DataConnection();

                            // Writing mySQL Query
                    String query = "INSERT INTO MainTable VALUES('" + cardno + "','" + name + "' , '" + fName
    + "' , '" + dob + "' , '" + state + "' , '" + city + "'  ,'" + address + "' , '"
    + email + "' , '" + gender + "' ,'" + marital + "','" + pin + "','" + bal + "')";


                            // Executing mySQL Query
                            con.s.executeUpdate(query);
                            
                                 JOptionPane.showMessageDialog(null,"The 6 digit Account number generated for your account is "+ getCardno() + " \nThe 4 digit pin generated for your account is "+ pin );
                          setVisible(false);
                          new AddMoney(cardno);
                            
                           
                        }
                    }
                    }
                } catch (Exception e) {
                    System.out.println(e);

                }
    }
           

    public static void main(String[] args) {
        SignupOne a=new SignupOne();
    }
}
