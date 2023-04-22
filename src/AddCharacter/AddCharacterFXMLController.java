/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AddCharacter;

import CharacterDisplay.*;
import addPowers.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cathe
 */
public class AddCharacterFXMLController implements Initializable {
    Stage stage;
    // data members for scene items
    // array list to save all characters
    private static ArrayList<character> characters = new ArrayList<character>();
     @FXML
    private ChoiceBox<String> HeroVvillian;
     

    @FXML
    private TextField Intelligence;

    @FXML
    private TextField Skills;

    @FXML
    private TextField Speed;

    @FXML
    private TextField Strength;

    @FXML
    private TextField name;

    @FXML
    private CheckBox powerCheck;

    @FXML
    private TextField stamina;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        HeroVvillian.getItems().addAll("Heroes", "Villains");
        HeroVvillian.getSelectionModel().select(0);
    }    
    //method to collect array of characters
    public ArrayList<character> getCharacters(){
        return characters;
    }
   
  
    //method that is called to open character display window
     public void openCharacterDisplayWin(){
         try{
            //create character display window
            Stage displayChar = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/CharacterDisplay/CharDisplay.fxml"));
            Parent pane = (Parent) loader.load();//problem
            CharDisplayController control = loader.getController();
            control.setCharacter(characters, characters.size()-1);
            displayChar.setTitle("FIGHTER");
            displayChar.setScene(new Scene(pane));
            displayChar.setResizable(false);
            displayChar.show();
            
            
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
     
    //method that is called to open powers window display window
     public void openPowersWin(){
         try{
            //create add powers window
            Stage getPowers = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/addPowers/AddPowerFXML.fxml"));
            Parent pane = (Parent) loader.load();//problem
            AddPowerFXMLController control = loader.getController();
            control.setCharacter(characters, characters.size()-1, "empty");
            getPowers.setTitle("ADD POWERS");
            getPowers.setScene(new Scene(pane));
            getPowers.setResizable(false);
            getPowers.show();

        }catch(IOException ex){
            System.out.println(ex);
        }
    }
    //open error window
     public void openErrorWin(){
         try{
            //create add powers window
            Stage error= new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("errorMessage.fxml"));
            Scene scene = new Scene(root);
            error.setTitle("ERROR");
            error.setScene(scene);
            error.show();
            error.setResizable(false);
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
     //check is value is a number
     public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
     }
     
    @FXML
    //this method creates an action event for when the user clicks the start button: closing the window and opening main
    public void buttonAction(ActionEvent event){
        //if all textboxes have been filled
        if (!(name.getText().isEmpty() || stamina.getText().isEmpty() || Intelligence.getText().isEmpty() || Strength.getText().isEmpty() || Speed.getText().isEmpty() || 
                Skills.getText().isEmpty())){
            //if all stats are integers
            if (isNumeric(stamina.getText()) & isNumeric(Intelligence.getText()) & isNumeric(Strength.getText()) & isNumeric(Speed.getText()) & 
                isNumeric(Skills.getText())){
                //collect the stage attached to the window and button
                stage = (Stage)((Button)event.getSource()).getScene().getWindow();

                //if fighter has powers
                if (powerCheck.isSelected()){
                    //collect and save all data as a superhv character
                     characters.add(new SuperHV(name.getText(), HeroVvillian.getValue(),Integer.parseInt(Intelligence.getText()), Integer.parseInt(Strength.getText()), Integer.parseInt(stamina.getText()), Integer.parseInt(Speed.getText()), Integer.parseInt(Skills.getText())));
                    //call method to open add powers window
                    openPowersWin();
                }
                //else fighter does not have powers
                else{
                    //collect and save all data as a character
                    characters.add(new character(name.getText(), HeroVvillian.getValue(),Integer.parseInt(Intelligence.getText()), Integer.parseInt(Strength.getText()), Integer.parseInt(stamina.getText()), Integer.parseInt(Speed.getText()), Integer.parseInt(Skills.getText())));
                   //call method to open character display window
                    openCharacterDisplayWin();
                }
                //close window stage
                stage.close();
           }
           //else stats are not integers
            else{
                //display error window
                openErrorWin();
            }
        }
        //else a textbox is missing a feild
        else{
            //display error window
            openErrorWin();
        }

    }
    
}
