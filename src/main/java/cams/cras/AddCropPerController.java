/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.cams.cras;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Brenna
 */
public class AddCropPerController implements Initializable {

    @FXML
    private TextField codeField;

    @FXML
    private TextField descField;

    @FXML
    private Button back;

    @FXML
    private Button addButton;

    @FXML
    private TextField endField;

    @FXML
    private TextField startField;

    @FXML
    private Button home;

    @FXML
    void handleBackAction(ActionEvent e) throws IOException {
        Parent homePage = FXMLLoader.load(AddCropPerController.class.getResource("../crasMenu.fxml"));
        Scene homepage = new Scene(homePage);
        Stage oldStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        oldStage.setScene(homepage);
    }

    @FXML
    void handleHomeAction(ActionEvent e) throws IOException {
        Parent homePage = FXMLLoader.load(AddCropPerController.class.getResource("../main.fxml"));
        Scene homepage = new Scene(homePage);
        Stage oldStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        oldStage.setScene(homepage);
    }

    @FXML
    void handleAddAction(ActionEvent e) {
        String code, desc, start, end; 
        
        code = codeField.getText().trim();
        desc = descField.getText().trim();
        start = startField.getText().trim();
        end = endField.getText().trim();
        
        CropPeriod newPeriod = new CropPeriod(code, start, end, desc); 
        newPeriod.addCropPeriod();
        Alert addedAlert = new Alert(Alert.AlertType.INFORMATION);
        addedAlert.setTitle("Confirmation");
        addedAlert.setHeaderText("Congratulations");
        addedAlert.setContentText("Your new crop period has been added");
        addedAlert.showAndWait();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
