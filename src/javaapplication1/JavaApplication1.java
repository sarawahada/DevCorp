/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author LENOVO
 */
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
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
import java.sql.SQLException;
import javax.mail.MessagingException;
import model.promo;
import services.promoservice;
import services.ExportDataToPdf;
import services.Mail;
import services.ExportDataToPdf;
/**
 *
 * @author LENOVO
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, MessagingException {
     // TODO code application logic here
     interfaceoffer os = new offreservice();
     interfacecoupouns cs = new coupounsservice();
     Ipromo ps = new promoservice();
     coupouns c = new coupouns (799, "coupouns ","resto mano","02-03-2014","02-05-2014",213780,3);
     //offre o = new offre (298,"oui", "02/04/2022","non");
     promo p = new promo (4,"a hit promo",70,"leess","06-05-2022",4333,"i want to say");
     //cs.ajoutercoupouns(c);
     
     //os.ajouteroffre(o);
     //ps.ajouterpromo(p);
     
     //Connection cnx =connexion.getInstance().getCnx();
     //System.out.print(os.afficheroffre());
     //System.out.print(cs.affichercoupouns());
     //System.out.print(ps.afficherpromo());
       // os.modifieroffre();
       os.modifieroffre(o);
        os.supprimeroffre(298);
        cs.modifiercoupouns(c);
        cs.supprimercoupouns(76);
        ps.modifierpromo(p);
        //System.out.println(os.getoffreByType("rjej"));
         //System.out.println(os.getoffreById(111));
         //System.out.println(os.getoffreByIdandType(111,"sssssss"));
         //System.out.println(ps.getpromoById(2));
         //System.out.println(ps.getpromoByType(70));
         System.out.println(cs.getCoupounsByCode("code23432"));
         //os.pdf(o);
         
      //PdfDocument doc = new PdfDocument();
      //doc.saveToFile("ExportDataToPdf.pdf");
    }
    
}
