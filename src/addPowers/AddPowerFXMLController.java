/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package addPowers;

import AddCharacter.*;
import AddCharacter.character;
import CharacterDisplay.CharDisplayController;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;


/**
 * FXML Controller class
 *
 * @author cathe
 */
public class AddPowerFXMLController implements Initializable {
    Stage stage;
    private ArrayList<character> characters = new ArrayList<character>();
    private int charIndex = -1;
    private String nameFind = "empty";
    
    @FXML
    private Label errorMessage;
            
    @FXML
    private TextField name;

    @FXML
    private TextField powers;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void setCharacter(ArrayList<character> characters, int index, String nameFind){
        //collect character arrray values
        this.characters = characters;
        //if index is not -1 then the user is adding a new powers to a character
        if( index != -1){
            //collect character index
            this.charIndex = index; 
            name.setText(characters.get(charIndex).getName());
        }
        //else the user is searching by name
        else{
            this.nameFind = nameFind;
        }
        
    }

    //method that is called to open character display window
     public void openCharacterDisplayWin(){
          try{
            //create character display window
            Stage displayChar = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/CharacterDisplay/CharDisplay.fxml"));
            Parent pane = (Parent) loader.load();//problem
            CharDisplayController control = loader.getController();
            control.setCharacter(characters, charIndex);
            displayChar.setTitle("FIGHTER");
            displayChar.setScene(new Scene(pane));
            displayChar.setResizable(false);
            displayChar.show();
            
            
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
    @FXML
    //this method creates an action event for when the user clicks the start button: closing the window and opening main
    public void buttonAction(ActionEvent event){
  
        String[] array = powers.getText().split(",");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
        //if user entered a name to add a power to search for it in character list
        if (!nameFind.equals("empty")){
            nameFind = name.getText();
            //loop until index of character that has entered name is found
            for(int i = 0; i < characters.size(); i++ ){
                //if character at index i name is equal to user name entry
                if ( (characters.get(i) instanceof SuperHV)& characters.get(i).getName().equals(nameFind)){
                    //set index for character
                    charIndex = i;
                    //exit loop
                    break;
                }
            }
            //if user name was not found in character list 
            if( charIndex == -1){
                errorMessage.setText("ERROR: Name was not found in system. Enter a superhero fighter name.");
            }
        }
       //if a valid character index was saved
       if( charIndex != -1){ 
            //collect the powers text to add to superhero charatcer
            ((SuperHV)(characters.get(charIndex))).addPower(list);
            //collect the stage attached to the window and button
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            stage.close();
            //display fighter that powers were added to
            openCharacterDisplayWin();
       }
        
    }
    
    
    
}
