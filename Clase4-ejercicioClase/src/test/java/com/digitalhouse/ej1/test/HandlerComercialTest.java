package com.digitalhouse.ej1.test;

import com.digitalhouse.ej2.chainofresponsability.chain.Handler;
import com.digitalhouse.ej2.chainofresponsability.chain.HandlerComercial;
import com.digitalhouse.ej2.chainofresponsability.chain.HandlerSpam;
import com.digitalhouse.ej2.chainofresponsability.model.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class HandlerComercialTest {

    @Test
    public void test1() {
        //GIVEN
        var support = new HandlerComercial(any(Handler.class));
        var email = new Email("origen", "comercial@colmena.com", "Comercial");
        //WHEN
        var response = support.check(email);
        //THEN
        assertEquals(response, "Enviado a comercial");
    }

    @Test
    public void test2() {
        //GIVEN
        var support = spy(new HandlerComercial(mock(HandlerSpam.class)));
        var email = new Email("origen", "comercial@asdasd.com", "asdasd");
        //WHEN
        support.check(email);
        //THEN
        verify(support).getNextHandler();
    }

    @Test
    public void test3() {
        //GIVEN
        var support = new HandlerComercial(null);
        var email = new Email("origen", "comercial@asdasd.com", "asdasd");
        //WHEN
        var actual = support.check(email);
        //THEN
        assertEquals(actual, "");
    }
}