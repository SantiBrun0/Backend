package apis;

import model.Producto;
import model.Tarjeta;

public class ApiTarjeta {

    public int descuento(Tarjeta unaTarjeta) {
        return unaTarjeta.banco().compareTo("Star Bank")==0 ? 10 : 0;
    }

}
