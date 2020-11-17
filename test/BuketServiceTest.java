import java.util.List;

import static org.junit.Assert.*;

public class BuketServiceTest {

    @org.junit.Test
    public void getAllFlowers() {
        BuketService bs = new BuketService();
        List<Buket> bukets = bs.getAllFlowers();
        int expected = 12;
        int actual = bukets.size();
        assertEquals(expected,actual);
    }
}