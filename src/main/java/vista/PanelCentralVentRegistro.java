/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class PanelCentralVentRegistro extends JPanel {

    private JTable tablaDatos;
   
   
    
    
    private DefaultTableModel modelo;
    private JScrollPane scrollPanelTabla;
    private PanelCentralSuperiorVentRegistro panelCentralSup;
   
    public PanelCentralVentRegistro() {
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
                this.modelo.addColumn("Codigo");
                this.modelo.addColumn("Tipo");
                this.modelo.addColumn("Presentación");
                this.modelo.addColumn("Concentración");
                this.modelo.addColumn("Clase");
                this.modelo.addColumn("Stock");
                this.modelo.addColumn("Acción Tomada");
		
		this.tablaDatos = new JTable(modelo);
                
                this.scrollPanelTabla = new JScrollPane(this.tablaDatos);
		this.add(scrollPanelTabla, BorderLayout.CENTER);
    }

}
