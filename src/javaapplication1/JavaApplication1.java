/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;



import util.connexion;
import java.sql.Connection;
import java.util.List;
import model.coupouns;
import model.offre;
import services.coupounsservice;
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
     coupounsservice cs = new coupounsservice();
     coupouns c = new coupouns (243, "dfefwff","effefeef");
     offre o = new offre (255,"sdefeefefe", "02/03/21","ekhdem");
     //cs.ajoutercoupouns(c);
     
     //os.ajouteroffre(o);
     
     //Connection cnx =connexion.getInstance().getCnx();
     System.out.print(os.afficheroffre());
     System.out.print(cs.affichercoupouns());
     
        os.modifieroffre();
        os.supprimeroffre();
        cs.modifiercoupouns();
        cs.supprimercoupouns();
        
    }
    
}
