import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    // variabler der skal være tilgængelige overalt
    Scanner sc;
    List<Buket> buketter;
    List<Order> orders;

    public MainController() {
        sc = new Scanner(System.in);
        orders = new ArrayList<>();
        buketter = fillListWithBukets();
    }

    public void runProgram() {
        int mainChoice = 0;
        printMainControl();
        while(mainChoice != 9) {
            mainChoice = sc.nextInt();
            switch (mainChoice) {
                case 1: fillListWithBukets();break;
                case 2: showBukets();break;
                case 3: createOrder();break;
                default:mainChoice=9;
            }
        }



    }


    // UI services
    private void printMainControl() {
        System.out.println("1) fyld buketter i listen");
        System.out.println("2) opret ordre");
        System.out.println("3) vis alle ordrer");
        System.out.println("9) afslut ");
    }

    private void showBukets() {
        for (Buket buket:buketter) {
            System.out.println(buket.getBuketIndhold());
        }
    }

    private void  createOrder() {
        Order order = null;

        commitOrder(order);
    }


    // data services
    public void commitOrder(Order order) {
        //insert into orders (orderStatus,OrderDate,customerID) values ("CREATED",date("2020-05-02"),7);
        /*
            private int orderID;
    private String orderStatus;
    private int customerID;
    private List<Buket> orderItems;
    private LocalDate ld;
         */
        Connection con = null;
        Statement stmt = null;
        ResultSet res = null;

        String sql = "";
        String values = "";
        String buketStr = "";
        // konstruér query-streng ud fra order-objektets egenskaber
        // ('CREATED',
        sql += "INSERT INTO orders (orderStatus,OrderDate,customerID,orderItems) VALUES ";
        // buketstr bygges ved at loope igennem buketterne
        for (Buket buket:order.getOrderItems()) {
            buketStr += "@" + buket.getBuketID();
        }
        values = "("+
                "'" + order.getOrderStatus() + "'," +
                "'" + order.getLd() + "'," +
                order.getCustomerID() + "," +
                "'" + buketStr + "'" +
                ")" ;

        sql += values;
        try {
            con = getConnection();
            stmt = con.createStatement();
            //stmt.executeUpdate(sql);
            int myNewID = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            res = stmt.getGeneratedKeys();
            res.next();
            int newOrderID = res.getInt(1);
            order.setOrderID(newOrderID);
            orders.add(order);
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public List<Order> getAllOrdersDB() {
        List<Order> orders = new ArrayList<>();
        // hent fra db med kundenavn via kunde-tabel joined på kundeID

        return orders;
    }

    public List<Buket> fillListWithBukets() {
        //int buketID, String buketIndhold, int buketPris)
        // hentet data fra db og lave nye objekter, et pr række
        List<Buket> bukets = new ArrayList<>();
        Buket buket = null;
        String sql = "";
        Statement stmt = null;
        ResultSet res = null;

        sql = "SELECT * FROM bukets order by buketID";
        Connection con = getConnection();
        try {
            stmt = con.createStatement();
            res = stmt.executeQuery(sql);
            while(res.next()) {
                // hent indhold i hver række
                int buketID = res.getInt("buketID");
                String buketIndhold = res.getString("buketIndhold");
                int buketPris = res.getInt("buketPris");
                buket = new Buket(buketID,buketIndhold,buketPris);
                bukets.add(buket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bukets;
    }

    public Connection getConnection() {
        Connection con = null;
        String user = "root";
        String password = "root123";
        String urlAddOn = "?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        String url = "jdbc:mysql://localhost:3306/InterFloraIV"+urlAddOn;
        try {
            con = DriverManager.getConnection(url,user,password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
