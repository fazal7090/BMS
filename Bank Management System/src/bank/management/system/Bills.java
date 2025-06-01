package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Bills extends JFrame implements ActionListener {
    private final String cardno;
    private final JButton backBtn, waterBtn, elecBtn, gasBtn, netBtn;

    public Bills(String cardno) {
        this.cardno = cardno;

        setTitle("Utility Bill Payments");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        JPanel header = new JPanel();
        header.setBounds(0, 0, 900, 70);
        header.setBackground(Color.decode("#EFCC00"));
        header.setLayout(null);
        add(header);

        JLabel title = new JLabel("MCS BANK");
        title.setFont(new Font("Segoe UI", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        title.setBounds(20, 15, 300, 40);
        header.add(title);

        backBtn = new JButton("Back");
        backBtn.setBounds(780, 20, 80, 30);
        backBtn.setBackground(Color.decode("#EFCC00"));
        backBtn.setForeground(Color.WHITE);
        backBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        backBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        backBtn.addActionListener(this);
        header.add(backBtn);

        // Utility buttons
        Font btnFont = new Font("Segoe UI", Font.BOLD, 20);
        Color bg = Color.decode("#f0ecec");

        waterBtn = new JButton("Water Bill");
        waterBtn.setBounds(100, 170, 200, 50);
        waterBtn.setFont(btnFont);
        waterBtn.setBackground(bg);
        waterBtn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        waterBtn.addActionListener(this);
        add(waterBtn);

        elecBtn = new JButton("Electricity Bill");
        elecBtn.setBounds(330, 170, 200, 50);
        elecBtn.setFont(btnFont);
        elecBtn.setBackground(bg);
        elecBtn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        elecBtn.addActionListener(this);
        add(elecBtn);

        gasBtn = new JButton("Gas Bill");
        gasBtn.setBounds(560, 170, 200, 50);
        gasBtn.setFont(btnFont);
        gasBtn.setBackground(bg);
        gasBtn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        gasBtn.addActionListener(this);
        add(gasBtn);

        netBtn = new JButton("Internet Bill");
        netBtn.setBounds(330, 280, 200, 50);
        netBtn.setFont(btnFont);
        netBtn.setBackground(bg);
        netBtn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        netBtn.addActionListener(this);
        add(netBtn);

        JLabel quote = new JLabel("Fast, secure, and hassle-free bill payments");
        quote.setFont(new Font("Segoe UI", Font.BOLD, 22));
        quote.setForeground(Color.decode("#EFCC00"));
        quote.setBounds(220, 520, 600, 40);
        add(quote);

        // Icons for each service
        try {
            JLabel waterIcon = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/icons/logo/water.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
            waterIcon.setBounds(170, 100, 60, 60);
            add(waterIcon);

            JLabel elecIcon = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/icons/logo/elec.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
            elecIcon.setBounds(400, 100, 60, 60);
            add(elecIcon);

            JLabel gasIcon = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/icons/logo/gas.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
            gasIcon.setBounds(630, 100, 60, 60);
            add(gasIcon);

            JLabel netIcon = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/icons/logo/net.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
            netIcon.setBounds(400, 210, 60, 60);
            add(netIcon);

            JLabel banner = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/icons/logo/BILL (2).png")).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
            banner.setBounds(300, 340, 300, 300);
            add(banner);

        } catch (Exception e) {
            System.out.println("Image loading failed: " + e.getMessage());
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            setVisible(false);
            new Branchless(cardno);
        } else if (e.getSource() == waterBtn) {
            JOptionPane.showMessageDialog(this, "Water Bill screen coming soon");
        } else if (e.getSource() == elecBtn) {
            JOptionPane.showMessageDialog(this, "Electricity Bill screen coming soon");
        } else if (e.getSource() == gasBtn) {
            JOptionPane.showMessageDialog(this, "Gas Bill screen coming soon");
        } else if (e.getSource() == netBtn) {
            JOptionPane.showMessageDialog(this, "Internet Bill screen coming soon");
        }
    }

    public static void main(String[] args) {
        new Bills("231234");
    }
}