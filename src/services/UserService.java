/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import com.mysql.cj.jdbc.Blob;
import interfaces.IUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.maConnexion;


public class UserService implements IUser{
    
    //var
    Connection cnx = maConnexion.getInstance().getCnx();
//addUser
       @Override
    public void AddUser(User u) {
        
        String Req = "INSERT INTO `user`(`NameUser`, `LastNameUser`, `EmailUser`, `ProfilePicUser`,`PasswordUser`,`TypeUser`,`StatusUser`) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement su = cnx.prepareStatement(Req);
            su.setString(1, u.getNameUser());
            su.setString(2, u.getLastNameUser());
            su.setString(3, u.getEmailUser());
            su.setBlob(4,u.getProfilePicUser());
            su.setString(5, u.getPasswordUser());
            su.setString(6, u.getTypeUser());
            su.setString(7, u.getStatusUser());
            su.execute();
            System.out.println("User added ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
}
//ShowUser
    @Override
    public List<User> ShowUser() {
        List<User> users = new ArrayList<>();
        
        String query = "SELECT * FROM user";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), (Blob) rs.getBlob(5),rs.getString(6),rs.getString(7),rs.getString(8)));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return users;
    }
    
//UpdateUser
    @Override
            public void UpdateUser(){
                   String LastNameUser = "kkk";
 String EmailUser = "lll"; 
 Blob ProfilePicUser=null ; 
 String PasswordUser = "lll"; 
 String TypeUser = "lll"; 
 String StatusUser = "allowed";
 String NameUser = "Lionel";

 
        try {
            String sql = "UPDATE user SET LastNameUser=?, EmailUser=?, ProfilePicUser=?, PasswordUser=?, TypeUser=?,StatusUser=? WHERE NameUser=?";

            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setString(1, LastNameUser);
            statement.setString(2, EmailUser);
            statement.setBlob(3, ProfilePicUser);
            statement.setString(4, PasswordUser);
            statement.setString(5, TypeUser);
            statement.setString(5, StatusUser);
            statement.setString(7, NameUser);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }       }
        catch (SQLException ex) {
                ex.printStackTrace();
 
        }}
//BanUser
         @Override
            public void BanUser(){
                String PasswordUser = "123845678"; 
                String StatusUser = "banned";

  try {
            String sql = "UPDATE user SET StatusUser=? WHERE PasswordUser!=?";

            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setString(1, StatusUser);
            statement.setString(2, PasswordUser);


            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User is now banned!");
            }       }
        catch (SQLException ex) {
                ex.printStackTrace();
 
        }
            }
//DeleteUser
                   @Override
            public void DeleteUser(){
                     String NameUser = "Lionel"; 


  try {
            String sql = "Delete FROM user WHERE NameUser=?";

            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setString(1, NameUser);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User deleted");
            }       }
        catch (SQLException ex) {
                ex.printStackTrace();
 
        }
            }
            
}
