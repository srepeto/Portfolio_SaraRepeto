package act3;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Ficheros_act3 {

    public static void main(String[] args) throws InterruptedException {
        long t_comienzo, t_fin;
        t_comienzo = System.currentTimeMillis();

        for (int j=0; j<args.length; j++) {
            String rutaFich = args[j];

            try {

                FileReader fichero = new FileReader(rutaFich);
                CuentaCaracteres hilo = new CuentaCaracteres("fichero " + (j+1), fichero);
                hilo.start();

            } catch (FileNotFoundException e) {
                System.out.println("No se ha encontrado el fichero");
            }
        }

        Thread.sleep(1000);

        t_fin = System.currentTimeMillis();
        long tiempoTotal = (t_fin - t_comienzo) - 1000;
        System.out.println("El proceso ha tardado: " + tiempoTotal + " milisegundos");
    }

}
