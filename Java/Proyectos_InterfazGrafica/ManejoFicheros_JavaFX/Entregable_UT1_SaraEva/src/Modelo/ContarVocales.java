package Modelo;

import java.io.*;
import java.util.Scanner;

public class ContarVocales {
    File fichSeleccionado;

    public ContarVocales(File fichSeleccionado) {
        this.fichSeleccionado = fichSeleccionado;
    }

    public int [] cuentavocales() {
        try {
            FileReader lector = new FileReader(fichSeleccionado);
            BufferedReader inBuffer = new BufferedReader(lector);

            int contadorA = 0;
            int contadorE = 0;
            int contadorI = 0;
            int contadorO = 0;
            int contadorU = 0;
            String linea = inBuffer.readLine();

            while (linea != null) {
                for (int i = 0; i < linea.length(); i++) {
                    char letra = linea.charAt(i);
                    if(esVocalA(letra)) {
                        contadorA++;
                    }
                    if(esVocalE(letra)) {
                        contadorE++;
                    }
                    if(esVocalI(letra)) {
                        contadorI++;
                    }
                    if(esVocalO(letra)) {
                        contadorO++;
                    }
                    if(esVocalU(letra)) {
                        contadorU++;
                    }
                }
                linea = inBuffer.readLine();
            }
            inBuffer.close();
            lector.close();

            int [] contador = {contadorA, contadorE, contadorI, contadorO, contadorU};
            return contador;

        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e2) {
            return null;
        }
    }

    /*public static boolean esVocal(char c) {
        return "aeiouAEIOUáéíóúÁÉÍÓÚüÜ".indexOf(c) > -1;
    }*/

    public static boolean esVocalA(char c) {
        return "aAáÁ".indexOf(c) > -1;
    }

    public static boolean esVocalE(char c) {
        return "eEéÉ".indexOf(c) > -1;
    }

    public static boolean esVocalI(char c) {
        return "iIíÍ".indexOf(c) > -1;
    }

    public static boolean esVocalO(char c) {
        return "oOóÓ".indexOf(c) > -1;
    }

    public static boolean esVocalU(char c) {
        return "uUúÚüÜ".indexOf(c) > -1;
    }

}
