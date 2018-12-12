/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author usuario
 */
public class GestorDeArchivos {

    private Usuario usuario;
    private final Codificador codificador = new Codificador();
    ArrayList<Usuario> usuarios = new ArrayList<>();
    private final String RUTA = "datosAlmacenados/";
    

    public GestorDeArchivos() {

    }
    public boolean almacenarObjeto(Object objeto, String NOMBRE/*objetos.json*/){
        boolean valorReturn=false;
        
        
        
        Type listType =new TypeToken<List<Object>>() {}.getType();
        Gson gson = new Gson();
//        ArrayList<Object> lista=this.recuperarJsonGenerico(NOMBRE);
//        lista.add(objeto);
        
        String json = gson.toJson(objeto,listType);
        
        String jsonCodificado = codificador.codificarString(json);
                
        try (FileWriter file = new FileWriter(RUTA+NOMBRE)){
                file.write(jsonCodificado);
                valorReturn = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        return valorReturn;
    }
    
    public ArrayList<Object> recuperarJsonGenerico(String NOMBRE/*objetos.json*/){
        Gson gson = new Gson();

        String textDecodificado=DecoJson(NOMBRE);
        
        return gson.fromJson(textDecodificado, new TypeToken<List<Object>>() {}.getType());
    }
    
    
    public ArrayList<Usuario> recuperarJsonUsuario(String NOMBRE/*objetos.json*/){
         Gson gson = new Gson();

        String textDecodificado=DecoJson(NOMBRE);
        return gson.fromJson(textDecodificado, new TypeToken<List<Usuario>>() {}.getType());
    }
    
    
    private String DecoJson(String NOMBRE){
                BufferedReader br = null;
              try {
                br =new BufferedReader(new FileReader(RUTA+NOMBRE));
            } catch (Exception e) {
                  e.printStackTrace();
            }
              
             return codificador.decodificar(br.lines().collect(Collectors.joining()));
      
    }
}
