public abstract class Menu {

    private Integer precioBase;

    public Menu(Integer precioBase) {
        this.precioBase = precioBase;
    }

    public abstract Integer calcularPrecio();

    public Integer getPrecioBase() {
        return precioBase;
    }

}
