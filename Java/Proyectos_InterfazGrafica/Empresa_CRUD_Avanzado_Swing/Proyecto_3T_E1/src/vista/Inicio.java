package vista;

import com.formdev.flatlaf.*;
import controlador.TestGestionSAFA;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Inicio extends Component {

    public void inicioGUI () {

        JFrame marco = new JFrame("SAFA-Ntra. Sra. de los Reyes");
        marco.setUndecorated(false);
        cambiarLookAndFeel();

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new FlowLayout());
        panelPrincipal.setBorder(new EmptyBorder(0,-15,0,0));

        JLabel etiGestion = new JLabel("GESTIÓN SAFA FCT");
        etiGestion.setBorder(new EmptyBorder(5, 45, 5, 45));

        Icon logoSAFA = new ImageIcon(TestGestionSAFA.class.getResource("/Logo_SAFA.png"));
        JLabel etiLogoSAFA = new JLabel(logoSAFA);
        etiLogoSAFA.setBorder(new EmptyBorder(70, 40, 5, 40));

        JPanel panelBot = new JPanel(new GridLayout(1,3,5,0));
        JButton botGestion = new JButton("Gestión Empresas");
        botGestion.setPreferredSize(new Dimension(265,40));
        botGestion.setBorder(new EmptyBorder(0,10,0,0));
        botGestion.setFocusable(false);
        JButton botAsig = new JButton("Asignación Alumnos");
        botAsig.setPreferredSize(new Dimension(265,40));
        botAsig.setBorder(new EmptyBorder(0,0,0,0));
        botAsig.setFocusable(false);
        JButton botFich = new JButton("Ficheros a BBDD");
        botFich.setPreferredSize(new Dimension(265,40));
        botFich.setBorder(new EmptyBorder(0,0,0,0));
        botFich.setFocusable(false);

        JPanel panelMenu = new JPanel(new FlowLayout());
        panelMenu.setBorder(new EmptyBorder(-5,-5,-5,700));

        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Menú");
        JMenuItem ayuda = new JMenuItem("Ayuda");

        menu.add(ayuda);
        barra.add(menu);
        menu.add(ayuda);
        panelMenu.add(barra);

        panelBot.add(botGestion);
        panelBot.add(botAsig);
        panelBot.add(botFich);

        panelPrincipal.add(panelMenu);
        panelPrincipal.add(panelBot, BorderLayout.NORTH);
        panelPrincipal.add(etiLogoSAFA, BorderLayout.SOUTH);


        File fichero = new File("help/help_set.hs");
        try {
            URL hsURL = fichero.toURI().toURL();
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();
            hb.enableHelpOnButton(ayuda, "inicio", helpset);
            ayuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        } catch (Exception e) {
            System.out.println(e);
        }


        // -------- ACCIONES DE BOTONES -----------

        ActionListener accionBotInicio = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == botAsig) {
                    AsigAlum ObjAA = new AsigAlum(marco);
                    ObjAA.asigAlumGUI();
                }
                if(e.getSource() == botFich) {
                    FicherosTabla ObjFT = new FicherosTabla(marco);
                    ObjFT.FichTablaGUI();
                }
                if(e.getSource() == botGestion) {
                    GestionEmpresas ObjGE = new GestionEmpresas(marco);
                    ObjGE.GestEmpGUI();
                }
            }
        };

        botFich.addActionListener(accionBotInicio);
        botAsig.addActionListener(accionBotInicio);
        botGestion.addActionListener(accionBotInicio);

        // -----------------

        marco.setContentPane(panelPrincipal);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(800, 500);
        marco.setResizable(false);
        marco.setVisible(true);
    }

    private void cambiarLookAndFeel () {
        try {
            UIManager.setLookAndFeel(FlatIntelliJLaf.class.getCanonicalName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Throwable e) {
            JOptionPane.showConfirmDialog(this, "Error estableciendo LookAndFeel");
        }
    }
}