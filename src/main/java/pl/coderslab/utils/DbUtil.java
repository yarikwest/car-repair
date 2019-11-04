package pl.coderslab.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static DataSource dataSource;

    public static Connection getConn() throws SQLException {
        String url = System.getenv("CLEARDB_DATABASE_URL");
        String user = System.getenv("CLEARDB_DATABASE_USER");
        String pass = System.getenv("CLEARDB_DATABASE_PASS");
        return DriverManager.getConnection(url, user, pass);
    }
}
