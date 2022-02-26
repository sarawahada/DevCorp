/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efood;

import model.User;
import services.UserService;
import services.ClientService;
import services.ChefService;
import services.DeliveryGuyService;
import interfaces.IUser;
import interfaces.IAdmin;
import java.sql.SQLException;
import services.AdminService;


public class EFood {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception  {
        // TODO code application logic here
        
        //Personne
        User u1 = new User("Mourad123", "Wahada", "MouradWahada@esprit.tn","ProfilePic", "lina","client",1);
        User u2 = new User("Sara222", "Wahada", "SaraWahada@esprit.tn","ProfilePic", "sara","admin",0);

        //Interface
        
        IUser Iu = new UserService();
        IAdmin Ia = new AdminService ();
      
           //login
           //Iu.Login("MouradWahada@esprit.tn","lina");
            //Ajouter
           // Iu.AddUser(u1,"lina");
           //Ia.AddUser(u2,"sara");
           //su.AddUser(u2);
           //au.AddUser(u1);
           //cls.AddUser(u2);
          

            
//Afficher
System.out.println(Iu.ShowUser());

//modify
 //Iu.UpdateUser(u2);
 //Iu.UpdateUsername("SaraWahada@esprit.tn","Sara2000");
 //Iu.UpdatePassword("SaraWahada@esprit.tn","sara");
 //Iu.UpdateProfilePicUser("SaraWahada@esprit.tn", "UpdatedProfilePicture");
 
//ban
 //Ia.Banned(1);

//delete
//Iu.DeleteUser("MouradWahada@esprit.tn");

//search user by username 
//System.out.println(Iu.getUserByNameUser("Mourad123"));
//search user by mail
//System.out.println(Iu.getUserByMail("SaraWahada@esprit.tn"));

//System.out.println(Iu.getRolebyId(Iu.getIdbyMail("SaraWahada@esprit.tn")));

}}
