package act1;

public class Hilo extends Thread {

    public Hilo (String nombre) {
        setName(nombre);
    }

    public void run() {
        System.out.println(getName() + ": Hola mundo");
    }
}
