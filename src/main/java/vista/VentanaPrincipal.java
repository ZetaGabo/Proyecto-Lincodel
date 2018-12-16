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
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import modelo.GestorDeArchivos;
import modelo.Historial;
import modelo.Insumo;

public final class VentanaPrincipal extends JFrame implements ActionListener {

    private PanelTablaVentPrincipal panelTabla;
    private PanelMenuVentPrincipal panelMenu;
    private PanelDatosVentPrincipal panelDatos;
    private GridBagConstraints c;
    private GridBagLayout distribucion;
    private final boolean esAdministrador;
    private DateTimeFormatter dtf;
    private final GestorDeArchivos gestor = new GestorDeArchivos();
    private final String NOMBRE = "insumos.json";
    private JMenuItem mntmCerrarSesion;

   

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
        this.panelDatos = new PanelDatosVentPrincipal(this.esAdministrador);
        this.add(this.panelDatos, BorderLayout.WEST);
        this.panelTabla = new PanelTablaVentPrincipal();
        this.add(panelTabla, BorderLayout.CENTER);
        this.setVisible(true);
        pack();

        //actionListener test
        this.panelDatos.btnAgregar.addActionListener(this);
        if (this.esAdministrador) {
            this.panelDatos.btnBorrar.addActionListener(this);
        }

        this. mntmCerrarSesion = this.panelMenu.mntmCerrarSesion;
        this.mntmCerrarSesion.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.panelDatos.btnAgregar == e.getSource() && this.esAdministrador) {
            Insumo i = this.panelDatos.getAllData();
            if (i != null) {
                ArrayList<Insumo> ins = gestor.recuperarJsonInsumos(this.NOMBRE);

                if (!ins.stream().anyMatch(x -> x.getCodigo().equals(i.getCodigo())
                        && x.getCantidad() == i.getCantidad()
                        && x.getNombreInsumo().equals(i.getNombreInsumo())
                        && x.getPresentacion().equals(i.getPresentacion())
                        && x.getTipo().equals(i.getTipo())
                        && x.getUnidadMedida().equals(i.getUnidadMedida()))) {

                    //guardar insumo
                    Object[] row = {i.getNombreInsumo(), i.getCodigo(), i.getCantidad(),
                        i.getTipo(), i.getPresentacion(), i.getUnidadMedida(), i.getFecha()};
                    this.panelTabla.modelo.addRow(row);
                    guardarDato(i);
                    //guardar historial
                    this.guardarHistorial(i, 0);
                } else {
                    JOptionPane.showMessageDialog(this, "No puede ingresar un insumo identico a otro",
                            "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe llenar los datos segun corresponda",
                        "Error",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (this.panelDatos.btnAgregar == e.getSource() && !this.esAdministrador) {
            
            //boton "modificar" (agregar) datos por un usuario comun
            if (this.panelTabla.tabla.getSelectedRow() != -1 && !this.panelDatos.ingCantidad.getText().isEmpty()) {
                int seleccion = this.panelTabla.tabla.getSelectedRow();

                int nuevaCantidad = Integer.parseInt(this.panelDatos.ingCantidad.getText());

                Insumo i = new Insumo(
                        (String) this.panelTabla.modelo.getValueAt(seleccion, 0),
                        (String) this.panelTabla.modelo.getValueAt(seleccion, 1),
                        (int) this.panelTabla.modelo.getValueAt(seleccion, 2),
                        (String) this.panelTabla.modelo.getValueAt(seleccion, 3),
                        (String) this.panelTabla.modelo.getValueAt(seleccion, 4),
                        (String) this.panelTabla.modelo.getValueAt(seleccion, 5),
                        (String) this.panelTabla.modelo.getValueAt(seleccion, 6));
                if (nuevaCantidad < (int) this.panelTabla.modelo.getValueAt(seleccion, 2)) {
                    this.gestor.modificarObjetoJson(i, this.NOMBRE, nuevaCantidad);
                    
                    this.guardarHistorial(i, 2);
                    
                    for (int j = 0; j < this.panelTabla.modelo.getRowCount(); j++) {
                        this.panelTabla.modelo.removeRow(j);
                    }
                    this.obtenerDatos();
                }else{
                    JOptionPane.showMessageDialog(this, "Debe ingresar una cantidad menor a la almacenada",
                        "Acceso Restringido",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else if (this.panelDatos.btnBorrar == e.getSource()) {

            if (this.panelTabla.tabla.getSelectedRow() != -1) {
                int seleccion = this.panelTabla.tabla.getSelectedRow();

                Insumo i = new Insumo(
                        (String) this.panelTabla.modelo.getValueAt(seleccion, 0),
                        (String) this.panelTabla.modelo.getValueAt(seleccion, 1),
                        (int) this.panelTabla.modelo.getValueAt(seleccion, 2),
                        (String) this.panelTabla.modelo.getValueAt(seleccion, 3),
                        (String) this.panelTabla.modelo.getValueAt(seleccion, 4),
                        (String) this.panelTabla.modelo.getValueAt(seleccion, 5),
                        (String) this.panelTabla.modelo.getValueAt(seleccion, 6)
                );
                this.panelTabla.modelo.removeRow(seleccion);

                this.gestor.removerObjetoJson(i, NOMBRE);

                this.guardarHistorial(i, 1);

            }
        }else if(this.mntmCerrarSesion==e.getSource()){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            VentanaIngreso vent = new VentanaIngreso();
            this.dispose();
            
        }
    }//fin actionlistener

    private ArrayList<Insumo> obtenerJson() {
        return this.gestor.recuperarJsonInsumos(this.NOMBRE);

    }

    private void obtenerDatos() {
        
        ArrayList<Insumo> in = obtenerJson();

        if (in != null) {
            for (Insumo i : in) {
                Object[] row = {i.getNombreInsumo(), i.getCodigo(), i.getCantidad(),
                    i.getTipo(), i.getPresentacion(), i.getUnidadMedida(), i.getFecha()};
                this.panelTabla.modelo.addRow(row);
            }
        }

    }

    private boolean guardarDato(Insumo i) {
        Object ob = (Object) i;

        return this.gestor.almacenarObjeto(ob, this.NOMBRE);
    }

    private boolean guardarHistorial(Insumo i, int accion) {

        //guardar historial
        // 0 = agregar
        // 1 = borrar
        // 2 = modificar
        Historial his = new Historial(i.getNombreInsumo(), i.getCodigo(), i.getCantidad(),
                i.getTipo(), i.getPresentacion(), i.getUnidadMedida(), i.getFecha(), accion);
        return this.gestor.almacenarObjeto(his, "historial.json");
    }

}
