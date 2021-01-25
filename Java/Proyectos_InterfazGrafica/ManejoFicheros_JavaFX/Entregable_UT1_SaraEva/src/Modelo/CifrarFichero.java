package Modelo;
import java.io.*;

public class CifrarFichero {

    File fichSeleccionado;

    public CifrarFichero(File fichSeleccionado) {
        this.fichSeleccionado = fichSeleccionado;
    }

    public void cifrado() throws IOException {

        try{
            String linea, absoluta, palabra = "", lineacifrada = "";
            int i, contador = 0, suma = 0;

            absoluta = fichSeleccionado.getAbsolutePath();
            int last = absoluta.lastIndexOf('.');
            String nomsinext = absoluta.substring(0,last);
            String nuevonombre = nomsinext + "_cifrado." + getFileExtension(fichSeleccionado.getName());

            File fichOrigen = new File(String.valueOf(fichSeleccionado));
            File fichDestino = new File(nuevonombre);

            FileReader lector = new FileReader(fichOrigen);
            BufferedReader entrada = new BufferedReader(lector);

            FileWriter escritor = new FileWriter(fichDestino);
            BufferedWriter salida = new BufferedWriter(escritor);


            while ((linea = entrada.readLine()) != null) {
                String[] ArrayPalabras = linea.split("\\s+");
                for (i = 0; i < ArrayPalabras.length; i++) {
                    if (ArrayPalabras[i].length() > 4){
                        palabra = cifrarcadena(ArrayPalabras[i]);
                    }else{
                        palabra =  ArrayPalabras[i];
                    }
                    lineacifrada = lineacifrada + palabra + " ";
                }
                lineacifrada = lineacifrada + "\n";
            }
            lector.close();

            salida.write(lineacifrada);
            salida.flush();
            escritor.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Se le pasa el nombre del fichero y devuelve la extensión
    private String getFileExtension(String fullName) {
        String fileName = new File(fullName).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    private String cifrarcadena(String cadena){
        int i;
        String cadenacifrada = "";
        for (i = 1; i <= cadena.length(); i++){
            if ((i == 1) || (i == cadena.length())){
                cadenacifrada = cadenacifrada + cadena.charAt(i-1);
            } else {
                cadenacifrada = cadenacifrada + cadena.charAt(cadena.length() - i);
            }
        }
        return cadenacifrada;
    }

}
