/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package GUI;
//import com.sun.javafx.logging.PlatformLogger.Level;
//import com.sun.javafx.logging.PlatformLogger.Level;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.offre;
import services.offreservice;
import interfaces.interfaceoffer;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import util.connexion;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */

public class OffreItemController implements Initializable {
   
    @FXML
    private Label date_label;

    @FXML
    private Label id_label;

    @FXML
    private Label name_label;

    @FXML
    private Label type_label;
    private offre offre;
     private interfaceoffer myListener;
    /**
     * Initializes the controller class.
     */
     public void setData(offre offre, interfaceoffer myListener) {
        this.offre = offre;
        this.myListener = myListener;
        //id_label.set(offre.getId_offre());
        name_label.setText(offre.getText_offre());
        date_label.setText(offre.getDate_offre());
        type_label.setText(offre.getType_offre());
        
       
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
              
        }
  

}