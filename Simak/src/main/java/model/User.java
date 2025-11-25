package model;

public class User {
    private int idUser;
    private String username;
    private String password;
    private String nama;
    private String role;
    private String status;

    // Constructor kosong
    public User() {}

    // Constructor dengan parameter
    public User(int idUser, String username, String password, String nama, String role, String status) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.role = role;
        this.status = status;
    }

    // Getters
    public int getIdUser() {
        return idUser;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNama() {
        return nama;
    }

    public String getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", username='" + username + '\'' +
                ", nama='" + nama + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}