import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class MainControllerTest {
    MainController mc;
    @Before
    public void setup() {
        mc = new MainController();
    }

    @Test
    public void runProgram() {
    }

    @Test
    public void fillListWithBukets() {
        mc.fillListWithBukets();
    }

    @Test
    public void printActions() {
    }

    @Test
    public void getMyConnection() {
        Connection con = mc.getMyConnection();
        try {
            System.out.println(con.getCatalog());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}