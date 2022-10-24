package chain;

import model.Documento;

import javax.print.Doc;

public interface Validador {

    void validarNivel(Documento doc);

    void setSiguiente(Validador next);

}
