package act11;

public class Main {

    public static void main(String[] args) {
        int numeroAdivinar = 1 + (int) (10 * Math.random());
        System.out.println("Número a adivinar: " + numeroAdivinar);
        Arbitro arbitro = new Arbitro(3, numeroAdivinar, 1);

        while (true) {

            Jugador jugador1 = new Jugador(1, arbitro);
            Jugador jugador2 = new Jugador(2, arbitro);
            Jugador jugador3 = new Jugador(3, arbitro);

            jugador1.start();
            jugador2.start();
            jugador3.start();

            try {
                jugador1.join();jugador2.join();jugador3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
