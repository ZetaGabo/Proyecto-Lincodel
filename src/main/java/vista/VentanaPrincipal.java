/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

import javax.swing.JFrame;

public final class VentanaPrincipal extends JFrame implements ActionListener {

    private PanelTablaVentPrincipal panelTabla;
    private PanelMenuVentPrincipal panelMenu;
    private PanelDatosVentPrincipal panelDatos;
    private GridBagConstraints c;
    private GridBagLayout distribucion;
    private final boolean esAdministrador;
    private DateTimeFormatter dtf ;
    /**
    *
    * @author usuario
     * @param esAdministrador
    */
    public VentanaPrincipal(boolean esAdministrador) {
    this.esAdministrador = esAdministrador;
        this.inicializarComponentes();
        this.obtenerDatos();

    }

    public void inicializarComponentes() {
        this.setTitle("Ventana de Datos");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.panelMenu = new PanelMenuVentPrincipal();
        this.add(panelMenu, BorderLayout.NORTH);
        this.panelDatos = new PanelDatosVentPrincipal();
        this.add(this.panelDatos, BorderLayout.WEST);
        this.panelTabla = new PanelTablaVentPrincipal();
        this.add(panelTabla, BorderLayout.CENTER);
        this.setVisible(true);
        //pack();
        
        //actionListener test
        this.panelDatos.btnAgregar.addActionListener(this);
        this.panelDatos.btnBorrar.addActionListener(this);
        
        this.dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.panelDatos.btnAgregar==e.getSource()){
        String dato1 = this.panelDatos.ingNombre.getText();
        String dato2 = this.panelDatos.ingCodigo.getText();
        String dato3 = this.panelDatos.ingCantidad.getText();
        String dato4 = this.panelDatos.CbxIngTipo.getSelectedItem().toString();
        String dato5 = this.panelDatos.ingPresentacion.getText();
        String dato6 = this.panelDatos.ingUnidadMedida.getText();
        LocalDateTime now = LocalDateTime.now();
        String dato7 = this.dtf.format(now);
        Object []row={dato1,dato2,dato3,dato4,dato5,dato6,dato7};
        this.panelTabla.modelo.addRow(row);
        }
        if(this.panelDatos.btnBorrar==e.getSource()){
            this.panelTabla.tabla.addMouseListener(new MouseAdapter() {
                @Override
    public void mouseReleased(MouseEvent e) {
        this
    }
            
            });
        }
    }

    private void obtenerDatos() {
        
    }

}
