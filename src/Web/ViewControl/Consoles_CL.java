
package Web.ViewControl;

import Web.Control.ConsoleControl;
import Web.Model.ModelProduct;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author brian
 */



public class Consoles_CL implements Initializable{
    @FXML
    private Label lb;
     @FXML
    private TextField txtName;
    @FXML
    private TextField txtNumber;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtDiscount;
    @FXML
    private TextField txtSearch;
    @FXML
    private ComboBox Type;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnBack;
    @FXML
    private TableView table;
    @FXML
    private TableColumn id;
    @FXML
    private TableColumn name;
    @FXML
    private TableColumn number;
    @FXML
    private TableColumn price;
    @FXML
    private TableColumn type;
    @FXML
    private TableColumn discount;
    
    ConsoleControl pc = new ConsoleControl();
    String typeValue[] = {"Playstation", "Xbox", "Nintendo", "PC"};
    int ID;
    ObservableList<String>olType = FXCollections.observableArrayList(typeValue);
    
    public void search (){
    
        table.setItems(pc.getSearchProduct(txtSearch.getText()));
    }
    
    public void add(Event e){
        ModelProduct mp = new ModelProduct();
        mp.setName(txtName.getText());
        mp.setNumber(Integer.parseInt(txtNumber.getText()));
        mp.setPrice(Double.parseDouble(txtPrice.getText()));
        mp.setDiscount(Integer.parseInt(txtDiscount.getText()));
        mp.setType(Type.getValue()+"");
        
        pc.insert(mp);
        
        txtName.setText("");
        txtNumber.setText("");
        txtPrice.setText("");
        txtDiscount.setText("");
        table.setItems(pc.getAllProduct());
    }
    
    public void update(Event e){
    
        ModelProduct mp = new ModelProduct();
        mp.setId(ID);
        mp.setName(txtName.getText());
        mp.setNumber(Integer.parseInt(txtNumber.getText()));
        mp.setPrice(Double.parseDouble(txtPrice.getText()));
        mp.setDiscount(Integer.parseInt(txtDiscount.getText()));
        mp.setType(Type.getValue()+"");
        
        
        pc.update(mp);
        

        txtName.setText("");
        txtNumber.setText("");
        txtPrice.setText("");
        txtDiscount.setText("");
        table.setItems(pc.getAllProduct());
    }
    
    public void delete(Event e){
    
    pc.delete(ID);
       txtName.setText("");
        txtNumber.setText("");
        txtPrice.setText("");
        txtDiscount.setText("");
        
        table.setItems(pc.getAllProduct());
    
    }
       
 public void back(Event e)
 {
      try {
                    //add you loading or delays - ;-)
                   Node node = (Node) e.getSource();
                   Stage stage = (Stage) node.getScene().getWindow();                  
                   stage.close();
                   
                   Parent root = FXMLLoader.load(getClass().getResource("/Web/View/Home.fxml"));       
                   Scene scene = new Scene(root);       
                   stage.setScene(scene);
                   stage.show();

                } catch (IOException ex) {
                    System.out.println("y"+ex.getMessage());
                }
 }
    
    public void ClickTable(Event e){
        ModelProduct mp = (ModelProduct) table.getSelectionModel().getSelectedItem();
        txtName.setText(mp.getName());
        txtNumber.setText(mp.getNumber()+"");
        txtPrice.setText(mp.getPrice()+"");
        txtDiscount.setText(mp.getDiscount()+"");
        Type.setValue(mp.getType());
        ID= mp.getId();
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        
        table.setItems(pc.getAllProduct());
        Type.getItems().addAll(olType);
    }
    
    
}
