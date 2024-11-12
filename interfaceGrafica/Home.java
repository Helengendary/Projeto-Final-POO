package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Home extends InterfaceGrafica {

    @Override
    public JPanel mostrar() {
        JPanel panel = new JPanel();

        JButton buttonPadrao = new JButton("Uou");
        buttonPadrao.addActionListener(e -> changePanel());
    }
    
}
