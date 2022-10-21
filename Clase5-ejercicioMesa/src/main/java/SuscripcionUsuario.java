public class SuscripcionUsuario implements Suscripcion {

    @Override
    public String comprobarSuscripcion(Usuario u) {
        return "El usuiaro " + u.nombre() + " tiene suscipcion " + u.suscripcion();
    }

}
