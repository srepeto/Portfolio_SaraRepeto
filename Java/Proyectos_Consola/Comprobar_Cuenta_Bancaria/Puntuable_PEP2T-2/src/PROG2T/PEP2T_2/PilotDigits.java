package PROG2T.PEP2T_2;
import java.util.Scanner;

public class PilotDigits {

    public static void main(String[] args) {
        DigiIban ibanConObj = new DigiIban();
        DigiControl digConObj = new DigiControl();
        String digBanco, digSucursal, digCuenta, digControl, fdigControl, digitosIBAN, fdigitosIBAN, digTotal;
        Scanner teclado = new Scanner(System.in);
        int opcion;
        boolean salir=false;

        while (!salir) {

            System.out.print("\n\tMenú de opciones\n\t================\n\n1) Generar dígitos de control\n2) Validación de dígitos de control\n3) Generar dígitos de IBAN\n4) Validación de dígitos de IBAN\n5) Salir\n\n\tOpción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();
            System.out.println("");

            switch (opcion) {
                case 1:
                    System.out.print("Introduzca los 4 dígitos referentes al Banco: ");
                    digBanco = teclado.nextLine();
                    System.out.print("Introduzca los 4 dígitos referentes a la Sucursal: ");
                    digSucursal = teclado.nextLine();
                    System.out.print("Introduzca los 10 dígitos referentes a su Cuenta: ");
                    digCuenta = teclado.nextLine();

                    fdigControl = digConObj.generarDC(digBanco, digSucursal, digCuenta);
                    System.out.println("\n" + digBanco + " " + digSucursal + " DC1DC2 " + digCuenta + "\t-> " + digBanco + " " + digSucursal + " " + fdigControl + " " + digCuenta);
                    break;

                case 2:
                    System.out.print("Introduzca los 4 dígitos referentes al Banco: ");
                    digBanco = teclado.nextLine();
                    System.out.print("Introduzca los 4 dígitos referentes a la Sucursal: ");
                    digSucursal = teclado.nextLine();
                    System.out.print("Introduzca los 2 dígitos de control: ");
                    digControl = teclado.nextLine();
                    System.out.print("Introduzca los 10 dígitos referentes a su Cuenta: ");
                    digCuenta = teclado.nextLine();

                    System.out.println("\nNúmero de cuenta a validar: " + digBanco + " " + digSucursal + " " + digControl + " " + digCuenta);
                    fdigControl = digConObj.generarDC(digBanco, digSucursal, digCuenta);
                    digConObj.validacion(digBanco, digSucursal, digControl, digCuenta, fdigControl);
                    break;

                case 3:
                    System.out.print("Introduzca los 4 dígitos referentes al Banco: ");
                    digBanco = teclado.nextLine();
                    System.out.print("Introduzca los 4 dígitos referentes a la Sucursal: ");
                    digSucursal = teclado.nextLine();
                    System.out.print("Introduzca los 2 dígitos de control: ");
                    digControl = teclado.nextLine();
                    System.out.print("Introduzca los 10 dígitos referentes a su Cuenta: ");
                    digCuenta = teclado.nextLine();

                    digTotal = digBanco + digSucursal + digControl + digCuenta + 142800;
                    digitosIBAN = ibanConObj.generaIBAN(digTotal);
                    System.out.println("\n\t\t\tES" + digitosIBAN + " " + digBanco + " " + digSucursal + " " + digControl + " " + digCuenta);
                    break;

                case 4:
                    System.out.print("Introduzca los 4 dígitos referentes al IBAN: ");
                    digitosIBAN = teclado.nextLine();
                    System.out.print("Introduzca los 4 dígitos referentes al Banco: ");
                    digBanco = teclado.nextLine();
                    System.out.print("Introduzca los 4 dígitos referentes a la Sucursal: ");
                    digSucursal = teclado.nextLine();
                    System.out.print("Introduzca los 2 dígitos de control: ");
                    digControl = teclado.nextLine();
                    System.out.print("Introduzca los 10 dígitos referentes a su Cuenta: ");
                    digCuenta = teclado.nextLine();
                    System.out.println("\nNúmero de cuenta a validar: "+ digitosIBAN + " " + digBanco + " " + digSucursal + " " + digControl + " " + digCuenta);

                    digTotal = digBanco + digSucursal + digControl + digCuenta + 142800;
                    fdigitosIBAN = ibanConObj.generaIBAN(digTotal);
                    ibanConObj.validacionIBAN(digitosIBAN, fdigitosIBAN);
                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Esta opción no está disponible");
            }
        }
    }
}
