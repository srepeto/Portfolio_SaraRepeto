package act10;

public class Cola {
    char letraEnCola;
    boolean disponibleParaConsumir = false; // la cola empieza vacía

    public synchronized char get () {
        while (!disponibleParaConsumir) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Se ha producido una excepción en el wait");
            }
        }
        disponibleParaConsumir = false;
        notify();
        return letraEnCola;
    }

    public synchronized void put (char letra) {
        while (disponibleParaConsumir) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Se ha producido una excepción en el wait");
            }
        }
        letraEnCola = letra;
        disponibleParaConsumir = true;
        notify();
    }

}
