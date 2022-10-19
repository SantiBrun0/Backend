public class MenuInfantil extends Menu {

    private Double cantJuguetes;

    public MenuInfantil(Double cantJuguetes) {
        this.cantJuguetes = cantJuguetes;
    }

    @Override
    public Double calcularCosto() {
        return precioBase+(cantJuguetes*3.0);
    }

    @Override
    public String mostrarInstrucciones() {
        return "no se olvide de colocar los juguetes";
    }

}
