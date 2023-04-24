package mainMenu;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

//java fx imports
import fightCharacterSelect.HeroVillianDisplayController;
import fightCharacterSelect.FullCharDisplayController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import AddCharacter.*;
import CharacterDisplay.*;
import addPowers.AddPowerFXMLController;
import Stats.*;
import java.util.ArrayList;


//main controller class for main menu scene
public class MainFXMLController implements Initializable {
    Stage stage;
    String buttonText;
    private ArrayList<character> characters = new ArrayList<character>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    //get character list from call
    public void setCharacter(ArrayList<character> characters){
        //update character list
        this.characters = characters;
    }
    //method that is called from the "add fighter" or "search character button to open add fighter window
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
     

    //method that is called from the "Fight" button 
    public void openAllCharacterSelectionWin(){
        //catch io exception
        try{
            //create character display window 
            Stage displayAll = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fightCharacterSelect/FullCharDisplay.fxml"));
            Parent pane = (Parent) loader.load();
            FullCharDisplayController control = loader.getController();
            //send character list to for fight selection
            control.setCharacter(characters);
            displayAll.setTitle("FIGHTERS!");
            displayAll.setScene(new Scene(pane));
            displayAll.setResizable(false);
            displayAll.show();
            
        }catch(IOException ex){
            System.out.println(ex);
        }            
    }

     
     //method that is called from the "add power" button to open add power window
     public void openAddPowerWin(){
         //catch io exception
         try{
            //create add powers window
            Stage getPowers = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/addPowers/AddPowerFXML.fxml"));
            Parent pane = (Parent) loader.load();
            AddPowerFXMLController control = loader.getController();
            //send character list, index to show that character index needs to be found, and string to show that character needs to be found
            control.setCharacter(characters, -1, "find");
            getPowers.setTitle("ADD POWERS");
            getPowers.setScene(new Scene(pane));
            getPowers.setResizable(false);
            getPowers.show();
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
    
     //method that is called from the "stats" button to open fighter stats window
     public void openFighterStatsWin(){
         //catch io exception
         try{
            //create stats window
            Stage displayStats = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Stats/StatsFXML.fxml"));
            Parent pane = (Parent) loader.load();
            StatsFXMLController control = loader.getController();
            //send character array list to stats controller
            control.setCharacterStats(characters);
            displayStats.setTitle("FIGHTER STATS");
            displayStats.setScene(new Scene(pane));
            displayStats.setResizable(false);
            displayStats.show();
 
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
     //this method is called by saved fighter, heroes, or villians button to open display window
     public void openCollectionCharacterDisplay(){
         try{
            //create stats window
            Stage displayStats = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fightCharacterSelect/HeroVillianDisplay.fxml"));
            Parent pane = (Parent) loader.load();
            HeroVillianDisplayController control = loader.getController();
            //send character lsit and button text
            control.setCharacterAndButtonText(characters, buttonText);
            displayStats.setTitle("FIGHTERS");
            displayStats.setScene(new Scene(pane));
            displayStats.setResizable(false);
            displayStats.show();
 
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
     //method that is called from the "search character" button to search character window
     public void openSearchCharacterWin(){
         //catch io exception
         try{
            //create character display window
            Stage displayChar = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/CharacterDisplay/searchName.fxml"));
            Parent pane = (Parent) loader.load();
            SearchNameController control = loader.getController();
            //send character array lsit
            control.setCharacter(characters);
            displayChar.setScene(new Scene(pane));
            displayChar.setResizable(false);
            displayChar.show();

        }catch(IOException ex){
            System.out.println(ex);
        }
    }
     
     
    @FXML
    //this method creates an action event for when the user clicks the one of the buttons
    //then determines which button was pressed and what event should take place
    public void buttonAction(ActionEvent event){
        Button button = (Button) event.getSource();
        buttonText = button.getText();
       
        //case based on button text
        switch(buttonText){
            case"ADD FIGHTER":
                //call method to add character window
               openAddCharWin(); 
               break;
            case"SAVED FIGHTERS":
            case"SAVED VILLIANS":
            case"SAVED HEREOS":
                //call method to diaply lsit of characters window
                openCollectionCharacterDisplay();
                break;
            case"FIGHT":
                //method to get player slection for fight window
                openAllCharacterSelectionWin();
                break;
            case"ADD POWER":
                //method to call add powers window
                openAddPowerWin();
                break;
            case"FIGHTER STATS":
                //method to call fighter stats window
                openFighterStatsWin();
                break;
            case"SEARCH FIGHTER":
                //method to call window to search for a character
                openSearchCharacterWin();
                break;
                
        }
        //close main
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }
    
}
