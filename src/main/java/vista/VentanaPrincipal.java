package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;



public final class VentanaPrincipal extends JFrame {

	private PanelTabla panelTabla;
	private PanelDatos panelDatos;
	private Menu panelMenu;
	
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		
		this.inicializarComponentes();
		
			}
	public void inicializarComponentes() {
		this.setTitle("Ventana de Datos");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setBounds(500, 500, 500, 500);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panelTabla = new PanelTabla();
		getContentPane().add(panelTabla, BorderLayout.CENTER);
		
		panelDatos = new PanelDatos();
		getContentPane().add(panelDatos, BorderLayout.WEST);
		
		
		
		panelMenu = new Menu();
		getContentPane().add(panelMenu, BorderLayout.NORTH);
                
                this.setVisible(true);
		

	}

}
