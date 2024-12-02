
package airlinemanagemntsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BoardingPass extends JFrame implements ActionListener{
    JLabel tfname,tfaadhar,tfsrc,tfdest,tffcode,tffname,tfdate; 
    JTextField tfpnr;
    JButton enter;
    
    public BoardingPass(){
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    JLabel heading = new JLabel("AIR INDIA");
    heading.setBounds(380, 10, 450, 35);
    heading.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 32));
    heading.setForeground(Color.BLACK);
    add(heading);
    
     
    JLabel heading2 = new JLabel("Boarding Pass");
    heading2.setBounds(380, 50, 300, 30);
    heading2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 24));
    heading2.setForeground(Color.BLACK);
    add(heading2);
    
     JLabel lbpnr = new JLabel("PNR");
     lbpnr.setBounds(60, 100, 150, 25);
     lbpnr.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(lbpnr);
     
      tfpnr = new JTextField();
     tfpnr.setBounds(220, 100, 150, 25);
     add(tfpnr);
     
     enter = new JButton("Enter");
     enter.setBackground(Color.BLACK);
     enter.setForeground(Color.WHITE);
     enter.setBounds(380, 100, 120, 25);
     enter.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(enter);
     enter.addActionListener(this);
     
     JLabel lbname = new JLabel("Name");
     lbname.setBounds(60, 140, 150, 25);
     lbname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(lbname);
     
     tfname = new JLabel();
     tfname.setBounds(220, 140, 150, 25);
     add(tfname);
     
     JLabel lbnationality = new JLabel("Nationality");
     lbnationality.setBounds(60, 180, 150, 25);
     lbnationality.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(lbnationality);
     
      tfaadhar = new JLabel();
     tfaadhar.setBounds(220, 180, 150, 25);
     add(tfaadhar);
     
     JLabel lbsrc = new JLabel("SRC");
     lbsrc.setBounds(60, 220, 150, 25);
     lbsrc.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(lbsrc);
     
      tfsrc = new JLabel();
     tfsrc.setBounds(220, 220, 150, 25);
     add(tfsrc);
     
     JLabel lbdest = new JLabel("DEST");
     lbdest.setBounds(380,220, 150, 25);
     lbdest.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(lbdest);
     
      tfdest = new JLabel();
     tfdest.setBounds(540, 220, 150, 25);
     add(tfdest);
    
     JLabel lbfname = new JLabel("Flight Name");
     lbfname.setBounds(60, 260, 150, 25);
     lbfname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(lbfname);
     
      tffname = new JLabel();
     tffname.setBounds(220, 260, 150, 25);
     add(tffname);
     
     JLabel lbfcode = new JLabel("Flight Code");
     lbfcode.setBounds(380, 260, 150, 25);
     lbfcode.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(lbfcode);
     
      tffcode = new JLabel();
     tffcode.setBounds(540, 260, 150, 25);
     add(tffcode);
     
     JLabel lbdate = new JLabel("Date");
     lbdate.setBounds(60, 300, 150, 25);
     lbdate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(lbdate);
     
     tfdate = new JLabel();
     tfdate.setBounds(220, 300, 150, 25);
     add(tfdate);
     
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagemntsystem/icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600, 0, 300, 300);
        add(lblimage);
    
    setSize(1000, 450);
    setLocation(300, 150);
    setVisible(true);
    setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent ae){
        
            String userpnr = tfpnr.getText();
            try{
            conn c5 = new conn();
            String ssql = "Select * from tickets where PNR =?";
            c5.s=c5.c.prepareStatement(ssql);
            c5.s.setString(1,userpnr );
            ResultSet rs = c5.s.executeQuery();
            if (rs.next()){
            tfname.setText(rs.getString("name"));
            tfaadhar.setText(rs.getString("aadhar")); 
            tfsrc.setText(rs.getString("source"));
            tfdest.setText(rs.getString("destination"));
            tffname.setText(rs.getString("flname"));
            tffcode.setText(rs.getString("fcode"));
            tfdate.setText(rs.getString("date"));
            }
            else {
            
                    JOptionPane.showMessageDialog(null, "Please enter correct PNR");                
            }
    }
            catch(Exception e){
              e.printStackTrace();
            }}
    
    
    
}
