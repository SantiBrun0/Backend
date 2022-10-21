public class SuscripcionUsuarioProxy implements Suscripcion {

    private final SuscripcionUsuario suscripcionUsuario = new SuscripcionUsuario();

    @Override
    public String comprobarSuscripcion(Usuario u) {
        if (u.suscripcion().equals("FREE")) return "No puede descargar canciones sin suscripcion PREMIUM";

        return suscripcionUsuario.comprobarSuscripcion(u);
    }

}
