import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MainControllerTest {

    @Test
    public void getConnection() {
        MainController mc = new MainController();
        Connection con = mc.getConnection();
        try {
            System.out.println(con.getCatalog());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertNotNull(con);
    }

    @Test
    public void fillListWithBukets() {
        List<Buket> bukets = new ArrayList<>();
        MainController mc = new MainController();
        bukets = mc.fillListWithBukets();
        int expected = 12;
        int actual = bukets.size();
        assertEquals(expected,actual);

    }

    @Test
    public void commitOrder() {
        List<Buket> buketter = new ArrayList<>();
        Buket buket1 = new Buket(3,"Mix bundt med 7 stilke pastel hortensia",275);
        Buket buket2 = new Buket(5,"Queen blomsterbuket",275);
        buketter.add(buket1);
        buketter.add(buket2);
        int customerID = 32324512;
        MainController mc = new MainController();
        Order order = new Order(23232323, LocalDate.now());
        order.addBuketToOrder(buket1);
        order.addBuketToOrder(buket2);
        mc.commitOrder(order);
    }

    @Test
    public void commitOrderPS() {
        List<Buket> buketter = new ArrayList<>();
        Buket buket1 = new Buket(3,"Mix bundt med 7 stilke pastel hortensia",275);
        Buket buket2 = new Buket(5,"Queen blomsterbuket",275);
        buketter.add(buket1);
        buketter.add(buket2);
        int customerID = 32324512;
        MainController mc = new MainController();
        Order order = new Order(23232323, LocalDate.now());
        order.addBuketToOrder(buket1);
        order.addBuketToOrder(buket2);
        mc.commitOrderPS(order);
    }
}