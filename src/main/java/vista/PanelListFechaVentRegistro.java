/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import javax.swing.DefaultListModel;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author usuario
 */
public class PanelListFechaVentRegistro extends JPanel {
    
    public  JList listaFecha;
    private JScrollPane scrollListFecha;
    public DefaultListModel modeloLista;
    
    
    public PanelListFechaVentRegistro() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
    
                modeloLista = new DefaultListModel();
                

            this.setLayout(new BorderLayout(0, 0));
		
		listaFecha = new JList(modeloLista);
		this.add(listaFecha, BorderLayout.CENTER);
		
		scrollListFecha = new JScrollPane(this.listaFecha,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(scrollListFecha, BorderLayout.EAST);
    }
    
}
