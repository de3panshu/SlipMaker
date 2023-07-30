/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Deepanshu Sahu
 */
public class DashiBoardController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Label fileNameLabel;
    @FXML
    private ToggleGroup configs;
    @FXML
    private TableView<?> table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void boxModelActionEvent(ActionEvent event) {
    }

    @FXML
    private void createLabelsActionEvent(ActionEvent event) {
    }

    @FXML
    private void chooseFileButtonAvtionEvent(ActionEvent event) {
    }
    
}
