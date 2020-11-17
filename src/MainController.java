import java.util.List;

public class MainController {
    BuketService bs;
    List<Buket> bukets;
    MainController() {
        bs = new BuketService();
        bukets = bs.getAllFlowers();
    }

    public void runProgram() {


    }
}
