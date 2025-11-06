package ar.edu.unju.escmi.tp6.collections;

import ar.edu.unju.escmi.tp6.dominio.Libro;
import ar.edu.unju.escmi.tp6.exceptions.LibroNoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class CollectionLibro {
    public static List<Libro> libros = new ArrayList<>();

    public static void guardarLibro(Libro libro) {
        libros.add(libro);
    }

    public static Libro buscarLibro(Integer id) throws LibroNoEncontradoException {
        return libros.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new LibroNoEncontradoException("No se encontró el libro con ID " + id));
    }

    public static void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        libros.forEach(Libro::mostrarDatos);
    }
}