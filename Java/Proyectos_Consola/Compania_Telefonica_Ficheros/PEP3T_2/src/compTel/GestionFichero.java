package compTel;

import java.io.*;
import java.util.Scanner;

public class GestionFichero {
    Scanner teclado = new Scanner(System.in);
    static RandomAccessFile fichero = null;
    int numAb;
    float valorFact;
    String nombre;

    public void menuOpciones () {
        System.out.println("\t\nMenú de Opciones");
        System.out.println("================");
        System.out.println("1) Alta de nuevas facturas");
        System.out.println("2) Modificación del valor de factura");
        System.out.println("3) Consulta del dato de facturación de un abonado");
        System.out.println("4) Consulta del dato de facturación total de la compañía");
        System.out.println("5) Eliminar el fichero");
        System.out.println("6) Salir\n");
    }

    public void pedirDatosAlta () {
        System.out.println("Alta de factura");
        System.out.print("Número del abonado: ");
        numAb = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Nombre: ");
        nombre = teclado.nextLine();
        System.out.print("Valor de la factura: ");
        valorFact = teclado.nextFloat();
    }

    public void grabarDatos () {
        FileOutputStream fos = null;
        DataOutputStream salida = null;
        try {
            fos = new FileOutputStream("src/facturas.dat", true);
            salida = new DataOutputStream(fos);
            salida.writeInt(numAb);
            salida.writeUTF(nombre);
            salida.writeFloat(valorFact);
            System.out.println("\t\nDatos incorporados al fichero\n");
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (salida != null) {
                    salida.close();
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
    }

    public void modificarFactura () {
        System.out.println("Modificación del valor de factura\n");
        System.out.print("Número del abonado: ");
        int num = teclado.nextInt();
        long position;
        boolean found=false;
        try {
            fichero = new RandomAccessFile("src/facturas.dat", "rw");
            fichero.seek(fichero.getFilePointer());
            while (true) {
                numAb = fichero.readInt();
                fichero.readUTF();
                if (num==numAb) {
                    position = fichero.getFilePointer();
                    System.out.print("\tValor de la factura: ");
                    valorFact = fichero.readFloat();
                    System.out.println(valorFact+"€");
                    System.out.print("Nuevo valor de la factura: ");
                    fichero.seek(position);
                    valorFact = teclado.nextFloat();
                    fichero.writeFloat(valorFact);
                    System.out.println("\tDato modificado en el fichero");
                    found=true;
                } else {
                    fichero.readFloat();
                }
            }
        } catch (EOFException eofe) { //Por si llega al final del fichero
        } catch (FileNotFoundException fnfe) { //Por si no encuentra el fichero
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) { //Por si alguien intenta escribir en un fichero de sólo lectura
            System.out.println(ioe.getMessage());
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException eio) {
                System.out.println(eio.getMessage());
            }
        }
        if (found==false) {
            System.out.println("\nAbonado no registrado");
        }
    }

    public void consultarFactura () {
        System.out.println("Consulta facturación abonado\n");
        System.out.print("Número del abonado: ");
        int num = teclado.nextInt();
        boolean found=false;
        try {
            fichero = new RandomAccessFile("src/facturas.dat", "r");
            fichero.seek(fichero.getFilePointer());
            while (true) {
                numAb = fichero.readInt();
                fichero.readUTF();
                if (num==numAb) {
                    System.out.print("\tValor de la factura: ");
                    valorFact = fichero.readFloat();
                    System.out.println(valorFact+"€");
                    found=true;
                } else {
                    fichero.readFloat();
                }
            }
        } catch (EOFException eofe) { //Por si llega al final del fichero
        } catch (FileNotFoundException fnfe) { //Por si no encuentra el fichero
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) { //Por si alguien intenta escribir en un fichero de sólo lectura
            System.out.println(ioe.getMessage());
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException eio) {
                System.out.println(eio.getMessage());
            }
        }
        if (found==false) {
            System.out.println("\nAbonado no registrado");
        }
    }

    public void facturacionTotal () {
        System.out.println("Consulta facturación total");
        float resul = 0;
        try {
            fichero = new RandomAccessFile("src/facturas.dat", "r");
            fichero.seek(fichero.getFilePointer());
            while (true) {
                fichero.readInt();
                fichero.readUTF();
                resul = resul + fichero.readFloat();
            }
        } catch (EOFException eofe) { //Por si llega al final del fichero
        } catch (FileNotFoundException fnfe) { //Por si no encuentra el fichero
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) { //Por si alguien intenta escribir en un fichero de sólo lectura
            System.out.println(ioe.getMessage());
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException eio) {
                System.out.println(eio.getMessage());
            }
        }
        System.out.println("\tFacturación total: "+resul+"€");
    }

    public void eliminarFichero() {
        System.out.println("Eliminar fichero");
        File miFich = new File("src/facturas.dat");
        boolean borrado = miFich.delete();
        if (borrado) {
            System.out.println("\tFichero eliminado");
        }
        else {
            System.out.println("Problema al borrar el fichero.");
        }
    }

}
