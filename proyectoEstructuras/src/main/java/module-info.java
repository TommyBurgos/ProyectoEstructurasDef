module ec.edu.espol.proyectoestructuras {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.proyectoestructuras to javafx.fxml;
    exports ec.edu.espol.proyectoestructuras;
}
