/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author usuario
 */
public class PanelInformacionVentRegistro extends JPanel {

    
    private JPanel panelBotones;
    public  JButton btnBuscar;
    public  JButton btnLimpiar;
    public  PanelMostrarInfoVentRegistro panelMostrarInfo;
    private   JLabel lblNombre ;
    private   JLabel lblCodigo ;
    private  JLabel lblCantidad ;
    private  JLabel lblTipo;
    private  JLabel lblPresentacion ;
    private JLabel lblUnidadMedida;
    private JLabel lblFecha;
    private JLabel lblAccion;
    
    
    public PanelInformacionVentRegistro() {
        inicializarComponentes();
    }
   
    

    private void inicializarComponentes() {
       this.setLayout(new BorderLayout(0, 0));
    
        
        this.setLayout(new BorderLayout(0, 0));

        this.panelMostrarInfo = new PanelMostrarInfoVentRegistro();
        this.add(this.panelMostrarInfo, BorderLayout.CENTER);
        

        this.panelBotones = new JPanel();
        this.add(this.panelBotones, BorderLayout.SOUTH);

        this.btnBuscar = new JButton("Buscar");
        panelBotones.add(this.btnBuscar);

        this.btnLimpiar = new JButton("Limpiar");
        panelBotones.add(this.btnLimpiar);

        JPanel panelMostrarListaInfo = new JPanel();
        this.add(panelMostrarListaInfo, BorderLayout.WEST);
        panelMostrarListaInfo.setLayout(new BoxLayout(panelMostrarListaInfo, BoxLayout.Y_AXIS));

        this.lblNombre = new JLabel("Nombre:");
        panelMostrarListaInfo.add(this.lblNombre);

        this.lblCodigo = new JLabel("Codigo:");
        panelMostrarListaInfo.add(this.lblCodigo);

        this.lblCantidad = new JLabel("Cantidad:");
        panelMostrarListaInfo.add(this.lblCantidad);

        this.lblTipo = new JLabel("Tipo:");
        panelMostrarListaInfo.add(this.lblTipo);

        this.lblPresentacion = new JLabel("Presentación:");
        panelMostrarListaInfo.add(this.lblPresentacion);
        
        this.lblFecha = new JLabel("Unidad de medida:");
        panelMostrarListaInfo.add(this.lblFecha);
        
        this.lblFecha = new JLabel("Fecha:");
        panelMostrarListaInfo.add(this.lblFecha);
        
        this.lblAccion = new JLabel("Accion:");
        panelMostrarListaInfo.add(this.lblAccion);
    }
}
