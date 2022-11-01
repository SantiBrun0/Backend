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

    // log4j
    private static final Logger logger = LogManager.getLogger(Main.class);
    private final static String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "log4j2.xml";
    private static void startLogger() throws IOException {
        var source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
        Configurator.initialize(null, source);
    }

    //conection
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:~/clase13");
    }

    //show result
    private static void mostrarResultados() throws SQLException {
        var connection = getConnection();
        var statement = connection.createStatement();
        var result = statement.executeQuery(SELECT_ALL);

        while (result.next()){
            logger.info( "ID: "+ result.getInt(1)+" NOMBRE: "+result.getString(2)+" APELLIDO: "+result.getString(3)+" MATRICULA: "+ result.getString(4));
        }
    }

    private final static String DROP = "DROP TABLE IF EXISTS ODONTOLOGOS;";

    private final static String CREATE = "CREATE TABLE ODONTOLOGOS (ID INT PRIMARY KEY AUTO_INCREMENT, NOMBRE VARCHAR, APELLIDO VARCHAR, MATRICULA VARCHAR);";

    private final static String UPDATE_MATRICULA = "UPDATE ODONTOLOGOS SET MATRICULA = ? WHERE apellido = ?";

    private final static String INSERT = "INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO, MATRICULA) VALUES (?,?,?)";

    private final static String SELECT_ALL = "SELECT * FROM ODONTOLOGOS;";

    private static void create() throws SQLException{
        var connection = getConnection();
        var create = connection.createStatement();
        create.execute(DROP + CREATE);
    }

    private static void insert(Odontologos odontologo) throws SQLException {
        var connection = getConnection();
        var insert = connection.prepareStatement(INSERT);

        insert.setString(1, odontologo.nombre());
        insert.setString(2, odontologo.apellido());
        insert.setString(3, odontologo.matricula());

        insert.execute();
    }

    private static void update(Odontologos odontologo) throws SQLException {
        var connection = getConnection();
        var update = connection.prepareStatement(UPDATE_MATRICULA);

        update.setString(1,odontologo.matricula()+"ssj");
        update.setString(2, "mertens");
        update.executeUpdate();

        update.execute();
    }


    private static void updateWithTX(Odontologos odontologo) throws SQLException {
        Connection connection = null;

        try {
            connection = getConnection();
            connection.setAutoCommit(false);


            var update = connection.prepareStatement(UPDATE_MATRICULA);
            update.setString(3, odontologo.matricula() + "ssj");

            var i = 1/0;

            update.executeUpdate();

            connection.commit();

        } catch (SQLException | ArithmeticException e) {
            if (connection != null) {
                connection.rollback();
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public static void main(String[] args) throws IOException, SQLException {
        startLogger();

        var odontologo1 = new Odontologos("juan", "mertens", "m4ssa24");
        var odontologo2 = new Odontologos("lucas", "matus", "m4ssa24");
        var odontologo3 = new Odontologos("facundo", "juarez", "m4ssa24");

        create();
        insert(odontologo1);
        update(odontologo1);
        updateWithTX(odontologo1);

        mostrarResultados();

    }







}
