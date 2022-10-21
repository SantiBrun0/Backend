package com.digitalhouse.ej2.chainofresponsability.chain;

import com.digitalhouse.ej2.chainofresponsability.model.Email;
import lombok.Getter;

@Getter
public abstract class Handler {
    protected final String direccionDeCorreoAsignada;
    protected final String asuntoPorAtender;
    protected final Handler nextHandler;

    public Handler(String direccionDeCorreoAsignada, String asuntoPorAtender, Handler nextHandler) {
        this.direccionDeCorreoAsignada = direccionDeCorreoAsignada;
        this.asuntoPorAtender = asuntoPorAtender;
        this.nextHandler = nextHandler;
    }

    public abstract String check(Email email);

/*    protected String check(Email email, String msg){
        if (this.isEmailValid(email))
            return msg;
        if (this.nextHandler != null) {
            return this.nextHandler.check(email);
        }
        return "";
    };*/

    protected boolean isEmailValid(Email email) {
        return (email.destino().equalsIgnoreCase(this.direccionDeCorreoAsignada)) ||
                (email.asunto().equalsIgnoreCase(this.asuntoPorAtender));
    }
}