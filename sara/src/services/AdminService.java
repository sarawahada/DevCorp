
package services;

import interfaces.IAdmin;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sarawahada
 */
public class AdminService extends UserService implements IAdmin {
    
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
}
