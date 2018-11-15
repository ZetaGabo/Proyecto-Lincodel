package vista;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelDatos extends JPanel{
	public PanelDatos() {
		this.inicializarComponentes();
	}

	private void inicializarComponentes() {
		this.setLayout(new BorderLayout(0, 0));
		
		JPanel organizacion = new JPanel();
		this.add(organizacion, BorderLayout.NORTH);
		
		JPanel modDatos = new JPanel();
		modDatos.setToolTipText("");
		this.add(modDatos, BorderLayout.SOUTH);
		modDatos.setLayout(new BorderLayout(0, 0));
		
		JPanel panNombre = new JPanel();
		modDatos.add(panNombre, BorderLayout.NORTH);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		panNombre.add(lblNombre);
		
		JTextField ingNombre = new JTextField();
		panNombre.add(ingNombre);
		ingNombre.setColumns(10);
		
		JPanel panCodigo = new JPanel();
		modDatos.add(panCodigo, BorderLayout.CENTER);
		
		JLabel lblCodigo = new JLabel("CODIGO");
		panCodigo.add(lblCodigo);
		
		JTextField ingCodigo = new JTextField();
		panCodigo.add(ingCodigo);
		ingCodigo.setColumns(10);
		
		JPanel panCantidad = new JPanel();
		modDatos.add(panCantidad, BorderLayout.SOUTH);
		
		JLabel lblCantidad = new JLabel("CANTIDAD");
		panCantidad.add(lblCantidad);
		
		JTextField ingCantidad = new JTextField();
		panCantidad.add(ingCantidad);
		ingCantidad.setColumns(10);
        }
}
