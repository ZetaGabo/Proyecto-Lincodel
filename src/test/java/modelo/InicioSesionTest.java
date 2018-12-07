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
public class InicioSesionTest {
    
    InicioSesion inicio = new InicioSesion();
    
    public InicioSesionTest() {
    }

    @Test
    public void testCodificarString() {
    }

    @Test
    public void testDecodificar() {
    }

    @Test
    public void testVerificarNombreUsuario() {
        
        inicio.verificarNombreUsuario("mario");
    }

    @Test
    public void testVerificarContraseña() {
        inicio.verificarContraseña("123");
    }
    
}
