package Modelo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MostrarINFO {
    File fichSeleccionado;

    public MostrarINFO(File fichSeleccionado) {
        this.fichSeleccionado = fichSeleccionado;
    }

    public String[] obtenerInfo() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = new Date(fichSeleccionado.lastModified());

        String nombre = fichSeleccionado.getName().replaceFirst("[.][^.]+$", "");
        String extension = getFileExtension(fichSeleccionado.getName());
        String ruta = fichSeleccionado.getAbsolutePath();
        String tamano = (fichSeleccionado.length()/1024)+" KB";
        String ultModif = formatoFecha.format(fecha);

        String [] infoFich = {nombre, extension, ruta, tamano, ultModif};
        return infoFich;
    }

    //Se le pasa el nombre del fichero y devuelve la extensión
    public static String getFileExtension(String fullName) {
        String fileName = new File(fullName).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }


}
