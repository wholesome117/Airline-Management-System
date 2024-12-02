package airlinemanagemntsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Home extends JFrame implements ActionListener {
 
 public Home(){
  setLayout(null);
  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagemntsystem/icons/front.jpg"));
  JLabel image = new JLabel(i1);
  image.setBounds(0, 0, 1600, 650);
  add(image);
  
  JLabel heading = new JLabel("AIR INDIA WELCOMES YOU");
  heading.setBounds(400, 40, 1000, 40);
  heading.setForeground(Color.BLACK);
  heading.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 36));
  image.add(heading);
  
  JMenuBar menubar = new JMenuBar();
  setJMenuBar(menubar);
  
  JMenu details= new JMenu("DETAILS");
  details.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
  menubar.add(details);
  
  JMenuItem flightDetails = new JMenuItem("Flights");
  flightDetails.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
  details.add(flightDetails);
  flightDetails.addActionListener(this);
  
  JMenuItem customerDetails = new JMenuItem("Add Customer Details");
  customerDetails.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
  details.add(customerDetails);
  customerDetails.addActionListener(this);
  
  JMenuItem bookFlights = new JMenuItem("Book Flight");
  bookFlights.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
  details.add(bookFlights);
  bookFlights.addActionListener(this);
  
  JMenuItem journeyDetails = new JMenuItem("Journey Details");
  journeyDetails.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
  details.add(journeyDetails);
  journeyDetails.addActionListener(this);
  
  JMenuItem cancelTicket = new JMenuItem("Ticket Cancellation");
  cancelTicket.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
  details.add(cancelTicket);
  cancelTicket.addActionListener(this);
  
  JMenu ticket= new JMenu("TICKETS");
  ticket.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
  menubar.add(ticket);
  
  JMenuItem boardingPass = new JMenuItem("Boarding Pass");
  boardingPass.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
  ticket.add(boardingPass);
  boardingPass.addActionListener(this);
  
  
  setExtendedState(JFrame.MAXIMIZED_BOTH);
  setVisible(true);
  }
 public void actionPerformed(ActionEvent ae){
     String text = ae.getActionCommand();
     if (text.equals("Flights")){
         new Flights();
      }
     else if(text.equals("Add Customer Details")){
         new AddCustomer();
     }
     else if(text.equals("Book Flight")){
         new BookFlights();
     }
     else if(text.equals("Journey Details")){
         new JourneyDetails();}
      else if(text.equals("Ticket Cancellation")){
         new Cancel();}
     
     else if(text.equals("Boarding Pass")){
         new BoardingPass();}
 }
}
 
 
      
 