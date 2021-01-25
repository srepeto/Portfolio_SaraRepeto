package Controlador;

//Eva María Marchena Mejías & Sara Repeto García

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GestionFicheros extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../Vista/VistaGestFich.fxml"));
        Scene sceneGestion = new Scene(root);
        primaryStage.setTitle("Gestión de ficheros");
        primaryStage.setScene(sceneGestion);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
