package practica_2_ud2_act9;

import com.formdev.flatlaf.FlatDarculaLaf;
import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;

public class Ventana extends javax.swing.JFrame {
    Hilo hilo1;
    Hilo hilo2;

    public Ventana() {
        setResizable(false);
        setTitle("EJECUTAR E INTERRUMPIR HILOS");
        setLocationRelativeTo(null);
        cambiarLookAndFeel();
        initComponents();
        botFinalizar.setEnabled(false);
        botIntHilo1.setEnabled(false);
        botIntHilo2.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botComenzar = new javax.swing.JButton();
        fieldHilo1 = new javax.swing.JTextField();
        fieldHilo2 = new javax.swing.JTextField();
        labelHilo2 = new javax.swing.JLabel();
        labelHilo1 = new javax.swing.JLabel();
        botFinalizar = new javax.swing.JButton();
        botIntHilo1 = new javax.swing.JButton();
        botIntHilo2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botComenzar.setText("Comenzar proceso");
        botComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botComenzarActionPerformed(evt);
            }
        });

        fieldHilo1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldHilo1.setText("0");
        fieldHilo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldHilo1ActionPerformed(evt);
            }
        });

        fieldHilo2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldHilo2.setText("0");
        fieldHilo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldHilo2ActionPerformed(evt);
            }
        });

        labelHilo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHilo2.setText("HILO 2");

        labelHilo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHilo1.setText("HILO 1");

        botFinalizar.setText("Finalizar Proceso");
        botFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botFinalizarActionPerformed(evt);
            }
        });

        botIntHilo1.setText("Interrumpir");
        botIntHilo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botIntHilo1ActionPerformed(evt);
            }
        });

        botIntHilo2.setText("Interrumpir");
        botIntHilo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botIntHilo2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelHilo1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addGap(151, 151, 151)
                        .addComponent(labelHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botIntHilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botIntHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(botComenzar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(botFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(fieldHilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177)
                        .addComponent(fieldHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(botComenzar)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botIntHilo1)
                    .addComponent(botIntHilo2))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldHilo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHilo2)
                    .addComponent(labelHilo1))
                .addGap(18, 18, 18)
                .addComponent(botFinalizar)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botIntHilo1ActionPerformed(java.awt.event.ActionEvent evt) {
        hilo1.interrumpir();
    }

    private void botIntHilo2ActionPerformed(java.awt.event.ActionEvent evt) {
        hilo2.interrumpir();
    }

    private void botComenzarActionPerformed(java.awt.event.ActionEvent evt) {
        botIntHilo1.setEnabled(true);
        botIntHilo2.setEnabled(true);
        botFinalizar.setEnabled(true);
        botComenzar.setEnabled(false);

        hilo1 = new Hilo("HILO 1", 500, fieldHilo1, labelHilo1);
        hilo2 = new Hilo("HILO 2", 500, fieldHilo2, labelHilo2);

        hilo1.start();
        hilo2.start();
    }

    private void fieldHilo1ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void fieldHilo2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
    }

    private void botFinalizarActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Valor final del contador del HILO 1: " + hilo1.getContador());
        System.out.println("Valor final del contador del HILO 2: " + hilo2.getContador());

        labelHilo1.setText("HILO 1");
        labelHilo2.setText("HILO 2");
        botComenzar.setEnabled(true);
        botFinalizar.setEnabled(false);
        botIntHilo1.setEnabled(false);
        botIntHilo2.setEnabled(false);

        hilo1.finalizarProceso();
        hilo2.finalizarProceso();
    }


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
        //</editor-fold>

        /* Create and display the form */
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
    private javax.swing.JButton botComenzar;
    private javax.swing.JButton botFinalizar;
    private javax.swing.JButton botIntHilo1;
    private javax.swing.JButton botIntHilo2;
    private javax.swing.JTextField fieldHilo1;
    private javax.swing.JTextField fieldHilo2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelHilo1;
    private javax.swing.JLabel labelHilo2;
    // End of variables declaration//GEN-END:variables

}

