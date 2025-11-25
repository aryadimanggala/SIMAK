package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.User;

public class HomeController {

    @FXML
    private Label lblUserRole;

    @FXML
    private Label lblSimak;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnPeminjaman;

    @FXML
    private Button btnLaporan;

    @FXML
    private Button btnDataBarang;

    private User currentUser;

    // Method untuk set user yang login
    public void setUser(User user) {
        this.currentUser = user;
        if (user != null) {
            // Capitalize role (admin -> Admin, peminjam -> Peminjam)
            String role = user.getRole().substring(0, 1).toUpperCase() + user.getRole().substring(1);
            lblUserRole.setText(role);
            
            System.out.println("Home loaded for user: " + user.getNama() + " (" + role + ")");
        }
    }

    @FXML
    private void handleLogout() {
        System.out.println("\n=== LOGOUT ===");
        System.out.println("User logged out: " + (currentUser != null ? currentUser.getNama() : "Unknown"));
        
        try {
            // Load Login.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
            Parent root = loader.load();
            
            // Get current stage
            Stage stage = (Stage) btnLogout.getScene().getWindow();
            
            // Set scene login
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("SIMAK - Login");
            
            System.out.println("✓ Redirected to Login page");
            System.out.println("==============\n");
            
        } catch (Exception e) {
            System.err.println("✗ Error loading Login page: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSimakClick(MouseEvent event) {
        System.out.println("SIMAK clicked - Already on Home page");
        // Sudah di home, tidak perlu redirect
    }

    @FXML
    private void handleDashboard() {
        System.out.println("\n=== NAVIGATE TO DASHBOARD ===");
        System.out.println("User: " + (currentUser != null ? currentUser.getNama() : "Unknown"));
        System.out.println("Fitur Dashboard akan ditampilkan");
        System.out.println("=============================\n");
        
        // TODO: Load Dashboard.fxml
        // navigateToScene("/view/Dashboard.fxml", "SIMAK - Dashboard");
    }

    @FXML
    private void handlePeminjaman() {
        System.out.println("\n=== NAVIGATE TO PEMINJAMAN ===");
        System.out.println("User: " + (currentUser != null ? currentUser.getNama() : "Unknown"));
        System.out.println("Fitur Peminjaman akan ditampilkan");
        System.out.println("==============================\n");
        
        // TODO: Load Peminjaman.fxml
        // navigateToScene("/view/Peminjaman.fxml", "SIMAK - Peminjaman");
    }

    @FXML
    private void handleLaporan() {
        System.out.println("\n=== NAVIGATE TO LAPORAN ===");
        System.out.println("User: " + (currentUser != null ? currentUser.getNama() : "Unknown"));
        System.out.println("Fitur Laporan akan ditampilkan");
        System.out.println("===========================\n");
        
        // TODO: Load Laporan.fxml
        // navigateToScene("/view/Laporan.fxml", "SIMAK - Laporan");
    }

    @FXML
    private void handleDataBarang() {
        System.out.println("\n=== NAVIGATE TO DATA BARANG ===");
        System.out.println("User: " + (currentUser != null ? currentUser.getNama() : "Unknown"));
        System.out.println("Fitur Data Barang akan ditampilkan");
        System.out.println("===============================\n");
        
        // TODO: Load DataBarang.fxml
        // navigateToScene("/view/DataBarang.fxml", "SIMAK - Data Barang");
    }

    @FXML
    private void handleBarang1(MouseEvent event) {
        System.out.println("\n=== BARANG CLICKED ===");
        System.out.println("Barang: Handy Talky");
        System.out.println("Detail barang akan ditampilkan");
        System.out.println("======================\n");
        
        // TODO: Load DetailBarang.fxml dengan ID barang
    }

    @FXML
    private void handleBarang2(MouseEvent event) {
        System.out.println("\n=== BARANG CLICKED ===");
        System.out.println("Barang: Proyektor");
        System.out.println("Detail barang akan ditampilkan");
        System.out.println("======================\n");
        
        // TODO: Load DetailBarang.fxml dengan ID barang
    }

    @FXML
    private void handleBarang3(MouseEvent event) {
        System.out.println("\n=== BARANG CLICKED ===");
        System.out.println("Barang: Terminal Listrik 10m");
        System.out.println("Detail barang akan ditampilkan");
        System.out.println("======================\n");
        
        // TODO: Load DetailBarang.fxml dengan ID barang
    }

    @FXML
    private void handleBarang4(MouseEvent event) {
        System.out.println("\n=== BARANG CLICKED ===");
        System.out.println("Barang: Tenda");
        System.out.println("Detail barang akan ditampilkan");
        System.out.println("======================\n");
        
        // TODO: Load DetailBarang.fxml dengan ID barang
    }

    // Helper method untuk navigasi (untuk nanti)
    private void navigateToScene(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            
            // Pass current user ke controller berikutnya jika perlu
            // Object controller = loader.getController();
            // if (controller instanceof SomeController) {
            //     ((SomeController) controller).setUser(currentUser);
            // }
            
            Stage stage = (Stage) btnDashboard.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            
            System.out.println("✓ Scene loaded: " + fxmlPath);
            
        } catch (Exception e) {
            System.err.println("✗ Error loading scene: " + e.getMessage());
            e.printStackTrace();
        }
    }
}