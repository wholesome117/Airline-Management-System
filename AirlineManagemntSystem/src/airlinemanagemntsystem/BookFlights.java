package airlinemanagemntsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;


public class BookFlights extends JFrame implements ActionListener {
    
    JTextField tfaadhar; 
    JLabel tfname,tfaddress,tfnationality,tfgender,tffname,tffnum;
    JButton fetchu,fetchfl,bookfl;
    Choice source,destination;
    JDateChooser bd;
    
    public BookFlights(){
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     
     JLabel heading = new JLabel("Book Flights");
     heading.setBounds(550, 15, 500, 40);
    
     heading.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 32));
     heading.setForeground(Color.BLACK);
     add(heading);
     
     JLabel lbaadhar = new JLabel("Aadhar");
     lbaadhar.setBounds(60, 80, 150, 25);
     lbaadhar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(lbaadhar);
     
     tfaadhar = new JTextField();
     tfaadhar.setBounds(220, 80, 150, 25);
     add(tfaadhar);
     
     fetchu = new JButton("Fetch user");
     fetchu.setBounds(380, 80, 120, 25);
     fetchu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
     fetchu.setBackground(Color.BLACK);
     fetchu.setForeground(Color.WHITE);
     add(fetchu);
     fetchu.addActionListener(this);
     
     JLabel lbname = new JLabel("Name");
     lbname.setBounds(60, 130, 150, 25);
     lbname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(lbname);
     
     tfname = new JLabel();
     tfname.setBounds(220, 130, 150, 25);
     add(tfname);
     
     JLabel lbaddress = new JLabel("Address");
     lbaddress.setBounds(60, 180, 150, 25);
     lbaddress.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(lbaddress);
     
     tfaddress = new JLabel();
     tfaddress.setBounds(220, 180, 150, 25);
     add(tfaddress);
     
     JLabel lbnationality = new JLabel("Nationality");
     lbnationality.setBounds(60, 230, 150, 25);
     lbnationality.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(lbnationality);
     
     tfnationality = new JLabel();
     tfnationality.setBounds(220, 230, 150, 25);
     add(tfnationality);
     
     JLabel lbgender = new JLabel("Gender");
     lbgender.setBounds(60, 280, 150, 25);
     lbgender.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(lbgender);
     
     tfgender = new JLabel();
     tfgender.setBounds(220, 280, 150, 25);
     add(tfgender);
     
     JLabel lbsource = new JLabel("Source");
     lbsource.setBounds(60, 330, 150, 25);
     lbsource.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(lbsource);
     
     source = new Choice();
     source.setBounds(220, 330, 150, 25);
     add(source);
     
     
     
     JLabel lbdestination = new JLabel("Destination");
     lbdestination.setBounds(60, 380, 150, 25);
     lbdestination.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(lbdestination);
     
     destination = new Choice();
     destination.setBounds(220, 380, 150, 25);
     add(destination);
     
     try{
     conn c4 = new conn();
     
     String ssql = "Select * from flights";
     c4.s=c4.c.prepareStatement(ssql);
     ResultSet rs = c4.s.executeQuery();
     
     while(rs.next()){
     source.add(rs.getString("source"));
     destination.add(rs.getString("destination"));
     }
     

     
     
     }
     catch (Exception e){
     e.printStackTrace();}
     
     fetchfl = new JButton("Fetch Flight");
     fetchfl.setBounds(380, 380, 120, 25);
     fetchfl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
     fetchfl.setBackground(Color.BLACK);
     fetchfl.setForeground(Color.WHITE);
     add(fetchfl);
     fetchfl.addActionListener(this);
     
     JLabel flname = new JLabel("Flight Name");
     flname.setBounds(60, 430, 150, 25);
     flname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(flname);
     
     tffname = new JLabel();
     tffname.setBounds(220, 430, 150, 25);
     add(tffname);
     
     JLabel flnum = new JLabel("Flight code");
     flnum.setBounds(60, 480, 150, 25);
     flnum.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(flnum);
     
     tffnum = new JLabel();
     tffnum.setBounds(220, 480, 150, 25);
     add(tffnum);
     
     JLabel lbdot = new JLabel("Date of travel");
     lbdot.setBounds(60,530, 150, 25);
     lbdot.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(lbdot);
     
     bd = new JDateChooser();
     bd.setBounds(220, 530, 150, 25);
     add(bd);
     
     
     
     bookfl = new JButton("Book Flight");
     bookfl.setBounds(220, 580, 150, 25);
     bookfl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
     add(bookfl);
     bookfl.addActionListener(this);
     
     ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagemntsystem/icons/details.jpg"));
     Image i4 = i3.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
     ImageIcon image = new ImageIcon(i4);
     JLabel lblimage = new JLabel(image);
     lblimage.setBounds(550, 80, 500, 410);
     add(lblimage);
     
     
     
     
     setSize(110,700);
     setLocation(200,50);
     setVisible(true);
     setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==fetchu){
            String useraadhar = tfaadhar.getText();
            try{
            conn c5 = new conn();
            String ssql = "Select * from passengers where aadhar =?";
            c5.s=c5.c.prepareStatement(ssql);
            c5.s.setString(1,useraadhar );
            ResultSet rs = c5.s.executeQuery();
            
            if (rs.next()){
            tfname.setText(rs.getString("name"));
            tfnationality.setText(rs.getString("nationality")); 
            tfaddress.setText(rs.getString("address"));
            tfgender.setText(rs.getString("gender"));
            }
            else {
            
                    JOptionPane.showMessageDialog(null, "Please enter correct aadhar");                
            }
            }
            catch(Exception e){
            e.printStackTrace();}
        }
        else if(ae.getSource()==fetchfl){
        String src = source.getSelectedItem();
        String dest = destination.getSelectedItem();
        
        try{
        conn con  = new conn();
        
        String ssql ="Select * from flights where source =? and destination=?";
        con.s = con.c.prepareStatement(ssql);
        con.s.setString(1,src);
        con.s.setString(2,dest);
        
        ResultSet rs = con.s.executeQuery();
        
        if (rs.next()){
        tffname.setText(rs.getString("fname"));
        tffnum.setText(rs.getString("fcode"));
        }
        else{
            JOptionPane.showMessageDialog(null, "No flights found");       
        }
        
        }
        catch(Exception e){
        e.printStackTrace();}
        }
    
    
        else{
            String useraadhar = tfaadhar.getText();
            String username = tfname.getText();
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            Random random = new Random();
            String flightname = tffname.getText();
            String flightnum = tffnum.getText();
            String ddate = ((JTextField) bd.getDateEditor().getUiComponent()).getText();
            
            try{
            conn con = new conn();
            String ssql = "Insert into tickets(PNR,ticket_id,name,aadhar,source,destination,flname,fcode,date)values(?,?,?,?,?,?,?,?,?) ";
            con.s=con.c.prepareStatement(ssql);
            con.s.setInt(1,random.nextInt(10000000));
            con.s.setInt(2,random.nextInt(10000000));
            con.s.setString(3,username);
            con.s.setString(4,useraadhar);
            con.s.setString(5,src);
            con.s.setString(6,dest);
            con.s.setString(7,flightname);
            con.s.setString(8,flightnum);
            con.s.setString(9,ddate);
            con.s.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
            setVisible(false);
            
            }
            
            
            catch(Exception e){
            e.printStackTrace();}
            
            
        }
    }
    
    
}
