package vista;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelTabla extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;
    private JScrollPane scroll;

    public PanelTabla() {
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
