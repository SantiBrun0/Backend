import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvionesDAOH2 implements AvionesDAO {

    private static final Logger logger = LogManager.getLogger(AvionesDAOH2.class);
    private final static String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "log4j2.xml";
    private static void startLogger() throws IOException {
        var source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
        Configurator.initialize(null, source);
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:~/test, INIT=RUNSCRIPT FROM 'create.sql'");
    }

    private static final String INSERT_AVION = "INSERT INTO aviones (marca, matricula, modelo, fechaEntrada) VALUES (?,?,?,?)";
    private static final String SELECT_ALL = "SELECT * FROM aviones";
    private static final String SELECT_AVION = "SELECT * FROM aviones WHERE id = ?";
    private static final String DELETE_AVION = "DELETE FROM aviones WHERE id = ?";


    @Override
    public void registarAvion(Avion avion) throws SQLException {
        Connection connection = null;

        try {
            connection = getConnection();
            var insert = connection.prepareStatement(INSERT_AVION);
            insert.setString(1, avion.marca());
            insert.setString(2, avion.matricula());
            insert.setString(3, avion.modelo());
            insert.setString(4, avion.fechaEntrada());

            insert.execute();
            logger.info("Avion registrado con éxito");

        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e);
            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                connection.close();
            }
        }

    }

    @Override
    public Avion buscarAvion(int id) throws SQLException {
        Connection connection = null;

        try {
            connection = getConnection();
            var insert = connection.prepareStatement(SELECT_AVION);
            insert.setInt(1, id);
            var resultado = insert.executeQuery();

            if (resultado.next()) {
                logger.info("Avion encontrado con éxito, id: " + id);
                return new Avion(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5));
            }
            return null;

        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e);
            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void eliminarAvion(int id) throws SQLException {
        Connection connection = null;

        try {
            connection = getConnection();
            var insert = connection.prepareStatement(DELETE_AVION);
            insert.setInt(1, id);

            insert.execute();
            logger.info("Avion eliminado con éxito, id: " + id);

        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e);
            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<Avion> buscarTodos() throws SQLException {
        Connection connection = null;
        List<Avion> aviones = new ArrayList<>();

        try {
            connection = getConnection();
            var stmt = connection.createStatement();
            var resultado = stmt.executeQuery(SELECT_ALL);

            while (resultado.next()) {
                aviones.add(new Avion(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5)));
            }

            logger.info("Todos los aviones encontrados con éxito");
            return aviones;

        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e);
            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

}
