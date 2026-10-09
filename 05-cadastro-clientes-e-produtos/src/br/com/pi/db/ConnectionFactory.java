package br.com.pi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DbConfig.getJdbcUrl(), DbConfig.USER, DbConfig.PASSWORD);
    }
}


