package airlinemanagemntsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
 JButton submit,reset,close;
 JTextField tfusername;
 JPasswordField tfpass;
 public Login(){
  getContentPane().setBackground(Color.WHITE);
  setLayout(null);
   
  
  JLabel lbusername=new JLabel("Username");
  lbusername.setBounds(100,40,100,20);
  lbusername.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
  add(lbusername);
  
  tfusername= new JTextField();
  tfusername.setBounds(200,40,150,20);
  add(tfusername);
  
  JLabel lbpass=new JLabel("Password");
  lbpass.setBounds(100,80,100,20);
  lbpass.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
  add(lbpass);
  
  tfpass= new JPasswordField();
  tfpass.setBounds(200,80,150,20);
  add(tfpass);
  
  submit = new JButton("Submit");
  submit.setBounds(90,140,120,20);
  submit.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
  submit.addActionListener(this);
  add(submit);
  
  reset = new JButton("Reset");
  reset.setBounds(240,140,120,20);
  reset.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
  reset.addActionListener(this);
  add(reset);
  
  close = new JButton("Close");
  close.setBounds(160,180,120,20);
  close.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
  close.addActionListener(this);
  add(close);
  
  
  setSize(500,300);
  setLocation(600,300);
  setVisible(true);
  setLocationRelativeTo(null);
  
  
 }
 
 public void actionPerformed(ActionEvent ae ){
  if (ae.getSource()==reset){
  tfusername.setText("");
  tfpass.setText("");
  }
  else if (ae.getSource()==close){
  setVisible(false);}
  else if (ae.getSource()==submit){
      String username= tfusername.getText();
      String password= tfpass.getText ();
      
      try{
          String ssql;
          conn c1 = new conn();
          ssql = "Select * from login where username = ? and password = ?";
          c1.s = c1.c.prepareStatement(ssql);
          c1.s.setString(1,username);
          c1.s.setString(2,password);
          ResultSet rs = c1.s.executeQuery();
          
          if (rs.next()){
             new Home();
          }
          else{
          JOptionPane.showMessageDialog(null,"Invalid credentials");
          setVisible(false);
          }
      }
      catch(Exception e){
      e.printStackTrace();}
      
  }
  
  
 }
    

 public static void main(String[] args){
  new Login();
  }
}
