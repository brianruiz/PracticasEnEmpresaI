/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.Control;

import Web.Model.Admin;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author brian
 */
public class LoginControl {
    
    Statement st;
    
   public boolean isLogin (Admin ad) throws SQLException{
        
        st = ConnectionDB.openConnection().createStatement();
        ResultSet res= st.executeQuery("select * from admins where username ='"+ad.getUsername()+"' and password  = '"+ad.getPassword()+"'");
        
        if(res.next())
            return true;
        return false;    
    }
    
}
