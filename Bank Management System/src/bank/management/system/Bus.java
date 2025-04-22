package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.BOLD;

public class Bus extends JFrame implements ActionListener  {
    JButton back, search;
    JComboBox departure,arrival;

    String[] departure_string ={"LAHORE", "ISB/RWP", "KARACHI", "PESHAWAR"};
    String[] arrival_string ={"LAHORE", "ISB/RWP", "KARACHI", "PESHAWAR"};

    JPanel panel;
    JLabel intro, intro1,departure_label,to_label,arrival_label;


Bus() {
    setSize(700, 500);
    setLocation(300, 100);
    setLayout(null);
    setResizable(false);

    //panel
    panel = new JPanel();
    panel.setBounds(0, 0, 700, 53);
    String yellow = "#EFCC00";
    panel.setBackground(Color.decode(yellow));
    panel.setLayout(null);
    add(panel);

    //MCS BANK label
    JLabel MCS = new JLabel("MCS BANK");
    MCS.setBounds(20, 0, 185, 50);
    MCS.setForeground(Color.WHITE);
    Font font = new Font("Segoe UI", BOLD, 32);
    MCS.setFont(font);
    panel.add(MCS);




    //back button
    back = new JButton("Back");
    Font font1 = new Font("Segoe UI", BOLD, 12);
    back.setFont(font1);
    back.setBounds(600, 12, 50, 25);
    back.setBackground(Color.decode(yellow));
    back.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    back.setForeground(Color.WHITE);
    back.addActionListener(this);
    panel.add(back);

    //intro label
    intro = new JLabel("Ticket Reservation");
    Font font2 = new Font("Segoe UI", BOLD, 30);
    intro.setFont(font2);
    intro.setBounds(230, 60, 300, 50);
    intro.setForeground(Color.decode(yellow));
    add(intro);

    //intro1 label
    intro1 = new JLabel("      Book your ticket with us from home");
    Font font3 = new Font("Segoe UI", BOLD, 30);
    intro1.setFont(font3);
    intro1.setBounds(55, 95, 700, 50);
    intro1.setForeground(Color.decode(yellow));
    add(intro1);

    Font font5;
    departure_label =new JLabel("Departure");
    font5=new Font("Segoe UI", BOLD, 16);
    departure_label.setFont(font5);
    departure_label.setBounds(160,160,300,50);
    add(departure_label);

    departure =new JComboBox(departure_string);
    departure.setBounds(160,200, 150,30);
    add(departure);

    to_label =new JLabel("To");
    font5=new Font("Segoe UI", BOLD, 16);
    to_label.setFont(font5);
    to_label.setBounds(340,190,300,50);
    add(to_label);

    arrival_label =new JLabel("Arrival");
    font5=new Font("Segoe UI", BOLD, 16);
    arrival_label.setFont(font5);
    arrival_label.setBounds(380,160,300,50);
    add(arrival_label);

    arrival =new JComboBox(arrival_string);
    arrival.setBounds(380,200, 150,30);
    add(arrival);

    search =new JButton("Search");
    Font font6=new Font("Segoe UI", BOLD, 18);

    search.setFont(font6);
    search.setBounds(285,270,120,25);
    search.setBackground(Color.decode(yellow));
    search.setForeground(Color.WHITE);
    search.addActionListener(this);
    add(search);

    setVisible(true);


}


    @Override
    public void actionPerformed(ActionEvent ae) {
        //My account action
        if(ae.getSource()==back) {
            setVisible(false);
            new TicketReservation();
        } else if (ae.getSource()==search) {

            String departureselected = (String) departure.getSelectedItem();
            String arrivalselected = (String) arrival.getSelectedItem();

            if(departureselected== departure_string[0] && arrivalselected==arrival_string[0]){
             JOptionPane.showMessageDialog(null,"Please select different arrival and deparure");
            }
            else if(departureselected== departure_string[1] && arrivalselected==arrival_string[1]){
                JOptionPane.showMessageDialog(null,"Please select different arrival and deparure");
            }
            else if(departureselected== departure_string[2] && arrivalselected==arrival_string[2]){
                JOptionPane.showMessageDialog(null,"Please select different arrival and deparure");
            }
            else if(departureselected== departure_string[3] && arrivalselected==arrival_string[3]){
                JOptionPane.showMessageDialog(null,"Please select different arrival and deparure");
            }
            else if(departureselected== departure_string[0] && arrivalselected==arrival_string[1]){
                new Tickets();

            }
//            else if(departureselected== departure_string[0] && arrivalselected==arrival_string[2]){
//                new Tickets2();
//
//            }
        }

    }

    public static void bus(String[] args){
    new Bus();
}


}
