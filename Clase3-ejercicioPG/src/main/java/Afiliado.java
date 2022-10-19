public class Afiliado extends Vendedor {

    public Afiliado(String nombre) {
        super(nombre);
    }

    @Override
    public void vender(Integer cantVendidas) {
        Integer aux = this.getPuntos()+(cantVendidas*15);
        this.setPuntos(aux);
    }

}
