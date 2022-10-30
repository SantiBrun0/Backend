
import java.io.IOException;
import java.sql.*;

public class Main {


    private static final String DROP_TABLE_IF_EXISTS = "DROP TABLE IF EXISTS PACIENTES";
    private static final String CREATE_TABLE = "CREATE TABLE PACIENTES (NOMBRE VARCHAR (50), APELLIDO VARCHAR (50), DOMICILIO VARCHAR (50), DNI VARCHAR (50), FECHAALTA VARCHAR (50), USUARIO VARCHAR (50), PASSWORD VARCHAR (50))";
    private static final String INSERT_PACIENTE = "INSERT INTO PACIENTES VALUES(?,?,?,?,?,?,?)";


    public static void main(String[] args) throws IOException, SQLException {

        Logging.startLogger();

        var usuario = new Paciente("santiago", "bruno", "jujuy 1285", "38278896", "30 octubre 2022", "santibruno47", "backend789");
        var usuario2 = new Paciente("lionel", "messi", "catamarca 1285", "50278111", "31 octubre 2022", "liomessi10", "frontend789");
        var usuario3 = new Paciente("mona", "gimenez", "cordoba 1285", "20278222", "29 octubre 2022", "monacuarteto", "fernet789");


        var connection = Conexion.obtenerConexion();
        var statement = connection.createStatement();
        var psInsert = connection.prepareStatement(INSERT_PACIENTE);

        statement.execute(DROP_TABLE_IF_EXISTS);
        statement.execute(CREATE_TABLE);

        try {
            psInsert.setString(1, usuario.nombre());
            psInsert.setString(2, usuario.apellido());
            psInsert.setString(3, usuario.domicilio());
            psInsert.setString(4, usuario.dni());
            psInsert.setString(5, usuario.fechaAlta());
            psInsert.setString(6, usuario.usuario());
            psInsert.setString(7, usuario.password());

            psInsert.execute();

            Logging.logger.info("PACIENTE AGREGADO: " + usuario.nombre() + " " + usuario.apellido());
        } catch (SQLException e) {
            Logging.logger.error("NO SE PUEDE AGREGAR ESTE PACIENTE: " + e);
        }

        try {
            psInsert.setString(1, usuario2.nombre());
            psInsert.setString(2, usuario2.apellido());
            psInsert.setString(3, usuario2.domicilio());
            psInsert.setString(4, usuario2.dni());
            psInsert.setString(5, usuario2.fechaAlta());
            psInsert.setString(6, usuario2.usuario());
            psInsert.setString(7, usuario2.password());

            psInsert.execute();

            Logging.logger.info("PACIENTE AGREGADO: " + usuario2.nombre() + " " + usuario2.apellido());
        } catch (SQLException e) {
            Logging.logger.error("NO SE PUEDE AGREGAR ESTE PACIENTE: " + e);
        }

        try {
            psInsert.setString(1, usuario3.nombre());
            psInsert.setString(2, usuario3.apellido());
            psInsert.setString(3, usuario3.domicilio());
            psInsert.setString(4, usuario3.dni());
            psInsert.setString(5, usuario3.fechaAlta());
            psInsert.setString(6, usuario3.usuario());
            psInsert.setString(7, usuario3.password());

            psInsert.execute();

            Logging.logger.info("PACIENTE AGREGADO: " + usuario3.nombre() + " " + usuario3.apellido());
        } catch (SQLException e) {
            Logging.logger.error("NO SE PUEDE AGREGAR ESTE PACIENTE: " + e);
        }

        connection.close();

    }


}
