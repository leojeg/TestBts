/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author professeur
 */
public class FXMain extends Application
{
    
    @Override
    public void start(Stage primaryStage)
    {
        AnchorPane layoutRacine;
        try
        {
            //Chargement de la fenetre d'accueil
            FXMLLoader loader  = new FXMLLoader(FXMain.class.getResource("/vue/FXML_Resultat.fxml"));
            System.out.println("PASSAGE1");
            layoutRacine = (AnchorPane) loader.load();
            System.out.println("PASSAGE2");
            Scene scene = new Scene(layoutRacine, 600, 400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Classement de la course");
            primaryStage.show();
        }
        catch (IOException ex)
        {
            System.out.println("ERREUR Démarrage fenêtre classement course : " + ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
