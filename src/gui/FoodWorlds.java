/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author user
 */
public class FoodWorlds extends Application {
    
    //definie your offsets here
    private double xOffset = 0;
    private double yOffset = 0;
    
    //public static final String CURRENCY ="$";
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        //grab your root here
	root.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
	//move around here
	root.setOnMouseDragged((MouseEvent event) -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });
        //Parent rootmenu = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene scence = new Scene(root, 1000, 700);
        //Scene scencemenu = new Scene(rootmenu, 800, 600);
        //primaryStage.setTitle("Restaurant");
        //primaryStage.setTitle("Menu");
        primaryStage.setScene(scence);
        //primaryStage.setScene(scencemenu);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
