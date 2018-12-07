/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class GestorDeArchivosTest {
    
    GestorDeArchivos g = new GestorDeArchivos();
    
    public GestorDeArchivosTest() {
    }

    @Test
    public void testAlmacenarUsuario() {
        //g.almacenarUsuario("mario", "123");
    }

    @Test
    public void testRecuperarJson() {
        ArrayList<Usuario> a= g.recuperarJsonUsuarios();
      
        a.forEach((usuario) -> {
            System.out.println(usuario.toString());
        });
    }
    
}
