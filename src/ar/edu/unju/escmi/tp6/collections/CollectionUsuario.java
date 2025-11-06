package ar.edu.unju.escmi.tp6.collections;

import ar.edu.unju.escmi.tp6.dominio.Usuario;
import ar.edu.unju.escmi.tp6.exceptions.UsuarioNoRegistradoException;

import java.util.ArrayList;
import java.util.List;

public class CollectionUsuario {
    public static List<Usuario> usuarios = new ArrayList<>();

    public static void guardarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static Usuario buscarUsuario(Integer id) throws UsuarioNoRegistradoException {
        return usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UsuarioNoRegistradoException("Usuario con ID " + id + " no registrado"));
    }

    public static void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        usuarios.forEach(Usuario::mostrarDatos);
    }
}