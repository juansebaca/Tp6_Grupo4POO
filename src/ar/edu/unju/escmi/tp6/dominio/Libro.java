package ar.edu.unju.escmi.tp6.dominio;

public class Libro {
    private Integer id;
    private String autor;
    private String titulo;
    private String isbn;
    private boolean estado; // true = disponible

    public Libro(Integer id, String autor, String titulo, String isbn, boolean estado) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.isbn = isbn;
        this.estado = estado;
    }

    public Integer getId() { return id; }
    public String getAutor() { return autor; }
    public String getTitulo() { return titulo; }
    public String getIsbn() { return isbn; }
    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }

    public void mostrarDatos() {
        System.out.println("ID: " + id +
                           " | Título: " + titulo +
                           " | Autor: " + autor +
                           " | ISBN: " + isbn +
                           " | Estado: " + (estado ? "Disponible" : "No disponible"));
    }

    @Override
    public String toString() {
        return "Libro{id=" + id + ", titulo='" + titulo + '\'' + ", autor='" + autor + '\'' + ", isbn='" + isbn + '\'' + ", estado=" + estado + '}';
    }
}