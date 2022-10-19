public abstract class Menu {

    protected final Double precioBase;

    public Menu() {
        this.precioBase = 400.0;
    }

    public abstract Double calcularCosto();

    public abstract String mostrarInstrucciones();

}
