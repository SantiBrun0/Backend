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

    private static final String DROP_TABLE_IF_EXISTS = "DROP TABLE IF EXISTS EMPLEADOS";
    private static final String CREATE_TABLE = "CREATE TABLE EMPLEADOS (ID INT PRIMARY KEY, NOMBRE VARCHAR (50), APELLIDO VARCHAR (50), SUELDO INT)";
    private static final String INSERT_EMPLEADO = "INSERT INTO EMPLEADOS VALUES(1, 'SANTIAGO', 'BRUNO', 100)";
    private static final String INSERT_EMPLEADO2 = "INSERT INTO EMPLEADOS VALUES(1, 'GARFIELD', 'GATO', 200)";
    private static final String INSERT_EMPLEADO3 = "INSERT INTO EMPLEADOS VALUES(3, 'PIOLIN', 'CANARIO', 300)";
    private static final String INSERT_EMPLEADO4 = "INSERT INTO EMPLEADOS VALUES(4, 'GHOST', 'LOBO', 400)";
    private static final String UPDATE_EMPLEADO = "UPDATE EMPLEADOS SET SUELDO = 500 WHERE ID = 1";
    private static final String DELETE_EMPLEADO = "DELETE FROM EMPLEADOS WHERE ID = 3";
    private static final String DELETE_EMPLEADO2 = "DELETE FROM EMPLEADOS WHERE APELLIDO LIKE 'LOBO'";
    private static final String SELECT_ALL = "SELECT * FROM EMPLEADOS";



    public static void main(String[] args) throws SQLException, IOException {
        startLogger();

        var connection = obtenerConexion();
        var statement = connection.createStatement();

        statement.execute(DROP_TABLE_IF_EXISTS);
        statement.execute(CREATE_TABLE);

        try {
            statement.execute(INSERT_EMPLEADO);
            loggger.info("EMPLEADO AGREGADO: " + INSERT_EMPLEADO);
        } catch (SQLException e) {
            loggger.error("NO SE PUEDE AGREGAR ESTE EMPLEADO: " + INSERT_EMPLEADO);
        }

        try {
            statement.execute(INSERT_EMPLEADO2);
            loggger.info("EMPLEADO AGREGADO: " + INSERT_EMPLEADO2);
        } catch (SQLException e) {
            loggger.error("NO SE PUEDE AGREGAR ESTE EMPLEADO: " + INSERT_EMPLEADO2);
        }

        try {
            statement.execute(INSERT_EMPLEADO3);
            loggger.info("EMPLEADO AGREGADO: " + INSERT_EMPLEADO3);
        } catch (SQLException e) {
            loggger.error("NO SE PUEDE AGREGAR ESTE EMPLEADO: " + INSERT_EMPLEADO3);
        }

        try {
            statement.execute(INSERT_EMPLEADO4);
            loggger.info("EMPLEADO AGREGADO: " + INSERT_EMPLEADO4);
        } catch (SQLException e) {
            loggger.error("NO SE PUEDE AGREGAR ESTE EMPLEADO: " + INSERT_EMPLEADO4);
        }

        try {
            statement.execute(UPDATE_EMPLEADO);
            loggger.debug("EMPLEADO ACTUALIZADO: " + UPDATE_EMPLEADO);
        } catch (SQLException e) {
            loggger.error("NO SE PUEDE ACTUALIZAR ESTE EMPLEADO: " + UPDATE_EMPLEADO);
        }

        try {
            statement.execute(DELETE_EMPLEADO);
            loggger.info("EMPLEADO ELIMINADO: " + DELETE_EMPLEADO);
        } catch (SQLException e) {
            loggger.error("NO SE PUEDE ELIMINAR ESTE EMPLEADO: " + DELETE_EMPLEADO);
        }

        try {
            statement.execute(DELETE_EMPLEADO2);
            loggger.info("EMPLEADO ELIMINADO: " + DELETE_EMPLEADO2);
        } catch (SQLException e) {
            loggger.error("NO SE PUEDE ELIMINAR ESTE EMPLEADO: " + DELETE_EMPLEADO2);
        }

        mostrarEmpleados(connection);

        connection.close();

    }

    public static void mostrarEmpleados(Connection connection) throws SQLException {
        var statement = connection.createStatement();
        var resultSet = statement.executeQuery(SELECT_ALL);

        while (resultSet.next()) {
            loggger.info("ID: " + resultSet.getInt(1) + " /NOMBRE: " + resultSet.getString(2) + " /APELLIDO: " + resultSet.getString(3) + " /SUELDO:" + resultSet.getString(4));
        }
    }

    private static void startLogger() throws IOException {
        ConfigurationSource source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
        Configurator.initialize(null, source);
    }

    private static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:~/test");
    }

}