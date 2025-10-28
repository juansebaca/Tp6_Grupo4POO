package ar.edu.unju.escmi.tp6.principal;

import java.time.LocalDate;
import java.util.Scanner;
import ar.edu.unju.escmi.tp6.collections.*;
import ar.edu.unju.escmi.tp6.dominio.*;
import ar.edu.unju.escmi.tp6.exceptions.*;
import ar.edu.unju.escmi.tp6.utils.FechaUtil;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ BIBLIOTECA ---");
            System.out.println("1. Registrar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Préstamo de libro");
            System.out.println("4. Devolución de libro");
            System.out.println("5. Listar libros");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1 -> {
                        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Título: "); String titulo = sc.nextLine();
                        System.out.print("Autor: "); String autor = sc.nextLine();
                        System.out.print("ISBN: "); String isbn = sc.nextLine();
                        Libro libro = new Libro(id, titulo, autor, isbn, true);
                        CollectionLibro.guardarLibro(libro);
                    }
                    case 2 -> {
                        System.out.print("1. Alumno / 2. Bibliotecario: "); int tipo = sc.nextInt(); sc.nextLine();
                        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Nombre: "); String nombre = sc.nextLine();
                        System.out.print("Apellido: "); String apellido = sc.nextLine();
                        System.out.print("Email: "); String email = sc.nextLine();

                        if (tipo == 1) {
                            System.out.print("N° Libreta: "); String libreta = sc.nextLine();
                            System.out.print("Curso: "); String curso = sc.nextLine();
                            CollectionUsuario.guardarUsuario(new Alumno(id, nombre, apellido, email, libreta, curso));
                        } else {
                            System.out.print("Legajo: "); String legajo = sc.nextLine();
                            CollectionUsuario.guardarUsuario(new Bibliotecario(id, nombre, apellido, email, legajo));
                        }
                    }
                    case 3 -> {
                        System.out.print("ID Usuario: "); int idU = sc.nextInt();
                        System.out.print("ID Libro: "); int idL = sc.nextInt();
                        sc.nextLine();
                        Usuario u = CollectionUsuario.buscarUsuario(idU);
                        Libro l = CollectionLibro.buscarLibro(idL);
                        CollectionLibro.verificarDisponibilidad(l);
                        l.setDisponible(false);
                        System.out.print("Fecha préstamo (dd/MM/yyyy): ");
                        String fecha = sc.nextLine();
                        LocalDate fPrestamo = FechaUtil.convertirStringLocalDate(fecha);
                        Prestamo p = new Prestamo((int)(Math.random()*1000), fPrestamo, l, u);
                        CollectionPrestamo.guardarPrestamo(p);
                    }
                    case 4 -> {
                        System.out.print("Ingrese ID de libro devuelto: ");
                        int id = sc.nextInt(); sc.nextLine();
                        Libro l = CollectionLibro.buscarLibro(id);
                        System.out.print("Fecha devolución (dd/MM/yyyy): ");
                        String fecha = sc.nextLine();
                        LocalDate fDev = FechaUtil.convertirStringLocalDate(fecha);
                        l.setDisponible(true);
                        System.out.println("Devolución registrada con éxito.");
                    }
                    case 5 -> CollectionLibro.mostrarLibros();
                    case 6 -> System.out.println("Fin del programa.");
                    default -> System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Error: " + e.getMessage());
            } finally {
                System.out.println("Operación finalizada.\n");
            }

        } while (opcion != 6);
        sc.close();
    }
}