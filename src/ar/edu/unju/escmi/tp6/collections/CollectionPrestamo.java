package ar.edu.unju.escmi.tp6.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import ar.edu.unju.escmi.tp6.dominio.Prestamo;

public class CollectionPrestamo {
    public static ArrayList<Prestamo> prestamos = new ArrayList<>();

    public static void guardarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public static void mostrarPrestamos() {
        for (Prestamo p : prestamos) p.mostrarDatos();
    }

    public static void registrarDevolucion(Prestamo prestamo, LocalDate fechaDevolucion) {
        prestamo.registrarDevolucion(fechaDevolucion);
    }
}