import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AfiliadoTest {

    @Test
    void vender() {
        var afiliado = new Afiliado("santiago");

        afiliado.vender(2);
        var puntos = afiliado.getPuntos();

        assertEquals(puntos, 30);
    }

    @Test
    void categoriaAprendiz() {
        var vendedor = new Afiliado("santiago");

        vendedor.vender(2);
        var puntos = vendedor.getPuntos();

        vendedor.mostrarCategoria();
        var categoria = vendedor.getCategoria();

        assertEquals(puntos, 30);
        assertEquals(categoria, "APRENDIZ");

    }

    @Test
    void categoriaNovato() {
        var vendedor = new Afiliado("santiago");

        var puntos = vendedor.getPuntos();

        vendedor.mostrarCategoria();
        var categoria = vendedor.getCategoria();

        assertEquals(puntos, 0);
        assertEquals(categoria, "NOVATO");

    }

}