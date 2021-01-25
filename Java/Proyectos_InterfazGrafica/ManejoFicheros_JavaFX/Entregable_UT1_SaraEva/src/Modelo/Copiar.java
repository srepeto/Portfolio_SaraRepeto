package Modelo;

import java.io.*;

public class Copiar {
    File fichSeleccionado;
    File fichNuevo;

    public Copiar(File fichSeleccionado, File fichNuevo) {
        this.fichSeleccionado = fichSeleccionado;
        this.fichNuevo = fichNuevo;
    }

    public void copiarFich () throws IOException {
        FileInputStream lector = new FileInputStream(fichSeleccionado.getAbsolutePath());
        BufferedInputStream entrada = new BufferedInputStream(lector);

        byte bufferEntrada[];
        bufferEntrada = entrada.readAllBytes();

        FileOutputStream escritor = new FileOutputStream(fichNuevo);
        BufferedOutputStream salida = new BufferedOutputStream(escritor);

        salida.write(bufferEntrada);
        salida.flush();
        lector.close();
        entrada.close();
        escritor.close();
        salida.close();
    }

}
