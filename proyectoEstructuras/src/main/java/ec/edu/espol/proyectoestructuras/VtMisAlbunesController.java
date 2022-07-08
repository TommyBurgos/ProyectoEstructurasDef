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
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author tommy_Burgos
 */
public class VtMisAlbunesController implements Initializable {

    @FXML
    private HBox barraName;
    @FXML
    private HBox barraSuperior;
    
     @FXML
    private void regresar() throws IOException{
        App.setRoot("vtSegunda");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        barraSuperior.setBackground(new Background(new BackgroundFill(Color.web("#C2DBFC"),CornerRadii.EMPTY,Insets.EMPTY)));
        barraName.setBackground(new Background(new BackgroundFill(Color.web("#C2DBFC"),CornerRadii.EMPTY,Insets.EMPTY)));
    }    
    
}
