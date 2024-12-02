package airlinemanagemntsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener {
    JTable table;
    JTextField pnr;
    JButton show;
    public JourneyDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        lblpnr.setBounds(50, 50, 100, 25);
        add(lblpnr);
        
        pnr = new JTextField();
        pnr.setBounds(160, 50, 120, 25);
        add(pnr);
        
        show = new JButton("Show Details");
        show.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(290, 50, 200, 25);
        show.addActionListener(this);
        add(show);
        
        table = new JTable();
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,100,800,150);
        sp.setBackground(Color.WHITE);
        add(sp);
        
        setSize(800,600);
        setLocation(400,150);
        setVisible(true);
        setLocationRelativeTo(null);
         }
    
    public void actionPerformed(ActionEvent ae){
        try {
            
         conn con= new conn();
         String ssql ="Select* from tickets where PNR = ?";
         con.s=con.c.prepareStatement(ssql);
         con.s.setString(1,pnr.getText());
         ResultSet rs = con.s.executeQuery();
         
         if (!rs.isBeforeFirst()){
          JOptionPane.showMessageDialog(null, "No Information Found");
         return;
         }
         table.setModel(DbUtils.resultSetToTableModel(rs));
           
        }
        catch(Exception e){
        e.printStackTrace();
        }
    }
}
