/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyectoestructuras;
import ec.edu.espol.model.Foto;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
/**
 *
 * @author Melanie Sandoval
 */


  
public class VtSubirFotosController {

   
    @FXML
    private TextField alname;

    @FXML
    private Button conf;

    @FXML
    private Button okButton;

    @FXML
    private FlowPane panel;

    @FXML
    private Button sf;

    @FXML
    private Text txtimg;

    @FXML
    private Button volver;


    @FXML
    void ConfirmarYRegresar(MouseEvent event) {

    }
    
   // public void initialize(URL url, ResourceBundle rb) {
     //   ArrayList<String> albumes = new ArrayList(Arrays.asList("Album Playa","Album Colegio","Album Universidad"));
    //    comboBox.setItems(FXCollections.observableList(albumes));
     //   panel.setHgap(10);
       
  //  }    

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
     @FXML
    void ingresarParametros(MouseEvent event){
        ArrayList<String> atrib = Foto.atributos();
                for(String cad:atrib)
                    añadirCaja(cad+":");
    }
      public void añadirCaja(String cad){
        VBox vb = new VBox();
        Text txt = new Text(cad);
        vb.setSpacing(20);
        TextField tf = new TextField();
        vb.getChildren().add(txt);
        vb.getChildren().add(tf);
        panel.getChildren().add(vb);
    }
       public ArrayList<String> informacion() {
        ArrayList<String> info = new ArrayList<>();
        VBox vb;
        for(int i = 0; i<panel.getChildren().size();i++){
            vb =(VBox)panel.getChildren().get(i);
            TextField tf =(TextField)vb.getChildren().get(1);
            info.add(tf.getText());
        }
        return info;
      
       }
       
       
       
      
      
}


