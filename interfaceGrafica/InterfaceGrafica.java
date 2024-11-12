package interfaceGrafica;

import javax.swing.JFrame;
import javax.swing.JPanel;


public abstract class InterfaceGrafica {
    public static final JFrame frame = new JFrame("Titulo da janela");

    public static void abrir(JPanel panel) {
        frame.add(panel);
        
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void changePanel(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.revalidate();
        frame.repaint();
    }

    public abstract JPanel mostrar();
}
