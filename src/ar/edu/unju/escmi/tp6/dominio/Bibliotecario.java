package ar.edu.unju.escmi.tp6.dominio;

public class Bibliotecario extends Usuario {
    private Integer legajo;

    public Bibliotecario(Integer id, String nombre, String apellido, String email, Integer legajo) {
        super(id, nombre, apellido, email);
        this.legajo = legajo;
    }

    public Integer getLegajo() { return legajo; }

    @Override
    public void mostrarDatos() {
        System.out.println("Bibliotecario: " + nombre + " " + apellido + " | ID: " + id + " | Legajo: " + legajo + " | Email: " + email);
    }
}