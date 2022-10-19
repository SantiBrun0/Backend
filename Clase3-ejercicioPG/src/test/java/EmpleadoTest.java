import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    @Test
    void conseguirAfiliado() {
        var empleado = new Empleado("santiago", 0);

        empleado.conseguirAfiliado(2);
        var puntos = empleado.getPuntos();

        assertEquals(puntos, 20);
    }

    @Test
    void vender() {
        var empleado = new Empleado("santiago", 0);

        empleado.vender(5);
        var puntos = empleado.getPuntos();

        assertEquals(puntos, 25);
    }

    @Test
    void categoriaMaestro() {
        var vendedor = new Empleado("santiago", 5);

        vendedor.conseguirAfiliado(1);
        vendedor.vender(2);
        var puntos = vendedor.getPuntos();

        vendedor.mostrarCategoria();
        var categoria = vendedor.getCategoria();

        assertEquals(puntos, 45);
        assertEquals(categoria, "MAESTRO");
    }

    @Test
    void categoriaBueno() {
        var vendedor = new Empleado("santiago", 2);

        vendedor.conseguirAfiliado(2);
        vendedor.vender(1);
        var puntos = vendedor.getPuntos();

        vendedor.mostrarCategoria();
        var categoria = vendedor.getCategoria();

        assertEquals(puntos, 35);
        assertEquals(categoria, "BUENO");
    }


}