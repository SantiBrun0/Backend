package repository;

import model.Medicamento;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MedicamentoDAOH2 implements MedicamentoDAO {
    private final static String DB_URL = "jdbc:h2:~/db_farmacia2;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String INSERT = "INSERT INTO medicamentos(nombre,laboratorio,cantidad,precio) VALUES(?,?,?,?)";
    private final static String SELECT = "SELECT id,nombre,laboratorio,cantidad,precio  FROM medicamentos where id = ?";
    private final static Logger logger = LogManager.getLogger(MedicamentoDAOH2.class);


    @Override
    public void guardar(Medicamento m) throws SQLException {
        Connection connection = null;
        try {
            connection = getConnection();
            var insert = connection.prepareStatement(INSERT);
            insert.setString(1, m.nombre());
            insert.setString(2, m.labo());
            insert.setInt(3, m.cantidad());
            insert.setDouble(4, m.precio());

            insert.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public Medicamento buscar(int id) {
        Connection connection = null;
        try {
            connection = getConnection();
            var buscar = connection.prepareStatement(SELECT);
            buscar.setInt(1, id);
            var result = buscar.executeQuery();

            if (result.next()) {
                var anId = result.getInt(1);
                var nombre = result.getString(2);
                var labo = result.getString(3);
                var cantidad = result.getInt(4);
                var precio = result.getDouble(5);
                return new Medicamento(anId, nombre, labo, cantidad, precio);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(Medicamento m) {
        Connection connection = null;
        try {
            connection = getConnection();
            var update = connection.prepareStatement("UPDATE medicamentos set nombre = ? where id = ?");
            update.setString(1, m.nombre());
            update.setInt(2, m.id());

            update.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

}