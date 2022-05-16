/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import interfaces.MyListener;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.menu;

/**
 *
 * @author user
 */
public class controllerPlat {
    
    @FXML
    private Label label_name;

    @FXML
    private Label label_id;
    
    @FXML
    private Label label_prix;

    @FXML
    private ImageView img;

    private menu menu;
    
    private MyListener mylistener;
    
    Blob blob;
    
    byte byteImg[];
    
    @FXML
    private void click(MouseEvent event){
       mylistener.conClickListener(menu);
    }
    
    public void setData(menu menus, MyListener myListener) {
        this.menu = menus;
        this.mylistener = myListener;
        label_name.setText(menu.getNom());
        label_prix.setText(menu.getPrix());
        //label_id.setText(menu.getId2());
        //Image image = new Image(getClass().getResourceAsStream(menu.getImgSrc()));
        //img.setImage(image);
        blob = menu.getImgSrc();
        try {
            byteImg = blob.getBytes(1, (int) blob.length());
            Image image = new Image(new ByteArrayInputStream(byteImg),img.getFitWidth(),img.getFitHeight(),true,true);
            img.setImage(image);
        } catch (SQLException ex) {
            Logger.getLogger(controllerPlat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
