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
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import model.promo;
import util.connexion;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */

public class PromoListController implements Initializable {
   
      // @FXML
   // private ListView<String> offrelistview;
      // ListView<String> offrelistview = new ListView<>();
       // offrelistview.getItems().add("abir");
   
    @FXML
    private Button btn_update;

    @FXML
    private TableColumn<promo, DatePicker> col_date1_promo;

    @FXML
    private TableColumn<promo, DatePicker> col_date2_promo;

    @FXML
    private TableColumn<promo, Integer> col_id_promo;

    @FXML
    private TableColumn<promo, Integer> col_id_resto;

    @FXML
    private TableColumn<promo, String> col_nom_promo;

    @FXML
    private TableColumn<promo, String> col_text_promo;

    @FXML
    private TableColumn<promo, Integer> col_type_promo;

    @FXML
    private TableView<promo> tvpromo;

 
       
    /**
     * Initializes the controller class.
     */
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      

              
         try {
             ObservableList<promo> promos = FXCollections.observableArrayList();
             
              // try {
             Connection cnx = connexion.getInstance().getCnx();
             Statement st = cnx.createStatement();
             ResultSet rs = cnx.createStatement().executeQuery("SELECT * FROM promo");
             while (rs.next()) {                
                promos.add(new promo(rs.getInt("id_promo"), rs.getString("nom_promo"),rs.getInt("type_promo") ,rs.getString("date_d"),rs.getString("date_f"),rs.getInt("id_resto"),rs.getString("text_promo")));
                 //ObservableList<offre> offres = afficheroffre();
                 col_id_promo.setCellValueFactory(new PropertyValueFactory<promo, Integer>("id_promo"));
                 col_nom_promo.setCellValueFactory(new PropertyValueFactory<promo, String>("nom_promo"));
                 col_type_promo.setCellValueFactory(new PropertyValueFactory<promo, Integer>("type_promo"));
                  col_date1_promo.setCellValueFactory(new PropertyValueFactory<promo, DatePicker>("date_d"));
                  col_date2_promo.setCellValueFactory(new PropertyValueFactory<promo, DatePicker>("date_f"));
                   col_id_resto.setCellValueFactory(new PropertyValueFactory<promo, Integer>("id_resto"));
                   col_text_promo.setCellValueFactory(new PropertyValueFactory<promo, String>("date_d"));
                  
                 
               
                 tvpromo.setItems (promos);
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(PromoListController.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
     @FXML
    void btn_updatep(ActionEvent event) {
        
        try {
              Stage stage = new Stage();
              
          FXMLLoader loader = new FXMLLoader(getClass().getResource("promoupdate.fxml"));
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
              
          FXMLLoader loader = new FXMLLoader(getClass().getResource("promo.fxml"));
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