package atlasArrayList;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class OpcionesAtlasArray {
    ArrayList<String> atlas = new ArrayList<String>();

    public void entrada (String pais, String capital) {
        atlas.add(pais);
        atlas.add(capital);
        System.out.println("\n\tNueva entrada incorporada");
    }

    public void mostrar () {
        int size;
        size=atlas.size();
        for (int i = 0; i < atlas.size(); i++) {
            if ((i+1)!=size) {
                System.out.println("País: " + atlas.get(i) + "   Capital: " + atlas.get(i + 1) + "");
                i++;
            }
        }
        System.out.println("\nHay "+(size/2)+" elementos en el Atlas");
    }

    public void buscar (String pais) {
        for (int i = 0; i < atlas.size(); i++) {
            if (atlas.get(i).equals(pais)) {
                System.out.println("Capital: "+atlas.get(i+1));
            }
        }
    }

    public void replace (String pais, String capital) {
        for (int i = 0; i < atlas.size(); i++) {
            if (atlas.get(i).equals(pais)) {
                atlas.set(i+1, capital);
            }
        }
    }

    public void remove (String pais) {
        for (int i = 0; i < atlas.size(); i++) {
            if (atlas.get(i).equals(pais)) {
                atlas.remove(atlas.get(i));
                atlas.remove(atlas.get(i));
            }
        }
        System.out.println(pais+" eliminada del Atlas");
    }

    public void clear () {
        atlas.clear();
        System.out.println("\tEliminado el Atlas por completo");
    }

    public boolean verificar (String pais) throws Exception {
        Exception ex;
        boolean fverif = false;
        for (int i = 0; i < atlas.size(); i++) {
            if (atlas.get(i).equals(pais)) {
                fverif = true;
            }
        }
        if (fverif==false) {
            System.out.println("De este país no se encuentra capital");
        }

        return fverif;
    }

}
