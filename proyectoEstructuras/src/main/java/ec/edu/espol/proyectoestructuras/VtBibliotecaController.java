/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoestructuras;

import Estructuras.LinkedList;
import ec.edu.espol.model.Foto;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


/**
 * FXML Controller class
 *
 * @author tommy_Burgos
 */
public class VtBibliotecaController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
      @FXML
    private ComboBox cbx1;

    @FXML
    private ComboBox cbx2;

    @FXML
    private VBox fotos;

    @FXML
    private ImageView volver;

    @FXML
    void buscarAutos(MouseEvent event) {

    }

    @FXML
    void regresar(MouseEvent event) throws IOException {
        App.setRoot("vtSegunda");
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbx1.getItems().add("Descripción");
        cbx1.getItems().add("Lugar");
        cbx1.getItems().add("Fecha");
        cbx1.getItems().add("Personas");
        
        cbx2.getItems().add("Descripción");
        cbx2.getItems().add("Lugar");
        cbx2.getItems().add("Fecha");
        cbx2.getItems().add("Personas");
    }  
    
    // Se necesita crear una lista de Fotos en donde se guarden las fotos subidas, despues el código debería mostrar todas las fotos al dar clik en
    //el Vbox, tambien se puede crear una lista de albumes y realizar lo mismo.
     @FXML
    private void buscarFotos(MouseEvent event) {
        fotos.getChildren().clear();
        
       LinkedList<Foto> albumes = Foto.leer("Fotos");
        for(int i = 0; i < albumes.getSize(); i++){
            HBox datosFoto = new HBox();
            Text t = new Text(albumes.get(i).toString());
            datosFoto.setSpacing(10);
            Image img = new Image("img/"+albumes.get(i).getRutaFoto());
            ImageView imgview = new ImageView(img);
            imgview.setFitWidth(150);
            imgview.setFitHeight(150);
            datosFoto.getChildren().add(t);
            datosFoto.getChildren().add(imgview);
            fotos.getChildren().add(datosFoto);           
    
    }
    
}
}
