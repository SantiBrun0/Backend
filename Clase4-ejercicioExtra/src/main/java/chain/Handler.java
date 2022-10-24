package chain;

import model.Documento;

public class Handler implements Validador {

    protected Validador next;

    @Override
    public void validarNivel(Documento doc) {
        HandlerDiputado d = new HandlerDiputado();
        setSiguiente(d);
        HandlerMinistro m = new HandlerMinistro();
        d.setSiguiente(m);
        HandlerPresidente p = new HandlerPresidente();
        m.setSiguiente(p);

        next.validarNivel(doc);
    }

    @Override
    public void setSiguiente(Validador next) {
        this.next = next;
    }

}
