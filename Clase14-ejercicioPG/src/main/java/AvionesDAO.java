import java.sql.SQLException;
import java.util.List;

public interface AvionesDAO {

    void registarAvion(Avion avion) throws SQLException;

    Avion buscarAvion(int id) throws SQLException;

    void eliminarAvion(int id) throws SQLException;

    List<Avion> buscarTodos() throws SQLException;

}
