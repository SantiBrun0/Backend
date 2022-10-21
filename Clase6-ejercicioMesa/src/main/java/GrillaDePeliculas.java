public class GrillaDePeliculas implements IGrillaDePeliculas {

    @Override
    public String getPelicula(Pelicula pelicula) {
        return pelicula.nombre() + ", " + pelicula.linkReproduccion();
    }

}
