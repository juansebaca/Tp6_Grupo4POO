package ar.edu.unju.escmi.tp6.principal;

import ar.edu.unju.escmi.tp6.dominio.*;
import ar.edu.unju.escmi.tp6.collections.*;
import ar.edu.unju.escmi.tp6.exceptions.*;
import ar.edu.unju.escmi.tp6.utils.FechaUtil;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // datos de prueba (opcionales)
        cargarDatosIniciales();

        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            try {
                int opcion = leerInt("Seleccione una opción: ");
                switch (opcion) {
                    case 1:
                        registrarLibro();
                        break;
                    case 2:
                        registrarUsuario();
                        break;
                    case 3:
                        prestamoLibro();
                        break;
                    case 4:
                        devolucionLibro();
                        break;
                    case 5:
                        CollectionLibro.mostrarLibros();
                        break;
                    case 6:
                        System.out.println("Saliendo...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Entrada inválida: " + ime.getMessage());
                scanner.nextLine(); // limpiar buffer si hace falta
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            } finally {
                System.out.println(); // separación visual
            }
        }
        // No cerramos System.in para evitar problemas si se reutiliza
    }

    private static void mostrarMenu() {
        System.out.println("1 - Registrar libro");
        System.out.println("2 - Registrar usuario");
        System.out.println("3 - Préstamo de libro");
        System.out.println("4 - Devolución de libro");
        System.out.println("5 - Listar libros");
        System.out.println("6 - Salir");
    }

    private static void registrarLibro() {
        try {
            Integer id = leerInt("ID del libro: ");
            String titulo = leerString("Título: ");
            String autor = leerString("Autor: ");
            String isbn = leerString("ISBN: ");
            boolean estado = true; // al registrar, disponible
            Libro libro = new Libro(id, autor, titulo, isbn, estado);
            CollectionLibro.guardarLibro(libro);
            System.out.println("Libro registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar libro: " + e.getMessage());
        }
    }

    private static void registrarUsuario() {
        try {
            Integer id = leerInt("ID del usuario: ");
            String nombre = leerString("Nombre: ");
            String apellido = leerString("Apellido: ");
            String email = leerString("Email: ");
            System.out.println("Tipo de usuario: 1-Alumno  2-Bibliotecario");
            int tipo = leerInt("Seleccione: ");
            if (tipo == 1) {
                String numLibreta = leerString("Núm. libreta: ");
                String curso = leerString("Curso: ");
                Alumno alumno = new Alumno(id, nombre, apellido, email, numLibreta, curso);
                CollectionUsuario.guardarUsuario(alumno);
            } else {
                Integer legajo = leerInt("Legajo: ");
                Bibliotecario b = new Bibliotecario(id, nombre, apellido, email, legajo);
                CollectionUsuario.guardarUsuario(b);
            }
            System.out.println("Usuario registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
    }

    private static void prestamoLibro() {
        try {
            Integer idPrestamo = leerInt("ID del préstamo: ");
            Integer idLibro = leerInt("ID del libro a prestar: ");
            Integer idUsuario = leerInt("ID del usuario que pide el préstamo: ");
            String fechaPrestamoStr = leerString("Fecha préstamo (dd/MM/yyyy): ");
            String fechaDevolucionStr = leerString("Fecha devolución prevista (dd/MM/yyyy): ");

            // validar usuario
            Usuario usuario = CollectionUsuario.buscarUsuario(idUsuario);

            // buscar libro
            Libro libro = CollectionLibro.buscarLibro(idLibro);

            // verificar disponibilidad
            if (!libro.isEstado()) {
                throw new LibroNoDisponibleException("El libro '" + libro.getTitulo() + "' no está disponible para préstamo.");
            }

            LocalDate fechaPrestamo = FechaUtil.convertirStringLocalDate(fechaPrestamoStr);
            LocalDate fechaDevolucion = FechaUtil.convertirStringLocalDate(fechaDevolucionStr);

            // crear préstamo y marcar libro como no disponible
            Prestamo prestamo = new Prestamo(idPrestamo, fechaPrestamo, fechaDevolucion, libro, usuario);
            libro.setEstado(false);
            CollectionPrestamo.guardarPrestamo(prestamo);

            System.out.println("Préstamo registrado correctamente.");
        } catch (UsuarioNoRegistradoException | LibroNoEncontradoException | LibroNoDisponibleException ex) {
            System.out.println("Operación inválida: " + ex.getMessage());
        } catch (Exception e) {
            System.out.println("Error al registrar préstamo: " + e.getMessage());
        }
    }

    private static void devolucionLibro() {
        try {
            Integer idPrestamo = leerInt("ID del préstamo a devolver: ");
            String fechaDevStr = leerString("Fecha de devolución (dd/MM/yyyy): ");
            LocalDate fechaDevol = FechaUtil.convertirStringLocalDate(fechaDevStr);
            CollectionPrestamo.registrarDevolucion(idPrestamo, fechaDevol);
            System.out.println("Devolución registrada correctamente.");
        } catch (Exception e) {
            System.out.println("Error en devolución: " + e.getMessage());
        }
    }

    private static int leerInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                String linea = scanner.nextLine();
                return Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.print("Número inválido. Reingrese: ");
            }
        }
    }

    private static String leerString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static void cargarDatosIniciales() {
        // algunos datos de ejemplo para pruebas
        CollectionUsuario.guardarUsuario(new Alumno(1, "Juan", "Perez", "juan@mail.com", "A001", "1A"));
        CollectionUsuario.guardarUsuario(new Bibliotecario(2, "Ana", "Gomez", "ana@mail.com", 1001));

        CollectionLibro.guardarLibro(new Libro(1, "Autor A", "Java Básico", "ISBN-111", true));
        CollectionLibro.guardarLibro(new Libro(2, "Autor B", "POO Avanzado", "ISBN-222", true));
    }
}