package bank.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDBConnectionFactory {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
        final String url = "jdbc:mysql://localhost:3306/your_database";
        final String user = "your_username";
        final String password = "your_password";

        Class.forName(jdbcDriver);
        return DriverManager.getConnection(url, user, password);
    }
}
