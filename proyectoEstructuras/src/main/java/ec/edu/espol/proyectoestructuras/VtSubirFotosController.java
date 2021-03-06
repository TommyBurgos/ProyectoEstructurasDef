/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyectoestructuras;
import Estructuras.LinkedList;
import ec.edu.espol.model.Album;
import ec.edu.espol.model.Foto;
import ec.edu.espol.model.Persona;
import ec.edu.espol.model.listaAlbumes;
import ec.edu.espol.model.paraSerializar;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private listaAlbumes albumes=new listaAlbumes();
    private ComboBox carpetas;
    private ComboBox cbOp;
    private ComboBox cbCantPersonas;
    private String path ="src\\main\\resources\\img\\";   
    
    
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
    void ConfirmarYRegresar(MouseEvent event) throws IOException {
        crearFoto();
        guardarAlbum();
        App.setRoot("vtSegunda");
        System.out.println("Logrado");
        System.out.println(albumes.getMisAlbumes().getHead().getDato().getNombre());
        String nombreDir=alname.getText();
        String ruta=path+nombreDir;
        File D = new File(ruta);
        boolean D1 = D.mkdirs();
        if(D1){ 
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("success");
        alert.setHeaderText(null);
        alert.setContentText("Albun creado exitosamente");
        alert.showAndWait();
      }else{  
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Error Message");
        alert.showAndWait();
      }
        
         subirfoto(ruta+"\\");
         //rutas.addLast(ruta+"\\");


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
            String placeToSaveFile = path+selectedFile.getName();
            Files.copy(selectedFile.toPath(),new File(placeToSaveFile).toPath(),StandardCopyOption.REPLACE_EXISTING);
            txtimg.setText(selectedFile.getName());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Imagen cargada exitosamente");
            alert.setTitle("success");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            txtimg.setText("");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No se pudo cargar la imagen");
            alert.showAndWait();
        }           

    }
    
   void subirfoto(String ruta)throws IOException {
         FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Imagenes","*.jpg","*.jpeg","*.png"));
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null){
            String placeToSaveFile = ruta+selectedFile.getName();
            Files.copy(selectedFile.toPath(),new File(placeToSaveFile).toPath(),StandardCopyOption.REPLACE_EXISTING);
            txtimg.setText(selectedFile.getName());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Albun creado exitosamente");
            alert.setTitle("success");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            txtimg.setText("");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No se pudo cargar la imagen");
            alert.showAndWait();
        } }
    
     @FXML
    void ingresarParametros(MouseEvent event) throws IOException{
        ArrayList<String> atrib = Foto.atributos();
            for(String cad:atrib)
                a??adirCaja(cad+":");
        //a??adirCaja("Aparecen personas en la foto?");
       // ArrayList<String> listaOp= new ArrayList<>();
       // listaOp.add("Si");listaOp.add("No");
        //addCombo(cbOp, listaOp);
        //panel.getChildren().add(cbOp);
        //
       /* String nombreDir=alname.getText();
        String ruta=path+nombreDir;
        File D = new File(ruta);
        boolean D1 = D.mkdirs();
        if(D1){ 
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("success");
        alert.setHeaderText(null);
        alert.setContentText("Albun creado exitosamente");
        alert.showAndWait();
      }else{  
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Error Message");
        alert.showAndWait();
      }
        
         subirfoto(ruta+"\\");
         rutas.addLast(ruta+"\\");
*/
    }
    public void addCombo(ComboBox cb, ArrayList<String> li){        
        cb.setItems(FXCollections.observableArrayList(li));
    }
      public void a??adirCaja(String cad){
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
       
       public void  crearFoto(){
        
        ArrayList<String> info = informacion();
        LinkedList<Persona> nombres = new LinkedList<>();
        String personas = info.get(3);
        String [] lista= personas.split("$");
        for(int i=0; i<lista.length;i++){
            Persona pn=new Persona(lista[i]);
            nombres.addLast(pn);
        }
        Foto.registrarFoto("fotos3.txt",info.get(0),info.get(1),info.get(2),nombres,"img\\"+txtimg.getText()); 
        
    }
       public void guardarAlbum() throws IOException{
           Album alb=new Album(alname.getText());
           albumes.addAlbum(alb);
           paraSerializar o = new paraSerializar();
           o.createFile();
           o.cargarAlbumesData(albumes);
           System.out.println(albumes.getMisAlbumes().getSize());
           
       }
      // public void GuardarFoto() {
        
      //  LinkedList<Foto> fot = Foto.leer("fotos.txt");
        
        //Foto f1 = crearFoto();
       // f1.setRutaFoto(txtimg.getText());
       // fot.addLast(f1);
       // Foto.registrarFoto("fotos.txt",);
   // }
       
      
}


