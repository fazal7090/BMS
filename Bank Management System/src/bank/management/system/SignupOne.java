package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Random;

public class SignupOne extends JFrame implements ActionListener {

    JLabel nameLabel, fnameLabel, dBirth, email, addressLabel, cityLabel, maritalLabel, StateLabel, genderLabel;
    TextField nameTextField, birthTextField, fnameTextField, stateTextField, pinTextField, cityTextField, addressTextField, emailTextField;
    JRadioButton married, otherGender, female, male, unmarried;
    JButton next, back;
    JPanel headerPanel;
    private String cardno;

    SignupOne() {
        setTitle("New Account Application Page 1");
        setSize(1000, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Main background panel
        JPanel background = new JPanel();
        background.setLayout(null);
        background.setBounds(0, 0, 1000, 750);
        background.setBackground(Color.WHITE);
        add(background);

        // Header panel
        headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 1000, 85);
        headerPanel.setLayout(null);
        headerPanel.setBackground(Color.decode("#EFCC00"));
        background.add(headerPanel);

        JLabel heading = new JLabel("BANK Management System");
        heading.setBounds(260, 10, 700, 70);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 42));
        headerPanel.add(heading);

        JLabel personDetails = new JLabel("Add Your Personal Details");
        personDetails.setFont(new Font("Railway", Font.BOLD, 32));
        personDetails.setBounds(280, 100, 500, 40);
        background.add(personDetails);

        int labelX = 100, fieldX = 300, y = 160, gap = 40;

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(labelX, y, 150, 25);
        background.add(nameLabel);
        nameTextField = new TextField();
        nameTextField.setBounds(fieldX, y, 300, 25);
        background.add(nameTextField);

        fnameLabel = new JLabel("Father's Name:");
        fnameLabel.setBounds(labelX, y += gap, 150, 25);
        background.add(fnameLabel);
        fnameTextField = new TextField();
        fnameTextField.setBounds(fieldX, y, 300, 25);
        background.add(fnameTextField);

        dBirth = new JLabel("Date Of Birth:");
        dBirth.setBounds(labelX, y += gap, 150, 25);
        background.add(dBirth);
        birthTextField = new TextField();
        birthTextField.setBounds(fieldX, y, 300, 25);
        background.add(birthTextField);

        email = new JLabel("Email Address:");
        email.setBounds(labelX, y += gap, 150, 25);
        background.add(email);
        emailTextField = new TextField();
        emailTextField.setBounds(fieldX, y, 300, 25);
        background.add(emailTextField);

        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(labelX, y += gap, 150, 25);
        background.add(addressLabel);
        addressTextField = new TextField();
        addressTextField.setBounds(fieldX, y, 300, 25);
        background.add(addressTextField);

        cityLabel = new JLabel("City:");
        cityLabel.setBounds(labelX, y += gap, 150, 25);
        background.add(cityLabel);
        cityTextField = new TextField();
        cityTextField.setBounds(fieldX, y, 300, 25);
        background.add(cityTextField);

        StateLabel = new JLabel("State:");
        StateLabel.setBounds(labelX, y += gap, 150, 25);
        background.add(StateLabel);
        stateTextField = new TextField();
        stateTextField.setBounds(fieldX, y, 300, 25);
        background.add(stateTextField);

        maritalLabel = new JLabel("Marital Status:");
        maritalLabel.setBounds(labelX, y += gap, 150, 25);
        background.add(maritalLabel);
        married = new JRadioButton("Married");
        unmarried = new JRadioButton("Unmarried");
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        married.setBounds(fieldX, y, 100, 25);
        unmarried.setBounds(fieldX + 120, y, 100, 25);
        background.add(married);
        background.add(unmarried);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(labelX, y += gap, 150, 25);
        background.add(genderLabel);
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        otherGender = new JRadioButton("Others");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(otherGender);
        male.setBounds(fieldX, y, 80, 25);
        female.setBounds(fieldX + 90, y, 80, 25);
        otherGender.setBounds(fieldX + 180, y, 80, 25);
        background.add(male);
        background.add(female);
        background.add(otherGender);

        back = new JButton("BACK");
        back.setBounds(300, y += gap + 20, 120, 35);
        back.addActionListener(this);
        background.add(back);

        next = new JButton("NEXT");
        next.setBounds(450, y, 120, 35);
        next.addActionListener(this);
        background.add(next);

        setVisible(true);
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public boolean checkcardno(String cardno) {
        try {
            DataConnection c = new DataConnection();
            ResultSet rs = c.s.executeQuery("SELECT * FROM MainTable WHERE cardno = '" + cardno + "'");
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void actionPerformed(ActionEvent ae) {
        Random ran = new Random();
        String cardno = "" + Math.abs((ran.nextLong() % 900L) + 504093L);
        while (checkcardno(cardno)) {
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
        int bal = 0;

        String gender = male.isSelected() ? "male" : female.isSelected() ? "female" : otherGender.isSelected() ? "other" : null;
        String marital = married.isSelected() ? "married" : unmarried.isSelected() ? "unmarried" : null;

        try {
            if (ae.getSource() == back) {
                setVisible(false);
                new login().setVisible(true);
            } else {
                if (name.isEmpty() || fName.isEmpty() || dob.isEmpty() || state.isEmpty() || city.isEmpty() || address.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter your details!");
                } else {
                    DataConnection con = new DataConnection();
                    String query = "INSERT INTO MainTable VALUES('" + cardno + "','" + name + "' , '" + fName
                            + "' , '" + dob + "' , '" + state + "' , '" + city + "'  ,'" + address + "' , '"
                            + email + "' , '" + gender + "' ,'" + marital + "','" + pin + "','" + bal + "')";
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "The 6 digit Account number generated for your account is " + getCardno() + " \nThe 4 digit pin generated for your account is " + pin);
                    setVisible(false);
                    new AddMoney(cardno);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
