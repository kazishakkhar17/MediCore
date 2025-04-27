package medi.core;

import javax.management.Notification;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {

    Reception(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1525,670);
        panel.setBackground(new Color(179, 250, 143));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1525,150);
        panel1.setBackground(new Color(179, 250, 143));
        add(panel1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/doctor.png"));
        Image image = i1.getImage().getScaledInstance(240,240,Image.SCALE_DEFAULT);
        ImageIcon i2= new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(1300,0,250,250);
        panel1.add(label);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/ambulence.png"));
        Image image1 = i11.getImage().getScaledInstance(200, 180, Image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon(image1);
        JLabel label1 = new JLabel(i22);
        label1.setBounds(1190, 50, 150, 60); // shifted right, and made smaller
        panel1.add(label1);


        JButton btn1 = new JButton("Add New Patient");
        btn1.setBounds(30,15,200,30);
        btn1.setBackground(new Color(245, 255, 137));
        panel1.add(btn1);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NEW_PATIENT();

            }
        });

        JButton btn2 = new JButton("Room");
        btn2.setBounds(30,58,200,30);
        btn2.setBackground(new Color(245, 255, 137));
        panel1.add(btn2);

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();

            }
        });

        JButton btn3 = new JButton("Medical Department");
        btn3.setBounds(30,100,200,30);
        btn3.setBackground(new Color(245, 255, 137));
        panel1.add(btn3);

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Medical_Department();

            }
        });

        JButton btn4 = new JButton("All Employee Info");
        btn4.setBounds(270,15,200,30);
        btn4.setBackground(new Color(245, 255, 137));
        panel1.add(btn4);

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee_info();
            }
        });

        JButton btn5 = new JButton("Patient Info");
        btn5.setBounds(270,58,200,30);
        btn5.setBackground(new Color(245, 255, 137));
        panel1.add(btn5);

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new ALL_Patient_Info();
            }
        });

        JButton btn6 = new JButton("Patient Discharge");
        btn6.setBounds(270,100,200,30);
        btn6.setBackground(new Color(245, 255, 137));
        panel1.add(btn6);

        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new patient_discharge();
            }
        });

        JButton btn7 = new JButton("Update Patient Details");
        btn7.setBounds(510,15,200,30);
        btn7.setBackground(new Color(245, 255, 137));
        panel1.add(btn7);

        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new update_patient_details();
            }
        });

        JButton btn8 = new JButton("IUT Ambulance");
        btn8.setBounds(510,58,200,30);
        btn8.setBackground(new Color(245, 255, 137));
        panel1.add(btn8);

        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulance();
            }
        });

        // Search Room Button
        JButton btn9 = new JButton("Search Room");
        btn9.setBounds(510,100,200,30);
        btn9.setBackground(new Color(245, 255, 137));
        panel1.add(btn9);

        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchRoom(); // Opens the SearchRoom screen
            }
        });

// Logout Button
        JButton btn10 = new JButton("Logout");
        btn10.setBounds(750,15,200,30);
        btn10.setBackground(new Color(245, 255, 137));
        panel1.add(btn10);

        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Close the Reception screen
                new Login(); // Redirect to the Login screen
            }
        });


        JButton btn11 = new JButton("Appointment");
        btn11.setBounds(750,58,200,30);
        btn11.setBackground(new Color(245, 255, 137));
        panel1.add(btn11);

        btn11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Appointment();

            }
        });

        JButton btn12 = new JButton("Notification");
        btn12.setBounds(750,100,200,30);
        btn12.setBackground(new Color(245, 255, 137));
        panel1.add(btn12);

        btn12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NotificationInfo();

            }
        });

        JButton btn13 = new JButton("Bill Breakdown");
        btn13.setBounds(990,15,200,30);
        btn13.setBackground(new Color(245, 255, 137));
        panel1.add(btn13);

        btn13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BillBreakdown();

            }
        });

        JButton btn14 = new JButton("View Discharge Info");
        btn14.setBounds(990,57,200,30);
        btn14.setBackground(new Color(245, 255, 137));
        panel1.add(btn14);

        btn14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ALL_Discharge_Info();

            }
        });

        JButton btn15 = new JButton("Reports");
        btn15.setBounds(990,99,200,30);
        btn15.setBackground(new Color(245, 255, 137));
        panel1.add(btn15);

        btn15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reports().setVisible(true);

            }
        });




        setSize(1950,1090);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Reception();
    }
}
