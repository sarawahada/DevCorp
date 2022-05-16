/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Date;
import java.util.List;
import model.restaurantAttente;

/**
 *
 * @author user
 */
public interface IrestaurantAttente {
    //ajouter
    public void ajouterRestaurant(restaurantAttente p);
    //Lister
    public List<restaurantAttente> afficherRestaurantAttente();
    
    //Modifier
    public void modifierRestaurantAttente(restaurantAttente p);
    
    //Modifier sans id
    public void modifier2RestaurantAttente(String id, String nom,String position,String gerant_restaurant);
    
    //Supprimer
    public void supprimerRestaurantAttente(int id);
    
    public void supprimer2RestaurantAttente(String id);
    
    //recherche par nom
    public List<restaurantAttente> recherche_nom_Restaurant_Attente(String nom_rechercher);
}
