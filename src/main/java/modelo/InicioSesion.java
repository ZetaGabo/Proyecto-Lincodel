package modelo;

import java.util.ArrayList;

/**
 * @author usuario
 */
public class InicioSesion {

    ArrayList<Usuario> usuarios;

    private final GestorDeArchivos gestor = new GestorDeArchivos();
    private final String NOMBRE = "objetos.json";

    public InicioSesion() {
        obtenerUsuariosAlmacenado();
    }

    public boolean verificarUsuario(String nombreUsuarioIngresado, String contraseñaIngresada) {

        return this.usuarios.stream().anyMatch(u -> u.getContraseña().equals(contraseñaIngresada) && u.getNombreUsuario().equals(nombreUsuarioIngresado));

    }

    private void obtenerUsuariosAlmacenado() {

        this.usuarios = this.gestor.recuperarJsonUsuario(this.NOMBRE);

    }

    public boolean obtenerValorDeAdministrador(String nombreUsuarioIngresado, String contraseñaIngresada) {
        boolean valorReturn = false;
//        for (Usuario usuario : this.usuarios) {
//            if(usuario.equals(new Usuario(nombreUsuarioIngresado, contraseñaIngresada, usuario.getPermisosDeAdministrador()))){
//                valorReturn = usuario.getPermisosDeAdministrador();break;
//            }
//        }
        for (Usuario usuario : this.usuarios) {

            if (usuario.getContraseña().equals(contraseñaIngresada) && usuario.getNombreUsuario().equals(nombreUsuarioIngresado)) {

                valorReturn = usuario.getPermisosDeAdministrador();
                break;
            }

        }

        return valorReturn;

    }

}
