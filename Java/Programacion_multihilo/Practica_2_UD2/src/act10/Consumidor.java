package act10;

public class Consumidor extends Thread{
    Productor productor;
    Cola cola;

    public Consumidor (String nombre, Cola cola, Productor productor) {
        setName(nombre);
        this.cola = cola;
        this.productor = productor;
    }

    public void run() {
        try {
            sleep(100);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        while (productor.getState()!=Thread.State.TERMINATED) {
            char letra = cola.get();
            System.out.println("El consumidor consume: " + letra);
            System.out.println(productor.getState());
        }
        System.out.println("Consumidor finalizado");
    }
}
