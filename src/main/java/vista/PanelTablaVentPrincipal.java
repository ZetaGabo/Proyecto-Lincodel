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

    private JTable tabla;
    private DefaultTableModel modelo;
    private JScrollPane scroll;

    public PanelTablaVentPrincipal() {
        this.inicializarComponentes();
    }

    private void inicializarComponentes() {

        this.modelo = new DefaultTableModel();
        this.tabla = new JTable();
        this.tabla.setModel(modelo);
        this.modelo.addColumn("Nombre");
        this.modelo.addColumn("Código");
        this.modelo.addColumn("Cantidad");
        this.scroll = new JScrollPane(tabla);
        this.add(this.scroll);
    }
}
