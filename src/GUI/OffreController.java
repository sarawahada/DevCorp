/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package GUI;
//import com.sun.javafx.logging.PlatformLogger.Level;
//import com.sun.javafx.logging.PlatformLogger.Level;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.offre;
import services.offreservice;
import interfaces.interfaceoffer;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
//import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import util.connexion;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class OffreController implements Initializable {

    
    @FXML
    private Button btn_ajouter_offre;

    @FXML
    private DatePicker tf_date_offre;

    @FXML
    private TextField tf_id_offre;

    @FXML
    private TextField tf_nom_offre;

    @FXML
    private TextField tf_type_offre;
    
    @FXML
    private ImageView img;
    
    File file;
     
    
    @FXML
    private void image(ActionEvent event) {
        FileChooser fileChooserr = new FileChooser();
        fileChooserr.setTitle("Select Image");
        fileChooserr.setInitialDirectory(new File("/"));
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        fileChooserr.getExtensionFilters().add(imageFilter);
        file = fileChooserr.showOpenDialog(img.getScene().getWindow());
        Image image = new Image(file.toURI().toString());
        img.setImage(image);
    }

    @FXML
    void ajout(ActionEvent event)throws IOException, SQLException, MessagingException {
       
         if (tf_nom_offre.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Name Field empty");
        alert.showAndWait();}
       else if (tf_type_offre.getText().isEmpty())
           { Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Warning");
           alert.setHeaderText(null);
           alert.setContentText("Type Field empty");
           alert.showAndWait();}
           else
           {
               offre o = new offre();
              // o.setId_offre(Integer.valueOf(tf_id_offre.getText()));
               o.setText_offre(tf_nom_offre.getText());
               o.setDate_offre(tf_date_offre.getValue().toString());
               o.setType_offre(tf_type_offre.getText());
               o.setImg_offre(file.toURI().toString());
               offreservice os = new offreservice();
               os.ajouteroffre2(o);
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Success");
               alert.setHeaderText(null);
               alert.setContentText("offer created successfully ");
               FXMLLoader loader = new FXMLLoader(getClass().getResource("offreList.fxml"));
               Parent root = loader.load();
               tf_nom_offre.getScene().setRoot(root);
               
               /*OffreListController apc = loader.getController();
               apc.setlbid(tf_id_offre.getText());
               apc.setlbnom(tf_nom_offre.getText());
               apc.setlbdate(tf_date_offre.getValue().toString());
               apc.setlbtype(tf_type_offre.getText());
               */
           }
      
    }
       @FXML
    void ajout2(ActionEvent event)throws IOException, SQLException, MessagingException {
       
         if (tf_nom_offre.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Name Field empty");
        alert.showAndWait();}
       else if (tf_type_offre.getText().isEmpty())
           { Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Warning");
           alert.setHeaderText(null);
           alert.setContentText("Type Field empty");
           alert.showAndWait();}
           else
           {
               offre o = new offre();
              // o.setId_offre(Integer.valueOf(tf_id_offre.getText()));
               o.setText_offre(tf_nom_offre.getText());
               o.setDate_offre(tf_date_offre.getValue().toString());
               o.setType_offre(tf_type_offre.getText());
               o.setImg_offre(file.toURI().toString());
               offreservice os = new offreservice();
               os.ajouteroffre2(o);
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Success");
               alert.setHeaderText(null);
               alert.setContentText("offer created successfully ");
               FXMLLoader loader = new FXMLLoader(getClass().getResource("offreList.fxml"));
               Parent root = loader.load();
               tf_nom_offre.getScene().setRoot(root);
               
               /*OffreListController apc = loader.getController();
               apc.setlbid(tf_id_offre.getText());
               apc.setlbnom(tf_nom_offre.getText());
               apc.setlbdate(tf_date_offre.getValue().toString());
               apc.setlbtype(tf_type_offre.getText());
               */
           }
      
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
              
        }

  

}