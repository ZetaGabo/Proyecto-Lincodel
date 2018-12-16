/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author usuario
 */
public class Historial {

    private final String nombreInsumo;
    private final String codigo;
    private final int cantidad;
 
    private final String tipo;
    
    private final String presentacion;
    private final String unidadMedida;
    private final String Fecha;
    private final int accion;

    public Historial(String nombreInsumo, String codigo, int cantidad, String tipo, String presentacion, String unidadMedida, String Fecha, int accion) {
        this.nombreInsumo = nombreInsumo;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.presentacion = presentacion;
        this.unidadMedida = unidadMedida;
        this.Fecha = Fecha;
        this.accion = accion;
    }

    @Override
    public String toString() {
        return "Historial{" + "nombreInsumo=" + nombreInsumo + ", codigo=" + codigo + ", cantidad=" + cantidad + ", tipo=" + tipo + ", presentacion=" + presentacion + ", unidadMedida=" + unidadMedida + ", Fecha=" + Fecha + ", accion=" + accion + '}';
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public String getFecha() {
        return Fecha;
    }

    public int getAccion() {
        return accion;
    }


}