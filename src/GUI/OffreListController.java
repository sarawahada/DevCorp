/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package GUI;
//import com.sun.javafx.logging.PlatformLogger.Level;
//import com.sun.javafx.logging.PlatformLogger.Level;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.offre;

import java.io.IOException;
//import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

import util.connexion;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */

public class OffreListController implements Initializable {
   
      // @FXML
   // private ListView<String> offrelistview;
      // ListView<String> offrelistview = new ListView<>();
       // offrelistview.getItems().add("abir");
     @FXML
    private Label lbdate;

    @FXML
    private Label lbid;

    @FXML
    private Label lbnom;

    @FXML
    private Label lbtype;
 @FXML
    private TableView<offre> tvoffre;
    @FXML
    private TableColumn<offre,Integer> col_id_offre;
    @FXML
    private TableColumn<offre, String> col_nom_offre;
    @FXML
    private TableColumn<offre, String> col_type_offre;
    @FXML
    private TableColumn<offre, DatePicker> col_date_offre;
      @FXML
    private AnchorPane anchotpane_right;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_update;
      
       
       
   @FXML
    private TextField tf_date;

    @FXML
    private TextField tf_id;

    @FXML
    private TextField tf_nom;

    @FXML
    private TextField tf_type;
    
   @FXML
    private Button btn_save;
    private boolean EDIT=false,     ADD=false;
    private int ID;
       
    /**
     * Initializes the controller class.
     */
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      

              
         try {
             ObservableList<offre> offres = FXCollections.observableArrayList();
             
              // try {
             Connection cnx = connexion.getInstance().getCnx();
             Statement st = cnx.createStatement();
             ResultSet rs = cnx.createStatement().executeQuery("SELECT * FROM offre");
             while (rs.next()) {
                 offres.add(new offre(rs.getInt("id_offre"), rs.getString("text_offre"), rs.getString("date_offre"),rs.getString("type_offre")));
                 //ObservableList<offre> offres = afficheroffre();
                 col_id_offre.setCellValueFactory(new PropertyValueFactory<offre, Integer>("id_offre"));
                 col_nom_offre.setCellValueFactory(new PropertyValueFactory<offre, String>("text_offre"));
                
                 col_date_offre.setCellValueFactory(new PropertyValueFactory<offre, DatePicker>("date_offre"));
                 col_type_offre.setCellValueFactory(new PropertyValueFactory<offre, String>("type_offre"));
                 tvoffre.setItems (offres);
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(OffreListController.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
  
 
           
       @FXML
    void btn_update(ActionEvent event) {

    
          try {
              Stage stage = new Stage();
              
          FXMLLoader loader = new FXMLLoader(getClass().getResource("offreupdate.fxml"));
          
              Parent root = loader.load();
              Scene scene = new Scene(root);
              stage.setScene(scene);
              stage.setTitle("update");
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(OffreListController.class.getName()).log(Level.SEVERE, null, ex);
          }
          
      }
     @FXML
    void btn_add(ActionEvent event) {
        
          try {
              Stage stage = new Stage();
              
          FXMLLoader loader = new FXMLLoader(getClass().getResource("offre.fxml"));
          
              Parent root = loader.load();
              Scene scene = new Scene(root);
              stage.setScene(scene);
              stage.setTitle("update");
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(OffreListController.class.getName()).log(Level.SEVERE, null, ex);
          }

    }
}