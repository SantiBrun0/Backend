package com.digitalhouse.ej1.test;

import com.digitalhouse.ej2.chainofresponsability.chain.Handler;
import com.digitalhouse.ej2.chainofresponsability.chain.HandlerSpam;
import com.digitalhouse.ej2.chainofresponsability.chain.HandlerSupport;
import com.digitalhouse.ej2.chainofresponsability.model.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class HandlerSupportTest {

    @Test
    public void test1() {
        //GIVEN
        var support = new HandlerSupport(any(Handler.class));
        var email = new Email("origen", "tecnica@colmena.com", "Tecnico");
        //WHEN
        var response = support.check(email);
        //THEN
        assertEquals(response, "Envio a soporte IT.");
    }

    @Test
    public void test2() {
        //GIVEN
        var support = spy(new HandlerSupport(mock(HandlerSpam.class)));
        var email = new Email("origen", "comercial@asdasd.com", "asdasd");
        //WHEN
        support.check(email);
        //THEN
        verify(support).getNextHandler();
    }

    @Test
    public void test3() {
        //GIVEN
        var support = new HandlerSupport(null);
        var email = new Email("origen", "comercial@asdasd.com", "asdasd");
        //WHEN
        var actual = support.check(email);
        //THEN
        assertEquals(actual, "");
    }
}