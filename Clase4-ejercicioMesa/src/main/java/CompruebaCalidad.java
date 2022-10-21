public interface CompruebaCalidad {

    void validarCalidadProducto(int valor);

    CompruebaCalidad getSucesor();

    CompruebaCalidad setSucesor(CompruebaCalidad sucesor);

}

