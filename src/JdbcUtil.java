

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
    public static Connection getConnection() {
        Connection conn = null;
        String proptiesPath = "db.properties";
        try (InputStream is = ClassLoader.getSystemResourceAsStream(proptiesPath)) {
            Properties props = new Properties();
            props.load(is);
//            System.out.println(props);
            
            String url = props.getProperty("url");
//            String user = props.getProperty("user");
//            String password = props.getProperty("password");
//            System.out.printf("user = %s, password = %s, url = %s%n", user, password, url);
//            conn = DriverManager.getConnection(url, user, password);
            conn = DriverManager.getConnection(url, props);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("aaaaaaaaaaaaa");
        }
        return conn;
    }

}
