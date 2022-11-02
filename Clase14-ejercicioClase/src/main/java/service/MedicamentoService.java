package service;

import lombok.AllArgsConstructor;
import model.Medicamento;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.MedicamentoDAO;
import repository.MedicamentoDAOH2;

import java.sql.SQLException;

@AllArgsConstructor
public class MedicamentoService {
    private final static Logger logger = LogManager.getLogger(MedicamentoDAOH2.class);
    private final MedicamentoDAO medicamentoDAO;

    public void guardar(Medicamento m){
        try {
            medicamentoDAO.guardar(m);
        } catch (SQLException e) {
            logger.fatal("No se pudo guardar el medicamento");
        }
    }

    public Medicamento buscar(int id){
        return medicamentoDAO.buscar(id);
    }

    public void update(Medicamento medicamento){
        try {
            medicamentoDAO.update(medicamento);
        } catch (SQLException e) {
            logger.fatal("Fallo la actualizacion");
        }
    }
}
