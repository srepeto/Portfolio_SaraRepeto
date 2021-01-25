package act11;

public class Jugador extends Thread{
    int idJugador;
    Arbitro arbitro;
    int numero;

    public Jugador (int idJugador, Arbitro arbitro) {
        this.idJugador = idJugador;
        this.arbitro = arbitro;
    }

    public void run() {
            if (arbitro.getTurno() == idJugador) {
                numero = 1 + (int) (10 * Math.random());
                arbitro.jugar(numero, idJugador);
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                }
            }
    }


}
