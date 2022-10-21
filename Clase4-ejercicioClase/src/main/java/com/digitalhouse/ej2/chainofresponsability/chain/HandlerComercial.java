package com.digitalhouse.ej2.chainofresponsability.chain;


import com.digitalhouse.ej2.chainofresponsability.model.Email;

public class HandlerComercial extends Handler {

    //private final String MSG = "Enviado a comercial";
    public HandlerComercial(Handler siguienteOldHandler) {
        super("comercial@colmena.com", "comercial", siguienteOldHandler);
    }

    @Override
    public String check(Email email) {
        if (this.isEmailValid(email))
            return "Enviado a comercial";
        if (this.getNextHandler() != null) {
            return this.getNextHandler().check(email);
        }
        return "";
    }
}