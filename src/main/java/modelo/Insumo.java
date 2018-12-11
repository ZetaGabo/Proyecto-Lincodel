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
    private final Date Fecha;
    private final long stock;
    private final String descripcion;
    private final TipoInsumo tipo;
    private final String unidadMedida;
    private final long precio;

    public Insumo(String nombreInsumo, Date Fecha, long stock, String descripcion, 
           TipoInsumo tipo, String unidadMedida, long precio) {
        
        this.nombreInsumo = nombreInsumo;
        this.Fecha = Fecha;
        this.stock = stock;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.unidadMedida = unidadMedida;
        this.precio = precio;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public Date getFecha() {
        return Fecha;
    }

    public long getStock() {
        return stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public TipoInsumo getTipo() {
        return tipo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public long getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Insumo{" + "nombreInsumo=" + nombreInsumo + ", Fecha=" + Fecha 
                + ", stock=" + stock + ", descripcion=" + descripcion + ", tipo=" 
                + tipo + ", unidadMedida=" + unidadMedida + ", precio=" + precio + '}';
    }
    
    
    
    
}
