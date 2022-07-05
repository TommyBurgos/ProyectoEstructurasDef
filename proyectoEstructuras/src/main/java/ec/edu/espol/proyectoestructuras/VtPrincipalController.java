/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoestructuras;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author tommy_Burgos
 */
public class VtPrincipalController implements Initializable {
    @FXML
    VBox contRight;
    @FXML
    Button btIngresar;
    @FXML
    VBox contLeft;
    /**
     * Initializes the controller class.
     */
    @FXML
    private void ingresar() throws IOException{
        App.setRoot("vtSegunda");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btIngresar.setPrefWidth(370);
        btIngresar.setPrefHeight(44);
        btIngresar.setMaxWidth(Double.MAX_VALUE);
        btIngresar.setCursor(Cursor.HAND);
        btIngresar.setText("Da Clic aquí");
        HBox.setHgrow(contLeft, Priority.ALWAYS);
        HBox.setHgrow(contRight, Priority.ALWAYS);
        
        contRight.setBackground(new Background(new BackgroundFill(Color.web("#30373e"),CornerRadii.EMPTY,Insets.EMPTY)));
    }    
    
}
