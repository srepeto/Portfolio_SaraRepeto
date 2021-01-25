package gestionNotas;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TestNotas {

    public static void main(String[] args) {

        JFrame marco = new JFrame("Ejercicio PEP3T_4 JAVA");

        //PANEL 1
        JPanel panelGestion = new JPanel();
        JLabel etiGestion = new JLabel("GESTIÓN DE LA TABLA NOTAS");

        panelGestion.add(etiGestion);

        JPanel panelCodMat = new JPanel();
        panelCodMat.setBorder(new EmptyBorder(0,-97,5,5));
        JLabel etiCodMat = new JLabel("Código Matrícula: ");
        JTextField campoCodMat = new JTextField(7);

        panelCodMat.add(etiCodMat);
        panelCodMat.add(campoCodMat);

        JPanel panelNomAsig = new JPanel();
        JLabel etiNomAsig = new JLabel("Nombre Asignatura: ");
        JTextField campoNomAsig = new JTextField(15);

        panelNomAsig.add(etiNomAsig);
        panelNomAsig.add(campoNomAsig);

        //PANEL 2
        JPanel panelNota1 = new JPanel();
        JLabel etiNota1 = new JLabel("Nota 1: ");
        JTextField campoNota1 = new JTextField(5);

        panelNota1.add(etiNota1);
        panelNota1.add(campoNota1);

        JPanel panelNota2 = new JPanel();
        JLabel etiNota2 = new JLabel("Nota 2: ");
        JTextField campoNota2 = new JTextField(5);

        panelNota2.add(etiNota2);
        panelNota2.add(campoNota2);

        //PANEL 3
        JPanel panelBotones = new JPanel();

        JButton botonIns = new JButton("Insertar");
        botonIns.setPreferredSize(new Dimension(80, 25));
        panelBotones.add(botonIns);

        JButton botonMod = new JButton("Modificar");
        botonMod.setPreferredSize(new Dimension(90, 25));
        panelBotones.add(botonMod);

        JButton botonBorrar = new JButton("Borrar");
        botonBorrar.setPreferredSize(new Dimension(80, 25));
        panelBotones.add(botonBorrar);

        JButton botonCons = new JButton("Consultar");
        botonCons.setPreferredSize(new Dimension(90, 25));
        panelBotones.add(botonCons);

        JPanel panelMensaje = new JPanel();
        JLabel etiMensaje = new JLabel();
        etiMensaje.setText("Registro modificado"); // hay que ir modificándolo
        etiMensaje.setVisible(false); // hay que ir modificándolo
        panelMensaje.add(etiMensaje);
        panelMensaje.setBorder(BorderFactory.createEmptyBorder(3, 0, 0, 0));


        //ASIGNACIÓN DE PANELES PRINCIPALES
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(5,10));
        panel1.add(panelGestion, BorderLayout.NORTH);
        panel1.add(panelCodMat, BorderLayout.CENTER);
        panel1.add(panelNomAsig, BorderLayout.SOUTH);

        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(7, 0, 0, 65));
        panel2.add(panelNota1);
        panel2.add(panelNota2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout(5,10));
        panel3.add(panelBotones, BorderLayout.NORTH);
        panel3.add(panelMensaje, BorderLayout.CENTER);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new FlowLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(panel1, BorderLayout.NORTH);
        panelPrincipal.add(panel2, BorderLayout.CENTER);
        panelPrincipal.add(panel3, BorderLayout.SOUTH);

        //EVENTOS BOTONES

        // --- Evento para el botón de insertar y modificar

        ActionListener botonInsModPulsados = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    int codMat = Integer.parseInt(campoCodMat.getText());
                    String nomAsig = campoNomAsig.getText();
                    float nota1 = Float.parseFloat(campoNota1.getText());
                    float nota2 = Float.parseFloat(campoNota2.getText());

                Acciones objBot = new Acciones(codMat, nomAsig, nota1, nota2);

                if(e.getSource() == botonIns) {
                    try {
                        if (objBot.insertar()) {
                            etiMensaje.setVisible(true);
                            etiMensaje.setText("Registro insertado");
                        } else {
                            etiMensaje.setVisible(true);
                            etiMensaje.setText("Ya existe un registro con ese código");
                        }
                    } catch (SQLException ex) {
                        etiMensaje.setText("Se ha producido un error");
                    }
                }

                    if(e.getSource() == botonMod) {
                        try {
                            if (objBot.modificar()) {
                                etiMensaje.setVisible(true);
                                etiMensaje.setText("Registro modificado");
                            } else {
                                etiMensaje.setVisible(true);
                                etiMensaje.setText("No existe ningún registro con ese código");
                            }
                        } catch (SQLException ex) {
                            etiMensaje.setText("Se ha producido un error");
                        }
                    }

                } catch (NumberFormatException nfe) {
                    etiMensaje.setVisible(true);
                    etiMensaje.setText("Formato de número incorrecto");
                }
            }
        };

        // --- Evento para el botón de borrar y consultar

        ActionListener botonElimConsPulsado = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    int codMat = Integer.parseInt(campoCodMat.getText());
                    String nomAsig = "";
                    float nota1 = 0;
                    float nota2 = 0;

                    Acciones objBot = new Acciones(codMat, nomAsig, nota1, nota2);

                    if(e.getSource() == botonBorrar) {
                        try {
                            if (objBot.eliminar()) {
                                etiMensaje.setVisible(true);
                                etiMensaje.setText("Registro eliminado");
                                campoCodMat.setText(null);
                                campoNomAsig.setText(null);
                                campoNota1.setText(null);
                                campoNota2.setText(null);
                            } else {
                                etiMensaje.setVisible(true);
                                etiMensaje.setText("No existe ningún registro con ese código");
                            }
                        } catch (SQLException ex) {
                            etiMensaje.setText("Se ha producido un error");
                        }
                    }

                    if(e.getSource() == botonCons) {
                        try {
                            if (objBot.consultar(campoNomAsig, campoNota1, campoNota2)) {
                                etiMensaje.setVisible(true);
                                etiMensaje.setText("Registro encontrado");
                            } else {
                                etiMensaje.setVisible(true);
                                etiMensaje.setText("Registro no encontrado");
                                campoNomAsig.setText(null);
                                campoNota1.setText(null);
                                campoNota2.setText(null);
                            }
                        } catch (SQLException ex) {
                            etiMensaje.setText("Se ha producido un error");
                        }
                    }

                } catch (NumberFormatException nfe) {
                    etiMensaje.setVisible(true);
                    etiMensaje.setText("Formato de número incorrecto");
                }
            }
        };

        botonIns.addActionListener(botonInsModPulsados);
        botonMod.addActionListener(botonInsModPulsados);
        botonBorrar.addActionListener(botonElimConsPulsado);
        botonCons.addActionListener(botonElimConsPulsado);

        //FINAL

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setContentPane(panelPrincipal);
        marco.setSize(450, 310);
        marco.setResizable(false);
        marco.setVisible(true);
    }

}
