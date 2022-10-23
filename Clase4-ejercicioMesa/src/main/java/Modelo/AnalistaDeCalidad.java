package Modelo;

public class AnalistaDeCalidad implements CompruebaCalidad {

    private CompruebaCalidad sucesor;

    @Override
    public void validarCalidadProducto(Producto producto) {
        ControlLote cl = new ControlLote();
        setSucesor(cl);
        ControlPeso cp = new ControlPeso();
        cl.setSucesor(cp);
        ControlEnvase ce = new ControlEnvase();
        cp.setSucesor(ce);

        sucesor.validarCalidadProducto(producto);
    }


    @Override
    public void setSucesor(CompruebaCalidad sucesor) {
        this.sucesor = sucesor;
    }

}
