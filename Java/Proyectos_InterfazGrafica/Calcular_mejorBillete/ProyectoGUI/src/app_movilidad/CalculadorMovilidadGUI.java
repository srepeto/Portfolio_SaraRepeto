package app_movilidad;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;

public class CalculadorMovilidadGUI {
    final static int NUM_IMAGENES = 4;
    ImageIcon[] imagColec1 = new ImageIcon[NUM_IMAGENES];
    ImageIcon[] imagColec2 = new ImageIcon[NUM_IMAGENES];
    ImageIcon[] imagColec3 = new ImageIcon[NUM_IMAGENES];
    ImageIcon[] imagColec4 = new ImageIcon[NUM_IMAGENES];
    ImageIcon[] imagColec5 = new ImageIcon[NUM_IMAGENES];
    JPanel panelPrincipal, Estancia, Colectivo, Propuesta, Billete, imagPanel;
    JRadioButton botRadio1, botRadio2, botRadio3, botRadio4, botRadio5;
    ButtonGroup agrupBotRad;
    int colectivo, numdias, numviajes;

    //Método constructor
    public CalculadorMovilidadGUI() {
        Estancia = new JPanel();
        Colectivo = new JPanel();
        Propuesta = new JPanel();
        Billete = new JPanel();
        panelPrincipal = new JPanel();
    }

    //Este método se usa para crear el contenido de los paneles
    private void contenidoPaneles() {

        //PANEL COLECTIVO
        Colectivo.setLayout(new GridLayout(5,1));

        botRadio1 = new JRadioButton();
        botRadio1.setActionCommand( botRadio1.getText() );
        botRadio2 = new JRadioButton();
        botRadio3 = new JRadioButton();
        botRadio4 = new JRadioButton();
        botRadio5 = new JRadioButton();
        agrupBotRad = new ButtonGroup();
        botRadio1.setText("Sin descuentos");
        botRadio2.setText("Jubilados");
        botRadio3.setText("Discapacitados");
        botRadio4.setText("Parado");
        botRadio5.setText("Estudiantes");

        agrupBotRad.add(botRadio1);
        agrupBotRad.add(botRadio2);
        agrupBotRad.add(botRadio3);
        agrupBotRad.add(botRadio4);
        agrupBotRad.add(botRadio5);

        Colectivo.setPreferredSize(new Dimension(200, 200));

        botRadio1.doClick();

        Colectivo.add(botRadio1);
        Colectivo.add(botRadio2);
        Colectivo.add(botRadio3);
        Colectivo.add(botRadio4);
        Colectivo.add(botRadio5);


        //PANEL PROPUESTA
        Propuesta.setLayout(new FlowLayout());

        //Campo de texto
        JTextArea campotexto = new JTextArea();
        campotexto.setOpaque(false);
        campotexto.setEditable(false);
        campotexto.setLineWrap(true);
        campotexto.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLoweredBevelBorder(), BorderFactory
                        .createEmptyBorder(5, 5, 5, 5)));
        campotexto.setPreferredSize(new Dimension(190,70));

        //Creación de botones e iconos y enlace
        Icon icono1 = new ImageIcon(getClass().getResource("/True.png"));
        JButton boton1 = new JButton(icono1);
        boton1.setPreferredSize(new Dimension(50, 30));

        Icon icono2 = new ImageIcon(getClass().getResource("/False.png"));
        JButton boton2 = new JButton(icono2);
        boton2.setPreferredSize(new Dimension(50, 30));

        //Nuevo Panel que contendrá ambos botones
        JPanel botones = new JPanel();
        boton1.setPreferredSize(new Dimension(55,33));
        boton2.setPreferredSize(new Dimension(55,33));
        botones.add(boton1);
        botones.add(boton2);
        botones.setBorder(new EmptyBorder(30,5,5,5));

        //Se añaden al panel Propuesta
        Propuesta.add(campotexto);
        Propuesta.add(botones);


        //PANEL ESTANCIA

        //Etiqueta dias
        JLabel Dias = new JLabel();
        Dias.setText("Dias");

        //Spinner
        SpinnerNumberModel model = new SpinnerNumberModel(
                Integer.valueOf(1),
                Integer.valueOf(1),
                Integer.valueOf(366),
                Integer.valueOf(1));
        JSpinner spinr = new JSpinner(model);
        spinr.setPreferredSize(new Dimension(45,20));

        //Slider
        JSlider slider = new JSlider(0, 100, 1);
        slider.setBorder(new EmptyBorder(30,0,0,5));
        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        //Etiqueta viajes
        JLabel viajes = new JLabel();
        viajes.setBorder(new EmptyBorder(30,0,0,0));
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                viajes.setText("Viajes: " + slider.getValue());
            }
        });
        viajes.setText("Viajes: " + slider.getValue());

        //Se añaden al panel
        Estancia.add(Dias);
        Estancia.add(spinr);
        Estancia.add(slider);
        Estancia.add(viajes);


        //Propiedades de los cuatro Paneles Principales
        Estancia.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                .createTitledBorder("Estancia"), BorderFactory
                .createEmptyBorder(5, 5, 5, 5)));

        Colectivo.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                .createTitledBorder("Colectivo"), BorderFactory
                .createEmptyBorder(5, 5, 5, 5)));

        Propuesta.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                .createTitledBorder("Propuesta"), BorderFactory
                .createEmptyBorder(5, 5, 5, 5)));

        Billete.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                .createTitledBorder("Su Billete"), BorderFactory
                .createEmptyBorder(5, 5, 5, 5)));


        //PANEL BILLETE
        JPanel imagPanel= new JPanel();
        imagPanel.setBorder(new EmptyBorder(35,0,0,0));
        JLabel labImages = new JLabel();
        labImages.setPreferredSize(new Dimension(130,70));
        labImages.setVisible(true);
        Billete.add(imagPanel);

        //ACCIONES DE BOTONES

        boton1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                campotexto.setText(null); //borramos lo escrito anteriormente
                numdias=(Integer) spinr.getValue(); //numdias coge el valor del spinner
                numviajes=slider.getValue(); //numviajes coge el valor del slider

                //Con los siguientes if evaluaremos según los colectivos. Cada if funciona igual pero cada uno trabajará con valores diferentes
                if(botRadio1.isSelected())
                {
                    campotexto.append("(Sin Descuento) ");
                    colectivo=1;

                    //Con este for cogemos las imágenes, en este caso las del colectivo 1
                    for (int i = 1; i < NUM_IMAGENES; i++) {
                        String imageName = "/1_" + i + ".png";
                        ImageIcon icono = new ImageIcon(getClass().getResource(imageName));
                        imagColec1[i] = icono;
                    }

                    MetodosMov appMov = new MetodosMov(colectivo, numdias, numviajes); //Se crea el objeto
                    int billeteFinal = Integer.parseInt(appMov.calculaPreciosViaje()[1]); //Esta variable contiene la opción que ha sido seleccionada como la mejor

                    // Se obtiene la imagen que corresponde finalmente con la mejor opción y el colectivo seleccionado
                    for (int x=1; x<=billeteFinal; x++) {
                        if (billeteFinal==x) {
                            labImages.setIcon(imagColec1[x]);
                        }
                    }

                    // Se añade en el campo de texto el String que devuelve el método de mejor opción
                    campotexto.append(appMov.calculaPreciosViaje()[0]);

                }
                else if(botRadio2.isSelected())
                {
                    colectivo=2;
                    campotexto.append("(Descuento Jubilados) ");

                    for (int i = 1; i < NUM_IMAGENES; i++) {
                        String imageName = "/2_" + i + ".png";
                        ImageIcon icono = new ImageIcon(getClass().getResource(imageName));
                        imagColec2[i] = icono;
                    }

                    MetodosMov appMov = new MetodosMov(colectivo, numdias, numviajes);
                    int billeteFinal = Integer.parseInt(appMov.calculaPreciosViaje()[1]);

                    for (int x=1; x<=(billeteFinal+1); x++) {
                        if (billeteFinal==x) {
                            labImages.setIcon(imagColec2[x]);
                        }
                    }

                    campotexto.append(appMov.calculaPreciosViaje()[0]);

                }
                else if(botRadio3.isSelected())
                {
                    colectivo=3;
                    campotexto.append("(Descuento Discapacitados) ");

                    for (int i = 1; i < NUM_IMAGENES; i++) {
                        String imageName = "/3_" + i + ".png";
                        ImageIcon icono = new ImageIcon(getClass().getResource(imageName));
                        imagColec3[i] = icono;
                    }

                    MetodosMov appMov = new MetodosMov(colectivo, numdias, numviajes);
                    int billeteFinal = Integer.parseInt(appMov.calculaPreciosViaje()[1]);

                    for (int x=1; x<=(billeteFinal+1); x++) {
                        if (billeteFinal==x) {
                            labImages.setIcon(imagColec3[x]);
                        }
                    }

                    campotexto.append(appMov.calculaPreciosViaje()[0]);

                }
                else if(botRadio4.isSelected())
                {
                    colectivo=4;
                    campotexto.append("(Descuento Parados) ");

                    for (int i = 1; i < NUM_IMAGENES; i++) {
                        String imageName = "/4_" + i + ".png";
                        ImageIcon icono = new ImageIcon(getClass().getResource(imageName));
                        imagColec4[i] = icono;
                    }

                    MetodosMov appMov = new MetodosMov(colectivo, numdias, numviajes);
                    int billeteFinal = Integer.parseInt(appMov.calculaPreciosViaje()[1]);

                    for (int x=1; x<=(billeteFinal+1); x++) {
                        if (billeteFinal==x) {
                            labImages.setIcon(imagColec4[x]);
                        }
                    }

                    campotexto.append(appMov.calculaPreciosViaje()[0]);

                }
                else if(botRadio5.isSelected())
                {
                    colectivo=5;
                    campotexto.append("(Descuento Estudiantes) ");

                    for (int i = 1; i < NUM_IMAGENES; i++) {
                        String imageName = "/5_" + i + ".png";
                        ImageIcon icono = new ImageIcon(getClass().getResource(imageName));
                        imagColec5[i] = icono;
                    }

                    MetodosMov appMov = new MetodosMov(colectivo, numdias, numviajes);
                    int billeteFinal = Integer.parseInt(appMov.calculaPreciosViaje()[1]);

                    for (int x=1; x<=(billeteFinal+1); x++) {
                        if (billeteFinal==x) {
                            labImages.setIcon(imagColec5[x]);
                        }
                    }

                    campotexto.append(appMov.calculaPreciosViaje()[0]);

                }

                imagPanel.add(labImages);

            }
        });

        boton2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                campotexto.setText(null);
                imagPanel.removeAll();
                agrupBotRad.clearSelection();
                slider.setValue(1);
                spinr.setValue(1);
                botRadio1.doClick();
            }
        });

        panelPrincipal.setLayout(new GridLayout(2, 1, 5, 5));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(Estancia);
        panelPrincipal.add(Colectivo);
        panelPrincipal.add(Propuesta);
        panelPrincipal.add(Billete);

    }

    public static void main(String[] args) {
        CalculadorMovilidadGUI objGUI = new CalculadorMovilidadGUI();
        JFrame marco = new JFrame("Aplicacion de movilidad");
        marco.setPreferredSize(new Dimension(430, 400));
        marco.setContentPane(objGUI.panelPrincipal);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(455, 455);
        marco.setVisible(true);
        marco.setResizable(false);
        objGUI.contenidoPaneles();
    }

}