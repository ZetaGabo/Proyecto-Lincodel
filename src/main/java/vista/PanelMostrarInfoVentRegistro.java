/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

/**
 *
 * @author usuario
 */
public class PanelMostrarInfoVentRegistro extends JLabel{
    private JLabel mostrarFecha;
    private JLabel mostrarTipo;
    private JLabel mostrarCodigo;
    private JLabel mostrarCantidad;
    private JLabel mostrarOtros;
    public PanelMostrarInfoVentRegistro() {
        inicializarComponentes();
    }
    
    
    

    private void inicializarComponentes()  {
       this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.mostrarFecha = new JLabel("n/a");
        this.add(this.mostrarFecha);

        this. mostrarCodigo = new JLabel("n/a");
        this.add(this.mostrarCodigo);

        this. mostrarTipo = new JLabel("n/a");
        this.add(this.mostrarTipo);

        this. mostrarCantidad = new JLabel("n/a");
        this.add(this.mostrarCantidad);

        this.mostrarOtros = new JLabel("n/a");
        this.add(this.mostrarOtros);
    }
}
