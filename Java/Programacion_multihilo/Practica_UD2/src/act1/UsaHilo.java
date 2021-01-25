package act1;

public class UsaHilo {

    public static void main(String[] args) {
        Hilo h1 = new Hilo("Hilo1");
        Hilo h2 = new Hilo("Hilo2");
        Hilo h3 = new Hilo("Hilo3");
        Hilo h4 = new Hilo("Hilo4");
        Hilo h5 = new Hilo("Hilo5");

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
    }

}
