/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import javax.swing.JPanel;


/**
 *
 * @author usuario
 */
public class PanelCentralSuperiorVentRegistro extends JPanel{
    
    public  PanelFormularioVentRegistro panelFormulario;
    public  PanelInformacionVentRegistro panelInformacion;
    public PanelCentralSuperiorVentRegistro(){
        inicializarComponentes();
    }
    
    public void inicializarComponentes (){
        this.setLayout(new BorderLayout(0, 0));

        this. panelFormulario = new PanelFormularioVentRegistro();
        this.add(this.panelFormulario, BorderLayout.WEST);
        
        this. panelInformacion = new PanelInformacionVentRegistro();
        this.add(this.panelInformacion, BorderLayout.CENTER);
        
        
    }
}
