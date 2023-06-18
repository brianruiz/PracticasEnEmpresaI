
package Web.Control;

import Web.Model.ModelProduct;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;


/**
 *
 * @author brian
 */
public class PeliculasControl {
    
    Statement state;
    
    public void insert (ModelProduct product){
    
        try{
            state= ConnectionDB.openConnection().createStatement();
            state.executeUpdate("INSERT INTO `movies`(`name`, `number`, `price`, `type`, `discount`) VALUES ('"+product.getName()+"',"+product.getNumber()+","+product.getPrice()+",'"+product.getType()+"',"+product.getDiscount()+")");
            ConnectionDB.closeConnection();
        }catch (SQLException ex) {
            ConnectionDB.closeConnection();
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void delete(int id)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();
            state.executeUpdate("Delete FROM `movies` WHERE id = " + id);
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            ConnectionDB.closeConnection();
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(ModelProduct product)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();
            state.executeUpdate("UPDATE movies set `name` = "+"'"+product.getName()+"'"+", `number` = "+product.getNumber() +", `price` = " + product.getPrice() +", `type` = "+"'"+product.getType()+"'"+", `discount` = "+product.getDiscount()+" WHERE id = "+product.getId() );
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionDB.closeConnection();
        }
    }
    
    
    public ObservableList<ModelProduct>getAllProduct(){
        
        ObservableList <ModelProduct> product = FXCollections.observableArrayList();
        try {
            state = ConnectionDB.openConnection().createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM movies");
            
            while (result.next()){
            
                ModelProduct obj = new ModelProduct();
                obj.setId(result.getInt(1));
                obj.setName(result.getString(2));
                obj.setNumber(result.getInt(3));
                obj.setPrice(result.getDouble(4));
                obj.setType(result.getString(5));
                obj.setDiscount(result.getInt(6));
                
                product.add(obj);
                
            }
            ConnectionDB.closeConnection();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
            
        }
                
                
        return product;
    }
    
    
    
    public ObservableList<ModelProduct>getSearchProduct(String name){
        
        ObservableList <ModelProduct>product = FXCollections.observableArrayList();
        try {
            state = ConnectionDB.openConnection().createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM movies WHERE name LIKE '%"+name+"%'");
            
            while (result.next()){
            
                ModelProduct obj = new ModelProduct();
                obj.setId(result.getInt(1));
                obj.setName(result.getString(2));
                obj.setNumber(result.getInt(3));
                obj.setPrice(result.getDouble(4));
                obj.setType(result.getString(5));
                obj.setDiscount(result.getInt(6));
                
                product.add(obj);
                
            }
            ConnectionDB.closeConnection();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                
        return product;
    }
    
}
