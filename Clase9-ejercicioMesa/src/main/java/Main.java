import java.util.ArrayList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        var listaRopa = new ArrayList<Ropa>();

        listaRopa.add(RopaFactory.getRopa("XS", "remera", true, true));
        listaRopa.add(RopaFactory.getRopa("XS", "remera", true, false));
        listaRopa.add(RopaFactory.getRopa("XS", "remera", false, true));
        listaRopa.add(RopaFactory.getRopa("XS", "pantalon", true, false));
        listaRopa.add(RopaFactory.getRopa("XS", "pantalon", false, true));
        listaRopa.add(RopaFactory.getRopa("M", "remera", true, false));
        listaRopa.add(RopaFactory.getRopa("M", "remera", false, true));
        listaRopa.add(RopaFactory.getRopa("S", "remera", true, false));
        listaRopa.add(RopaFactory.getRopa("S", "remera", false, true));
        listaRopa.add(RopaFactory.getRopa("XS", "remera", true, false));
        listaRopa.add(RopaFactory.getRopa("XS", "remera", false, false));
        listaRopa.add(RopaFactory.getRopa("M", "remera", true, false));
        listaRopa.add(RopaFactory.getRopa("XS", "pantalon", true, true));
        listaRopa.add(RopaFactory.getRopa("XS", "pantalon", true, false));
        listaRopa.add(RopaFactory.getRopa("XS", "pantalon", false, true));
        listaRopa.add(RopaFactory.getRopa("S", "remera", true, true));
        listaRopa.add(RopaFactory.getRopa("S", "remera", false, true));
        listaRopa.add(RopaFactory.getRopa("S", "remera", true, true));
        listaRopa.add(RopaFactory.getRopa("S", "remera", false, true));
        listaRopa.add(RopaFactory.getRopa("XS", "pantalon", true, false));
        listaRopa.add(RopaFactory.getRopa("XS", "pantalon", true, true));
        listaRopa.add(RopaFactory.getRopa("S", "remera", false, true));
        listaRopa.add(RopaFactory.getRopa("S", "remera", true, true));
        listaRopa.add(RopaFactory.getRopa("M", "remera", false, false));
        listaRopa.add(RopaFactory.getRopa("S", "remera", false, false));

        System.out.println("======================== ITERANDO EL HASHMAP ========================");

        for (Map.Entry<String, Ropa> entry : RopaFactory.mapRopa.entrySet()) {
            System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
        }

        System.out.println("======================= ITERANDO LISTA DE ROPA =======================");

        System.out.println("============================= PRENDAS XS =============================");
        for (Ropa prenda:listaRopa) {
            if (prenda.talle().equals("XS")) {
                System.out.println(prenda);
            }
        }

        System.out.println("============================= PRENDAS S  =============================");
        for (Ropa prenda:listaRopa) {
            if (prenda.talle().equals("S")) {
                System.out.println(prenda);
            }
        }

        System.out.println("============================= PRENDAS M  =============================");
        for (Ropa prenda:listaRopa) {
            if (prenda.talle().equals("M")) {
                System.out.println(prenda);
            }
        }

        System.out.println("========================== PRENDAS IMPORTADAS =========================");
        for (Ropa prenda:listaRopa) {
            if (prenda.esImportada()) {
                System.out.println(prenda);
            }
        }

        System.out.println("============================ PRENDAS NUEVAS ============================");
        for (Ropa prenda:listaRopa) {
            if (prenda.esNuevo()) {
                System.out.println(prenda);
            }
        }

    }

}
