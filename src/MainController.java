import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    // datastrukturer
    List<Buket> bukets;
    List<Ordre> orders;
    // andre ting
    Scanner sc;

    MainController() {
        orders = new ArrayList<>();
        sc = new Scanner(System.in);
        bukets = new ArrayList<>();
        orders = new ArrayList<>();
    }
    public void runProgram() {
        int runChoice=0;
        while(runChoice != 9) {
            printActions();
            runChoice = sc.nextInt();
            switch (runChoice) {
                case 1: fillListWithBukets();
                case 2: createOrder();
            }
        }
    }

    

    private void createOrder() {
        Ordre ordre = null;
        commitOrder(ordre);
    }
    // UI services
    public void printActions() {
        System.out.println("1) indlæs buketter");
        System.out.println("2) opret ordre");
        System.out.println("3) vis alle ordrer");
        System.out.println("9) exit");
    }


    // DataStore Services
    public void commitOrder(Ordre order) {
        //
        // sql ting
        Connection con = null;
        Statement stmt = null;
        ResultSet res = null;

        String sql = "";
        String values = "";
        String buketsStr = "";

        con = getMyConnection();
        try {
            stmt = con.createStatement();
            sql = "INSERT INTO orders (orderStatus, orderDate, customerID, orderItems) VALUES ";
            // now convert order-objekt to order-table
            values = "(" + "'"
                    +order.getStatus() + "','"
                    + order.getDate() + "','"
                    + order.getPhone() + "'," ;

            for (Buket b:order.getBuketter() ) {
                buketsStr +=b.getId()+"@";
            }
            values += "'"+buketsStr + "')";
            sql += values;

            int myRes = stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
            ResultSet r = stmt.getGeneratedKeys();
            r.next();
            int newId = r.getInt(1);
            order.setId(newId);
            orders.add(order);
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fillListWithBukets() {
        // int id, String name, int price
        // sql ting
        Connection con = null;
        Statement stmt = null;
        ResultSet res = null;

        String sql = "";
        Buket tmpBuket = null;

        con = getMyConnection();
        try {
            stmt = con.createStatement();
            //sql = "Select 'kurt'";
            //sql = "Select now()";
            sql = "select * from bukets order by buketID";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                System.out.println(res.getString("buketIndhold"));
                int buketID = res.getInt("buketID");
                String name = res.getString("buketIndhold");
                int price = res.getInt("buketPris");
                tmpBuket = new Buket(buketID,name,price);
                bukets.add(tmpBuket);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
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