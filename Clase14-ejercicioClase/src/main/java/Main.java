import model.Medicamento;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import repository.MedicamentoDAOH2;
import service.MedicamentoService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    private final static String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "log4j2.xml";

    public static void main(String[] args) throws IOException {
        startLogger();
        var service = new MedicamentoService(new MedicamentoDAOH2());
        var medicamento = new Medicamento(1, "Nombre", "labo", 1, 100);
        var newMedicamento = new Medicamento(1, "Hola", "labo", 1, 100);
        service.guardar(medicamento);

        System.out.println(service.buscar(1));

        service.update(newMedicamento);

    }


    private static void startLogger() throws IOException {
        var source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
        Configurator.initialize(null, source);
    }
}
