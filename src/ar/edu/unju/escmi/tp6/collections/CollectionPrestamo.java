package ar.edu.unju.escmi.tp6.collections;

import ar.edu.unju.escmi.tp6.dominio.Prestamo;
import ar.edu.unju.escmi.tp6.dominio.Libro;
import ar.edu.unju.escmi.tp6.exceptions.LibroNoDisponibleException;
import ar.edu.unju.escmi.tp6.exceptions.LibroNoEncontradoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CollectionPrestamo {
    public static List<Prestamo> prestamos = new ArrayList<>();

    public static void guardarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public static Prestamo buscarPrestamoPorId(Integer id) {
        return prestamos.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public static void mostrarPrestamos() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
            return;
        }
        prestamos.forEach(Prestamo::mostrarDatos);
    }

    // registrar la devolución por id de préstamo
    public static void registrarDevolucion(Integer idPrestamo, LocalDate fechaDevolucion) throws Exception {
        Prestamo p = buscarPrestamoPorId(idPrestamo);
        if (p == null) {
            throw new Exception("Préstamo con id " + idPrestamo + " no encontrado.");
        }
        p.registrarDevolucion(fechaDevolucion);
    }
}