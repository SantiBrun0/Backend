public class MenuClasico extends Menu {


    public MenuClasico(Integer precioBase) {
        super(precioBase);
    }

    @Override
    public Integer calcularPrecio() {
        return this.getPrecioBase();
    }

}
