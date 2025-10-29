package ar.edu.unju.escmi.tp6.collections;

import java.util.ArrayList;
import ar.edu.unju.escmi.tp6.dominio.Usuario;
import ar.edu.unju.escmi.tp6.exceptions.UsuarioNoRegistradoException;

public class CollectionUsuario {
    public static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static void guardarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static Usuario buscarUsuario(int id) throws UsuarioNoRegistradoException {
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        throw new UsuarioNoRegistradoException("Usuario con ID " + id + " no está registrado.");
    }

    public static void mostrarUsuarios() {
        for (Usuario u : usuarios) u.mostrarDatos();
    }
}