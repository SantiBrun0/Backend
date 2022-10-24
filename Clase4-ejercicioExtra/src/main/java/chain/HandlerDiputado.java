package chain;

import model.Documento;

public class HandlerDiputado implements Validador {

    public HandlerDiputado() {
        int nivel = 1;
    }

    private Validador next;

    @Override
    public void validarNivel(Documento doc) {
        if (doc.tipo() == 1) System.out.println("acceso concedido: diputado, a documento: " + doc.contenido());
        next.validarNivel(doc);
    }

    @Override
    public void setSiguiente(Validador next) {
        this.next = next;
    }

}
