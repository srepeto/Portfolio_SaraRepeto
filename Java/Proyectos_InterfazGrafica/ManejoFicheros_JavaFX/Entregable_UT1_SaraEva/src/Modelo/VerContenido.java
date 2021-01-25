package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class VerContenido {
    File fichSeleccionado;

    public VerContenido(File fichSeleccionado) {
        this.fichSeleccionado = fichSeleccionado;
    }

    public String leerContenido () {
        try {
            BufferedReader lectorR = new BufferedReader(new FileReader(fichSeleccionado));

            String textoEntero = "";
            String lineaLeida = lectorR.readLine();

            while ( lineaLeida != null) {
                textoEntero = textoEntero + lineaLeida + "\n";
                lineaLeida = lectorR.readLine();
            }

            lectorR.close();
            return textoEntero;

        } catch (IOException e) {
            System.out.println("Ha habido un problema al leer el fichero");
            return null;
        }
    }
}
