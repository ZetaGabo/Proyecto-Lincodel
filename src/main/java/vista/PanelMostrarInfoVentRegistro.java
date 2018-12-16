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
    public  JLabel mostrarNombre;
    public  JLabel mostrarTipo;
    public JLabel mostrarCodigo;
    public JLabel mostrarCantidad;
    public JLabel mostrarPresentacion;
    public JLabel mostrarUnidadMedida;
    public JLabel mostrarFecha;
    public JLabel mostrarAccion;
    public PanelMostrarInfoVentRegistro() {
        inicializarComponentes();
    }
    
    
    

    private void inicializarComponentes()  {
       this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.mostrarNombre = new JLabel("");
        this.add(this.mostrarNombre);

        this. mostrarCodigo = new JLabel("");
        this.add(this.mostrarCodigo);

       

        this. mostrarCantidad = new JLabel("");
        this.add(this.mostrarCantidad);
        
         this. mostrarTipo = new JLabel("");
        this.add(this.mostrarTipo);

        this.mostrarPresentacion = new JLabel("");
        this.add(this.mostrarPresentacion);
        
        this.mostrarUnidadMedida = new JLabel("");
        this.add(this.mostrarUnidadMedida);
        
         this.mostrarFecha = new JLabel("");
        this.add(this.mostrarFecha);
        
        this.mostrarAccion = new JLabel("");
        this.add(this.mostrarAccion);
    }
}
