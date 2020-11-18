import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    public List<Buket>  getAllBuketsOnOrder(Ordre ordre) {
        List<Buket> buketter = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet res = null;
        Buket tmpBuket = null;
        String sql = "";
        try {
            sql = "SELECT bukets.buketID,buketIndhold,buketPris FROM bukets " +
                    "WHERE bukets.buketid = order_buket.buketID" +
                    "AND order_buket.orderID = " + ordre.getId();
            connection = DBConnector.getCon();
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return buketter;
    }

    public List<Ordre>  getAllOrders() {
        List<Ordre> ordres = new ArrayList<>();
        //int id, int phone, List<Buket> buketter, LocalDate ld)
        Connection connection = null;
        Statement statement = null;
        ResultSet res = null;
        Ordre tmpOrdre = null;
        String sql = "";

        //sql = "SELECT * FROM orders order by orderID";
        sql = "SELECT o.orderID,o.orderStatus,o.orderDate,c.phone " +
                "FROM orders o " +
                "JOIN customers c on o.customerID = c.customerID "+
                "order by o.orderID";
        try {
            connection = DBConnector.getCon();
            statement = connection.createStatement();
            res = statement.executeQuery(sql);
            while(res.next()) {
                int orderID = res.getInt("orderID");
                Date orderDate = res.getDate("orderDate");
                int customerPhone = res.getInt("phone");
                System.out.println("easf");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordres;
    }
}
