package dao;

import model.User;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public User login(String username, String password) {
        // Query dari tabel 'user' di database inventaris_kampus
        String sql = "SELECT * FROM user WHERE username = ? AND status = 'aktif'";
        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            // Dapatkan koneksi database
            conn = DBConnection.getConnection();
            
            if (conn == null) {
                System.err.println("✗ Failed to get database connection!");
                return null;
            }
            
            System.out.println("Attempting login for username: " + username);
            
            // Prepare statement
            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            
            // Execute query
            rs = pst.executeQuery();

            if (rs.next()) {
                String dbPassword = rs.getString("password");
                
                System.out.println("User found in database: " + username);
                System.out.println("Checking password...");
                
                // Untuk testing: cek password plain text
                // NOTE: Password di database Anda sudah di-hash dengan BCrypt
                // Jadi untuk testing, kita perlu user dengan password plain text
                if (password.equals(dbPassword)) {
                    System.out.println("✓ Password match! Login successful");
                    
                    User user = new User(
                            rs.getInt("id_user"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("nama"),
                            rs.getString("role"),
                            rs.getString("status")
                    );
                    
                    System.out.println("User details: " + user);
                    return user;
                    
                } else {
                    System.out.println("✗ Password mismatch!");
                    System.out.println("Input password length: " + password.length());
                    System.out.println("DB password length: " + dbPassword.length());
                }
            } else {
                System.out.println("✗ User not found or account is not active: " + username);
            }

        } catch (SQLException e) {
            System.err.println("✗ SQL Error during login!");
            System.err.println("Error: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
            
        } catch (Exception e) {
            System.err.println("✗ Unexpected error during login!");
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            
        } finally {
            // Tutup semua resource
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) DBConnection.closeConnection(conn);
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }

        return null;
    }
}