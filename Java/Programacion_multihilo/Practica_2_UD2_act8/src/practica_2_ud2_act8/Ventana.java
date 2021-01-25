package practica_2_ud2_act8;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Ventana extends javax.swing.JFrame {
    Hilo hilo1;
    Hilo hilo2;

    public Ventana() {
        setResizable(false);
        setTitle("EJECUTAR, SUSPENDER Y REANUDAR HILOS");
        setLocationRelativeTo(null);
        cambiarLookAndFeel();
        initComponents();
        botFinalizar.setEnabled(false);
        botRHilo1.setEnabled(false);
        botRHilo2.setEnabled(false);
        botSHilo1.setEnabled(false);
        botSHilo2.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botComenzar = new javax.swing.JButton();
        botRHilo1 = new javax.swing.JButton();
        botRHilo2 = new javax.swing.JButton();
        botSHilo1 = new javax.swing.JButton();
        botSHilo2 = new javax.swing.JButton();
        fieldHilo1 = new javax.swing.JTextField();
        fieldHilo2 = new javax.swing.JTextField();
        labelHilo2 = new javax.swing.JLabel();
        labelHilo1 = new javax.swing.JLabel();
        botFinalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botComenzar.setText("Comenzar proceso");
        botComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botComenzarActionPerformed(evt);
            }
        });

        botRHilo1.setText("Reanudar");
        botRHilo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botRHilo1ActionPerformed(evt);
            }
        });

        botRHilo2.setText("Reanudar");
        botRHilo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botRHilo2ActionPerformed(evt);
            }
        });

        botSHilo1.setText("Suspender");
        botSHilo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botSHilo1ActionPerformed(evt);
            }
        });

        botSHilo2.setText("Suspender");
        botSHilo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botSHilo2ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(botRHilo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botRHilo2)
                .addGap(74, 74, 74))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(botSHilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(botSHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(botFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(botComenzar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldHilo1, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(labelHilo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldHilo2, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(labelHilo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(73, 73, 73))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(botComenzar)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botRHilo1)
                    .addComponent(botRHilo2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botSHilo1)
                    .addComponent(botSHilo2))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldHilo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHilo2)
                    .addComponent(labelHilo1))
                .addGap(18, 18, 18)
                .addComponent(botFinalizar)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botComenzarActionPerformed(java.awt.event.ActionEvent evt) {
        botRHilo1.setEnabled(true);
        botRHilo2.setEnabled(true);
        botSHilo1.setEnabled(true);
        botSHilo2.setEnabled(true);
        botFinalizar.setEnabled(true);
        botComenzar.setEnabled(false);

        hilo1 = new Hilo("HILO 1", 500, fieldHilo1, labelHilo1);
        hilo2 = new Hilo("HILO 2", 500, fieldHilo2, labelHilo2);

        hilo1.start();
        hilo2.start();
    }

    private void botRHilo1ActionPerformed(java.awt.event.ActionEvent evt) {
        hilo1.reanudar();
    }

    private void botRHilo2ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        hilo2.reanudar();
    }

    private void botSHilo1ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        hilo1.suspender();
    }

    private void botSHilo2ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        hilo2.suspender();
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
        botRHilo1.setEnabled(false);
        botRHilo2.setEnabled(false);
        botSHilo1.setEnabled(false);
        botSHilo2.setEnabled(false);
        botComenzar.setEnabled(true);
        botFinalizar.setEnabled(false);

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
    private javax.swing.JButton botRHilo1;
    private javax.swing.JButton botRHilo2;
    private javax.swing.JButton botSHilo1;
    private javax.swing.JButton botSHilo2;
    private javax.swing.JTextField fieldHilo1;
    private javax.swing.JTextField fieldHilo2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelHilo1;
    private javax.swing.JLabel labelHilo2;
    // End of variables declaration//GEN-END:variables

}

