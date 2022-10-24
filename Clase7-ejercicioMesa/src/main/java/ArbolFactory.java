import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ArbolFactory {
    private static final Map<String, Arbol> arboles = new HashMap<>();

    public static Arbol getArbol(int alto, int horizontal, String color){
        Arbol arbol = arboles.get(color);
        if (Objects.isNull(arbol)){
            arbol = new Arbol(alto, horizontal, color);
            arboles.put(color,arbol);
            System.out.println("creando arbol nuevo");
            return arbol;
        }
        System.out.println("usando arbol ya creado");
        return arbol;
    }

}