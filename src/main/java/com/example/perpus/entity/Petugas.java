package com.example.perpus.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "petugas")
public class Petugas extends Pengguna {
    public Petugas(int nip, int id_user, String username, String nama, String password, String email, String role){
        super(id_user, username, nama, password, email, role);
        this.nip = nip;
    }
    public Petugas(){
        
    }
    @Column(name = "nip", nullable = false, unique = true)
    private Integer nip;

    public Integer getNip() {
        return nip;
    }
    public void setNip(Integer nip) {
        this.nip = nip;
    }
    // Implement abstract methods
    @Override
    public boolean loginBerhasil(String username, String password) {
        return getUsername().equals(username) && getPassword().equals(password);
    }

    @Override
    public void loggingAktivitas() {
        System.out.println("Mahasiswa " + getNama() + " telah melakukan aktivitas.");
    }
}
