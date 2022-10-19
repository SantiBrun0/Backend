public class MenuClasico extends Menu {

    @Override
    public Double calcularCosto() {
        return precioBase;
    }

    @Override
    public String mostrarInstrucciones() {
        return "sale como viene";
    }

}
