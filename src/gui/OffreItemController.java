/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.offre;
import interfaces.interfaceoffer;
import javafx.scene.control.Label;

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