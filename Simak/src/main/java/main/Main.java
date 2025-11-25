package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.DBConnection;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   SIMAK - Sistem Inventaris Kampus    ║");
        System.out.println("╚════════════════════════════════════════╝\n");
        
        // Test database connection
        System.out.println("=== Testing Database Connection ===");
        if (DBConnection.testConnection()) {
            System.out.println("✓ Database is ready!");
            System.out.println("===================================\n");
        } else {
            System.err.println("✗ Database connection failed!");
            System.err.println("Please check:");
            System.err.println("1. MySQL service is running");
            System.err.println("2. Database 'inventaris_kampus' exists");
            System.err.println("3. Port is correct (currently: 8111)");
            System.err.println("===================================\n");
        }
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("SIMAK - Login");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}