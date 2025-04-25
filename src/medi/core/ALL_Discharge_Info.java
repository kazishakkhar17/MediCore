package medi.core;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ALL_Discharge_Info extends JFrame {
    ALL_Discharge_Info(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,1000,590);
        panel.setBackground(new Color(255, 204, 153));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,980,450);
        table.setBackground(new Color(255, 204, 153));
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(table);

        try {
            conn c = new conn();
            String q = "SELECT * FROM discharge_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Column headers
        String[] headers = {
                "Discharge ID", "ID", "Number", "Name", "Gender", "Disease",
                "Room", "Time", "Deposit", "Edu Dept", "Medical Dept", "Discharge Time"
        };
        int[] xPositions = {
                10, 100, 170, 250, 330, 410,
                490, 550, 630, 710, 790, 900
        };

        for (int i = 0; i < headers.length; i++) {
            JLabel label = new JLabel(headers[i]);
            label.setBounds(xPositions[i], 11, 100, 14);
            label.setFont(new Font("Tahoma", Font.BOLD, 12));
            panel.add(label);
        }

        JButton button = new JButton("BACK");
        button.setBounds(450,510,120,30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        panel.add(button);
        button.addActionListener(new ActionListener() {
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
        new ALL_Discharge_Info();
    }
}
