package org.parqueaderos.parqueadero;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    // Referencia a un componente Label en el archivo FXML
    @FXML
    private Label welcomeText;
    // Método que se ejecuta al hacer clic en el botón
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    } // Cambiar el texto del Label
}