/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Stats;

import AddCharacter.character;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import AddCharacter.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import mainMenu.MainFXMLController;

/**
 * FXML Controller class
 *
 * @author cathe
 */
public class StatsFXMLController implements Initializable {
    private ArrayList<character> characters = new ArrayList<character>();
    
    @FXML
    private Label AVHeroInt;

    @FXML
    private Label AVHeroSkl;

    @FXML
    private Label AVHeroSpd;

    @FXML
    private Label AVHeroSta;

    @FXML
    private Label AVHeroStr;

    @FXML
    private Label AVVillainInt;

    @FXML
    private Label AVVillainSpd;

    @FXML
    private Label AVVillainSta;

    @FXML
    private Label AVVillainStr;

    @FXML
    private Label AVVillainsSkl;

    @FXML
    private Label TotalHeroPowers;

    @FXML
    private Label TotalNPCHeroes;

    @FXML
    private Label TotalNPCVillain;

    @FXML
    private Label TotalHeroVillains;

    @FXML
    private Label TotalSuperHeroes;

    @FXML
    private Label TotalVillainPowers;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    //get charatcer list from main menu and generate fighter statistics
    public void setCharacterStats(ArrayList<character> characters){
        int numHeroNormal = 0;
        int numHeroSuper = 0;
        int numVillianNormal = 0;
        int numVillianSuper = 0;
        //collect characters array
        this.characters = characters;
        //loop to get number of normal characters and number of super charatcer
        for(int i = 0; i < characters.size(); i++){
            //if character is a hero 
            if (characters.get(i).getTeam().equals("Heroes")){
               //if charcter is a supper fighter
                if (characters.get(i) instanceof SuperHV){
                    //add to super fighter number
                    numHeroSuper += 1;
                }
                //else character at i is normal
                else{
                    //add to normal fighter number
                    numHeroNormal += 1;
                } 
            }
            //else character is a villian 
            else{
               //if charcter is a supper fighter
                if (characters.get(i) instanceof SuperHV){
                    //add to super fighter number
                    numVillianSuper += 1;
                }
                //else character at i is normal
                else{
                    //add to normal fighter number
                    numVillianNormal += 1;
                    
                } 
            }
            
        }
        //set numNormal and numSuper labels
        TotalSuperHeroes.setText(Integer.toString(numHeroSuper));
        TotalHeroVillains.setText(Integer.toString(numVillianSuper));
        TotalNPCVillain.setText(Integer.toString(numVillianNormal));
        TotalNPCHeroes.setText(Integer.toString(numHeroNormal));
        
        //set statistics averages
        //if num heroes is greater than zero
        if ((numHeroSuper +numHeroNormal)>0){
            AVHeroInt.setText(Double.toString(characters.get(0).getStats().getAvgInt("Heroes", (numHeroSuper +numHeroNormal))));
            AVHeroStr.setText(Double.toString(characters.get(0).getStats().getAvgStr("Heroes", (numHeroSuper +numHeroNormal))));
            AVHeroSta.setText(Double.toString(characters.get(0).getStats().getAvgSta("Heroes", (numHeroSuper +numHeroNormal))));
            AVHeroSpd.setText(Double.toString(characters.get(0).getStats().getAvgSpd("Heroes", (numHeroSuper +numHeroNormal))));
            AVHeroSkl.setText(Double.toString(characters.get(0).getStats().getAvgSkl("Heroes", (numHeroSuper +numHeroNormal))));
        }
        //if num villians if greater than 0
        if ((numVillianSuper +numVillianNormal)>0){
            AVVillainInt.setText(Double.toString(characters.get(0).getStats().getAvgInt("Villains", (numVillianSuper +numVillianNormal))));
            AVVillainStr.setText(Double.toString(characters.get(0).getStats().getAvgStr("Villains", (numVillianSuper +numVillianNormal))));
            AVVillainSta.setText(Double.toString(characters.get(0).getStats().getAvgSta("Villains", (numVillianSuper +numVillianNormal))));
            AVVillainSpd.setText(Double.toString(characters.get(0).getStats().getAvgSpd("Villains", (numVillianSuper +numVillianNormal))));
            AVVillainsSkl.setText(Double.toString(characters.get(0).getStats().getAvgSkl("Villains", (numVillianSuper +numVillianNormal))));
        }
        
        //display the aggregate powers of fighters
        TotalHeroPowers.setText(String.join(", ",((SuperHV)characters.get(0)).getPowerList("Heroes")));
        TotalVillainPowers.setText(String.join(", ",((SuperHV)characters.get(0)).getPowerList("Villains")));
        
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
    public void buttonAction(ActionEvent event){
        //open main window
        openMainWin();
    }
}
