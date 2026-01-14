package com.example.perpus.entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class Pengguna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(name = "nama")
    private String nama;
    @Column(name = "telp_user")
    private String telpUser;
    @Column(name = "email")
    private String email;
    @Column(name = "role")
    private String role;
    public Pengguna() {
    }
    public Pengguna(int id_user, String username, String nama, String password, String email, String role) {
        this.id_user = id_user;
        this.username = username;
        this.nama = nama;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    // Getters and Setters
    public int getId_user() {
        return id_user;
    }
    public void setId_user(int id) {
        this.id_user = id_user;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getTelpUser() {
        return telpUser;
    }
    public void setTelpUser(String telpUser) {
        this.telpUser = telpUser;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    // Abstract methods
    public abstract boolean loginBerhasil(String username, String password);
    public abstract void loggingAktivitas();
}