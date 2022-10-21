package com.digitalhouse.ej2.chainofresponsability.chain;


import com.digitalhouse.ej2.chainofresponsability.model.Email;

public class HandlerSpam extends Handler {

    //private final String MSG = "¡Ojo! Marcado como spam....";

    public HandlerSpam() {
        super(null, null, null);
    }

    @Override
    public String check(Email email) {
        return "¡Ojo! Marcado como spam....";
    }
}
