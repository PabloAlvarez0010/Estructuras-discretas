package cr.ac.una.ejemploBase;

import cr.ac.una.ejemploBase.configuration.Configuration;
import cr.ac.una.ejemploBase.control.ApplicationControl;
import cr.ac.una.ejemploBase.view.ApplicationWindow;
import cr.ac.una.simon.SimonGame;
import cr.ac.una.simon.SimonGameUI;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Georges Alfaro S.
 * @version 1.0.0 2023-09-05
 */
public class EjemploBase {

    //+++++++++++++++mi codigo generado+++++++++++++++++++

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public EjemploBase() {
        this.configuration = Configuration.getInstance();
        //+++++++++++++++mi codigo generado+++++++++++++++++++

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
    }

    public static void main(String[] args) {
        try {
            setupGUI();

        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | IOException
                | UnsupportedLookAndFeelException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        new EjemploBase().init();
    }

    private static void setupGUI() throws
            ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            UnsupportedLookAndFeelException,
            IOException {

        System.out.println("Configurando interfaz..");

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFrame.setDefaultLookAndFeelDecorated(true);

        // 2021-08-06
        // Para la versión 14+ del JDK, no es necesario redefinir los iconos
        // por defecto de la interfaz, ya que no hay problema de despliegue
        // en dispositivos de alta resolución.
        //
        // setIcon("OptionPane.errorIcon", "view/icons/error.png");
        // setIcon("OptionPane.informationIcon", "view/icons/information.png");
        // setIcon("OptionPane.questionIcon", "view/icons/question.png");
        // setIcon("OptionPane.warningIcon", "view/icons/warning.png");
    }

    private static void setIcon(String iconName, String iconFile) throws IOException {
        InputStream in = EjemploBase.class.getResourceAsStream(iconFile);
        ImageIcon icon = new ImageIcon(ImageIO.read(in));
        UIManager.put(iconName, icon);
    }

    public void init() {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    public void createAndShowGUI() {
        ApplicationControl control = new ApplicationControl(configuration);
        control.init();

        new ApplicationWindow(getClass().getSimpleName(), control).init();
    }
    private final Configuration configuration;

    //++++++++++++++mi codigo generado+++++++++++++++++++++++++++++++++++
   

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}
