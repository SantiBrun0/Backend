public class SuscripcionUsuario implements Suscripcion {

    @Override
    public String comprobarSuscripcion(Usuario u) {
        if (u.suscripcion().equals("PREMIUM")) return "El usuario " + u.nombre() + " tiene suscipción " + u.suscripcion() + ", puede descargar canciones";
        return "El usuario " + u.nombre() + " no tiene una suscripción válida";
    }

}
