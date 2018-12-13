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
    private JLabel mostrarNombre;
    private JLabel mostrarTipo;
    private JLabel mostrarCodigo;
    private JLabel mostrarCantidad;
    private JLabel mostrarPresentacion;
    private JLabel mostrarUnidadMedida;
    private JLabel mostrarFecha;
    public PanelMostrarInfoVentRegistro() {
        inicializarComponentes();
    }
    
    
    

    private void inicializarComponentes()  {
       this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.mostrarNombre = new JLabel("n/a");
        this.add(this.mostrarNombre);

        this. mostrarCodigo = new JLabel("n/a");
        this.add(this.mostrarCodigo);

       

        this. mostrarCantidad = new JLabel("n/a");
        this.add(this.mostrarCantidad);
        
         this. mostrarTipo = new JLabel("n/a");
        this.add(this.mostrarTipo);

        this.mostrarPresentacion = new JLabel("n/a");
        this.add(this.mostrarPresentacion);
        
        this.mostrarUnidadMedida = new JLabel("n/a");
        this.add(this.mostrarUnidadMedida);
        
         this.mostrarFecha = new JLabel("n/a");
        this.add(this.mostrarFecha);
    }
}
