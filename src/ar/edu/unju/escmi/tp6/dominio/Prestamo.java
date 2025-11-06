package ar.edu.unju.escmi.tp6.dominio;

import java.time.LocalDate;

public class Prestamo {
    private Integer id;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Libro libro;
    private Usuario usuario;

    public Prestamo(Integer id, LocalDate fechaPrestamo, LocalDate fechaDevolucion, Libro libro, Usuario usuario) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.libro = libro;
        this.usuario = usuario;
    }

    public Integer getId() { return id; }
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public Libro getLibro() { return libro; }
    public Usuario getUsuario() { return usuario; }

    public void registrarDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        if (libro != null) libro.setEstado(true); // marcar libro como disponible
    }

    public void mostrarDatos() {
        System.out.println("Préstamo ID: " + id);
        System.out.println("Libro: " + (libro != null ? libro.getTitulo() + " (ID " + libro.getId() + ")" : "N/A"));
        System.out.println("Usuario: " + (usuario != null ? usuario.getNombre() + " " + usuario.getApellido() + " (ID " + usuario.getId() + ")" : "N/A"));
        System.out.println("Fecha préstamo: " + fechaPrestamo);
        System.out.println("Fecha devolución: " + (fechaDevolucion == null ? "No devuelto" : fechaDevolucion));
        System.out.println("---------------------------------------------------");
    }

    @Override
    public String toString() {
        return "Prestamo{id=" + id + ", libro=" + (libro != null ? libro.getTitulo() : "null") + ", usuario=" + (usuario != null ? usuario.getId() : "null") + "}";
    }
}