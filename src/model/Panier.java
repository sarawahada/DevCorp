/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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

    public Map<String, PanierEntry> getEntries() {
        return entries;
    }

    public void setEntries(Map<String, PanierEntry> entries) {
        this.entries = entries;
    }
    
    
}
