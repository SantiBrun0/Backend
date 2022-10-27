import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ListaPromedio {

    private static final Logger logger = LogManager.getLogger(ListaPromedio.class);
    private final List<Integer> enteros;

    public ListaPromedio(List<Integer> enteros) throws Exception {
        this.enteros = enteros;
        if (enteros.size() > 5) {
            logger.info("La longitud de la lista es mayor a 5");
        }
        if (enteros.size() > 10) {
            logger.info("La longitud de la lista es mayor a 10");
        }
        if (enteros.size() == 0) {
            logger.error("la lista esta vacía");
            throw new Exception();
        }
    }

    public int promedio() {
        int sum = 0;
        for (int entero : enteros) {
            sum = sum + entero;
        }
        int promedio = sum / enteros.size();
        logger.info("El promedio de la lista es " + promedio);
        return  promedio;
    }

}
