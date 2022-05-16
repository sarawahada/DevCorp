/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Irestaurant;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextField;
import model.restaurant;
import util.maConnexion;

/**
 *
 * @author user
 */
public class ServiceRestaurant implements Irestaurant{

    Connection cnx;

    public ServiceRestaurant() {
        cnx = maConnexion.getInstance().getCnx();
    }
    
    @Override
    public void ajouterRestaurant(restaurant p) {
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

    @Override
    public List<restaurant> afficherRestaurant() {
        List<restaurant> list = new ArrayList<>();
        try {
            String req ="select * from restaurant";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                restaurant p = new restaurant();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPosition(rs.getString("position"));
                p.setDate_entrer(rs.getDate("date_entrer"));
                p.setGerant_restaurant(rs.getString("gerant_restaurant"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void modifier(restaurant p) {
        try {
            String req = "update restaurant set nom = ? , position = ? , date_entrer = ?, gerant_restaurant = ? where id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPosition());
            ps.setString(3, String.valueOf(p.getDate_entrer()));
            ps.setString(4, p.getGerant_restaurant());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
            System.out.println("MAJ EFFECTUE");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "delete from restaurant where id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("SUPPRESSION EFFECTUER");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void modifier2(String id, String nom,String position,Date date_entrer,String gerant_restaurant) {
        try {
            
            PreparedStatement pst = maConnexion.getInstance().getCnx()
                    .prepareStatement("UPDATE restaurant SET nom= '"+nom+"', position= '"+position+"', date_entrer = '"+date_entrer+"' , gerant_restaurant = '"+gerant_restaurant+"' WHERE id = '"+id+"'");
            pst.executeUpdate();
            System.out.println("restaurant modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
    }

    @Override
    public void supprimer2(String id) {
        try {
            String req = "delete from restaurant where id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, id);
            ps.executeUpdate();
            System.out.println("SUPPRESSION EFFECTUER");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<restaurant> recherche_nom(String nom_rechercher) {
        List<restaurant> list = new ArrayList<>();
        try {
            String req ="select * from restaurant where nom = '"+nom_rechercher+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                restaurant p = new restaurant();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPosition(rs.getString("position"));
                p.setDate_entrer(rs.getDate("date_entrer"));
                p.setGerant_restaurant(rs.getString("gerant_restaurant"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public List<restaurant> liquidation_plat() {
        List<restaurant> list = new ArrayList<>();
        LocalDate date = LocalDate.now();
        
        try {
            String req = "select * from restaurant where extract(day from '"+date+"') - extract(day from date_entrer) < 10";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                restaurant p = new restaurant();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPosition(rs.getString("position"));
                p.setDate_entrer(rs.getDate("date_entrer"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public List<restaurant> afficherRestaurant2() {
        List<restaurant> list = new ArrayList<>();
        try {
            String req ="select * from restaurant";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                restaurant p = new restaurant();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPosition(rs.getString("position"));
                p.setDate_entrer(rs.getDate("date_entrer"));
                p.setImgSrc(rs.getBlob("image"));
                p.setGerant_restaurant(rs.getString("gerant_restaurant"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public List<restaurant> afficherRestaurant3(String nom) {
        List<restaurant> list = new ArrayList<>();
        try {
            String req ="select * from menu where id_restaurant = '"+nom+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                restaurant p = new restaurant();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPosition(rs.getString("position"));
                p.setDate_entrer(rs.getDate("date_entrer"));
                p.setImgSrc(rs.getBlob("image"));
                p.setGerant_restaurant(rs.getString("gerant_restaurant"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
}
