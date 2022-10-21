public class Main {

    public static void main(String[] args) {

        Pelicula argentina = new Pelicula("peli argenta", "argentina", "toma el zelda");
        Pelicula brasil = new Pelicula("peli brazuca", "brasil", "toma el zelda");
        Pelicula colombia = new Pelicula("peli colombiana", "colombia", "toma el zelda");

        GrillaDePeliculasProxy proxy1 = new GrillaDePeliculasProxy();
        Ip ip1 = new Ip(25,155,5,57);
        proxy1.setIp(ip1);

        GrillaDePeliculasProxy proxy2 = new GrillaDePeliculasProxy();
        Ip ip2 = new Ip(70,132,9,83);
        proxy2.setIp(ip2);

        GrillaDePeliculasProxy proxy3 = new GrillaDePeliculasProxy();
        Ip ip3 = new Ip(112,96,14,4);
        proxy3.setIp(ip3);

        System.out.println(proxy1.getPelicula(argentina));
        System.out.println(proxy1.getPelicula(brasil));
        System.out.println(proxy1.getPelicula(colombia));

        System.out.println("-----------------------------------------");

        System.out.println(proxy2.getPelicula(argentina));
        System.out.println(proxy2.getPelicula(brasil));
        System.out.println(proxy2.getPelicula(colombia));

        System.out.println("-----------------------------------------");

        System.out.println(proxy3.getPelicula(argentina));
        System.out.println(proxy3.getPelicula(brasil));
        System.out.println(proxy3.getPelicula(colombia));

        System.out.println("-----------------------------------------");

        Serie uno = new Serie("ElMarginal", "argentina");
        GrillaDeSeriesProxy proxy4 = new GrillaDeSeriesProxy();

        System.out.println(proxy4.getSeries(uno));
        System.out.println(proxy4.getSeries(uno));
        System.out.println(proxy4.getSeries(uno));
        System.out.println(proxy4.getSeries(uno));
        System.out.println(proxy4.getSeries(uno));
        System.out.println(proxy4.getSeries(uno));

    }

}
