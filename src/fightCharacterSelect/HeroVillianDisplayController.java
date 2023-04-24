/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fightCharacterSelect;

import AddCharacter.SuperHV;
import AddCharacter.character;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import mainMenu.MainFXMLController;

//class controller for display of character arrays scene
public class HeroVillianDisplayController implements Initializable {
    Stage stage;
    private String buttonText = "";
    private ArrayList<character> characters = new ArrayList<character>();
    
    //data memebers for scene
    @FXML
    private ListView<String> characterList;

    @FXML
    private Label selectionDisplay;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    //get the button text and character array list from the main controller
    public void setCharacterAndButtonText(ArrayList<character> characters,String buttonText){
        //set characters and button text
        this.characters = characters;
        this.buttonText = buttonText;
        
        //set button text to match team displays
        if (buttonText.equals("SAVED VILLIANS")){
            buttonText = "Villains";
            //set the header text to match buttonText
            selectionDisplay.setText(buttonText);
        }
        else if(buttonText.equals("SAVED HEREOS")){
            buttonText = "Heroes"; 
            //set the header text to match buttonText
            selectionDisplay.setText(buttonText);
        }
       
        //loop until all characters are added to the choice display
        for(int i = 0; i < characters.size(); i++){
            //if character i's team matches slected to be displayed
            if (characters.get(i).getTeam().equals(buttonText) | buttonText.equals("SAVED FIGHTERS")){
                //if character is a super 
                if (characters.get(i) instanceof SuperHV){
                    //add character details of i to list view
                    characterList.getItems().add(String.format("%s, %s, STA: %d, STR: %d, SPD: %d, INT: %d, SKL: %d, Powers: %d", characters.get(i).getName(),characters.get(i).getTeam(),
                            characters.get(i).getStats().getStamina(), characters.get(i).getStats().getStrength(), characters.get(i).getStats().getSpeed(), 
                            characters.get(i).getStats().getIntelligence(), characters.get(i).getStats().getSkills(), ((SuperHV)characters.get(i)).getPowers().size()));

                }
                //else charatcer i has no powers
                else{
                    //add character details of i to  to list view
                    characterList.getItems().add(String.format("%s, %s, STA: %d, STR: %d, SPD: %d, INT: %d, SKL: %d, Powers: 0", characters.get(i).getName(),characters.get(i).getTeam(),
                            characters.get(i).getStats().getStamina(), characters.get(i).getStats().getStrength(), characters.get(i).getStats().getSpeed(), 
                            characters.get(i).getStats().getIntelligence(), characters.get(i).getStats().getSkills()));

                }
            }
        }

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
            //send character array list to main menu
            control.setCharacter(characters);
            mainMenu.setTitle("FIGHT!");
            mainMenu.setScene(new Scene (pane));
            mainMenu.setResizable(false);
            mainMenu.show();

        }catch(IOException ex){
            System.out.println(ex);
        }
    }
     @FXML
    //this method creates an action event for when the user clicks the home button they go back to main
    public void buttonAction(ActionEvent event){
        //collect the stage attached to the window and button
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        //close window stage
        stage.close();
        //open main window
        openMainWin(); 
        
    }
}
