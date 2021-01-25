package act10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Productor extends Thread {
    FileReader fichero;
    Cola cola;

    public Productor(String nombre, FileReader fichero, Cola cola) {
        setName(nombre);
        this.fichero = fichero;
        this.cola = cola;
    }
    public Productor () {}

    public void run() {
        BufferedReader leerFich = new BufferedReader(fichero);

        try {
            String linea = leerFich.readLine();

            while (linea != null) {
                for (int i=0; i<linea.length(); i++) {
                    System.out.println("El productor produce " + linea.charAt(i));
                    cola.put(linea.charAt(i));
                    sleep(100);
                }
                linea = leerFich.readLine();
            }

        } catch (InterruptedException | IOException e) {
            System.out.println("Ha ocurrido una excepción");
        }

        System.exit(0);
        System.out.println("Productor finalizado");
    }

}
