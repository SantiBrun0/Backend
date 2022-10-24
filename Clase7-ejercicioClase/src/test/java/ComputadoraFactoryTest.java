import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputadoraFactoryTest {

    @Test
    void test1() {

        //GIVEN

        //WHEN
        var mac1 = ComputadoraFactory.getComputadora(16, 500);
        var mac2 = ComputadoraFactory.getComputadora(16,500);
        //THEN
        assertSame(mac1, mac2);

    }

}