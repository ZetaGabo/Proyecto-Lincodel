/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Gabo
 */
public class PanelBotonesIngreso extends JPanel {

    FlowLayout distribucion;
    public JButton btnAceptar;
    public JButton btnCancelar;

    public PanelBotonesIngreso() {
        InicializarComponentes();
    }

    private void InicializarComponentes() {
        this.distribucion = new FlowLayout();
        this.setLayout(distribucion);
        this.btnAceptar = new JButton("Aceptar");
        this.add(this.btnAceptar);
        this.btnCancelar = new JButton("Cancelar");
        this.add(this.btnCancelar);
    }

}
