import java.time.LocalDate;

public class RegistrableVacunaProxy implements Registrable {

    private final RegistrableVacuna registrableVacuna = new RegistrableVacuna();

    @Override
    public String vacunar(Persona p) {
        if (validarFecha(p.fecha())) return "La fecha es incorrecta";

        return registrableVacuna.vacunar(p);
    }

    private boolean validarFecha(LocalDate date) {
        return date.isBefore((LocalDate.now().minusDays(1)));
    }

}
