package vista;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import javax.swing.JButton;

public class VentanaIngreso extends JFrame implements ActionListener{

	private JPanel panelUsuario;
        private JPanel panelContraseña;
        private JPanel panelBotones;
        private JLabel lblIngUsuario;
        private JLabel lblUsuario;
        private JLabel lblContraseña;
        private JTextField ingUsuario;
        private JTextField ingContraseña;
	private JButton btnAceptar;
        private JButton btnCancelar;
         
         public VentanaIngreso() {
		
		this.inicializarComponentes();
		
		
	}
	public void inicializarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 186);
		
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		lblIngUsuario = new JLabel("Ingreso de Usuario");
		lblIngUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblIngUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lblIngUsuario);
		
		panelUsuario = new JPanel();
		this.add(panelUsuario);
		
		lblUsuario = new JLabel("Usuario");
		panelUsuario.add(lblUsuario);
		
		ingUsuario = new JTextField();
		panelUsuario.add(ingUsuario);
		ingUsuario.setColumns(10);
		
		panelContraseña = new JPanel();
		this.add(panelContraseña);
		
		lblContraseña = new JLabel("Contraseña");
		panelContraseña.add(lblContraseña);
		
		ingContraseña = new JTextField();
		panelContraseña.add(ingContraseña);
		ingContraseña.setColumns(10);
		
		panelBotones = new JPanel();
		this.add(panelBotones);
		
		btnAceptar = new JButton("Aceptar");
		panelBotones.add(btnAceptar);
		btnAceptar.addActionListener(this);
                
		btnCancelar = new JButton("Cancelar");
		panelBotones.add(btnCancelar);
                
                this.setTitle("Iniciar Sesión");
                this.setVisible(true);
                
                
		
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        VentanaPrincipal p = new VentanaPrincipal();
        this.dispose();
    }

}
