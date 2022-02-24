/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.PanierEntry;
import model.User;

/**
 *
 * @author fomri
 */
public interface IPanier {
    public void addProduct(String productName, User user);

    public void removeProduct(String prodcutName);

    public int getQuantity(String productName);

    public float calculTotale();

    public List<PanierEntry> getEntries(User user);

    public void updateEntety(PanierEntry entry);

    public void deleteEntety(PanierEntry entry);

    public void passerCommande(User user, float totale, java.sql.Date sqlDate);
}
