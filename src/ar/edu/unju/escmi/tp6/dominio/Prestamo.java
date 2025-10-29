package ar.edu.unju.escmi.tp6.dominio;

import java.time.LocalDate;

public class Prestamo {
    private int id;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Libro libro;
    private Usuario usuario;

    public Prestamo(int id, LocalDate fechaPrestamo, Libro libro, Usuario usuario) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.libro = libro;
        this.usuario = usuario;
    }

    public void registrarDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        libro.setDisponible(true);
    }

    public void mostrarDatos() {
        System.out.println("Préstamo ID: " + id +
                "\nUsuario: " + usuario.nombre +
                "\nLibro: " + libro +
                "\nFecha préstamo: " + fechaPrestamo +
                "\nFecha devolución: " + (fechaDevolucion != null ? fechaDevolucion : "Pendiente"));
    }

    public Libro getLibro() { return libro; }
    public Usuario getUsuario() { return usuario; }
}