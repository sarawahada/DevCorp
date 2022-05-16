
package services;

import interfaces.IAdmin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.User;
import org.json.JSONArray;
import util.BCrypt;

/**
 *
 * @author sarawahada
 */
public class AdminService extends UserService implements IAdmin {
     //addUser
       @Override
    public void AddAdmin(User u,String PasswordUser) {
        
       String Req = "INSERT INTO `user`(`NameUser`, `LastNameUser`, `EmailUser`, `ProfilePicUser`,`PasswordUser`,`UserRole`,`UserStatus`) VALUES (?,?,?,?,?,?,?)";
        try {
            String hashedpw = BCrypt.hashpw(PasswordUser, BCrypt.gensalt(12));
            PreparedStatement su = cnx.prepareStatement(Req);
            su.setString(1, u.getNameUser());
            su.setString(2, u.getLastNameUser());
            su.setString(3, u.getEmailUser());
            su.setString(4,u.getProfilePicUser());
            su.setString(5, hashedpw);
            su.setString(6, u.getUserRole().toString());
            su.setInt(7, u.getUserStatus());
            su.execute();
            System.out.println("admin added!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
}
        //update user
        @Override
            public boolean UpdateEmployee(User u,int IdUser){

        try {
           
            String sql = "UPDATE user SET UserRole=?,UserStatus=? WHERE IdUser=?";

            PreparedStatement statement = cnx.prepareStatement(sql);
    
            statement.setString(1, u.getUserRole().toString());
            statement.setInt(2, u.getUserStatus());
            statement.setInt(3, IdUser);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }       }
        catch (SQLException ex) {
               System.out.println(ex.getMessage());
 
        }
            return true;
            }
            //update user role
@Override
              public void UpdateRole(String EmailUser, String UserRole) throws SQLException{
        String sql= "UPDATE user SET UserRole='"+ UserRole +"'"+"WHERE EmailUser='"+ EmailUser+"'";
        PreparedStatement statement = cnx.prepareStatement(sql);
        statement.executeUpdate(sql);
    }
              //update user status
 @Override
             public void UpdateUserStatus(int IDUser, int UserStatus ) throws SQLException{
        System.out.println(UserStatus);
        String sql= "UPDATE user SET UserStatus='"+ UserStatus +"'"+"WHERE IDUser='"+ IDUser +"'";
         PreparedStatement statement = cnx.prepareStatement(sql);
        statement.executeUpdate(sql);
    }
                 @Override
    public ObservableList<User> GetListUsers() {
        ObservableList<User> Users = FXCollections.observableArrayList();
        try {
            String sql = "SELECT IdUser,NameUser,LastNameUser,EmailUser,UserStatus FROM user";
             PreparedStatement statement = cnx.prepareStatement(sql);
              ResultSet rs = statement.executeQuery(sql);
            User user;
          //   String Role = rs.getString("UserRole");
        //JSONArray arrayRole = new JSONArray(Role); 
            while (rs.next()) {
                user = new User(rs.getInt("IdUser"), rs.getString("NameUser"), rs.getString("LastNameUser"), rs.getString("EmailUser"),rs.getInt("UserStatus"));
                Users.add(user);
            }

        } catch (SQLException ex) {
            
        }
        return Users;
    }


}
