/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package gui;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.offre;
import services.offreservice;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image ;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class OffreViewController implements Initializable {

     @FXML
    private AnchorPane content;

    @FXML
    private GridPane gridPane;

    @FXML
    private ScrollPane scrlpane;
      @FXML
    private Label list;

    @FXML
  /**
     * Initializes the controller class.
     * @param url
     * @param rb
     * @throws java.sql.SQLException
     */
    
   public void initialize(URL url, ResourceBundle rb) {

        try {  
            offreservice os= new offreservice();
            ArrayList<offre> initial_search_result;
            initial_search_result = (ArrayList<offre>)os.search();
            afficherGridPane(initial_search_result);
        }catch (FileNotFoundException | SQLException ex) {
        }
        scrlpane.setContent(gridPane);
        scrlpane.setFitToWidth(true);
        gridPane.setHgap(20);
        gridPane.setVgap(300);
        gridPane.setPadding(new Insets(200, 10, 10, 10));
        
       
   }
     @SuppressWarnings("empty-statement")
        public void afficherGridPane(List<offre> o) throws FileNotFoundException{
        gridPane.getChildren().clear();
        int size = o.size();
        int ncol = 2;
        int nrow = 1+ (size / ncol);
        System.out.println("ncol: "+ ncol);
        System.out.println("nrow: "+ nrow);
        int k = 0;
        for (int i = 0; i < nrow; i++) {
            // Each column
            for (int j = 0; j < ncol; j++) {
                //get image
                File file = new File(o.get(k).getImg_offre());
                Image image = new Image(file.toString());
                String sname="Name: ";
                String sdate="Date: ";
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(400);
                imageView.setFitHeight(400);
                Label oname = new Label(sname+o.get(k).getText_offre());
                Label odate = new Label(sdate+String.valueOf(o.get(k).getDate_offre()));
                VBox element = new VBox();
                offre oset = new offre(o.get(k));
                element.setUserData(oset);
                element.getChildren().addAll(imageView,oname, odate);
                gridPane.add(element, j, i);
                k++;
                if (k == size){
                    break;
                }
            }
        }
    }
               @FXML
    private void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        list.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("Client.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
    }
    
  
}