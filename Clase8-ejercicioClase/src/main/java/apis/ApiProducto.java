package apis;

import model.Producto;
import model.Tarjeta;

public class ApiProducto {

    public int descuento(Producto unProducto){
        return unProducto.tipo().compareTo("Lata")==0 ? 10 : 0;
    }

}
