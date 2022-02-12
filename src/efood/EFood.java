/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efood;

import model.User;
import services.UserService;

/**
 *
 * @author Fayechi
 */
public class EFood {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Personne
        User u1 = new User("Mourad", "Wahada", "MouradWahada@esprit.tn",null, "12345678","client","allowed");
        User u2 = new User("Sara", "Wahada", "SaraWahada@esprit.tn",null, "KKKK","admin","allowed");

        //Service
        UserService su = new UserService();
        
//Ajouter
       //su.AddUser(u1);
       //su.AddUser(u2);

        
//Afficher
       //System.out.println(su.ShowUser());
//modify
      // su.UpdateUser();
//ban
      //su.BanUser();
//delete    
      //su.DeleteUser();

    }
    
}
