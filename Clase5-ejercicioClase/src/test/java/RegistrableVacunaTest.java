import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrableVacunaTest {

    @Test
    @DisplayName("WHEN el metodo vacunar es llamado con fecha anterior THEN RegistrableVacuna deberia devolver el mensaje correcto")
    public void test1(){
        //GIVEN
        var persona = new Persona("Santiago", "Bruno", "38278896", "moderna", LocalDate.now());
        var registrableVacuna = new RegistrableVacuna();
        //WHEN
        var mensaje = registrableVacuna.vacunar(persona);
        //THEN
        var mensajeEsperado = "La persona " + persona.nombre() + " " + persona.apellido() + " fue vacunada el dia " + persona.fecha();
        assertEquals(mensaje, mensajeEsperado);
    }

}
