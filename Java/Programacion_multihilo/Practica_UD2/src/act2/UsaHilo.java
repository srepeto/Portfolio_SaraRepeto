package act2;

public class UsaHilo {

    public static void main(String[] args) {
        /*Hilo h1 = new Hilo("Hilo1");
        Hilo h2 = new Hilo("Hilo2");
        Hilo h3 = new Hilo("Hilo3");
        Hilo h4 = new Hilo("Hilo4");
        Hilo h5 = new Hilo("Hilo5");

        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);
        Thread t3 = new Thread(h3);
        Thread t4 = new Thread(h4);
        Thread t5 = new Thread(h5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();*/

        new Thread(new Hilo("Hilo1")).start();
        new Thread(new Hilo("Hilo2")).start();
        new Thread(new Hilo("Hilo3")).start();
        new Thread(new Hilo("Hilo4")).start();
        new Thread(new Hilo("Hilo5")).start();



    }

}
