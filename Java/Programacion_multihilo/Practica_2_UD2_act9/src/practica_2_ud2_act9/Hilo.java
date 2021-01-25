package practica_2_ud2_act9;

import javax.swing.*;

public class Hilo extends Thread {
    JTextField fieldHilo;
    int contador = 0;
    String nombre;
    int tiempoDormido;
    JLabel labelHilo;

    public Hilo (String nombre, int tiempoDormido, JTextField fieldhHilo, JLabel labelHilo) {
        this.nombre = nombre;
        this.tiempoDormido = tiempoDormido;
        this.fieldHilo = fieldhHilo;
        this.labelHilo = labelHilo;
    }

    public void run() {
        try {
            while (!isInterrupted()) {
                    contador++;
                    fieldHilo.setText("" + getContador());
                    labelHilo.setText(nombre + " corriendo");
                    sleep(tiempoDormido);
            }
        } catch (InterruptedException e) {
        System.out.println("Ha ocurrido una excepción");
        }
    }

    public int getContador() {
        return contador;
    }

    public void interrumpir () {
        labelHilo.setText(nombre + " interrumpido");
        interrupt();
    }


    public void finalizarProceso () {
        interrupt();
    }

}
