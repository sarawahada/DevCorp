
package services;

import interfaces.IAdmin;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.User;
import util.BCrypt;

/**
 *
 * @author sarawahada
 */
public class AdminService extends UserService implements IAdmin {
    //update user
  @Override
    public boolean Banned( int UserStatus){
        if(UserStatus==1){
            return true;
        }
        return false;
    }
        @Override
            public boolean UpdateUser(User u){

        try {
            String cpass=BCrypt.hashpw(u.getPasswordUser(), BCrypt.gensalt(12));
            String sql = "UPDATE user SET NameUser =?, LastNameUser=?, EmailUser=?, ProfilePicUser=?, PasswordUser=?, UserRole=?,UserStatus=? WHERE IdUser=?";

            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setString(1, u.getNameUser());
            statement.setString(2, u.getLastNameUser());
            statement.setString(3, u.getEmailUser());
            statement.setString(4, u.getProfilePicUser());
            statement.setString(5, cpass);
            statement.setString(6, u.getUserRole());
            statement.setInt(7, u.getUserStatus());
            statement.setInt(8, u.getIdUser());
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
 
}
