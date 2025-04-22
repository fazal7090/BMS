package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.BOLD;




public class Tickets extends JFrame implements ActionListener {


    JButton back,buy1,buy2,buy3;
    JPanel panel2;

    JPanel panel;

    Tickets(){
        setSize(400, 500);
        setLocation(300, 100);
        setLayout(null);
        setResizable(false);

        //panel
        panel = new JPanel();
        panel.setBounds(0, 0, 400, 53);
        String yellow = "#EFCC00";
        panel.setBackground(Color.decode(yellow));
        panel.setLayout(null);
        add(panel);

        //MCS BANK label
        JLabel MCS = new JLabel("MCS BANK");
        MCS.setBounds(20, 0, 140, 50);
        MCS.setForeground(Color.WHITE);
        Font font = new Font("Segoe UI", BOLD, 22);
        MCS.setFont(font);
        panel.add(MCS);




        //back button
        back = new JButton("Back");
        Font font1 = new Font("Segoe UI", BOLD, 12);
        back.setFont(font1);
        back.setBounds(300, 12, 50, 25);
        back.setBackground(Color.decode(yellow));
        back.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 72, 400, 2);
        panel2.setBackground(Color.BLACK);
        panel2.setLayout(null);
        add(panel2);


        JLabel daewoo=new JLabel("DAEWOO");
        Font font5=new Font("Segoe UI", BOLD, 16);
        daewoo.setFont(font5);
//        daewoo.setForeground(Color.WHITE);
        daewoo.setBounds(10,60,300,50);
        add(daewoo);

        JLabel daewoo_price=new JLabel("Rs.2000");
        daewoo_price.setFont(font5);
        daewoo_price.setBounds(10,80,300,50);
        add(daewoo_price);

        buy1 = new JButton("Buy");
        buy1.setFont(font1);
        buy1.setBounds(300, 80, 50, 25);
        buy1.setBackground(Color.decode(yellow));
        buy1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        buy1.setForeground(Color.WHITE);
        buy1.addActionListener(this);
        add(buy1);

        JPanel line2 = new JPanel();
        line2.setBounds(0, 120, 400, 2);
        line2.setBackground(Color.BLACK);
        line2.setLayout(null);
        add(line2);




        JLabel faisalmover=new JLabel("Faisal Mover");
        faisalmover.setFont(font5);
        faisalmover.setBounds(10,110,300,50);
        add(faisalmover);

        JLabel faisalmover_price=new JLabel("Rs.1800");
        faisalmover_price.setFont(font5);
        faisalmover_price.setBounds(10,130,300,50);
        add(faisalmover_price);

        buy2 = new JButton("Buy");
        buy2.setFont(font1);
        buy2.setBounds(300, 135, 50, 25);
        buy2.setBackground(Color.decode(yellow));
        buy2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        buy2.setForeground(Color.WHITE);
        buy2.addActionListener(this);
        add(buy2);

        JPanel line3 = new JPanel();
        line3.setBounds(0, 168, 400, 2);
        line3.setBackground(Color.BLACK);
        line3.setLayout(null);
        add(line3);

        JLabel roadmaster=new JLabel("Road Master");
        roadmaster.setFont(font5);
        roadmaster.setBounds(10,155,300,50);
        add(roadmaster);

        JLabel roadmaster_price=new JLabel("Rs.1900");
        roadmaster_price.setFont(font5);
        roadmaster_price.setBounds(10,175,300,50);
        add(roadmaster_price);

        buy3 = new JButton("Buy");
        buy3.setFont(font1);
        buy3.setBounds(300, 180, 50, 25);
        buy3.setBackground(Color.decode(yellow));
        buy3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        buy3.setForeground(Color.WHITE);
        buy3.addActionListener(this);
        add(buy3);

        JPanel line4 = new JPanel();
        line4.setBounds(0, 213, 400, 2);
        line4.setBackground(Color.BLACK);
        line4.setLayout(null);
        add(line4);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
if(ae.getSource()==back){
    setVisible(false);
    new Bus();

} else if (ae.getSource()==buy1) {
    JOptionPane.showMessageDialog(null,"Ticket bought successfully");
}
else if (ae.getSource()==buy2) {
    JOptionPane.showMessageDialog(null,"Ticket bought successfully");
}
else if (ae.getSource()==buy3) {
    JOptionPane.showMessageDialog(null,"Ticket bought successfully");
}
    }
    public static void Tickets(String[] args){
        new Tickets();
    }
}
