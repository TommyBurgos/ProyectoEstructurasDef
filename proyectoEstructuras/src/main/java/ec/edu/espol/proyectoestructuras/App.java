package ec.edu.espol.proyectoestructuras;

import Estructuras.LinkedList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        Label lbLogin=new Label("INICIAR SESIÓN");
        lbLogin.setFont(new Font(30));
        
        VBox contLogin=new VBox();
       
         Label lbUser=new Label("Usuario");
        lbUser.setFont(new Font(20));
        Label lbCont=new Label("Contraseña");
        lbCont.setFont(new Font(20));
        
        TextField textUser= new TextField();
        textUser.setFont(new Font(18));
        textUser.setPromptText("Ingrese su usuario");
        textUser.setPrefWidth(341);
        textUser.setPrefHeight(44);
        
        
        PasswordField password= new PasswordField();
        password.setFont(new Font(20));
        password.setPromptText("Ingrese una contraseña");
        
        Button btIngresar=new Button("Ingresar");
        btIngresar.setPrefWidth(370);
        btIngresar.setPrefHeight(44);
        btIngresar.setMaxWidth(Double.MAX_VALUE);
        btIngresar.setCursor(Cursor.HAND);
       
        contLogin.getChildren().addAll(lbUser,textUser,lbCont,password,btIngresar);
        contLogin.setAlignment(Pos.TOP_LEFT);
        
        contLeft.getChildren().addAll(lbLogin,contLogin);
        contLeft.setPrefWidth(422);
        contLeft.setAlignment(Pos.CENTER);
        VBox.setMargin(contLogin, new Insets(0,30,0,30));
        
        
        VBox contRight= new VBox();
       
        HBox root=new HBox();
        root.getChildren().addAll(contLeft,contRight);
        
        scene = new Scene(root, 640, 480);
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
        l1.addFirst("hola");
        System.out.println(l1.isEmpty());
        System.out.println(l1.toString());
    }

}