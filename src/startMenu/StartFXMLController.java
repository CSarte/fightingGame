/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package startMenu;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;


public class StartFXMLController {
    Stage stage;
    
    @FXML
    private Button start;

   
     //mehtod to open the add character window
    public void openAddCharWin(){
        //catch io exception
        try{
            //create add chracter window
            Stage addChar = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/AddCharacter/AddCharacterFXML.fxml"));
            Scene scene = new Scene(root);
            addChar.setTitle("AddFighter");
            addChar.setScene(scene);
            addChar.show();
            addChar.setResizable(false);
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
    @FXML
    //this method creates an action event for when the user clicks the start button: closing the window and opening another
    public void buttonAction(ActionEvent event){
        //collect the stage attached to the window and button
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        //close window stage
        stage.close();
        //open add character
        openAddCharWin(); 
        
    }


}


