/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author LENOVO
 */
import interfaces.interfaceoffer;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.List;
import model.offre; 

import util.connexion;

import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.PreparedStatement;



public class offreservice implements interfaceoffer 
         {
    Connection cnx = connexion.getInstance().getCnx();

    @Override
    public void ajouteroffre(offre o ) {
        String request = "INSERT INTO `offre`( `text_offre`, `date_offre`, `type_offre`) VALUES ('"+o.getText_offre()+"','"+o.getDate_offre()+"','"+o.getType_offre()+"')";
       try{
        Statement st = cnx.createStatement();
        st.executeUpdate(request);
                System.out.println("offre ajoutee avec succes");
                 } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void ajouteroffre2(offre o) {
           
       String Req = "INSERT INTO `offre`(`text_offre`, `date_offre`, `type_offre`, `img_offre`) VALUES (?,?,?,?)";
        try {
            
            PreparedStatement su = cnx.prepareStatement(Req);
            su.setString(1, o.getText_offre());
            su.setString(2, o.getDate_offre());
            su.setString(3, o.getType_offre());
            su.setString(4,o.getImg_offre());
            su.execute();
            System.out.println("Offer added!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<offre> afficheroffre() {
        List<offre> offres = new ArrayList<>();
        
        String query = "SELECT * FROM offre";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                offres.add(new offre(rs.getInt("id_offre"), rs.getString("text_offre"), rs.getString("date_offre"),rs.getString("type_offre")));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return offres;
    }
    
             public boolean modifieroffre(offre o){
                
        try {

            String sql = "UPDATE offre SET text_offre=?, date_offre=?, type_offre=? WHERE id_offre=?";

            PreparedStatement st = cnx.prepareStatement(sql);
            st.setString(1,o.getText_offre());
            st.setString(2, o.getDate_offre());
          
            st.setString(3,o.getType_offre());
            st.setInt(4,o.getId_offre());
            int rowsUpdated = st.executeUpdate();
            
            if (rowsUpdated > 0) {
            
                System.out.println("l'offre est modifiee");
            }
                   }
        catch (SQLException ex) {
                ex.printStackTrace();
 
        } return true;
            }
                   public void supprimeroffre(int id_offre){
                     //int id_offre = 245; 


  try {
            String sql = "Delete FROM offre WHERE id_offre=?";

            PreparedStatement st = cnx.prepareStatement(sql);
            st.setInt(1, id_offre);

            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("offre supprimee");
            }       }
        catch (SQLException ex) {
                ex.printStackTrace();
 
        }
            }

    @Override
         public offre getoffreByType(String type_offre) throws SQLException{
        String sql="SELECT * FROM offre WHERE type_offre='"+type_offre+"'";
        Statement statement = cnx.prepareStatement(sql);
        //statement.executeUpdate(sql);
        ResultSet rs = statement.executeQuery(sql);
        offre o = new offre();
       while(rs.next()){
                o.setId_offre(rs.getInt("id_offre"));
                o.setText_offre(rs.getString("text_offre"));
                o.setDate_offre(rs.getString("date_offre")); 
                o.setType_offre(rs.getString("type_offre"));
              
               
            }
       return o;
    }


    public  offre getoffreById(int id_offre) throws SQLException{
              offre o = new offre();
        String sql="SELECT * FROM offre WHERE id_offre='"+id_offre+"'";
        Statement statement = cnx.prepareStatement(sql);
        //statement.executeUpdate(sql);
        ResultSet rs = statement.executeQuery(sql);
       
       while(rs.next()){
                o.setId_offre(rs.getInt("id_offre"));
                o.setText_offre(rs.getString("text_offre"));
                o.setDate_offre(rs.getString("date_offre")); 
                o.setType_offre(rs.getString("type_offre"));
              
               
            }
       return o;
    }
          public offre getoffreByIdandType(int id_offre,String type_offre) throws SQLException{
        String sql="SELECT * FROM offre WHERE id_offre='"+id_offre+"' AND type_offre='"+type_offre+"'";
        Statement statement = cnx.prepareStatement(sql);
        //statement.executeUpdate(sql);
        ResultSet rs = statement.executeQuery(sql);
        offre o = new offre();
       while(rs.next()){
                o.setId_offre(rs.getInt("id_offre"));
                o.setText_offre(rs.getString("text_offre"));
                o.setDate_offre(rs.getString("date_offre")); 
                o.setType_offre(rs.getString("type_offre"));
            }
       return o;
    }
    public List<offre> search()throws SQLException{
        List<offre> arr=new ArrayList<>();
        PreparedStatement ps = cnx.prepareStatement ("SELECT * FROM offre");
        ResultSet res = ps.executeQuery();
              System.out.println(ps.toString());
       while (res.next()) { 
               int id_offre=res.getInt("id_offre");
               String text_offre=res.getString("text_offre");
               String date_offre=res.getString("date_offre");
               String type_offre=res.getString("type_offre");
               String img_offre=res.getString("img_offre");
               offre o=new offre(id_offre,text_offre,date_offre,type_offre,img_offre);
               System.out.println(o.toString());
     arr.add(o);
     }
    return arr;  
    }

    @Override
    public void onClickListener(offre offre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    }
    

