module ec.edu.espol.proyectoestructuras {
    requires javafx.controls;
    requires javafx.fxml;

    opens ec.edu.espol.proyectoestructuras to javafx.fxml;
    exports ec.edu.espol.proyectoestructuras;
}
