import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuVegetarianoTest {

    @Test
    void calcularCosto() {

        var menuVegetariano = new MenuVegetariano(2.0);

        var precio = menuVegetariano.calcularCosto();

        assertEquals(precio, 444.0);

    }

    @Test
    void mostrarInstrucciones() {

        var menuVegetariano = new MenuVegetariano(2.0);

        var instrucciones = menuVegetariano.mostrarInstrucciones();

        assertEquals(instrucciones, "Colocar especias y salsas segun el pedido");

    }
}