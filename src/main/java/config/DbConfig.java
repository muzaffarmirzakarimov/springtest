package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
    public static final String url = "jdbc:postgresql://ec2-3-230-238-86.compute-1.amazonaws.com:5432/d76844cmihhj2d";
    public static final String userName = "tqhotswabrbmnd";
    public static final String password = "5a3cd9c66c3524a68e21bd66792a8a84f4f5e244ef86b8c9904f398092e12105";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
