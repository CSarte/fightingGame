/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Fight;

//java fx imports
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
import javafx.stage.Stage;
import Fight.newGame.*;
import AddCharacter.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

//class for the fight scene
public class FightFXMLController implements Initializable {
    Stage stage;
    private ArrayList<character> characters = new ArrayList<character>();
    private String player1;
    private String player2;
    private int player1Index = -1;
    private int player2Index = -1;
    
    //data memebers from the scene
    @FXML
    private Text vsHeader;
    
    @FXML
    private Button ContinueButton;

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
    private Label Player2TCP;

    @FXML
    private Text Player2TCPHeader;

    @FXML
    private Line Player2Torso;

    @FXML
    private Text WinnerText;

    @FXML
    private Text p1Team;

    @FXML
    private Text p2Team;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    //method that collects the player1 and plaer2 choice as well as character list from call, searches for the index of each
    //players name to set stats for the fight scene
    public void setCharactersAndFighters(String player1, String player2, ArrayList<character> characters) {
        this.player1 = player1;
        this.player2 = player2;
        this.characters = characters;
        WinnerText.setVisible(false);
        Player1TCP.setVisible(false);
        Player2TCP.setVisible(false);
        ContinueButton.setVisible(false);

        //loop until player1 and 2 indexes are found
        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(i).getName().equals(player1)) {
                player1Index = i;
            }
            if (characters.get(i).getName().equals(player2)) {
                player2Index = i;
            }
            if (player2Index != -1 & player1Index != -1) {
                break;
            }

        }

        //set the character display stats
        Fighter1.setText(player1);
        Fighter2.setText(player2);
        p1Team.setText(characters.get(player1Index).getTeam());
        p2Team.setText(characters.get(player2Index).getTeam());
        Player1Sta.setText(Integer.toString(characters.get(player1Index).getStats().getStamina()));
        Player2Sta.setText(Integer.toString(characters.get(player2Index).getStats().getStamina()));
        Player1Str.setText(Integer.toString(characters.get(player1Index).getStats().getStrength()));
        Player2Str.setText(Integer.toString(characters.get(player2Index).getStats().getStrength()));
        Player1Skl.setText(Integer.toString(characters.get(player1Index).getStats().getSkills()));
        Player2Skl.setText(Integer.toString(characters.get(player2Index).getStats().getSkills()));
        Player1Int.setText(Integer.toString(characters.get(player1Index).getStats().getIntelligence()));
        Player2Int.setText(Integer.toString(characters.get(player2Index).getStats().getIntelligence()));
        Player1Spd.setText(Integer.toString(characters.get(player1Index).getStats().getSpeed()));
        Player2Spd.setText(Integer.toString(characters.get(player2Index).getStats().getSpeed()));
        
        //set player 2 body display based on stats
        //body increase based on stamina
        Player1Torso.setStrokeWidth(1 +((characters.get(player1Index).getStats().getStamina()))/2);
        //arm width increased based on strength
        Player1RightArm.setStrokeWidth(1 +((characters.get(player1Index).getStats().getStrength()))/2);
        Player1LeftArm.setStrokeWidth(1 +((characters.get(player1Index).getStats().getStrength()))/2);
        //legs width increased based on speed
        Player1RightLeg.setStrokeWidth(1 +((characters.get(player1Index).getStats().getSpeed()))/2);
        Player1LeftLeg.setStrokeWidth(1 +((characters.get(player1Index).getStats().getSpeed()))/2);
        //head size increase based on intelligence
        Player1Head.setRadius(20+((characters.get(player1Index).getStats().getIntelligence()))/2);
        //sword width increased based on skill
        Player1SwordBlade.setStrokeWidth(1 +((characters.get(player2Index).getStats().getSkills()))/2);
        
        //set character [;ayer 2body display based on stats
        //body increase based on stamina
        Player2Torso.setStrokeWidth(1 +((characters.get(player2Index).getStats().getStamina()))/2);
        //arm width increased based on strength
        Player2RightArm.setStrokeWidth(1 +((characters.get(player2Index).getStats().getStrength()))/2);
        Player2LeftArm.setStrokeWidth(1 +((characters.get(player2Index).getStats().getStrength()))/2);
        //legs width increased based on speed
        Player2RightLeg.setStrokeWidth(1 +((characters.get(player2Index).getStats().getSpeed()))/2);
        Player2LeftLeg.setStrokeWidth(1 +((characters.get(player2Index).getStats().getSpeed()))/2);
        //head size increase based on intelligence
        Player2Head.setRadius(20+((characters.get(player2Index).getStats().getIntelligence()))/2);
        //sword width increased based on skill
        Player2SwordBlade.setStrokeWidth(1 +((characters.get(player2Index).getStats().getSkills()))/2);
        
        //if player1 has powers
        if (characters.get(player1Index) instanceof SuperHV) {
            //set the list of super powers for player 1
            Player1Powers.setText(String.join(", ", (((SuperHV) characters.get(player1Index)).getPowers())));
            //get the stat sum for player1
            Player1TCP.setText(Integer.toString((characters.get(player1Index).getStats().getStatSum()) + ((((SuperHV) characters.get(player1Index)).getPowers().size()) * 10)));
        } 
        //else player1 does not have powers
        else {
            //display that the player has no powers
            Player1Powers.setText("none");
            //get player 1 stats sum
            Player1TCP.setText(Integer.toString(characters.get(player1Index).getStats().getStatSum()));
        }
        //if player 2 has super powers
        if (characters.get(player2Index) instanceof SuperHV) {
            //set the list of super pwoers for player 2
            Player2Powers.setText(String.join (", ", (((SuperHV) characters.get(player2Index)).getPowers())));
            //get player 2 stats sum
            Player2TCP.setText(Integer.toString((characters.get(player2Index).getStats().getStatSum()) + ((((SuperHV) characters.get(player2Index)).getPowers().size()) * 10)));
        } 
        //else player 2 does not have powers
        else {
            //display that the uplayer has no power
            Player2Powers.setText("none");
            //get player 2 stats sum
            Player2TCP.setText(Integer.toString(characters.get(player2Index).getStats().getStatSum()));
        }

    }
    
     //method to open the main menu
    public void openNewGameWin(){
        //catch io exception
        try{
            //create main menu
            Stage mainMenu = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fight/newGame/newGameFXML.fxml"));
            Parent pane = (Parent) loader.load();
            NewGameFXMLController control = loader.getController();
            //send character list to main
            control.setCharacter(characters);
            mainMenu.setTitle("New Game?");
            mainMenu.setScene(new Scene (pane));
            mainMenu.setResizable(false);
            mainMenu.show();

        }catch(IOException ex){
            System.out.println(ex);
        }
    }

    @FXML
    //this action event method occurs when the user click fight or continue. If they choose fight display fight winner, else cotinue to new game display
    public void buttonAction(ActionEvent event) {
        //get the button that was clicked
        Button button  = (Button) event.getSource();
        
        //if button pressed was FIGHT
        if (button.getText().equals("FIGHT")) {
            //change label visibiltiy for winner display
            Fighter1.setVisible(false);
            Fighter2.setVisible(false);
            p1Team.setVisible(false);
            p2Team.setVisible(false);
            FightButton.setVisible(false);
            ContinueButton.setVisible(true);
            vsHeader.setVisible(false);
            
            //if player1 fight power is greater than player two
            if (Integer.parseInt(Player1TCP.getText()) > Integer.parseInt(Player2TCP.getText())) {
                //display that player 1 won
                WinnerText.setText(String.format("%s WINS", characters.get(player1Index).getName()));
                //Shift scene elements to display winner
                WinnerText.setVisible(true);
                Player1TCP.setVisible(true);
                Player2TCP.setVisible(true);
                FightDivider.setDividerPositions(1);
                Player1Head.setLayoutX(379);
                Player1Torso.setLayoutX(356);
                Player1LeftArm.setLayoutX(480);
                Player1RightArm.setLayoutX(319);
                Player1LeftLeg.setLayoutX(414);
                Player1RightLeg.setLayoutX(322);
                Player1SwordBlade.setLayoutX(263);        

            } //else if player2 fight power is greater than player 1
            else if (Integer.parseInt(Player1TCP.getText()) < Integer.parseInt(Player2TCP.getText())) {
                //display that player 2 won
                WinnerText.setText(String.format("%s WINS", characters.get(player2Index).getName()));
                //Shift scene elements to display winner
                WinnerText.setVisible(true);
                Player1TCP.setVisible(true);
                Player2TCP.setVisible(true);
                FightDivider.setDividerPositions(0);
                Player2Head.setLayoutX(379);
                Player2Torso.setLayoutX(356);
                Player2LeftArm.setLayoutX(480);
                Player2RightArm.setLayoutX(319);
                Player2LeftLeg.setLayoutX(414);
                Player2RightLeg.setLayoutX(322);
                Player2SwordBlade.setLayoutX(263);             
            } //else the two fight powers are equals
            else {
                //display that the fight was a tie
                WinnerText.setText("IT'S A TIE!");
                WinnerText.setVisible(true);
                Player1TCP.setVisible(true);
                Player2TCP.setVisible(true);
            }
        }
        //else if button pressed was Continue
        else if(button.getText().equals("Continue")){
            //collect the stage attached to the window and button
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            //close window stage
            stage.close();
            //open fight new game menu
            openNewGameWin();
            
        }
    }

   
}
