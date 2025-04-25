package medi.core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Reports extends JFrame {

    Reports() {
        // Panel setup
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 790, 390);
        panel.setBackground(new Color(26, 220, 42));
        panel.setLayout(null);
        add(panel);

        // Title Label
        JLabel titleLabel = new JLabel("Discharge Report");
        titleLabel.setBounds(100, 20, 200, 30);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        titleLabel.setForeground(Color.white);
        panel.add(titleLabel);

        // Patient Number Label and Choice dropdown
        JLabel label = new JLabel("Select Patient:");
        label.setBounds(30, 80, 150, 20);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        label.setForeground(Color.white);
        panel.add(label);

        // Choice dropdown for patient Names
        Choice choice = new Choice();
        choice.setBounds(200, 80, 150, 25);
        panel.add(choice);

        // Populate choice dropdown with patient Names and store Numbers
        try {
            conn c = new conn();
            String query = "SELECT Number, Name FROM discharge_info";  // Query to fetch both Number and Name
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()) {
                String number = resultSet.getString("Number");
                String name = resultSet.getString("Name");
                choice.add(name + " (" + number + ")");  // Add the name and Number in the format "Name (Number)"
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Report Display Area
        JTextArea reportArea = new JTextArea();
        reportArea.setBounds(30, 130, 700, 150);
        reportArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        reportArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reportArea);
        scrollPane.setBounds(30, 130, 700, 150);
        panel.add(scrollPane);

        // Generate Report Button
        JButton generateReportButton = new JButton("Generate Report");
        generateReportButton.setBounds(30, 300, 150, 30);
        generateReportButton.setBackground(Color.black);
        generateReportButton.setForeground(Color.white);
        panel.add(generateReportButton);
        generateReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = choice.getSelectedItem();
                if (selectedItem != null && !selectedItem.isEmpty()) {
                    // Extract patient Number from the selected item
                    String patientNumber = selectedItem.substring(selectedItem.indexOf("(") + 1, selectedItem.indexOf(")"));
                    generateReport(patientNumber, reportArea);
                } else {
                    JOptionPane.showMessageDialog(Reports.this, "Please select a patient.");
                }
            }
        });

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(200, 300, 120, 30);
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.white);
        panel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);  // Close the report window
            }
        });

        // Window Setup
        setUndecorated(true);
        setSize(800, 400);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);
    }

    private void generateReport(String patientNumber, JTextArea reportArea) {
        try {
            conn c = new conn();
            String query = "SELECT Name, Patient_Disease, Room_Number, Discharge_Time FROM discharge_info WHERE Number = ?";
            PreparedStatement ps = c.connection.prepareStatement(query);
            ps.setString(1, patientNumber);  // Use the patient Number to fetch the report
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String patientName = rs.getString("Name");
                String disease = rs.getString("Patient_Disease");
                String roomNumber = rs.getString("Room_Number");
                String dischargeTime = rs.getString("Discharge_Time");

                // Prepare the report content
                String reportContent = "Discharge Report\n\n" +
                        "Patient Number: " + patientNumber + "\n" +
                        "Name: " + patientName + "\n" +
                        "Disease: " + disease + "\n" +
                        "Room Number: " + roomNumber + "\n" +
                        "Discharge Time: " + dischargeTime + "\n\n" +
                        "Thank you for using our services!";

                // Display the report in the text area
                reportArea.setText(reportContent);
            } else {
                JOptionPane.showMessageDialog(this, "No data found for patient Number: " + patientNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while fetching the report.");
        }
    }

    public static void main(String[] args) {
        new Reports();
    }
}
