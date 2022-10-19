import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuInfantilTest {

    @Test
    void calcularCosto() {

        var menuInfantil = new MenuInfantil(2.0);

        var precio = menuInfantil.calcularCosto();

        assertEquals(precio, 406.0);

    }

    @Test
    void mostrarInstrucciones() {

        var menuInfantil = new MenuInfantil(2.0);

        var instrucciones = menuInfantil.mostrarInstrucciones();

        assertEquals(instrucciones, "no se olvide de colocar los juguetes");

    }

}