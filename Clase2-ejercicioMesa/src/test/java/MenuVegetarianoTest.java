import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuVegetarianoTest {

    @Test
    void calcularPrecio() {
        MenuVegetariano m = new MenuVegetariano(100,5, 2);

        assertEquals(116, m.calcularPrecio());

    }
}