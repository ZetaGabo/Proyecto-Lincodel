/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author usuario
 */
public class Insumo {

    private final String nombreInsumo;
    private final String codigo;
    private final int cantidad;
 
    private final TipoInsumo tipo;
    
    private final String presentacion;
    private final String unidadMedida;
    private final String Fecha;

    @Override
    public String toString() {
        return "Insumo{" + "nombreInsumo=" + nombreInsumo + ", codigo=" + codigo + ", cantidad=" + cantidad + ", tipo=" + tipo + ", presentacion=" + presentacion + ", unidadMedida=" + unidadMedida + ", Fecha=" + Fecha + '}';
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public String getCodigo() {
        return codigo;
    }

    public long getCantidad() {
        return cantidad;
    }

    public TipoInsumo getTipo() {
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

    public Insumo(String nombreInsumo, String codigo, int cantidad, TipoInsumo tipo, String presentacion, String unidadMedida, String Fecha) {
        this.nombreInsumo = nombreInsumo;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.presentacion = presentacion;
        this.unidadMedida = unidadMedida;
        this.Fecha = Fecha;
    }


}