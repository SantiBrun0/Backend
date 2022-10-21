package com.digitalhouse.ej1.test;

import com.digitalhouse.ej2.chainofresponsability.chain.HandlerSpam;
import com.digitalhouse.ej2.chainofresponsability.model.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class HandlerSpamTest {

    @Test
    public void test1() {
        //GIVEN
        var support = new HandlerSpam();
        var email = new Email("origen", "comercial@colmena.com", "Comercial");
        //WHEN
        var response = support.check(email);
        //THEN
        assertEquals(response, "¡Ojo! Marcado como spam....");
    }
}