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

    public boolean almacenarObjeto(Object objeto, String NOMBRE/*objetos.json*/) {
        ArrayList<Object> lista;
        boolean valorReturn = false;
        if (this.recuperarJsonGenerico(NOMBRE) != null) {
            lista = this.recuperarJsonGenerico(NOMBRE);

        } else {
            lista = new ArrayList<>();

        }

        lista.add(objeto);
        valorReturn = escritorJson(lista, NOMBRE);
        return valorReturn;
    }

    private boolean escritorJson(ArrayList<Object> lista, String NOMBRE) {
        boolean valorReturn = false;
        Type listType = new TypeToken<List<Object>>() {
        }.getType();
        Gson gson = new Gson();
        String json = gson.toJson(lista, listType);
        System.out.println(json + " json");
        String jsonCodificado = codificador.codificarString(json);

        try (FileWriter file = new FileWriter(RUTA + NOMBRE)) {
            file.write(jsonCodificado);
            valorReturn = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valorReturn;
    }

    public ArrayList<Object> recuperarJsonGenerico(String NOMBRE) {
        Gson gson = new Gson();

        String textDecodificado = DecoJson(NOMBRE);

        return gson.fromJson(textDecodificado, new TypeToken<List<Object>>() {
        }.getType());
    }
    
    public ArrayList<Historial> recuperarJsonHistorial(String NOMBRE) {
        Gson gson = new Gson();

        String textDecodificado = DecoJson(NOMBRE);

        return gson.fromJson(textDecodificado, new TypeToken<List<Historial>>() {
        }.getType());
    }
    
    public ArrayList<Usuario> recuperarJsonUsuario(String NOMBRE/*objetos.json*/) {
        Gson gson = new Gson();

        String textDecodificado = DecoJson(NOMBRE);
        System.out.println(textDecodificado);

        return gson.fromJson(textDecodificado, new TypeToken<List<Usuario>>() {
        }.getType());

    }

    public ArrayList<Insumo> recuperarJsonInsumos(String NOMBRE/*insumos.json*/) {
        Gson gson = new Gson();

        String textDecodificado = DecoJson(NOMBRE);
        return gson.fromJson(textDecodificado, new TypeToken<List<Insumo>>() {
        }.getType());
    }

    private String DecoJson(String NOMBRE) {
        BufferedReader br = null;
        try {
            System.out.println(RUTA + " RUTA");
            System.out.println(NOMBRE + " NOMBRE");
            br = new BufferedReader(new FileReader(RUTA + NOMBRE));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this.codificador.decodificar(br.lines().collect(Collectors.joining()));

    }

    public boolean removerObjetoJson(Insumo i, String NOMBRE) {
        if (recuperarJsonGenerico(NOMBRE) != null) {
            ArrayList<Insumo> insumos = recuperarJsonInsumos(NOMBRE);

            ArrayList<Object> obj = new ArrayList<>();
            for (Insumo insumo : insumos) {
                if (!(insumo.getCodigo().equals(i.getCodigo())
                        && insumo.getCantidad() == i.getCantidad()
                        && insumo.getNombreInsumo().equals(i.getNombreInsumo())
                        && insumo.getPresentacion().equals(i.getPresentacion())
                        && insumo.getTipo().equals(i.getTipo())
                        && insumo.getFecha().equals(i.getFecha())
                        && insumo.getUnidadMedida().equals(i.getUnidadMedida()))) {
                    obj.add((Object) insumo);
                }

            }
            return escritorJson(obj, NOMBRE);
        } else {
            return false;
        }
    }
    
    public boolean modificarObjetoJson(Insumo i, String NOMBRE, int nuevaCantidad){
        
        if (recuperarJsonGenerico(NOMBRE) != null) {
            ArrayList<Insumo> insumos = recuperarJsonInsumos(NOMBRE);

            ArrayList<Object> obj = new ArrayList<>();
            for (Insumo insumo : insumos) {
                if ((insumo.getCodigo().equals(i.getCodigo())
                        && insumo.getCantidad() == i.getCantidad()
                        && insumo.getNombreInsumo().equals(i.getNombreInsumo())
                        && insumo.getPresentacion().equals(i.getPresentacion())
                        && insumo.getTipo().equals(i.getTipo())
                        && insumo.getFecha().equals(i.getFecha())
                        && insumo.getUnidadMedida().equals(i.getUnidadMedida()))) {
                    insumo.setCantidad(nuevaCantidad);
                }
                
                obj.add((Object) insumo);
            }
            return escritorJson(obj, NOMBRE);
        } else {
            return false;
        }
    }
    
    //funcion de prueba
    public  boolean borrarHistorial(String NOMBRE){
        boolean valorReturn =false;
        try (FileWriter file = new FileWriter(RUTA + NOMBRE)) {
            file.write("");
           valorReturn=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valorReturn;
    }
}
