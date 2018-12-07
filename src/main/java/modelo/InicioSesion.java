package modelo;

import java.util.ArrayList;
import java.util.Base64;

/**
 * @author usuario
 */
public class InicioSesion {

    ArrayList<Usuario> usuarios;
    private final GestorDeArchivos gestor = new GestorDeArchivos();

    public InicioSesion() {
        obtenerUsuariosAlmacenado();
    }

    


    public boolean verificarNombreUsuario(String nombreUsuarioIngresado) {
        boolean valorReturn = false;
        
       
        for (Usuario usuario : usuarios) {

            valorReturn = nombreUsuarioIngresado.equalsIgnoreCase(usuario.getNombreUsuario());
        }

        return valorReturn;
    }

    public boolean verificarContraseña(String contraseñaIngresada) {
        boolean valorReturn = false;

        for (Usuario usuario : usuarios) {
            
        valorReturn = contraseñaIngresada.equalsIgnoreCase(usuario.getContraseña());

        }
        return valorReturn;

    }

    private void obtenerUsuariosAlmacenado() {
        this.usuarios = this.gestor.recuperarJsonUsuarios();

    }

}
