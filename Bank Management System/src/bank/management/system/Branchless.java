package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

public class Branchless extends JFrame implements ActionListener {
    private final JPanel headerPanel;
    private final JButton backBtn, billsBtn, mobileBtn;
    private final String cardno;

    public Branchless(String cardno) {
        this.cardno = cardno;

        setTitle("Branchless Banking");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        // Header panel
        headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 900, 70);
        headerPanel.setBackground(Color.decode("#EFCC00"));
        headerPanel.setLayout(null);
        add(headerPanel);

        JLabel title = new JLabel("MCS BANK");
        title.setFont(new Font("Segoe UI", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        title.setBounds(20, 15, 300, 40);
        headerPanel.add(title);

        backBtn = new JButton("Back");
        backBtn.setBounds(780, 20, 80, 30);
        backBtn.setBackground(Color.decode("#EFCC00"));
        backBtn.setForeground(Color.WHITE);
        backBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        backBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        backBtn.addActionListener(this);
        headerPanel.add(backBtn);

        // Utility Bills button
        billsBtn = new JButton("Utility Bills");
        billsBtn.setBounds(180, 400, 220, 50);
        billsBtn.setFont(new Font("Segoe UI", Font.BOLD, 22));
        billsBtn.setBackground(Color.decode("#f0ecec"));
        billsBtn.setForeground(Color.BLACK);
        billsBtn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        billsBtn.addActionListener(this);
        add(billsBtn);

        // Mobile Packages button
        mobileBtn = new JButton("Mobile Packages");
        mobileBtn.setBounds(480, 400, 250, 50);
        mobileBtn.setFont(new Font("Segoe UI", Font.BOLD, 22));
        mobileBtn.setBackground(Color.decode("#f0ecec"));
        mobileBtn.setForeground(Color.BLACK);
        mobileBtn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        mobileBtn.addActionListener(this);
        add(mobileBtn);

        // Images
        try {
            ImageIcon billIcon = new ImageIcon(getClass().getResource("/icons/logo/BILL.png"));
            Image billImage = billIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            JLabel billLabel = new JLabel(new ImageIcon(billImage));
            billLabel.setBounds(200, 160, 200, 200);
            add(billLabel);

            ImageIcon mobileIcon = new ImageIcon(getClass().getResource("/icons/logo/mobile.png"));
            Image mobileImage = mobileIcon.getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH);
            JLabel mobileLabel = new JLabel(new ImageIcon(mobileImage));
            mobileLabel.setBounds(510, 150, 220, 220);
            add(mobileLabel);
        } catch (Exception e) {
            System.out.println("Image not found: " + e.getMessage());
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backBtn) {
            setVisible(false);
            new Facilities(cardno);
        } else if (ae.getSource() == billsBtn) {
            setVisible(false);
            new Bills(cardno);
        } else if (ae.getSource() == mobileBtn) {
            setVisible(false);
            new MobPackage();
        }
    }

    public static void main(String[] args) {
        new Branchless("231234");
    }
}