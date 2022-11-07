package model;

import java.time.LocalDate;

public record Paciente(String apellido, String nombre, String dni, LocalDate fechaIngreso, Domicilio domicilio) {
}
