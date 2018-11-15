package vista;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTable;

public class PanelTabla extends JPanel{
	private JTable tabla;
	public PanelTabla() {
		this.inicializarComponentes();
	}

	private void inicializarComponentes() {
		
		this.setLayout(new BorderLayout(0, 0));
		
		tabla = new JTable();
		this.add(tabla, BorderLayout.CENTER);
		
		JScrollBar scrollPanelTabla = new JScrollBar();
		this.add(scrollPanelTabla, BorderLayout.EAST);
		
	}
}
