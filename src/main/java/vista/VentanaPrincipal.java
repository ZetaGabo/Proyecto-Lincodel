/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public final class VentanaPrincipal extends JFrame implements ActionListener {

    private PanelTablaVentPrincipal panelTabla;
    private PanelMenuVentPrincipal panelMenu;
    private PanelDatosVentPrincipal panelDatos;
    private GridBagConstraints c;
    private GridBagLayout distribucion;
    private final boolean esAdministrador;
    /**
    *
    * @author usuario
     * @param esAdministrador
    */
    public VentanaPrincipal(boolean esAdministrador) {
    this.esAdministrador = esAdministrador;
        this.inicializarComponentes();

    }

    public void inicializarComponentes() {
        this.setTitle("Ventana de Datos");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.panelMenu = new PanelMenuVentPrincipal();
        this.add(panelMenu, BorderLayout.NORTH);
        this.panelDatos = new PanelDatosVentPrincipal();
        this.add(this.panelDatos, BorderLayout.WEST);
        this.panelTabla = new PanelTablaVentPrincipal();
        this.add(panelTabla, BorderLayout.CENTER);
        this.setVisible(true);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
