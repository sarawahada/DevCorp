/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Date;
import java.util.List;
import model.restaurant;

/**
 *
 * @author user
 */
public interface Irestaurant {
    //ajouter
    public void ajouterRestaurant(restaurant p);
    
    //Lister
    public List<restaurant> afficherRestaurant();
    
    //Lister
    public List<restaurant> afficherRestaurant2();
    
    //Lister
    public List<restaurant> afficherRestaurant3(String nom);
    
    //Modifier
    public void modifier(restaurant p);
    
    //Modifier sans id
    public void modifier2(String id, String nom,String position,Date date_entrer, String gerant_resturant);
    
    //Supprimer
    public void supprimer(int id);
    
    public void supprimer2(String id);
    
    //plat non vendu
    public List<restaurant> liquidation_plat();
    
    //recherche par nom
    public List<restaurant> recherche_nom(String nom_rechercher);
}

