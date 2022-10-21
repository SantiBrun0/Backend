package com.digitalhouse.ej2.chainofresponsability.chain;


import com.digitalhouse.ej2.chainofresponsability.model.Email;

public class HandlerSupport extends Handler {

    //private final String MSG = "Envio a soporte IT.";

    public HandlerSupport(Handler siguienteOldHandler) {
        super("tecnica@colmena.com", "Técnico", siguienteOldHandler);
    }

    @Override
    public String check(Email email) {
        if (this.isEmailValid(email))
            return "Envio a soporte IT.";
        if (this.getNextHandler() != null) {
            return this.nextHandler.check(email);
        }
        return "";
    }
}