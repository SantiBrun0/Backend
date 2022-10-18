public class MenuVegetariano extends Menu {

    private Integer cantidadSalsas;
    private Integer cantidadEspecias;

    public MenuVegetariano(Integer precioBase, Integer cantidadSalsas, Integer cantidadEspecias) {
        super(precioBase);
        this.cantidadSalsas = cantidadSalsas;
        this.cantidadEspecias = cantidadEspecias;
    }

    @Override
    public Integer calcularPrecio() {
        return this.getPrecioBase()+(2*this.cantidadSalsas)+(3*this.cantidadEspecias);
    }

}
