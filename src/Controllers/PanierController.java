/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Models.Panier;
import Models.PanierEntry;
import Models.User;
import Services.PanierService;
import Services.UserService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * FXML Controller class
 *
 * @author fomri
 */
public class PanierController implements Initializable {

    @FXML
    private VBox PanierPane;

    private Label totaleLabelPrice;

    private User user;

    public PanierController(User user) {
        this.user = user;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<PanierEntry> entries = PanierService.getInstance().getEntries(getUser());

        PanierPane.getChildren().clear();

        if ("Visitor".equalsIgnoreCase(getUser().getUserRole())) {
            if (entries.isEmpty()) {
                Label empltyLabel = new Label("Panier Vide de :" + getUser().getNameUser());
                PanierPane.getChildren().add(empltyLabel);
            } else {
                Label panierTitle = new Label("Panier List de :" + getUser().getNameUser());
                PanierPane.getChildren().add(panierTitle);
                for (PanierEntry panierEntry : entries) {
                    try {
                        HBox hbox = panierEntryView(panierEntry);
                        Label prodcutName = new Label(panierEntry.getProduct().name());
                        hbox.getChildren().add(prodcutName);
                        PanierPane.getChildren().add(hbox);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                Separator separator = new Separator();
                separator.setOrientation(Orientation.HORIZONTAL);
                PanierPane.getChildren().add(separator);
                HBox totaleView = totalView(PanierService.getInstance().calculTotale(), getUser());
                PanierPane.getChildren().add(totaleView);

            }

        } else if ("Admin".equalsIgnoreCase(getUser().getUserRole())) {
            Map<String, List<PanierEntry>> allEntries = PanierService.getInstance().getAllEntries();
            for (Map.Entry<String, List<PanierEntry>> panierEntry : allEntries.entrySet()) {
                try {
                    try {
                        
                        Label UserNamePanierLabel = new Label("Panier de :" + panierEntry.getKey());
                        PanierPane.getChildren().add(UserNamePanierLabel);
                        List<PanierEntry> childMap = panierEntry.getValue();
                        for (PanierEntry entry : childMap) {
                            HBox hbox = panierEntryView(entry);
                            Label prodcutName = new Label(entry.getProduct().name());
                            hbox.getChildren().add(prodcutName);
                            PanierPane.getChildren().add(hbox);
                        }
                        
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Separator separator = new Separator();
                    separator.setOrientation(Orientation.HORIZONTAL);
                    PanierPane.getChildren().add(separator);
                    HBox totaleView = totalViewForAdmin(PanierService.getInstance().calculTotaleByEntries(panierEntry.getValue()), PanierService.getInstance().getUserByName(panierEntry.getKey()));
                    PanierPane.getChildren().add(totaleView);
                } catch (SQLException ex) {
                    Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }

        }
    }

    private HBox totalView(float totalePrice, User user) {
        HBox layout = new HBox();
        layout.setAlignment(Pos.CENTER);
        Label totalLabel = new Label("Totale : ");
        totalLabel.setStyle("-fx-font-size:15pt;");
        Button passerCommandePanier = new Button("Passer Le Panier");
        passerCommandePanier.setStyle("-fx-padding:15px");
 
        //Action du button passerCommande
        passerCommandePanier.setOnAction((t) -> {
            java.util.Date date = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            PanierService.getInstance().passerCommande(user, totalePrice, sqlDate);
            PanierService.getInstance().getEntries(user).clear();

        });

        this.totaleLabelPrice = new Label(String.valueOf(totalePrice));
        layout.getChildren().addAll(totalLabel, this.totaleLabelPrice, passerCommandePanier); 
        return layout;
    }
    
     private HBox totalViewForAdmin(float totalePrice, User user) {
        HBox layout = new HBox();
        layout.setAlignment(Pos.CENTER);
        Label totalLabel = new Label("Totale : ");
        totalLabel.setStyle("-fx-font-size:15pt;"); 

        Button validerLePanier = new Button("Valider Le Panier");
        validerLePanier.setStyle("-fx-padding:15px"); 
        //Action du button passerCommande
        validerLePanier.setOnAction((t) -> {
            PanierService.getInstance().validerCommande(user); 
        }); 
        this.totaleLabelPrice = new Label(String.valueOf(totalePrice));
        layout.getChildren().addAll(totalLabel, this.totaleLabelPrice, validerLePanier); 
        return layout;
    }
    
    

    private HBox panierEntryView(PanierEntry panierEntry) throws FileNotFoundException {
        HBox layout = new HBox();
        layout.setAlignment(Pos.CENTER_LEFT);

        FileInputStream input = new FileInputStream("C:\\Users\\fomri\\Documents\\Chahine\\Final\\CRUDPI2\\MyApp\\src\\Assets\\" + panierEntry.getProduct().getImageFile());
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);

        Label productName = new Label(panierEntry.getProduct().name());
        productName.setPrefWidth(100);
        productName.setStyle("-fx-font-size:15pt; -fx-padding:5px");

        Label productQuantity = new Label(String.valueOf(panierEntry.getQuantity()));
        productName.setStyle("-fx-padding:5px");

        Button plusButton = new Button("+");
        plusButton.setStyle("-fx-padding:5px");

        plusButton.setUserData(panierEntry.getProduct().name());
        plusButton.setOnAction((t) -> {
            String name = (String) ((Node) t.getSource()).getUserData();
            PanierService.getInstance().addProduct(name, getUser());
            productQuantity.setText(String.valueOf(PanierService.getInstance().getQuantity(name)));
            this.totaleLabelPrice.setText(String.valueOf(PanierService.getInstance().calculTotale()));
        });

        Button moinsButton = new Button("-");
        moinsButton.setStyle("-fx-padding:5px");
        moinsButton.setUserData(panierEntry.getProduct().name());
        moinsButton.setOnAction((t) -> {
            String name = (String) ((Node) t.getSource()).getUserData();
            PanierService.getInstance().removeProduct(name);
            productQuantity.setText(String.valueOf(PanierService.getInstance().getQuantity(name)));
            this.totaleLabelPrice.setText(String.valueOf(PanierService.getInstance().calculTotale()));
        });

        Label labelPrice = new Label(String.valueOf("£ " + panierEntry.getProduct().getPrice()));
        labelPrice.setStyle("-fx-padding:5px");

        layout.getChildren().addAll(imageView, productName, plusButton, productQuantity, moinsButton, labelPrice);
        return layout;

    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
