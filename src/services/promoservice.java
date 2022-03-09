/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author LENOVO
 */
import interfaces.Ipromo;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import model.promo;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.offre;
import util.connexion;

/**
 *
 * @author LENOVO
 */
public class promoservice implements Ipromo {
    Connection cnx = connexion.getInstance().getCnx();
     @Override
        public void ajouterpromo(promo p ) {
        String request = "INSERT INTO `promo`(`nom_promo`,`type_promo`,`date_d`,`date_f`,`id_resto`,`text_promo`) VALUES ('"+p.getNom_promo()+"','"+p.getType_promo()+"','"+p.getDate_d()+"','"+p.getDate_f()+"','"+p.getId_resto()+"','"+p.getText_promo()+"')";
       try{
        Statement st = cnx.createStatement();
            st.executeUpdate(request);
                System.out.println("promo ajoutee avec succes");
                 } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    public List<promo> afficherpromo() {
        List<promo> promos = new ArrayList<>();
        
        String query = "SELECT * FROM promo";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                promos.add(new promo(rs.getInt("id_promo"), rs.getString("nom_promo"),rs.getInt("type_promo") ,rs.getString("date_d"),rs.getString("date_f"),rs.getInt("id_resto"),rs.getString("text_promo")));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return promos;
    }
     public boolean modifierpromo(promo p){
                
                
 

    
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
            int rowsUpdated = st.executeUpdate();
            
            if (rowsUpdated > 0) {
            
                System.out.println("promo est modifiee");
            }
                   }
        catch (SQLException ex) {
                ex.printStackTrace();
 
        } return true;
            }
             public void supprimerpromo(int id_promo){
                     //int id_offre = 245; 


  try {
            String sql = "Delete FROM promo WHERE id_promo=?";

            PreparedStatement st = cnx.prepareStatement(sql);
            st.setInt(1, id_promo);

            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("promo supprimee");
            }       }
        catch (SQLException ex) {
                ex.printStackTrace();
 
        }
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
  public promo getpromoByType(int type_promo) throws SQLException{
        String sql="SELECT * FROM promo WHERE type_promo='"+type_promo+"'";
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
   public List<promo> search()throws SQLException{
        List<promo> pr=new ArrayList<>();
        PreparedStatement ps = cnx.prepareStatement ("SELECT * FROM promo");
        ResultSet res = ps.executeQuery();
              System.out.println(ps.toString());
       while (res.next()) { 
               int id_promo=res.getInt("id_promo");
               String nom_promo=res.getString("nom_promo");
                 int type_promo=res.getInt("type_promo");
               String date_d=res.getString("date_d");
               String date_f=res.getString("date_f");
                int id_resto=res.getInt("id_resto");
               String text_promo=res.getString("text_promo");
               promo p=new promo(id_promo,nom_promo,type_promo,date_d,date_f,id_resto,text_promo);
               System.out.println(p.toString());
     pr.add(p);
     }
    return pr;  
    }
}

