/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import com.mysql.cj.jdbc.Blob;

public class User {
    
    //var
    private int IdUser;
    private String NameUser;
    private String LastNameUser;
    private String EmailUser;
    private Blob ProfilePicUser;
    private String PasswordUser;
    private String TypeUser;
    private String StatusUser;

    
    //Constructor
    public User() {
    }

    public User(int IdUser, String NameUser, String LastNameUser, String EmailUser, Blob ProfilePicUser,String PasswordUser,String TypeUser,String StatusUser) {
        this.IdUser = IdUser;
        this.NameUser = NameUser;
        this.LastNameUser = LastNameUser;
        this.EmailUser = EmailUser;
        this.ProfilePicUser = ProfilePicUser;
        this.PasswordUser = PasswordUser;
        this.TypeUser = TypeUser;
        this.StatusUser= StatusUser;
        
    }
  public User( String NameUser, String LastNameUser, String EmailUser, Blob ProfilePicUser,String PasswordUser,String TypeUser,String StatusUser) {
        this.NameUser = NameUser;
        this.LastNameUser = LastNameUser;
        this.EmailUser = EmailUser;
        this.ProfilePicUser = ProfilePicUser;
        this.PasswordUser = PasswordUser;
        this.TypeUser = TypeUser;
        this.StatusUser= StatusUser;

        
    }
  //Getters & Setters


    public int getIdUser() {
        return IdUser;
    }

    public String getNameUser() {
        return NameUser;
    }

    public String getLastNameUser() {
        return LastNameUser;
    }

    public String getEmailUser() {
        return EmailUser;
    }

    public Blob getProfilePicUser() {
        return ProfilePicUser;
    }

    public String getPasswordUser() {
        return PasswordUser;
    }

    public String getTypeUser() {
        return TypeUser;
    }
    public String getStatusUser() {
        return StatusUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }
     public void setStatusUSer(String StatusUser) {
        this.StatusUser = StatusUser;
    }

    public void setNameUser(String NameUser) {
        this.NameUser = NameUser;
    }

    public void setLastNameUser(String LastNameUser) {
        this.LastNameUser = LastNameUser;
    }

    public void setEmailUser(String EmailUser) {
        this.EmailUser = EmailUser;
    }

    public void setProfilePicUser(Blob ProfilePicUser) {
        this.ProfilePicUser = ProfilePicUser;
    }

    public void setPasswordUser(String PasswordUser) {
        this.PasswordUser = PasswordUser;
    }

    public void setTypeUser(String TypeUser) {
        this.TypeUser = TypeUser;
    }
    
 
    //Affichage
    @Override
    public String toString() {
        return "User{" + "IdUser=" + IdUser + ", NameUser=" + NameUser + ", LastNameUser=" + LastNameUser + ", EmailUser=" + EmailUser + ", ProfilePicUser=" + ProfilePicUser +",PasswordUser=" + PasswordUser +",TypeUser=" + TypeUser +",StatusUser=" + StatusUser + '}';
    }

   
}
   