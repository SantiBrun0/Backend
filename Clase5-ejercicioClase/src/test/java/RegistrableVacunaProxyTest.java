import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrableVacunaProxyTest {

    @Test
    @DisplayName("WHEN el metodo vacunar es llamado con una fecha anterior" +
            " THEN registrableVacuna deberia devolver el mensaje correcto")
    public void test1(){
        //GIVEN
        var nombre = "Santiago";
        var apellido = "Bruno";
        var fecha = LocalDate.now();
        var vacuna = "Pfizer";
        var persona = new Persona(nombre, apellido, "1234", vacuna, fecha);
        var registrableVacuna = new RegistrableVacunaProxy();
        //WHEN
        var mensaje = registrableVacuna.vacunar(persona);
        //THEN
        var mensajeEsperado = "La persona "+nombre+" "+apellido+ "fue vacunada el dia "+fecha+ "con la vacuna "+vacuna;
        assertEquals(mensaje, mensajeEsperado);
    }

    @Test
    @DisplayName("WHEN el metodo vacunar es llamado con una fecha incorrecta" +
            " THEN deberia devolver un mensaje de error")
    public void test2(){
        //GIVEN
        var nombre = "Santiago";
        var apellido = "Bruno";
        var fecha = LocalDate.now().minusDays(100);
        var vacuna = "Pfizer";
        var persona = new Persona(nombre, apellido, "1234", vacuna, fecha);
        var registrableVacuna = new RegistrableVacunaProxy();
        //WHEN
        var mensaje = registrableVacuna.vacunar(persona);
        //THEN
        var mensajeEsperado = "La fecha es incorrecta";
        assertEquals(mensaje, mensajeEsperado);
    }

}