/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class controllerRestaurant_gererrestaurant implements Initializable{

    @FXML
    private AnchorPane pane;
    
    @FXML
    private Button boutton_restaurant;
    
    @FXML
    private Button boutton_menu;
    
    @FXML
    private FontAwesomeIconView boutton_close;
    
    private Parent fxml;
    
    @FXML
    void openMenu(ActionEvent event) {
        pane.getScene().getWindow().hide();
        Stage menu = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("/foodworlds/menu.fxml"));
            Scene scene = new Scene(fxml);
            menu.setScene(scene);
            menu.show();
        } catch (IOException ex) {
            Logger.getLogger(controllerRestaurant_gererrestaurant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void openRestaurant(ActionEvent event) {

    }
    
    public void handle_close(javafx.scene.input.MouseEvent event){
        if(event.getSource() == boutton_close){
            System.exit(0);
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
