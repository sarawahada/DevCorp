/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;



/**
 *
 * @author LENOVO
 */


import java.util.List;
import model.offre;
public interface interfaceoffer {
    
    
     //Add
    public void ajouteroffre(offre o);
    public void ajouteroffre2(offre o);
    
    //List
    public List<offre> afficheroffre();
    public void modifieroffre();
    public void supprimeroffre();
    
}
