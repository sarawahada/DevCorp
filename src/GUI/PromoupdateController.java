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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
//import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import model.promo;
import util.connexion;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */

public class PromoupdateController implements Initializable {
   
      @FXML
    private TextField date1_p;

    @FXML
    private TextField date2_p;

    @FXML
    private Label date_label;

    @FXML
    private Label id_label;

    @FXML
    private TextField id_resto;

    @FXML
    private TextField idp;

    @FXML
    private Label name_label;

    @FXML
    private TextField namep;

    @FXML
    private TextArea textp;

    @FXML
    private Label type_label;

    @FXML
    private Label type_label1;

    @FXML
    private Label type_label11;

    @FXML
    private Label type_label12;

    @FXML
    private TextField typep;
    Connection cnx = connexion.getInstance().getCnx();
     public int supprimerpromo(int id_promo){
                   int stat =0;

  try {
            String sql = "Delete FROM promo WHERE id_promo=?";

            PreparedStatement st = cnx.prepareStatement(sql);
            st.setInt(1, id_promo);
            stat = st.executeUpdate();

            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("promo supprimee");
            }       }
        catch (SQLException ex) {
                ex.printStackTrace();
 
        }
          return stat;
            }

    @FXML
    void deletepromo(ActionEvent event) {
         String pid = idp.getText();
        int id_promo = Integer.parseInt(pid);
        int status = supprimerpromo(id_promo);
        if(status>0){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(" Promotion Deleted  ");
        alert.showAndWait();}
        else{
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fail");
        alert.setHeaderText(null);
        alert.setContentText(" Try again");
        alert.showAndWait();}
 

    }
public promo getpromoById(int id_promo) throws SQLException{
        String sql="SELECT * FROM promo WHERE id_promo='"+id_promo+"'";
        Statement statement = cnx.prepareStatement(sql);
        //statement.executeUpdate(sql);
        ResultSet rs = statement.executeQuery(sql);
        promo p = new promo();
       while(rs.next()){
                p.setId_promo(rs.getInt("id_promo"));
                p.setNom_promo(rs.getString("nom_promo"));
                p.setType_promo(rs.getInt("type_promo"));
                p.setDate_d(rs.getString("date_d")); 
                p.setDate_f(rs.getString("date_f")); 
                p.setId_resto(rs.getInt("id_resto"));
                p.setText_promo(rs.getString("text_promo"));
              
               
            }
       return p;
    }
    @FXML
    void getpromo(ActionEvent event) throws SQLException {
         String pid = idp.getText();
        int id_promo = Integer.parseInt(pid);
         //Connection cnx = connexion.getInstance().getCnx();
         // offreservice os =  new offreservice();
         //os.getoffreById(id_offre);
         promo p = getpromoById(id_promo);
         
         namep.setText(p.getNom_promo());
         typep.setText(String.valueOf(p.getType_promo()));
         date1_p.setText(p.getDate_d());
         date2_p.setText(p.getDate_f());
         id_resto.setText(String.valueOf(p.getId_promo()));
         textp.setText(p.getText_promo());
         
         
         

    }
      public int modifierpromo(promo p){
                
                int stat = 0;
 

    
        try {
            
            
            String sql = "UPDATE promo SET nom_promo=?, type_promo=?, date_d=?, date_f=?, id_resto=?, text_promo=? WHERE id_promo=?";

            PreparedStatement st = cnx.prepareStatement(sql);
            st.setString(1,p.getNom_promo());
            st.setInt(2,p.getType_promo());
            st.setString(3,p.getDate_d());
            st.setString(4,p.getDate_f());
            st.setInt(5,p.getId_resto());
            st.setString(6,p.getText_promo());
            
            st.setInt(7,p.getId_promo());
            stat = st.executeUpdate();
        }
        catch (SQLException ex) {
                ex.printStackTrace();
 
        } return stat;
            }


    @FXML
    void updatepromo(ActionEvent event) {
        String pid = idp.getText();
        int id_promo = Integer.parseInt(pid);
        String nomp = namep.getText();
        String typp = typep.getText();
        String dt1 = date1_p.getText();
        String dt2 = date2_p.getText();
        String idr = id_resto.getText();
        String txt = textp.getText();
        promo p = new promo();
        p.setId_promo(id_promo);
        p.setNom_promo(nomp);
        p.setType_promo(Integer.parseInt(typp));
        p.setDate_d(dt1);
        p.setDate_f(dt2);
        p.setId_resto(Integer.parseInt(idr));
        p.setText_promo(txt);
        int status = modifierpromo(p);
        if(status>0)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(" Promotion Updated  ");
        alert.showAndWait();}
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(" Promotion Not Updated ");
        alert.showAndWait();}

            }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
        
        
        
                
        

    }

  

