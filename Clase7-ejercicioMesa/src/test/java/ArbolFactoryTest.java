import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbolFactoryTest {

    @Test
    @DisplayName("WHEN ArbolFactory.getArbol() is call THEN it should return a new Arbol with the right parameters or an existing one if has already created")
    void test() {

        //GIVEN
        var alto = 500;
        var horizontal = 300;
        var color = "rojo";
        //WHEN
        var arbol1 = ArbolFactory.getArbol(alto, horizontal, color);
        var arbol2 = ArbolFactory.getArbol(alto, horizontal, color);
        //THEN
        assertEquals(arbol1.alto(), alto);
        assertEquals(arbol1.horizontal(), horizontal);
        assertEquals(arbol1.color(), color);

        assertSame(arbol1, arbol2);

    }
}