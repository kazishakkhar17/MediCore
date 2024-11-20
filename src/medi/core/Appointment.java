package medi.core;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Appointment extends JFrame {

    Appointment(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(136, 255, 146));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,34,980,450);
        table.setBackground(new Color(179, 250, 143));
        table.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(table);




        try {
            conn c = new conn();

            // Insert query with SELECT to fetch patient details from patient_info, medical_department, and doctor tables
            String insertQuery = """
    INSERT INTO appointment (
        patient_id, patient_name, patient_disease, department_name, 
        doctor_name, doctor_specialization, doctor_phone, appointment_time
    )
    SELECT
        p.Number, p.Name, p.Patient_Disease, md.medi_dept_name, 
        d.doctor_name, d.specialization, d.phone, p.Time
    FROM
        patient_info p
    JOIN
        medical_department md ON p.Medical_Department_Name = md.medi_dept_name
    JOIN
        doctor d ON md.medical_department_id = d.medical_department_id
    WHERE NOT EXISTS (
        SELECT 1
        FROM appointment a
        WHERE a.patient_id = p.Number AND a.appointment_time = p.Time
    );
    """;


            c.statement.executeUpdate(insertQuery);


            String selectQuery = "SELECT * FROM appointment";
            ResultSet resultSet = c.statement.executeQuery(selectQuery);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(panel, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }







        JLabel label1 = new JLabel("Appointment ID");
        label1.setBounds(10, 11, 180, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 10));
        panel.add(label1);

        JLabel label2 = new JLabel("ID type");
        label2.setBounds(120, 11, 150, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 10));
        panel.add(label2);

        JLabel label3 = new JLabel("Name");
        label3.setBounds(225, 11, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 10));
        panel.add(label3);

        JLabel label4 = new JLabel("Disease Name");
        label4.setBounds(335, 11, 180, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 10));
        panel.add(label4);

        JLabel label5 = new JLabel("Medical Dept");
        label5.setBounds(445, 11, 150, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 10));
        panel.add(label5);

        JLabel label6 = new JLabel("Doctor ");
        label6.setBounds(555, 11, 180, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 10));
        panel.add(label6);

        JLabel label7 = new JLabel("Doctor Specialization");
        label7.setBounds(660, 11, 180, 20);
        label7.setFont(new Font("Tahoma", Font.BOLD, 10));
        panel.add(label7);

        JLabel label8 = new JLabel("Doctor Phone");
        label8.setBounds(770, 11, 150, 20);
        label8.setFont(new Font("Tahoma", Font.BOLD, 10));
        panel.add(label8);

        JLabel label9 = new JLabel("Appointment Date");
        label9.setBounds(880, 11, 180, 20);
        label9.setFont(new Font("Tahoma", Font.BOLD, 10));
        panel.add(label9);



        JButton b1 = new JButton("BACK");
        b1.setBounds(400, 500, 130, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });




        setUndecorated(true);
        setSize(1000,600);
        setLayout(null);
        setLocation(300,200);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Appointment();
    }
}
