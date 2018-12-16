/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelMenuVentPrincipal extends JPanel implements ActionListener{
	
    
    public  JMenuItem mntmCerrarSesion;
    
    private JMenuItem mntmVerRegistroGeneral;
    private JMenuItem mntmVerRegistroDe;
    public  JMenuItem mntmAcerca;
    public  JMenuItem mntmLimpiar;
    public  JMenuItem mntmCopiar;
    public  JMenuItem mntmOrdenar;
    public  JMenuItem mntmSalir;
    
    public PanelMenuVentPrincipal() {
		this.inicializarComponentes();
	}

	private void inicializarComponentes() {
		this.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menu = new JMenuBar();
		this.add(menu, BorderLayout.NORTH);
		
		JMenu mnArchivo= new JMenu("Archivo");
		menu.add(mnArchivo);
		
		this.mntmCerrarSesion = new JMenuItem("Cerrar Sesión");
		mnArchivo.add(this.mntmCerrarSesion);
		
                this.mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(this.mntmSalir);
                this.mntmSalir.addActionListener(this);
                
		JMenu mnEditar = new JMenu("Editar");
		menu.add(mnEditar);
		
		this.mntmLimpiar = new JMenuItem("Copiar");
		mnEditar.add(this.mntmLimpiar);
		
		this.mntmCopiar = new JMenuItem("Pegar");
		mnEditar.add(this.mntmCopiar);
		
		
		
		JMenu mnOpciones = new JMenu("Opciones");
		menu.add(mnOpciones);
                
                this.mntmOrdenar = new JMenuItem("Ordernar por fecha");
		mnOpciones.add(this.mntmOrdenar);
                
		JMenu mnRegistro = new JMenu("Registro");
		menu.add(mnRegistro);
                
                
		this.mntmVerRegistroGeneral = new JMenuItem("Ver Registro General");
		mnRegistro.add(this.mntmVerRegistroGeneral);
		this.mntmVerRegistroGeneral.addActionListener((ActionListener) this);
                
		this.mntmVerRegistroDe = new JMenuItem("Ver Registro de este Ordenador");
		mnRegistro.add(this.mntmVerRegistroDe);
		
		JMenu mnAcercaDe = new JMenu("Acerca de");
		menu.add(mnAcercaDe);
		
		this.mntmAcerca = new JMenuItem("Acerca de aplicación");
                this.mntmAcerca.addActionListener((ActionListener)this);
		mnAcercaDe.add(this.mntmAcerca);
        }
                   
        public void actionPerformed(ActionEvent e) {
            if(this.mntmVerRegistroGeneral==e.getSource()){
                VentanaRegistro v = new VentanaRegistro();
            }else if(this.mntmAcerca==e.getSource()){
                
                JOptionPane.showMessageDialog(this, 
                        "Lincodel 2018\nProyecto con propósito de aprendizaje\nUfro - "
                                + "facultad de Ingenieria informatica","acerca"
                        ,JOptionPane.INFORMATION_MESSAGE);
            }else if(this.mntmSalir==e.getSource()){
                this.setVisible(false);
                System.exit(0);
                
            }
            
        }
                
	}
        

