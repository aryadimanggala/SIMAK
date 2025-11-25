package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    // PENTING: Sesuaikan dengan nama database di SQL dump Anda
    private static final String DB_NAME = "inventaris_kampus";
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "8111"; // Port dari BaseDao.java Anda
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    
    private static final String URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME 
            + "?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            conn = DriverManager.getConnection(URL, DB_USER, DB_PASS);
            
            System.out.println("✓ Database connected successfully to: " + DB_NAME);
            return conn;
            
        } catch (ClassNotFoundException e) {
            System.err.println("✗ MySQL JDBC Driver not found!");
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("✗ Database connection failed!");
            System.err.println("Database: " + DB_NAME);
            System.err.println("Host: " + DB_HOST + ":" + DB_PORT);
            System.err.println("Error: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            e.printStackTrace();
            
        } catch (Exception e) {
            System.err.println("✗ Unexpected error!");
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    // Method untuk test koneksi
    public static boolean testConnection() {
        try (Connection conn = getConnection()) {
            return conn != null && !conn.isClosed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("✓ Database connection closed");
            } catch (SQLException e) {
                System.err.println("✗ Error closing connection: " + e.getMessage());
            }
        }
    }
}