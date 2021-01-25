package carreraHilos;

import com.formdev.flatlaf.*;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.*;


public class Ventana extends javax.swing.JFrame {

    public Ventana() {
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("PrácticaUD2_act6_SaraRepeto");
        initComponents();
        cambiarLookAndFeel();

        // Labels del slider
        Hashtable<Integer, JLabel> labels = new Hashtable<>();
        labels.put(1, new JLabel("1"));
        labels.put(5, new JLabel("5"));
        labels.put(10, new JLabel("10"));
        sliderHilo1.setLabelTable(labels);
        sliderHilo2.setLabelTable(labels);
        sliderHilo3.setLabelTable(labels);        
                
        // Evento que toma el valor del slider en todo momento
        ChangeListener changeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                prioridadHilo1.setText("Prioridad: " + sliderHilo1.getValue());
                prioridadHilo2.setText("Prioridad: " + sliderHilo2.getValue());
                prioridadHilo3.setText("Prioridad: " + sliderHilo3.getValue());                                           
            }
        };
        
        // Se añade el evento a los sliders
        sliderHilo1.addChangeListener(changeListener);
        sliderHilo2.addChangeListener(changeListener);
        sliderHilo3.addChangeListener(changeListener);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        botCarrera = new javax.swing.JButton();
        sliderHilo1 = new javax.swing.JSlider();
        barraHilo1 = new javax.swing.JProgressBar();
        sliderHilo2 = new javax.swing.JSlider();
        barraHilo2 = new javax.swing.JProgressBar();
        sliderHilo3 = new javax.swing.JSlider();
        barraHilo3 = new javax.swing.JProgressBar();
        prioridadHilo1 = new javax.swing.JLabel();
        prioridadHilo2 = new javax.swing.JLabel();
        prioridadHilo3 = new javax.swing.JLabel();
        fieldHilo1 = new javax.swing.JTextField();
        fieldHilo2 = new javax.swing.JTextField();
        fieldHilo3 = new javax.swing.JTextField();
        labelGanador = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botCarrera.setText("Comenzar Carrera");
        botCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCarreraActionPerformed(evt);
            }
        });

        sliderHilo1.setMaximum(10);
        sliderHilo1.setMinimum(1);
        sliderHilo1.setMinorTickSpacing(1);
        sliderHilo1.setPaintLabels(true);
        sliderHilo1.setToolTipText("");
        sliderHilo1.setValue(5);

        sliderHilo2.setMaximum(10);
        sliderHilo2.setMinimum(1);
        sliderHilo2.setMinorTickSpacing(1);
        sliderHilo2.setPaintLabels(true);
        sliderHilo2.setToolTipText("");
        sliderHilo2.setValue(5);

        sliderHilo3.setMaximum(10);
        sliderHilo3.setMinimum(1);
        sliderHilo3.setMinorTickSpacing(1);
        sliderHilo3.setPaintLabels(true);
        sliderHilo3.setToolTipText("");
        sliderHilo3.setValue(5);

        prioridadHilo1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        prioridadHilo1.setText("Prioridad: 5");

        prioridadHilo2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        prioridadHilo2.setText("Prioridad: 5");

        prioridadHilo3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        prioridadHilo3.setText("Prioridad: 5");

        fieldHilo1.setEditable(false);
        fieldHilo1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldHilo1.setText("0");
        fieldHilo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldHilo1ActionPerformed(evt);
            }
        });

        fieldHilo2.setEditable(false);
        fieldHilo2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldHilo2.setText("0");
        fieldHilo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldHilo2ActionPerformed(evt);
            }
        });

        fieldHilo3.setEditable(false);
        fieldHilo3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldHilo3.setText("0");
        fieldHilo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldHilo3ActionPerformed(evt);
            }
        });

        labelGanador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGanador.setText("GANADOR");

        jLabel1.setText("HILO 1");

        jLabel8.setText("HILO 2");

        jLabel10.setText("HILO 3");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(fieldHilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelGanador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldHilo2, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                        .addGap(66, 66, 66)
                        .addComponent(fieldHilo3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(barraHilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sliderHilo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(prioridadHilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(barraHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sliderHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(42, 42, 42)
                            .addComponent(prioridadHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(barraHilo3, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sliderHilo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(39, 39, 39)
                            .addComponent(prioridadHilo3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(botCarrera)
                .addGap(26, 26, 26)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sliderHilo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(prioridadHilo1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraHilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sliderHilo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(prioridadHilo2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sliderHilo3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(prioridadHilo3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraHilo3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldHilo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldHilo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelGanador)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldHilo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldHilo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldHilo3ActionPerformed

    private void fieldHilo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldHilo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldHilo2ActionPerformed

    private void fieldHilo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldHilo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldHilo1ActionPerformed

    private void botCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCarreraActionPerformed
        botCarrera.setEnabled(false);
        
        barraHilo1.setValue(0);
        barraHilo2.setValue(0);
        barraHilo3.setValue(0);
        
        Hilo1 hilo1 = new Hilo1((int) Math.random()*1000+1);
        Hilo2 hilo2 = new Hilo2((int) Math.random()*1000+1);
        Hilo3 hilo3 = new Hilo3((int) Math.random()*1000+1);
        
        hilo1.setPriority(sliderHilo1.getValue());
        hilo2.setPriority(sliderHilo2.getValue());
        hilo3.setPriority(sliderHilo3.getValue());  
        
        hilo1.start();
        hilo2.start();
        hilo3.start();       
    }//GEN-LAST:event_botCarreraActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });  

    }
    
    // Cambio de aparencia de la ventana con un nuevo Look And Feel
    private void cambiarLookAndFeel () {
        try {
            UIManager.setLookAndFeel(FlatDarculaLaf.class.getCanonicalName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Throwable e) {
            JOptionPane.showConfirmDialog(this, "Error estableciendo LookAndFeel");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraHilo1;
    private javax.swing.JProgressBar barraHilo2;
    private javax.swing.JProgressBar barraHilo3;
    private javax.swing.JButton botCarrera;
    private javax.swing.JTextField fieldHilo1;
    private javax.swing.JTextField fieldHilo2;
    private javax.swing.JTextField fieldHilo3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel labelGanador;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel prioridadHilo1;
    private javax.swing.JLabel prioridadHilo2;
    private javax.swing.JLabel prioridadHilo3;
    private javax.swing.JSlider sliderHilo1;
    private javax.swing.JSlider sliderHilo2;
    private javax.swing.JSlider sliderHilo3;
    // End of variables declaration//GEN-END:variables
    
    
    
    // Clase del Hilo 1
    private class Hilo1 extends Thread { 
        int tiempoDormido;
    
        public Hilo1(int tiempoDormido){
            this.tiempoDormido = tiempoDormido;
        }
        
        public void run(){
            for(int i =0; i< 101; i++){
                if (!comprobarVictoria()) {
                    int contador = i;
                    barraHilo1.setValue(contador);
                    fieldHilo1.setText(""+  contador);
                    try {
                       sleep(tiempoDormido);
                    } catch (InterruptedException e) {}
                }
            }
        }
        
    }   
    
    // Clase del Hilo 2
    private class Hilo2 extends Thread { 
        int tiempoDormido;
    
        public Hilo2(int tiempoDormido){
            this.tiempoDormido = tiempoDormido;
        }
        
        public void run(){
            for(int i =0; i< 101; i++){
                if (!comprobarVictoria()) {
                    int contador = i;
                    barraHilo2.setValue(contador);
                    fieldHilo2.setText(""+  contador);
                    try {
                       sleep(tiempoDormido);
                    } catch (InterruptedException e) {}
                }
            }
        }        
    }
    
    
    // Clase del Hilo 3
    private class Hilo3 extends Thread { 
        int tiempoDormido;
    
        public Hilo3(int tiempoDormido){
            this.tiempoDormido = tiempoDormido;
        }
        
        public void run(){
            for(int i =0; i< 101; i++){
                if (!comprobarVictoria()) {
                    int contador = i;
                    barraHilo3.setValue(contador);
                    fieldHilo3.setText(""+  contador);
                    try {
                       sleep(tiempoDormido);
                    } catch (InterruptedException e) {}
                }
            }
        }        
    }
        
    
    // Método para comprobar quién es el ganador
    public boolean comprobarVictoria () {                
        if (barraHilo1.getValue()==100) {
            labelGanador.setText("GANA HILO 1");
            botCarrera.setEnabled(true);
            return true;
        } else if (barraHilo2.getValue()==100) {
            labelGanador.setText("GANA HILO 2");
            botCarrera.setEnabled(true);
            return true;
        } else if (barraHilo3.getValue()==100) {
            labelGanador.setText("GANA HILO 3");
            botCarrera.setEnabled(true);
            return true;
        } else {
            return false;
        }
    }

    
}


// El hilo de máxima prioridad no es el que gana siempre, la influencia de las prioridades es baja
