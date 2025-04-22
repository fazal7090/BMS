package bank.management.system;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DecimalFormat;

class CurrencyConversion extends JFrame implements ActionListener {
    private final JButton back;
    JPanel setBar;
    private final JTextField amountField;
    private final JTextField amountField2;
    private final JTextField amountField3;
    private final JTextField purposeField;
    private final  JComboBox<String> fromCurrencyComboBox;
    private final JComboBox<String> toCurrencyComboBox;
    private final JComboBox<String> toCountry;
    private final JButton convertButton;
    private final JButton transferButton;
    private final JLabel resultLabel;
    private final JLabel exchangerate;
    private final JLabel transferredAmount;
    private final JLabel exchangeRate;
    private final JPanel panel1;
    private final JPanel panel2;
    private final JLabel purpose;
    String placeholder1 = "Transfer Purpose";
    String yellow = "#EFCC00";
    boolean isAmountFieldselected;
    boolean isAmountField1selected;
    double transferAmount = 0;
    Connection connection;
    CurrencyConversion(){

        try {
            // Establishing database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost/bankmanagementsystem", "root", "11111");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        panel1 = new JPanel();
        panel1.setBackground(Color.white);
        panel1.setLayout(null);

        panel2 = new JPanel();
        panel2.setBackground(Color.white);
        panel2.setLayout(null);

//        Increase border thickness and title size
        Border border1 = BorderFactory.createLineBorder(Color.darkGray, 2);
        TitledBorder titledBorder1 = BorderFactory.createTitledBorder(border1, "Currency Converter", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION);
        titledBorder1.setTitleFont(titledBorder1.getTitleFont().deriveFont(Font.PLAIN, 18f)); // Increase the title size
        panel1.setBorder(titledBorder1);
        panel1.setBounds(315, 226, 380, 400);

        Border border2 = BorderFactory.createLineBorder(Color.darkGray, 2);
        TitledBorder titledBorder2 = BorderFactory.createTitledBorder(border2, "International Transfer", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION);
        titledBorder2.setTitleFont(titledBorder2.getTitleFont().deriveFont(Font.PLAIN, 18f)); // Increase the title size
        panel2.setBorder(titledBorder2);
        panel2.setBounds(800, 226, 380, 400);

        JLabel amount = new JLabel("Amount: ");
        amount.setFont(new Font("Sogoe UI", Font.PLAIN, 25));
        amount.setBounds(50, 60, 170, 25);
        panel1.add(amount);

        amountField = new JTextField(10);
        amountField.setBounds(200, 65, 100, 23);
        panel1.add(amountField);

        JLabel from = new JLabel("From: ");
        from.setFont(new Font("Sogoe UI", Font.PLAIN, 25));
        from.setBounds(50, 110, 75, 25);
        panel1.add(from);

        fromCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "PKR", "GBP"});
        fromCurrencyComboBox.setFont(new Font("Arial",Font.PLAIN,13));
        fromCurrencyComboBox.setBackground(Color.white);
        fromCurrencyComboBox.setForeground(Color.BLACK);
        fromCurrencyComboBox.setFocusable(false);
        fromCurrencyComboBox.setEditable(false);
        fromCurrencyComboBox.setBounds(200, 115, 80, 19);
        panel1.add(fromCurrencyComboBox);

        JLabel to = new JLabel("To: ");
        to.setFont(new Font("Sogoe UI", Font.PLAIN, 25));
        to.setBounds(50, 160, 50, 25);
        panel1.add(to);

        toCurrencyComboBox = new JComboBox<>(new String[]{"EUR", "GBP", "PKR", "USD"});
        toCurrencyComboBox.setFont(new Font("Arial",Font.PLAIN,13));
        toCurrencyComboBox.setBackground(Color.white);
        toCurrencyComboBox.setForeground(Color.BLACK);
        toCurrencyComboBox.setFocusable(false);
        toCurrencyComboBox.setEditable(false);
        toCurrencyComboBox.setBounds(200, 165, 80, 19);
        panel1.add(toCurrencyComboBox);

        convertButton = new JButton("Convert");
        convertButton.setBounds(150, 210, 90, 27);
        convertButton.setFocusable(false);
        convertButton.setToolTipText("Convert currency");
        convertButton.setBorder(null);
        convertButton.setFocusPainted(true);
        convertButton.setBackground(Color.decode(yellow));
        convertButton.setForeground(Color.white);
        convertButton.setFont(new Font("Segoe UI",Font.BOLD,20));
        convertButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        convertButton.addActionListener(e -> convertCurrency());
        panel1.add(convertButton);

        exchangerate  = new JLabel();
        exchangerate.setBounds(40,260,400,50);
        exchangerate.setFont(new Font("Calibri", Font.BOLD, 20));
        panel1.add(exchangerate);

        resultLabel = new JLabel();
        resultLabel.setBounds(40, 300, 500, 50);
        resultLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        panel1.add(resultLabel);

        JLabel amount2 = new JLabel("Amount(Rs):");
        amount2.setFont(new Font("Sogoe UI", Font.PLAIN, 25));
        amount2.setBounds(50, 40, 170, 25);
        panel2.add(amount2);

        amountField2 = new JTextField(10);
        amountField2.setBounds(220, 45, 100, 23);
        panel2.add(amountField2);

        JLabel country = new JLabel("Country: ");
        country.setFont(new Font("Sogoe UI", Font.PLAIN, 25));
        country.setBounds(50, 90, 105, 25);
        panel2.add(country);

        toCountry = new JComboBox<>(new String[]{"SriLanka","Bangladesh","Nepal","Iran"});
        toCountry.setFont(new Font("Arial",Font.PLAIN,13));
        toCountry.setBackground(Color.white);
        toCountry.setForeground(Color.BLACK);
        toCountry.setFocusable(false);
        toCountry.setBounds(220, 95, 100, 20);
        panel2.add(toCountry);

        JLabel To = new JLabel("Account #");
        To.setFont(new Font("Sogoe UI", Font.PLAIN, 25));
        To.setBounds(50, 143, 120, 25);
        panel2.add(To);

        amountField3 = new JTextField(15);
        amountField3.setBounds(220, 145, 120, 23);
        panel2.add(amountField3);

        purpose = new JLabel("Description");
        purpose.setFont(new Font("Sogoe UI",Font.PLAIN,25));
        purpose.setBounds(50,200,140,23);
        panel2.add(purpose);

        purposeField = new JTextField(10);
        purposeField.setBounds(220,200,120,25);
        purposeField.setForeground(Color.gray);
        purposeField.setText(placeholder1);
        purposeField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (purposeField.getText().equals(placeholder1)) {
                    purposeField.setText("");
                    purposeField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (purposeField.getText().isEmpty()) {
                    purposeField.setText(placeholder1);
                    purposeField.setForeground(Color.GRAY);
                }
            }
        });
        panel2.add(purposeField);

        transferButton = new JButton("Next");
        transferButton.setBounds(150, 250, 90, 27);
        transferButton.setFocusable(false);
        transferButton.setToolTipText("Send Money");
        transferButton.setBorder(null);
        transferButton.setFocusPainted(true);
        transferButton.setBackground(Color.decode(yellow));
        transferButton.setForeground(Color.white);
        transferButton.setFont(new Font("Segoe UI",Font.BOLD,20));
        transferButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        transferButton.addActionListener(this);
        transferButton.addActionListener(e -> transferAmount());
        panel2.add(transferButton);

        exchangeRate  = new JLabel();
        exchangeRate.setBounds(40,280,400,50);
        exchangeRate.setFont(new Font("Calibri", Font.BOLD, 20));
        panel2.add(exchangeRate);

        transferredAmount = new JLabel();
        transferredAmount.setBounds(40, 320, 500, 50);
        transferredAmount.setFont(new Font("Calibri", Font.BOLD, 20));
        panel2.add(transferredAmount);

        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.decode(yellow));
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.setFont(new Font("Segoe UI",Font.BOLD,19));
        back.setBounds(1400,25,80,30);
        back.setBorder(BorderFactory.createLineBorder(Color.white));
        back.setFocusable(false);
        back.setToolTipText("Back to previous page");
        back.addActionListener(this);

        JLabel setTopic = new JLabel("MCS Bank");
        setTopic.setBounds(20,20,210,45);
        setTopic.setFont(new Font("Segoe UI",Font.BOLD,35));
        setTopic.setForeground(Color.white);

        setBar = new JPanel();
        setBar.setBounds(0,0,1920,90);
        setBar.setBackground(Color.decode(yellow));
        setBar.setLayout(null);
        setBar.add(setTopic);

        JFrame frame = new JFrame();

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("MCS Bank");
        frame.setSize(1800,1080);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.white);
        frame.add(back);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(setBar);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Facilities();
        }
    }
    private void convertCurrency() {
        double amount = Double.parseDouble(amountField.getText());
        String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
        String toCurrency = (String) toCurrencyComboBox.getSelectedItem();

        if (fromCurrency.equals(toCurrency)) {
            resultLabel.setText("Enter different currencies!");
            return;
        }

        try {
            // Prepare the SQL query
            String query = "SELECT exchange_rate FROM diff_country_exchange_rates WHERE to_country = ? AND from_country = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Set the parameters
            statement.setString(1, toCurrency);
            statement.setString(2, fromCurrency);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if a result is obtained
            if (resultSet.next()) {
                double result = 0;
                double exchange = 0;
                // Retrieve the exchange rate from the result set
                exchange = resultSet.getDouble("exchange_rate");
                result = amount * exchange;
                DecimalFormat df = new DecimalFormat("#.##");
                exchangerate.setText("Exchange Rate: " + df.format(result));
                resultLabel.setText(amount + " " + fromCurrency + " = " + df.format(result) + " "+ toCurrency);
            } else {
                // Handle case when no exchange rate is found
                resultLabel.setText("Not found");
                connection.close();  // Close the database connection
                return;
            }

            // Close the database connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkBalance(int userId, double amount) {
        // Step 1: Establish database connection
        try {
            // Step 2: Prepare SQL statement
            String sql = "SELECT balance FROM Balance WHERE acc_no = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, userId);

            // Step 3: Execute the query
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Step 4: Get the user's balance from the result set
                double balance = rs.getDouble("balance");

                // Step 5: Check if the balance is enough for the transfer
                if (balance >= amount) {
                    return true; // Balance is sufficient
                } else {
                    return false; // Balance is not sufficient
                }
            } else {
                // User with the given ID not found
                System.out.println("User not found");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
        private void transferAmount() {
        String toSelectedCountry = (String) toCountry.getSelectedItem();

        if (toSelectedCountry.isEmpty() || purposeField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a country and enter the purpose of transfer.");
            return;
        }

        double amountToTransfer = Double.parseDouble(amountField2.getText());
        int cardno = Integer.parseInt(CardNo.cardno);
        if(checkBalance(cardno,amountToTransfer)){
             try {
            String sql = "INSERT INTO transfers (sent_by,country, amount, purpose, sent_to) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            //put account number of user
            statement.setString(1, CardNo.cardno);
            statement.setString(2, toSelectedCountry);
            statement.setDouble(3, amountToTransfer);
            statement.setString(4, purposeField.getText());
            statement.setString(5,amountField3.getText());
            statement.executeUpdate();
            double amount = (Double)getExchangeRate(toSelectedCountry);
            exchangeRate.setText("1 PKR = " + getExchangeRate(toSelectedCountry) + " " + toSelectedCountry);
            transferredAmount.setText("Trsnsferred Amount: "+ String.valueOf(amountToTransfer*amount) + toSelectedCountry);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }else{
            JOptionPane.showMessageDialog(null, "Insufficient balance for this transaction");
            return;
        }
       
    }
    private double getExchangeRate(String country) {
        double exchangeRate = 0;

        // Fetch the exchange rate from the database based on the country
        try {
            String sql = "SELECT exchange_rate FROM exchange_rates WHERE to_country = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, country);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                exchangeRate = resultSet.getDouble("exchange_rate");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DecimalFormat df = new DecimalFormat("#.#####");
        df.format(exchangeRate);
        
        return exchangeRate;
    }
}
