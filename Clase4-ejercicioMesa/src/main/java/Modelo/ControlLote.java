package Modelo;

public class ControlLote implements CompruebaCalidad {

    private CompruebaCalidad sucesor;

    @Override
    public void validarCalidadProducto(Producto producto) {
        if (producto.lote() > 999 && producto.lote() <2001) {
            sucesor.validarCalidadProducto(producto);
        } else {
            System.out.println("El lote no cumple los parámetros establecidos");
        }
    }


    @Override
    public void setSucesor(CompruebaCalidad sucesor) {
        this.sucesor = sucesor;
    }

}
