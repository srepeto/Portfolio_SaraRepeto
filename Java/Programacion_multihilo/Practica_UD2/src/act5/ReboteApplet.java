package act5;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReboteApplet extends Applet implements ActionListener {


    //El hilo se crea en otra clase llamada HiloContador
    class HiloContador extends Thread {
        boolean stopHilo = false;

        public void pararHilo () {
            stopHilo = true;
        }

        public void run() { //Cuando se ejecute el hilo en el start(), se ejecutará este run()
            while (!stopHilo) {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }

    }
    //Finaliza la clase HiloContador




    //Atributos de la clase Actividad3
    HiloContador hilo;
    private Font fuente;
    private Button botFin, botReanudar;
    boolean choqueDcha = false;
    boolean botFinPulsado = false;
    boolean botReanPulsado = false;
    boolean inicio = true;
    int x=1;

    //Se inician los dos hilos
    public void start() {
        hilo = new HiloContador();
        hilo.start();
    }

    //Prepara la pantalla
    public void init() {
        setBackground(Color.pink);
        add(botFin = new Button("Finalizar Hilo"));
        botFin.addActionListener(this);
        add(botReanudar = new Button("Reanudar Hilo"));
        botReanudar.addActionListener(this);
        fuente = new Font("Calibri", Font.PLAIN, 26);
    }

    //Pinta la pantalla
    public void paint(Graphics g) {
        g.clearRect(0, 0, 400, 400);
        g.setFont(fuente); // fuente

        botFin.setLocation(160,10);
        botReanudar.setLocation(155,10);

        if (x==(getSize().width-15)) { choqueDcha = true; }
        if (x==0) { choqueDcha = false; }

        if (choqueDcha) {
            x--;
        } else {
            x++;
        }

        if (inicio) {
            botReanudar.setVisible(false);
            inicio = false;
        }

        if (botFinPulsado) {
            botFin.setVisible(false);
            botReanudar.setVisible(true);
        }

        if (botReanPulsado) {
            botReanudar.setVisible(false);
            botFin.setVisible(true);
        }

        g.drawString("O", x, 100);
    }

    //Control de botones
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botFin) {
            botReanPulsado = false;
            botFinPulsado = true;
            hilo.pararHilo();
        }
        if (e.getSource() == botReanudar) {
            botFinPulsado = false;
            botReanPulsado = true;
            start();
        }
    }

}
