/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Gabo
 */
public class PanelUsuarioIngreso extends JPanel {

    private JLabel lblUsuario;
    private JLabel lblContrasena;
    private JTextField ingUsuario;
    private JTextField ingContrasena;
    private GridLayout distribucion;

    public PanelUsuarioIngreso() {
        InicializarComponentes();
    }

    private void InicializarComponentes() {
        this.distribucion = new GridLayout(3, 1, 1, 1);
        this.setLayout(distribucion);
        this.lblUsuario = new JLabel("Usuario");
        this.add(this.lblUsuario, distribucion);
        this.ingUsuario = new JTextField();
        this.ingUsuario.setColumns(10);
        this.add(this.ingUsuario, distribucion);
        this.lblContrasena = new JLabel("Contrase�aa");
        this.add(this.lblContrasena, distribucion);
        this.ingContrasena = new JTextField();
        this.ingContrasena.setColumns(10);
        this.add(this.ingContrasena, distribucion);
    }
}
