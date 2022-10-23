package Modelo;

public class ControlEnvase implements CompruebaCalidad {

    private CompruebaCalidad sucesor;

    @Override
    public void validarCalidadProducto(Producto producto) {
        if (producto.envase().equals("sano") || producto.envase().equals("casi sano")) {
            System.out.println("PRODUCTO LIBERADO");
        } else {
            System.out.println("El envase no cumple los parámetros establecidos");
        }
    }


    @Override
    public void setSucesor(CompruebaCalidad sucesor) {
        this.sucesor = sucesor;
    }

}