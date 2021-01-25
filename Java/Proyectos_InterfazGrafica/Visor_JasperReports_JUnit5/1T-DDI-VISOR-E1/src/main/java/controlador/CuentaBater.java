package controlador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class CuentaBater extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(loadFXML());
        stage.getIcons().add(new Image(CuentaBater.class.getResourceAsStream("/vista/logo.png")));
        stage.setTitle("Aplicación Cuentas Bancarias");
        scene.getStylesheets().add(getClass().getResource("/vista/VisorStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private static Parent loadFXML() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CuentaBater.class.getResource("/vista/"+ "VisualizaCuentas" +".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {

        launch();
    }

}