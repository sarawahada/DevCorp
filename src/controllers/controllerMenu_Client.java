/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import controllers.controllerMenuClient;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import interfaces.MyListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.menu;
import services.ServiceMenu;
/**
 *
 * @author user
 */
public class controllerMenu_Client implements Initializable{
    
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
    private Button boutton_parametre;

    @FXML
    private Button boutton_recherche_restaurant;

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
    private Label label;
    
    private MyListener myListener;
    
    private  List<menu> menus = new ArrayList<>();
    
    String variable;
    
    private Parent fxml;
    
     @FXML
    private AnchorPane pane;

    controllerMenuClient controllers = new controllerMenuClient();
    String nom = controllers.nom;
    
    public void show_menu(String nom){
        ServiceMenu servicemenus = new services.ServiceMenu();
        menus.addAll(servicemenus.afficherMenu2(nom));
        if(menus.size() > 0){
            setchosen(menus.get(0));
            myListener = new MyListener() {
                @Override
                public void conClickListener(menu menus) {
                    setchosen(menus);
                }
            };
        }
        
        int column = 0;
        int row =1;
        try {
            for(int i=0; i < menus.size(); i++){
                FXMLLoader fmxlLoader =  new FXMLLoader();
                fmxlLoader.setLocation(getClass().getResource("/foodworlds/plat.fxml"));
                AnchorPane anchorpane =  fmxlLoader.load();

                controllerPlat Controllerplat = fmxlLoader.getController();
                Controllerplat.setData(menus.get(i),myListener);
                
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
    private void setchosen(menu menus){
        label_name_plat.setText(menus.getNom());
        label_prix_menu.setText(menus.getPrix());
        //label_id.setText(menus.getId2());
        Blob blob;
        byte byteImg[];
        blob = menus.getImgSrc();
        try {
            byteImg = blob.getBytes(1, (int) blob.length());
            Image image = new Image(new ByteArrayInputStream(byteImg),imagePlat.getFitWidth(),imagePlat.getFitHeight(),true,true);
            imagePlat.setImage(image);
        } catch (SQLException ex) {
            Logger.getLogger(controllerMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        //image = new Image(getClass().getResourceAsStream(menus.getImgSrc()));
        //imagePlat.setImage(image);
    }
    
    public void handleClose(javafx.scene.input.MouseEvent event){
        if(event.getSource() == boutton_close){
            System.exit(0);
        }
    }
    
    @FXML
    void open_restaurant(ActionEvent event) {
        pane.getScene().getWindow().hide();
        Stage menu = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("/foodworlds/restaurant_client.fxml"));
            Scene scene = new Scene(fxml);
            menu.setScene(scene);
            menu.show();
        } catch (IOException ex) {
            Logger.getLogger(controllerRestaurant_gererrestaurant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //label.setText(nom);
        //System.out.println(nom);
        //show_menu("");
    }
     public void myFonction(String text){
         show_menu(text);
         //label.setText(text);
     }
}
