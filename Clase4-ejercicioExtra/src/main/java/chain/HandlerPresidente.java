package chain;

import model.Documento;

public class HandlerPresidente implements Validador {

    public HandlerPresidente() {
        int nivel = 3;
    }

    private Validador next;

    @Override
    public void validarNivel(Documento doc) {
        if (doc.tipo() <= 3 ) System.out.println("acceso concedido: presidente, a documento: " + doc.contenido());
    }

    @Override
    public void setSiguiente(Validador next) {
        this.next = next;
    }

}
