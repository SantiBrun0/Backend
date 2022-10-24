import model.Documento;
import chain.Handler;

public class Main {

    public static void main(String[] args) {

        Documento uno = new Documento("nivel 1", 1);
        Documento dos = new Documento("nivel 2", 2);
        Documento tres = new Documento("nivel 3", 3);

        Handler handler = new Handler();

        handler.validarNivel(uno);
        System.out.println("-------------------------------------------");
        handler.validarNivel(dos);
        System.out.println("-------------------------------------------");
        handler.validarNivel(tres);

    }

}
