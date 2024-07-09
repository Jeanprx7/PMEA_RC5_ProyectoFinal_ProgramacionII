package org.parqueaderos.parqueadero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    // Método start que se ejecuta al iniciar la aplicación JavaFX
    @Override
    public void start(Stage stage) throws IOException {
        // Cargar la vista FXML y crear una escena
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        // Configurar el título de la ventana
        stage.setTitle("Hello!");
        // Establecer la escena en el escenario y mostrarla
        stage.setScene(scene);
        stage.show();
    }
    // Método main para lanzar la aplicación
    public static void main(String[] args) {
        launch();
    }
}