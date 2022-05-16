/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import css.Message;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.restaurant;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import services.ServiceRestaurant;
import services.ServiceRestaurantAttente;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class controllerRestaurant implements Initializable{

    @FXML
    private Button boutton_restaurant;

    @FXML
    private Button boutton_parametre;
    
    @FXML
    private Button boutton_annuler;

    @FXML
    private TableView<restaurant> tableau_afficher_restaurant;

    @FXML
    private Pane pnlStatus;
    
    @FXML
    private Button boutton_recherche_restaurant;

    @FXML
    private Label label_affichage_restaurant;
    
    @FXML
    private FontAwesomeIconView boutton_close;
    
    @FXML
    private VBox slide_menu;
    
    private ObservableList<restaurant> ob_list_restaurant;
    
    @FXML
    private TableColumn<?, ?> col_id;

    @FXML
    private TableColumn<?, ?> col_nom;

    @FXML
    private TableColumn<?, ?> col_position;
    
    @FXML
    private TableColumn<?, ?> col_gerant;

    @FXML
    private TableColumn<?, ?> col_date_adhesion;
    
    @FXML
    private Label id_label_restaurant;

    @FXML
    private TextField text_nom_restaurant;

    @FXML
    private TextField text_position_restaurant;

    @FXML
    private DatePicker text_date_restaurant;
    
    @FXML
    private Pane panel_gerer_restaurant;
    
    @FXML
    private Pane panel_menu;
    
    @FXML
    private Label Menu;

    @FXML
    private Label MenuBack;
    
    private Parent fxml;
    
     @FXML
    private AnchorPane pane;
     
     @FXML
    private TextField text_gerant_restaurant;
     
      @FXML
    private TextField zone_recherche;
    
    // methode d'affichage des restaurants
    public void show_restaurant(){
        ServiceRestaurant restaurants = new ServiceRestaurant();
        ArrayList<restaurant> list_restaurant = new ArrayList<>();
        list_restaurant = (ArrayList<restaurant>) restaurants.afficherRestaurant();
        
        ob_list_restaurant = FXCollections.observableArrayList(list_restaurant);
        
        tableau_afficher_restaurant.setItems(ob_list_restaurant);
    }
    
    @FXML
    private void handleClicks(ActionEvent event){
        if(event.getSource() == boutton_restaurant){
            label_affichage_restaurant.setText("Restaurant");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(153, 153, 153), CornerRadii.EMPTY, Insets.EMPTY)));
            TranslateTransition transition = new TranslateTransition();
            transition.setDuration(Duration.seconds(0.0001));
            transition.setNode(slide_menu);
            
            transition.setToX(+217);
            transition.play();
            slide_menu.toFront();
            
        }else
            if(event.getSource() == boutton_parametre){
                TranslateTransition transition = new TranslateTransition();
                transition.setDuration(Duration.seconds(0.0001));
                transition.setNode(slide_menu);
                transition.setToX(-217);
                transition.play();
                slide_menu.toBack();
        }else{
                
            }
    }
    
    public void handleClose(javafx.scene.input.MouseEvent event){
        if(event.getSource() == boutton_close){
            System.exit(0);
        }
    }
    
    // Enregistrement dess restaurants
    /*@FXML
    public void enregistrer_restaurant(ActionEvent e){
            Message message = new Message();
            //Date date1 = Date.valueOf(text_date_restaurant.getValue());
                if(id_label_restaurant.getText().equals("ID")){
                if(!text_nom_restaurant.getText().equals("")){
                    if(!text_position_restaurant.getText().equals("")){
                            ServiceRestaurant servicesrestaurants = new ServiceRestaurant();
                            String nom_restaurant = text_nom_restaurant.getText();
                            String position_restaurant = text_position_restaurant.getText();
                            Date date = Date.valueOf(text_date_restaurant.getValue());
                            restaurant p = new restaurant(nom_restaurant,position_restaurant,date);
                            servicesrestaurants.ajouterRestaurant(p);
                            
                            ob_list_restaurant.clear();
                            show_restaurant();
                            
                            message.valide_message("Succes", "Bien enregistrer", "Le restaurant a été enregistré avec succès !");
                            
                            text_nom_restaurant.setText("");
                            text_position_restaurant.setText("");
                            text_date_restaurant.setValue(null);

                    }else{
                        message.error_message("Erreur", "Erreur du champ", "Veuillez entrer la position du restaurant SVP !");
                    }
                }else{
                    message.error_message("Erreur", "Erreur du champ", "Veuillez entrer le nom du restaurant SVP !");
                }
            }else{
                message.error_message("Erreur", "Erreur des champ", "Veuillez appuyer sur le boutton reset pour reinitialiser le formulaire car la ligne est selectionne dans le tableau !");
            }
                
    }*/
    
    //Lorsqu'on selection un restaurant dans le tableau
    @FXML
    public void get_restaurant(MouseEvent e){

        restaurant restaurants = tableau_afficher_restaurant.getSelectionModel().getSelectedItem();
        text_nom_restaurant.setText(String.valueOf(restaurants.getNom()));
        text_position_restaurant.setText(String.valueOf(restaurants.getPosition()));
        text_date_restaurant.setValue(null);
        text_gerant_restaurant.setText(String.valueOf(restaurants.getGerant_restaurant()));
        id_label_restaurant.setText(String.valueOf(restaurants.getId()));
        
        tableau_afficher_restaurant.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.5));
            slide.setNode(panel_gerer_restaurant);
            
            slide.setToX(0);
            slide.play();
            
            panel_gerer_restaurant.setTranslateX(-970);
            
            get_restaurant(e);

        });
    }
    
    //Reinitialiser le formulaire restaurant
    @FXML
    public void reset_from_restaurant(ActionEvent e){
        id_label_restaurant.setText("ID");
        text_nom_restaurant.setText("");
        text_position_restaurant.setText("");
        text_gerant_restaurant.setText("");
        text_date_restaurant.setValue(null);
        
        show_restaurant();
    }
    
    @FXML
    public void modifier_restaurant(ActionEvent e){
        Message message = new Message();
        
                if(!text_nom_restaurant.getText().equals("")){
                    if(!text_position_restaurant.getText().equals("")){

                            ServiceRestaurant servicesrestaurants = new ServiceRestaurant();
                            String nom_restaurant = text_nom_restaurant.getText();
                            String position_restaurant = text_position_restaurant.getText();
                            Date date = Date.valueOf(text_date_restaurant.getValue());
                            String id_restaurant = id_label_restaurant.getText();
                            String gerant_restaurant = text_gerant_restaurant.getText();
                            servicesrestaurants.modifier2(id_restaurant, nom_restaurant, position_restaurant, date, gerant_restaurant);
                            
                            ob_list_restaurant.clear();
                            show_restaurant();
                            
                            message.valide_message("Succes", "Modifier reussite", "Le restaurant a été modifier avec succès !");
                            
                            text_nom_restaurant.setText("");
                            text_position_restaurant.setText("");
                            text_date_restaurant.setValue(null);
                            id_label_restaurant.setText("ID");
                            text_gerant_restaurant.setText("");

                    }else{
                        message.error_message("Error", "Error in filed", "Enter first name restaurant !");
                    }
                }else{
                    message.error_message("Error", "Error in filed", "Enter last name restaurant !");
                }
    }
    
    @FXML
    public void annuler_restaurant(ActionEvent e){
        
            panel_gerer_restaurant.setTranslateX(-970);
            text_gerant_restaurant.setText("");
            text_nom_restaurant.setText("");
            text_position_restaurant.setText("");
            text_date_restaurant.setValue(null);
            id_label_restaurant.setText("ID");
    }
    
    public void enlever_transition_panel_gerer_restaurant(){
        //Transition
        ScaleTransition transition1 = new ScaleTransition(Duration.seconds(0.001), panel_gerer_restaurant);
        transition1.setToX(0);
        transition1.setToY(0);
        transition1.play();
    }
    
    public void afficher_transition_panel_gerer_restaurant(){
        //Transition
        ScaleTransition transition1 = new ScaleTransition(Duration.seconds(0.001), panel_gerer_restaurant);
        transition1.setToX(0);
        transition1.setToY(0);
        transition1.play();
    }
    
    @FXML
    void openRestaurantattente(ActionEvent event) {
        pane.getScene().getWindow().hide();
        Stage menu = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("/foodworlds/restaurant_attente.fxml"));
            Scene scene = new Scene(fxml);
            menu.setScene(scene);
            menu.show();
        } catch (IOException ex) {
            Logger.getLogger(controllerRestaurant_gererrestaurant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void rechercher_restaurant(ActionEvent event) {
        Message message = new Message();
        
        if(!zone_recherche.getText().equals("")){
            String nom = zone_recherche.getText();
            ServiceRestaurant restaurants = new ServiceRestaurant();
            ArrayList<restaurant> list_recherche = new ArrayList<>();
            list_recherche = (ArrayList<restaurant>) restaurants.recherche_nom(nom);

            ob_list_restaurant = FXCollections.observableArrayList(list_recherche);
            
            tableau_afficher_restaurant.setItems(ob_list_restaurant);

            //afficher_restaurant.setItems(ob_list_restaurant);

        }else{
            message.error_message("Error", "Error in field", "Enter something to search !");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_position.setCellValueFactory(new PropertyValueFactory<>("position"));
        col_date_adhesion.setCellValueFactory(new PropertyValueFactory<>("date_entrer"));
        col_gerant.setCellValueFactory(new PropertyValueFactory<>("gerant_restaurant"));
        
        panel_gerer_restaurant.setTranslateX(-970);
        panel_menu.setTranslateX(-210);
        //slide_menu.setTranslateX(-210);
        Menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.5));
            slide.setNode(panel_menu);
            
            slide.setToX(0);
            slide.play();
            
            panel_menu.setTranslateX(-210);
            
            slide.setOnFinished((ActionEvent e)-> {
                Menu.setVisible(false);
                MenuBack.setVisible(true);
            });
        });
        
        MenuBack.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.5));
            slide.setNode(panel_menu);
            
            slide.setToX(-210);
            slide.play();
            
            panel_menu.setTranslateX(0);
            
            slide.setOnFinished((ActionEvent e)-> {
                Menu.setVisible(true);
                MenuBack.setVisible(false);
            });
        });
        
        //Affichage Restaurant        
        show_restaurant();
    }
    
}