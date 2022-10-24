import java.util.HashMap;
import java.util.Objects;

public class ComputadoraFactory {

    private final static HashMap<Integer, Computadora> computadoras = new HashMap<>();

    public static Computadora getComputadora(int ram, int disco) {

        var key = ram + disco;
        var hashPC = computadoras.get(key);

        if (Objects.nonNull(hashPC)) return hashPC;

        var newPC = new Computadora(ram, disco);
        computadoras.put(key, newPC);

        return newPC;
    }

}
