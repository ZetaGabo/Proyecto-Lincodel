/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.*;

/**
 *
 * @author usuario
 */
public class VentanaRegistro extends JFrame {
    
    private PanelListFechaVentRegistro panelListFecha;
    private PanelCentralVentRegistro panelCentral;
    
    public VentanaRegistro() {
        inicializarComponentes();

    }

    private void inicializarComponentes() {
        setTitle("Registro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 621, 368);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        this.panelListFecha = new PanelListFechaVentRegistro();
        
        this.add(this.panelListFecha);

        this.panelCentral = new PanelCentralVentRegistro();
        this.add(this.panelCentral);

        this.setVisible(true);
    }

}
