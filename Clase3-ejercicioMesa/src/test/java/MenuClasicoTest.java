import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuClasicoTest {

    @Test
    void calcularCosto() {

        var menuClasico = new MenuClasico();

        var precio = menuClasico.calcularCosto();

        assertEquals(precio, 400.0);

    }

    @Test
    void mostrarInstrucciones() {

        var menuClasico = new MenuClasico();

        var instrucciones = menuClasico.mostrarInstrucciones();

        assertEquals(instrucciones, "sale como viene");

    }

}