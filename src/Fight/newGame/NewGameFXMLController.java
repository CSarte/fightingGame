/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Fight.newGame;

//javafx import
import AddCharacter.character;
import fightCharacterSelect.FullCharDisplayController;
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
import javafx.stage.Stage;
import mainMenu.MainFXMLController;

//class controller for new game scene
public class NewGameFXMLController implements Initializable {
    Stage stage;
    private ArrayList<character> characters = new ArrayList<character>();
    
    //data memebers for the scene
    @FXML
    private Button NewGameButton;

    @FXML
    private Button NewGameMainMenuButton;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 
    //this method collects the character array to send to main menu or fight scene
    public void setCharacter(ArrayList<character> characters){
        this.characters = characters;
    }
    
     //method that is called from the "Fight" button 
    public void openAllCharacterSelectionWin(){
        //catch io exception
        try{
            //create character display window 
            Stage displayAll = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fightCharacterSelect/FullCharDisplay.fxml"));
            Parent pane = (Parent) loader.load();
            FullCharDisplayController control = loader.getController();
            //send array list to selection window
            control.setCharacter(characters);
            displayAll.setTitle("FIGHTERS!");
            displayAll.setScene(new Scene(pane));
            displayAll.setResizable(false);
            displayAll.show();
            
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
            //send character array to main menu
            control.setCharacter(characters);
            mainMenu.setTitle("FIGHT!");
            mainMenu.setScene(new Scene (pane));
            mainMenu.setResizable(false);
            mainMenu.show();

        }catch(IOException ex){
            System.out.println(ex);
        }
    }
    //Action event to either open the main menu or the fight menu selection again
    public void buttonAction(ActionEvent event){
        //collect the stage attached to the window and button
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        //close window stage
        stage.close();
        //get which button was pressed
        Button button  = (Button) event.getSource();
        
        //if main menu button was clicked
        if (button.getText().equals("Main Menu")) {
            //method to open main window
            openMainWin(); 
        }
        //else new game menu was clicked
        else{
            //method to open fight character selection
            openAllCharacterSelectionWin();
        }
    }
    
}
