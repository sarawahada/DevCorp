/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.IrestaurantAttente;
import java.sql.Blob;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class restaurantAttente{

    //variables
    private int id;
    private String nom;
    private String position;
    private Blob imgage;
    private Date date_entrer;
    private String gerant_restaurant;
    private String email;

    public restaurantAttente() {
    }

    public restaurantAttente(int id, String nom, String position, Blob image, String gerant_restaurant) {
        this.id = id;
        this.nom = nom;
        this.position = position;
        this.imgage = image;
        this.gerant_restaurant = gerant_restaurant;
    }

    public restaurantAttente(int id, String nom, String position, Blob imgage, Date date_entrer, String gerant_restaurant) {
        this.id = id;
        this.nom = nom;
        this.position = position;
        this.imgage = imgage;
        this.date_entrer = date_entrer;
        this.gerant_restaurant = gerant_restaurant;
    }

    public restaurantAttente(int id, String nom, String position, String gerant_restaurant) {
        this.id = id;
        this.nom = nom;
        this.position = position;
        this.gerant_restaurant = gerant_restaurant;
    }

    public restaurantAttente(String nom, String position, String gerant_restaurant) {
        this.nom = nom;
        this.position = position;
        this.gerant_restaurant = gerant_restaurant;
    }

    public restaurantAttente(String nom, String position, Date date_entrer, String gerant_restaurant) {
        this.nom = nom;
        this.position = position;
        this.date_entrer = date_entrer;
        this.gerant_restaurant = gerant_restaurant;
    }

    public Date getDate_entrer() {
        return date_entrer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGerant_restaurant() {
        return gerant_restaurant;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPosition() {
        return position;
    }

    public Blob getImgage() {
        return imgage;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setGerant_restaurant(String gerant_restaurant) {
        this.gerant_restaurant = gerant_restaurant;
    }

    public void setDate_entrer(Date date_entrer) {
        this.date_entrer = date_entrer;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setImgage(Blob imgage) {
        this.imgage = imgage;
    }

    @Override
    public String toString() {
        return "restaurantAttente{" + "id=" + id + ", nom=" + nom + ", position=" + position + ", imgage=" + imgage + ", date_entrer=" + date_entrer + ", gerant_restaurant=" + gerant_restaurant + '}';
    }

    
}
