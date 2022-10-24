import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbolTest {

    @Test
    @DisplayName("WHEN a new Arbol is created THEN it should have the right parameters")
    void test() {

        //GIVEN
        var alto = 500;
        var horizontal = 300;
        var color = "rojo";
        //WHEN
        var arbol = new Arbol(alto, horizontal, color);
        //THEN
        assertEquals(arbol.alto(), alto);
        assertEquals(arbol.horizontal(), horizontal);
        assertEquals(arbol.color(), color);

    }

}