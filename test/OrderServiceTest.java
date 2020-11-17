import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void getAllOrders() {
        OrderService os = new OrderService();
        List<Ordre> ordres = os.getAllOrders();
        int expected = 3;
        int actual = ordres.size();
        assertEquals(expected,actual);
    }
}