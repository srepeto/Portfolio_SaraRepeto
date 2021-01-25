package atlasHashmap;
import java.util.Scanner;
import java.util.InputMismatchException;


public class TestAtlas {

    public static void main(String[] args) throws Exception {
        atlasHashmap.OpcionesAtlas opAt = new atlasHashmap.OpcionesAtlas();
        String pais, capital;
        boolean verif;
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion=0;
        boolean ident=false;
        System.out.print("\n\tPROGRAMA ATLAS\n\t==============\n\n1) Añadir una entrada al atlas\n2) Mostrar el contenido actual del atlas\n3) Buscar una entrada del atlas\n4) Modificar una entrada del atlas\n5) Eliminar una entrada del atlas\n6) Eliminar el contenido completo del atlas\n7) Salir\n\n");


        while (!salir) {

            try {

                System.out.print("\nTeclea una de las opciones: ");
                opcion = teclado.nextInt();
                teclado.nextLine();
                System.out.println("");

                switch (opcion) {

                    case 1:
                        System.out.print("Teclea un País: ");
                        pais = teclado.next();
                        System.out.print("Teclea su Capital: ");
                        capital = teclado.next();
                        opAt.entrada(pais, capital);
                        break;

                    case 2:
                        opAt.mostrar();
                        break;

                    case 3:
                        System.out.print("Teclea un País: ");
                        pais = teclado.next();
                        verif = opAt.verificar(pais);
                        if (verif==true) {
                            opAt.buscar(pais);
                        }
                        break;

                    case 4:
                        System.out.print("Teclea un País: ");
                        pais = teclado.next();
                        verif = opAt.verificar(pais);
                        if (verif==true) {
                            System.out.print("Teclea una modificación de Capital: ");
                            capital = teclado.next();
                            opAt.replace(pais, capital);
                        }
                        break;

                    case 5:
                        System.out.print("Teclea un País a eliminar: ");
                        pais = teclado.next();
                        verif = opAt.verificar(pais);
                        if (verif==true) {
                            opAt.remove(pais);
                        }
                        break;

                    case 6:
                        opAt.clear();
                        break;

                    case 7:
                        System.exit(0);
                        break;

                    default:
                        throw new InputMismatchException("Unknown enumeration value " + opcion);
                        //System.out.println("Esta opción no está disponible");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes teclear un número entero");
                teclado.next();
            }
        }
    }
}
