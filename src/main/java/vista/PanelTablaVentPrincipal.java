/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;



import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelTablaVentPrincipal extends JPanel {

    public JTable tabla;
    public DefaultTableModel modelo;
    private  JScrollPane scroll;

    public PanelTablaVentPrincipal() {
        this.inicializarComponentes();
    }

    private void inicializarComponentes() {

        this.modelo = new DefaultTableModel();
        
        this.tabla = new JTable(){
            @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
        };
        this.tabla.setModel(modelo);
        this.modelo.addColumn("Nombre");
        this.modelo.addColumn("Código");
        this.modelo.addColumn("Cantidad");
        this.modelo.addColumn("tipo de insumo");
        this.modelo.addColumn("presentación");
        this.modelo.addColumn("u. de medida");
        this.modelo.addColumn("fecha");
        
        this.scroll = new JScrollPane(tabla,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        this.add(this.scroll);
        
        
    }
}
