/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AddCharacter;

//javafx imports
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

//controller class for error message scene
public class ErrorMessageController implements Initializable {
    
    //data memebers for scene
    @FXML
    private Label erroMessgae;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    //method to set error message from string set from call
    public void setMessage(String message){
        //set error text
        erroMessgae.setText(message);
    }
    
}
