public class MenuVegetariano extends Menu {

    private Double cantSalsas;

    public MenuVegetariano(Double cantSalsas) {
        this.cantSalsas = cantSalsas;
    }

    @Override
    public Double calcularCosto() {
        return (precioBase+(cantSalsas*2)+(precioBase*0.1));
    }

    @Override
    public String mostrarInstrucciones() {
        return "Colocar especias y salsas segun el pedido";
    }

}
