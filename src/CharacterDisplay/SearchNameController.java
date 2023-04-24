/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package CharacterDisplay;
//imports for javafx
import AddCharacter.*;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import mainMenu.*;

//controller for the search character display
public class SearchNameController implements Initializable {
    private ArrayList<character> characters = new ArrayList<character>();
    private int charIndex;
    
    //data memebers from scene builder
    @FXML
    private TextField fighterName;
    
    @FXML
    private Label message;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    //this method collects the character list from main
    public void setCharacter(ArrayList<character> characters){
        //set character list
        this.characters = characters;
    }
    //this method opens the character display window using index found 
     public void openCharacterDisplayWin(int chrIndex){
        //catch IO exception
         try{
            //create character display window
            Stage displayChar = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/CharacterDisplay/CharDisplay.fxml"));
            Parent pane = (Parent) loader.load();
            CharDisplayController control = loader.getController();
            //send character list and the chosen charaters index
            control.setCharacter(characters, chrIndex);
            displayChar.setTitle("FIGHTER");
            displayChar.setScene(new Scene(pane));
            displayChar.setResizable(false);
            displayChar.show();
            
        }catch(IOException ex){
            System.out.println(ex);
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
    
    //open error window: called when user has not inputed information into the window properly
     public void openErrorWin(String message){
         //catch io exception
         try{
            //create error window
            Stage error= new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AddCharacter/errorMessage.fxml"));
            Parent pane = (Parent) loader.load();
            ErrorMessageController control = loader.getController();
            error.setTitle("ERROR");
            control.setMessage(message);
            error.setScene(new Scene(pane));
            error.setResizable(false);
            error.show();
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
    
    //this method collects the entered text and searches for the fighter from the character list
    public void buttonAction(ActionEvent event){
        //get and save button text
        Button button = (Button) event.getSource();
        String buttonText = button.getText();
        
        //if search button was pressed
        if (buttonText.equals("SEARCH")){
            //if user entered text
            if (!fighterName.getText().isEmpty()){
                //get name entered in search
                String chrName = fighterName.getText();
                int chrIndex = -1;
                //loop over character list
                for(int i = 0; i < characters.size(); i++){
                    //if name was found
                    if (characters.get(i).getName().equals(chrName)){
                        //open character display window with found index
                        chrIndex = i;
                        openCharacterDisplayWin(chrIndex);
                        //exit loop
                        break;
                    }
                }
                //if index was not found
                if (chrIndex == -1){
                    //show error message
                    openErrorWin("Name was not found in the fighter database");
                }
            }
            //else user did not enter a name
            else{
                //show error message
                openErrorWin("Please enter a name");
            }
        }
        //else user clicked the home button
        else{
            //call main menu window method to open window
            openMainWin();
        }
    }
}
