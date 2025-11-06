package ar.edu.unju.escmi.tp6.dominio;

public class Alumno extends Usuario {
    private String numLibreta;
    private String curso;

    public Alumno(Integer id, String nombre, String apellido, String email, String numLibreta, String curso) {
        super(id, nombre, apellido, email);
        this.numLibreta = numLibreta;
        this.curso = curso;
    }

    public String getNumLibreta() { return numLibreta; }
    public String getCurso() { return curso; }

    @Override
    public void mostrarDatos() {
        System.out.println("Alumno: " + nombre + " " + apellido + " | ID: " + id + " | Libreta: " + numLibreta + " | Curso: " + curso + " | Email: " + email);
    }
}