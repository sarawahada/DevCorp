/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import model.coupouns;
import model.offre;
import services.coupounsservice;
import services.offreservice;

import util.connexion;


/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class CoupounsController implements Initializable {
    
    
    @FXML
    private Button ajoutcoup;

    @FXML
    private TextField code_coup;

    @FXML
    private DatePicker date1_coup;

    @FXML
    private DatePicker date2_coup;

    @FXML
    private TextField duree_coup;

    @FXML
    private TextField id_coup;

    @FXML
    private TextField idp_coup;

    @FXML
    private TextField nom_coup;

    @FXML
    void ajoutcoup(ActionEvent event) throws IOException {
         if (nom_coup.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Please insert a name");
        alert.showAndWait();}
        else if(code_coup.getText().isEmpty()){
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(" please insert a type ");
        alert.showAndWait();
        }
       /* else if(date1_coup.getText().isEmpty()){
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(" please insert a a start date ");
        alert.showAndWait(); }
   
       else if(date2_coup.getText().isEmpty()){
        
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(" please insert a finish date date ");
        alert.showAndWait();}
        else if (idp_coup.getText().isEmpty()){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(" please insert a valid ID of a restaurnant ");
        alert.showAndWait();}*/
       else if(duree_coup.getText().isEmpty())
        {
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(" please insert a description  ");
        alert.showAndWait();}
        else{
            coupouns c = new coupouns();
            //p.setId_promo(Integer.valueOf(Id_promo.getText()));
            c.setText_coupouns(nom_coup.getText());
            c.setCode_coupouns(code_coup.getText());
            c.setDate_1(date1_coup.getValue().toString());
            c.setDate_2(date2_coup.getValue().toString());
            c.setId_promo1(Integer.valueOf(idp_coup.getText()));
            c.setDuree_coupouns(Integer.valueOf(duree_coup.getText()));
            
           // p.setType_promo(Integer.valueOf(type_promo.getText()));
            //p.setDate_d(date1_promo.getText());
           // p.setDate_f(date2_promo.getText());
            //p.setId_resto(Integer.valueOf(id_resto.getText()));
            //p.setText_promo(text_promo.getText());
            coupounsservice cs = new coupounsservice();
            cs.ajoutercoupouns(c);
           //Parent root = loader.load();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("promotion created successfully ");
       FXMLLoader loader = new FXMLLoader(getClass().getResource("coupounList.fxml"));
        Parent root = loader.load();
        nom_coup.getScene().setRoot(root);
        
        
        
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
   
        }


