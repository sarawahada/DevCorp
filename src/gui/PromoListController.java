/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.promo;
import util.maConnexion;

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
    private TableColumn<promo, String> col_date1_promo;

    @FXML
    private TableColumn<promo, String> col_date2_promo;

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
        @FXML
    private Label list;

 
       
    /**
     * Initializes the controller class.
     */
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      

              
         try {
             ObservableList<promo> promos = FXCollections.observableArrayList();
             
              // try {
             Connection cnx = maConnexion.getInstance().getCnx();
             Statement st = cnx.createStatement();
             ResultSet rs = cnx.createStatement().executeQuery("SELECT * FROM promo");
             while (rs.next()) {                
                promos.add(new promo(rs.getInt("id_promo"), rs.getString("nom_promo"),rs.getInt("type_promo") ,rs.getString("date_d"),rs.getString("date_f"),rs.getInt("id_resto"),rs.getString("text_promo")));
                 //ObservableList<offre> offres = afficheroffre();
                 col_id_promo.setCellValueFactory(new PropertyValueFactory<promo, Integer>("id_promo"));
                 col_nom_promo.setCellValueFactory(new PropertyValueFactory<promo, String>("nom_promo"));
                 col_type_promo.setCellValueFactory(new PropertyValueFactory<promo, Integer>("type_promo"));
                  col_date1_promo.setCellValueFactory(new PropertyValueFactory<promo, String>("date_d"));
                  col_date2_promo.setCellValueFactory(new PropertyValueFactory<promo, String>("date_f"));
                   col_id_resto.setCellValueFactory(new PropertyValueFactory<promo, Integer>("id_resto"));
                   col_text_promo.setCellValueFactory(new PropertyValueFactory<promo, String>("text_promo"));
                  
                 
               
                 tvpromo.setItems (promos);
                 
             }
         } catch (SQLException ex) {
             
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
              
          }
          

    }
      @FXML
    private void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        list.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("ChefDashboard.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
    }
 
}