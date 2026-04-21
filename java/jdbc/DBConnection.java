package jdbc;

import java.sql.*;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/	studentdb";
        String user = "root";
        String password = "root"; // change to your MySQL password

        return DriverManager.getConnection(url, user, password);
    }
}