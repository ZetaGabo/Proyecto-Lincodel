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
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

import javax.swing.JFrame;
import modelo.GestorDeArchivos;
import modelo.Insumo;

public final class VentanaPrincipal extends JFrame implements ActionListener {

    private PanelTablaVentPrincipal panelTabla;
    private PanelMenuVentPrincipal panelMenu;
    private PanelDatosVentPrincipal panelDatos;
    private GridBagConstraints c;
    private GridBagLayout distribucion;
    private final boolean esAdministrador;
    private DateTimeFormatter dtf ;
    private final GestorDeArchivos gestor = new GestorDeArchivos();
    private final String NOMBRE = "insumos.json";
    /**
    *
    * @author usuario
     * @param esAdministrador
    */
    public VentanaPrincipal(boolean esAdministrador) {
    this.esAdministrador = esAdministrador;
        this.inicializarComponentes();
        this.obtenerDatos();

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
        
        //actionListener test
        this.panelDatos.btnAgregar.addActionListener(this);
        this.panelDatos.btnBorrar.addActionListener(this);
        
   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.panelDatos.btnAgregar==e.getSource()){
            Insumo i = this.panelDatos.getAllData();
        Object []row={i.getNombreInsumo(),i.getCodigo(),i.getCantidad(),
            i.getTipo(),i.getPresentacion(),i.getUnidadMedida(),i.getFecha()};
        this.panelTabla.modelo.addRow(row);
            
        }
        if(this.panelDatos.btnBorrar==e.getSource()){
            int seleccion=this.panelTabla.tabla.getSelectedRow();
            this.panelTabla.modelo.removeRow(seleccion);
        }
   }

    private void obtenerDatos() {
            Object ob =this.gestor.recuperarJsonGenerico(this.NOMBRE);
            
            
    }
    private void guardarDatos(){
        
    }

}
