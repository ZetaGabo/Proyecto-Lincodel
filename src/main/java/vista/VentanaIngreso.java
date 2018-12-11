package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.InicioSesion;

public final class VentanaIngreso extends JFrame implements ActionListener {

    private PanelUsuarioIngreso panelUsuario;
    private PanelBotonesIngreso panelBotones;
    private InicioSesion inicio = new InicioSesion();;
    
    public VentanaIngreso() {
        this.inicializarComponentes();
    }

    public void inicializarComponentes() {
        this.setSize(235,123);
        this.panelUsuario = new PanelUsuarioIngreso();
        this.panelBotones = new PanelBotonesIngreso();
        this.add(this.panelUsuario, BorderLayout.NORTH);
        this.add(this.panelBotones, BorderLayout.CENTER);
        this.setTitle("Ingreso de Usuario");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        panelBotones.btnAceptar.addActionListener(this);
        panelBotones.btnCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.panelBotones.btnAceptar) {
            String usuarioIngresado =this.panelUsuario.ingUsuario.getText();
            String contraseñaIngresada = this.panelUsuario.ingContrasena.getText();
            if(this.inicio.verificarUsuario(usuarioIngresado, contraseñaIngresada)){
                this.setVisible(false);
               VentanaPrincipal p = new VentanaPrincipal(this.inicio.obtenerValorDeAdministrador(usuarioIngresado, contraseñaIngresada));
             
            }else{
                JOptionPane.showMessageDialog(this,
    "La contraseña, o nombre de usuario son incorrectos, intentelo denuevo.",
    "Error de inicio",
    JOptionPane.ERROR_MESSAGE);
            }
            
            
        } else if (e.getSource() == this.panelBotones.btnCancelar) {
            System.exit(0);
        }
        
    }
}
