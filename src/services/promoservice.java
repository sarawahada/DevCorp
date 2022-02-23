/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Ipromo;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import model.promo;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.connexion;

/**
 *
 * @author LENOVO
 */
public class promoservice implements Ipromo {
    Connection cnx = connexion.getInstance().getCnx();
     @Override
        public void ajouterpromo(promo p ) {
        String request = "INSERT INTO `promo`(`id_promo`,`nom_promo`,`type_promo`,`date_d`,`date_f`,`id_resto`,`text_promo`) VALUES ('"+p.getId_promo()+"','"+p.getNom_promo()+"','"+p.getType_promo()+"','"+p.getDate_d()+"','"+p.getDate_f()+"','"+p.getId_resto()+"','"+p.getText_promo()+"')";
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
}
