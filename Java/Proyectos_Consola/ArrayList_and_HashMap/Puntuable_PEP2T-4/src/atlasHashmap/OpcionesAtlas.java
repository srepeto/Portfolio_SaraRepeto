package atlasHashmap;
import java.util.HashMap;
import java.util.InputMismatchException;

public class OpcionesAtlas {
    HashMap<String, String> atlas = new HashMap<String, String>();

    public void entrada (String pais, String capital) {
        atlas.put(pais, capital);
        System.out.println("\n\tNueva entrada incorporada");
    }

    public void mostrar () {
        int size;
        for (String i : atlas.keySet()) {
            System.out.println("País: " + i + "   Capital: " + atlas.get(i)+"");
        }
        size=atlas.size();
        System.out.println("\nHay "+size+" elementos en el Atlas");
    }

    public void buscar (String pais) {
        System.out.println("Capital: "+atlas.get(pais));
    }

    public void replace (String pais, String capital) {
        atlas.replace(pais, capital);
        //map.replace("b", 200);
    }

    public void remove (String pais) {
        atlas.remove(pais);
        System.out.println(pais+" eliminada del Atlas");
    }

    public void clear () {
        atlas.clear();
        System.out.println("\tEliminado el Atlas por completo");
    }

    public boolean verificar (String pais) throws Exception {
        Exception ex;
        boolean fverif = false;
        for (String i : atlas.keySet()) {
            if (pais.equals(i)) {
                fverif = true;
            }
        }
        if (fverif==false) {
            System.out.println("De este país no se encuentra capital");
        }

        return fverif;
    }



}
