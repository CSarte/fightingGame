/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Fight;

import AddCharacter.character;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mainMenu.MainFXMLController;
import AddCharacter.*;
 
/**
 * FXML Controller class
 *
 * @author cathe
 */
public class FightFXMLController implements Initializable {
    private ArrayList<character> characters = new ArrayList<character>();
    String player1;
    String player2;
    @FXML
    private Button FightButton;

    @FXML
    private SplitPane FightDivider;

    @FXML
    private Label Fighter1;

    @FXML
    private Label Fighter2;

    @FXML
    private Circle Player1Head;

    @FXML
    private Label Player1Int;

    @FXML
    private Line Player1LeftArm;

    @FXML
    private Line Player1LeftLeg;

    @FXML
    private Label Player1Powers;

    @FXML
    private Line Player1RightArm;

    @FXML
    private Line Player1RightLeg;

    @FXML
    private Label Player1Skl;

    @FXML
    private Label Player1Spd;

    @FXML
    private Label Player1Sta;

    @FXML
    private Label Player1Str;

    @FXML
    private Line Player1SwordBlade;

    @FXML
    private Circle Player1SwordHilt;

    @FXML
    private Label Player1TCP;

    @FXML
    private Text Player1TCPHeader;

    @FXML
    private Line Player1Torso;

    @FXML
    private Circle Player2Head;

    @FXML
    private Label Player2Int;

    @FXML
    private Line Player2LeftArm;

    @FXML
    private Line Player2LeftLeg;

    @FXML
    private Label Player2Powers;

    @FXML
    private Line Player2RightArm;

    @FXML
    private Line Player2RightLeg;

    @FXML
    private Label Player2Skl;

    @FXML
    private Label Player2Spd;

    @FXML
    private Label Player2Sta;

    @FXML
    private Label Player2Str;

    @FXML
    private Line Player2SwordBlade;

    @FXML
    private Circle Player2SwordHilt;

    @FXML
    private Label Player2TCP;

    @FXML
    private Text Player2TCPHeader;

    @FXML
    private Line Player2Torso;

    @FXML
    private Text WinnerText;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setCharactersAndFighters(String player1, String player2, ArrayList<character> characters){
        this.player1 = player1;
        this.player2 = player2;
        this.characters = characters;
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
   
    
}
