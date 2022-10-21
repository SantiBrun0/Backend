import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrillaDeSeriesTest {

    @Test
    @DisplayName("WHEN getSeries es llamado THEN GrillaDeSeries devuelve la pagina de la misma")
    void test1() {
        //GIVEN
        var serie = new Serie("ElMarginal", "argentina");
        var proxy = new GrillaDeSeriesProxy();
        //WHEN
        var mensaje = proxy.getSeries(serie);
        //THEN
        var mensajeEsperado = "www.ElMarginal.com";
        assertEquals(mensaje, mensajeEsperado);
    }

    @Test
    @DisplayName("WHEN getSeries es llamado mas de 5 veces THEN GrillaDeSeries devuelve un mensaje de error")
    void test2() {
        //GIVEN
        var serie = new Serie("ElMarginal", "argentina");
        var proxy = new GrillaDeSeriesProxy();
        //WHEN
        proxy.getSeries(serie);
        proxy.getSeries(serie);
        proxy.getSeries(serie);
        proxy.getSeries(serie);
        proxy.getSeries(serie);
        var mensaje = proxy.getSeries(serie);
        //THEN
        var mensajeEsperado = "La serie ya ha sido vista mas de 5 veces";
        assertEquals(mensaje, mensajeEsperado);
    }

}