public class Main {

    public static void main(String[] args) {

        Facade fachada = new Facade();
        var busqueda = fachada.busqueda("new york", "villa maria", "01/01/22", "01/01/23");

        System.out.println(busqueda);

    }

}
