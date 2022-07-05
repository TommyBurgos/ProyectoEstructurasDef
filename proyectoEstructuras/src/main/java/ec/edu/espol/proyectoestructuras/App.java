package ec.edu.espol.proyectoestructuras;

import Estructuras.DoubleLinkedList;
import Estructuras.LinkedList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    @Override
    public void start(Stage stage) throws IOException {
        VBox contLeft= new VBox();
        //Agregar nodos hijos de la izquierda
        Label lbLogin=new Label("BIENVENIDO");
        lbLogin.setFont(new Font(30));
        
        VBox contLogin=new VBox();
       
        Label lbUser=new Label("Da clic para ingresar a tú gestor de fotos favorito");
        lbUser.setFont(new Font(20));
        //Label lbCont=new Label("Contraseña");
        //lbCont.setFont(new Font(20));
        
        //TextField textUser= new TextField();
        //textUser.setFont(new Font(18));
        //textUser.setPromptText("Ingrese su usuario");
        //textUser.setPrefWidth(341);
        //textUser.setPrefHeight(44);
        
        
        //PasswordField password= new PasswordField();
        //password.setFont(new Font(20));
        //password.setPromptText("Ingrese una contraseña");
        
        Button btIngresar=new Button("Ingresar");
        btIngresar.getOnAction();
       
        
       
        contLogin.getChildren().addAll(lbUser,btIngresar);
        contLogin.setAlignment(Pos.TOP_LEFT);
        
        contLeft.getChildren().addAll(lbLogin,contLogin);
        contLeft.setPrefWidth(422);
        contLeft.setAlignment(Pos.CENTER);
        VBox.setMargin(contLogin, new Insets(0,30,0,30));
        
        
        VBox contRight= new VBox();
        
        ImageView ImagenLogo;
        InputStream inputStream;
        inputStream = getClass().getResourceAsStream("logo.png");
        Image imagen= new Image(inputStream);
        
        ImagenLogo= new ImageView(imagen);
        VBox contImag= new VBox();
        contImag.getChildren().add(ImagenLogo);
        contImag.setAlignment(Pos.CENTER_RIGHT);
        contRight.getChildren().add(contImag);
        
        contRight.setPrefWidth(310);
        contRight.setAlignment(Pos.CENTER);
        
              
        HBox root=new HBox();
        root.getChildren().addAll(contLeft,contRight);
        
        HBox.setHgrow(contLeft, Priority.ALWAYS);
        HBox.setHgrow(contRight, Priority.ALWAYS);
                
        scene = new Scene(loadFXML("vtPrincipal"), 1140, 550);
        stage.setTitle("Your Memories");
        stage.setScene(scene);
        stage.show();
    }
 
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
        LinkedList<String> l1= new LinkedList<>(); 
        System.out.println(l1.isEmpty());
        l1.addFirst("hola");
        l1.addFirst("chao");
        l1.addFirst("hola2");
        l1.addLast("penultimo");
        l1.addLast("ultimo?");
        l1.addLast("Pedro");
        l1.addFirst("dome");
        System.out.println(l1.isEmpty());
        System.out.println(l1.toString());
        System.out.println(l1.removeFirst().getDato());
        System.out.println(l1.toString());
        System.out.println(l1.removeLast().getDato());
        System.out.println(l1.toString());
        System.out.println(l1.remove("dome"));
        System.out.println(l1.remove("chao").getDato());
        System.out.println(l1.toString());
        System.out.println("---------------");
        DoubleLinkedList<String> l2= new DoubleLinkedList<>(); 
        System.out.println(l2.isEmpty());
        l2.addFirst("hola");
        l2.addFirst("chao");
        l2.addFirst("hola2");
        l2.addLast("penultimo");
        l2.addLast("ultimo?");
        l2.addLast("Pedro");
        l2.addFirst("dome");
        System.out.println(l2.isEmpty());
        System.out.println(l2.toString());
    }

}