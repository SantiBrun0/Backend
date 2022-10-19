public class Empleado extends Vendedor {

    private Integer antiguedad;

    public Empleado(String nombre, Integer antiguedad) {
        super(nombre);
        this.antiguedad = antiguedad;
        this.setPuntos(antiguedad*5);
    }

    public void conseguirAfiliado(Integer cantAfiliados) {
        Integer aux = this.getPuntos()+(cantAfiliados*10);
        this.setPuntos(aux);
    }

    @Override
    public void vender(Integer cantVendidas) {
        Integer aux = this.getPuntos()+(cantVendidas*5);
        this.setPuntos(aux);
    }

}
