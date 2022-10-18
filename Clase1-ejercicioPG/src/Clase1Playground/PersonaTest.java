package Clase1Playground;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonaTest {

    @Test
    public void nombreCorrecto() {
        Persona santiagoBruno = new Persona("Santiago", "Bruno", "sb@gmail.com", 27);

        assertEquals("Santiago Bruno", santiagoBruno.mostrarNombre());

    }

    @Test
    public void esMayorDe18() {
        Persona santiagoBruno = new Persona("Santiago", "Bruno", "sb@gmail.com", 27);

        assertTrue(santiagoBruno.esMayorDe18());
    }

}
