import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuInfantilTest {

    @Test
    void calcularPrecio() {
        MenuInfantil mi = new MenuInfantil(100, 2);

        assertEquals(106, mi.calcularPrecio());

    }
}