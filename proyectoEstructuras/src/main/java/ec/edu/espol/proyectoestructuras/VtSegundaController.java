/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoestructuras;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class VtSegundaController implements Initializable {
   
    @FXML
    TextField buscar;
    @FXML
    HBox ptCentro;
    @FXML
    Button btCrearAlbun;
    @FXML
    private void regresar() throws IOException{
        App.setRoot("vtPrincipal");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buscar.setPromptText("Buscar");
        ptCentro.setBackground(new Background(new BackgroundFill(Color.web("#BDBDBD"),CornerRadii.EMPTY,Insets.EMPTY)));
        btCrearAlbun.setBackground(new Background(new BackgroundFill(Color.web("#FFFFFF"),CornerRadii.EMPTY,Insets.EMPTY)));
    }
        @FXML
    void showCrearAlbum(ActionEvent event) throws IOException {
        App.setRoot("vtSubirFotosController");

    }

    
 
      
    
}
