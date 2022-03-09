/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package GUI;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.offre;
import services.offreservice;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image ;
import javafx.scene.layout.AnchorPane;
import services.promoservice;
import model.promo;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class PromoViewController implements Initializable {

     @FXML
    private AnchorPane content;

    @FXML
    private GridPane gridPane;

    @FXML
    private ScrollPane scrlpane;

    @FXML
  /**
     * Initializes the controller class.
     * @param url
     * @param rb
     * @throws java.sql.SQLException
     */
    
   public void initialize(URL url, ResourceBundle rb) {

        try {  
            promoservice ps= new promoservice();
            ArrayList<promo> initial_search_result;
            initial_search_result = (ArrayList<promo>)ps.search();
            afficherGridPane(initial_search_result);
        }catch (FileNotFoundException | SQLException ex) {
        }
        scrlpane.setContent(gridPane);
        scrlpane.setFitToWidth(true);
        gridPane.setHgap(10);
        gridPane.setVgap(100);
        gridPane.setPadding(new Insets(100, 10, 10, 10));
        
       
   }
     @SuppressWarnings("empty-statement")
        public void afficherGridPane(List<promo> p) throws FileNotFoundException{
        gridPane.getChildren().clear();
        int size = p.size();
        int ncol = 5;
        int nrow = 1+ (size / ncol);
        System.out.println("ncol: "+ ncol);
        System.out.println("nrow: "+ nrow);
        int k = 0;
        for (int i = 0; i < nrow; i++) {
            // Each column
            for (int j = 0; j < ncol; j++) {
                //get image
               // File file = new File(o.get(k).getImg_offre());
               // Image image = new Image(file.toString());
                String sname="Name: ";
                String sdate="Star Date: ";
                String sdate1="End Date: ";
                String text = "description:";
                //ImageView imageView = new ImageView(image);
                //imageView.setFitWidth(400);
                //imageView.setFitHeight(400);
                Label pname = new Label(sname+p.get(k).getNom_promo());
                Label pdate = new Label(sdate+String.valueOf(p.get(k).getDate_d()));
               Label pdate1 = new Label(sdate1+String.valueOf(p.get(k).getDate_f()));
                Label ptext = new Label(text+String.valueOf(p.get(k).getText_promo()));
                Button addBtn = new Button("Get your coupoun");
                VBox element = new VBox();
                promo pset = new promo(p.get(k));
                element.setUserData(pset);
                element.getChildren().addAll(pname,pdate, pdate1,ptext,addBtn);
                gridPane.add(element, j, i);
                k++;
                if (k == size){
                    break;
                }
                  
                 
            }
        }
    }
    
  
}