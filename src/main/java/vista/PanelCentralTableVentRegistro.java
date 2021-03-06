/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class PanelCentralTableVentRegistro extends JPanel {

    public JTable tablaDatos;
    public DefaultTableModel modelo;
    private JScrollPane scrollPanelTabla;
    public PanelCentralSuperiorVentRegistro panelCentralSup;

    public PanelCentralTableVentRegistro() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        this.setLayout(new BorderLayout(0, 0));

        this.panelCentralSup = new PanelCentralSuperiorVentRegistro();
        this.add(panelCentralSup, BorderLayout.NORTH);

        JPanel PanelTabla = new JPanel();
        this.add(PanelTabla);
        PanelTabla.setLayout(new BorderLayout(0, 0));

        this.modelo = new DefaultTableModel();
        this.modelo.addColumn("Nombre");
        this.modelo.addColumn("Código");
        this.modelo.addColumn("Cantidad");
        this.modelo.addColumn("Tipo");
        this.modelo.addColumn("Presentacion");
        this.modelo.addColumn("Unidad de medida");
        this.modelo.addColumn("Fecha");
        this.modelo.addColumn("acción tomada");

        this.tablaDatos = new JTable(modelo) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.scrollPanelTabla = new JScrollPane(this.tablaDatos);
        this.add(scrollPanelTabla, BorderLayout.CENTER);

    }

}
