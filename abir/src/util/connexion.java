/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author LENOVO
 */
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;

public class connexion {
    final static String URL = "jdbc:mysql://127.0.0.1:3306/efood";
    final static String USERNAME = "root";
    final static String PWD = "";
    static connexion instance = null;
    private Connection cnx ;

    private connexion() {
         try {
            cnx = DriverManager.getConnection(URL, USERNAME, PWD);
            System.out.println("Connexion etablie avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getCnx() {
        return cnx;
    }

    public static connexion getInstance() {
        if (instance == null) {
            instance = new connexion();
        }
        return instance;
    }
    

       
}
