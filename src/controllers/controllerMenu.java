/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author sarawahada
 */
public class controllerMenu implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private FontAwesomeIconView boutton_close;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuBack;
    @FXML
    private VBox slide_menu;
    @FXML
    private Button boutton_restaurant1;
    @FXML
    private Button boutton_parametre1;
    @FXML
    private VBox panel_menu;
    @FXML
    private Button boutton_menu;
    @FXML
    private VBox chosenCard;
    @FXML
    private Label label_name_plat;
    @FXML
    private Label label_prix_menu;
    @FXML
    private ImageView imagePlat;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private Pane panel_gerer_menu;
    @FXML
    private Label id_label_menu;
    @FXML
    private TextField text_nom_menu;
    @FXML
    private TextField text_saison_menu;
    @FXML
    private DatePicker text_date_permption;
    @FXML
    private Button boutton_annuler;
    @FXML
    private TextField text_quantite_menu;
    @FXML
    private TextField text_prix_menu;
    @FXML
    private DatePicker text_date_mise_en_rayon;
    @FXML
    private Button load_image;
    @FXML
    private Rectangle rectImg;
    @FXML
    private TextField text_id_restaurant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleClose(MouseEvent event) {
    }

    @FXML
    private void openRestaurant(ActionEvent event) {
    }

    @FXML
    private void boutton_enregistrer(ActionEvent event) {
    }

    @FXML
    private void enregistrer_menu(ActionEvent event) {
    }

    @FXML
    private void rest_from_menu(ActionEvent event) {
    }

    @FXML
    private void modifier_menu(ActionEvent event) {
    }

    @FXML
    private void annuler_menu(ActionEvent event) {
    }

    @FXML
    private void load_image(ActionEvent event) {
    }

    @FXML
    private void supprimer_menu(ActionEvent event) {
    }
    
}
