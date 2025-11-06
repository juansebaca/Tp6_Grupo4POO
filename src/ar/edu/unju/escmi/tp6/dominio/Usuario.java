package ar.edu.unju.escmi.tp6.dominio;

public abstract class Usuario {
    protected Integer id;
    protected String nombre;
    protected String apellido;
    protected String email;

    public Usuario(Integer id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public Integer getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEmail() { return email; }

    public abstract void mostrarDatos();

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nombre=" + nombre + " " + apellido + ", email=" + email + "}";
    }
}