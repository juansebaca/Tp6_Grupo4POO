package ar.edu.unju.escmi.tp6.dominio;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private boolean estado; // true = disponible, false = no disponible

    public Libro(int id, String titulo, String autor, String isbn, boolean estado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.estado = estado;
    }

    public int getId() { return id; }
    public boolean isDisponible() { return estado; }
    public void setDisponible(boolean estado) { this.estado = estado; }

    public void mostrarDatos() {
        String disponibilidad = estado ? "Disponible" : "No disponible";
        System.out.println("Libro: " + titulo + " (" + autor + ") - " + disponibilidad);
    }
}