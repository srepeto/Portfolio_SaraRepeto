package Modelo;
import java.io.*;

public class ContarPalabras {

    File fichSeleccionado;

    public ContarPalabras(File fichSeleccionado) {
        this.fichSeleccionado = fichSeleccionado;
    }

    public int CuentaPalabras() {

        String linea;
        int i, contador = 0;

        try {
            FileReader lector = new FileReader(fichSeleccionado);
            BufferedReader entrada = new BufferedReader(lector);

            while ((linea = entrada.readLine()) != null) {
                for (i = 0; i < linea.length(); i++) {
                    if (i == 0) {
                        if (linea.charAt(i) != ' ') {
                            contador++;
                        }
                    } else {
                        if (linea.charAt(i - 1) == ' ') {
                            if (linea.charAt(i) != ' ') {
                                contador++;
                            }
                        }
                    }
                }
            }

            lector.close();
            entrada.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contador;
    }

}
