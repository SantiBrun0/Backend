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

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final String log4jConfigFile = System.getProperty("user.dir") +  File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "log4j2.xml";

    private static final String DROP_TABLE_IF_EXISTS = "DROP TABLE IF EXISTS ODONTOLOGOS";
    private static final String CREATE_TABLE = "CREATE TABLE ODONTOLOGOS (APELLIDO VARCHAR (50), NOMBRE VARCHAR (50), MATRICULA INT PRIMARY KEY)";
    private static final String INSERT_ODONTOLOGO = "INSERT INTO ODONTOLOGOS VALUES(?,?,?)";
    private static final String SELECT_ALL = "SELECT * FROM ODONTOLOGOS";



    public static void main(String[] args) throws SQLException, IOException {

        startLogger();

        var odontologo1 = new Odontologo("Bruno", "Santiago", "AFK404");
        var odontologo2 = new Odontologo("Martos", "Francisco", "JTR205");
        var odontologo3 = new Odontologo("Holguin", "Laura", "ZXW702");

        var connection = obtenerConexion();
        var statement = connection.createStatement();
        var psInsert = connection.prepareStatement(INSERT_ODONTOLOGO);

        statement.execute(DROP_TABLE_IF_EXISTS);
        statement.execute(CREATE_TABLE);

        try {
            psInsert.setString(1, odontologo1.apellido());
            psInsert.setString(2, odontologo1.nombre());
            psInsert.setString(3, odontologo1.matricula());

            psInsert.execute();

            logger.info("ODONTOLOGO AGREGADO: " + odontologo1.apellido() + " " + odontologo1.nombre());
        } catch (SQLException e) {
            logger.error("NO SE PUEDE AGREGAR ESTE ODONTOLOGO: " + e);
        }

        try {
            psInsert.setString(1, odontologo2.apellido());
            psInsert.setString(2, odontologo2.nombre());
            psInsert.setString(3, odontologo2.matricula());

            psInsert.execute();

            logger.info("ODONTOLOGO AGREGADO: " + odontologo2.apellido() + " " + odontologo2.nombre());
        } catch (SQLException e) {
            logger.error("NO SE PUEDE AGREGAR ESTE ODONTOLOGO: " + e);
        }

        try {
            psInsert.setString(1, odontologo3.apellido());
            psInsert.setString(2, odontologo3.nombre());
            psInsert.setString(3, odontologo3.matricula());

            psInsert.execute();

            logger.info("ODONTOLOGO AGREGADO: " + odontologo3.apellido() + " " + odontologo3.nombre());
        } catch (SQLException e) {
            logger.error("NO SE PUEDE AGREGAR ESTE ODONTOLOGO: " + e);
        }

        mostrarOdontologo(connection);

        connection.close();

    }

    public static void mostrarOdontologo(Connection connection) throws SQLException {
        var statement = connection.createStatement();
        var resultSet = statement.executeQuery(SELECT_ALL);

        while (resultSet.next()) {
            logger.info("APELLIDO: " + resultSet.getInt(1) + " /NOMBRE: " + resultSet.getString(2) + " /MATRICULA: " + resultSet.getString(3));
        }
    }

    private static void startLogger() throws IOException {
        ConfigurationSource source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
        Configurator.initialize(null, source);
    }

    private static Connection obtenerConexion() throws SQLException {
        Connection conectar = null;
        try {
            conectar = DriverManager.getConnection("jdbc:h2:~/test");
            logger.info("Conexión a la BD exitosa");
        } catch (SQLException e) {
            logger.error("Sin conexion a la BD: " + e);
        }
        return conectar;
    }

}
