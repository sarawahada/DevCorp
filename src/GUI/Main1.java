/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package GUI;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.offre;

/**
 *
 * @author LENOVO
 */
public class Main1 extends Application {
    
    public void start(Stage primaryStage) throws IOException ,MalformedURLException{
        
         
        try {
            FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("promoList.fxml"));
        
        Parent root =loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
       
        //primaryStage.setTitle("EFOOD APPLICATION");
        primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(main11.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}