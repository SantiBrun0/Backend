package Modelo;

public class ControlPeso implements CompruebaCalidad {

    private CompruebaCalidad sucesor;

    @Override
    public void validarCalidadProducto(Producto producto) {
        if (producto.peso() > 1199 && producto.peso() <1301) {
            sucesor.validarCalidadProducto(producto);
        } else {
            System.out.println("El peso no cumple los parámetros establecidos");
        }
    }

    @Override
    public CompruebaCalidad getSucesor() {
        return sucesor;
    }

    @Override
    public void setSucesor(CompruebaCalidad sucesor) {
        this.sucesor = sucesor;
    }

}