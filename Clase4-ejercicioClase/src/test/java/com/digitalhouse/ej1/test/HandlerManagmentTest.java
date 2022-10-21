package com.digitalhouse.ej1.test;

import com.digitalhouse.ej2.chainofresponsability.chain.*;
import com.digitalhouse.ej2.chainofresponsability.model.Email;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class HandlerManagmentTest {

    @Test
    public void test1() {
        //GIVEN
        var support = new HandlerManagment(any(Handler.class));
        var email = new Email("origen", "gerencia@colmena.com", "Gerencial");
        //WHEN
        var response = support.check(email);
        //THEN
        assertEquals(response, "Enviado a gerencia");
    }

    @Test
    public void test2(){
        //GIVEN
        var support = spy(new HandlerComercial(new HandlerSpam()));
        var email = new Email("origen", "comercial@asdasd.com", "asdasd");
        //WHEN
        support.check(email);
        //THEN
        verify(support).getNextHandler();
    }

    @Test
    public void test3(){
        //GIVEN
        var support = new HandlerManagment(null);
        var email = new Email("origen", "comercial@asdasd.com", "asdasd");
        //WHEN
        var actual = support.check(email);
        //THEN
        assertEquals(actual, "");
    }
}