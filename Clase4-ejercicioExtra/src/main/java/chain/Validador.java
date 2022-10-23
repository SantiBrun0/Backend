package chain;

import model.Documento;

import javax.print.Doc;

public interface Validador {

    String validarNivel(Documento doc);

    void setSiguiente(Documento doc);

}
