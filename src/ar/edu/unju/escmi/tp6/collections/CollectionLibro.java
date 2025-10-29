package ar.edu.unju.escmi.tp6.collections;

import java.util.ArrayList;
import ar.edu.unju.escmi.tp6.dominio.Libro;
import ar.edu.unju.escmi.tp6.exceptions.LibroNoDisponibleException;
import ar.edu.unju.escmi.tp6.exceptions.LibroNoEncontradoException;

public class CollectionLibro {
    public static ArrayList<Libro> libros = new ArrayList<>();

    public static void guardarLibro(Libro libro) {
        libros.add(libro);
    }

    public static Libro buscarLibro(int id) throws LibroNoEncontradoException {
        for (Libro l : libros) {
            if (l.getId() == id) return l;
        }
        throw new LibroNoEncontradoException("El libro con ID " + id + " no fue encontrado.");
    }

    public static void verificarDisponibilidad(Libro libro) throws LibroNoDisponibleException {
        if (!libro.isDisponible()) {
            throw new LibroNoDisponibleException("El libro '" + libro + "' no está disponible.");
        }
    }

    public static void mostrarLibros() {
        for (Libro l : libros) l.mostrarDatos();
    }
}