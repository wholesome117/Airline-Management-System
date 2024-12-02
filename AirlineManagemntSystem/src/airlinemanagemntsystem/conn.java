package airlinemanagemntsystem;
import java.sql.*;

public class conn {
    Connection c;
    PreparedStatement s;
    
   public conn(){
   
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem","root","Mysql@3890");
    
    
    
    }
    catch(Exception e){
        e.printStackTrace();
    }

} 
}
