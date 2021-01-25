package act3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CuentaCaracteres extends Thread {
    FileReader fichero;

    public CuentaCaracteres (String nombre, FileReader fichero) {
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
                    contador = contador + 1;
                }
                linea = leerFich.readLine();
            }

            System.out.println("El " + getName() + " contiene " + contador + " caracteres");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
