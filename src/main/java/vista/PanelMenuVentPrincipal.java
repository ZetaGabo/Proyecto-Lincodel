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
	
    
    private JMenuItem mntmIngresarInsumo;
    private JMenuItem mntmCopiar;
    private JMenuItem mntmPegar ;
    private JMenuItem mntmBorrar ;
    private JMenuItem mntmVerRegistroGeneral;
    private JMenuItem mntmVerRegistroDe;
    private JMenuItem mntmAcerca;
    public PanelMenuVentPrincipal() {
		this.inicializarComponentes();
	}

	private void inicializarComponentes() {
		this.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menu = new JMenuBar();
		this.add(menu, BorderLayout.NORTH);
		
		JMenu mnArchivo= new JMenu("Archivo");
		menu.add(mnArchivo);
		
		mntmIngresarInsumo = new JMenuItem("Ingresar Insumo");
		mnArchivo.add(mntmIngresarInsumo);
		
		JMenu mnEditar = new JMenu("Editar");
		menu.add(mnEditar);
		
		mntmCopiar = new JMenuItem("Copiar");
		mnEditar.add(mntmCopiar);
		
		mntmPegar = new JMenuItem("Pegar");
		mnEditar.add(mntmPegar);
		
		mntmBorrar = new JMenuItem("Borrar");
		mnEditar.add(mntmBorrar);
		
		JMenu mnOpciones = new JMenu("Opciones");
		menu.add(mnOpciones);
		
		JMenu mnRegistro = new JMenu("Registro");
		menu.add(mnRegistro);
                
                
		mntmVerRegistroGeneral = new JMenuItem("Ver Registro General");
		mnRegistro.add(mntmVerRegistroGeneral);
		mntmVerRegistroGeneral.addActionListener((ActionListener) this);
                
		mntmVerRegistroDe = new JMenuItem("Ver Registro de este Ordenador");
		mnRegistro.add(mntmVerRegistroDe);
		
		JMenu mnAcercaDe = new JMenu("Acerca de");
		menu.add(mnAcercaDe);
		
		mntmAcerca = new JMenuItem("Acerca de aplicación");
                this.mntmAcerca.addActionListener((ActionListener)this);
		mnAcercaDe.add(mntmAcerca);
        }
                   
        public void actionPerformed(ActionEvent e) {
            if(this.mntmVerRegistroGeneral==e.getSource()){
                VentanaRegistro v = new VentanaRegistro();
            }else if(this.mntmAcerca==e.getSource()){
                
                JOptionPane.showMessageDialog(this, 
                        "Lincodel 2018\nProyecto con propósito de aprendizaje\nUfro - "
                                + "facultad de Ingenieria informatica","acerca"
                        ,JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
                
	}
        

