import java.time.LocalDate;

public class BusquedaVuelo {

    public String buscarVuelo(String fechaSalida, String fechaRegreso, String origen, String destino) {
        return "De " + origen + " a " + destino + " con salida " + fechaSalida + " y regreso " + fechaRegreso;
    }

}
