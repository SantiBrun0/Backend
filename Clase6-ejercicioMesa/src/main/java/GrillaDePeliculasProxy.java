public class GrillaDePeliculasProxy implements IGrillaDePeliculas {

    private final GrillaDePeliculas grillaDePeliculas = new GrillaDePeliculas();
    private Ip ip;

    public void setIp(Ip ip) {
        this.ip = ip;
    }

    @Override
    public String getPelicula(Pelicula pelicula) {
        if (!pelicula.pais().equals("argentina") && ip.a() <= 49) return "Pelicula no habilitada para tu pais";
        if (!pelicula.pais().equals("brasil") && ip.a() > 49 && ip.a() <= 99) return "Pelicula no habilitada para tu pais";
        if (!pelicula.pais().equals("colombia") && ip.a() > 99 && ip.a() <= 149) return "Pelicula no habilitada para tu pais";

        return grillaDePeliculas.getPelicula(pelicula);
    }

}
