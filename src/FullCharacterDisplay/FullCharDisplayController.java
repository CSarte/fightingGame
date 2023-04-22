/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FullCharacterDisplay;

import AddCharacter.character;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.Group;
import mainMenu.MainFXMLController;
import Fight.*;

/**
 * FXML Controller class
 *
 * @author cathe
 */
public class FullCharDisplayController implements Initializable {
    private Stage stage;
    private String buttonText = "";
    private ArrayList<character> characters = new ArrayList<character>();
 
   // headShape
    
  
    
 
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }  
    //get the button text and character array list from the main controller
    public void setCharacterAndButtonText(ArrayList<character> characters, String buttonText){
        this.characters = characters;
        this.buttonText = buttonText;
    }
    
    //method to open the main menu
    public void openMainWin(){
        //catch io exception
        try{
            //create main menu
            Stage mainMenu = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainMenu/MainFXML.fxml"));
            Parent pane = (Parent) loader.load();
            MainFXMLController control = loader.getController();
            control.setCharacter(characters);
            mainMenu.setTitle("FIGHT!");
            mainMenu.setScene(new Scene (pane));
            mainMenu.setResizable(false);
            mainMenu.show();

        }catch(IOException ex){
            System.out.println(ex);
        }
    }
     //mehtod to open the new character display
    public void openFightWin(){
        //catch io exception
        try{
            //create fight display window
            Stage fight = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fight/FightFXML.fxml"));
            Parent pane = (Parent) loader.load();
            FightFXMLController control = loader.getController();
            control.setCharactersAndFighters("john", "jay", characters);          
            fight.setTitle("FIGHT!");
            fight.setScene(new Scene (pane));
            fight.show();
            fight.setResizable(false);
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
    @FXML
    //this method creates an action event for when the user clicks the start button: closing the window and opening main
    public void buttonAction(ActionEvent event){
        //collect the stage attached to the window and button
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();
        //if button selected was not fight 
        if (!buttonText.equals("FIGHT")){
            //call main menu window open method
            openMainWin(); 
        }
        //else button is fight so open fight menu
        else{
           //call open fight window method
           openFightWin(); 
        }
        
    }
    
}
