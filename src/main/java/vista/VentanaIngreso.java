package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class VentanaIngreso extends JFrame implements ActionListener {

    private PanelUsuarioIngreso panelUsuario;
    private PanelBotonesIngreso panelBotones;

    public VentanaIngreso() {
        this.inicializarComponentes();
    }

    public void inicializarComponentes() {
        this.setSize(235,123);
        this.panelUsuario = new PanelUsuarioIngreso();
        this.panelBotones = new PanelBotonesIngreso();
        this.add(this.panelUsuario, BorderLayout.NORTH);
        this.add(this.panelBotones, BorderLayout.CENTER);
        this.setTitle("Ingreso de Usuario");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        panelBotones.btnAceptar.addActionListener(this);
        panelBotones.btnCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.panelBotones.btnAceptar) {
            this.setVisible(false);
            VentanaPrincipal p = new VentanaPrincipal();
        } else if (e.getSource() == this.panelBotones.btnCancelar) {
            System.exit(0);
        }
    }
}
