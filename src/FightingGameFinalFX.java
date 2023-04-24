/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
/**Title: FSC Grade Book
 * Date: 2/24/2023
 * Author: Catherine Sarte, Jake Shumate
 * Email: csarte250@gmail.com, jake.shumate33823@gmail.com
 * Honor Code:“I will practice academic and personal integrity and excellence of character  
 *  and expect the same from others.”
 * 
 * Project Description: This program creates a game to create and and compare fighters. The program generates a user interface
 *  that allows the user to add characters with special abilities and stats. The user can view the saved characters by a team of Villain
 *  ,hero, or all the saved characters at once. The user can also choose two of their saved characters for the program to compare stats and 
 *  determine who would win in a fight.
 */

//import for javafx main
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FightingGameFinalFX extends Application {

    @Override
    //method to make and display starting scene stage
    public void start(Stage primaryStage) throws Exception{
        //load opening menu
        Parent root = FXMLLoader.load(getClass().getResource("startMenu/StartFXML.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Fight!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

    //laound program
    public static void main(String[] args) {
        launch(args);
    }
    
}
