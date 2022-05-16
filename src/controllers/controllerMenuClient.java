/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import interfaces.MyListener;
import interfaces.MyListenerResto;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.menu;
import model.restaurant;
import services.ServiceMenu;
import services.ServiceRestaurant;

/**
 *
 * @author user
 */
public class controllerMenuClient implements Initializable{
    
    @FXML
    private VBox slide_menu;

    @FXML
    private Button boutton_restaurant1;

    @FXML
    private Button boutton_parametre1;

    @FXML
    private Button boutton_restaurant11;

    @FXML
    private Button boutton_restaurant;

    @FXML
    private FontAwesomeIconView boutton_close;

    @FXML
    private Button boutton_recherche_restaurant;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

    @FXML
    private Button boutton_recherche_restaurant1;

    @FXML
    private VBox chosenCard;

    @FXML
    private Label label_name_resto;
    
    @FXML
    private Label label_id;

    @FXML
    private ImageView imageResto;
    
    private List<restaurant> restaurants = new ArrayList<>();
    
    private MyListenerResto MyListenerResto;
    
    private Image image;
    
    private Parent fxml;
    
    public String nom = "AZERTY";
    
    @FXML
    private AnchorPane pane;

    @FXML
    void handleClicks(ActionEvent event) {
        
    }

    public void handleClose(javafx.scene.input.MouseEvent event){
        if(event.getSource() == boutton_close){
            System.exit(0);
        }
    }
    
    public void show_menu(){
        ServiceRestaurant servicerestaurants = new services.ServiceRestaurant();
        restaurants.addAll(servicerestaurants.afficherRestaurant2());
        if(restaurants.size() > 0){
            setchosen(restaurants.get(0));
            MyListenerResto = new MyListenerResto() {
                @Override
                public void conClickListener(restaurant restaurants) {
                    setchosen(restaurants);
                }
            };
        }
        
        int column = 0;
        int row =1;
        try {
            for(int i=0; i < restaurants.size(); i++){
                FXMLLoader fmxlLoader =  new FXMLLoader();
                fmxlLoader.setLocation(getClass().getResource("/foodworlds/resto.fxml"));
                AnchorPane anchorpane =  fmxlLoader.load();

                controllerResto ControllerResto = fmxlLoader.getController();
                ControllerResto.setData(restaurants.get(i),MyListenerResto);
                
                if(column == 3){
                    column = 0;
                    row ++;
                }
                
                grid.add(anchorpane, column++, row);
                GridPane.setMargin(anchorpane, new Insets(10));
            }
        } catch (IOException ex) {
            Logger.getLogger(controllerMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setchosen(restaurant restaurants){
        label_name_resto.setText(restaurants.getNom());
        nom = label_name_resto.getText();
        label_id.setText(String.valueOf(restaurants.getId()));
        //label_prix_menu.setText(menus.getPrix());
        //label_id.setText(menus.getId2());
        Blob blob;
        byte byteImg[];
        blob = restaurants.getImgSrc();
        try {
            byteImg = blob.getBytes(1, (int) blob.length());
            image = new Image(new ByteArrayInputStream(byteImg),imageResto.getFitWidth(),imageResto.getFitHeight(),true,true);
            imageResto.setImage(image);
        } catch (SQLException ex) {
            Logger.getLogger(controllerMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void afficher_menu(ActionEvent event){
        //final String nom2 = label_name_resto.getText();
        //System.out.println(label_name_resto.getText());
        //nom = label_name_resto.getText();
        pane.getScene().getWindow().hide();
        //Stage menu = new Stage();
        //fxml = FXMLLoader.load(getClass().getResource("/foodworlds/menuClient.fxml"));
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/foodworlds/menuClient.fxml"));
            Parent root = (Parent) loader.load();
            controllerMenu_Client controllers = loader.getController();
            controllers.myFonction(label_id.getText());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(controllerMenuClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Scene scene = new Scene(fxml);
        //menu.setScene(scene);
        //menu.show();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        show_menu();
    }
    
}
