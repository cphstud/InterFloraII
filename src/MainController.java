import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    // datastrukturer
    List<Buket> bukets;
    List<Buket> orders;
    // sql ting
    Connection con;
    Statement stmt;
    ResultSet res;
    // andre ting
    Scanner sc;

    MainController() {
        orders = new ArrayList<>();
        sc = new Scanner(System.in);
    }
    public void runProgram() {
        int runChoice=0;
        while(runChoice != 9) {
            printActions();
        }


    }

    private void printActions() {
        System.out.println("1) indlæs buketter");
        System.out.println("2) opret ordre");
        System.out.println("3) vis alle ordrer");
        System.out.println("9) exit");
    }
}