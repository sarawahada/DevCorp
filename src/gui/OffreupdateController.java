/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package gui;
//import com.sun.javafx.logging.PlatformLogger.Level;
//import com.sun.javafx.logging.PlatformLogger.Level;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.offre;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import util.maConnexion;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */

public class OffreupdateController implements Initializable {
   
     @FXML
    private Label date_label;

     @FXML
    private TextField dateo;
    @FXML
    private Label id_label;

   

    @FXML
    private TextField ido;

    @FXML
    private Label name_label;

    @FXML
    private TextField nameo;

    @FXML
    private Label type_label;

    @FXML
    private TextField typeo;
    
    public int supprimeroffre(int id_offre){
                     //int id_offre = 245; 
                     int stat = 0;
                      Connection cnx = maConnexion.getInstance().getCnx();
             


  try {
            String sql = "Delete FROM offre WHERE id_offre=?";

            PreparedStatement st = cnx.prepareStatement(sql);
            st.setInt(1, id_offre);
            stat = st.executeUpdate();
            int rowsUpdated = st.executeUpdate();
                 }
        catch (SQLException ex) {
                ex.printStackTrace();
 
        }
         return stat;
            }

    @FXML
    void deleteoffre(ActionEvent event) {
        String oid = ido.getText();
        int id_offre = Integer.parseInt(oid);
        int status =  supprimeroffre(id_offre);
        if(status>0){
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("offer status");
        alert.setHeaderText(null);
        alert.setContentText("offer deleted");
        alert.showAndWait();
        
        }else{
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("offer status");
        alert.setHeaderText(null);
        alert.setContentText("offer not deleted");
        alert.showAndWait();
        
        }
      

    }
 public static offre getoffreById(int id_offre) {
     offre o = new offre();
         try {
             Connection cnx = maConnexion.getInstance().getCnx();
             
             
             String sql="SELECT * FROM offre WHERE id_offre='"+id_offre+"'";
             PreparedStatement statement = cnx.prepareStatement(sql);
            // statement.setInt(1, id_offre);
             //statement.executeUpdate(sql);
             ResultSet rs = statement.executeQuery(sql);
             
             while(rs.next()){
                 o.setId_offre(rs.getInt("id_offre"));
                 o.setText_offre(rs.getString("text_offre"));
                 o.setDate_offre(rs.getString("date_offre"));
                 o.setType_offre(rs.getString("type_offre"));
                 
                 
             }
            // cnx.close();
             // return o;
         } catch (SQLException ex) {
            
         }
         return o;
    }
    @FXML
    void getoffre(ActionEvent event)throws IOException ,ParseException, SQLException {
        
        String oid = ido.getText();
        int id_offre = Integer.parseInt(oid);
         //Connection cnx = connexion.getInstance().getCnx();
         // offreservice os =  new offreservice();
         //os.getoffreById(id_offre);
         offre o = getoffreById(id_offre);
         
         nameo.setText(o.getText_offre());
         dateo.setText(o.getDate_offre());
         typeo.setText(o.getType_offre()); 
         

    }
      public int modifieroffre(offre o){
                   

                int stat = 0;
                Connection cnx = maConnexion.getInstance().getCnx();
       
        try {
            
            
            String sql = "UPDATE offre SET text_offre=?, date_offre=?, type_offre=? WHERE id_offre=?";
             
            PreparedStatement st;
            st = cnx.prepareStatement(sql);
            st.setString(1,o.getText_offre());
            st.setString(2,o.getDate_offre());
            st.setString(3,o.getType_offre());
            st.setInt(4,o.getId_offre());
            stat = st.executeUpdate();
            
        }
        catch (SQLException ex) {
                ex.printStackTrace();
 
        } return stat;
            }

    @FXML
    void updateoffre(ActionEvent event) {
        String oid = ido.getText();
        int id_offre = Integer.parseInt(oid);
        String txtnom = nameo.getText();
        String txtdate = dateo.getText();
        String txttype = typeo.getText();
        offre o = new offre();
        o.setId_offre(id_offre);
        o.setText_offre(txtnom);
        o.setDate_offre(txtdate);
        o.setType_offre(txttype);
         int status = modifieroffre(o);
         if(status>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("offer status");
        alert.setHeaderText(null);
        alert.setContentText("offre updated");
        alert.showAndWait();
         
         }else{
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("offre not updates");
        alert.showAndWait();
         
         
         }
        

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
              
        }
  

}