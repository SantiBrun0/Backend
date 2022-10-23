package Modelo;

public interface CompruebaCalidad {

    void validarCalidadProducto(Producto producto);

    CompruebaCalidad getSucesor();

    void setSucesor(CompruebaCalidad sucesor);

}

