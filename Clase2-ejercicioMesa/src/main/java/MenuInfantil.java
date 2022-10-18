public class MenuInfantil extends Menu {

    private Integer cantidadJuguetes;

    public MenuInfantil(Integer precioBase, Integer cantidadJuguetes) {
        super(precioBase);
        this.cantidadJuguetes = cantidadJuguetes;
    }


    @Override
    public Integer calcularPrecio() {
        return this.getPrecioBase()+(3*this.cantidadJuguetes);
    }

}
