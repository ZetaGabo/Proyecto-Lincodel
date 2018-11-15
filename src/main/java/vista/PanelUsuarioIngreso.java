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
    private JLabel lblContraseña;
    private JTextField ingUsuario;
    private JTextField ingContraseña;
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
        this.lblContraseña = new JLabel("Contraseña");
        this.add(this.lblContraseña, distribucion);
        this.ingContraseña = new JTextField();
        this.ingContraseña.setColumns(10);
        this.add(this.ingContraseña, distribucion);
    }
}
