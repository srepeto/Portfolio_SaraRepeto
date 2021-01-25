package practica_2_ud2_act8;

import javax.swing.*;

public class Hilo extends Thread {
    JTextField fieldHilo;
    int contador = 0;
    String nombre;
    int tiempoDormido;
    JLabel labelHilo;
    boolean hiloParado = false;
    SolicitaSuspender solicSusp = new SolicitaSuspender();

    public Hilo (String nombre, int tiempoDormido, JTextField fieldhHilo, JLabel labelHilo) {
        this.nombre = nombre;
        this.tiempoDormido = tiempoDormido;
        this.fieldHilo = fieldhHilo;
        this.labelHilo = labelHilo;
    }

    public void run() {
        while (true) {
            while (!hiloParado) {
                try {
                    solicSusp.esperandoParaReanudar(); //comprobar si la booleana suspender es true para suspenderlo
                    contador++;
                    fieldHilo.setText("" + getContador());
                    labelHilo.setText(nombre + " corriendo");
                    sleep(tiempoDormido);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getContador() {
        return contador;
    }

    public void suspender () {
        solicSusp.set(true);
        labelHilo.setText(nombre + " suspendido");
    }

    public void reanudar () {
        solicSusp.set(false);
    }

    public void finalizarProceso () {
        hiloParado = true;
    }

}
