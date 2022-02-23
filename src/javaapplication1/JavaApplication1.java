/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;



import interfaces.Ipromo;
import util.connexion;
import java.sql.Connection;
import java.util.List;
import model.coupouns;
import model.offre;
import services.coupounsservice;
import services.offreservice;
import interfaces.interfacecoupouns;
import interfaces.interfaceoffer;
import model.promo;
import services.promoservice;


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
     interfaceoffer os = new offreservice();
     interfacecoupouns cs = new coupounsservice();
     Ipromo ps = new promoservice();
     coupouns c = new coupouns (76, "coupouns ","effef");
     offre o = new offre (298,"oui", "02/04/21","non");
     promo p = new promo (333,"promo",50,"fssfssf","06-05-2019",232223,"dfeecsecvecd");
     //cs.ajoutercoupouns(c);
     
     //os.ajouteroffre(o);
     //ps.ajouterpromo(p);
     
     //Connection cnx =connexion.getInstance().getCnx();
     System.out.print(os.afficheroffre());
     System.out.print(cs.affichercoupouns());
     System.out.print(ps.afficherpromo());
       // os.modifieroffre();
       os.modifieroffre(o);
        os.supprimeroffre(298);
        cs.modifiercoupouns(c);
        cs.supprimercoupouns(76);
        ps.modifierpromo(p);
        ps.supprimerpromo(333);
    }
    
}
