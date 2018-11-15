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
    private JButton btnBuscar;
    private JButton btnCancelar;
    private PanelMostrarInfoVentRegistro panelMostrarInfo;
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

        JButton btnCancelar = new JButton("Limpiar");
        panelBotones.add(btnCancelar);

        JPanel panelMostrarListaInfo = new JPanel();
        this.add(panelMostrarListaInfo, BorderLayout.WEST);
        panelMostrarListaInfo.setLayout(new BoxLayout(panelMostrarListaInfo, BoxLayout.Y_AXIS));

        JLabel lblFecha_1 = new JLabel("Fecha:");
        panelMostrarListaInfo.add(lblFecha_1);

        JLabel lblCodigo_1 = new JLabel("Codigo:");
        panelMostrarListaInfo.add(lblCodigo_1);

        JLabel lblTipo = new JLabel("Tipo:");
        panelMostrarListaInfo.add(lblTipo);

        JLabel lblCantidadDeStock = new JLabel("Cantidad de Stock:");
        panelMostrarListaInfo.add(lblCantidadDeStock);

        JLabel lblClase = new JLabel("Clase:");
        panelMostrarListaInfo.add(lblClase);
    }
}
