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
import model.coupouns;
import model.promo;
import util.connexion;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */

public class CoupounListController implements Initializable {
   
      // @FXML
   // private ListView<String> offrelistview;
      // ListView<String> offrelistview = new ListView<>();
       // offrelistview.getItems().add("abir");
     @FXML
    private Button btn_update;

    @FXML
    private TableColumn<coupouns, String> col_code_coup;

    @FXML
    private TableColumn<coupouns, DatePicker> col_date1_coupoun;

    @FXML
    private TableColumn<coupouns, DatePicker> col_date2_coupoun;

    @FXML
    private TableColumn<coupouns, Integer> col_duree_coupoun;

    @FXML
    private TableColumn<coupouns, Integer> col_id_coupoun;

    @FXML
    private TableColumn<coupouns, Integer> col_id_promo1;

    @FXML
    private TableColumn<coupouns, String> col_nom_coupoun;

    @FXML
    private TableView<coupouns> tvcoupoun;

    @FXML
    void btn_updatec(ActionEvent event) {
try {
              Stage stage = new Stage();
              
          FXMLLoader loader = new FXMLLoader(getClass().getResource("coupounupdate.fxml"));
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
              
          FXMLLoader loader = new FXMLLoader(getClass().getResource("coupouns.fxml"));
             Parent root = loader.load();
              Scene scene = new Scene(root);
              stage.setScene(scene);
              stage.setTitle("update");
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(OffreListController.class.getName()).log(Level.SEVERE, null, ex);
          }

    }

       
    /**
     * Initializes the controller class.
     */
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      

              
         try {
             ObservableList<coupouns> coupoun = FXCollections.observableArrayList();
             
              // try {
             Connection cnx = connexion.getInstance().getCnx();
             Statement st = cnx.createStatement();
             ResultSet rs = cnx.createStatement().executeQuery("SELECT * FROM coupouns");
             //String request = "INSERT INTO `coupouns`(`id_coupouns`, `text_coupouns`, `code_coupouns`, `date_1`,`date_2`,`id_promo1`,`duree_coupouns`) 
             while (rs.next()) {                
                coupoun.add(new coupouns(rs.getInt("id_coupouns"), rs.getString("id_coupouns"),rs.getString("code_coupouns") ,rs.getString("date_1"),rs.getString("date_2"),rs.getInt("id_promo1"),rs.getInt("duree_coupouns")));
                 //ObservableList<offre> offres = afficheroffre();
                 col_id_coupoun.setCellValueFactory(new PropertyValueFactory<coupouns, Integer>("id_coupouns"));
                 col_nom_coupoun.setCellValueFactory(new PropertyValueFactory<coupouns, String>("id_coupouns"));
                 col_code_coup.setCellValueFactory(new PropertyValueFactory<coupouns, String>("code_coupouns"));
                  col_date1_coupoun.setCellValueFactory(new PropertyValueFactory<coupouns, DatePicker>("date_1"));
                  col_date2_coupoun.setCellValueFactory(new PropertyValueFactory<coupouns, DatePicker>("date_2"));
                   col_id_promo1.setCellValueFactory(new PropertyValueFactory<coupouns, Integer>("id_promo1"));
                   col_duree_coupoun.setCellValueFactory(new PropertyValueFactory<coupouns, Integer>("duree_coupouns"));
                  
                 
               
                 tvcoupoun.setItems (coupoun);
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(CoupounListController.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    
 
}