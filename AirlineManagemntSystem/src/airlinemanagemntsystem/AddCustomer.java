package airlinemanagemntsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddCustomer extends JFrame implements ActionListener {
    JTextField tfname, tfphone, tfaadhar, tfaddress,tfnationality;
    JRadioButton rbmale,rbfemale;
    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 32));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        JLabel lbname = new JLabel("Name");
        lbname.setBounds(60, 80, 150, 25);
        lbname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        lbname.setForeground(Color.BLACK);
        add(lbname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 80, 150, 25);
        add(tfname);
        
        JLabel lbphone = new JLabel("Phone");
        lbphone.setBounds(60, 130, 150, 25);
        lbphone.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        lbphone.setForeground(Color.BLACK);
        add(lbphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 130, 150, 25);
        add(tfphone);
        
        JLabel lbaddress = new JLabel("Address");
        lbaddress.setBounds(60, 180, 150, 25);
        lbaddress.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        lbaddress.setForeground(Color.BLACK);
        add(lbaddress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 180, 150, 25);
        add(tfaddress);
        
        JLabel lbaadhar = new JLabel("Aadhar");
        lbaadhar.setBounds(60, 230, 150, 25);
        lbaadhar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        lbaadhar.setForeground(Color.BLACK);
        add(lbaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 230, 150, 25);
        add(tfaadhar);
        
        JLabel lbnation = new JLabel("Nationality");
        lbnation.setBounds(60, 280, 150, 25);
        lbnation.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        lbnation.setForeground(Color.BLACK);
        add(lbnation);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(220, 280, 150, 25);
        add(tfnationality);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(60, 330, 150, 25);
        gender.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        gender.setForeground(Color.BLACK);
        add(gender);
        
        ButtonGroup gb = new ButtonGroup();
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 330, 70, 30);
        rbmale.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 330, 100, 30);
        rbfemale.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        gb.add(rbmale);
        gb.add(rbfemale);
        
        JButton save = new JButton("SAVE");
        save.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220, 380, 150, 30);
        save.addActionListener(this);
        add(save);
        
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagemntsystem/icons/emp.png"));
        JLabel image2= new JLabel(i2);
        image2.setBounds(450, 80, 280, 400);
        add(image2);
        
        
        setSize(900,600);
        setLocation(300,150);
        setVisible(true);
        setLocationRelativeTo(null);
        
    
    }
    
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String nationality = tfnationality.getText();
        String gender = null;
        if (rbmale.isSelected()){
        gender = "male";}
        else {
        gender = "female";}
         
    try {
       
       conn c2 = new conn();
       String ssql= "Insert Into passengers(name ,phone,address,aadhar,nationality,gender) Values(?,?,?,?,?,?) ";
       c2.s=c2.c.prepareStatement(ssql);
       c2.s.setString(1,name);
       c2.s.setString(2,phone);
       c2.s.setString(3,address);
       c2.s.setString(4,aadhar);
       c2.s.setString(5,nationality);
       c2.s.setString(6,gender);
       c2.s.executeUpdate();
       
       JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
        
       setVisible(false);
    }
    catch(Exception e){
     e.printStackTrace();}
    }
}
