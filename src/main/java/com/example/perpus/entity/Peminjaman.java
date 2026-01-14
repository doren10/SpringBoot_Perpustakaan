package com.example.perpus.entity;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;




@Entity
@Table(name = "peminjaman")
public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private Integer userId;


    @Column(nullable = false)
    private String bookId;


    @Column(nullable = false)
    private LocalDate tanggalPeminjaman;


    @Column(nullable = false)
    private LocalDate tanggalPengembalian;


    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private Integer denda;


    @PrePersist
    public void prePersist() {
        if (denda == null) {
            denda = 0; // Set nilai default jika denda tidak diisi
        }
        if (status == null || status.isEmpty()) {
            status = "dipinjam"; // Tetapkan nilai default
        }
    }


    // Getters and Setters
    public Integer getDenda() {
        return denda;
    }
    public void setDenda(Integer denda) {
        this.denda = denda;
    }
    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Integer getUserId() {
        return userId;
    }


    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public String getBookId() {
        return bookId;
    }


    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public LocalDate getTanggalPeminjaman() {
        return tanggalPeminjaman;
    }


    public void setTanggalPeminjaman(LocalDate tanggalPeminjaman) {
        this.tanggalPeminjaman = tanggalPeminjaman;
    }


    public LocalDate getTanggalPengembalian() {
        return tanggalPengembalian;
    }


    public void setTanggalPengembalian(LocalDate tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
    }
}