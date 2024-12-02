package airlinemanagemntsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;


public class Cancel extends JFrame implements ActionListener {
    
    JTextField tfpnr; 
    JLabel tfname,tfcnum,tffcode,tfdate;
    JButton showdetails,bcancel;
   
    
    public Cancel(){
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     
     JLabel heading = new JLabel("Cancellation");
     heading.setBounds(300, 20, 250, 35);
     heading.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 32));
     heading.setForeground(Color.BLACK);
     add(heading);
     
     ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagemntsystem/icons/cancel.jpg"));
     Image i4 = i3.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
     ImageIcon image = new ImageIcon(i4);
     JLabel lblimage = new JLabel(image);
     lblimage.setBounds(470,120, 250, 250);
     add(lblimage);
     
     JLabel lbpnr = new JLabel("PNR");
     lbpnr.setBounds(60, 80, 150, 25);
     lbpnr.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(lbpnr);
     
     tfpnr = new JTextField();
     tfpnr.setBounds(220, 80, 150, 25);
     add(tfpnr);
     
     showdetails = new JButton("Show Details");
     showdetails.setBackground(Color.BLACK);
     showdetails.setForeground(Color.WHITE);
     showdetails.setBounds(380, 80, 200, 25);
     showdetails.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
     add(showdetails);
     showdetails.addActionListener(this);
     
     JLabel lbname = new JLabel("Name");
     lbname.setBounds(60, 130, 150, 25);
     lbname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(lbname);
     
     tfname = new JLabel();
     tfname.setBounds(220, 130, 150, 25);
     add(tfname);
     
     JLabel cnum = new JLabel("Cancellation number");
     cnum.setBounds(60, 180, 150, 25);
     cnum.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(cnum);
     
     Random random = new Random();
     
     tfcnum = new JLabel("" +random.nextInt(100000));
     tfcnum.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     tfcnum.setBounds(220, 180, 150, 25);
     add(tfcnum);
     
     
     
     JLabel flightcode = new JLabel("Flight code");
     flightcode.setBounds(60, 230, 150, 25);
     flightcode.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(flightcode);
     
     tffcode = new JLabel();
     tffcode.setBounds(220, 230, 150, 25);
     tffcode.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(tffcode);
     
     JLabel lbdate = new JLabel("Date");
     lbdate.setBounds(60, 280, 150, 25);
     lbdate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(lbdate);
     
     tfdate = new JLabel();
     tfdate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     tfdate.setBounds(220, 280, 150, 25);
     add(tfdate);
     
     bcancel = new JButton("Cancel");
     bcancel.setBounds(220, 330, 120, 25);
     bcancel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     bcancel.setBackground(Color.BLACK);
     bcancel.setForeground(Color.WHITE);
     add(bcancel);
     bcancel.addActionListener(this);
     
     setSize(800, 450);
     setLocation(350, 150);
     setVisible(true);
     setLocationRelativeTo(null);
     
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==showdetails){
            String userpnr = tfpnr.getText();
            try{
            conn c5 = new conn();
            String ssql = "Select * from tickets where pnr =?";
            c5.s=c5.c.prepareStatement(ssql);
            c5.s.setString(1,tfpnr.getText() );
            ResultSet rs = c5.s.executeQuery();
            
            if (rs.next()){
            tfname.setText(rs.getString("name"));
           
            tffcode.setText(rs.getString("fcode"));
            tfdate.setText(rs.getString("date"));
            }
            else {
            
                JOptionPane.showMessageDialog(null, "Please enter correct pnr");                
            }
            }
            catch(Exception e){
            e.printStackTrace();}
        }
        
        
        
    
        else if(ae.getSource()==bcancel){
            String userpnr = tfpnr.getText();
            String username = tfname.getText();
            
            String cnum = tfcnum.getText();
            String flightcode = tffcode.getText();
            String ddate = tfdate.getText();
            
            try{
            conn con = new conn();
            String ssql = "Insert into cancel(PNR,name,cancel_num,fcode,date)values(?,?,?,?,?) ";
            con.s=con.c.prepareStatement(ssql);
            
            con.s.setString(1,userpnr);
            con.s.setString(2,username);
            con.s.setString(3,cnum);
            con.s.setString(4,flightcode);
            con.s.setString(5,ddate);
            
            con.s.executeUpdate();
            
            String ssql2= "delete from tickets where pnr =?";
            con.s=con.c.prepareStatement(ssql2);
            con.s.setString(1,userpnr);
            
            con.s.executeUpdate();
            
           
            
            JOptionPane.showMessageDialog(null, "Ticket cancelled Successfully");
            setVisible(false);
            
            }
        
            
            
            catch(Exception e){
            e.printStackTrace();}
            
            
        }
    }
    
    
}

