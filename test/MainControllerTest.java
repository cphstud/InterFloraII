import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MainControllerTest {
    MainController mc;
    @Before
    public void setup() {
        mc = new MainController();
        mc.fillListWithBukets();
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

    @Test
    public void commitOrder() {
        List<Buket> buketter = new ArrayList<>();
        Buket buket1 = new Buket(3,"Mix bundt med 7 stilke pastel hortensia",275);
        Buket buket2 = new Buket(5,"Queen blomsterbuket",275);
        buketter.add(buket1);
        buketter.add(buket2);
        int phone = 32324512;
        LocalDate ld = LocalDate.now();
        Ordre ordre = new Ordre(phone,buketter,ld);
        mc.commitOrder(ordre);
        System.out.println("done");
    }
}