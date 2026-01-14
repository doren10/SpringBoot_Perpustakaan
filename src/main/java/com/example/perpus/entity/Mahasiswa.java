package com.example.perpus.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "mahasiswa")
public class Mahasiswa extends Pengguna {
    public Mahasiswa(int nim, int id_user, String username, String nama, String password, String email, String role) {
        super(id_user, username, nama, password, email, role);
        this.nim = nim;
    }
    public Mahasiswa(){
       
    }
    @Column(name = "nim", nullable = false, unique = true)
    private Integer nim; // Nomor Induk Mahasiswa


    public Integer getNim() {
        return nim;
    }
    public void setNim(Integer nim) {
        this.nim = nim;
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