import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    public List<Ordre>  getAllOrders() {
        List<Ordre> ordres = new ArrayList<>();
        //int id, int phone, List<Buket> buketter, LocalDate ld)
        Connection connection = null;
        Statement statement = null;
        ResultSet res = null;
        Ordre tmpOrdre = null;
        String sql = "";

        //sql = "SELECT * FROM orders order by orderID";
        sql = "SELECT o.orderID,o.orderStatus,o.orderDate,c.customerName " +
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
                String customerName = res.getString("customerName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordres;
    }
}
