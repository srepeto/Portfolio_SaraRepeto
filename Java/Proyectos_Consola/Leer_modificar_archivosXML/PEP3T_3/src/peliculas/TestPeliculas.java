package peliculas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestPeliculas {

    public static void main(String[] args) {
        peliculasXML pel = new peliculasXML();
        Scanner sc = new Scanner(System.in);
        int option;
        int optionSec;

        while (true) {
            pel.menuOP1();
            try {
                System.out.print("Opción: ");
                option = sc.nextInt();
                System.out.println("");

                switch (option) {
                    case 1:
                        pel.presentarXML();
                        break;
                    case 2:
                        System.out.println("¿Dónde quiere ubicar el nuevo nodo?");
                        pel.menuOp2();
                        System.out.print("Opción: ");
                        optionSec = sc.nextInt();
                        while (optionSec<1 || optionSec>3) {
                            System.out.println("Esta opción no está disponible\n");
                            System.out.print("Opción: ");
                            optionSec = sc.nextInt();
                        }
                        System.out.println("");
                        pel.addNode(optionSec);
                        break;
                    case 3:
                        System.out.println("¿Dónde se ubica el nodo a modificar?");
                        pel.menuOp2();
                        System.out.print("Opción: ");
                        optionSec = sc.nextInt();
                        while (optionSec<1 || optionSec>3) {
                            System.out.println("Esta opción no está disponible\n");
                            System.out.print("Opción: ");
                            optionSec = sc.nextInt();
                        }
                        System.out.println("");
                        pel.modifyNode(optionSec);
                        break;
                    case 4:
                        System.out.println("¿Dónde se ubica el nodo a eliminar?");
                        pel.menuOp2();
                        System.out.print("Opción: ");
                        optionSec = sc.nextInt();
                        while (optionSec<1 || optionSec>3) {
                            System.out.println("Esta opción no está disponible\n");
                            System.out.print("Opción: ");
                            optionSec = sc.nextInt();
                        }
                        System.out.println("");
                        pel.deleteNode(optionSec);
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Esta opción no está disponible\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("\nDebes teclear un número entero\n");
                sc.next();
            }

        }

    }

}
