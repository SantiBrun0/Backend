package com.digitalhouse.ej2.chainofresponsability;


import com.digitalhouse.ej2.chainofresponsability.chain.Handler;
import com.digitalhouse.ej2.chainofresponsability.model.Email;

public class Validator {
    String MENSAJE_SPAM = "¡Ojo! Marcado como spam...";
    private final Handler inicial;

    public Validator(Handler... handlers) {
        inicial = handlers[0]; //stream(handlers).findFirst().orElseThrow();
    }

    public boolean comprobar(Email email) {
        return !MENSAJE_SPAM.equalsIgnoreCase(inicial.check(email));
    }
}

