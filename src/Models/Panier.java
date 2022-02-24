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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fomri
 */
public class Panier {

    private static Panier INSTANCE;

    Connection conn;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public static Panier getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Panier();
        }
        return INSTANCE;
    }
    private Map<String, PanierEntry> entries;

    public Panier() {
        this.entries = new HashMap<>();
    }

    public void addProduct(String productName, User user) {
        PanierEntry productEntry = entries.get(productName.toUpperCase());
        if (productEntry != null) {
            productEntry.increaseQuantity();
            updateEntety(productEntry);
        } else {
            try {
                Product product = Product.valueOf(productName);
                PanierEntry entry = new PanierEntry(product, 1);
                entries.put(productName.toUpperCase(), entry);
                conn = DbUtils.getInstance().getConn();
                String query = "INSERT INTO commande (id_produit, id_user, Quantity) VALUES(" + product.getId() + "," + String.valueOf(user.getId()) + ",1)";
                Statement statement = conn.createStatement();
                statement.executeUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void removeProduct(String prodcutName) {
        PanierEntry panierEntry = entries.get(prodcutName.toUpperCase());
        if (panierEntry.getQuantity() >= 1) {
            panierEntry.decreaseQuantity();
            updateEntety(panierEntry);
        }
        if (panierEntry.getQuantity() == 0) {
            deleteEntety(panierEntry);
            entries.remove(prodcutName);
        }
    }

    public int getQuantity(String productName) {
        PanierEntry entry = entries.get(productName.toUpperCase());
        if (entry != null) {
            return entry.getQuantity();
        }
        return 0;
    }

    public float calculTotale() {
        float totale = 0;
        for (PanierEntry entry : entries.values()) {
            float entryCost = entry.getProduct().getPrice() * entry.getQuantity();
            totale += entryCost;
        }
        return totale;
    }

    public List<PanierEntry> getEntries(User user) {
        String productId = "";
        int quantity;
        Product product = null;

        try {
            conn = DbUtils.getInstance().getConn();
            preparedStatement = conn.prepareStatement("SELECT * from commande WHERE id_user = ?");
            preparedStatement.setString(1, String.valueOf(user.getId()));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productId = resultSet.getString("id_produit");
                quantity = Integer.valueOf(resultSet.getString("Quantity"));
                PreparedStatement ps = conn.prepareStatement("SELECT * from produit WHERE id = ?");
                ps.setString(1, productId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    product = Product.valueOf(rs.getString("name"));
                    PanierEntry entry = new PanierEntry(product, quantity);
                    entries.put(rs.getString("name"), entry);
                }
            }
            return new ArrayList<>(entries.values());

        } catch (SQLException ex) {
            Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();

    }

    public void updateEntety(PanierEntry entry) {
        try {
            conn = DbUtils.getInstance().getConn();
            String query = "UPDATE commande set Quantity = " + entry.getQuantity() + " WHERE id_produit=" + String.valueOf(entry.getProduct().getId());
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteEntety(PanierEntry entry) {
        try {
            conn = DbUtils.getInstance().getConn();
            String query = "DELETE FROM commande WHERE id_produit = " + entry.getProduct().getId();
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void passerCommande(User user, float totale,java.sql.Date sqlDate) {
        int idcommande = 0;
        for (PanierEntry entry : entries.values()) {
            try {
                conn = DbUtils.getInstance().getConn();
                String query = "INSERT INTO panier (total, datePanier,etat,id_user ) VALUES(" + String.valueOf(totale) + ",'" + sqlDate + "','En_cour'," + String.valueOf(user.getId()) + ")";
                Statement statement = conn.createStatement();
                statement.executeUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
