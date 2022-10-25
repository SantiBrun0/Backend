package apis;

import model.Producto;
import model.Tarjeta;

public class ApiCantidad {

    public int descuento(int cuantos) {
        return cuantos > 11 ? 15 : 0;
    }

}
