/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.File;
import java.sql.Blob;
import java.sql.Date;
import java.util.List;
import model.menu;

/**
 *
 * @author user
 */
public interface Imenu {
    //ajouter
    public void ajouterMenu(menu p);
    
    //ajouter
    public void ajouterMenu2(String nom, String quantite, String prix, Blob imgSrc, String saison,Date date_mise_en_rayon, Date date_peremption, File file);
    
    //ajouter
    public void ajouterMenu3(menu p);
    
    //Lister
    public List<menu> afficherMenu();
    
    //Lister
    public List<menu> afficherMenu2(String nom);
    
    //Modifier
    public void modifier(menu p);
    
    //Supprimer
    public void supprimer(int id);
    public void supprimer2(String id);
    public void supprimer3(String nom);
    
    //Modifier id string
    public void modifier2(String id, String nom, String quantite, String prix, Blob imgSrc, String saison,Date date_mise_en_rayon, Date date_peremption);
   
    //plat non vendu
    //public List<menu> liquidation_plat();
}
