package act11;

public class Arbitro {
    int numJugadores;
    int turno;
    int numeroAdivinar;

    public Arbitro (int numJugadores, int numeroAdivinar, int turno) {
        this.numJugadores = numJugadores;
        this.numeroAdivinar = numeroAdivinar;
        this.turno = turno;
    }


    public int getTurno() {
        return turno;
    }

    public synchronized void jugar (int numero, int idJugador) {
        System.out.println("Le toca a Jug" + idJugador);
        System.out.println("Jugador" + idJugador + " dice: " + numero);
        if (numero == numeroAdivinar) {
            System.out.println("Jugador " + idJugador + " gana");
            System.exit(0);
        } else {
            int num = idJugador+1;
            if (num==4) {
                turno = 1;
            } else {
                turno = idJugador+1;
            }
        }
    }
}
