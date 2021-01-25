package act10;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Cola cola = new Cola();

            try {
                FileReader fichero = new FileReader("res/fichero1.txt");
                Productor productor = new Productor("Productor1", fichero, cola);
                Consumidor consumidor = new Consumidor("Consumidor1", cola, productor);
                productor.start();
                consumidor.start();
            } catch (FileNotFoundException e) {
                System.out.println("No se ha encontrado el fichero");
            }
    }

}
