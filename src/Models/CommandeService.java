/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Utils.DbUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class CommandeService {
        
    public boolean passerCommande(User user) {
      
        try {
            Connection conn = DbUtils.getInstance().getConn();
            PreparedStatement preparedStatement = conn.prepareStatement("select  sum(p.price*c.Quantity)  from produit"
                    + " p inner join commande c  where ( p.id = c.id_produit and c.id_user=?)");
            preparedStatement.setString(1, String.valueOf(user.getId()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               PreparedStatement ps = conn.prepareStatement("insert into panier (id_user,total) values (?,?)");
               ps.setString(1,String.valueOf(user.getId()));
               ps.setDouble(2,resultSet.getDouble("sum(p.price*c.Quantity)"));
               ps.executeQuery();
               viderPanier(user.getId());
                return true;
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
       return false;

    }

    public boolean updateCommande(int type , Commande c) {
        if(type == 0 || c.getId() ==0  ){
            return false;
        }
        else if (type == 1 && c.getId()!= 0 ) {
             try {
            Connection conn = DbUtils.getInstance().getConn();
            String query = "UPDATE panier set etat = 1 where id = "+c.getId()+"";
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
         else if (type == 2 && c.getId() != 0) {
             try {
            Connection conn = DbUtils.getInstance().getConn();
            String query = "UPDATE panier set etat = 2 where id = "+c.getId()+"";
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
        }
        } 
       return false;
    }
    
    public void viderPanier(int id_user) {
        try {
            Connection conn = DbUtils.getInstance().getConn();
            String query = "DELETE FROM commande WHERE id_user = "+id_user+"";
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
