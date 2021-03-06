/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import modelo.Insumo;
import modelo.TipoInsumo;

public class PanelDatosVentPrincipal extends JPanel {

    private GridLayout distribucion;
    
    private boolean esAdministrador;

    private TipoInsumo tipoInsumo;
    private JScrollPane scroll;
    private JLabel lblNombre;
    public JTextField ingNombre;
    private JLabel lblCodigo;
    public JTextField ingCodigo;

    private JLabel lblCantidad;
    public JTextField ingCantidad;

    public JComboBox CbxIngTipo;
    private JLabel lblTipo;

    private JLabel lblUnidadMedida;
    public JTextField ingUnidadMedida;

    private JLabel lblPresentacion;
    public JTextField ingPresentacion;

    public JButton btnAgregar;
    public JButton btnBorrar;

    public PanelDatosVentPrincipal(boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
        if(this.esAdministrador) this.inicializarComponentesAdmin();
        else this.inicializarComponentesComun();
    }

    private void inicializarComponentesAdmin() {
        this.distribucion = new GridLayout(7, 2, 1, 60);
        this.setLayout(distribucion);

        //nombre
        this.lblNombre = new JLabel("Nombre");
        this.add(this.lblNombre, distribucion);
        this.ingNombre = new JTextField();
        this.ingNombre.setColumns(10);
        this.add(this.ingNombre, distribucion);

        //codigo
        this.lblCodigo = new JLabel("Código");
        this.add(this.lblCodigo, distribucion);
        this.ingCodigo = new JTextField();
        this.ingCodigo.setColumns(10);
        this.add(this.ingCodigo, distribucion);

        //cantidad
        this.lblCantidad = new JLabel("Cantidad");
        this.add(this.lblCantidad, distribucion);
        this.ingCantidad = new JTextField();
        this.ingCantidad.setColumns(10);
        this.add(this.ingCantidad, distribucion);
        this.ingCantidad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c)
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();

                }
            }
        });

        //combo box: tipo de insumo + texto
        this.lblTipo = new JLabel();
        this.lblTipo.setText("Ingrese tipo de insumo");
        this.add(this.lblTipo, distribucion);

        this.CbxIngTipo = new JComboBox();
        for (TipoInsumo ti : TipoInsumo.values()) {
            this.CbxIngTipo.addItem(ti.toString());
        }

        this.add(this.CbxIngTipo, distribucion);

        //unidad de medida
        this.lblUnidadMedida = new JLabel();
        this.lblUnidadMedida.setText("Unidad De Medida");
        this.add(this.lblUnidadMedida, distribucion);
        this.ingUnidadMedida = new JTextField();
        this.ingUnidadMedida.setColumns(10);
        this.add(this.ingUnidadMedida, distribucion);

        //ingresar presentacion
        this.lblPresentacion = new JLabel();
        this.lblPresentacion.setText("Presentación");
        this.add(this.lblPresentacion, distribucion);
        this.ingPresentacion = new JTextField();
        this.ingPresentacion.setColumns(10);
        this.add(this.ingPresentacion, distribucion);

        //botones
        this.btnAgregar = new JButton("Agregar");
        this.add(this.btnAgregar);
        this.btnBorrar = new JButton("Borrar");
        this.add(this.btnBorrar);

        //scroll
//        this.scroll = new JScrollPane();
//        this.scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        this.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        //this.add(this.scroll,distribucion);

    }
    
     private void inicializarComponentesComun() {
       this.distribucion = new GridLayout(2, 1, 0, 300);
        this.setLayout(distribucion);
        
        this.lblCantidad = new JLabel("Cantidad");
        this.add(this.lblCantidad, distribucion);
        this.ingCantidad = new JTextField();
        this.ingCantidad.setColumns(10);
        
        this.add(this.ingCantidad, distribucion);
        this.ingCantidad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c)
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();

                }
            }
        });
        
        this.btnAgregar = new JButton("modificar");
        this.add(this.btnAgregar);
     }

    public Insumo getAllData() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String fecha = dtf.format(now);

        System.out.println(this.ingCantidad.getText());
        if (!(this.ingCantidad.getText().isEmpty() || this.ingCodigo.getText().isEmpty() || this.ingNombre.getText().isEmpty()
                || this.ingPresentacion.getText().isEmpty() || this.ingUnidadMedida.getText().isEmpty())) {

            Insumo i = new Insumo(this.ingNombre.getText(),
                    this.ingCodigo.getText(),
                    Integer.parseInt(this.ingCantidad.getText()),
                    (String) this.CbxIngTipo.getSelectedItem(),
                    this.ingPresentacion.getText(),
                    this.ingUnidadMedida.getText(),
                    fecha);
            System.out.println(i.toString());

            return i;
        }
        return null;
    }

   
}
