/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package gui;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import model.coupouns;
import services.Mail;
import util.maConnexion;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */

public class CoupounListController implements Initializable {
   
      // @FXML
   // private ListView<String> offrelistview;
      // ListView<String> offrelistview = new ListView<>();
       // offrelistview.getItems().add("abir");
     @FXML
    private Button btn_update;

    @FXML
    private TableColumn<coupouns, String> col_code_coup;

    @FXML
    private TableColumn<coupouns, String> col_date1_coupoun;

    @FXML
    private TableColumn<coupouns, String> col_date2_coupoun;

    @FXML
    private TableColumn<coupouns, Integer> col_duree_coupoun;

    @FXML
    private TableColumn<coupouns, Integer> col_id_coupoun;

    @FXML
    private TableColumn<coupouns, Integer> col_id_promo1;

    @FXML
    private TableColumn<coupouns, String> col_nom_coupoun;

    @FXML
    private TableView<coupouns> tvcoupoun;
    @FXML
    private Label list;
    @FXML
    private TextField ToMail;
     @FXML
    private TextField CodeInput;
     
      int index = -1;
        public boolean isValidEmailAddress(String email) {
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           Pattern p = Pattern.compile(ePattern);
           Matcher m = p.matcher(email);
           return m.matches();
    }

    @FXML
    void btn_updatec(ActionEvent event) {
try {
              Stage stage = new Stage();
              
          FXMLLoader loader = new FXMLLoader(getClass().getResource("coupounupdate.fxml"));
             Parent root = loader.load();
              Scene scene = new Scene(root);
              stage.setScene(scene);
              stage.setTitle("update");
              stage.show();
          } catch (IOException ex) {
              
          }
    }
        @FXML
    void btn_add(ActionEvent event) {
        try {
         Stage stage = new Stage();         
          FXMLLoader loader = new FXMLLoader(getClass().getResource("coupouns.fxml"));
             Parent root = loader.load();
              Scene scene = new Scene(root);
              stage.setScene(scene);
              stage.setTitle("update");
              stage.show();
          } catch (IOException ex) {
             
          }

    }
     @FXML
    void getSelected(MouseEvent event) {
        
    index = tvcoupoun.getSelectionModel().getSelectedIndex();
    if (index <= -1){
        return;
    }
    CodeInput.setText(col_code_coup.getCellData(index));
       }

       
   public void showAllCoupouns(){
      try {
             ObservableList<coupouns> coupoun = FXCollections.observableArrayList();
             
              // try {
             Connection cnx = maConnexion.getInstance().getCnx();
             Statement st = cnx.createStatement();
             ResultSet rs = cnx.createStatement().executeQuery("SELECT * FROM coupouns");
             while (rs.next()) {                
                coupoun.add(new coupouns(rs.getInt("id_coupouns"), rs.getString("text_coupouns"),rs.getString("code_coupouns") ,rs.getString("date_1"),rs.getString("date_2"),rs.getInt("id_promo1"),rs.getInt("duree_coupouns")));
                 //ObservableList<offre> offres = afficheroffre();
                 col_id_coupoun.setCellValueFactory(new PropertyValueFactory<coupouns, Integer>("id_coupouns"));
                 col_nom_coupoun.setCellValueFactory(new PropertyValueFactory<coupouns, String>("text_coupouns"));
                 col_code_coup.setCellValueFactory(new PropertyValueFactory<coupouns, String>("code_coupouns"));
                 col_date1_coupoun.setCellValueFactory(new PropertyValueFactory<coupouns, String>("date_1"));
                 col_date2_coupoun.setCellValueFactory(new PropertyValueFactory<coupouns, String>("date_2"));
                 col_id_promo1.setCellValueFactory(new PropertyValueFactory<coupouns, Integer>("id_promo1"));
                 col_duree_coupoun.setCellValueFactory(new PropertyValueFactory<coupouns, Integer>("duree_coupouns"));
                 tvcoupoun.setItems (coupoun);
                 
             }
         } catch (SQLException ex) {
           
         }
   }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
      showAllCoupouns();
              
      
        }
       @FXML
    private void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        list.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("ChefDashboard.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
    }
        @FXML
    void SendMail(ActionEvent event) throws MessagingException {
        if(isValidEmailAddress(ToMail.getText())==false)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Email is not valid");
        alert.showAndWait();     
        }
        else{
        Mail.send(ToMail.getText(),CodeInput.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Mail was sent");
        alert.showAndWait();

    }
    
 
}
}