package compTel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestGestion {

    public static void main(String[] args) {

        GestionFichero gestFich = new GestionFichero();
        Scanner teclado = new Scanner(System.in);
        int opcion;
        System.out.println("PROGRAMA GESTIÓN COMPAÑÍA TELEFÓNICA");

        while (true) {

            try {

                gestFich.menuOpciones();
                System.out.print("\tOpción: ");
                opcion = teclado.nextInt();
                System.out.println("");

                switch (opcion) {
                    case 1:
                        gestFich.pedirDatosAlta();
                        gestFich.grabarDatos();
                        break;
                    case 2:
                        gestFich.modificarFactura();
                        break;
                    case 3:
                        gestFich.consultarFactura();
                        break;
                    case 4:
                        gestFich.facturacionTotal();
                        break;
                    case 5:
                        gestFich.eliminarFichero();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Esta opción no está disponible");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nDebes teclear un número entero");
                teclado.next();
            }
        }
    }

}
