/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
/**
 *
 * @author usuario
 */
public class Usuario {
    
    private String nombreUsuario;
    private String contraseña;
    private Boolean permisosDeAdministrador;


    
    public Boolean getPermisosDeAdministrador() {
        return permisosDeAdministrador;
    }

    public Usuario(String nombreUsuario, String contraseña, Boolean permisosDeAdministrador) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.permisosDeAdministrador =  permisosDeAdministrador;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombreUsuario=" + nombreUsuario + ", contrase\u00f1a=" + contraseña + ", permisosDeAdministrador=" + permisosDeAdministrador + '}';
    }

    

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }
    
    
}
