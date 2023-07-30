/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXClippedPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;

/**
 * FXML Controller class
 *
 * @author Deepanshu Sahu
 */
public class WelcomePageController implements Initializable {

    @FXML
    private ImageView bgImage;
    @FXML
    private AnchorPane mask;
    @FXML
    private JFXClippedPane root;
double screenW;
double screenH;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        screenW=Screen.getPrimary().getVisualBounds().getWidth();
        screenH=Screen.getPrimary().getVisualBounds().getHeight();
        
      bgImage.setFitWidth(screenW);
      bgImage.setFitHeight(screenH);
      
      mask.setMinWidth(screenW);
      mask.setMinHeight(screenH);
    }    

    @FXML
    private void startButtonActionEvent(ActionEvent event) {
        try {
            App.STAGE.setScene(new Scene(FXMLLoader.load(getClass().getResource("LabelMaker.fxml")),this.screenW,this.screenH));
        } catch (IOException ex) {
            Logger.getLogger(WelcomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
