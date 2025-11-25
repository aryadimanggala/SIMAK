package controller;

import dao.UserDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

public class LoginController {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblStatus;

    private UserDao userDao = new UserDao();

    @FXML
    private void handleLogin() {
        System.out.println("\n=== LOGIN ATTEMPT ===");
        
        String username = txtUsername.getText().trim();
        String password = txtPassword.getText();

        // Validasi input kosong
        if (username.isEmpty() || password.isEmpty()) {
            lblStatus.setText("Username dan Password harus diisi!");
            lblStatus.setStyle("-fx-text-fill: red;");
            System.out.println("✗ Empty username or password");
            return;
        }

        System.out.println("Username: " + username);
        System.out.println("Password length: " + password.length());

        // Coba login
        User user = userDao.login(username, password);

        if (user != null) {
            lblStatus.setText("Login Berhasil! Selamat datang " + user.getNama());
            lblStatus.setStyle("-fx-text-fill: green;");
            
            System.out.println("✓ Login successful!");
            System.out.println("User: " + user.getNama());
            System.out.println("Role: " + user.getRole());
            System.out.println("=====================\n");
            
            // Redirect ke Home
            redirectToHome(user);
            
        } else {
            lblStatus.setText("Username/Password salah atau akun tidak aktif!");
            lblStatus.setStyle("-fx-text-fill: red;");
            System.out.println("✗ Login failed!");
            System.out.println("=====================\n");
        }
    }

    private void redirectToHome(User user) {
        try {
            System.out.println("Loading Home page...");
            
            // Load Home.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Home.fxml"));
            Parent root = loader.load();
            
            // Get controller dan pass user data
            HomeController homeController = loader.getController();
            homeController.setUser(user);
            
            // Get current stage
            Stage stage = (Stage) txtUsername.getScene().getWindow();
            
            // Set scene home
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("SIMAK - Home");
            stage.setWidth(1200);
            stage.setHeight(700);
            
            System.out.println("✓ Home page loaded successfully");
            
        } catch (Exception e) {
            System.err.println("✗ Error loading Home page: " + e.getMessage());
            e.printStackTrace();
            lblStatus.setText("Error: Gagal membuka halaman Home!");
            lblStatus.setStyle("-fx-text-fill: red;");
        }
    }
}