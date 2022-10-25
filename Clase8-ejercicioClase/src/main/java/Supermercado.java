import model.Producto;
import model.Tarjeta;

public class Supermercado {

    public static void main(String[] args) {
        var facade = new FacadeDescuento();
        var tarj = new Tarjeta("33443344223433", "Star Bank");
        var producto = new Producto("arvejas", "latas");
        System.out.println("Descuento: "+facade.descuento(tarj, producto, 0));
    }

}
