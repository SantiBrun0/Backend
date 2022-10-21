package com.digitalhouse.ej1.test;

import com.digitalhouse.ej2.chainofresponsability.Validator;
import com.digitalhouse.ej2.chainofresponsability.chain.HandlerComercial;
import com.digitalhouse.ej2.chainofresponsability.chain.HandlerSupport;
import com.digitalhouse.ej2.chainofresponsability.chain.HandlerManagment;
import com.digitalhouse.ej2.chainofresponsability.chain.HandlerSpam;
import com.digitalhouse.ej2.chainofresponsability.model.Email;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.spy;


class ValidatorTest {

    @Test
    public void test1() {
        //GIVEN
        var spam = spy(new HandlerSpam());
        var tecnica = spy(new HandlerSupport(spam));
        var comercial = spy(new HandlerComercial(tecnica));
        var managment = spy(new HandlerManagment(comercial));

        var validator = new Validator(managment, comercial, tecnica, spam);

        var email = new Email("origen", "destino", "asunto");

        //WHEN
        validator.comprobar(email);
        //THEN
        var inOrder = inOrder(managment, comercial, tecnica, spam);
        inOrder.verify(managment).check(email);
        inOrder.verify(comercial).check(email);
        inOrder.verify(tecnica).check(email);
        inOrder.verify(spam).check(email);
    }
}