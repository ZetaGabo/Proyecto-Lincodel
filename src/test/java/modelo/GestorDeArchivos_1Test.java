/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
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
        Usuario u = new Usuario("mario","123",true);
        List<Object> ob = new ArrayList<>();
        ob.add(u);
        String NOMBRE = "objetos.json";
        g.almacenarObjeto(ob, NOMBRE);
    }

    
    
}
