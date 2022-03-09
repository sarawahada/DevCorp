/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author LENOVO
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import util.maConnexion;
public class ExportDataToPdf {
 maConnexion cnx =null;
ResultSet rs=null;
PreparedStatement pst=null;
 
   public static void main(String[] args) throws SQLException {
 
        //  Assume the below is the input file format
      java.sql.Connection cnx = maConnexion.getInstance().getCnx();
      String input ="select * from offre";
      PreparedStatement pst = cnx.prepareStatement(input);
      //pst=cnx.prepareStatement(input);       
       ResultSet rs=pst.executeQuery(input);
      
        // creation of a document-object
        Document document = new Document();
        try {
            // create a writer
            PdfWriter.getInstance(
            // that listens to the document
            document,
            // and directs a PDF-stream to a file
            new FileOutputStream("output.pdf"));
            // open document
            document.open();
            // ajouter table dans le document
            PdfPTable table = new PdfPTable(5);
            PdfPCell cell =
                new PdfPCell(
                    new Paragraph("entete"));                
            cell.setColspan(5);
           // cell.setBackgroundColor(Color.red);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
 
            //Définir le texte d'en-tête de la Table

            cell = new PdfPCell(new Paragraph("id_pffre"));
            //cell.setBackgroundColor(Color.blue);
            table.addCell(cell);
 
            cell = new PdfPCell(new Paragraph("text_offre"));
           // cell.setBackgroundColor(Color.blue);
            table.addCell(cell);
 
            cell = new PdfPCell(new Paragraph("date_offre"));
            //cell.setBackgroundColor(Color.blue);
            table.addCell(cell);
 
            cell = new PdfPCell(new Paragraph("type_pffre"));
           //cell.setBackgroundColor(Color.blue);
            table.addCell(cell);

            
            //Fill data to the table                       
 
            String inputArray[] = input.split("END");
 
            for (int i = 0; i < inputArray.length; i++) {
 
                String fieldValuesArray[] = inputArray[i].split(",");
 
                for (int j = 0; j < fieldValuesArray.length; j++) {
 
                    table.addCell(fieldValuesArray[j].toString());
 
                }
            }
 
            document.add(table);
            System.out.println("pdf extracted");
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
 
        // close the document
        document.close();
 
    }
    
}
