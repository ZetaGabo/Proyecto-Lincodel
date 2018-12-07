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
import javax.swing.JPanel;

public class PanelMenuVentPrincipal extends JPanel implements ActionListener{
	public PanelMenuVentPrincipal() {
		this.inicializarComponentes();
	}

	private void inicializarComponentes() {
		this.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menu = new JMenuBar();
		this.add(menu, BorderLayout.NORTH);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menu.add(mnArchivo);
		
		JMenuItem mntmIngresarInsumo = new JMenuItem("Ingresar Insumo");
		mnArchivo.add(mntmIngresarInsumo);
		
		JMenu mnEditar = new JMenu("Editar");
		menu.add(mnEditar);
		
		JMenuItem mntmCopiar = new JMenuItem("Copiar");
		mnEditar.add(mntmCopiar);
		
		JMenuItem mntmPegar = new JMenuItem("Pegar");
		mnEditar.add(mntmPegar);
		
		JMenuItem mntmBorrar = new JMenuItem("Borrar");
		mnEditar.add(mntmBorrar);
		
		JMenu mnOpciones = new JMenu("Opciones");
		menu.add(mnOpciones);
		
		JMenu mnRegistro = new JMenu("Registro");
		menu.add(mnRegistro);
                
                
		JMenuItem mntmVerRegistroGeneral = new JMenuItem("Ver Registro General");
		mnRegistro.add(mntmVerRegistroGeneral);
		mntmVerRegistroGeneral.addActionListener((ActionListener) this);
                
		JMenuItem mntmVerRegistroDe = new JMenuItem("Ver Registro de este Ordenador");
		mnRegistro.add(mntmVerRegistroDe);
		
		JMenu mnAcercaDe = new JMenu("Acerca de");
		menu.add(mnAcercaDe);
		
		JMenuItem mntmAcerca = new JMenuItem("Acerca de aplicación");
		mnAcercaDe.add(mntmAcerca);
        }
                   
        public void actionPerformed(ActionEvent e) {
            VentanaRegistro v = new VentanaRegistro();
        }
                
	}
        

