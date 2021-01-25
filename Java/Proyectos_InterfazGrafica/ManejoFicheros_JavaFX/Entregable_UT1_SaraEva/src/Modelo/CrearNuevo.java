package Modelo;

import java.io.File;

public class CrearNuevo {
    File directSeleccionado;
    String nombre;

    public CrearNuevo(File directSeleccionado, String nombre) {
        this.directSeleccionado = directSeleccionado;
        this.nombre = nombre;
    }

    public File crearNuevoFich () {
        File fichNuevo = new File(directSeleccionado.getAbsolutePath() + "\\" + nombre + ".txt");
        return fichNuevo;
    }

}
