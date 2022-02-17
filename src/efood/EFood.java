
package efood;

import model.User;
import services.UserService;
import model.Admin;
import services.AdminService;
import model.Chef;
import services.ChefService;
import model.Client;
import services.ClientService;
import model.DeliveryGuy;
import services.DeliveryGuyService;

public class EFood {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Personne
        User u1 = new User("Mourad", "Wahada", "MouradWahada@esprit.tn",null, "12345678","client","allowed");
        User u2 = new User("Sara", "Wahada", "SaraWahada@esprit.tn",null, "KKKK","admin","allowed");
        Admin a1 = new Admin();
        Chef ch1 = new Chef();
        DeliveryGuy d1 = new DeliveryGuy(); 
        Client c1 = new Client(); 
        //Service
        UserService su = new UserService();
        AdminService as = new AdminService();
        ChefService chs = new ChefService();
        DeliveryGuyService dgs = new DeliveryGuyService();
        ClientService cs = new ClientService();
//Ajouter
       //su.AddUser(u1);
       //su.AddUser(u2); 
       //au.AddUser(u1);
       //cs.AddUser(u2);
        
//Afficher
       //System.out.println(su.ShowUser());
       //System.out.println(au.ShowUser());
//Modifier
       //su.UpdateUser();
       //au.UpdateUser();
//ban

     // au.BanUser();
//Supprimer    
      //su.DeleteUser();
     //au.DeleteUser();

    }
    
}
