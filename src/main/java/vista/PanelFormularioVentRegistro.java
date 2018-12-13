/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author usuario
 */
public class PanelFormularioVentRegistro extends JPanel {

    private JLabel lblCodigo;
     private JTextField ingCodigo;
      private JTextField ingFecha;
      private JLabel lblFecha;
      private JTextField ingNombTipo;
      private JLabel lblNombTipo;
      private  JLabel lblAccion;
    private JComboBox combBoxAccion;
    
    public PanelFormularioVentRegistro() {
    inicializarComponentes();
    }
    
    public void inicializarComponentes(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this. lblNombTipo = new JLabel("NOMBRE");
        this.add(this.lblNombTipo);
        
        this.ingNombTipo = new JTextField();
        this.add(this.ingNombTipo);
        this.ingNombTipo.setColumns(10);
    
        this.lblCodigo = new JLabel("CODIGO");
        this.add(this.lblCodigo);

        this.ingCodigo = new JTextField();
        this.add(this.ingCodigo);
        this.ingCodigo.setColumns(10);

        this.lblFecha = new JLabel("FECHA");
        this.add(this.lblFecha);

        this.ingFecha = new JTextField();
        this.add(ingFecha);
        this.ingFecha.setColumns(10);

        
        this.lblAccion = new JLabel("ACCIÓN TOMADA");
        this.add(this.lblAccion);

        this. combBoxAccion = new JComboBox();
        this.combBoxAccion.addItem("Ingresado");
        this.combBoxAccion.addItem("Borrado");
        this.combBoxAccion.addItem("Modificado");
        this.add(this.combBoxAccion);
        
    }
}
