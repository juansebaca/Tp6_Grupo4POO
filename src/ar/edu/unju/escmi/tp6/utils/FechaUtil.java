package ar.edu.unju.escmi.tp6.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FechaUtil {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate convertirStringLocalDate(String fechaStr) throws Exception {
        try {
            return LocalDate.parse(fechaStr, FORMATO);
        } catch (DateTimeParseException e) {
            throw new Exception("Formato de fecha inválido. Use dd/MM/yyyy. Error: " + e.getMessage());
        }
    }
}