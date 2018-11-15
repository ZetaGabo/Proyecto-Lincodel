package vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public final class VentanaPrincipal extends JFrame implements ActionListener {

    private PanelTabla panelTabla;
    private PanelMenu panelMenu;
    private PanelDatos panelDatos;
    private GridBagConstraints c;
    private GridBagLayout distribucion;

    /**
     * Launch the application.
     */
    /**
     * Create the frame.
     */
    public VentanaPrincipal() {

        this.inicializarComponentes();

    }

    public void inicializarComponentes() {
        this.setTitle("Ventana de Datos");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.panelMenu = new PanelMenu();
        this.add(panelMenu, BorderLayout.NORTH);
        this.panelDatos = new PanelDatos();
        this.add(this.panelDatos, BorderLayout.WEST);
        this.panelTabla = new PanelTabla();
        this.add(panelTabla, BorderLayout.CENTER);
        this.setVisible(true);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
