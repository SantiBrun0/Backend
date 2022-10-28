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

    private static final Logger loggger = LogManager.getLogger(Main.class);
    private static final String log4jConfigFile = System.getProperty("user.dir") +  File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "log4j2.xml";

    private static final String DROP_TABLE_IF_EXISTS = "DROP TABLE IF EXISTS ANIMALES";
    private static final String CREATE_TABLE = "CREATE TABLE ANIMALES (ID INT PRIMARY KEY, NOMBRE VARCHAR (50) NOT NULL, TIPO VARCHAR (50) NOT NULL)";
    private static final String INSERT_ANIMAL = "INSERT INTO ANIMALES VALUES(1, 'MANCHITAS', 'PERRO')";
    private static final String INSERT_ANIMAL2 = "INSERT INTO ANIMALES VALUES(2, 'GARFIELD', 'GATO')";
    private static final String INSERT_ANIMAL3 = "INSERT INTO ANIMALES VALUES(3, 'PIOLIN', 'CANARIO')";
    private static final String INSERT_ANIMAL4 = "INSERT INTO ANIMALES VALUES(4, 'GHOST', 'LOBO')";
    private static final String INSERT_ANIMAL5 = "INSERT INTO ANIMALES VALUES(5, 'TINTO', 'PERRO')";
    private static final String DELETE_ANIMAL = "DELETE FROM ANIMALES WHERE ID = 5";
    private static final String SELECT_ALL = "SELECT * FROM ANIMALES";



    public static void main(String[] args) throws Exception {
        startLogger();

        var connection = obtenerConexion();
        var statement = connection.createStatement();

        statement.execute(DROP_TABLE_IF_EXISTS);
        statement.execute(CREATE_TABLE);
        statement.execute(INSERT_ANIMAL);
        statement.execute(INSERT_ANIMAL2);
        statement.execute(INSERT_ANIMAL3);
        statement.execute(INSERT_ANIMAL4);
        statement.execute(INSERT_ANIMAL5);

        mostrarAnimales(connection);

        statement.execute(DELETE_ANIMAL);

        mostrarAnimales(connection);

        connection.close();

    }

    public static void mostrarAnimales(Connection connection) throws SQLException {
        var statement = connection.createStatement();
        var resultSet = statement.executeQuery(SELECT_ALL);

        while (resultSet.next()) {
            loggger.info("ID: " + resultSet.getInt(1) + " NOMBRE: " + resultSet.getString(2) + " TIPO: " + resultSet.getString(3));
        }
    }

    private static void startLogger() throws IOException {
        ConfigurationSource source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
        Configurator.initialize(null, source);
    }

    private static Connection obtenerConexion() throws Exception {
        return DriverManager.getConnection("jdbc:h2:~/test");
    }

}
