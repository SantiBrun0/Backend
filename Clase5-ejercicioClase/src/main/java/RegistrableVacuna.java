public class RegistrableVacuna implements Registrable {

    public String vacunar(Persona p) {
        return "La persona " + p.nombre() + " " + p.apellido() + " fue vacunada el dia " + p.fecha();
    }

}
