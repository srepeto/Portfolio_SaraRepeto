package act2;

public class Hilo implements Runnable {
    String nombre;

    public Hilo (String nombre) {
        this.nombre = nombre;
    }

    public void run() {
        try {
            Thread.sleep(Thread.currentThread().getId()*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hola mundo: " + nombre);
    }

    //Parece que con el sleep suelen ejecutarse los hilos de forma más ordenada
}
