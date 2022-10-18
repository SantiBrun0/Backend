import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuClasicoTest {

    @Test
    void calcularPrecio() {
        MenuClasico m = new MenuClasico(100);

        assertEquals(100, m.calcularPrecio());

    }
}