/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3a19;

import java.sql.Connection;
import model.Personne;
import services.ServicePersonne;
import util.maConnexion;

/**
 *
 * @author Fayechi
 */
public class JavaApplication3A19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Personne
        Personne p1 = new Personne("Lionel", "Messi", 22, "12345678");
        
        //Service
        ServicePersonne sp = new ServicePersonne();
        
        //Ajouter
        //sp.ajouterPersonne2(p1);
        
        //Afficher
        System.out.println(sp.afficherPersonne());

    }
    
}
