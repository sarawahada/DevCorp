/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.User;

public interface IUser {
    //Add
    public void AddUser(User u);
    //List
    public List<User> ShowUser();
    //Update
    public void UpdateUser();
    //Ban (Update Status to "Banned")
    public void BanUser();
   //Delete 
    public void DeleteUser();

}
