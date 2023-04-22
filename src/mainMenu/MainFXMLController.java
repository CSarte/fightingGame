package mainMenu;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


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
import javafx.stage.Modality;
import FullCharacterDisplay.*;
import AddCharacter.*;
import CharacterDisplay.*;
import addPowers.AddPowerFXMLController;
import Stats.*;
import java.util.ArrayList;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author cathe
 */
public class MainFXMLController implements Initializable {
    Stage stage;
    String buttonText;
    private ArrayList<character> characters = new ArrayList<character>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    //get character list
    public void setCharacter(ArrayList<character> characters){
        this.characters = characters;
    }
    //method that is called from the "add fighter" or "search character button to open add fighter window
     public void openAddCharWin(){
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
     

     //method that is called from the "savedFighters","saved villians", "Fight", or "saved hereos" 
    //button to open full character display window
    public void openAllCharacterDisplayWin(){
         
        try{
            //create character display window 
            Stage displayAll = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FullCharacterDisplay/FullCharDisplay.fxml"));
            Parent pane = (Parent)loader.load();
           // AnchorPane pane2 = (AnchorPane) loader.load();
            FullCharDisplayController control = loader.getController();
            control.setCharacterAndButtonText(characters, buttonText);
            //loop to create each character display peices

          //  for(int i = 0; i < characters.size(); i++ ){
          //      System.out.print("hi");
           //     Label name = new Label(characters.get(i).getName());
           //     name.setPrefSize(33.5, 17);
           //     name.setLayoutX(7);
           //     name.setLayoutY(85);
           //     pane.getChildren().add(name);
           //     System.out.print("hi");
           // }
            displayAll.setTitle("FIGHTERS!");
            displayAll.setScene(new Scene(pane));
            displayAll.setResizable(false);
            displayAll.initModality(Modality.APPLICATION_MODAL);
            displayAll.show();
        }catch(IOException ex){
            System.out.println(ex);
        }            
    }

     
     //method that is called from the "add power" button to open add power window
     public void openAddPowerWin(){
         try{
            //create add powers window
            Stage getPowers = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/addPowers/AddPowerFXML.fxml"));
            Parent pane = (Parent) loader.load();
            AddPowerFXMLController control = loader.getController();
            control.setCharacter(characters, -1, "find");
            getPowers.setTitle("ADD POWERS");
            getPowers.setScene(new Scene(pane));
            getPowers.setResizable(false);
            getPowers.show();
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
    
     //method that is called from the "add power" button to open add power window
     public void openFighterStatsWin(){
         try{
            //create stats window
            Stage displayStats = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Stats/StatsFXML.fxml"));
            Parent pane = (Parent) loader.load();
            StatsFXMLController control = loader.getController();
            control.setCharacterStats(characters);
            displayStats.setTitle("FIGHTER STATS");
            displayStats.setScene(new Scene(pane));
            displayStats.setResizable(false);
            displayStats.show();
 
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
     //method that is called from the "search character" button to search character window
     public void openSearchCharacterWin(){
         try{
            //create character display window
            Stage displayChar = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/CharacterDisplay/searchName.fxml"));
            Parent pane = (Parent) loader.load();
            SearchNameController control = loader.getController();
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
       
        
        switch(buttonText){
            case"ADD FIGHTER":
               openAddCharWin(); 
               break;
            case"SAVED FIGHTERS":
            case"SAVED VILLIANS":
            case"SAVED HEREOS":
            case"FIGHT":
                openAllCharacterDisplayWin();
                break;
            case"ADD POWER":
                openAddPowerWin();
                break;
            case"FIGHTER STATS":
                openFighterStatsWin();
                break;
            case"SEARCH FIGHTER":
                openSearchCharacterWin();
                break;
                
        }
        //close main
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }
    
}
