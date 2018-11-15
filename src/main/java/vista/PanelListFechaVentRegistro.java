/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

/**
 *
 * @author usuario
 */
public class PanelListFechaVentRegistro extends JPanel {
    
    private JList listaFecha;
    private JScrollBar scrollListFecha;
    
    public PanelListFechaVentRegistro() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        	this.setLayout(new BorderLayout(0, 0));
		
		listaFecha = new JList();
		this.add(listaFecha, BorderLayout.CENTER);
		
		scrollListFecha = new JScrollBar();
		this.add(scrollListFecha, BorderLayout.EAST);
    }
    
}
