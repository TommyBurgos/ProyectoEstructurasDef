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
import javafx.scene.control.ScrollPane;
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
    private ComboBox<?> cbx1;

    @FXML
    private ComboBox<?> cbx2;

    @FXML
    private VBox fotos= new VBox();

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
        buscarFotos();
    }

    // Se necesita crear una lista de Fotos en donde se guarden las fotos subidas, despues el código debería mostrar todas las fotos al dar clik en
    //el Vbox, tambien se puede crear una lista de albumes y realizar lo mismo.
    @FXML
    private void buscarFotos() {
        fotos.getChildren().clear();

        LinkedList<Foto> albumes = Foto.leer("fotos2.txt");
        System.out.println(albumes.getSize());
        System.out.println("holaMundo");
        
        System.out.println(albumes.getHead());
        System.out.println(albumes.getSize());
        ScrollPane sp= new ScrollPane();
        for (int i = 0; i < albumes.getSize()-1; i++) {
            HBox datosFoto = new HBox();
            System.out.println(albumes.get(i).getRutaFoto());
            Text t = new Text(albumes.get(i).getDescripcion());
            datosFoto.setSpacing(10);
            Image img = new Image(albumes.get(i).getRutaFoto());
            ImageView imgview = new ImageView(img);
            imgview.setFitWidth(150);
            imgview.setFitHeight(150);
            datosFoto.getChildren().add(t);
            datosFoto.getChildren().add(imgview);
            sp.setContent(datosFoto);
            //fotos.getChildren().add(sp);
            fotos.getChildren().add(datosFoto);

        }

    }
    
    /*public static void main(String[] args) {
        VtBibliotecaController v = new VtBibliotecaController();
        v.buscarFotos();
    }*/
}
