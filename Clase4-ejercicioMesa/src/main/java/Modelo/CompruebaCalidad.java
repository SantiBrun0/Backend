package Modelo;

public interface CompruebaCalidad {

    void validarCalidadProducto(Producto producto);


    void setSucesor(CompruebaCalidad sucesor);

}

