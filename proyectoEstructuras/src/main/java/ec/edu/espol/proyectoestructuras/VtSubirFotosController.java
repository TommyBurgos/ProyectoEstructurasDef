/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyectoestructuras;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
/**
 *
 * @author Melanie Sandoval
 */


  
public class VtSubirFotosController {

    @FXML
    private TextField albumname;

    @FXML
    private FlowPane panel;

    @FXML
    private Button sf;

    @FXML
    private Text txtimg;

    @FXML
    void ConfirmarYRegresar(MouseEvent event) {

    }

    @FXML
    void RegresarAOpciones(MouseEvent event) throws IOException {
    App.setRoot("vtSegunda");
    }

    @FXML
    void subirfoto(MouseEvent event)throws IOException {
         FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imagenes","*.jpg","*.jpeg","*.png"));
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null){
            String placeToSaveFile = "src/main/resources/img/"+selectedFile.getName();
            Files.copy(selectedFile.toPath(),new File(placeToSaveFile).toPath(),StandardCopyOption.REPLACE_EXISTING);
            txtimg.setText(selectedFile.getName());
        } else {
            txtimg.setText("");
        }

    }

}


