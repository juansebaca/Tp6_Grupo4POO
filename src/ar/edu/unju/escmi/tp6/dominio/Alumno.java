package ar.edu.unju.escmi.tp6.dominio;

public class Alumno extends Usuario {
    private String numLibreta;
    private String curso;

    public Alumno(int id, String nombre, String apellido, String email, String numLibreta, String curso) {
        super(id, nombre, apellido, email);
        this.numLibreta = numLibreta;
        this.curso = curso;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Alumno: " + nombre + " " + apellido + " - Libreta: " + numLibreta + " - Curso: " + curso);
    }
}