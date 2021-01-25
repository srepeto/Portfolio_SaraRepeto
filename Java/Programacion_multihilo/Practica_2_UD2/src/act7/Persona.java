package act7;

public class Persona extends Thread {
    String nombre;
    Cuenta cuenta;

    public Persona (String nombre, Cuenta cuenta) {
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    public void run() {
        for (int i = 0; i < 4; i++) {
            if (i%2 == 0) {
                float cantidadSuma = (float) (Math.random()*500+1);
                cuenta.ingreso(cantidadSuma, nombre);
            } else {
                float cantidadResta = (float) (Math.random()*500+1);
                cuenta.reintegro(cantidadResta, nombre);
            }
        }
    }
}
