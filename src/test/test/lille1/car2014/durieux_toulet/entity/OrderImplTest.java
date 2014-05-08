package test.lille1.car2014.durieux_toulet.entity;

import lille1.car2014.durieux_toulet.entity.OrderImpl;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;


public class OrderImplTest {

    @Test
    public void testOrderConstructorWithoutParameters() {
        // Instanciate order
        OrderImpl order = new OrderImpl();

        // Test book collection
        assertEquals(0, order.getBooks().size());
    }

}
