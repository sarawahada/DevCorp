/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import css.JavaMail;
import css.Message;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import model.menu;
import model.restaurant;
import model.restaurantAttente;
import services.ServiceMenu;
import services.ServiceRestaurant;
import services.ServiceRestaurantAttente;
import util.maConnexion;

/**
 *
 * @author user
 */
public class controllerRestaurant_enattente implements Initializable{

    private Parent fxml;
    
    @FXML
    private TableView<restaurantAttente> afficher_restaurant_en_attente;
    
    private ObservableList<restaurantAttente> ob_list_restaurant_attente;
    
    @FXML
    private AnchorPane pane;
    
    @FXML
    private TableColumn<?, ?> col_id_restaurant_en_attente;

    @FXML
    private TableColumn<?, ?> col_nom_restaurant_en_attente;
    
    @FXML
    private TableColumn<?, ?> col_email;

    @FXML
    private TableColumn<?, ?> col_position_restaurant_en_attente;
    
    @FXML
    private Pane panel_gerer_restaurant_en_attente;
    
    @FXML
    private TextField text_nom_restaurant_en_attente;
    
    @FXML
    private TextField text_gerant_restaurant;
    
    @FXML
    private FontAwesomeIconView boutton_close;

    @FXML
    private TextField text_position_restaurant_en_attente;

    @FXML
    private DatePicker text_date_restaurant_en_attente;
    
    @FXML
    private Label id_label_restaurant_en_attente;
    
    @FXML
    private Rectangle rectImg;
    
    private String imPath;
    
    @FXML
    private TableColumn<?, ?> col_gerant;
    
    Connection cnx;
    
    @FXML
    private TextField zone_recherche;
    
    @FXML
    private TextField text_email;
    
    // methode d'affichage des restaurants
    public void show_restaurant_en_attente(){
        ServiceRestaurantAttente restaurantAttentes = new ServiceRestaurantAttente();
        ArrayList<restaurantAttente> list_restaurant_en_attente = new ArrayList<>();
        list_restaurant_en_attente = (ArrayList<restaurantAttente>) restaurantAttentes.afficherRestaurantAttente();
        
        ob_list_restaurant_attente = FXCollections.observableArrayList(list_restaurant_en_attente);
        
        afficher_restaurant_en_attente.setItems(ob_list_restaurant_attente);
    }
        
    @FXML
    void openRestaurant(ActionEvent event) {
        pane.getScene().getWindow().hide();
        Stage menu = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("/foodworlds/restaurant.fxml"));
            Scene scene = new Scene(fxml);
            menu.setScene(scene);
            menu.show();
        } catch (IOException ex) {
            Logger.getLogger(controllerRestaurant_gererrestaurant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void get_restaurant(MouseEvent e){
        restaurantAttente restaurants = afficher_restaurant_en_attente.getSelectionModel().getSelectedItem();
        text_nom_restaurant_en_attente.setText(String.valueOf(restaurants.getNom()));
        text_position_restaurant_en_attente.setText(String.valueOf(restaurants.getPosition()));
        text_gerant_restaurant.setText(String.valueOf(restaurants.getGerant_restaurant()));
        text_email.setText(String.valueOf(restaurants.getEmail()));
        //LocalDate date = LocalDate.of(2021, 12, 1);
        //text_date_restaurant_en_attente.setValue(date);
        id_label_restaurant_en_attente.setText(String.valueOf(restaurants.getId()));
        afficher_restaurant_en_attente.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.5));
            slide.setNode(panel_gerer_restaurant_en_attente);
            
            slide.setToX(0);
            slide.play();
            
            panel_gerer_restaurant_en_attente.setTranslateX(-970);
            
            get_restaurant(e);

        });
    }
    
    @FXML
    void annuler_restaurant(ActionEvent event){
        panel_gerer_restaurant_en_attente.setTranslateX(-970);
            
        text_nom_restaurant_en_attente.setText("");
        text_position_restaurant_en_attente.setText("");
        text_date_restaurant_en_attente.setValue(null);
        id_label_restaurant_en_attente.setText("ID");
    }
    
    @FXML
    void enregistrer_restaurant(ActionEvent event){
        String request = "insert into restaurant (nom,position,date_entrer,image,gerant_restaurant) values(?,?,?,?,?)";
        String id_restaurant = id_label_restaurant_en_attente.getText();
        String nom_restaurant = text_nom_restaurant_en_attente.getText();
        String position = text_position_restaurant_en_attente.getText();
        String email = text_email.getText();
        Date date_peremption = Date.valueOf(text_date_restaurant_en_attente.getValue());
        String gerant = text_gerant_restaurant.getText();
        //Date date_mise_en_rayon = Date.valueOf(text_date_mise_en_rayon.getValue());
        //File images = new File(lab_url.getText());
        restaurantAttente p = new restaurantAttente(nom_restaurant, position, date_peremption,gerant);
        //menu p = new menu(nom_restaurant, saison_menu, quanitite_menu, prix_menu, date_mise_en_rayon, date_peremption);
        cnx = maConnexion.getInstance().getCnx();
        try {
            PreparedStatement ps = cnx.prepareStatement(request);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPosition());
            ps.setString(3, String.valueOf(p.getDate_entrer()));
            if(imPath != null){
            try {
                InputStream is = new FileInputStream(new File(imPath));
                ps.setBlob(4, is);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ServiceMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            ps.setString(5, p.getGerant_restaurant());
            ps.executeUpdate();
            System.out.println("Ajout");
                try {
                    JavaMail.sendMail(email);
                } catch (Exception ex) {
                    Logger.getLogger(controllerRestaurant_enattente.class.getName()).log(Level.SEVERE, null, ex);
                }
            ServiceRestaurantAttente service = new ServiceRestaurantAttente();
            service.supprimer2RestaurantAttente(id_restaurant);
            panel_gerer_restaurant_en_attente.setTranslateX(-970);
            ob_list_restaurant_attente.clear();
            show_restaurant_en_attente();
            //panel_gerer_restaurant_en_attente.setTranslateX((-850));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @FXML
    void modifier_restaurant(ActionEvent event){
        Message message = new Message();
        
                if(!text_nom_restaurant_en_attente.getText().equals("")){
                    if(!text_position_restaurant_en_attente.getText().equals("")){

                            ServiceRestaurantAttente servicesrestaurants = new ServiceRestaurantAttente();
                            String nom_restaurant = text_nom_restaurant_en_attente.getText();
                            String position_restaurant = text_position_restaurant_en_attente.getText();
                            Date date = Date.valueOf(text_date_restaurant_en_attente.getValue());
                            String id_restaurant = id_label_restaurant_en_attente.getText();
                            String gerant = text_gerant_restaurant.getText();
                            servicesrestaurants.modifier2RestaurantAttente(id_restaurant, nom_restaurant, position_restaurant,gerant);
                            
                            ob_list_restaurant_attente.clear();
                            show_restaurant_en_attente();
                            
                            message.valide_message("Success", "Updated", "Restaurant was updated !");
                            
                            text_nom_restaurant_en_attente.setText("");
                            text_position_restaurant_en_attente.setText("");
                            text_date_restaurant_en_attente.setValue(null);
                            id_label_restaurant_en_attente.setText("ID");

                    }else{
                        message.error_message("Error", "Error in field", "Enter first name restaurant !");
                    }
                }else{
                    message.error_message("Error", "Error in field", "Enter last name restaurant !");
                }
    }
    
    @FXML
    void reset_from_restaurant(ActionEvent event){
        id_label_restaurant_en_attente.setText("ID");
        text_nom_restaurant_en_attente.setText("");
        text_position_restaurant_en_attente.setText("");
        text_gerant_restaurant.setText("");
        text_date_restaurant_en_attente.setValue(null);
        
        show_restaurant_en_attente();
    }
    
     @FXML
    void load(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterjpg = new FileChooser.ExtensionFilter("jpg files (*.png)", "*.png");
        FileChooser.ExtensionFilter extFilterpng = new FileChooser.ExtensionFilter("png files (*.jpg)", "*.jpg");
        fileChooser.getExtensionFilters().addAll(extFilterjpg, extFilterpng);

        File file = fileChooser.showOpenDialog(null);
        
        if (file != null) {
            if (file.length() < 6000000) {
                System.out.print("Condition ok");
                System.out.println(file.length());
                BufferedImage bufferedImage = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                rectImg.setFill(new ImagePattern(image));
                imPath = file.getAbsolutePath();
            } else {
            }
            }
    }

public void handleClose(javafx.scene.input.MouseEvent event){
        if(event.getSource() == boutton_close){
            System.exit(0);
        }
    }

    @FXML
    void rechercher_restaurant_attente(ActionEvent event) {
        Message message = new Message();
        
        if(!zone_recherche.getText().equals("")){
            String nom = zone_recherche.getText();
            ServiceRestaurantAttente restaurants = new ServiceRestaurantAttente();
            ArrayList<restaurantAttente> list_recherche = new ArrayList<>();
            list_recherche = (ArrayList<restaurantAttente>) restaurants.recherche_nom_Restaurant_Attente(nom);

            ob_list_restaurant_attente = FXCollections.observableArrayList(list_recherche);
            
            //tableau_afficher_restaurant.setItems(ob_list_restaurant);
            afficher_restaurant_en_attente.setItems(ob_list_restaurant_attente);

            //afficher_restaurant.setItems(ob_list_restaurant);

        }else{
            message.error_message("Error", "Error in field", "Enter something to search !");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        panel_gerer_restaurant_en_attente.setTranslateX(-970);
        
        //Tableau Restaurant en attente
        col_id_restaurant_en_attente.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_nom_restaurant_en_attente.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_position_restaurant_en_attente.setCellValueFactory(new PropertyValueFactory<>("position"));
        col_gerant.setCellValueFactory(new PropertyValueFactory<>("gerant_restaurant"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        //Affichage Restaurant en attente
        show_restaurant_en_attente();
    }
    
}
