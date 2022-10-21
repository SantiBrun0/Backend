import java.time.LocalDate;

public record Persona(String nombre, String apellido, String dni, String vacuna, LocalDate fecha) {
}
