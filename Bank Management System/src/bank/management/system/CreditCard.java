package bank.management.system;
import javax.swing.*;
import java.awt.*;//for dealing with images
import java.awt.event.*;


public class CreditCard extends JFrame implements ActionListener {
    JButton platinum,gold,pink,visa,Back;
    JPanel panel;
    String accno;
    CreditCard(String cardno){
        accno=cardno;
setLayout(null);//the program will be run with custom layout (line 19) othrwise will be run with border
        //layout always centered
    //     JPanel npanel=new JPanel();
         setTitle("ATM");
            getContentPane().setBackground(Color.white);
       setSize(1350,700);//size of frame
       setVisible(true);// for the pupose that frame is visible
       setLocation(50,50);// changing location of frame as originally it is going to open 
    //from top left (350 from left ,200 from top)
    
    
    //    npanel.setSize(900,630);
      //  npanel.setBounds(0,70,900,700);
      // npanel.setBackground(Color.WHITE);
        setResizable(true);
     // add(npanel);
        
        //panel
        panel=new JPanel();
        panel.setBounds(0,0,1350,70);
        String yellow="#EFCC00";
        panel.setBackground(Color.decode(yellow));
        panel.setLayout(null);
        add(panel);
        
        //MCS BANK text field
        JLabel MCS=new JLabel("MCS BANK");
        MCS.setBounds(40,0,200,60);
        MCS.setForeground(Color.WHITE);
        Font font=new Font("Segoe UI", Font.BOLD, 32);
        MCS.setFont(font);
        panel.add(MCS);
        
        // CREDIT CARD LABEL
        Back=new JButton("BACK");
        Back.setBounds(1100,20,200,32);
        Back.setBackground(Color.decode(yellow));
        Back.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Back.setForeground(Color.WHITE);
        Back.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Back.setFont(font);
        Back.addActionListener(this);
        panel.add(Back);
             
         JLabel label3=new JLabel("Which card do you want to apply for ?");
        label3.setBounds(40, 80, 1100, 40);
        label3.setFont(font);
        add(label3);
        
    
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/g6.PNG"));// importing 
        //image from another class
        Image i2=i1.getImage().getScaledInstance(400, 180,Image.SCALE_DEFAULT);//for setting h,w,l otherwise will be very Large
        ImageIcon i3 = new ImageIcon(i2);//we are converting iage into imageicon bec jlabel cant work with image
         JLabel label=new JLabel(i3);// imagesicon cant be directly placed on frames so passing it in jlabel
       // and then placing it  on frame
        label.setBounds(50, 180, 410, 190);//for setting the loc of image otherwise will be centered
        //1st arg horiontal distance from frame 2nd arg vertical dis from fram ,3rd 4th l anh h of image as passed in line 13
        add(label);//adding image on to frame after convertingit in obj of jlabel
        
         ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/gr14.JPG"));// importing 
        //image from another class
        Image i5=i4.getImage().getScaledInstance(330, 165,Image.SCALE_DEFAULT);//for setting h,w,l otherwise will be very Large
        ImageIcon i6 = new ImageIcon(i5);//we are converting iage into imageicon bec jlabel cant work with image
         JLabel label1=new JLabel(i6);// imagesicon cant be directly placed on frames so passing it in jlabel
       // and then placing it  on frame
        label1.setBounds(490, 190, 325, 165);//for setting the loc of image otherwise will be centered
        //1st arg horiontal distance from frame 2nd arg vertical dis from fram ,3rd 4th l anh h of image as passed in line 13
        add(label1);//adding image on to frame after convertingit in obj of jlabel
        
          ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icons/G5.PNG"));// importing 
        //image from another class
        Image i8=i7.getImage().getScaledInstance(400, 215,Image.SCALE_DEFAULT);//for setting h,w,l otherwise will be very Large
        ImageIcon i9 = new ImageIcon(i8);//we are converting iage into imageicon bec jlabel cant work with image
         JLabel label2=new JLabel(i9);// imagesicon cant be directly placed on frames so passing it in jlabel
               label2.setBounds(50, 400, 410, 215);//for setting the loc of image otherwise will be centered

        //1st arg horiontal distance from frame 2nd arg vertical dis from fram ,3rd 4th l anh h of image as passed in line 13
        add(label2);//adding image on to frame after convertingit in obj of jlabel
        
         ImageIcon i13=new ImageIcon(ClassLoader.getSystemResource("icons/i4.JPG"));// importing 
        //image from another class
        Image i14=i13.getImage().getScaledInstance(510, 230,Image.SCALE_DEFAULT);//for setting h,w,l otherwise will be very Large
        ImageIcon i15 = new ImageIcon(i14);//we are converting iage into imageicon bec jlabel cant work with image
         JLabel label5=new JLabel(i15);// imagesicon cant be directly placed on frames so passing it in jlabel
               label5.setBounds(400, 390, 510, 230);//for setting the loc of image otherwise will be centered
          add(label5);
        
        
         ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icons/crecar.PNG"));// importing 
        //image from another class
        Image i11=i10.getImage().getScaledInstance(400, 450,Image.SCALE_DEFAULT);//for setting h,w,l otherwise will be very Large
        ImageIcon i12 = new ImageIcon(i11);//we are converting iage into imageicon bec jlabel cant work with image
         JLabel label4=new JLabel(i12);// imagesicon cant be directly placed on frames so passing it in jlabel
       // and then placing it  on frame
                label4.setBounds(900, 170, 410, 450);//for setting the loc of image otherwise will be centered

        //1st arg horiontal distance from frame 2nd arg vertical dis from fram ,3rd 4th l anh h of image as passed in line 13
        add(label4);//adding image on to frame after convertingit in obj of jlabel
        
         
          
          platinum = new JButton("MCS BANK PLATINUM CREDIT");
        platinum.setBackground(Color.DARK_GRAY);
        platinum.setForeground(Color.WHITE);
        platinum.setFont(new Font("Arial", Font.BOLD, 14));
        platinum.setBounds(120,370,250,28);
        add(platinum);
       platinum.addActionListener(this);
      
        gold = new JButton("MCS BANK GOLD CREDIT");
        gold.setBackground(Color.DARK_GRAY);
        gold.setForeground(Color.WHITE);
        gold.setFont(new Font("Arial", Font.BOLD, 14));
        gold.setBounds(530,370,250,28);
        add(gold);
               gold.addActionListener(this);

        
         pink = new JButton("MCS BANK PINK CREDIT");
        pink.setBackground(Color.DARK_GRAY);
        pink.setForeground(Color.WHITE);
        pink.setFont(new Font("Arial", Font.BOLD, 14));
        pink.setBounds(120,620,250,28);
        add(pink);               
        pink.addActionListener(this);

        
        visa = new JButton("MCS BANK VISA CREDIT");
        visa.setBackground(Color.DARK_GRAY);
        visa.setForeground(Color.WHITE);
        visa.setFont(new Font("Arial", Font.BOLD, 14));
        visa.setBounds(530,620,250,28);
        add(visa);
        visa.addActionListener(this);

    }    
    
    
public void actionPerformed(ActionEvent ae)
{
    if ( ae.getSource()==Back)
    {
        setVisible(false);
        new Facilities(accno);
          
    }
    else if ( ae.getSource()==platinum)
    {
        setVisible(false);
           new platinum(accno);
    }
    else if ( ae.getSource()==gold)
    {
        setVisible(false);
           new Gold (accno);
    }
    else if ( ae.getSource()==pink)
    {
        setVisible(false);
           new Pink(accno);
    }
    else if ( ae.getSource()==visa)
    {
        setVisible(false);
           new Visa(accno);
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CreditCard a=new CreditCard("11");
    }
    
    
}