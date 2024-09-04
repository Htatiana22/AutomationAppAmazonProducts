package com.amazon.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connections {
    private static HikariDataSource dataSource;


    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/logdb");
        config.setUsername("root");
        config.setPassword("9022");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        // Configuración adicional del pool (opcional)
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setConnectionTimeout(30000);
        config.setIdleTimeout(600000);
        config.setMaxLifetime(1800000);

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void logToBD(String level,Logger logge, String message, String thread){
        try(Connection connection= dataSource.getConnection()){
            String sql = "INSERT INTO logsamazon (level, logger, message, thread) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, level);
                statement.setString(2, logge.getName());
                statement.setString(3, message);
                statement.setString(4, thread);
                statement.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}


