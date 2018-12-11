/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author usuario
 */
public class InicioSesionTest {
    
    InicioSesion inicio;
    
    public InicioSesionTest() {
    }

    @Before
    public void setUp(){
         inicio=new InicioSesion();
    }
    
    @Test
    public void testVerificarUsuario() {
        
        assertTrue(inicio.verificarUsuario("mario", "123"));
        
    }
   
    @Test
    public void testObtenerValorAdministrador(){
        
        assertTrue(inicio.obtenerValorDeAdministrador("mario", "123"));
        
        
    }
}
