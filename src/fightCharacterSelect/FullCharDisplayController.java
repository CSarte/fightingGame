/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fightCharacterSelect;

//import javafx 
import AddCharacter.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainMenu.MainFXMLController;
import Fight.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

//class controller for fighter player selection scene
public class FullCharDisplayController implements Initializable {
    private Stage stage;
    private ArrayList<character> characters = new ArrayList<character>();
    
     @FXML
    private Button ReadyButton;

    @FXML
    private Rectangle headShape;

    @FXML
    private Label middleTItle;

    @FXML
    private ChoiceBox<String> player1;

    @FXML
    private ChoiceBox<String> player2;
    
 
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        
    }  
    //get the button text and character array list from the main controller
    public void setCharacter(ArrayList<character> characters){
        this.characters = characters;

        //loop until all characters are added to the choice display
        for(int i = 0; i < characters.size(); i++){
            //if character is a super 
            if (characters.get(i) instanceof SuperHV){
                //add character details of i to both player1 and player2 lists
                player1.getItems().add(String.format("%s, %s, STA: %d, STR: %d, SPD: %d, INT: %d, SKL: %d, Powers: %d", characters.get(i).getName(),characters.get(i).getTeam(),
                        characters.get(i).getStats().getStamina(), characters.get(i).getStats().getStrength(), characters.get(i).getStats().getSpeed(), 
                        characters.get(i).getStats().getIntelligence(), characters.get(i).getStats().getSkills(), ((SuperHV)characters.get(i)).getPowers().size()));
                player2.getItems().add(String.format("%s, %s, STA: %d, STR: %d, SPD: %d, INT: %d, SKL: %d, Powers: %d", characters.get(i).getName(),characters.get(i).getTeam(),
                        characters.get(i).getStats().getStamina(), characters.get(i).getStats().getStrength(), characters.get(i).getStats().getSpeed(), 
                        characters.get(i).getStats().getIntelligence(), characters.get(i).getStats().getSkills(), ((SuperHV)characters.get(i)).getPowers().size()));
            }
            //else charatcer i has no powers
            else{
                //add character details of i to both player1 and player2 lists
                player1.getItems().add(String.format("%s, %s, STA: %d, STR: %d, SPD: %d, INT: %d, SKL: %d, Powers: 0", characters.get(i).getName(),characters.get(i).getTeam(),
                        characters.get(i).getStats().getStamina(), characters.get(i).getStats().getStrength(), characters.get(i).getStats().getSpeed(), 
                        characters.get(i).getStats().getIntelligence(), characters.get(i).getStats().getSkills()));
                player2.getItems().add(String.format("%s, %s, STA: %d, STR: %d, SPD: %d, INT: %d, SKL: %d, Powers: 0", characters.get(i).getName(),characters.get(i).getTeam(),
                        characters.get(i).getStats().getStamina(), characters.get(i).getStats().getStrength(), characters.get(i).getStats().getSpeed(), 
                        characters.get(i).getStats().getIntelligence(), characters.get(i).getStats().getSkills()));
            }
        }
        //set a prechosen player 1 and 2
        player1.getSelectionModel().select(0);
        player2.getSelectionModel().select(0);
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
            //make string array to get name chosen
            String[] player1Name = player1.getValue().split(",");
            String[] player2Name = player2.getValue().split(",");
            //send the slected player1 and 2 names with character list to the fight scene
            control.setCharactersAndFighters(player1Name[0], player2Name[0], characters);  
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
        //close current stage
        stage.close();    
        //open window for fight scene
        openFightWin(); 
       
        
    }
    
}
