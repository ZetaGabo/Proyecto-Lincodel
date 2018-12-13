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
import java.util.ArrayList;

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
        guardarDato(i);
            System.out.println(i.toString());
        }else if(this.panelDatos.btnBorrar==e.getSource()){
            
            if(this.panelTabla.tabla.getSelectedRow()!=-1){
            int seleccion=this.panelTabla.tabla.getSelectedRow();
            
            Insumo i = new Insumo(
            (String)this.panelTabla.modelo.getValueAt(seleccion,0),
            (String)this.panelTabla.modelo.getValueAt(seleccion,1),
            (int)this.panelTabla.modelo.getValueAt(seleccion,2),
            (String)this.panelTabla.modelo.getValueAt(seleccion,3),
            (String)this.panelTabla.modelo.getValueAt(seleccion,4),
            (String)this.panelTabla.modelo.getValueAt(seleccion,5),
            (String)this.panelTabla.modelo.getValueAt(seleccion,6)
            );
            this.panelTabla.modelo.removeRow(seleccion);
            
            this.gestor.removerObjetoJson(i, NOMBRE);
            }
        }
   }
    
    private ArrayList<Insumo> obtenerJson(){
        return this.gestor.recuperarJsonInsumos(this.NOMBRE);
        
    }
    private void obtenerDatos() {
           ArrayList<Insumo> in= obtenerJson();
            
        if(in!=null){
            for (Insumo i : in) {
             Object []row={i.getNombreInsumo(),i.getCodigo(),i.getCantidad(),
            i.getTipo(),i.getPresentacion(),i.getUnidadMedida(),i.getFecha()};
         this.panelTabla.modelo.addRow(row);
        }
        }
            
            
    }
    private boolean guardarDato(Insumo i){
        Object ob = (Object)i;
        
        return this.gestor.almacenarObjeto(ob, this.NOMBRE);
    }

}
