package act4;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Ficheros_act4 {

    public static void main(String[] args) throws InterruptedException {
        long t_comienzo, t_fin;
        t_comienzo = System.currentTimeMillis();

        for (int j=0; j<args.length; j++) {
            String rutaFich = args[j];

            try {

                FileReader fichero = new FileReader(rutaFich);
                CuentaPalabras hilo = new CuentaPalabras("fichero " + (j+1), fichero);
                hilo.start();

            } catch (FileNotFoundException e) {
                System.out.println("No se ha encontrado el fichero");
            }
        }

        Thread.sleep(1000);

        t_fin = System.currentTimeMillis();
        long tiempoTotal = (t_fin - t_comienzo) - 1000;
        System.out.println("El proceso ha tardado: " + tiempoTotal + " milisegundos");
        //La mayoría de las veces sale 0, pero hay otras que no
    }

}
