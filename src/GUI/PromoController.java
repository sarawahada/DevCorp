/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

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
import javafx.scene.control.TextArea;


import interfaces.Ipromo;
import java.awt.event.MouseEvent;
import java.io.IOException;
//import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import model.promo;
import services.promoservice;
import util.connexion;
/**
 * FXML Controller class
 *
 * @author LENOVO
 */

public class PromoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
private TextField Id_promo;

    @FXML
    private TextField nom_promo;

    @FXML
    private TextField type_promo;

     @FXML
    private DatePicker date1_promo;

    @FXML
    private DatePicker date2_promo;
    @FXML
    private TextField id_resto;

    @FXML
    private TextArea text_promo;

 
    private Button btn_ajouter_promo;

 
    

             @Override
    public void initialize(URL url, ResourceBundle rb) {
     
       
    }    

    @FXML
    void ajouterpromo(ActionEvent event) throws IOException , SQLException ,MessagingException{
         if (nom_promo.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Please insert a name");
        alert.showAndWait();}
        else if(type_promo.getText().isEmpty()){
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(" please insert a type ");
        alert.showAndWait();
        }
       /* else if(date1_promo.getValue().isEmpty()){
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(" please insert a a start date ");
        alert.showAndWait(); }
   
       else if(date2_promo.getText().isEmpty()){
        
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(" please insert a finish date date ");
        alert.showAndWait();}*/
        else if (id_resto.getText().isEmpty()){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(" please insert a valid ID of a restaurnant ");
        alert.showAndWait();}
       else if(text_promo.getText().isEmpty())
        {
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(" please insert a description  ");
        alert.showAndWait();}
        else{
            promo p = new promo();
            //p.setId_promo(Integer.valueOf(Id_promo.getText()));
            p.setNom_promo(nom_promo.getText());
            p.setType_promo(Integer.valueOf(type_promo.getText()));
            p.setDate_d(date1_promo.getValue().toString());
            p.setDate_f(date2_promo.getValue().toString());
            p.setId_resto(Integer.valueOf(id_resto.getText()));
            p.setText_promo(text_promo.getText());
            promoservice ps = new promoservice();
            ps.ajouterpromo(p);
           // Parent root = loader.load();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("promotion created successfully ");
       FXMLLoader loader = new FXMLLoader(getClass().getResource("promoList.fxml"));
        Parent root = loader.load();
        nom_promo.getScene().setRoot(root);
        
        
        
        }

    }


    
   
    
}



