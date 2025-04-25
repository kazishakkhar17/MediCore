package medi.core;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class BillBreakdown extends JFrame {
    BillBreakdown() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(new Color(136, 255, 146));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 34, 980, 450);
        table.setBackground(new Color(179, 250, 143));
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(table);

        try {
            conn conn = new conn(); // uses your existing connection class
            String query = """
                    SELECT 
                        Patient_Disease,
                        Medical_Department_Name,
                        SUM(CAST(Deposite AS DECIMAL(10,2))) AS total_deposit
                    FROM 
                        patient_info
                    GROUP BY 
                        Patient_Disease, Medical_Department_Name
                    WITH ROLLUP
                    """;

            ResultSet rs = conn.statement.executeQuery(query);

            // Use DefaultTableModel instead of DbUtils to handle ROLLUP nulls
            String[] columns = {"Patient Disease", "Medical Department", "Total Deposit"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(columns, 0);

            while (rs.next()) {
                String disease = rs.getString("Patient_Disease");
                String department = rs.getString("Medical_Department_Name");
                String deposit = rs.getString("total_deposit");

                if (disease == null) disease = "ALL Diseases";
                if (department == null) department = "ALL Departments";

                model.addRow(new Object[]{disease, department, deposit});
            }

            table.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage());
        }

        JLabel label1 = new JLabel("Patient Disease");
        label1.setBounds(41, 9, 150, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("Medical Dept.");
        label2.setBounds(430, 9, 150, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        JLabel label3 = new JLabel("Total Deposit");
        label3.setBounds(730, 9, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);

        JButton button = new JButton("BACK");
        button.setBounds(350, 500, 120, 30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        panel.add(button);
        button.addActionListener(e -> setVisible(false));

        setUndecorated(true);
        setSize(1000, 600);
        setLocation(350, 230);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BillBreakdown();
    }
}
