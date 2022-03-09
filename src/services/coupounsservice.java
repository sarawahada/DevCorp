/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author LENOVO
 */
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.coupouns;
import interfaces.interfacecoupouns;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import util.connexion;

/**
 *
 * @author LENOVO
 */
public class coupounsservice implements interfacecoupouns
        {
     Connection cnx = connexion.getInstance().getCnx();
     public void ajoutercoupouns(coupouns c  ) {
        String request = "INSERT INTO `coupouns`( `text_coupouns`, `code_coupouns`, `date_1`,`date_2`,`id_promo1`,`duree_coupouns`) VALUES ('"+c.getText_coupouns()+"','"+c.getCode_coupouns()+"','"+c.getDate_1()+"','"+c.getDate_2()+"','"+c.getId_promo1()+"','"+c.getDuree_coupouns()+"')";
       try{
        Statement st = cnx.createStatement();
        st.executeUpdate(request);
                System.out.println("coupouns ajoutee avec succes");
                 } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
      public List<coupouns> affichercoupouns() {
        List<coupouns> coupoun = new ArrayList<>();
        
        String query = "SELECT * FROM coupouns";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                coupoun.add(new coupouns(rs.getInt("id_coupouns"), rs.getString("text_coupouns"), rs.getString("code_coupouns"),rs.getString("date_1"),rs.getString("date_2"),rs.getInt("id_promo1"),rs.getInt("duree_coupouns")));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return coupoun;
    }
         public boolean modifiercoupouns(coupouns c){
                
                
 

    
        try {
            
            
            String sql = "UPDATE coupouns SET text_coupouns=?, code_coupouns=?,date_1=?,date_2=?,id_promo1=? , duree_coupouns=? WHERE id_coupouns=?";

            PreparedStatement st = cnx.prepareStatement(sql);
            st.setString(1,c.getCode_coupouns());
            st.setString(2,c.getText_coupouns());
            st.setString(3,c.getDate_1());
            st.setString(4,c.getDate_2());
            st.setInt(5,c.getId_promo1());
            st.setInt(6,c.getDuree_coupouns());
            st.setInt(7,c.getId_coupouns());
            
            int rowsUpdated = st.executeUpdate();
            
            if (rowsUpdated > 0) {
            
                System.out.println("coupouns est modifiee");
            }
                   }
        catch (SQLException ex) {
                ex.printStackTrace();
 
        }
        return true;
            }
            
    public void supprimercoupouns(int id_coupouns){
                     //int id_coupouns = 2; 


  try {
            String sql = "Delete FROM coupouns WHERE id_coupouns=?";

            PreparedStatement st = cnx.prepareStatement(sql);
            st.setInt(1, id_coupouns);

            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("coupouns supprimee");
            }       }
        catch (SQLException ex) {
                ex.printStackTrace();
 
        }
            }
    
  	/*public Set<coupouns> getCouponsUntilEndDate(int id_coupouns, String date_2)  {
		Connection cnx = connexion.getInstance().getCnx();

		try {
			
			PreparedStatement join = cnx.prepareStatement("SELECT * FROM coupouns  WHERE id_coupouns = ? AND date_2<=?");
			join.setInt(1, id_coupouns);
			join.setString(2, date_2);
			ResultSet result = join.executeQuery();
			Set<coupouns> set = new HashSet<>();
			while (result.next()) {
				coupouns coupon = CouponDBDAO.ResultSetToCoupon(result);
				set.add(coupon);

			}
			return set;

		} catch (connectionException e) {

			throw e;
		} catch (SQLException e) {
			throw new CouponSystemException("coupon retrieval failed.error accessing the database", e);
		} finally {
			pool.returnConnection(con);

		}
	}*/
    public coupouns getCoupounsByCode(String code_coupouns) throws SQLException{
        String sql="SELECT * FROM coupouns WHERE code_coupouns='"+code_coupouns+"'";
        Statement statement = cnx.prepareStatement(sql);
        //statement.executeUpdate(sql);
        ResultSet rs = statement.executeQuery(sql);
        coupouns c = new coupouns();
       while(rs.next()){
                c.setId_coupouns(rs.getInt("id_coupouns"));
                c.setText_coupouns(rs.getString("text_coupouns"));
                c.setCode_coupouns(rs.getString("code_coupouns"));
                c.setDate_1(rs.getString("date_1")); 
                c.setDate_2(rs.getString("date_2")); 
                c.setId_promo1(rs.getInt("id_promo1"));
                c.setDuree_coupouns(rs.getInt("duree_coupouns"));
              
               
            }
       return c;
    }
    public void qrCode(){
          try{
            String query = "select code_coupouns,date_2 from coupouns";
            Statement stmt = null;
            stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	coupounsservice.generate_qr(rs.getString("code_coupouns"),rs.getString("date_2"));
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
                     }
 	public static void generate_qr(String image_name,String qrCodeData) {
        try {
            String filePath = "C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\JavaApplication1"+image_name+".png";
            String charset = "UTF-8"; // or "ISO-8859-1"
            Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
                new String(qrCodeData.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, 200, 200);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                .lastIndexOf('.') + 1), new File(filePath));
            System.out.println("QR Code image created successfully!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
