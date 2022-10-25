import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacadeTest {

    @Test
    @DisplayName("WHEN fachada.busqueda() is call, it should return buscarHotel() and buscarVuelo() with the same parameters")
    void test() {

        //GIVEN
        Facade fachada = new Facade();
        //WHEN
        var busqueda = fachada.busqueda("new york", "villa maria", "01/01/22", "01/01/23");
        var resultado = "Hotel: En la ciudad new york con check-in el 01/01/22 y check out el 01/01/23, Vuelo: De villa maria a new york con salida 01/01/22 y regreso 01/01/23";
        //THEN
        assertEquals(busqueda, resultado);

    }

}