public class SuscripcionUsuarioProxy implements Suscripcion {

    private final SuscripcionUsuario suscripcionUsuario = new SuscripcionUsuario();

    @Override
    public String comprobarSuscripcion(Usuario u) {
        if (u.suscripcion().equals("FREE")) return "El usuario " + u.nombre() + " no puede descargar canciones con suscripción FREE, hazte PREMIUM!";

        return suscripcionUsuario.comprobarSuscripcion(u);
    }

}
