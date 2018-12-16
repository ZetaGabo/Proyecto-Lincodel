/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import modelo.GestorDeArchivos;
import modelo.Historial;

/**
 *
 * @author usuario
 */
public final class VentanaRegistro extends JFrame implements ActionListener,MouseListener {

    private GestorDeArchivos gestor = new GestorDeArchivos();
    private PanelListFechaVentRegistro panelListFecha;
    private PanelCentralTableVentRegistro panelCentral;
    private final String NOMBRE = "historial.json";

    public VentanaRegistro() {
        inicializarComponentes();
        

    }

    private void inicializarComponentes() {
        setTitle("Registro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 621, 368);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        this.panelListFecha = new PanelListFechaVentRegistro();

        this.add(this.panelListFecha);

        this.panelCentral = new PanelCentralTableVentRegistro();
        this.add(this.panelCentral);

        this.panelCentral.panelCentralSup.panelInformacion.btnBuscar.addActionListener(this);
        this.panelCentral.panelCentralSup.panelInformacion.btnLimpiar.addActionListener(this);
        
        //llenar lista de fechas
        this.llenarTablaFechas(this.obtenerDatos());
        //lista fechas mouselistener
        this.panelListFecha.listaFecha.addMouseListener(this);
        //Llenar jtable
        this.llenarTabla(this.obtenerDatos());
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (this.panelCentral.panelCentralSup.panelInformacion.btnBuscar == e.getSource()) {
            
            aplicarFiltro();

        } else if (this.panelCentral.panelCentralSup.panelInformacion.btnLimpiar == e.getSource()) {
            this.panelCentral.panelCentralSup.panelFormulario.ingCodigo.setText(null);
            this.panelCentral.panelCentralSup.panelFormulario.ingFecha.setText(null);
            this.panelCentral.panelCentralSup.panelFormulario.ingNombTipo.setText(null);
            
            this.panelCentral.modelo.setRowCount(0);
            this.llenarTabla(this.obtenerDatos());

            this.panelCentral.panelCentralSup.panelInformacion.panelMostrarInfo.mostrarCantidad.setText("");
        this.panelCentral.panelCentralSup.panelInformacion.panelMostrarInfo.mostrarCodigo.setText("");
        this.panelCentral.panelCentralSup.panelInformacion.panelMostrarInfo.mostrarFecha.setText("");
        this.panelCentral.panelCentralSup.panelInformacion.panelMostrarInfo.mostrarNombre.setText("");
        this.panelCentral.panelCentralSup.panelInformacion.panelMostrarInfo.mostrarPresentacion.setText("");
        this.panelCentral.panelCentralSup.panelInformacion.panelMostrarInfo.mostrarTipo.setText("");
        this.panelCentral.panelCentralSup.panelInformacion.panelMostrarInfo.mostrarUnidadMedida.setText("");
        this.panelCentral.panelCentralSup.panelInformacion.panelMostrarInfo.mostrarAccion.setText("");
        }

    }

    public ArrayList<Historial> obtenerDatos() {

        return gestor.recuperarJsonHistorial(this.NOMBRE);
    }

    public void llenarTabla(ArrayList<Historial> h) {
        
        
        for (Historial historial : h) {
            String accion = null;
            switch (historial.getAccion()) {
                case 0:
                    accion = "Agregado";
                    break;
                case 1:
                    accion = "Borrado";
                    break;
                case 2:
                    accion = "Modificado";
                    break;
            }

            Object[] o = {historial.getNombreInsumo(),
                historial.getCodigo(),
                historial.getCantidad(),
                historial.getTipo(),
                historial.getPresentacion(),
                historial.getUnidadMedida(),
                historial.getFecha(),
                accion};
            this.panelCentral.modelo.addRow(o);
        }
    }

    public void llenarTablaFechas(List<Historial> h) {
         
        h.forEach(x -> this.panelListFecha.modeloLista.addElement(x.getFecha()));

        
        
    }

    public void aplicarFiltro() {
        List<Historial> h = this.obtenerDatos();
        List<Historial> nuevoTable;
        String nombreIng = this.panelCentral.panelCentralSup.panelFormulario.ingNombTipo.getText();
        String codigoIng = this.panelCentral.panelCentralSup.panelFormulario.ingCodigo.getText();
        String fechaIng = this.panelCentral.panelCentralSup.panelFormulario.ingFecha.getText();
        int accionIng =this.panelCentral.panelCentralSup.panelFormulario.combBoxAccion.getSelectedIndex();
        
        nuevoTable=h.stream().filter(x -> ((x.getNombreInsumo().equals(nombreIng))||nombreIng.isEmpty())
                &&((x.getCodigo().equals(codigoIng))||codigoIng.isEmpty())
                &&((x.getFecha().equals(fechaIng))||fechaIng.isEmpty() )
                &&(x.getAccion()==accionIng)||accionIng==3).collect(Collectors.toList());
        
        
           this.panelCentral.modelo.setRowCount(0);
           
           llenarTabla((ArrayList<Historial>) nuevoTable);
            
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        JList list = (JList)e.getSource();
        if (e.getClickCount() == 2) {

            // Double-click detected
            
        ArrayList<Historial> datos =this.obtenerDatos();
        
        Historial i=null;
        
            for (Historial dato : datos) {
                if(dato.getFecha().equals(list.getSelectedValue())){
                    
                    i = dato;
                    System.out.println(i.getAccion());
                }
               
            }
            if(i!=null){
                llenarPanelMostrarInfo(i);
            }
        } 
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    private void llenarPanelMostrarInfo(Historial dato) {
        
        this.panelCentral.panelCentralSup.panelInformacion.panelMostrarInfo.mostrarCantidad.setText(Integer.toString(dato.getCantidad()));
        this.panelCentral.panelCentralSup.panelInformacion.panelMostrarInfo.mostrarCodigo.setText(dato.getCodigo());
        this.panelCentral.panelCentralSup.panelInformacion.panelMostrarInfo.mostrarFecha.setText(dato.getFecha());
        this.panelCentral.panelCentralSup.panelInformacion.panelMostrarInfo.mostrarNombre.setText(dato.getNombreInsumo());
        this.panelCentral.panelCentralSup.panelInformacion.panelMostrarInfo.mostrarPresentacion.setText(dato.getPresentacion());
        this.panelCentral.panelCentralSup.panelInformacion.panelMostrarInfo.mostrarTipo.setText(dato.getTipo());
        this.panelCentral.panelCentralSup.panelInformacion.panelMostrarInfo.mostrarUnidadMedida.setText(dato.getUnidadMedida());
        String accion="";
         switch (dato.getAccion()) {
                case 0:
                    accion = "Agregado";
                    break;
                case 1:
                    accion = "Borrado";
                    break;
                case 2:
                    accion = "Modificado";
                    break;
            }
        this.panelCentral.panelCentralSup.panelInformacion.panelMostrarInfo.mostrarAccion.setText(accion);
    }
    
    
}
