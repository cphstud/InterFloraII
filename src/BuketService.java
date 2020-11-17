import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BuketService {

    public List<Buket> getAllFlowers() {
        //(int id, String name, int price
        Connection connection = null;
        Statement statement = null;
        ResultSet res = null;
        Buket tmpBuket = null;
        String sql = "";

        List<Buket> bukets = new ArrayList<>();
        sql = "SELECT * FROM bukets order by buketid";
        try {
            connection = DBConnector.getCon();
            statement = connection.createStatement();
            res = statement.executeQuery(sql);
            while(res.next()) {
                int id = res.getInt("buketID");
                String name = res.getString("buketIndhold");
                int price = res.getInt("buketPris");
                tmpBuket = new Buket(id,name,price);
                bukets.add(tmpBuket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bukets;
    }
}
