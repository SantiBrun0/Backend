import model.Contacto;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import service.ContatoIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    private final static String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "log4j2.xml";


    private static void startLogger() throws IOException {
        var source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
        Configurator.initialize(null, source);
    }


    public static void main(String[] args) throws IOException {
        startLogger();

        var uno = new Contacto("santiago", "santi@hotmail.com", "1234546");
        var dos = new Contacto("messi", "messi@homtmail.com", "65482344");

        ContatoIO.write(Arrays.asList(uno, dos));

        var contactos = ContatoIO.read();

        contactos.forEach(System.out::println);
    }


}
