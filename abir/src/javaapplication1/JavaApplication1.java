/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;



import util.connexion;
import java.sql.Connection;
import model.offre;
import services.offreservice;


/**
 *
 * @author LENOVO
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     // TODO code application logic here
     offreservice os = new offreservice();
     offre o = new offre (245,"sdefeefefe", "02/03/21","ekhdem");
     //os.ajouteroffre(o);
     
     //Connection cnx =connexion.getInstance().getCnx();
     System.out.print(os.afficheroffre());
     
        os.modifieroffre();
        os.supprimeroffre();
        
    }
    
}
