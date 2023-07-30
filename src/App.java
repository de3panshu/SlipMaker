/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Deepanshu Sahu
 */
public class App extends Application {
    public static Stage STAGE;
    //@Override
    public void start(Stage primaryStage) {
        STAGE = primaryStage;
        Scene scene=null;
        try {
            scene = new Scene(FXMLLoader.load(getClass().getResource("WelcomePage.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        primaryStage.setTitle("Label Maker");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("tick.png")));
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }
    
}
