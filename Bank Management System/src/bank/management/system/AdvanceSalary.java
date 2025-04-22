package bank.management.system;

//package bank.system;
import javax.swing.JOptionPane;

import java.awt.*;
import javax.swing.JFileChooser;
import static java.awt.Font.BOLD;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.lang.Double.parseDouble;

import java.nio.file.StandardCopyOption;
import java.util.logging.Filter;

import static java.lang.Integer.parseInt;

public class AdvanceSalary extends JFrame implements ActionListener {
    double installment=0;
    JComboBox repay;
    String[] Months_string ={"1 Months", "2 Months", "3 Months"};
    JRadioButton Saleried, Businessman,Simple;
    String salary_input,Address_1,Address_2,Address_3;
    ButtonGroup emp;
    JButton back, upload1, upload2, upload3,Final_enter;
    JPanel panel;
    JLabel intro, intro1,salary, months,document_request1,document_request2,document_request3;
    JTextField salary_textfield;

    File selectedFile2;
    File selectedFile1;
    File selectedFile3;
    int Months = 0;
    double N=0;


    AdvanceSalary(){
        //frame
        setSize(1550,800);
         setLayout(null);


        //panel
        panel=new JPanel();
        panel.setBounds(0,0,1550,80);
        String yellow="#EFCC00";
        panel.setBackground(Color.decode(yellow));
        panel.setLayout(null);
        add(panel);

        //MCS BANK label
        JLabel MCS=new JLabel("MCS BANK");
        MCS.setBounds(20,3,185,50);
        MCS.setForeground(Color.WHITE);
        Font font=new Font("Segoe UI", BOLD, 32);
        MCS.setFont(font);
        panel.add(MCS);



        //back button
        back=new JButton("Back");
        Font font1=new Font("Segoe UI", BOLD, 12);
        back.setFont(font1);
        back.setBounds(1450,20,50,25);
        back.setBackground(Color.decode(yellow));
        back.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        //intro label
        intro=new JLabel("     Advance Salary");
        Font font2=new Font("Segoe UI", BOLD, 30);
        intro.setFont(font2);
        intro.setBounds(550,130,300,50);
        intro.setForeground(Color.decode(yellow));
        add(intro);

        //intro1 label
        intro1=new JLabel("      Request your salary in Advance");
        Font font3=new Font("Segoe UI", BOLD, 30);
        intro1.setFont(font3);
        intro1.setBounds(435,175,700,50);
        intro1.setForeground(Color.decode(yellow));
        add(intro1);

        // Radio Button
//        JRadioButton salaried = new JRadioButton("Salaried");
        //salaried .setBounds();


        //income label


        salary =new JLabel("Monthly Salary");
        Font font5=new Font("Segoe UI", BOLD, 16);
        salary.setFont(font5);
        salary.setBounds(450,250,300,50);
        add(salary);




        //income text field
        salary_textfield =new JTextField();
        salary_textfield.setBounds(800,260,150,24);
        add(salary_textfield);

        months =new JLabel("Advance salary months (Max.3)");
        font5=new Font("Segoe UI", BOLD, 16);
        months.setFont(font5);
        months.setBounds(450,300,300,50);
        add(months);


        //repay dropdown
        repay=new JComboBox(Months_string);
        repay.setBounds(800,300, 150,30);
        add(repay);

        document_request1 =new JLabel("Upload Bank Statement of last 6 months");
        font5=new Font("Segoe UI", BOLD, 15);
        document_request1.setFont(font5);
        document_request1.setBounds(450,335,310,50);
        add(document_request1);

        //income_enter button
        upload1 =new JButton("Upload");
        Font font6=new Font("Segoe UI", BOLD, 18);
        upload1.setFont(font6);
        upload1.setBounds(800,350,120,25);
        upload1.setBackground(Color.decode(yellow));
        upload1.setForeground(Color.WHITE);
        upload1.addActionListener(this);
        add(upload1);

        document_request2 =new JLabel("Upload surety bond of campany ");
        font5=new Font("Segoe UI", BOLD, 16);
        document_request2.setFont(font5);
        document_request2.setBounds(450,370,300,50);
        add(document_request2);


        //loan_enter button
        upload2 =new JButton("Upload");
        upload2.setFont(font6);
        upload2.setBounds(800,385,120,25);
        upload2.setBackground(Color.decode(yellow));
        upload2.setForeground(Color.WHITE);
        upload2.addActionListener(this);
        add(upload2);



        document_request3 =new JLabel("Upload Salary slip of comapany");
        font5=new Font("Segoe UI", BOLD, 16);
        document_request3.setFont(font5);
        document_request3.setBounds(450,410,300,50);
        add(document_request3);



        upload3 =new JButton("Upload");
        upload3.setFont(font6);
        upload3.setBounds(800,430,120,25);
        upload3.setBackground(Color.decode(yellow));
        upload3.setForeground(Color.WHITE);
        upload3.addActionListener(this);
        add(upload3);

        Final_enter =new JButton("Enter");
        Final_enter.setFont(font6);
        Final_enter.setBounds(670,480,120,25);
        Final_enter.setBackground(Color.decode(yellow));
        Final_enter.setForeground(Color.WHITE);
        Final_enter.addActionListener(this);
        add(Final_enter);

        //view
        setVisible(true);

    }


public static void Message(int Months){
    JOptionPane.showMessageDialog(null, "Your request for" +Months+ " months advance Salary has been Submitted");

}
    public AdvanceSalary(String imageFiles, String img, String png) {
    }

    public void actionPerformed(ActionEvent ae) {
        //My account action

        if (ae.getSource() == back) {
            setVisible(false);
            new Facilities();
        } else if (ae.getSource() == upload1) {

            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "img", "png");
            fileChooser.setFileFilter(filter);
            int option = fileChooser.showOpenDialog(AdvanceSalary.this);
            if (option == JFileChooser.APPROVE_OPTION) {
                selectedFile1 = fileChooser.getSelectedFile();
                // Process the selected file here
                String sourceFilePath = selectedFile1.getAbsolutePath();
                String targetDirectoryPath = "C:\\Users\\ADMIN\\Desktop";

                File sourceFile = new File(sourceFilePath);
                File targetDirectory = new File(targetDirectoryPath);
                try {
                    // Create the target directory if it doesn't exist
                    if (!targetDirectory.exists()) {
                        targetDirectory.mkdirs();
                    }

                    // Specify the target file path
                    String targetFilePath = targetDirectoryPath + File.separator + sourceFile.getName();
                    File targetFile = new File(targetFilePath);

                    // Copy the file to the target directory
                    Path sourcePath = sourceFile.toPath();
                    Path targetPath = targetFile.toPath();
                    Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);

                } catch (IOException e) {
                    e.printStackTrace();
                }
//                System.out.println("Selected file: " + selectedFile1.getAbsolutePath());
            }
        } else if (ae.getSource() == upload2) {

            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "img", "png");
            fileChooser.setFileFilter(filter);
            int option = fileChooser.showOpenDialog(this); // Assuming this code is inside a Swing component

            if (option == JFileChooser.APPROVE_OPTION) {
                selectedFile2 = fileChooser.getSelectedFile();
                // Process the selected file here
                String sourceFilePath = selectedFile2.getAbsolutePath();
                String destinationDirectoryPath = "C:\\Users\\ADMIN\\Desktop";

                File sourceFile = new File(sourceFilePath);
                File destinationDirectory = new File(destinationDirectoryPath);
                try {
                    // Create the destination directory if it doesn't exist
                    if (!destinationDirectory.exists()) {
                        destinationDirectory.mkdirs();
                    }

                    // Specify the destination file path
                    String destinationFilePath = destinationDirectoryPath + File.separator + sourceFile.getName();
                    File destinationFile = new File(destinationFilePath);

                    // Copy the file to the destination directory
                    Path sourcePath = sourceFile.toPath();
                    Path destinationPath = destinationFile.toPath();
                    Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

                } catch (IOException e) {
                    e.printStackTrace();
                }
//                System.out.println("Selected file: " + selectedFile2.getAbsolutePath());
            }

        } else if (ae.getSource() == upload3) {

            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "img", "png");
            fileChooser.setFileFilter(filter);
            int option = fileChooser.showOpenDialog(AdvanceSalary.this);
            if (option == JFileChooser.APPROVE_OPTION) {
                selectedFile3 = fileChooser.getSelectedFile();
                // Process the selected file here
                String sourceFilePath = selectedFile3.getAbsolutePath();
                String destinationDirectoryPath = "C:\\Users\\ADMIN\\Desktop";

                File sourceFile = new File(sourceFilePath);
                File destinationDirectory = new File(destinationDirectoryPath);
                try {
                    // Create the destination directory if it doesn't exist
                    if (!destinationDirectory.exists()) {
                        destinationDirectory.mkdirs();
                    }

                    // Specify the destination file path
                    String destinationFilePath = destinationDirectoryPath + File.separator + sourceFile.getName();
                    File destinationFile = new File(destinationFilePath);

                    // Copy the file to the destination directory
                    Path sourcePath = sourceFile.toPath();
                    Path destinationPath = destinationFile.toPath();
                    Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

                } catch (IOException e) {
                    e.printStackTrace();
                }
//                System.out.println("Selected file: " + selectedFile3.getAbsolutePath());
            }


        } else if (ae.getSource() == Final_enter) {

            salary_input = salary_textfield.getText();
            N = parseDouble(salary_input);

            String selected = (String) repay.getSelectedItem();

            if (selected == Months_string[0]) {
                Months = 1;
            } else if (selected == Months_string[1]) {
                Months = 2;
            } else  {
                Months = 3;
            }
Message(Months);
            System.out.println("Hello world");
            Address_1 = selectedFile1.getAbsolutePath();
            Address_2 = selectedFile2.getAbsolutePath();
            Address_3 = selectedFile3.getAbsolutePath();

//            JOptionPane.showMessageDialog(null,"Your request for " + Months + " Salary has been Submitted");

        }
    }

    public static void main(String[] args) {
        new AdvanceSalary();
    }
}
