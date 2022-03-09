/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

/**
 *
 * @author LENOVO
 */
import java.sql.SQLException;
import java.util.List;
import model.promo;

/**
 *
 * @author LENOVO
 */
public interface Ipromo {
    
    
    public void ajouterpromo(promo p ) ;
    public List<promo> afficherpromo();
    public boolean modifierpromo(promo p);
    public void supprimerpromo(int id_promo);
    public promo getpromoById(int id_promo) throws SQLException;
    public promo getpromoByType(int type_promo) throws SQLException;

  
}
