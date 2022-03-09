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
import java.util.Set;
import model.coupouns;

/**
 *
 * @author LENOVO
 */
public interface interfacecoupouns {
    public void ajoutercoupouns(coupouns c );
    public List<coupouns> affichercoupouns();
  // public void modifiercoupouns();
   public void supprimercoupouns(int id_coupouns);
   public boolean modifiercoupouns(coupouns c);
   public coupouns getCoupounsByCode(String code_coupouns) throws SQLException;
   //public Set<Coupouns> getCouponsUntilEndDate(int id_coupons, Date_f) ;
   
}

