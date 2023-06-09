/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package CharacterDisplay;

//javafx imports
import AddCharacter.*;
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
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import mainMenu.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//class to display a single character
public class CharDisplayController implements Initializable {
    Stage stage; 
    private ArrayList<character> characters = new ArrayList<character>();
    private int charIndex;
    // data members for scene items
    @FXML
    private Label INT;

    @FXML
    private Label SKL;

    @FXML
    private Label SPD;

    @FXML
    private Label STA;

    @FXML
    private Label STR;

    @FXML
    private Line body;

    @FXML
    private Circle head;

    @FXML
    private Line leftArm;

    @FXML
    private Line leftLeg;

    @FXML
    private Label powerList;

    @FXML
    private Line rightArm;

    @FXML
    private Line rightLeg;
    
    @FXML
    private Line sword;

    @FXML
    private Label teamLabel;
    
    @FXML
    private Label name;
    
    @FXML
    private Rectangle bottomFrame;
    
    @FXML
    private Rectangle topFrame;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    
    //This method gets the character list and index from the add character controller to display the characters stats
    public void setCharacter(ArrayList<character> characters, int index){

        //collect character arrray values
        this.characters = characters;
        //collect character index
        this.charIndex = index; 
        //display charatcer stats
        name.setText(characters.get(charIndex).getName());
        STA.setText(Integer.toString(characters.get(charIndex).getStats().getStamina()));
        STR.setText(Integer.toString(characters.get(charIndex).getStats().getStrength()));
        SPD.setText(Integer.toString(characters.get(charIndex).getStats().getSpeed()));
        INT.setText(Integer.toString(characters.get(charIndex).getStats().getIntelligence()));
        SKL.setText(Integer.toString(characters.get(charIndex).getStats().getSkills()));
        teamLabel.setText(characters.get(charIndex).getTeam());
        
        //set character body display based on stats
        //body increase based on stamina
        body.setStrokeWidth(1 +((characters.get(charIndex).getStats().getStamina()))/2);
        //arm width increased based on strength
        leftArm.setStrokeWidth(1 +((characters.get(charIndex).getStats().getStrength()))/2);
        rightArm.setStrokeWidth(1 +((characters.get(charIndex).getStats().getStrength()))/2);
        //legs width increased based on speed
        leftLeg.setStrokeWidth(1 +((characters.get(charIndex).getStats().getSpeed()))/2);
        rightLeg.setStrokeWidth(1 +((characters.get(charIndex).getStats().getSpeed()))/2);
        //head size increase based on intelligence
        head.setRadius(20+((characters.get(charIndex).getStats().getIntelligence()))/2);
        //sword width increased based on skill
        sword.setStrokeWidth(1 +((characters.get(charIndex).getStats().getSkills()))/2);
        //set framing based of team selected
        //if hero team was selected
        if (characters.get(charIndex).getTeam().equals("Heroes")){
            topFrame.setFill(Color.LIGHTBLUE);
            bottomFrame.setFill(Color.LIGHTBLUE);
        }
        
        //if fighter is a super hero
        if (characters.get(charIndex) instanceof SuperHV){
            //collect and display charatcers powers
            powerList.setText(String.join(", ", (((SuperHV)characters.get(charIndex)).getPowers())));
        }
        //character is not super
        else{
            //display that the character does not have powers
            powerList.setText("Fighter does not have powers");
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
            //send character list to main menu
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
    //this method creates an action event for when the user clicks the start button: closing the window and opening main
    public void buttonAction(ActionEvent event){
        //collect the stage attached to the window and button
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        //close window stage
        stage.close();
        //open MainMenu
        openMainWin(); 
        
    }
    
}
