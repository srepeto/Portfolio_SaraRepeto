package Modelo;
import java.io.File;

public class Borrar {
    File fichSeleccionado;

    public Borrar(File fichSeleccionado) { this.fichSeleccionado = fichSeleccionado; }

    public boolean BorrarFichero(){

        File fichero = new File(fichSeleccionado.getAbsolutePath());
        fichero.delete();

        return true;
    }
}
