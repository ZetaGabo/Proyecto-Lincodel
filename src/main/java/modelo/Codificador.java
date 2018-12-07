/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Base64;

/**
 *
 * @author usuario
 */
public class Codificador {

    public Codificador() {
    }
    
    public  String codificarString(String dato) {

        return Base64.getEncoder().encodeToString(dato.getBytes());
    }
    
    
    public  String decodificar(String dato) {

        
        return new String(Base64.getDecoder().decode(dato));
        
       
    }
}
