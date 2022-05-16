/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Blob;
import java.util.Date;
import java.text.DateFormat;
import java.time.LocalDate;
/**
 *
 * @author user
 */
public class restaurant {
    //variables
    private int id;
    private String id2;
    private String nom;
    private String position;
    private Date date_entrer;
    private Blob imgSrc;
    private String gerant_restaurant;

    //Constructor
    public restaurant() {
    }

    public restaurant(String nom, String position, Date date_entrer, String gerant_restaurant ) {
        this.nom = nom;
        this.position = position;
        this.date_entrer = date_entrer;
        this.gerant_restaurant = gerant_restaurant;
    }

    public restaurant(int id, String nom, String position, Date date_entrer, String gerant_restaurant) {
        this.id = id;
        this.nom = nom;
        this.position = position;
        this.date_entrer = date_entrer;
        this.gerant_restaurant = gerant_restaurant;
    }
    
    //Getters and Setters
    public int getId() {
        return id;
    }

    public String getId2() {
        return id2;
    }

    public Blob getImgSrc() {
        return imgSrc;
    }

    public String getNom() {
        return nom;
    }

    public String getPosition() {
        return position;
    }

    public Date getDate_entrer() {
        return date_entrer;
    }

    public String getGerant_restaurant() {
        return gerant_restaurant;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDate_entrer(Date date_entrer) {
        this.date_entrer = date_entrer;
    }

    public void setImgSrc(Blob imgSrc) {
        this.imgSrc = imgSrc;
    }

    public void setGerant_restaurant(String gerant_restaurant) {
        this.gerant_restaurant = gerant_restaurant;
    }

    @Override
    public String toString() {
        return "restaurant{" + "id=" + id + ", nom=" + nom + ", position=" + position + ", date_entrer=" + date_entrer + ", imgSrc=" + imgSrc + ", gerant_restaurant=" + gerant_restaurant + '}';
    }

    
}

