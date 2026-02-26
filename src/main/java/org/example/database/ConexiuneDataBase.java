package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexiuneDataBase {
    private static ConexiuneDataBase instance;
    private Connection conexiune;

    private ConexiuneDataBase() {
        try {
            conexiune = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clinica", "postgres", "postgres");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConexiuneDataBase getInstance() {
        if (instance == null) {
            instance = new ConexiuneDataBase();
        }
        return instance;
    }

    public Connection getConexiune() {
        return conexiune;
    }
}
