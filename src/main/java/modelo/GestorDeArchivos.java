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
    private Codificador codificador = new Codificador();
    ArrayList<Usuario> usuarios = new ArrayList<>();
    private final String RUTA = "datosAlmacenados/";
    private final String NOMBRE = "objetos.json";

    public GestorDeArchivos() {

    }
    public boolean almacenarUsuario(String usuarioIngresado, String contraseñaIngresada){
        boolean valorReturn=false;
        
        usuario = new Usuario(usuarioIngresado,contraseñaIngresada);
        this.usuarios.add(usuario);
        
        Type listType =new TypeToken<List<Usuario>>() {}.getType();
        Gson gson = new Gson();
        String json = gson.toJson(usuarios,listType);
        
        String jsonCodificado = codificador.codificarString(json);
                
        try (FileWriter file = new FileWriter(RUTA+NOMBRE)){
                file.write(jsonCodificado);
                valorReturn = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        return valorReturn;
    }
    public ArrayList<Usuario> recuperarJsonUsuarios(){
        Gson gson = new Gson();
        BufferedReader br = null;
              try {
                br =new BufferedReader(new FileReader(RUTA+NOMBRE));
            } catch (Exception e) {
                  e.printStackTrace();
            }
              
              String textDecodificado = codificador.decodificar(br.lines().collect(Collectors.joining()));
              this.usuarios = gson.fromJson(textDecodificado, new TypeToken<List<Usuario>>() {}.getType());
   
      
        return this.usuarios;
    }
}
