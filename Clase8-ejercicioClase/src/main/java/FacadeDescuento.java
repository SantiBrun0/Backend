import apis.ApiCantidad;
import apis.ApiProducto;
import apis.ApiTarjeta;
import model.Producto;
import model.Tarjeta;

public class FacadeDescuento {

    private final ApiTarjeta apiTarjeta = new ApiTarjeta();
    private final ApiProducto apiProducto = new ApiProducto();
    private final ApiCantidad apiCantidad = new ApiCantidad();

    public int descuento(Tarjeta tarj, Producto prod, int cant) {
        return apiCantidad.descuento(cant) +  apiProducto.descuento(prod)+ apiTarjeta.descuento(tarj);
    }

}
