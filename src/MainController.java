import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    // datastrukturer
    List<Buket> bukets;
    List<Buket> orders;
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
            runChoice = sc.nextInt();
            switch (runChoice) {
                case 1: fillListWithBukets();
            }
        }
    }

    public void fillListWithBukets() {
        // sql ting
        Connection con = null;
        Statement stmt = null;
        ResultSet res = null;
        String sql = "";

        con = getMyConnection();
        try {
            stmt = con.createStatement();
            //sql = "Select 'kurt'";
            //sql = "Select now()";
            sql = "select * from bukets order by buketID";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                System.out.println(res.getString("buketIndhold"));
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void printActions() {
        System.out.println("1) indlæs buketter");
        System.out.println("2) opret ordre");
        System.out.println("3) vis alle ordrer");
        System.out.println("9) exit");
    }

    public Connection getMyConnection() {
        // sql ting
        Connection connection = null;
        String urlSettings = "?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        String url = "jdbc:mysql://localhost:3306/InterFloraIV";
        String userName = "root";
        String password = "root123";

        try {
            connection = DriverManager.getConnection(
                    url+urlSettings,
                    userName,
                    password
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}