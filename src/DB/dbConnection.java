package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    private static dbConnection dbconnection;
   private Connection connection;


   private dbConnection(){
       try {
           Class.forName("com.mysql.jdbc.Driver");
           try {
               connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/comunication","root","12345");
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }

       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }

   }
   public static dbConnection getInstance(){
       return (dbconnection == null)? dbconnection = new dbConnection():dbconnection;
   }
   public Connection getConnection(){
       return  connection;
   }
}
