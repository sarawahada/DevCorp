/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package css;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author user
 */
public class Message {
    public void error_message(String titre, String header, String content){
        Alert dialogue = new Alert(AlertType.ERROR);
        dialogue.setTitle(titre);
        dialogue.setHeaderText(header);
        dialogue.setContentText(content);
        dialogue.showAndWait();
    }
    
    public void valide_message(String titre, String header, String content){
        Alert dialogue = new Alert(AlertType.INFORMATION);
        dialogue.setTitle(titre);
        dialogue.setHeaderText(header);
        dialogue.setContentText(content);
        dialogue.showAndWait();
    }
}
