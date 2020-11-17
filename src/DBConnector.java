import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


    public class DBConnector {
        private static Connection con = null;
        private static String uName = "root";
        private static String pWord = "root123";
        private static String db = "InterFloraII";
        private static String Url = "jdbc:mysql://localhost:3306/InterFloraIV?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        //"jdbc:myDriver:myDatabase",

        private DBConnector() {
        }

        public static Connection getCon() throws SQLException {
            if (con == null) {
                con = DriverManager.getConnection(
                        Url,
                        uName,
                        pWord);

            }
            return con;
        }

    }
