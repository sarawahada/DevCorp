/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package gui;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;


import model.coupouns;
import services.Mail;

import services.coupounsservice;



/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class CoupounsController implements Initializable {
    
    
    @FXML
    private Button ajoutcoup;

    @FXML
    private TextField code_coup;

    @FXML
    private DatePicker date1_coup;

    @FXML
    private DatePicker date2_coup;

    @FXML
    private TextField duree_coup;

    @FXML
    private TextField id_coup;

    @FXML
    private TextField idp_coup;

    @FXML
    private TextField nom_coup;
   

     CoupounListController clc = new CoupounListController();
     
    @FXML
    void ajoutcoup(ActionEvent event) throws IOException {
         if (nom_coup.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Please insert a name");
        alert.showAndWait();}
        else if(code_coup.getText().isEmpty()){
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(" please insert a type ");
        alert.showAndWait();
        }
       else if(duree_coup.getText().isEmpty())
        {
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(" please insert a description  ");
        alert.showAndWait();}
        else{
            coupouns c = new coupouns();
           
            c.setText_coupouns(nom_coup.getText());
            c.setCode_coupouns(code_coup.getText());
            c.setDate_1(date1_coup.getValue().toString());
            c.setDate_2(date2_coup.getValue().toString());
            c.setId_promo1(Integer.valueOf(idp_coup.getText()));
            c.setDuree_coupouns(Integer.valueOf(duree_coup.getText()));
        coupounsservice cs = new coupounsservice();
        cs.ajoutercoupouns(c);
        
      Alert a1 =new Alert(Alert.AlertType.INFORMATION);
        a1.setHeaderText("success");
        a1.setContentText("you can now print your coupoun");
        ButtonType buttonTypeOne = new ButtonType("Print");
        ButtonType buttonTypeTwo = new ButtonType("Exit");
        a1.getButtonTypes().setAll(buttonTypeOne,buttonTypeTwo);
        Optional<ButtonType> result = a1.showAndWait();
         if (result.get() == buttonTypeOne){
              coupounsservice.generate_qr( code_coup.getText(),code_coup.getText());
              Document document = new Document();
              String FILE_NAME = "/Users/sarawahada/Downloads/JavaApplication1/src/pica/pdf"+code_coup.getText()+".pdf";
                try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
            document.open();
            Paragraph p = new Paragraph();
            p.add("COUPON DETAIL");
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            Paragraph p2 = new Paragraph();
            p2.add(""); //no alignment
            document.add(p2);
            Paragraph p3 = new Paragraph();
            p3.add(""); //no alignment
            document.add(p3);
            Paragraph p4 = new Paragraph();
            p4.add(""); //no alignment
            document.add(p4);
            Paragraph p5 = new Paragraph();
            p5.add(""); //no alignment
            document.add(p5);
            Font f = new Font();
            f.setStyle(Font.BOLD);
            f.setSize(20);
            f.setColor(BaseColor.BLACK);
            Font f2 = new Font();
            f2.setStyle(Font.UNDERLINE);
            f2.setSize(15);
            document.add(new Paragraph("Coupouns :", f));
            document.add(new Paragraph("Coupoun description :", f2));
            Paragraph p6 = new Paragraph();
            p6.setSpacingAfter(15);
            p6.setSpacingBefore(15);
            p6.add(nom_coup.getText()); //no alignment
            document.add(p6);
            document.add(new Paragraph("Start date :", f2));
            Paragraph p7 = new Paragraph();
            p7.setSpacingAfter(15);
            p7.setSpacingBefore(15);
            p7.add(date1_coup.getValue().toString()); //no alignment
            document.add(p7);
            document.add(new Paragraph("End date :", f2));
            Paragraph p8 = new Paragraph();
            p8.setSpacingAfter(15);
            p8.setSpacingBefore(15);
            p8.add(date2_coup.getValue().toString()); //no alignment
            document.add(p8);
            document.add(new Paragraph("Duration", f2));
            Paragraph p9 = new Paragraph();
            p9.setSpacingAfter(15);
            p9.setSpacingBefore(15);
            p9.add(duree_coup.getText()); //no alignment
            document.add(p9);
            document.add(new Paragraph("QR code", f2));
            com.itextpdf.text.Image image1=  com.itextpdf.text.Image.getInstance("/Users/sarawahada/Downloads/JavaApplication1/src/pica/qrcode"+code_coup.getText()+".png");
            image1.setAbsolutePosition(400f,450f);
            document.add(image1);
            document.close();
            
            System.out.println("Done");
        } catch (DocumentException | IOException e) {
        }
 
         }
       }
    }
  
      
       

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       // clc.showAllCoupouns();
       
    }
   
        }
    

    


