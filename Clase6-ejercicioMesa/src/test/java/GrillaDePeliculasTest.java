import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrillaDePeliculasTest {

    @Test
    @DisplayName("WHEN getPelicula es llamado con una ip incorrecta THEN GrillaDePeliculas devuelve mensaje de error")
    void test1() {
        //GIVEN
        var pelicula = new Pelicula("peli argenta", "argentina", "toma el zelda");
        var proxy = new GrillaDePeliculasProxy();
        var ip = new Ip(112,96,14,4);
        proxy.setIp(ip);
        //WHEN
        var mensaje = proxy.getPelicula(pelicula);
        //THEN
        var mensajeEsperado = "Pelicula no habilitada para tu pais";
        assertEquals(mensaje, mensajeEsperado);
    }

    @Test
    @DisplayName("WHEN getPelicula es llamado con una ip correcta THEN GrillaDePeliculas devuelve el nombre de la pelicula y el link")
    void test2() {
        //GIVEN
        var pelicula = new Pelicula("peli colombiana", "colombia", "toma el zelda");
        var proxy = new GrillaDePeliculasProxy();
        var ip = new Ip(112,96,14,4);
        proxy.setIp(ip);
        //WHEN
        var mensaje = proxy.getPelicula(pelicula);
        //THEN
        var mensajeEsperado = pelicula.nombre() + ", " + pelicula.linkReproduccion();
        assertEquals(mensaje, mensajeEsperado);
    }

}