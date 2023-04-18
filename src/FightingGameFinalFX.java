/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author cathe
 */
public class FightingGameFinalFX extends Application {
    private static Stage AddCharStage = null;
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
    
    //method to create character stage
    public void createAddCharStage(){
        AddCharStage = new Stage();
        AddCharStage.setTitle("Add Fighter");
        AddCharStage.setAlwaysOnTop(true);
        AddCharStage.setResizable(false);
        AddCharStage.initModality(Modality.APPLICATION_MODAL);
    }
    
    //method to get add character stage at any moment
    public static Stage getAddCharStage(){
        return AddCharStage;
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
