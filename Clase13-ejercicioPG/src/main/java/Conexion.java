
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    static Connection obtenerConexion() throws SQLException {

        var nombreDB = "JavaPacientes";
        var user = "root";
        var pass = "sodastereo";
        var url = "jdbc:mysql://localhost:3306/"+nombreDB+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Connection conectar = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(url,user,pass);
            Logging.logger.info("Conexión a la BD exitosa");
        } catch(ClassNotFoundException | SQLException e) {
            Logging.logger.error("Sin conexión a la BD: " + e);
        }

        return conectar;
    }

}
