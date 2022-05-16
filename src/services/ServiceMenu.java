/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Imenu;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.menu;
import util.maConnexion;

/**
 *
 * @author user
 */
public class ServiceMenu implements Imenu{

    Connection cnx;
    private FileInputStream fs;
    
    public ServiceMenu() {
        cnx = maConnexion.getInstance().getCnx();
    }
    
    @Override
    public void ajouterMenu(menu p) {
        try {
            String request = "insert into menu (nom,quantite,prix,imgSrc,saison,date_mise_en_rayon,date_peremption) values"
                    + " ( '" + p.getNom()+ "','" + p.getQuantite()+ "','" + p.getPrix()+ "','" + p.getFs()+ "','" + p.getSaison()+ "','" + p.getDate_mise_en_rayon()+ "','" + p.getDate_peremption()+ "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println("plat ajoutée avec succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<menu> afficherMenu() {
        List<menu> list = new ArrayList<>();
        //Blob blob;
        //byte byteImg[];
        try {
            String req ="select * from menu";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                menu p = new menu();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setSaison(rs.getString("saison"));
                p.setQuantite(rs.getString("quantite"));
                p.setPrix(rs.getString("prix"));
                p.setImgSrc(rs.getBlob("ImgSrc"));
                //blob = rs.getBlob("ImgSrc");
                //byteImg = blob.getBytes(1, (int) blob.length());
                //p.setImgSrc(byteImg);
                p.setDate_mise_en_rayon(rs.getDate("date_mise_en_rayon"));
                p.setDate_peremption(rs.getDate("date_peremption"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void modifier(menu p) {
        try {
            String req = "update menu set nom = ? , quantite = ? , prix = ?, imgSrc = ?, saison = ?, date_mise_en_rayon = ?, date_peremption = ? where id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getQuantite());
            ps.setString(3, p.getPrix());
            ps.setBlob(4, p.getImgSrc());
            ps.setString(5, p.getSaison());
            ps.setString(6, String.valueOf(p.getDate_mise_en_rayon()));
            ps.setString(7, String.valueOf(p.getDate_peremption()));
            ps.setInt(8, p.getId());
            ps.executeUpdate();
            System.out.println("MAJ EFFECTUE");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "delete from menu where id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("SUPPRESSION EFFECTUER");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void supprimer2(String id) {
        try {
            String req = "delete from menu where id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, id);
            ps.executeUpdate();
            System.out.println("SUPPRESSION EFFECTUER");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void modifier2(String id, String nom, String quantite, String prix, Blob imgSrc, String saison,Date date_mise_en_rayon, Date date_peremption) {
        try {
            
            PreparedStatement pst = maConnexion.getInstance().getCnx()
                    .prepareStatement("UPDATE restaurant SET nom= '"+nom+"', quantite= '"+quantite+"', prix= '"+prix+"', saison= '"+saison+"', saison= '"+saison+"', date_mise_en_rayon= '"+date_mise_en_rayon+"', date_peremption= '"+date_peremption+"' WHERE id = '"+id+"'");
            pst.executeUpdate();
            System.out.println("menu modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
    }

    //@Override
    //public List<menu> liquidation_plat() {
        
    //}

    @Override
    public void ajouterMenu2(String nom, String quantite, String prix, Blob imgSrc, String saison, Date date_mise_en_rayon, Date date_peremption, File file) {
        String request = "insert into menu (nom,quantite,prix,imgSrc,saison,date_mise_en_rayon,date_peremption) values(?,?,?,?,?,?,?)";
        try {
        PreparedStatement ps = cnx.prepareStatement(request);
            ps.setString(1, nom);
            ps.setString(2, quantite);
            ps.setString(3, prix);
            try {
                fs = new FileInputStream(file);
                ps.setBinaryStream(4, fs, file.length());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ServiceMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            //ps.setBlob(4, imgSrc);
            ps.setString(5, saison);
            ps.setString(6, String.valueOf(date_mise_en_rayon));
            ps.setString(7, String.valueOf(date_peremption));
            ps.executeUpdate();
            System.out.println("Ajout");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void ajouterMenu3(menu p) {
        
    }

    @Override
    public void supprimer3(String nom) {
        try {
            String req = "delete from menu where nom = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, nom);
            ps.executeUpdate();
            System.out.println("SUPPRESSION EFFECTUER");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<menu> afficherMenu2(String nom) {
        List<menu> list = new ArrayList<>();
        //Blob blob;
        //byte byteImg[];
        try {
            String req ="select * from menu where id_restaurant = '"+nom+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                menu p = new menu();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setSaison(rs.getString("saison"));
                p.setQuantite(rs.getString("quantite"));
                p.setPrix(rs.getString("prix"));
                p.setImgSrc(rs.getBlob("ImgSrc"));
                //blob = rs.getBlob("ImgSrc");
                //byteImg = blob.getBytes(1, (int) blob.length());
                //p.setImgSrc(byteImg);
                p.setDate_mise_en_rayon(rs.getDate("date_mise_en_rayon"));
                p.setDate_peremption(rs.getDate("date_peremption"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
}
