/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package gui;


import java.io.IOException;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;



/**
 *
 * @author sarawahada
 */
public class NewFXMain_EFOOD extends Application {

   
    
    @Override
    public void start(Stage primaryStage) throws IOException {
    
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Login.fxml"));
        Parent root =loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("EFOOD APPLICATION");
        primaryStage.show();

    }

   
    public static void main(String[] args) {
    Application.launch (args);
   


       
    }}/*}}*/
    

