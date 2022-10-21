import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonaTest {

    @Test
    @DisplayName("WHEN a new persona object is created THEN it should have the right parameters")
    public void test1(){
        //GIVEN
        var nombre = "Nicolas";
        var apellido = "Condezo";
        var dni = "12345678";
        var vacuna = "moderna";
        var fecha = LocalDate.now();
        //WHEN
        var persona = new Persona(nombre, apellido, dni, vacuna, fecha);
        //THEN
        assertEquals(persona.nombre(), nombre);
        assertEquals(persona.apellido(), apellido);
        assertEquals(persona.dni(), dni);
        assertEquals(persona.vacuna(), vacuna);
        assertEquals(persona.fecha(), fecha);
    }

}
