import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RopaFactory {

    static final Map<String, Ropa> mapRopa = new HashMap<>();

    public static Ropa getRopa(String talle, String tipo, boolean esNuevo, boolean esImportada){
        Ropa prenda = mapRopa.get(talle);

        if (Objects.isNull(prenda)){
            prenda = new Ropa(talle, tipo, esNuevo, esImportada);
            mapRopa.put(talle,prenda);
            System.out.println("creando ropa: " + talle + " " + tipo + " " + esNuevo + " " + esImportada);
            return prenda;
        }

        System.out.println("usando ropa ya creada: " + talle + " " + tipo + " " + esNuevo + " " + esImportada);
        return prenda;
    }

}
