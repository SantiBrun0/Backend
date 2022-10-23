package Modelo;

public class Main {

    public static void main(String[] args) {

        Producto uno = new Producto("ddl", 1100, 1250, "sano");
        Producto dos = new Producto("ddl", 1120, 1270, "patogeno");
        Producto tres = new Producto("ddl", 990, 800, "sano");
        Producto cuatro = new Producto("ddl", 1105, 900, "casi sano");

        AnalistaDeCalidad adc = new AnalistaDeCalidad();

        adc.validarCalidadProducto(uno);
        adc.validarCalidadProducto(dos);
        adc.validarCalidadProducto(tres);
        adc.validarCalidadProducto(cuatro);

    }

}
