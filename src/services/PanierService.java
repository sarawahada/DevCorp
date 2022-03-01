/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.IPanier;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Panier;
import model.PanierEntry;
import model.Product;
import model.User;
import util.maConnexion;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Statement;

/**
 *
 * @author fomri
 */
public class PanierService implements IPanier {

    Connection conn;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    @Override
    public void addProduct(String productName, User user) {
        PanierEntry productEntry = Panier.getInstance().getEntries().get(productName.toUpperCase());
        if (productEntry != null) {
            productEntry.increaseQuantity();
            updateEntety(productEntry);
        } else {
            try {
                Product product = Product.valueOf(productName);
                PanierEntry entry = new PanierEntry(product, 1);
                Panier.getInstance().getEntries().put(productName.toUpperCase(), entry);
                conn = maConnexion.getInstance().getCnx();
                String query = "INSERT INTO commande (id_produit, id_user, Quantity) VALUES(" + product.getId() + "," + String.valueOf(user.getIdUser()) + ",1)";
                java.sql.Statement statement = conn.createStatement();
                statement.executeUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void removeProduct(String prodcutName) {
        PanierEntry panierEntry = Panier.getInstance().getEntries().get(prodcutName.toUpperCase());
        if (panierEntry.getQuantity() >= 1) {
            panierEntry.decreaseQuantity();
            updateEntety(panierEntry);
        }
        if (panierEntry.getQuantity() == 0) {
            deleteEntety(panierEntry);
            Panier.getInstance().getEntries().remove(prodcutName);
        }
    }

    @Override
    public int getQuantity(String productName) {
        PanierEntry entry = Panier.getInstance().getEntries().get(productName.toUpperCase());
        if (entry != null) {
            return entry.getQuantity();
        }
        return 0;
    }

    @Override
    public float calculTotale() {
        float totale = 0;
        for (PanierEntry entry : Panier.getInstance().getEntries().values()) {
            float entryCost = entry.getProduct().getPrice() * entry.getQuantity();
            totale += entryCost;
        }
        return totale;
    }

    @Override
    public List<PanierEntry> getEntries(User user) {
        String productId = "";
        int quantity;
        Product product = null;

        try {
            conn = maConnexion.getInstance().getCnx();
            preparedStatement = conn.prepareStatement("SELECT * from commande WHERE id_user = ?");
            preparedStatement.setString(1, String.valueOf(user.getIdUser()));
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
                    Panier.getInstance().getEntries().put(rs.getString("name"), entry);
                }
            }
            return new ArrayList<>(Panier.getInstance().getEntries().values());

        } catch (SQLException ex) {
            Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }

    @Override
    public void updateEntety(PanierEntry entry) {
        try {
            conn = maConnexion.getInstance().getCnx();
            String query = "UPDATE commande set Quantity = " + entry.getQuantity() + " WHERE id_produit=" + String.valueOf(entry.getProduct().getId());
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteEntety(PanierEntry entry) {
        try {
            conn = maConnexion.getInstance().getCnx();
            String query = "DELETE FROM commande WHERE id_produit = " + entry.getProduct().getId();
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void passerCommande(User user, float totale, Date sqlDate) {

        try {
            conn = maConnexion.getInstance().getCnx();
            String query = "INSERT INTO panier (total, datePanier,etat,id_user ) VALUES(" + String.valueOf(totale) + ",'" + sqlDate + "','En_cour'," + String.valueOf(user.getIdUser()) + ")";
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
