/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import interfaces.MyListenerResto;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.restaurant;

/**
 *
 * @author user
 */
public class controllerResto {
    
    @FXML
    private Label label_name;
    
    @FXML
    private Label label_id;
    
    @FXML
    private ImageView img;

    private restaurant restaurant;
    
    private MyListenerResto mylistenerResto;
    
    Blob blob;
    
    byte byteImg[];
    
    @FXML
    private void click(MouseEvent event) {
        mylistenerResto.conClickListener(restaurant);
    }

    public void setData(restaurant restaurant, MyListenerResto MyListenerResto) {
        this.restaurant = restaurant;
        this.mylistenerResto = MyListenerResto;
        label_name.setText(restaurant.getNom());
        //int id_restaurant = Integer.valueOf(text_id_restaurant.getText());
        label_id.setText(String.valueOf(restaurant.getId()));
        //label_prix.setText(menu.getPrix());
        //label_id.setText(menu.getId2());
        //Image image = new Image(getClass().getResourceAsStream(restaurant.getImgSrc()));
        //img.setImage(image);
        blob = restaurant.getImgSrc();
        try {
            byteImg = blob.getBytes(1, (int) blob.length());
            Image image = new Image(new ByteArrayInputStream(byteImg),img.getFitWidth(),img.getFitHeight(),true,true);
            img.setImage(image);
        } catch (SQLException ex) {
            Logger.getLogger(controllerPlat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
