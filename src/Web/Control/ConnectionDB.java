/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.Control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author brian
 */
public class ConnectionDB {
    
    private static Connection con = null;
    
    private ConnectionDB(){
    
    }
    
    
    public  static Connection openConnection() throws SQLException{
        if(con==null)
        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/TrabajoPracticas","root","");
            return con;
    }
    
    
    public static void  closeConnection(){
        
        if(con!=null)
            con=null;
        
    } 
}
