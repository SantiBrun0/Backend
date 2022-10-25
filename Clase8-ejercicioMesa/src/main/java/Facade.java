public class Facade {

    BusquedaHotel busquedaHotel = new BusquedaHotel();
    BusquedaVuelo busquedaVuelo = new BusquedaVuelo();

    public String busqueda(String ciudadDestino, String ciudadOrigen , String fechaIn, String fechaOut) {
        var hotel = busquedaHotel.buscarHotel(fechaIn, fechaOut, ciudadDestino);
        var vuelo = busquedaVuelo.buscarVuelo(fechaIn, fechaOut, ciudadOrigen, ciudadDestino);

        return "Hotel: " + hotel +
                ", Vuelo: " + vuelo;
    }

}
