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
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import model.coupouns;
import util.maConnexion;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */

public class CoupounupdateController implements Initializable {
   
     @FXML
    private TextField codec;

    @FXML
    private TextField date1_c;

    @FXML
    private TextField date2_c;

    @FXML
    private Label date_label;

    @FXML
    private TextField duree_c;

    @FXML
    private Label id_label;

    @FXML
    private TextField id_promo;

    @FXML
    private TextField idc;

    @FXML
    private Label name_label;

    @FXML
    private TextField namec;

    @FXML
    private Label type_label;

    @FXML
    private Label type_label1;

    @FXML
    private Label type_label11;

    @FXML
    private Label type_label12;
    Connection cnx = maConnexion.getInstance().getCnx();
      public int supprimercoupouns(int id_coupouns){
                    int stat = 0; 


  try {
            String sql = "Delete FROM coupouns WHERE id_coupouns=?";

            PreparedStatement st = cnx.prepareStatement(sql);
            st.setInt(1, id_coupouns);
            stat = st.executeUpdate();

            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("coupouns supprimee");
            }       }
        catch (SQLException ex) {
                ex.printStackTrace();
 
        }
         return stat;
            }
    

    @FXML
    void deletecoupoun(ActionEvent event) {
         String cid = idc.getText();
        int id_coupouns = Integer.valueOf(cid);
        int status = supprimercoupouns(id_coupouns);
        if(status>0){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(" coupouns Deleted  ");
        alert.showAndWait();
        
    
    }else{
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(" Try again?  ");
        alert.showAndWait();
        }

    }
     public coupouns getCoupounsById(int id_coupouns) throws SQLException{
        String sql="SELECT * FROM coupouns WHERE id_coupouns='"+id_coupouns+"'";
        Statement statement = cnx.prepareStatement(sql);
        //statement.executeUpdate(sql);
        ResultSet rs = statement.executeQuery(sql);
        coupouns c = new coupouns();
       while(rs.next()){
                c.setId_coupouns(rs.getInt("id_coupouns"));
                c.setText_coupouns(rs.getString("text_coupouns"));
                c.setCode_coupouns(rs.getString("code_coupouns"));
                c.setDate_1(rs.getString("date_1")); 
                c.setDate_2(rs.getString("date_2")); 
                c.setId_promo1(rs.getInt("id_promo1"));
                c.setDuree_coupouns(rs.getInt("duree_coupouns")); 
            }
       return c;
    }

    @FXML
    void getcoupoun(ActionEvent event) throws SQLException {
        String cid = idc.getText();
        int id_coupouns = Integer.valueOf(cid);
        coupouns c = getCoupounsById(id_coupouns);
        namec.setText(c.getText_coupouns());
        codec.setText(c.getCode_coupouns());
        date1_c.setText(c.getDate_1());
        date2_c.setText(c.getDate_2());
        id_promo.setText(String.valueOf(c.getId_promo1()));
        duree_c.setText(String.valueOf(c.getDuree_coupouns()));
       

    }
    public int modifiercoupouns(coupouns c){
                int stat = 0;

        try {
            
            
            String sql = "UPDATE coupouns SET text_coupouns=?, code_coupouns=?,date_1=?,date_2=?,id_promo1=? , duree_coupouns=? WHERE id_coupouns=?";

            PreparedStatement st = cnx.prepareStatement(sql);
            st.setString(1,c.getText_coupouns());
            st.setString(2,c.getCode_coupouns());
            st.setString(3,c.getDate_1());
            st.setString(4,c.getDate_2());
            st.setInt(5,c.getId_promo1());
            st.setInt(6,c.getDuree_coupouns());
            st.setInt(7,c.getId_coupouns());
            
            stat = st.executeUpdate();
            
            
                   }
        catch (SQLException ex) {
                ex.printStackTrace();
 
        }
        return stat;
            }
            

    @FXML
    void updatecoupoun(ActionEvent event) {
        String cid = idc.getText();
        int id_coupouns = Integer.valueOf(cid);
        String nomc = namec.getText();
        String code = codec.getText();
        String date1= date1_c.getText();
        String date2= date2_c.getText();
        String id_p = id_promo.getText();
        String dure = duree_c.getText();
        coupouns c = new coupouns();
        c.setId_coupouns(id_coupouns);
        c.setText_coupouns(nomc);
        c.setCode_coupouns(code);
        c.setDate_1(date1);
        c.setDate_2(date2);
        c.setId_promo1(Integer.valueOf(id_p));
        c.setDuree_coupouns(Integer.valueOf(dure));
        int status = modifiercoupouns(c);
        if(status>0)
        {
        //CoupounListController clc = new CoupounListController();
        //clc.showAllCoupouns();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("coupouns Updated");
        alert.showAndWait();
        
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(" Try again? ");
        alert.showAndWait();
        
        
        }
        
        

    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
        
        
        
                
        

    }

  

