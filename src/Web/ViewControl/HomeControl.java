/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.ViewControl;

import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author brian
 */
public class HomeControl {
    
    @FXML
    Button btn1,btn2,btn3,btn4;
    
    public void openGames(Event e) throws IOException {
    
        Node node =(Node) e.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            
            
             Parent root = FXMLLoader.load(getClass().getResource("/Web/View/Products.fxml"));
             Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.show();
    }
    
    
    public void openConsoles(Event e) throws IOException {
    
        Node node =(Node) e.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            
            
             Parent root = FXMLLoader.load(getClass().getResource("/Web/View/Consoles.fxml"));
             Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.show();
    }
    
    
    public void openEmploye(Event e) throws IOException {
    
        Node node =(Node) e.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            
            
             Parent root = FXMLLoader.load(getClass().getResource("/Web/View/Employe.fxml"));
             Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.show();
    }
    
    
    public void openMovie(Event e) throws IOException {
    
        Node node =(Node) e.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            
            
             Parent root = FXMLLoader.load(getClass().getResource("/Web/View/Movie.fxml"));
             Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.show();
    }
    
    
    public void openToys(Event e) throws IOException {
    
        Node node =(Node) e.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            
            
             Parent root = FXMLLoader.load(getClass().getResource("/Web/View/Toys.fxml"));
             Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.show();
    }
    
    
    
}
