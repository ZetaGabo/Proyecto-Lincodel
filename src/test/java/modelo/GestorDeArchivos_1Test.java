/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class GestorDeArchivos_1Test {
    
    public GestorDeArchivos_1Test() {
    }

    @Test
    public void testAlmacenarUsuario() {
        GestorDeArchivos g = new GestorDeArchivos();
        Usuario u = new Usuario("nico","123",false);
        
        Object ob = u;
        String NOMBRE = "objetos.json";
       // g.almacenarObjeto(ob, NOMBRE);
    }
    @Test
    public void testBorrarObjeto(){
        
                
    }
    @Test
    public void testLimpiarHistorial(){
        GestorDeArchivos g = new GestorDeArchivos();
        boolean valor=g.borrarHistorial("historial.json");
        assertTrue(valor);
        
    }
    
}
