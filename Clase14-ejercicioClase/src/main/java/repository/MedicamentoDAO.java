package repository;

import model.Medicamento;

import java.sql.SQLException;

public interface MedicamentoDAO {
    void guardar(Medicamento m) throws SQLException;
    Medicamento buscar(int id);

    void update(Medicamento m) throws SQLException;
}
