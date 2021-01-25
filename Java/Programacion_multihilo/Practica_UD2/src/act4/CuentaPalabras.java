package act4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CuentaPalabras extends Thread {
    FileReader fichero;

    public CuentaPalabras(String nombre, FileReader fichero) {
        setName(nombre);
        this.fichero = fichero;
    }

    public void run() {
        BufferedReader leerFich = new BufferedReader(fichero);
        int contador = 0;

        try {
            String linea = leerFich.readLine();

            while (linea != null) {
                for (int i=0; i<linea.length(); i++) {
                    int caracter = linea.charAt(i);
                    if (caracter == 32) {
                        contador = contador + 1;
                    }
                }
                linea = leerFich.readLine();
            }

            System.out.println("El " + getName() + " contiene " + (contador+1) + " palabras");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
