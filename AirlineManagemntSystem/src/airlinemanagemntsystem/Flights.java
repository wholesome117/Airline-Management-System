package airlinemanagemntsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Flights extends JFrame {
    public Flights(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JTable table = new JTable();
        
        try {
         conn c3= new conn();
         String ssql ="Select* from flights";
         c3.s=c3.c.prepareStatement(ssql);
         ResultSet rs = c3.s.executeQuery();
         
         table.setModel(DbUtils.resultSetToTableModel(rs));
         
        }
        catch(Exception e){
        e.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0,800,500);
        add(sp);
        
        setSize(800,500);
        setLocation(400,200);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
