/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.util.Date;

/**
 *
 * @author user
 */
public class menu {
    private int id;
    private String id2;
    private String nom;
    private String saison;
    private String quantite;
    private String prix;
    private Blob imgSrc;
    private Date date_mise_en_rayon;
    private Date date_peremption;
    private File fs;

    public menu() {
    }

    public menu(String nom, String saison, String quantite, String prix, Blob imgSrc, Date date_mise_en_rayon, Date date_peremption) {
        this.nom = nom;
        this.saison = saison;
        this.quantite = quantite;
        this.prix = prix;
        this.imgSrc = imgSrc;
        this.date_mise_en_rayon = date_mise_en_rayon;
        this.date_peremption = date_peremption;
    }

    public menu(int id, String nom, String saison, String quantite, String prix, Date date_mise_en_rayon, Date date_peremption, File fs) {
        this.id = id;
        this.nom = nom;
        this.saison = saison;
        this.quantite = quantite;
        this.prix = prix;
        this.date_mise_en_rayon = date_mise_en_rayon;
        this.date_peremption = date_peremption;
        this.fs = fs;
    }

    public menu(String nom, String saison, String quantite, String prix, Date date_mise_en_rayon, Date date_peremption, File fs) {
        this.nom = nom;
        this.saison = saison;
        this.quantite = quantite;
        this.prix = prix;
        this.date_mise_en_rayon = date_mise_en_rayon;
        this.date_peremption = date_peremption;
        this.fs = fs;
    }

    public menu(String nom, String saison, String quantite, String prix, Date date_mise_en_rayon, Date date_peremption) {
        this.nom = nom;
        this.saison = saison;
        this.quantite = quantite;
        this.prix = prix;
        this.date_mise_en_rayon = date_mise_en_rayon;
        this.date_peremption = date_peremption;
    }
    
    
    public menu(int id, String nom, String saison, String quantite, String prix, Blob imgSrc, Date date_mise_en_rayon, Date date_peremption) {
        this.id = id;
        this.nom = nom;
        this.saison = saison;
        this.quantite = quantite;
        this.prix = prix;
        this.imgSrc = imgSrc;
        this.date_mise_en_rayon = date_mise_en_rayon;
        this.date_peremption = date_peremption;
    }

    public String getId2() {
        return id2;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getQuantite() {
        return quantite;
    }

    public String getPrix() {
        return prix;
    }

    public Blob getImgSrc() {
        return imgSrc;
    }

    public String getSaison() {
        return saison;
    }

    public Date getDate_mise_en_rayon() {
        return date_mise_en_rayon;
    }

    public Date getDate_peremption() {
        return date_peremption;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }
    
    public void setDate_mise_en_rayon(Date date_mise_en_rayon) {
        this.date_mise_en_rayon = date_mise_en_rayon;
    }

    public void setDate_peremption(Date date_peremption) {
        this.date_peremption = date_peremption;
    }

    public void setImgSrc(Blob imgSrc) {
        this.imgSrc = imgSrc;
    }

    @Override
    public String toString() {
        return "menu{" + "id=" + id + ", nom=" + nom + ", saison=" + saison + ", quantite=" + quantite + ", prix=" + prix + ", imgSrc=" + imgSrc + ", date_mise_en_rayon=" + date_mise_en_rayon + ", date_peremption=" + date_peremption + '}';
    }

    public File getFs() {
        return fs;
    }

    public void setFs(File fs) {
        this.fs = fs;
    }
}
