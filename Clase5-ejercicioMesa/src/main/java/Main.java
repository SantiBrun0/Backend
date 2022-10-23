public class Main {

    public static void main(String[] args) {

        Usuario uno = new Usuario("santiago", "bruno", "PREMIUM");
        Usuario dos = new Usuario("lionel", "messi", "FREE");
        Usuario tres = new Usuario("Ele", "Gante", "TURRO");

        SuscripcionUsuarioProxy proxy = new SuscripcionUsuarioProxy();

        System.out.println(proxy.comprobarSuscripcion(uno));
        System.out.println(proxy.comprobarSuscripcion(dos));
        System.out.println(proxy.comprobarSuscripcion(tres));

    }

}
