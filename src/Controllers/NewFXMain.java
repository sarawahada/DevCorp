/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package Controllers;

import Models.Commande;
import Models.CommandeService;
import Models.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author fomri
 */
public class NewFXMain extends Application {
    private static Stage window;
    
    @Override
    public void start(Stage primaryStage)  throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/LogIn.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        window = primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
//       User u = new User(1);
//       CommandeService cm = new CommandeService();
//      cm.passerCommande(1);
    }
    public static Stage getWindow(){
      return window ;
    }
}
