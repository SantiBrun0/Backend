package chain;

import model.Documento;

public class HandlerMinistro implements Validador {

    public HandlerMinistro() {
        int nivel = 2;
    }

    private Validador next;

    @Override
    public void validarNivel(Documento doc) {
        if (doc.tipo() <= 2 ) System.out.println("acceso concedido: ministro, a documento: " + doc.contenido());
        next.validarNivel(doc);
    }

    @Override
    public void setSiguiente(Validador next) {
        this.next = next;
    }

}
