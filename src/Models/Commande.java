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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fomri
 */
public class Commande {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getDatePanier() {
        return datePanier;
    }

    public void setDatePanier(Date datePanier) {
        this.datePanier = datePanier;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Commande(int id) {
        this.id = id;
    }

    public Commande(int id, Double total, Date datePanier, int etat, int id_user) {
        this.id = id;
        this.total = total;
        this.datePanier = datePanier;
        this.etat = etat;
        this.id_user = id_user;
    }

    public Commande() {
    }

    Connection conn;
   
    
    private int id;
    private Double total;
    private Date datePanier;
    private int etat;
    private int id_user;
    
    
    public boolean passerCommande(User user) {
      
        try {
            conn = DbUtils.getInstance().getConn();
            PreparedStatement preparedStatement = conn.prepareStatement("select  sum(p.price*c.Quantity)  from produit p inner join commande c  where ( p.id = c.id_produit and c.id_user=?)");
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
            conn = DbUtils.getInstance().getConn();
            String query = "UPDATE panier set etat = 1 where id = "+c.getId()+"";
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
         else if (type == 2 && c.getId() != 0) {
             try {
            conn = DbUtils.getInstance().getConn();
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
            conn = DbUtils.getInstance().getConn();
            String query = "DELETE FROM commande WHERE id_user = "+id_user+"";
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

