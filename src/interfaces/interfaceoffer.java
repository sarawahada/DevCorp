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
import model.offre;
import services.ExportDataToPdf;
public interface interfaceoffer {
    
    
    public void onClickListener(offre offre);
    
     //Add
    public void ajouteroffre(offre o);
    public void ajouteroffre2(offre o);
    
    //List
    public List<offre> afficheroffre();
    //public void modifieroffre();
    public boolean modifieroffre(offre o);
   public void supprimeroffre(int id_offre);
    
    public offre getoffreByType(String type_offre)throws SQLException;
    public offre getoffreById(int id_offre) throws SQLException;
    public offre getoffreByIdandType(int id_offre,String type_offre) throws SQLException;
    //public  void pdf(offre o) throws SQLException;
}

