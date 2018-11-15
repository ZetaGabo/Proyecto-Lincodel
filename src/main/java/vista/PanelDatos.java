package vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelDatos extends JPanel {

    GridLayout distribucion;
    private JLabel lblNombre;
    private JTextField ingNombre;
    private JLabel lblCodigo;
    private JTextField ingCodigo;
    private JLabel lblCantidad;
    private JTextField ingCantidad;
    private JButton btnAgregar;
    private JButton btnBorrar;

    public PanelDatos() {
        this.inicializarComponentes();
    }

    private void inicializarComponentes() {
        this.distribucion = new GridLayout(4, 2, 1,100);
        this.setLayout(distribucion);
        this.lblNombre = new JLabel("Nombre");
        this.add(this.lblNombre, distribucion);
        this.ingNombre = new JTextField();
        this.ingNombre.setColumns(10);
        this.add(this.ingNombre, distribucion);
        this.lblCodigo = new JLabel("Código");
        this.add(this.lblCodigo, distribucion);
        this.ingCodigo = new JTextField();
        this.ingCodigo.setColumns(10);
        this.add(this.ingCodigo, distribucion);
        this.lblCantidad = new JLabel("Cantidad");
        this.add(this.lblCantidad, distribucion);
        this.ingCantidad = new JTextField();
        this.ingCantidad.setColumns(10);
        this.add(this.ingCantidad, distribucion);
        this.btnAgregar = new JButton("Agregar");
        this.add(this.btnAgregar);
        this.btnBorrar = new JButton("Borrar");
        this.add(this.btnBorrar);
    }
}
