/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import java.util.List;
import model.User;

public interface IUser {
    //Add
    public void AddUser(User u,String PasswordUse);
    //List
    public List<User> ShowUser();
    //Update user except status and role
    public boolean UpdateUser(User u);
   //Delete 
    public void DeleteUser( String EmailUser);
    //login 
    public boolean Login(String NameUser, String PasswordUser)throws Exception;
    //BanUser
    //public boolean Banned( int UserStatus);
    //Update username
    public void UpdateUsername(String EmailUser, String NameUser) throws SQLException;
    //Update password
    public void UpdatePassword(String EmailUser, String pass) throws SQLException;
    //Update profile picture
     public void UpdateProfilePicUser(String EmailUser, String ProfilePicUser) throws SQLException;
    //Mail
    //search user by username
     public User getUserByNameUser(String NameUser) throws SQLException;
    //search user by mail
     public User getUserByMail(String EmailUser)throws SQLException;
}
