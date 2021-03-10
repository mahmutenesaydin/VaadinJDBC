package com.uniyaz.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbOperations {

    static final String driverName = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/vaadinJDBC?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    static final String userName = "root";
    static final String password = "12345";
    static Connection connection = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driverName);
        connection = DriverManager.getConnection(url, userName, password);
        return connection;
    }
}
