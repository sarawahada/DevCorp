/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.IPanierEntry;
import model.PanierEntry;
import model.Product;

/**
 *
 * @author fomri
 */
public class PanierEntryService implements IPanierEntry{
     PanierEntry panierEntry;

    public PanierEntryService(Product product,int quantity) {
        this.panierEntry = new PanierEntry(product, quantity);
    }
     
     
    @Override
    public void increaseQuantity() {
         panierEntry.increaseQuantity();
    }

    @Override
    public void decreaseQuantity() {
         panierEntry.decreaseQuantity();
    }
    
}
