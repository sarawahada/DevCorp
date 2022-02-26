package gui;

import interfaces.IUser;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import services.UserService;
import services.SendingMail;


public class LoginController implements Initializable {

    @FXML
    private TextField EmailUser;

    @FXML
    private PasswordField PasswordUser;


    @FXML
    private Button SignUpButton;

    @FXML
    private AnchorPane content;

    @FXML
    private AnchorPane contentContainer;

    @FXML
    private ImageView contentPic;

    @FXML
    private Label label;

    @FXML
    private Label labelContainer;

    @FXML
    private Label labelNoAccount;

    @FXML
    private Label labelSignIn;

    @FXML
    private Label labelSignUp;

    @FXML
    private Label labelpwd;
  
    @FXML
    private Button LoginButton;
    public static int  codem;
    
  
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

     @FXML
   private void login(ActionEvent event) throws Exception {
        IUser Iu = new UserService();
        if (EmailUser.getText().equals("")){
        EmailUser.setStyle("-fx-border-color: red");
        }
        else if(PasswordUser.getText().equals("")) { 
        EmailUser.setStyle("");
        PasswordUser.setStyle("-fx-border-color: red");  
        
        }
        else if (Iu.Login(EmailUser.getText(), PasswordUser.getText())) {
                    String Role = Iu.getRolebyId(Iu.getIdbyMail(EmailUser.getText()));
                  
            switch (Role) {
                case "client" ->                     {
                        FXMLLoader loader = new FXMLLoader();
                        label.getScene().getWindow().hide();
                        Stage prStage = new Stage();
                        loader.setLocation(getClass().getResource("Client.fxml"));
                        Parent root = loader.load();
                        Scene scene = new Scene(root);
                        prStage.setScene(scene);
                        prStage.setResizable(false);
                        prStage.show();
                    }
                case "chef" ->                     {
                        FXMLLoader loader = new FXMLLoader();
                        label.getScene().getWindow().hide();
                        Stage prStage = new Stage();
                        loader.setLocation(getClass().getResource("ChefDashboard.fxml"));
                        Parent root = loader.load();
                        Scene scene = new Scene(root);
                        prStage.setScene(scene);
                        prStage.setResizable(false);
                        prStage.show();
                    }
                case "admin" ->                     {
                        FXMLLoader loader = new FXMLLoader();
                        label.getScene().getWindow().hide();
                        Stage prStage = new Stage();
                        loader.setLocation(getClass().getResource("AdminDashboard.fxml"));
                        Parent root = loader.load();
                        Scene scene = new Scene(root);
                        prStage.setScene(scene);
                        prStage.setResizable(false);
                        prStage.show();
                    }
                case "delivery_guy" ->                 {
                    FXMLLoader loader = new FXMLLoader();
                    label.getScene().getWindow().hide();
                    Stage prStage = new Stage();
                    loader.setLocation(getClass().getResource("DeliveryDashboard.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    prStage.setScene(scene);
                    prStage.setResizable(false);
                    prStage.show();
                }
                default -> { }
            }
        } 
        else {
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Password or Email is incorrect");
            alert.showAndWait();
        } 
   } 
       @FXML
    private void SignUp(ActionEvent event) throws IOException {
        
     FXMLLoader loader = new FXMLLoader();
                SignUpButton.getScene().getWindow().hide();  
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("SignUp.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
    }
    
  
 /*@FXML
    private void MotpassOubliee(ActionEvent event) throws MessagingException, IOException {
        //username = EmailUser.getText();
        IUser Iu = new UserService();
   		
        Random r = new Random ();
      codem =r.nextInt(9999-1000+1);
      System.out.println(codem);
                //sc.setCodepass(sc.getIdbymail(t1.getText()), codem);

        //System.out.println(sc.getPassbyId(sc.getIdbymail(t1.getText())));
        if(isValidEmailAddress(EmailUser.getText())){
   //     SendMail.send(t1.getText(), sc.getPassbyId(sc.getIdbymail(t1.getText())));
          SendingMail.send(EmailUser.getText(), codem);
          FXMLLoader loader = new FXMLLoader();
        label.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("Motpasseoublie.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();}
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!! Adresse Email Non Valide !!!");
            alert.showAndWait();
        }
       
    }*/
    
        }    
    

