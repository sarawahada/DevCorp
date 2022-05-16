/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IrestaurantAttente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.restaurantAttente;
import util.maConnexion;

/**
 *
 * @author user
 */
public class ServiceRestaurantAttente implements IrestaurantAttente{

    Connection cnx;

    public ServiceRestaurantAttente() {
        cnx = maConnexion.getInstance().getCnx();
    }

    @Override
    public List<restaurantAttente> afficherRestaurantAttente() {
        List<restaurantAttente> list = new ArrayList<>();
        try {
            String req ="select * from restaurant_attente";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                restaurantAttente p = new restaurantAttente();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPosition(rs.getString("position"));
                p.setGerant_restaurant(rs.getString("gerant_restaurant"));
                p.setEmail(rs.getString("email"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void modifierRestaurantAttente(restaurantAttente p) {
        try {
            String req = "update restaurant_attente set nom = ? , position = ? gerant_restaurant = ? where id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPosition());
            ps.setInt(3, p.getId());
            ps.setString(4, p.getGerant_restaurant());
            ps.executeUpdate();
            System.out.println("MAJ EFFECTUE");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void modifier2RestaurantAttente(String id, String nom, String position,String gerant_restaurant) {
        try {
            
            PreparedStatement pst = maConnexion.getInstance().getCnx()
                    .prepareStatement("UPDATE restaurant_attente SET nom= '"+nom+"', position= '"+position+"', gerant_restaurant= '"+gerant_restaurant+"' WHERE id = '"+id+"'");
            pst.executeUpdate();
            System.out.println("restaurant modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
    }

    @Override
    public void supprimerRestaurantAttente(int id) {
        try {
            String req = "delete from restaurant_attente where id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("SUPPRESSION EFFECTUER");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void supprimer2RestaurantAttente(String id) {
        try {
            String req = "delete from restaurant_attente where id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, id);
            ps.executeUpdate();
            System.out.println("SUPPRESSION EFFECTUER");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<restaurantAttente> recherche_nom_Restaurant_Attente(String nom_rechercher) {
        List<restaurantAttente> list = new ArrayList<>();
        try {
            String req ="select * from restaurant_attente where nom = '"+nom_rechercher+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                restaurantAttente p = new restaurantAttente();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPosition(rs.getString("position"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void ajouterRestaurant(restaurantAttente p) {
        try {
            String request = "insert into restaurant (nom,position,date_entrer,gerant_restaurant) values"
                    + " ( '" + p.getNom()+ "','" + p.getPosition()+ "','" + p.getDate_entrer()+ "','" + p.getGerant_restaurant()+ "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println("restaurant ajoutée avec succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
