package com.digitalhouse.ej2.chainofresponsability.chain;


import com.digitalhouse.ej2.chainofresponsability.model.Email;

public class HandlerManagment extends Handler {

    public HandlerManagment(Handler siguienteOldHandler) {
        super("gerencia@colmena.com", "gerencia", siguienteOldHandler);
    }

    @Override
    public String check(Email email) {
        if (this.isEmailValid(email))
            return "Enviado a gerencia";
        if (this.nextHandler != null) {
            return this.nextHandler.check(email);
        }
        return "";
    }
}
